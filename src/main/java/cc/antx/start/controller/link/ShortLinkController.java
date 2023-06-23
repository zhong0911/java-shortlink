//package com.adisaint.start.controller.link;
//
//import com.adisaint.start.server.data.link.add.ShortLinkAddition;
//import com.adisaint.start.server.data.link.query.ShortLinkQuery;
//import com.adisaint.utils.time.TimeUtils;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author zhong
// * @date 2023-03-04 10:58
// */
//@RestController
//public class ShortLinkController {
//    @RequestMapping("/url/{shortLink}")
//    public void sendRedirect(HttpServletResponse response, @PathVariable String shortLink) {
//        String longLink = ShortLinkQuery.getLongLink(shortLink);
//        if (longLink != null) {
//            try {
//                if (Boolean.TRUE.equals(ShortLinkQuery.getStatus(shortLink)) && ShortLinkQuery.getShortLinkValid(shortLink))
//                    response.sendRedirect(longLink);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    @RequestMapping("/url/generate")
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
//                    info.put("short_link", "https://adsturl.com/"+shortLink);
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
//
//}
