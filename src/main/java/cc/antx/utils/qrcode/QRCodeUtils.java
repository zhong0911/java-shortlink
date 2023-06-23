package cc.antx.utils.qrcode;

import cn.hutool.core.codec.Base64;
import cc.antx.utils.string.StringUtils;
import cc.antx.utils.time.TimeUtils;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于google zxing的二维码识别和生成
 *
 * @author zhong
 * @date 2023-02-03 13:53
 */
public class QRCodeUtils {
    public static void main(String[] args) {
        generateQRCode("https://www.adisaint.com/", "./");
    }

    /**
     * 解析二维码
     * 返回解析内容
     *
     * @param path 图片路径
     * @return 解析的二维码内容
     */
    public static String parseQRCode(String path) {
        String content = null;
        BufferedImage image;
        try {
            image = ImageIO.read(new File(path));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<>(1);
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            content = result.getText();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            try {
                image = ImageIO.read(new File(path));
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                Binarizer binarizer = new HybridBinarizer(source);
                BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
                Map<DecodeHintType, Object> hints = new HashMap<>(3);
                hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
                hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
                hints.put(DecodeHintType.PURE_BARCODE, Boolean.TYPE);
                Result result = new MultiFormatReader().decode(binaryBitmap, hints);
                content = result.getText();
            } catch (IOException | NotFoundException e1) {
                e1.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 生成二维码
     *
     * @param content      扫码内容
     * @param QRCodeWidth  二维码宽度
     * @param QRCodeHeight 二维码高度
     * @param logoWidth    logo宽度
     * @param logoHeight   logo高度
     * @param logoPath     logo相对路径("null"时不加logo）
     * @param QRCodeColor  二维码颜色
     * @param QRCodeName   二维码保存名称
     * @param savePath     保存路径
     * @return 生成成功返回二维码路径, 生成失败返回null
     */
    public static String generateQRCode(String content, int QRCodeWidth, int QRCodeHeight, int logoWidth, int logoHeight, String logoPath, int QRCodeColor, String QRCodeName, String savePath) {
        String savedPath = null;
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.MARGIN, 1);
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCodeWidth, QRCodeHeight, hints);
            int matrix_width = matrix.getWidth();
            int matrix_height = matrix.getHeight();
            BufferedImage image = new BufferedImage(matrix_width, matrix_height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < matrix_width; x++) {
                for (int y = 0; y < matrix_height; y++) {
                    int rgb = matrix.get(x, y) ? QRCodeColor : 0xFFFFFF;
                    image.setRGB(x, y, rgb);
                }
            }
            if (!logoPath.equals("null")) {
                BufferedImage logo = ImageIO.read(new File(logoPath));
                Graphics2D g = (Graphics2D) image.getGraphics();
                g.drawImage(logo, (matrix_width - logoWidth) / 2, (matrix_height - logoHeight) / 2, logoWidth, logoHeight, null);
                g.setColor(Color.WHITE);
                g.setStroke(new BasicStroke(5.0f));
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.drawRoundRect((matrix_width - logoWidth) / 2, (matrix_height - logoHeight) / 2, logoWidth, logoHeight, 10, 10);
            }
            String qrcodeName = QRCodeName + ".png";
            ImageIO.write(image, "png", new File(savePath + qrcodeName));
            savedPath = savePath + qrcodeName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedPath;
    }

    /**
     * 生成二维码
     *
     * @param content    扫码内容
     * @param QRCodeName 二维码保存名称
     * @param savePath   保存路径
     * @return 生成成功返回二维码路径, 生成失败返回null
     */
    public static String generateQRCode(String content, String QRCodeName, String savePath) {
        return generateQRCode(content, 0, 0, 0, 0, "null", 0, QRCodeName, savePath);
    }

    /**
     * 生成二维码
     *
     * @param content    扫码内容
     * @param logoPath   logo相对路径("null"时不加logo）
     * @param QRCodeName 二维码保存名称
     * @param savePath   保存路径
     * @return 生成成功返回二维码路径, 生成失败返回null
     */
    public static String generateQRCode(String content, String logoPath, String QRCodeName, String savePath) {
        return generateQRCode(content, 0, 0, 0, 0, "null", 0, QRCodeName, savePath);
    }

    /**
     * 生成二维码
     *
     * @param content  扫码内容
     * @param savePath 保存路径
     * @return 生成成功返回二维码路径, 生成失败返回null
     */
    public static String generateQRCode(String content, String savePath) {
        return generateQRCode(content, 0, 0, 0, 0, "null", 0, "qrcode-" + StringUtils.getRandomString(12), savePath);
    }

    /**
     * 生成二维码, 保存路径为当前路径
     *
     * @param content 扫码内容
     * @return 生成成功返回二维码路径, 生成失败返回null
     */
    public static String generateQRCode(String content) {
        return generateQRCode(content, 0, 0, 0, 0, "null", 0, "qrcode-"+StringUtils.getRandomString(12), "./");
    }

    /**
     * 生成加密后的二维码字符串 Base64字符串二维码
     *
     * @param content 二维码正文
     * @param width   二维码宽
     * @param height  二维码高
     * @return base64 编码后的字符串
     * @throws IOException 抛出IOException异常
     */
    public static String getQRCodeBase64String(String content, int width, int height) throws IOException {
        String resultImage = "";
        if (!org.springframework.util.StringUtils.isEmpty(content)) {
            ServletOutputStream stream = null;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            @SuppressWarnings("rawtypes")
            HashMap<EncodeHintType, Comparable> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 指定字符编码为“utf-8”
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); // 指定二维码的纠错等级为中级
            hints.put(EncodeHintType.MARGIN, 2); // 设置图片的边距
            try {
                QRCodeWriter writer = new QRCodeWriter();
                BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

                BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
                ImageIO.write(bufferedImage, "png", os);
                /**
                 * 原生转码前面没有 data:image/png;base64 这些字段，返回给前端是无法被解析，可以让前端加，也可以在下面加上
                 */
                resultImage = "data:image/jpeg;base64," + Base64.encode(os.toByteArray());

                return resultImage;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

