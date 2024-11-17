//
// Created by fiking on 2022/8/28.
//
#include "Stack.h"

namespace Stack {
    const int max_size = 200;

    struct Rep {
        char v[max_size];
        int top;
    };

    const int max = 16;

    Rep stacks[max];
    bool used[max];

    typedef Rep& stack;
};

void Stack::push(stack s, char c) {}

char Stack::pop(stack s) {}

Stack::stack Stack::create() {}

void Stack::destroy(Rep &s) {}


