
//
// Created by fiking on 2022/9/14.
//
#ifndef INC_2_7_1_STACK_H
#define INC_2_7_1_STACK_H
template<class T> class Stack {
    T *v;
    int max_size;
    int top;
public:
    class Underflow {};
    class Overflow {};

    Stack(int s) {}
    ~Stack() {}

    void push(T);
    T pop();
};

template<class T> void Stack<T>::push(T c) {
    if (top == max_size) throw Overflow();

    v[top] = c;
    top = top + 1;
}

template<class T> T Stack<T>::pop() {
    if (top == 0) throw Underflow();
    top = top - 1;
    return v[top];
}
#endif //INC_2_7_1_STACK_H
