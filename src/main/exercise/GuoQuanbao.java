/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * singleton
 */
public class GuoQuanbao {

    // avoid instruction being rescheduled
    volatile private static GuoQuanbao instance = null;

    private GuoQuanbao() {}

    public static GuoQuanbao getInstance() {
        try {
            if (instance != null) {

            } else {
                // double check
                synchronized (GuoQuanbao.class) {
                    if (instance == null) {
                        System.out.println("Thread no." + Thread.currentThread().getId() + " finds 郭全宝 does not exist");
                        //Thread.sleep(5000);
                        instance = new GuoQuanbao();
                        System.out.println("Thread no." + Thread.currentThread().getId() + " created a new 郭全宝");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return instance;
    }
}
