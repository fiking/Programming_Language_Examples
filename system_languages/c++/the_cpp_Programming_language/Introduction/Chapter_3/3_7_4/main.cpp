#include <iostream>
#include <map>
#include <string>

using namespace std;

map<string, int> phone_book;
void print_entry(const string &s) {
    if (int i = phone_book[s])
        cout << s << ' ' << i << '\n';
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}