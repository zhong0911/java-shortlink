package cc.antx.utils.math;

/**
 * 一些常用的数学运算
 *
 * @author zhong
 * @date 2023-02-01 14:41
 */
public class MathUtils {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    /**
     * 获取幂的值
     *
     * @param a 底数
     * @param b 指数
     * @return a的b幂
     */
    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    /**
     * 获取阶乘的值
     *
     * @param a 自然数
     * @return 阶乘的值
     */
    public static long factorial(long a) {
        if (a <= 1) return 1L;
        else return a * factorial(a - 1);
    }

    /**
     * 判断一个数是否为偶数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为偶数
     */
    public static boolean isEvenNumber(byte a) {
        return a % 2 == 0;
    }

    /**
     * 判断一个数是否为正数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为正数
     */
    public static boolean isPositiveNumber(byte a) {
        return a > 0;
    }

    /**
     * 判断一个数是否为负数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 数字是否为负数
     */
    public static boolean isNegativeNumber(byte a) {
        return a < 0;
    }

    /**
     * 判断一个数是否为奇数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为奇数
     */
    public static boolean isOddNumber(byte a) {
        return !isEvenNumber(a);
    }

    /**
     * 判断一个数是否为偶数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为偶数
     */
    public static boolean isEvenNumber(short a) {
        return a % 2 == 0;
    }

    /**
     * 判断一个数是否为正数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为正数
     */
    public static boolean isPositiveNumber(short a) {
        return a > 0;
    }

    /**
     * 判断一个数是否为负数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 数字是否为负数
     */
    public static boolean isNegativeNumber(short a) {
        return a < 0;
    }

    /**
     * 判断一个数是否为奇数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为奇数
     */
    public static boolean isOddNumber(short a) {
        return !isEvenNumber(a);
    }

    /**
     * 判断一个数是否为偶数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为偶数
     */
    public static boolean isEvenNumber(int a) {
        return a % 2 == 0;
    }

    /**
     * 判断一个数是否为正数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为正数
     */
    public static boolean isPositiveNumber(int a) {
        return a > 0;
    }

    /**
     * 判断一个数是否为负数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 数字是否为负数
     */
    public static boolean isNegativeNumber(int a) {
        return a < 0;
    }

    /**
     * 判断一个数是否为奇数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为奇数
     */
    public static boolean isOddNumber(int a) {
        return !isEvenNumber(a);
    }

    /**
     * 判断一个数是否为偶数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为偶数
     */
    public static boolean isEvenNumber(long a) {
        return a % 2 == 0;
    }

    /**
     * 判断一个数是否为正数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为正数
     */
    public static boolean isPositiveNumber(long a) {
        return a > 0;
    }

    /**
     * 判断一个数是否为负数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 数字是否为负数
     */
    public static boolean isNegativeNumber(long a) {
        return a < 0;
    }

    /**
     * 判断一个数是否为奇数
     * 是就返回 true
     * 非就返回 false
     *
     * @param a 数字
     * @return 是否为奇数
     */
    public static boolean isOddNumber(long a) {
        return !isEvenNumber(a);
    }
}
