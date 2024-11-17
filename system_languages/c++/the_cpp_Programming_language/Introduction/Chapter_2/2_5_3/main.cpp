#include <iostream>
#include "Stack.h"

Stack s_var1(10);

void f(Stack &s_ref, int i) {
    Stack s_var2(i);
    Stack *s_ptr = new Stack(20);

    s_var1.push('a');
    s_var2.push('b');
    s_ref.push('c');
    s_ptr->push('d');
}


int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}