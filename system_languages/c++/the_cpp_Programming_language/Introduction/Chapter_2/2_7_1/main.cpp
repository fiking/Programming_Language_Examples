#include <iostream>
#include "Stack.h"
#include <list>
#include <complex>

using namespace std;

class Bad_pop {};
Stack<char> sc(200);
Stack<complex<float>> scplx(30);
Stack<list<int>> sli(45);

void f() {
    sc.push('c');
    if (sc.pop() != 'c') throw Bad_pop();

    scplx.push(complex<float>(1,2));
    if (scplx.pop() != complex<float >(1,2)) throw Bad_pop();
}
int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}