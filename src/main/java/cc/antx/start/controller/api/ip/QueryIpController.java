package cc.antx.start.controller.api.ip;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhong
 * @date 2023-03-05 9:38
 */
@RestController
public class QueryIpController {
    @RequestMapping("/api/ip")
    public Map<String, Object> test(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            String ip = request.getHeader("x-forwarded-for");
            if (!checkIP(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (!checkIP(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (!checkIP(ip)) {
                ip = request.getRemoteAddr();
            }

            result.put("success", true);
            result.put("addr", ip);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Server Error");
        }
        return result;
    }

    public static boolean checkIP(String ip) {
        if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)
                || ip.split("").length != 4) {
            return false;
        }
        return true;
    }
}
