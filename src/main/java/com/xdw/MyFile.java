package com.xdw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFile {

    /**
     * 通过 Paths File Files 直接拷贝文件
     */
    public static void copyFile1(){
        try {
            //获取原文件
            Path sourceFilePath = Paths.get("D:\\JAVA","apache-maven-3.6.2-bin.tar.gz");
            System.out.println("文件路径：" + sourceFilePath);
            //创建一个新文件
            File f = new File("D:\\JAVA\\apache-maven-3.6.2-bin.tar.gz.tmp");
            f.createNewFile();

            //添加
            //拷贝文件
            Files.copy(sourceFilePath, new FileOutputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过文件流来直接拷贝文件
     * @throws IOException
     */
    public static void copyFile2() throws IOException {
        FileInputStream in = new FileInputStream("D:\\JAVA\\apache-maven-3.6.2-bin.tar.gz");
        FileOutputStream out = new FileOutputStream("D:\\JAVA\\apache-maven-3.6.2-bin.tar.gz.tmp1");
        byte[] buffer = new byte[20 * 1024];
        int cnt;
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }
        in.close();
        out.close();

    }


    public static void main(String[] args) {
//        MyFile.copyFile1();
        try {
            MyFile.copyFile2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
