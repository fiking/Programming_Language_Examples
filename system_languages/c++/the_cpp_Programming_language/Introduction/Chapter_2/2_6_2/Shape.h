//
// Created by fiking on 2022/9/12.
//

#ifndef INC_2_6_2_SHAPE_H
#define INC_2_6_2_SHAPE_H

class Point {};
class Color {};
class Shape {
    Point center;
    Color col;

public:
    Point where() {
        return center;
    }

    void move(Point to) {
        center = to;
        draw();
    }

    virtual void draw() = 0;
    virtual void rotate(int angle) = 0;
};
#endif //INC_2_6_2_SHAPE_H
