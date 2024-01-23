
#include <iostream>

#include "com_upchina_Hello.h"

void hello() {
    std::cout << "Hello, World!" << std::endl;
}

JNIEXPORT void JNICALL Java_com_upchina_Hello_hello
(JNIEnv *, jobject){
    hello();
}



//int main(){
//    JNICALL();
//    return 0;
//}

// g++ -shared -o shawn.dll .\library.cpp -I"D:\development\jdk\jdk8\include" -I"D:\development\jdk\jdk8\include\win32"