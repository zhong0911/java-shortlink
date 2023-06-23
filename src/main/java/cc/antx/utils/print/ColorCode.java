package cc.antx.utils.print;

/**
 * 控制台信息格式化参数
 *
 * @author zhong
 * @date 2023-02-01 12:23
 */
public enum ColorCode {
    /**
     * 黑色
     */
    BLACK(30),
    /**
     * 黑色背景
     */
    BLACK_BACKGROUND(40),
    /**
     * 红色
     */
    RED(31),
    /**
     * 红色背景
     */
    RED_BACKGROUND(41),
    /**
     * 绿色
     */
    GREEN(32),
    /**
     * 绿色背景
     */
    GREEN_BACKGROUND(42),
    /**
     * 黄色
     */
    YELLOW(33),
    /**
     * 黄色背景
     */
    YELLOW_BACKGROUND(43),
    /**
     * 蓝色
     */
    BLUE(34),
    /**
     * 蓝色背景
     */
    BLUE_BACKGROUND(44),
    /**
     * 品红（洋红）
     */
    MAGENTA(35),
    /**
     * 品红背景
     */
    MAGENTA_BACKGROUND(45),
    /**
     * 蓝绿
     */
    CYAN(36),
    /**
     * 蓝绿背景
     */
    CYAN_BACKGROUND(46),
    /**
     * 灰色
     */
    GREY(37),
    /**
     * 灰色背景
     */
    GREY_BACKGROUND(47),
    /**
     * 粗体
     */
    BOLD(1),
    /**
     * 斜体
     */
    ITALIC(3),
    /**
     * 下划线
     */
    UNDERLINE(4);

    private final int code;

    ColorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}