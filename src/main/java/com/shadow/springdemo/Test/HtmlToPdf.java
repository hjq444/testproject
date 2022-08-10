package com.shadow.springdemo.Test;

import ch.qos.logback.core.util.FileUtil;

import java.io.File;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-25 18:06
 */
public class HtmlToPdf {
    //wkhtmltopdf在系统中的路径
    private static final String toPdfTool = "D:/Program Files/wkhtmltopdf/bin/wkhtmltopdf.exe";

    /**
     * html转pdf
     *
     * @param srcPath  html路径，可以是硬盘上的路径，也可以是网络路径
     * @param destPath pdf保存路径
     * @return 转换成功返回true
     */
    public static boolean convert(String srcPath, String destPath) {
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if (!parent.exists()) {
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
//        if (System.getProperty("os.name").indexOf("Windows") == -1) {
//            //非windows 系统
//            toPdfTool;
//        }
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("  --header-line");//页眉下面的线
        cmd.append("  --header-center 这里是页眉这里是页眉这里是页眉这里是页眉 ");
        //页眉中间内容
        cmd.append("  --margin-top 3cm ");
        //设置页面上边距 (default 10mm)
        cmd.append(" --header-html  file:///" + "D:/Administrator/Desktop/reportTemplate(1).html");
        // (添加一个HTML页眉,后面是网址)
        cmd.append(" --header-spacing 5 ");
        //    (设置页眉和内容的距离,默认0)
        cmd.append(" --footer-center (设置在中心位置的页脚内容)");
        //设置在中心位置的页脚内容
        cmd.append(" --footer-html  file:///" + "D:/Administrator/Desktop/reportTemplate(1).html");
        // (添加一个HTML页脚,后面是网址)
        cmd.append(" --footer-line");
        //* 显示一条线在页脚内容上)
        cmd.append(" --footer-spacing 5 ");
        // (设置页脚和内容的距离)
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);


        boolean result = true;
        try {
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
            error.start();
            output.start();
            proc.waitFor();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        HtmlToPdf.convert("D:/Administrator/Desktop/reportTemplate(1).html", "D:/Administrator/Desktop/wkhtmltopdf.pdf");
    }
}
