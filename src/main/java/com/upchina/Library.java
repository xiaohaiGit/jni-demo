package com.upchina;

import java.io.*;

public class Library {

    public static void load(String name) {
        // ��ȡ��̬���ļ���·��
        // Windows ƽ̨�µĶ�̬���ļ���
        String libraryName = name + ".dll";

        // ��̬���ļ��� classpath �е�·��
        String libraryPath = "/lib/" + libraryName;

        // �� classpath �л�ȡ��̬���ļ���������
        InputStream inputStream = Library.class.getResourceAsStream(libraryPath);
        if (inputStream == null) {
            try {
                throw new Exception("Library not found in classpath: " + libraryName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // ������ʱ�ļ�
        // Windows ƽ̨�µĶ�̬���ļ���չ��
        File tempFile = null;
        try {
            tempFile = File.createTempFile(name + "TempLibFile", ".dll");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // �����˳�ʱɾ����ʱ�ļ�
        tempFile.deleteOnExit();

        // ����̬���ļ�д����ʱ�ļ�
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
        // ���ض�̬��
        System.load(absolutePath);
    }

}
