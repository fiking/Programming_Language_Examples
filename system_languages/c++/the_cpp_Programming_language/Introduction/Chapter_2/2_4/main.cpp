#include <iostream>
#include "Stack.h"

using namespace std;

void f() {
    Stack::push('c');
    if (Stack::pop() != 'c') perror("impossible");
}

void f1() {
    try {
        while (true) Stack::push('c');
    } catch (Stack::Overflow) {

    }
}
int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}