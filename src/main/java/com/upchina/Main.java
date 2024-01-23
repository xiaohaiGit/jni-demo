package com.upchina;

public class Main {
    static {
        // 打印下库路径，看下包含些什么，方便排错
        System.out.println("path : " + System.getProperty("java.library.path", "not lib path"));

        // 自定义库路径变量
        String myLibraryPath = System.getProperty("my_lib_path", "");

        // 加载库有两种方式
        // 1 通过库名
        // 2 通过库文件路径

        if (myLibraryPath.isEmpty()) {
            //通过库名
            System.loadLibrary("shawn");
        } else {
            // 通过库文件路径
            System.load(myLibraryPath);
        }


    }

    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.hello();
        hello.say();

    }
}