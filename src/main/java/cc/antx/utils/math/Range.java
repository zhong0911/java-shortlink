package cc.antx.utils.math;

/**
 * 创建整数列表
 *
 * @author zhong
 * @date 2023-02-02 21:04
 */

public class Range {

    /**
     * 数组的值
     */
    public Integer[] value;

    /**
     * 创建一个整数列表
     *
     * @param start 数组开始的数
     */
    public Range(int start) {
        value = range(start);
    }

    /**
     * 创建一个整数列表
     *
     * @param start 数组开始的数
     * @param end   数组结束的数
     */
    public Range(int start, int end) {
        value = range(start, end);
    }

    /**
     * 创建一个整数列表
     *
     * @param start 数组开始的数
     * @param end   数组结束的数
     * @param step  数组的步长
     */
    public Range(int start, int end, int step) {
        value = range(start, end, step);
    }

    /**
     * 创建一个整数列表
     * 范围在 0 ~ (a - 1)
     * 例如: range(10) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     *
     * @param start 数组开始的数
     * @return 数组
     */
    public static Integer[] range(int start) {
        Integer[] res = new Integer[start];
        for (int i = 0; i < start; i++) {
            res[i] = i;
        }
        return res;
    }

    /**
     * 创建一个整数列表
     * 范围在 a ~ (b - 1)
     * 例如: range(10, 20) = [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
     *
     * @param start 数组开始的数
     * @param end   数组结束的数
     * @return 数组
     */
    public static Integer[] range(int start, int end) {
        if (end > start) {
            Integer[] res = new Integer[end - start];
            for (int i = 0; i < end && i < (end - start); i++) {
                res[i] = start + i;
            }
            return res;
        } else {
            return new Integer[]{};
        }
    }

    /**
     * 创建一个整数列表
     * 范围在 a ~ (b - 1), 但每个数的步长为c
     *
     * @param start 数组开始的数
     * @param end   数组结束的数
     * @param step  数组的步长
     * @return 数组
     */
    public static Integer[] range(int start, int end, int step) {
        if (end > start && step < end - start) {
            Integer[] range = range(start, end);
            Integer[] res = new Integer[end - start];
            res[0] = start;
            for (int i : range) {
                int d = start + i * step;
                if (d < end) res[i] = d;
            }
            return res;
        } else if (step > end - start) {
            return new Integer[]{};
        } else {
            return new Integer[]{};
        }
    }
}
