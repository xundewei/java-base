package com.xdw;

import java.io.*;
import java.net.URL;

public class MyIO {

    public void a() throws IOException {
        try {
            FileInputStream fis = new FileInputStream("");
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.baidu.com");

        /* 字节流 */
        InputStream is = url.openStream();

        /* 字符流 */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

}
