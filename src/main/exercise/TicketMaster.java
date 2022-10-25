import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class TicketMaster {

    static String URL = "https://www.eticketing.co.uk/arsenal/EDP/Event/Index/3030?position=1";
    static String loginUrl = "https://web-identity.tmtickets.co.uk/uk_arsenal/Account/Login?ReturnUrl=%2Fuk_arsenal%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Duk_arsenal_pro%26response_type%3Dcode%26scope%3Dopenid%2520profile%2520offline_access%26redirect_uri%3Dhttps%253A%252F%252Fwww.eticketing.co.uk%252Farsenal%252FAuthentication%252FCallback%252FOpenIdSignInCallback%252F%26state%3Dc4oKAI1R1yRM8C5jqNNWlL3t13gBc2G2Yi6YiUFtxheNPQEcJtgmxBPAWQuqzS%25252BBkaWkssL5GmgYh%25252F4zb3xRzhx%25252FB%25252Fa5OiRXHwdkfiNzgswlKbuO4VnPc1a5pp3AIuKCgDafhFTeOz2%25252BnFBmi47pytgbXU8%25253D%26nonce%3DFP5APSd_0QjVeXcE6JEnuA%26acr_values%3Dtenant%253Auk_arsenal%26response_mode%3Dform_post%26code_challenge%3DkBi3agADYHfkgZnLuv_XF4zDwsIMW8gH6UF5nvQeNW4%26code_challenge_method%3DS256";
    static String loginFormSubmitUrl = "https://web-identity.tmtickets.co.uk/uk_arsenal/Account/Login?ReturnUrl=/uk_arsenal/connect/authorize/callback?client_id=uk_arsenal_pro&response_type=code&scope=openid%20profile%20offline_access&redirect_uri=https%3A%2F%2Fwww.eticketing.co.uk%2Farsenal%2FAuthentication%2FCallback%2FOpenIdSignInCallback%2F&state=c4oKAI1R1yRM8C5jqNNWlL3t13gBc2G2Yi6YiUFtxheNPQEcJtgmxBPAWQuqzS%252BBkaWkssL5GmgYh%252F4zb3xRzhx%252FB%252Fa5OiRXHwdkfiNzgswlKbuO4VnPc1a5pp3AIuKCgDafhFTeOz2%252BnFBmi47pytgbXU8%253D&nonce=FP5APSd_0QjVeXcE6JEnuA&acr_values=tenant%3Auk_arsenal&response_mode=form_post&code_challenge=kBi3agADYHfkgZnLuv_XF4zDwsIMW8gH6UF5nvQeNW4&code_challenge_method=S256";
    static String sessionId = "cxzt0oyesmv1x0i0vgc30dz1";

    static void request() throws IOException {

        Document oriDoc = Jsoup.connect(loginUrl)
                .get();
        System.out.println(oriDoc);
        
        
        Connection.Response res = Jsoup.connect(loginFormSubmitUrl)
//                .cookie(".ASPXAUTH", sessionId)
                .method(Connection.Method.POST)
                .data("Password","Chrischenhe")
                .data("Username", "4480302")
                .data("__RequestVerificationToken", "CfDJ8GoPstqV2UhDpnCcbpzWUUphPho0ep5WuxNGZBXYfzyM7sPL8uNiq5GqB7N_rCNdfZS0jlKDvFgUDVMh1iRixUw1PYK_kn5vZjy8g_QvySo3A2xxWvzFaTumIlIg9DZl_hGTA841xqNhwBM-UaqiJWw")
                .data("button", "login")
                .data("ReturnUrl", "/uk_arsenal/connect/authorize/callback?client_id=uk_arsenal_pro&response_type=code&scope=openid%20profile%20offline_access&redirect_uri=https%3A%2F%2Fwww.eticketing.co.uk%2Farsenal%2FAuthentication%2FCallback%2FOpenIdSignInCallback%2F&state=c4oKAI1R1yRM8C5jqNNWlL3t13gBc2G2Yi6YiUFtxheNPQEcJtgmxBPAWQuqzS%252BBkaWkssL5GmgYh%252F4zb3xRzhx%252FB%252Fa5OiRXHwdkfiNzgswlKbuO4VnPc1a5pp3AIuKCgDafhFTeOz2%252BnFBmi47pytgbXU8%253D&nonce=FP5APSd_0QjVeXcE6JEnuA&acr_values=tenant%3Auk_arsenal&response_mode=form_post&code_challenge=kBi3agADYHfkgZnLuv_XF4zDwsIMW8gH6UF5nvQeNW4&code_challenge_method=S256")
                .execute();

        Document doc = res.parse();
        System.out.println(doc);


    }



    public static void main(String[] args) {


        try {
            request();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
