//
// Created by fiking on 2022/9/3.
//
#include "List_Stack.h"
char List_Stack::pop() {
    char x = lc.front();
    lc.pop_front();
    return x;
}

void h() {
    List_Stack ls;
    f(ls);
}
