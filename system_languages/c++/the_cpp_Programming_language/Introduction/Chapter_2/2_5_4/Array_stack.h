//
// Created by fiking on 2022/9/1.
//

#ifndef INC_2_5_4_ARRAY_STACK_H
#define INC_2_5_4_ARRAY_STACK_H

#include "Stack.h"

class Array_stack : public Stack {
    char *p;
    int max_size;
    int top;
public:
    Array_stack(int s) {}
    ~Array_stack() {}

    void push(char c) override {}
    char pop() override { return 'c'; }

};

#endif //INC_2_5_4_ARRAY_STACK_H
