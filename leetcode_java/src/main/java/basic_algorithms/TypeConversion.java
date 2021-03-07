
package main.java.basic_algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类型转换
 * 参考：https://www.imooc.com/article/43299
 *
 * @author zx
 * @since 2021-03-06
 */
public class TypeConversion {
    /**
     * int --> String
     * 1. int 直接加上 ""
     * 2. String.valueOf()，推荐，可以应用到任何数据类型
     * 3. Integer.toString()
     */
    @Test
    public void intToString() {
        int num1 = 123;
        int num2 = -123;

        /* int 直接加上 "" 即可转为字符串 */
        String s1_1 = num1 + "";
        String s1_2 = num2 + "";
        System.out.println("int 直接加上 \"\" 将数字转化为字符串：" + num1 + " ----> " + s1_1);
        System.out.println("int 直接加上 \"\" 将数字转化为字符串：" + num2 + " ----> " + s1_2);
        System.out.println("----------");

        /* 推荐使用 String.valueOf() 方法，可以应用到任何数据类型，且不会有异常报出。 */
        String s2_1 = String.valueOf(num1);
        String s2_2 = String.valueOf(num2);
        System.out.println("String.valueOf() 将数字转换为字符串：" + num1 + " ----> " + s2_1);
        System.out.println("String.valueOf() 将数字转换为字符串：" + num2 + " ----> " + s2_2);
        System.out.println("----------");

        /* Integer.toString() 是先将 int 转换成 Integer，再将 Integer 转换成 String */
        String s3_1 = Integer.toString(num1);
        String s3_2 = Integer.toString(num2);
        System.out.println("Integer.toString() 将数字转换为字符串：" + num1 + " ----> " + s3_1);
        System.out.println("Integer.toString() 将数字转换为字符串：" + num2 + " ----> " + s3_2);
        System.out.println("----------");
    }

    /**
     * String --> int
     * 1. Integer.parseInt()，推荐，Float也有类似的 Float.parseFloat()，Double 也有。
     * 2. Integer.valueOf()
     */
    @Test
    public void stringToInt() {
        String s1 = "123";
        String s2 = "-123";

        /* 推荐使用 Integer.parseInt()，注意 int 范围是 -2^32 ~ (2^32)-1 */
        int num1_1 = Integer.parseInt(s1);
        int num1_2 = Integer.parseInt(s2);
        System.out.println("Integer.parseInt() 将字符串转换为数字：" + s1 + " ----> " + num1_1);
        System.out.println("Integer.parseInt() 将字符串转换为数字：" + s2 + " ----> " + num1_2);
        System.out.println("----------");

        /* Integer.valueOf() 有多余的装箱操作，valueOf 是调用 parseInt 之后再做一次类型转换。*/
        /* 注意 int 的取值范围为 -2^32 ~ (2^32)-1 */
        int num2_1 = Integer.valueOf(s1);
        int num2_2 = Integer.valueOf(s2);
        System.out.println("Integer.valueOf() 将字符串转换为数字：" + s1 + " ----> " + num2_1);
        System.out.println("Integer.valueOf() 将字符串转换为数字：" + s2 + " ----> " + num2_2);
        System.out.println("----------");
    }

    /**
     * String --> Array
     * 1. split(String regex) 转换为字符串数组 String[]
     * 2. toCharArray(String str) 转换为字符数组 char[]
     */
    @Test
    public void stringToArray() {
        String s1 = "123";
        String s2 = "abc";

        /* split(String regex) 按指定正则把 String 拆分为 String[] */
        String[] array1_1 = s1.split("");
        String[] array1_2 = s2.split("");
        System.out.println("split() 将字符串转换为字符串数组：" + s1 + " ----> " + Arrays.toString(array1_1));
        System.out.println("split() 将字符串转换为字符串数组：" + s2 + " ----> " + Arrays.toString(array1_2));
        System.out.println("----------");

        // toCharArray(String str) 将字符串 str 转换为 char[] 字符数组。
        char[] ch1_1 = s1.toCharArray();
        char[] ch1_2 = s2.toCharArray();
        System.out.println("split() 将字符串转换为字符数组：" + s1 + " ----> " + Arrays.toString(ch1_1));
        System.out.println("split() 将字符串转换为字符数组：" + s2 + " ----> " + Arrays.toString(ch1_2));
        System.out.println("----------");
    }

    /**
     * Array --> String
     * 1. Arrays.toString()，可以把基础类型的数组转化成字符串，如 int[], char[] 等
     * 2. StringBuilder()，遍历数组保存到 StringBuilder。
     * 3. new String(char[])
     * 4. toCharArray(String str) 转换为字符数组 char[]
     */
    @Test
    public void arrayToString() {
        String[] array1 = {"a", "b", "c"};
        char[] array2 = {'a', 'b', 'c'};

        /*          通用转换，可以是 int[], char[] 等             */
        /* Arrays.toString() 转化后的字符串，实际被一个中括号包含 */
        String s1 = Arrays.toString(array1);
        String s2 = Arrays.toString(array2);
        System.out.println("Arrays.toString() 转换成的字符串被中括号包裹：" + s1);
        System.out.println("Arrays.toString() 也可以把[字符数组]转换为[字符串]：" + s2);
        System.out.println("----------");

        /* StringBuilder 不支持并发操作，线性不安全，但是在单线程中的性能比 StringBuffer 高 */
        StringBuilder s3 = new StringBuilder();
        for (String str : array1) {
            s3.append(str);
        }
        System.out.println("StringBuilder 将数组转换成字符串：" + s3);
        System.out.println("----------");

        /*          字符数组转换           */
        /* 字符数组还可以用 new String(char[]) 和 String.copyValueOf(char[]) */
        String s4 = new String(array2);
        System.out.println("new String(char[]) 可以把[字符数组]转换为[字符串]：" + s4);

        String s5 = String.copyValueOf(array2);
        System.out.println("String.copyValueOf(char[]) 可以把[字符数组]转换为[字符串]：" + s5);
    }

    /**
     * List --> String
     * 1. String.join() 把可迭代的对象拼接成字符串。
     */
    @Test
    public void listToString() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        /* String.join() 可以把可迭代的对象拼接成字符串 */
        String s1 = String.join("", list);

        System.out.println("String.join() 将 List 转换为 String：" + s1);
        System.out.println("----------");
    }

    /**
     * array --> List
     * 1. Arrays.asList() 把数组转换成 List，注意不能把基本数据类型转化为列表，
     * 因为 asList 接受的是一个泛型的变长参数，而基本数据类型是无法泛型化的。
     * 2. 如果想把 String 转换为 List，可以先用 split 把 String 转换为 String[]
     */
    @Test
    public void arrayToList() {
        String[] array = {"a", "b", "c"};
        // int[] 类型的数组不可以转换，需要用 Integer[] 类型的数组

        /* Arrays.asList 将数组转换为List */
        List<String> list = Arrays.asList(array);

        System.out.println("Arrays.asList 将 String[] 转换为List ：" + list);
        System.out.println("----------");
    }
}
