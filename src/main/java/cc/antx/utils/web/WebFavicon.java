package cc.antx.utils.web;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * @author zhong
 * @date 2023-03-25 7:25
 */
public class WebFavicon {


    public static void main(String[] args) {
        String faviconUrl = getFaviconUrl("https://fanyi.baidu.com");
        System.out.println("faviconUrl = " + faviconUrl);
    }

    public static String getFaviconUrl(String str) {
        try {
            String url = StrUtil.trimToEmpty(str);
            // 假设输入的参数不携带协议，则拼接协议
            if (!isHttpOrHttps(str)) {
                url = StrUtil.format("https://{}", str);
            }
            URL urlObj = new URL(url);
            // 处理出新的url
            String newUrl = urlObj.getProtocol().concat("://").concat(urlObj.getHost());
            // 发请求
            Document document = Jsoup.connect(newUrl).get();
            // 筛选包含favicon图标的link标签
            Elements title = document.select("link[type=image/x-icon]");
            title = ObjectUtil.isEmpty(title) ? document.select("link[rel$=icon]") : title;
            // 获取favicon路径
            String href = title.attr("href");
            // 假设获取到的favicon路径已经包含了域名，则直接返回
            if (isHttpOrHttps(href) && StrUtil.containsAny(href, "favicon")) {
                return href;
            }
            // 拼接favicon的访问链接
            return StrUtil.format("{}/{}", newUrl, StrUtil.removePrefix(href, "/"));
        } catch (IOException i) {
            i.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            return "链接无法识别";
        }
        return "";
    }

    /**
     * 检测是否http或https
     *
     * @param url URL
     * @return 检验是否是http或https
     */
    public static boolean isHttpOrHttps(String url) {
        String lowerCaseStr = url.toLowerCase();
        return lowerCaseStr.startsWith("http:") || lowerCaseStr.startsWith("https:");
    }
}
