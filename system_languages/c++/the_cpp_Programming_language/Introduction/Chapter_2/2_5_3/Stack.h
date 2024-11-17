//
// Created by fiking on 2022/8/31.
//

#ifndef INC_2_5_3_STACK_H
#define INC_2_5_3_STACK_H

class Stack {
    char *v;
    int top;
    int max_size;

public:
    class Underflow {};
    class Overflow {};
    class Bad_size {};

    Stack(int s);
    ~Stack();

    void push(char c);
    char pop();
};
#endif //INC_2_5_3_STACK_H
