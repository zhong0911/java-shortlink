package cc.antx.utils.math;

import cc.antx.utils.math.exception.FractionException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhong
 * @date 2023-02-02 19:07
 */
public class Fraction {

    /**
     * 分数的值
     */
    private BigDecimal value;

    /**
     * 创建一个分数对象
     *
     * @param a 分子(被除数)
     * @param b 分母(除数)
     */
    public Fraction(int a, int b) {
        BigDecimal A = new BigDecimal(String.valueOf(a));
        BigDecimal B = new BigDecimal(String.valueOf(b));
        value = A.divide(B, 10, RoundingMode.HALF_UP);
    }

    /**
     * 创建一个分数对象
     *
     * @param a     分子(被除数)
     * @param b     分母(除数)
     * @param scale 分数结果保留的小数位数
     */
    public Fraction(int a, int b, int scale) {
        BigDecimal A = new BigDecimal(String.valueOf(a));
        BigDecimal B = new BigDecimal(String.valueOf(b));
        value = A.divide(B, scale, RoundingMode.HALF_UP);
    }

    /**
     * 返回分数的Byte类型的值
     * 如果分数的值不是整数
     * 将会抛出FractionException
     *
     * @return 分数Byte类型值
     */
    public Byte byteValue() {
        try {
            return Byte.valueOf(String.valueOf(value));
        } catch (NumberFormatException err) {
            try {
                throw new FractionException("该分数的值是非整数无法转换成java.lang.Byte类型");
            } catch (FractionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 返回分数的整型类型
     * 如果分数的值不是整数
     * 将会抛出FractionException
     *
     * @return 分数Integer类型的值
     */
    public Integer intValue() {
        try {
            return Integer.valueOf(String.valueOf(value));
        } catch (NumberFormatException err) {
            try {
                throw new FractionException("该分数的值是非整数无法转换成java.lang.integer类型");
            } catch (FractionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 返回分数的短整型类型
     * 如果分数的值不是整数
     * 将会抛出FractionException
     *
     * @return 分数的Short类型的值
     */
    public Short shortValue() {
        try {
            return Short.valueOf(String.valueOf(value));
        } catch (NumberFormatException err) {
            try {
                throw new FractionException("该分数的值是非整数无法转换成java.lang.short类型");
            } catch (FractionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 返回分数的长整型类型
     * 如果分数的值不是整数
     * 将会抛出FractionException
     *
     * @return 分数的Long类型的值
     */
    public Long longValue() {
        try {
            return Long.valueOf(String.valueOf(value));
        } catch (NumberFormatException err) {
            try {
                throw new FractionException("该分数的值是非整数无法转换成java.lang.long类型");
            } catch (FractionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 返回分数的浮点型类型
     *
     * @return 分数的Float类型的值
     */
    public Float floatValue() {
        return Float.valueOf(String.valueOf(value));
    }

    /**
     * 返回分数的双精度类
     *
     * @return 分数的Double类型的值
     */
    public Double doubleValue() {
        return Double.valueOf(String.valueOf(value));
    }

    /**
     * 返回分数的字符串
     *
     * @return 分数的字符串
     */
    public String toString() {
        return String.valueOf(value);
    }
}
