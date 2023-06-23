package cc.antx.utils.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 关于文件操作的类
 *
 * @author zhong
 * @date 2023-02-02 21:33
 */
public class FileUtils {

    /**
     * 复制文件
     * 复制成就返回true
     * 否则就返回false
     *
     * @param filePath 源文件路径
     * @param newPath  目标文件路径
     * @return 是否复制成功
     * @throws IOException 抛出IOException异常
     */
    public static Boolean copyFile(String filePath, String newPath) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(filePath);
            os = new FileOutputStream(newPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
            return true;
        } catch (Exception e) {
            assert is != null;
            is.close();
            assert os != null;
            os.close();
            return false;
        }
    }

    /**
     * 获取文件内容
     * @param file 文件
     * @return 返回文件内容
     * @throws IOException 抛出IOException异常
     */
    public static String getFileText(File file) throws IOException {
        FileInputStream fip = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fip, StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        String text = sb.toString();
        reader.close();
        fip.close();
        return text;
    }

    /**
     * 获取文件内容
     * @param filePath 文件路径
     * @return 返回文件内容
     * @throws IOException 抛出IOException异常
     */
    public static String getFileText(String filePath) throws IOException {
        return getFileText(new File(filePath));
    }

}
