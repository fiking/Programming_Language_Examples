#include <iostream>
#include <list>
#include <string>

using namespace std;

struct Entry {
    string name;
    int number;
};

list<Entry> phone_book;
void print_entry(const string &s) {
    typedef list<Entry>::const_iterator LI;
    for (LI i = phone_book.begin(); i != phone_book.end(); ++i) {
        const Entry &e = *i;
        if (s == e.name) {
            cout << e.name << ' ' << e.number << '\n';
            return;
        }
    }
}

void add_entry(Entry &e, list<Entry>::iterator i) {
    phone_book.push_front(e);
    phone_book.push_back(e);
    phone_book.insert(i, e);
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}