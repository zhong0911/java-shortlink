package cc.antx.start.controller.host;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static cc.antx.start.controller.api.ip.QueryIpController.checkIP;

/**
 * @author zhong
 * @date 2023-03-26 0:01
 */
@RestController
public class HostController {
    @RequestMapping("/query/host")
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
            result.put("user", request.getRemoteUser());
            result.put("uri", request.getRequestURI());
            result.put("url", request.getRequestURL());
            result.put("remote", request.getRemoteAddr());
            result.put("local", request.getLocalAddr());
            result.put("method", request.getMethod());
            result.put("server", request.getServerName());
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Server Error");
        }
        return result;
    }


}
