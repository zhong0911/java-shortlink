package cc.antx.utils.print;


import java.util.Arrays;

/**
 * 在控制台按照传入格式输出
 *
 * @author zhong
 * @date 2023-02-03 10:48
 */
public class ColorPrint {

    /**
     * 分号
     */
    private static final String SEMICOLON = ";";

    /**
     * 默认黑色打印
     *
     * @param txt 信息
     */
    public static void outPrintln(String txt) {
        System.out.println(format(txt, ColorCode.BLACK));
    }

    /**
     * 换行打印
     *
     * @param txt   信息
     * @param codes 格式化参数
     */
    public static void outPrintln(String txt, ColorCode... codes) {
        System.out.println(format(txt, codes));
    }

    /**
     * 不换行打印
     *
     * @param txt   打印内容
     * @param codes 格式化参数
     */
    public static void outPrint(String txt, ColorCode... codes) {
        System.out.print(format(txt, codes));
    }

    /**
     * 默认红色打印
     *
     * @param txt 信息
     */
    public static void errorPrintln(String txt) {
        System.err.println(format(txt, ColorCode.RED));
    }

    /**
     * 换行打印
     *
     * @param txt   信息
     * @param codes 格式化参数
     */
    public static void errorPrintln(String txt, ColorCode... codes) {
        System.err.println(format(txt, codes));
    }

    /**
     * 不换行打印
     *
     * @param txt   打印内容
     * @param codes 格式化参数
     */
    public static void errorPrint(String txt, ColorCode... codes) {
        System.err.print(format(txt, codes));
    }

    /**
     * 格式化信息
     *
     * @param txt   信息
     * @param codes 参数集合
     * @return 格式化后的信息
     */
    private static String format(String txt, ColorCode... codes) {
        String codeStr = String.join(SEMICOLON, Arrays.stream(codes).map((printCode) -> String.valueOf(printCode.getCode())).toArray(String[]::new));
        return (char) 27 + "[" + codeStr + "m" + txt + (char) 27 + "[0m";
    }

    /**
     * 打印样例
     */
    public static void printExample() {
        ColorPrint.outPrintln("样例提示：黑色字体和黑色背景是一个取反色,和整体控制台主题背景有关,主题背景如果为深色,则相应的字体和背景变为白色,反之黑色",
                ColorCode.BOLD, ColorCode.UNDERLINE);
        ColorPrint.outPrintln("");
        outPrintln("灰色(ColorPrint.ColorCode.GREY)", ColorCode.GREY);
        outPrintln("黑色(ColorPrint.ColorCode.BLACK)", ColorCode.BLACK);
        outPrintln("红色(ColorPrint.ColorCode.RED)", ColorCode.RED);
        outPrintln("绿色(ColorPrint.ColorCode.GREEN)", ColorCode.GREEN);
        outPrintln("黄色(ColorPrint.ColorCode.YELLOW)", ColorCode.YELLOW);
        outPrintln("蓝色(ColorPrint.ColorCode.BLUE)", ColorCode.BLUE);
        outPrintln("品红(ColorPrint.ColorCode.MAGENTA)", ColorCode.MAGENTA);
        outPrintln("蓝绿(ColorPrint.ColorCode.CYAN)", ColorCode.CYAN);
        ColorPrint.outPrintln("黑色背景(ColorPrint.ColorCode.BLACK_BACKGROUND)",
                ColorCode.GREY, ColorCode.BLACK_BACKGROUND);
        ColorPrint.outPrintln("红色背景(ColorPrint.ColorCode.RED_BACKGROUND)",
                ColorCode.BLACK, ColorCode.RED_BACKGROUND);
        ColorPrint.outPrintln("绿色背景(ColorPrint.ColorCode.GREEN_BACKGROUND)",
                ColorCode.BLACK, ColorCode.GREEN_BACKGROUND);
        ColorPrint.outPrintln("黄色背景(ColorPrint.ColorCode.YELLOW_BACKGROUND)",
                ColorCode.BLACK, ColorCode.YELLOW_BACKGROUND);
        ColorPrint.outPrintln("蓝色背景(ColorPrint.ColorCode.BLUE_BACKGROUND)",
                ColorCode.BLACK, ColorCode.BLUE_BACKGROUND);
        ColorPrint.outPrintln("品红背景(ColorPrint.ColorCode.MAGENTA_BACKGROUND)",
                ColorCode.BLACK, ColorCode.MAGENTA_BACKGROUND);
        ColorPrint.outPrintln("蓝绿背景(ColorPrint.ColorCode.CYAN_BACKGROUND)",
                ColorCode.BLACK, ColorCode.CYAN_BACKGROUND);
        ColorPrint.outPrintln("灰色背景(ColorPrint.ColorCode.GREY_BACKGROUND)",
                ColorCode.BLACK, ColorCode.GREY_BACKGROUND);
        ColorPrint.outPrintln("默认字体(不传入其它参数)");
        outPrintln("加粗(ColorPrint.ColorCode.BOLD)", ColorCode.BOLD);
        outPrintln("斜体(ColorPrint.ColorCode.ITALIC)", ColorCode.ITALIC);
        outPrintln("下划线(ColorPrint.ColorCode.UNDERLINE)", ColorCode.UNDERLINE);
        ColorPrint.outPrintln(
                "示例:灰底/黑字/加粗/下划线/倾斜(ColorPrint.ColorCode.GREY_BACKGROUND," +
                        "ColorPrint.ColorCode.BLACK,ColorPrint.ColorCode.BOLD," +
                        "ColorPrint.ColorCode.UNDERLINE,ColorPrint.ColorCode.ITALIC)",
                ColorCode.GREY_BACKGROUND, ColorCode.BLACK,
                ColorCode.BOLD, ColorCode.UNDERLINE, ColorCode.ITALIC);
    }
}

