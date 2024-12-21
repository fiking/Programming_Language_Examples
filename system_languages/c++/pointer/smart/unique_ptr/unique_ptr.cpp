#include <iostream>

class MyClass {
public:
  MyClass()
    : data(1) {
    std::cout << "Myclass constructor!" << std::endl;
  }

  ~MyClass() {
    std::cout << "Myclass destructor!" << std::endl;
  }

  void run() {
    std::cout << "run ok!" << std::endl;
    std::cout << "data = " << data << std::endl;
  }

private:
  int data;
};

void test1() {
  std::cout << "run test1" << std::endl;
  std::unique_ptr<MyClass> myclass = std::make_unique<MyClass>();
  myclass->run();
  std::cout << "run test1 end" << std::endl;
}

void test2() {
  std::cout << "run test2" << std::endl;
  std::unique_ptr<MyClass> myclass = std::make_unique<MyClass>();
  myclass->run();
  std::unique_ptr<MyClass> myclass1 = std::move(myclass);

  if (myclass == nullptr) {
    std::cout << "myclass is nullptr" << std::endl;
  }

  myclass1->run();

  std::cout << "run test2 end" << std::endl;
}

int main() {
  std::cout << "run test!" << std::endl;
  test1();
  test2();
  std::cout << "run test end!" << std::endl;
  return 0;
}
