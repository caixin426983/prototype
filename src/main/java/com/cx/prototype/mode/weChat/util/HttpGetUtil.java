package com.cx.prototype.mode.weChat.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpGetUtil {

    public static String httpRequestToString(String url,
                                             Map<String, String> params) {
        String result = null;
        try {
            InputStream is = httpRequestToStream(url, params);
            BufferedReader in = new BufferedReader(new InputStreamReader(is,
                    "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            result = buffer.toString();
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    private static InputStream httpRequestToStream(String url,
                                                   Map<String, String> params) {
        InputStream is = null;
        try {
            String parameters = "";
            boolean hasParams = false;
            for (String key : params.keySet()) {
                String value = URLEncoder.encode(params.get(key), "UTF-8");
                parameters += key + "=" + value + "&";
                hasParams = true;
            }
            if (hasParams) {
                parameters = parameters.substring(0, parameters.length() - 1);
            }
            url += "?" + parameters;

            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setConnectTimeout(50000);
            conn.setReadTimeout(50000);
            conn.setDoInput(true);
            //设置请求方式，默认为GET
            conn.setRequestMethod("GET");
            is = conn.getInputStream();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }


    /**
     * get请求
     *
     * @return
     */
//    public static String doGet(String url) {
//        try {
//            HttpClient client = new DefaultHttpClient();
//            //发送get请求
//            HttpGet request = new HttpGet(url);
//            HttpResponse response = client.execute(request);
//
//            /**请求发送成功，并得到响应**/
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                /**读取服务器返回过来的json字符串数据**/
//                String strResult = EntityUtils.toString(response.getEntity());
//                return strResult;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
