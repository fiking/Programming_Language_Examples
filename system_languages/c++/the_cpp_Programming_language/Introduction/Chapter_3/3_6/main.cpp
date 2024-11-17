#include <iostream>
using namespace std;

void f() {
    int i;
    cin >> i;

    double d;
    cin >> d;
}

int main() {
    const float factor = 2.54;
    float x, in, cm;
    char ch = 0;

    cout << "enter length: ";

    cin >> x;
    cin >> ch;

    switch (ch) {
        case 'i':
            in = x;
            cm = x * factor;
            break;
        case 'c':
            in =  x / factor;
            cm = x;
            break;
        default:
            in = cm = 0;
            break;
    }
    cout << in << "in = " << cm << "cm\n";

    string str;
    cout << "Please enter your name\n";
    cin >> str;
    cout << "Hello, " << str << "!\n";

    cout << "Please enter your name\n";
    getline(cin, str);
    cout << "Hello, " << str << "!\n";
    return 0;
}
