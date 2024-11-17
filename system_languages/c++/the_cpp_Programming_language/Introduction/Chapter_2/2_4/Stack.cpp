//
// Created by fiking on 2022/8/24.
//
#include "Stack.h"

namespace Stack {
    const int max_size = 200;
    char v[max_size];
    int top = 0;
}

void Stack::push(char c) {
    if (top == max_size) throw Overflow{};
}

char Stack::pop() { return '0'; }
