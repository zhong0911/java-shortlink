package cc.antx.utils.phone;

/**
 * @author zhong
 * @date 2023-03-04 12:37
 */
public class PhoneUtils {

    /**
     * 获取中国大陆手机号归属地
     *
     * @param phone 手机号
     * @return 手机号归属地
     */
    public static String getPhoneNumberLocation(String phone) {
        return Core.getPhoneNumberLocation(phone, "86");
    }


    /**
     * 获取中国大陆手机号的运营商
     *
     * @param phone 手机号
     * @return 手机号运营商
     */
    public static String getPhoneNumberOperation(String phone) {
        return Core.getPhoneNumberOperation(phone, "86");
    }

    /**
     * 获取指定国家代码的手机号归属地
     *
     * @param phone 手机号
     * @return 手机号归属地
     */
    public static String getPhoneNumberLocation(String phone, String code) {
        return Core.getPhoneNumberLocation(phone, code);
    }

    /**
     * 获取指定国家代码的手机号的运营商
     *
     * @param phone 手机号
     * @return 手机号运营商
     */
    public static String getPhoneNumberOperation(String phone, String code) {
        return Core.getPhoneNumberOperation(phone, code);
    }
}
