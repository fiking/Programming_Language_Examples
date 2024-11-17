//
// Created by fiking on 2022/9/12.
//

#ifndef INC_2_6_2_CIRCLE_H
#define INC_2_6_2_CIRCLE_H
#include "Shape.h"

class Circle : public Shape {
    int radius;
public:
    void draw() override {}
    void rotate(int) override {}
};
#endif //INC_2_6_2_CIRCLE_H
