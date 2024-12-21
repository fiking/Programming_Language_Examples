#include <iostream>

class MyClass {
public:
  MyClass() {
    std::cout << "Myclass constructor!" << std::endl;
  }

  ~MyClass() {
    std::cout << "Myclass destructor!" << std::endl;
  }
};

void test() {
  auto *myClass = new MyClass();
  delete myClass;
}

int main() {
  std::cout << "run test!" << std::endl;
  test();
  std::cout << "run test end!" << std::endl;
  return 0;
}
