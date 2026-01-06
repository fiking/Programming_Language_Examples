#include <iostream>
using namespace std;

void func() {
    throw 42;  // 抛出异常
}

int main() {
    try {
//        func();
        throw 42;
    } catch (int e) {
        return 1;
//        cout << "Caught exception: " << e << endl;
    }
    return 0;
}

