package com.veganlefty.java;

import java.io.File;
/**
 * @Description:
 * @date: 2021/10/27 11:08 下午
 * @author: 王小欢
 */
public class Test {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    }
}
