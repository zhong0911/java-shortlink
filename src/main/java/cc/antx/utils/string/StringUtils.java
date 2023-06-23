package cc.antx.utils.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * 关于一些字符串的操作
 *
 * @author zhong
 * @date 2023-02-01 14:31
 */

public class StringUtils {
    public static void main(String[] args) {
        System.out.println(isEmail("zhong_jia_hao@163.com"));
    }

    /**
     * 空白字符
     */
    public static final String[] WHITE_SPACE = new String[]{" ", "\n", "\t", "\r", "\f"};
    /**
     * 十进制数字字符
     */
    public static final Integer[] DIGITS = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    /**
     * 小写ASCII码字母
     */
    public static final String[] ASCII_LOWERCASE = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };
    /**
     * 大写ASCII码字母
     */
    public static final String[] ASCII_UPPERCASE = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    /**
     * ASCII码字母
     */
    public static final String[] ASCII_LETTERS = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    /**
     * 十六进制数字字符
     */
    public static final String[] HEXDIGITS = new String[]{
            "a", "b", "c", "d", "e", "f", "A", "B", "C", "D", "E", "F",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
    };
    /**
     * 八进制数字字符
     */
    public static final Integer[] OCTDIGITS = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
    /**
     * 标点符号字符
     */
    public static final String[] PUNCTUATION = new String[]{
            "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", "", "/", ":",
            ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "`", "{", "|", "}", "~"
    };
    /**
     * 可打印的ASCII码字符
     */
    public static final Object[] PRINTABLE = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-",
            "", "/", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^",
            "_", "`", "{", "|", "}", "~"
    };
    /**
     * 大小写ASCII码字母和十进制数字
     */
    public static final String[] LETTERS_AND_DIGITS = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
    };
    /**
     * Random对象
     */
    public static final Random random = new Random();
    /**
     * 中国大陆手机号的正则表达式
     */
    public static final String PHONE_RE = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
    /**
     * uid的正则表达式
     */
    public static final String UID_RE = "^\\d{5,10}$";
    /**
     * 用户名的正则表达式
     */
    public static final String USERNAME_RE = "^[a-zA-Z]+([a-zA-Z0-9]+)$";
    /**
     * 密码的正则表达式
     */
    public static final String PASSWORD_RE = "^[a-zA-Z]+([a-zA-Z0-9]+)$";
    /**
     * 字母的正则表达式
     */
    public static final String LETTERS_RE = "[a-zA-Z ]+";
    /**
     * 数字的正则表达式
     */
    public static final String NUMBER_RE = "^[+-]?\\d+(\\.\\d*)?$";
    /**
     * 整数的正则表达式
     */
    public static final String INTEGER_RE = "^[+-]?\\d+$";
    /**
     * 邮箱的正则表达式
     */
    public static final String EMAIL_RE = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 生成长度为length的激活码
     *
     * @param length 激活码长度
     * @return 激活码
     */
    public static String getActivationCode(int length) {
        StringBuilder code = new StringBuilder();
        int len = PRINTABLE.length;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(len);
            code.append(PRINTABLE[index]);
        }
        return code.toString();
    }

    /**
     * 生成激活码
     * 长度为1024
     *
     * @return 激活码
     */
    public static String getActivationCode() {
        return getActivationCode(1024);
    }

    /**
     * 生成长度为length的随机数字
     *
     * @param length 数字长度
     * @return 随机数字
     */
    public static String getRandomNumber(Integer length) {
        StringBuilder code = new StringBuilder();
        int len = DIGITS.length;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(len);
            code.append(DIGITS[index]);
        }
        return code.toString();
    }

    /**
     * 生成长度为length的随机字符串
     *
     * @param length 字符串长度
     * @return 随机字符串
     */
    public static String getRandomString(Integer length) {
        StringBuilder string = new StringBuilder();
        int len = LETTERS_AND_DIGITS.length;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(len);
            string.append(LETTERS_AND_DIGITS[index]);
        }
        return string.toString();
    }

    /**
     * 判断字符串是否是中文
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否是中文
     */
    public static boolean isChinese(String s) {
        int n;
        for (int i = 0; i < s.length(); i++) {
            n = s.charAt(i);
            if (!(19968 <= n && n < 40869)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否是中国大陆的手机号
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否否为中国大陆的手机号
     */
    public static boolean isPhone(String s) {
        return Pattern.matches(PHONE_RE, s);
    }

    /**
     * 判断字符串是否为uid
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否为字符串
     */
    public static boolean isUid(String s) {
        return Pattern.matches(UID_RE, s);
    }

    /**
     * 判断字符串是否为字母
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否为字母
     */
    public static boolean isLetters(String s) {
        return Pattern.matches(LETTERS_RE, s);
    }

    /**
     * 判断字符串是否为符合格式用户名
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否为符合格式用户名
     */
    public static boolean isUsername(String s) {
        return (Pattern.matches(USERNAME_RE, s) && (s.length() >= 4) && (s.length() <= 16) || (Pattern.matches("^[a-zA-Z]+$", s) && (s.length() >= 4) && (s.length() <= 16)));
    }

    /**
     * 判断字符串是否为符合格式的密码
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否为符合格式的密码
     */
    public static boolean isPassword(String s) {
        return (Pattern.matches(PASSWORD_RE, s) && (s.length() >= 6) && (s.length() <= 20));
    }

    /**
     * 判断字符串是否为数字
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否为数字
     */
    public static boolean isNumber(String s) {
        return Pattern.matches(NUMBER_RE, s);
    }

    /**
     * 判断字符串是否为整数
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否为整数
     */
    public static boolean isInteger(String s) {
        return Pattern.matches(INTEGER_RE, s);
    }

    /**
     * 判断字符串是否为符合格式的邮箱地址
     * 是就返回true
     * 否则返回false
     *
     * @param s 字符串
     * @return 是否为符合格式的邮箱地址
     */
    public static boolean isEmail(String s) {
        return Pattern.matches(EMAIL_RE, s);
    }

    /**
     * 将bytes类型的数据转换为16进制的数据
     *
     * @param bytes bytes数据
     * @return 16进制数据
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xFF & aByte);
            if (hex.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取字符串的md5值
     *
     * @param s 字符串
     * @return 字符串md5值
     */
    public static String getStringMD5(String s) {
        return getStringHash(s, "MD5");
    }

    /**
     * 获取字符串的sha1值
     *
     * @param s 字符串
     * @return 字符串的sha1值
     */
    public static String getStringSHA1(String s) {
        return getStringHash(s, "SHA1");
    }

    /**
     * 获取字符串的sha256值
     *
     * @param s 字符串
     * @return 字符串sha256值
     */
    public static String getStringSHA256(String s) {
        return getStringHash(s, "SHA256");
    }

    /**
     * 获取字符串的sha512值
     *
     * @param s 字符串
     * @return 字符串sha512值
     */
    public static String getStringSHA512(String s) {
        return getStringHash(s, "SHA512");
    }

    /**
     * 获取字符串的指定hash值
     *
     * @param s      字符串
     * @param method hash算法
     * @return 字符串指定hash值
     */
    public static String getStringHash(String s, String method) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance(method);
            mDigest.update(s.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(s.hashCode());
        }
        return cacheKey;
    }

}
