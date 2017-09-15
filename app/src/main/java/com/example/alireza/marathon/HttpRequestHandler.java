/**
 * Created by navid on 9/15/17.
 */

import jdk.nashorn.internal.runtime.Debug;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class HttpRequestHandler {
    private final String USER_AGENT = "Mozilla/5.0";
    private String destUrl;
    private static HttpRequestHandler instance = null;

    public static void main(String args[]) throws Exception {
        HttpRequestHandler h = new HttpRequestHandler("http://localhost:3000/");
        JSONObject res = h.sendReq("username=Ali&password=1234&birthday=''", RequestMethods.POST,"user/");
        System.out.println(res.get("statusCode").toString());
    }

    private HttpRequestHandler(String url) {
        this.destUrl = url;
    }

    public static HttpRequestHandler createCustomeHttpReqHandler(String url){
        if (instance == null) {
           instance = new HttpRequestHandler(url);
        }
        return instance;
    }


    public JSONObject sendReq(String data, RequestMethods reqMethod, String route) throws Exception {
        return sendReq(data, reqMethod, this.destUrl, route);
    }

    public JSONObject sendReq(String data, RequestMethods reqMethod, String destUrl, String route) throws Exception {

        byte[] postData = data.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL obj = new URL(destUrl.concat(route));

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        //set request method
        con.setRequestMethod(reqMethod.toString());

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setDoOutput(true);
        con.setUseCaches(false);
        con.getOutputStream().write(postData);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

        String line = "";
        String res = "";

        while ((line = in.readLine()) != null) {
            res = line.concat(res);
        }

        return new JSONObject(res);
    }


    public void setDestUrl(String newUrl) {
        this.destUrl = newUrl;
    }

}
