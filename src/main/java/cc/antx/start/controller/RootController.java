package cc.antx.start.controller;

import cc.antx.start.server.data.link.add.ShortLinkAddition;
import cc.antx.start.server.data.link.query.ShortLinkQuery;
import cc.antx.utils.time.TimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhong
 * @date 2023-03-25 23:36
 */
@Controller
public class RootController {

    @RequestMapping("/")
    public void intoPrimaryWebsite(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.antx.cc");
    }


    @RequestMapping("/{uri}")
    public void sendRedirect(HttpServletResponse response, @PathVariable String uri) {
        String longLink = ShortLinkQuery.getLongLink(uri);
        if (longLink != null) {
            try {
                if (Boolean.TRUE.equals(ShortLinkQuery.getStatus(uri)) && ShortLinkQuery.getShortLinkValid(uri))
                    response.sendRedirect(longLink);
                else response.sendRedirect("https://url.antx.cc/help/404.html");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


//    @RequestMapping("/link/gen")
//    public Map<String, Object> generateShortLink(String link) {
//        Map<String, Object> res = new HashMap<>();
//        if (link == null || link.equals("")) {
//            res.put("success", false);
//            res.put("message", "Link is null");
//        } else {
//            if (link.startsWith("https://") || link.startsWith("http://")) {
//                String shortLink = ShortLinkQuery.getNewShortLink();
//                String generationTime = TimeUtils.getNowFormatTime();
//                String expirationTime = "2099-12-31 23:59:59"; //  TimeUtils.dateFormat(new Date(new Date().getTime() + (1000L * 60 * 60 * 24 * 30 * 12 * 99))))
//                if (ShortLinkAddition.addShortLink(shortLink, link, true, generationTime, expirationTime)) {
//                    res.put("success", true);
//                    Map<String, Object> info = new HashMap<>();
//                    info.put("short_link", "https://m.antx.cc/" + shortLink);
//                    info.put("long_link", link);
//                    info.put("status", true);
//                    info.put("generation_time", generationTime);
//                    info.put("expiration_time", expirationTime);
//                    res.put("info", info);
//                } else {
//                    res.put("success", false);
//                    res.put("message", "Generation short link failed");
//                }
//            } else {
//                res.put("success", false);
//                res.put("message", "Link must have protocol");
//            }
//        }
//        return res;
//    }
}

