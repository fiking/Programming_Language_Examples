//
// Created by fiking on 2022/9/12.
//

#ifndef INC_2_6_1_SHAPE_H
#define INC_2_6_1_SHAPE_H
enum Kind {
    circle,
    triangle,
    square,
};

class Point {};

class Color{};

class Shape {
    Kind k;
    Point center;
    Color col;

public:
    void draw();
    void rotate();
};
#endif //INC_2_6_1_SHAPE_H
