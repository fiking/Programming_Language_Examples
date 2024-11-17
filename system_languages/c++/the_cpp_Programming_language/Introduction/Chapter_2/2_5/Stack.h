//
// Created by fiking on 2022/8/28.
//

#ifndef INC_2_5_STACK_H
#define INC_2_5_STACK_H
struct Rep;

namespace Stack {
    struct Rep;
    typedef Rep& stack;

    stack create();
    void destroy(stack s);

    void push(stack s, char c);
    char pop(stack s);
};

#endif //INC_2_5_STACK_H
