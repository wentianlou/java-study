package com.study.javastudy.io;

import java.io.*;

/**
 * 主要研制io的主要方法使用
 *
 * BufferedReader:从字符输入流中读取文本并缓冲字符,主要方法为read、readLine
 * InputStreamReader:是从字节流到字符流的桥：它读取字节，并使用指定的charset将其解码为字符 。
 * FileOutputStream:用于将数据写入到输出流File或一个FileDescriptor 。
 * FileWriter:写文本内容到文件，如果文件不存在会先创建
 *
 * @author wentianlou
 * @date 2019/12/11 19:25
 **/
public class IOTestDemo {
    public static void main(String[] args) throws IOException {
        //读取控制台中的输入
//        test01();
//        test02();
//        test03();

        //二进制文件的写入和读取
//        test04();
//        test05();

        //文本文件的写入和读取
//        test06();
//        test07();
//        test08();
//        test09();

//        test10();
//        test11();

//        test12();
//        test13();
//        test14();
        test15();
    }

    public static void test01() throws IOException {
        //从字符输入流中读取文本并缓冲字符
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符");
        char c;
        c = (char) bufferedReader.read();
        System.out.println("你输入的字符为"+c);
    }

    public static void test02() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符，按 q 键结束");
        char c;
        do {
            c = (char) bufferedReader.read();
            System.out.println("你输入的字符为"+c);
        } while (c != 'q');
    }

    public static void test03() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行字符");
        String str = bufferedReader.readLine();
        System.out.println("你输入的字符为" + str);
    }

    /**
     * 写二进制数据到文件
     * @throws IOException
     */
    public static void test04() throws IOException {
        byte[] bytes = {12,21,34,11,21};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+"/io/test.txt");
        // 写入二进制文件，直接打开会出现乱码
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    /**
     * 从文件都数据到内存
     * @throws IOException
     */
    public static void test05() throws IOException {
        File file = new File("");
        //getAbsolutePath获取文件的绝对路径名字符串[D:\workspace\java-study]
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath:" + absolutePath);
        FileInputStream fileInputStream = new FileInputStream(absolutePath + "/io/test.txt");
        int c;
        // 读取写入的二进制文件，输出字节数组
        while ((c = fileInputStream.read()) != -1) {
            System.out.print(c);
        }
    }

    /**
     * FileWriter:写文本内容到文件，如果文件不存在会先创建
     * @throws IOException
     */
    public static void test06() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/io/file_writer.txt");
        fileWriter.write("Hello，world！\n欢迎来到 java 世界\n");
        fileWriter.write("不会覆盖文件原本的内容\n");
//        fileWriter.write(null); 不能直接写入 null
        fileWriter.append("并不是追加一行内容，不要被方法名迷惑\n");
        fileWriter.append(null);
        fileWriter.flush();
        System.out.println("文件的默认编码为" + fileWriter.getEncoding());
        fileWriter.close();
    }

    /**
     * FileWriter:写文本内容到文件，如果文件不存在会先创建
     * 参数：append false：关闭追加模式，变为覆盖模式
     * @throws IOException
     */
    public static void test07() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/io/file_writer.txt", false);
        fileWriter.write("Hello，world！欢迎来到 java 世界\n");
        fileWriter.write("我来覆盖文件原本的内容");
        fileWriter.append("我是下一行");
        fileWriter.flush();
        System.out.println("文件的默认编码为" + fileWriter.getEncoding());
        fileWriter.close();
    }

    /**
     * 读取文件内容到内存,一次都一行
     * @throws IOException
     */
    public static void test08() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath()+"/io/file_writer.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();
    }

    /**
     * 读取文件内容到内存,每次读一个字符
     * @throws IOException
     */
    public static void test09() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath()+"/io/file_writer.txt");
        int c;
        while ((c = fileReader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    /**
     * OutputStreamWriter:可以指定编码
     * @throws IOException
     */
    public static void test10() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+"/io/test2.txt");
        // 使用 GBK 编码文件
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
        outputStreamWriter.write("Hello，world！\n欢迎来到 java 世界\n");
        outputStreamWriter.append("另外一行内容");
        outputStreamWriter.flush();
        System.out.println("文件的编码为" + outputStreamWriter.getEncoding());
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    /**
     * InputStreamReader:可以指定编码
     * @throws IOException
     */
    public static void test11() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/io/test2.txt");
        // 使用 GBK 解码文件
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
    }

    /**
     * 输入和输出都使用缓冲流
     * 结果：复制文件所需的时间：277
     * @throws IOException
     */
    public static void  test12() throws IOException {
        FileInputStream in = new FileInputStream("D:\\软件\\apache-activemq-5.12.0-bin.zip");
        BufferedInputStream inBuffer = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("activemq.zip");
        BufferedOutputStream outBuffer = new BufferedOutputStream(out);
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = inBuffer.read(bs)) != -1) {
            outBuffer.write(bs, 0, len);
        }
        System.out.println("复制文件所需的时间：" + (System.currentTimeMillis() - begin));
        inBuffer.close();
        in.close();
        outBuffer.close();
        out.close();
    }

    /**
     * 只有输入使用缓冲流
     * 结果：复制文件所需的时间：208
     * @throws IOException
     */
    public static void test13() throws IOException {
        FileInputStream in = new FileInputStream("D:\\软件\\apache-activemq-5.12.0-bin.zip");
        BufferedInputStream inBuffer = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("activemq.zip");
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = inBuffer.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin));
        inBuffer.close();
        in.close();
        out.close();
    }

    /**
     * 输入和输出都不使用缓冲流
     * 结果：复制文件所需的时间：301
     * @throws IOException
     */
    public static void test14() throws IOException {
        FileInputStream in = new FileInputStream("D:\\软件\\apache-activemq-5.12.0-bin.zip");
        FileOutputStream out = new FileOutputStream("activemq14.zip");
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin)); // 平均时间 700 多毫秒
        in.close();
        out.close();
    }

    /**
     * 不使用缓冲
     * 结果：复制文件所需的时间,226081
     * 不适应缓冲流太耗时间
     * @throws IOException
     */
    public static void test15() throws IOException {
        FileInputStream in = new FileInputStream("D:\\软件\\apache-activemq-5.12.0-bin.zip");
        FileOutputStream out = new FileOutputStream("activemq15.zip");
        int len = 0;
        long begin = System.currentTimeMillis();
        while ((len = in.read()) != -1) {
            out.write(len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin));
        in.close();
        out.close();
    }

}
