package cc.antx.utils.phone;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhong
 * @date 2023-03-04 12:44
 */
public class Phone {
    private final String phone;
    private final String location;
    private final String operation;

    public Phone(String phone) {
        this.phone = phone;
        this.location = PhoneUtils.getPhoneNumberLocation(phone);
        this.operation = PhoneUtils.getPhoneNumberOperation(phone);
    }

    public Phone(String phone, String code) {
        this.phone = phone;
        this.location = Core.getPhoneNumberLocation(phone, code);
        this.operation = Core.getPhoneNumberOperation(phone, code);
    }


    public String getOperation() {
        return operation;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getJSONString();
    }

    public Map<String, String> getMap() {
        Map<String, String> info = new HashMap<>();
        info.put("phone", phone);
        info.put("location", location);
        info.put("operation", operation);
        return info;
    }


    public String getJSONString() {
        Map<String, String> info = getMap();
        JSONObject json = new JSONObject();
        json.putAll(info);
        return json.toJSONString();
    }
}
