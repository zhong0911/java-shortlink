package cc.antx.utils.system;

import javax.swing.filechooser.FileSystemView;

/**
 * 关于系统属性的类
 *
 * @author zhong
 * @date 2023-02-03 19:32
 */
public class SystemUtils {

    public static void main(String[] args) {
        printProperties();
    }


    /**
     * java版本号
     */
    public static final String JAVA_VERSION = System.getProperty("java.version");
    /**
     * java提供商
     */
    public static final String JAVA_VENDOR = System.getProperty("java.vendor");
    /**
     * java提供商网站
     */
    public static final String JAVA_VENDOR_URL = System.getProperty("java.vendor.url");
    /**
     * jre目录
     */
    public static final String JRE_DIR = System.getProperty("java.home");
    /**
     * Java虚拟机版本号
     */
    public static final String JVM_VERSION = System.getProperty("java.vm.version");
    /**
     * Java虚拟机提供商
     */
    public static final String JVM_VENDOR = System.getProperty("java.vm.vendor");
    /**
     * java虚拟机名称
     */
    public static final String JVM_NAME = System.getProperty("java.vm.name");
    /**
     * Java虚拟机规范版本号
     */
    public static final String JVM_SPECIFICATION_VERSION = System.getProperty("java.vm.specification.version");
    /**
     * Java虚拟机规范提供商
     */
    public static final String JVM_SPECIFICATION_VENDOR = System.getProperty("java.vm.specification.vendor");
    /**
     * Java虚拟机规范名称
     */
    public static final String JVM_SPECIFICATION_NAME = System.getProperty("java.vm.specification.name");
    /**
     * Java类版本号
     */
    public static final String JAVA_CLASS_VERSION = System.getProperty("java.class.version");
    /**
     * java类路径
     */
    public static final String JAVA_CLASS_PATH = System.getProperty("java.class.path");
    /**
     * java lib路径
     */
    public static final String JAVA_LIB_PATH = System.getProperty("java.library.path");
    /**
     * Java输入输出临时路径
     */
    public static final String JAVA_IO_TMP_DIR = System.getProperty("java.io.tmpdir");
    /**
     * Java编译器
     */
    public static final String JAVA_COMPILER = System.getProperty("java.compiler");
    /**
     * java执行路径
     */
    public static final String JAVA_EXECUTE_DIR = System.getProperty("java.ext.dirs");
    /**
     * 操作系统名称
     */
    public static final String OS_NAME = System.getProperty("os.name");
    /**
     * 操作系统架构
     */
    public static final String OS_ARCH = System.getProperty("os.arch");
    /**
     * 操作系统版本号
     */
    public static final String OS_VERSION = System.getProperty("os.version");
    /**
     * 文件分隔符
     */
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    /**
     * 路径分隔符
     */
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");
    /**
     * 直线分隔符
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    /**
     * 操作系统用户名
     */
    public static final String OS_USER_NAME = System.getProperty("user.name");
    /**
     * 操作系统用户主目录
     */
    public static final String OS_USER_HOME = System.getProperty("user.home");
    /**
     * 当前程序的目录
     */
    public static String WORKING_DIR = System.getProperty("user.dir");
    /**
     * 操作系统桌面路径
     */
    public static final String DESKTOP_PATH = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();

    /**
     * 打印所有的系统属性
     */
    public static void printProperties() {
        System.out.println("java版本号: " + JAVA_VERSION);
        System.out.println("Java提供商名称: " + JAVA_VENDOR);
        System.out.println("Java提供商网站: " + JAVA_VENDOR_URL);
        System.out.println("jre目录: " + JRE_DIR);
        System.out.println("Java虚拟机规范版本号: " + JVM_SPECIFICATION_VERSION);
        System.out.println("Java虚拟机规范提供商: " + JVM_SPECIFICATION_VENDOR);
        System.out.println("Java虚拟机规范名称: " + JVM_SPECIFICATION_NAME);
        System.out.println("Java虚拟机版本号: " + JVM_VERSION);
        System.out.println("Java虚拟机提供商: " + JVM_VENDOR);
        System.out.println("Java虚拟机名称: " + JVM_NAME);
        System.out.println("Java规范版本号: " + JVM_SPECIFICATION_VERSION);
        System.out.println("Java规范提供商: " + JVM_SPECIFICATION_VENDOR);
        System.out.println("Java规范名称: " + JVM_SPECIFICATION_NAME);
        System.out.println("Java类版本号: " + JAVA_CLASS_VERSION);
        System.out.println("Java类路径: " + JAVA_CLASS_PATH);
        System.out.println("Java lib路径: " + JAVA_LIB_PATH);
        System.out.println("Java输入输出临时路径: " + JAVA_IO_TMP_DIR);
        System.out.println("Java编译器: " + JAVA_COMPILER);
        System.out.println("Java执行路径: " + JAVA_EXECUTE_DIR);
        System.out.println("操作系统名称: " + OS_NAME);
        System.out.println("操作系统的架构: " + OS_ARCH);
        System.out.println("操作系统版本号: " + OS_VERSION);
        System.out.println("文件分隔符: " + FILE_SEPARATOR);
        System.out.println("路径分隔符: " + PATH_SEPARATOR);
        System.out.println("直线分隔符: " + LINE_SEPARATOR);
        System.out.println("操作系统用户名: " + OS_USER_NAME);
        System.out.println("操作系统用户的主目录: " + OS_USER_HOME);
        System.out.println("当前程序所在目录: " + WORKING_DIR);
        System.out.println("操作系统桌面路径: " + DESKTOP_PATH);
    }
}

















