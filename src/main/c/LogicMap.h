//
// Created by Dell on 2024/1/28.
//

#ifndef C_LOGICMAP_H
#define C_LOGICMAP_H

#include <iostream>
#include <utility>

class LogicMap {
public:
    LogicMap(int number, std::string name) : number(number), name(std::move(name)) {
    };

    ~LogicMap() = default;

private:
    int number;
    std::string name;

public:
    int searchNodeByLatLng(double v1, double v2);

    std::string describe();
};


#endif //C_LOGICMAP_H
