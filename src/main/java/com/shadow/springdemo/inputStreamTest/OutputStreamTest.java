package com.shadow.springdemo.inputStreamTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-08 13:35
 */
public class OutputStreamTest {
    public static void main(String[] args) throws Exception {
        File file = new File("D:" + File.separator + "test1.txt");
        OutputStream output = new FileOutputStream(file);
        String msg = "HelloWorld213213";
        byte[] data = msg.getBytes();
        output.write(data);
        System.out.println("写入完成");
        output.close();

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator =list.iterator();
        iterator.remove();
        System.out.println(list);
    }
}
