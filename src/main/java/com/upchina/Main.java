package com.upchina;

import java.io.*;

public class Main {

    //g++ -shared -o ../../../src/main/resources/lib/logic.dll .\LogicMap.cpp -I"D:\development\jdk\jdk8\include" -I"D:\development\jdk\jdk8\include\win32" -std=c++11

    public static void main(String[] args) {

        LogicMap shawn = new LogicMap(1, "shawn");
        System.out.println(shawn.getPtr());
        System.out.println("r : " + shawn.searchNodeByLatLng(1.5, 2.5));
        System.out.println("r : " + shawn.describe());
    }

}
