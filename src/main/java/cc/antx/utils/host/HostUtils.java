package cc.antx.utils.host;

import java.net.InetAddress;

/**
 * 获取本机的一些基本信息
 */
public class HostUtils {
    public static void main(String[] args) {
        System.out.println(getHostAddress("localhost"));
    }

    /**
     * 获取本机的IPv4地址
     *
     * @return 本机IPv4地址
     */
    public static String getLocalhostAddress() {
        InetAddress inetAddress;
        String addr = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            addr = inetAddress.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addr;
    }

    /**
     * 获取本机名称
     *
     * @return 本机名称
     */
    public static String getLocalhostName() {
        InetAddress inetAddress;
        String name = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            name = inetAddress.getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 获取指定主机的IPv4地址
     *
     * @param name 指定主机名
     * @return 主机的IPv4地址
     */
    public static String getHostAddress(String name) {
        InetAddress inetAddr;
        String addr = null;
        try {
            inetAddr = InetAddress.getByName(name);
            addr = inetAddr.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addr;
    }
}
