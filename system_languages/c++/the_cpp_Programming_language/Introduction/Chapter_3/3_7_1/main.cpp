#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct Entry {
    string name;
    int number;
};
Entry phone_book[1000];

void print_entry(int i) {
    cout << phone_book[i].name << ' ' << phone_book[i].number << '\n';
}

vector<Entry> phone_book_v(1000);
void print_entry_v(int i) {
    cout << phone_book_v[i].name << ' ' << phone_book_v[i].number << '\n';
}

void add_entries(int n) {
    phone_book_v.resize(phone_book_v.size() + n);
}

void f(vector<Entry> &v) {
    vector<Entry> v2 = phone_book_v;
    v = v2;
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}