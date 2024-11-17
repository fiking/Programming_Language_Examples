//
// Created by fiking on 2022/9/1.
//

#ifndef INC_2_5_4_STACK_H
#define INC_2_5_4_STACK_H

class Stack {
public:
    class Underflow {};
    class Overflow {};

    virtual void push(char c) = 0;
    virtual char pop() = 0;
};

class Bad_pop {};

static void f(Stack &s_ref) {
    s_ref.push('c');
    if (s_ref.pop() != 'c') throw Bad_pop();
}

#endif //INC_2_5_4_STACK_H
