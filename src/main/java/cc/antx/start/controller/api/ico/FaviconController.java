package cc.antx.start.controller.api.ico;

import cc.antx.utils.web.WebFavicon;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * @author zhong
 * @date 2023-03-25 7:28
 */
@RestController
public class FaviconController {
    @RequestMapping("/ico-url")
    public Map<String, Object> getFaviconUrl(String url) {
        Map<String, Object> result = new HashMap<>();
        try {
            String icoUrl = WebFavicon.getFaviconUrl(url);
            if (icoUrl == null || Objects.equals(icoUrl, "")) {
                result.put("success", false);
                result.put("message", "Please check the url and requests api again");
            } else {
                result.put("success", true);
                result.put("url", icoUrl);
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Server Error");
        }
        return result;
    }

    @RequestMapping("/ico")
    public void getFavicon(String url, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        String path = WebFavicon.getFaviconUrl(url);;
        URL uri = new URL(path);
        BufferedImage img = ImageIO.read(uri);
        ImageIO.write(img, "png", response.getOutputStream());
    }

    public static void main(String[] args) {
        System.out.println(WebFavicon.getFaviconUrl("fanyi.baidu.com"));
    }
}
