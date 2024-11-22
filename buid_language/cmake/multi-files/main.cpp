#include <iostream>

#include "arithmetic.h"

int main() {
  int a = 0;
  int b = 0;
  std::cin >> a >> b;
  int c = add(a, b);
  std::cout << " c = " << c << std::endl;
  int d = sub(a, b);
  std::cout << " d = " << d << std::endl;
  return 0;
}
