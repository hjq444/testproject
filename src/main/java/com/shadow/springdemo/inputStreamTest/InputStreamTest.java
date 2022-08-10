package com.shadow.springdemo.inputStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author: Huajq
 * @description: InputStreamTest
 * @date: 2022-06-08 12:00
 */
public class InputStreamTest {
    public static void main(String[] args) throws Exception {
        File file = new File("D:" + File.separator + "test1.txt");
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            byte[] data = new byte[1024 * 1024];
            int foot = 0;
            int temp = 0;
            while ((temp = is.read()) != -1) {
                data[foot++] = (byte) temp;
            }
            is.close();
            System.out.println(new String(data, 0, foot));
        }
    }
}
