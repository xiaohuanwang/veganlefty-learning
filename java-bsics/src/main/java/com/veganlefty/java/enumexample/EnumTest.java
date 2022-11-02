package com.veganlefty.java.enumexample;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/11/2 22:14
 */
public class EnumTest {
    public static void main(String[] args) {
        Spiciness spiciness = Spiciness.MILD;
        System.out.println(spiciness);

        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ":" + s.ordinal());
        }
    }
}
