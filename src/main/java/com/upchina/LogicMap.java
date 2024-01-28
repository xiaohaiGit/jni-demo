package com.upchina;

import java.io.*;

public class LogicMap {

    static {
        Library.load("logic");
        //Library.load("shawn");
    }

    private final long ptr;

    public LogicMap(int number, String name) {
        this.ptr = create(number, name);
    }

    public native long create(int number, String name);

    public native int searchNodeByLatLng(double v1, double v2);

    public native String describe();

    public long getPtr() {
        return ptr;
    }
}
