#include <iostream>
#include "Shape.h"
#include <vector>

using namespace std;

void rotate_all(vector<Shape*> &v, int angle) {
    for (int i = 0; i < v.size(); ++i)
        v[i]->rotate(angle);
}
int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}