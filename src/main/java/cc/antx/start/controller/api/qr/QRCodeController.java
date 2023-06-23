package cc.antx.start.controller.api.qr;

import cc.antx.utils.qrcode.QRCodeUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author zhong
 * @date 2023-03-05 20:10
 */
@RestController
public class QRCodeController {

    @GetMapping(value = "/qr", produces = MediaType.IMAGE_PNG_VALUE)
    public Object getImage(String text) throws Exception {
        String path = "C:/www/wwwres/java/start/src/main/resources/static/img/qrcode/";
        String name = QRCodeUtils.generateQRCode(text, path);
        return ImageIO.read(new FileInputStream(name));
    }

}