//
// Created by fiking on 2022/8/31.
//
#include "Stack.h"

Stack::Stack(int s) {
    top = 0;
    if (s < 0 || 10000 < s) throw Bad_size();
    max_size = s;
    v = new char(s);
}

Stack::~Stack() {
    delete[] v;
}

void Stack::push(char c) {
    if (top == max_size) throw Overflow();
    v[top] = c;
    top += 1;
}

char Stack::pop() {
    if (top == 0) throw Underflow();
    top = top - 1;
    return v[top];
}

