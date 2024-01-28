//
// Created by Dell on 2024/1/28.
//
#include <sstream>
#include <iostream>
#include "LogicMap.h"
#include "com_upchina_LogicMap.h"


int LogicMap::searchNodeByLatLng(double v1, double v2) {
    double r = v1 + v2;
    return static_cast<int>(r);
}

std::string LogicMap::describe() {
    std::cout << "name is : " << name << std::endl;
    std::stringstream ss;
    ss << "number is : " << number << " , name is : " << name << " !" << std::endl;
    return ss.str();
}


jlong getCppObj(JNIEnv *env, jobject obj) {
    // ��ȡ Java �������
    jclass clazz = (*env).GetObjectClass(obj);
    if (clazz == nullptr) {
        // �����쳣����
        jclass exceptionClass = (*env).FindClass("java/lang/RuntimeException");
        if (exceptionClass != nullptr) {
            // �׳��쳣
            (*env).ThrowNew(exceptionClass, "Failed to get class");
        }
        return -1;
    }

    // ��ȡ�ֶε� ID
    // ע�� "J" ��ʾ long ����
    jfieldID fieldId = (*env).GetFieldID(clazz, "ptr", "J");
    if (fieldId == nullptr) {
        // �����쳣����
        jclass exceptionClass = (*env).FindClass("java/lang/RuntimeException");
        if (exceptionClass != nullptr) {
            // �׳��쳣
            (*env).ThrowNew(exceptionClass, "Failed to get field ID");
        }
        return -1;
    }

    // ��ȡ�ֶε�ֵ
    jlong value = (*env).GetLongField(obj, fieldId);
    return value;
}


JNIEXPORT jlong JNICALL Java_com_upchina_LogicMap_create(JNIEnv *env, jobject obj, jint number, jstring name) {
    const char *cstr = env->GetStringUTFChars(name, nullptr);
    auto *ptr = new LogicMap(number, std::string(cstr));
    return reinterpret_cast<jlong>(ptr);
}

JNIEXPORT jint JNICALL Java_com_upchina_LogicMap_searchNodeByLatLng(JNIEnv *env, jobject obj, jdouble v1, jdouble v2) {

    jlong cppObj = getCppObj(env, obj);
    if (cppObj == -1) {
        return -1;
    }

    LogicMap *logicMapPtr = reinterpret_cast<LogicMap *>(cppObj);
    return logicMapPtr->searchNodeByLatLng(v1, v2);

}

JNIEXPORT jstring JNICALL Java_com_upchina_LogicMap_describe(JNIEnv *env, jobject obj) {

    jlong cppObj = getCppObj(env, obj);
    if (cppObj == -1) {
        return nullptr;
    }

    LogicMap *logicMapPtr = reinterpret_cast<LogicMap *>(cppObj);

    // ��C++��std::stringת��ΪC�ַ���
    const char *cString = logicMapPtr->describe().c_str();

    // ��C�ַ���ת��ΪJava�ַ���
    jstring r = (*env).NewStringUTF(cString);

    return r;

}