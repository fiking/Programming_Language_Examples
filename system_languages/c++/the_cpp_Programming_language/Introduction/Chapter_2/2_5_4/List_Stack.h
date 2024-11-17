//
// Created by fiking on 2022/9/2.
//

#ifndef INC_2_5_4_LIST_STACK_H
#define INC_2_5_4_LIST_STACK_H
#include "Stack.h"
#include <list>

class List_Stack : public Stack {
    std::list<char> lc;
public:
    List_Stack() {}

    void push(char c) { }
    char pop();
};
#endif //INC_2_5_4_LIST_STACK_H
