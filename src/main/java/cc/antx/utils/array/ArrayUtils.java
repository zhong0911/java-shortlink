package cc.antx.utils.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 关于数组操作的类
 *
 * @author zhong
 * @date 2023-02-02 18:11
 */
public class ArrayUtils {

    /**
     * 将参数里的数组依次连接并返回
     *
     * @param arrays 数组
     * @return 连接好的数组
     */
    public static Object[] concatArray(Object[]... arrays) {
        List<Object> list = new ArrayList<>(Arrays.asList(arrays[0]));
        for (int i = 1; i < arrays.length; i++) {
            list.addAll(Arrays.asList(arrays[i]));
        }
        return list.toArray();
    }


    /**
     * 判断数组中是否包含指定元素
     *
     * @param arr 数组
     * @param obj 元素
     * @return 数组是否包含指定元素
     */
    public static boolean contains(Object[] arr, Object obj) {
        List<Object> list = new ArrayList<>(Arrays.asList(arr));
        return list.contains(obj);
    }


    /**
     * 将某个对象添加到指定数组的最后
     *
     * @param arr 数组
     * @param obj 要添加对象
     * @return 添加了指定对象的数组
     */
    public static Object[] concatOne(Object[] arr, Object... obj) {
        try {
            List<Object> list = new ArrayList<>(Arrays.asList(arr));
            list.add(obj);
            return list.toArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[]{};
        }
    }


    /**
     * 将多个个对象添加到指定数组的最后
     *
     * @param arr 数组
     * @param obj 要添加对象
     * @return 添加了指定对象的数组
     */
    public static Object[] concat(Object[] arr, Object... obj) {
        Object[] result;
        try {
            List<Object> list = new ArrayList<>(Arrays.asList(arr));
            list.addAll(Arrays.asList(obj));
            result = list.toArray();
        } catch (Exception e) {
            e.printStackTrace();
            result = new Object[]{};
        }
        return result;
    }


    /**
     * 获取指定对象在数组中的所有索引
     * 返回的索引在数组中
     *
     * @param arr 数组
     * @param obj 要查找对象
     * @return 索引数组
     */
    public static Integer[] getAllIndex(Object[] arr, Object obj) {
        List<Integer> indexes = new ArrayList<>();
        List<Object> list = new ArrayList<>(Arrays.asList(arr));
        try {
            int index;
            do {
                index = list.indexOf(obj);
                if (index != -1) {
                    indexes.add(index);
                    list.set(index, null);
                }
            } while (index != list.lastIndexOf(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexes.toArray(new Integer[0]);
    }


    /**
     * 获取指定对象在数组中的第一个索引
     *
     * @param arr 数组
     * @param obj 对象
     * @return 第一个索引
     */
    public static Integer getIndex(Object[] arr, Object obj) {
        int result;
        try {
            List<Object> list = new ArrayList<>(Arrays.asList(arr));
            result = list.indexOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }


    /**
     * 获取指定对象在数组中的最后一个索引
     *
     * @param arr 数组
     * @param obj 对象
     * @return 第一个索引
     */
    public static Integer getLastIndex(Object[] arr, Object obj) {
        int result;
        try {
            List<Object> list = new ArrayList<>(Arrays.asList(arr));
            result = list.lastIndexOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }


    public static void main(String[] args) {
        Object[] arr = new Object[]{1, "", 2, 12, 20, 2, 2, 1.0, 99, 66, 6, 7, 6,};
        Integer[] indexes = getAllIndex(arr, 2);
        System.out.println(Arrays.toString(indexes));
        System.out.println(getIndex(arr, 2));
        System.out.println(getLastIndex(arr, 2));
    }
};





