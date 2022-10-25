import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class CrawlerDemo {



    public static void main(String[] args) {
        final String URL = "https://www.bankofchina.com/sourcedb/whpj/enindex_1619.html";

        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
            //System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //StringBuffer path =  new StringBuffer("/html/body/table[2]/tbody/tr/td[2]/table[2]/tbody/tr/td/table/tbody/tr[11]/td[0]");
        String selector = "body > table:nth-child(2) > tbody > tr > td:nth-child(2) > table:nth-child(5) > tbody > tr > td > table > tbody > tr:nth-child(9) ";
        StringBuffer sel = new StringBuffer(selector);
//        for (int i = 1; i <= 7; i++) {
//            sel.replace(sel.length()-2, sel.length()-1, String.valueOf(i));
//            //System.out.println(sel);
//            //Elements elements = document.selectXpath(path.toString());
//            Elements elements = document.select(sel.toString());
//            System.out.println(elements.html());
//        }
        String child = "> td:nth-child(0)";
        Elements gbpElements = document.select(sel.toString());
        //System.out.println(el.html());

        String currencyName = gbpElements.select("> td:nth-child(1)").html();
        Double buyingRate = Double.valueOf(gbpElements.select("> td:nth-child(2)").html());
        Double cashBuyingRate = Double.valueOf(gbpElements.select("> td:nth-child(3)").html());
        Double sellingRate = Double.valueOf(gbpElements.select("> td:nth-child(4)").html());
        Double cashSellingRate = Double.valueOf(gbpElements.select("> td:nth-child(5)").html());
        String cnPubTime = gbpElements.select("> td:nth-child(7)").html();

        System.out.println(cnPubTime);


    }
}
