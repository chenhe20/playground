import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 */

//

public class main {


    public static void main(String[] args) {

        String now = new SimpleDateFormat("HHmmss").format(new Date());
        System.out.println(Integer.valueOf(now.substring(0,2)));
        if (Integer.valueOf(now.substring(0,2)) > 12) {

            System.out.println("night");
        } else {
            System.out.println("morning");
        }

        //seleniumDemo();

//        Process proc;
//        try {
//            proc = Runtime.getRuntime().exec("python /Users/hechen/myProjects/IdeaProjects/playgroundkcl/src/main/exercise/test.py");
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            proc.waitFor();
//        } catch (Exception e) {
//
//        }

//        TreeNode test = new TreeNode(0);
//        test.left = new TreeNode(-1);
//        BSTValidator bstValidator = new BSTValidator();
//        System.out.println(bstValidator.isValidBST(test));

//    String toTrim = "[[., ., 9, 7, 4, 8, ., ., .], [7, ., ., 6, ., 2, ., ., .], [., 2, ., 1, ., 9, ., ., .], [., ., 7, 9, 8, 6, 2, 4, 1], [2, 6, 4, 3, 1, 7, 5, 9, 8], [1, 9, 8, 5, 2, 4, 3, 6, 7], [., ., ., 8, 6, 3, ., 2, .], [., ., ., 4, 9, 1, ., ., 6], [., ., ., 2, 7, 5, 9, ., .]]";
//    //String toTrim = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n";
//
//
//
//        //System.out.println(toTrim.replace('[','{').replace(']','}').replace('"','\''));
//
//        char[][] boardInput = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','6','.','2','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','9','8','6','2','4','1'},{'2','6','4','3','1','7','5','9','8'},{'1','9','8','5','6','4','3','6','7'},{'.','.','.','8','6','3','.','2','.'},{'.','.','.','4','9','1','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
//        System.out.println(Arrays.deepToString(boardInput));
//        SudokuSolver sudokuSolver = new SudokuSolver();
//        sudokuSolver.solveSudoku(boardInput);
//        System.out.println(Arrays.deepToString(boardInput));
    }

    public static void seleniumDemo() {
        // init web driver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(" https://python.org/");
        System.out.println(chromeDriver.getTitle());
        //chromeDriver.findElement(By.xpath("//div[text()='I agree']")).click();
        // get search input area
        WebElement searchEle = chromeDriver.findElement
                (By.xpath("//*[@id=\"id-search-field\"]"));
        searchEle.sendKeys("unitest");
        searchEle.sendKeys(Keys.RETURN);

        //wait
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, 600);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/section/form/h3")));
        System.out.println("result returned");

        WebElement result_stats = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/section/form/ul"));
        // WebElement newResult = chromeDriver.findElement(By.cssSelector(".list-recent-events.menu"));
        //System.out.println(newResult.getText());
        System.out.println(" ");
        System.out.print(result_stats.getText());

    }


    public static double cal(double r, double c) {

        int term = 20;
        double latter = 100/Math.pow(1+r, term);
        System.out.println("latter is "+ latter);
        double former = 0;
        for (int i = 1; i <= term; i++) {
            former += c/Math.pow(1+r, i);
            System.out.println("former is "+former);
        }
        return former + latter;

    }

}


