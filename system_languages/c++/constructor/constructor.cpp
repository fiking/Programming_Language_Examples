#include <iostream>

// 使用 __attribute__((constructor)) 修饰函数，使其在 main() 前执行
__attribute__((constructor(102)))
void before_main() {
    std::cout << "【第一步】：这个函数在 main() 执行之前被自动调用" << std::endl;
    std::cout << "          它不需要被手动调用，编译器会自动安排执行顺序" << std::endl;
}

__attribute__((constructor(0)))
void func_priority_102() {
    std::cout << "优先级 102：我是第二个执行的 constructor 函数" << std::endl;
}

// 普通的 main 函数（程序入口）
int main() {
    std::cout << "\n【第二步】：这是 main() 函数，程序的常规入口" << std::endl;
    return 0;
}

