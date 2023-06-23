package cc.antx.utils.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取网页的信息
 *
 * @author zhong
 * @date 2023-02-01 16:42
 */
public class WebUtils {
    public static void main(String[] args) {
        System.out.println(getUrlHTML("https://fanyi.baidu.com/#zh/en/你好"));

    }


    public String url;
    public String title;
    public String urlString;

    public WebUtils(String url) throws Exception {
        this.url = url;
        this.title = getUrlTitle(url);
        this.urlString = getUrlHTML(url);
    }

    /**
     * 获取网页的源代码, 默认为utf-8编码
     *
     * @param url 网址
     * @return 网页源代码
     */
    public static String getUrlHTML(String url) {
        return getUrlHTML(url, "utf-8");
    }


    /**
     * 获取网页的源代码, 并指定编码
     *
     * @param url    网址
     * @param coding 编码
     * @return 网页源代码
     */
    public static String getUrlHTML(String url, String coding) {
        try {
            StringBuilder string = new StringBuilder();
            URL Url = new URL(url);
            HttpURLConnection huc = (HttpURLConnection) Url.openConnection();
            huc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream is = huc.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(is, coding));
            String line;
            while ((line = r.readLine()) != null) {
                string.append(line);
            }
            r.close();
            is.close();
            return String.valueOf(string);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 获取网页的标题
     *
     * @param url 网站
     * @return 网页标题
     */
    public static String getUrlTitle(String url) {
        try {
            String urlString = getUrlHTML(url);
            String pattern = "<title>(.*)</title>";
            Pattern patt = Pattern.compile(pattern);
            assert urlString != null;
            Matcher match = patt.matcher(urlString);
            if (match.find()) {
                return match.group(1);
            } else {
                return "Not Found";
            }
        } catch (Exception e) {
            return "";
        }
    }

}