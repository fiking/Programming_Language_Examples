// cmake .
// make

#include <iostream>

using namespace std;

double sqrt(double arg) {

}

void f() {
    double root2 = sqrt(2);
}

void some_function() {
    double d = 2.2;
    int i = 7;
    d = d + i;
    i = d * i;
}

bool accept()
{
    cout << "Do you want to proceed(y or n)?\n";

    char answer = 0;
    cin >> answer;

    if (answer == 'y') return true;
    return false;
}

bool accept2() {
    cout << "Do you want to proceed (y or n) ?\n";

    char answer = 0;
    cin >> answer;

    switch (answer) {
        case 'y':
            return true;
        case 'n':
            return false;
        default:
            cout << "I'll take that for a no. \n";
            return false;
    }
}

bool accept3() {
    int tries = 1;
    while (tries < 4) {
        cout << "Do you want to proceed (y or n) ?\n";
        char answer = 0;
        cin >> answer;
        switch (answer) {
            case 'y':
                return true;
            case 'n':
                return false;
            default:
                cout << "Sorry I don't understand that.\n";
                tries = tries + 1;
        }
    }
    cout << "I'll take that for a no.\n";
    return false;
}

void another_function() {
    int v1[10];
    int v2[10];

    for (int i = 0; i < 10; ++i) v1[i] = v2[i];
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
