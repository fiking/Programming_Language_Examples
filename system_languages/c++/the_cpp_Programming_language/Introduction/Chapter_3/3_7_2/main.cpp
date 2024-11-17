#include <iostream>
#include <vector>
#include <string>

using namespace std;

template <class T>
class Vec : public vector<T> {
public:
    Vec() : vector<T>() {}
    Vec(int s) : vector<T>(s) {}

    T &operator[](int i) {
        return this->at(i);
    }

    const T &operator[](int i) const {
        return this->at(i);
    }
};

struct Entry {
    string name;
    int number;
};

Vec<Entry> phone_book(1000);
void print_entry(int i) {
    cout << phone_book[i].name << ' ' << phone_book[i].number << '\n';
}

int main() {
    try {
        for (int i = 0; i < 10000; i++)
            print_entry(i);
    } catch (out_of_range) {
        cout << "range error\n";
    }
    return 0;
}