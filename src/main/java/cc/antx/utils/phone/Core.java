package cc.antx.utils.phone;

import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import java.util.Locale;

public class Core {
    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
    private static final PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();
    private static final PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();

    /**
     * 根据国家代码和手机号  判断手机号是否有效
     *
     * @param phoneNumber 手机号
     * @param countryCode 国家代码
     * @return 手机号是否有效
     */
    public static boolean checkPhoneNumber(String phoneNumber, String countryCode) {
        int code = Integer.parseInt(countryCode);
        long phone = Long.parseLong(phoneNumber);
        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(code);
        pn.setNationalNumber(phone);
        return phoneNumberUtil.isValidNumber(pn);
    }

    /**
     * 根据国家代码和手机号  判断手机运营商
     *
     * @param phoneNumber 手机号
     * @param countryCode 国家代码
     * @return 手机号运营商
     */
    public static String getPhoneNumberOperation(String phoneNumber, String countryCode) {
        int code = Integer.parseInt(countryCode);
        long phone = Long.parseLong(phoneNumber);
        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(code);
        pn.setNationalNumber(phone);
        String carrierEn = carrierMapper.getNameForNumber(pn, Locale.ENGLISH);
        String carrierZh = "";
        carrierZh += geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
        switch (carrierEn) {
            case "China Mobile" -> carrierZh += "移动";
            case "China Unicom" -> carrierZh += "联通";
            case "China Telecom" -> carrierZh += "电信";
            default -> {
            }
        }
        return carrierZh;
    }


    /**
     * 获取指定国家代码的手机号的归属地
     *
     * @param phoneNumber 手机号
     * @param countryCode 国家代码
     * @return 归属地
     */
    public static String getPhoneNumberLocation(String phoneNumber, String countryCode) {
        int code = Integer.parseInt(countryCode);
        long phone = Long.parseLong(phoneNumber);
        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(code);
        pn.setNationalNumber(phone);
        return geocoder.getDescriptionForNumber(pn, Locale.CHINA);
    }
}