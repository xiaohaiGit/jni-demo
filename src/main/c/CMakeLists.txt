cmake_minimum_required(VERSION 3.22)
project(c)

set(CMAKE_CXX_STANDARD 11)

include_directories(.)
include_directories("D:\\development\\jdk\\jdk8\\include")
include_directories("D:\\development\\jdk\\jdk8\\include\\win32")

file(GLOB CPP_FILES *.cpp)

add_library(logic SHARED LogicMap.cpp)
set_target_properties(logic PROPERTIES PREFIX "")
