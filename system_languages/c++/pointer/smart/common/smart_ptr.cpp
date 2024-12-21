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

  void Run() {
    std::cout << "Run ok!" << std::endl;
    std::cout << "data = " << data << std::endl;
  }

private:
  int data;
};

void TestUniquePtr() {
  std::cout << "Run TestUniquePtr" << std::endl;
  std::unique_ptr<MyClass> myclass = std::make_unique<MyClass>();
  myclass->Run();

  std::unique_ptr<MyClass> myclass1 = std::move(myclass);
  if (myclass == nullptr) {
    std::cout << "myclass is nullptr" << std::endl;
  }
  myclass1->Run();

  std::cout << "Run TestUniquePtr end" << std::endl;
}

void TestSharedPtr() {
  std::cout << "Run TestSharedPtr" << std::endl;

  std::shared_ptr<MyClass> myClass = std::make_shared<MyClass>();
  myClass->Run();

  std::cout << "Run TestSharedPtr middle" << std::endl;
  std::shared_ptr<MyClass> myClass1 = myClass;
  myClass1->Run();

  std::cout << "Run TestSharedPtr end" << std::endl;
}

void TestWeakPtr() {
  std::cout << "Run TestWeakPtr" << std::endl;

  std::shared_ptr<MyClass> myClass = std::make_shared<MyClass>();
  std::weak_ptr<MyClass> weakPtr(myClass);
  {
     auto ptr = weakPtr.lock();
     if (ptr != nullptr) {
       ptr->Run();
     } else {
       std::cout << "Object has been destroyed" << std::endl;
     }
  }

  myClass.reset();

  {
     auto ptr = weakPtr.lock();
     if (ptr != nullptr) {
       ptr->Run();
     } else {
       std::cout << "Object has been destroyed" << std::endl;
     }
  }
  std::cout << "Run TestWeakPtr end" << std::endl;
}

int main() {
  std::cout << "Run test!" << std::endl;
  TestUniquePtr();
  TestSharedPtr();
  TestWeakPtr();
  std::cout << "Run test end!" << std::endl;
  return 0;
}
