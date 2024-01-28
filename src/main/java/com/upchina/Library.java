package com.upchina;

import java.io.*;

public class Library {

    public static void load(String name) {
        // 获取动态库文件的路径
        // Windows 平台下的动态库文件名
        String libraryName = name + ".dll";

        // 动态库文件在 classpath 中的路径
        String libraryPath = "/lib/" + libraryName;

        // 从 classpath 中获取动态库文件的输入流
        InputStream inputStream = Library.class.getResourceAsStream(libraryPath);
        if (inputStream == null) {
            try {
                throw new Exception("Library not found in classpath: " + libraryName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // 创建临时文件
        // Windows 平台下的动态库文件扩展名
        File tempFile = null;
        try {
            tempFile = File.createTempFile(name + "TempLibFile", ".dll");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 程序退出时删除临时文件
        tempFile.deleteOnExit();

        // 将动态库文件写入临时文件
        try (OutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String absolutePath = tempFile.getAbsolutePath();
        // 加载动态库
        System.load(absolutePath);
    }

}
