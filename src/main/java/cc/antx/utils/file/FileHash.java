package cc.antx.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import static cc.antx.utils.string.StringUtils.bytesToHexString;

/**
 * 获取文件的hash值
 *
 * @author zhong
 * @date 2023-02-01 14:10
 */

public class FileHash {

    /**
     * 获取文件md5值
     *
     * @param file 文件路径
     * @return 文件的md5值
     */
    public static String getFileMD5(File file) {
        String hash = "";
        try {
            hash = getHash(file, "MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * 获取文件sha1值
     *
     * @param file 文件路径
     * @return 文件的sha1值
     */
    public static String getFileSHA1(File file) {
        String hash = "";
        try {
            hash = getHash(file, "SHA-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * 获取文件sha256值
     *
     * @param file 文件路径
     * @return 文件的sha256值
     */
    public static String getFileSHA256(File file) {
        String hash = "";
        try {
            hash = getHash(file, "SHA-256");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * 获取文件sha512值
     *
     * @param file 文件路径
     * @return 文件的sha512值
     */
    public static String getFileSHA512(File file) {
        String hash = "";
        try {
            hash = getHash(file, "SHA-512");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * 通过指定hash类型, 获取文件hash值
     *
     * @param file     文件路径
     * @param hashType hash类型
     * @return 文件has值
     * @throws Exception 抛出Exception异常
     */
    private static String getHash(File file, String hashType) throws Exception {
        InputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        MessageDigest md5 = MessageDigest.getInstance(hashType);
        for (int numRead; (numRead = fis.read(buffer)) > 0; ) {
            md5.update(buffer, 0, numRead);
        }
        fis.close();
        return bytesToHexString(md5.digest());
    }

}
