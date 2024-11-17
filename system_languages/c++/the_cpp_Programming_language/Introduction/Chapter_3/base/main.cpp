#include <iostream>
#include <string>
#include <list>

std::string s = "Four legs Good: two legs Baaad!";
std::list<std::string> slogans;

using namespace std;
string ss = "Ignorance is bliss";

void f() {
    cout << 10;
}

void g() {
    int i = 10;
    cout << i;
}

void h(int i) {
    cout << "the value of i is";
    cout << i;
    cout << "\n";
}

void k() {
    cout << 'a';
    cout << 'b';
    cout << 'c';
}

void h2(int i) {
    cout << "the value of i is" << i << '\n';
}

string s1 = "Hello";
string s2 = "world";
void m1() {
    string s3 = s1 + ", " + s2 + "!\n";
    cout << s3;
}

void m2(string &s1, string &s2) {
    s1 = s1 + '\n';
    s2 += '\n';
}

string incantation;
void respond(const string &answer) {
    if (answer == incantation) {

    } else if (answer == "yes") {

    }
}

string name = "Niels Stroustrup";
void m3() {
    string s = name.substr(6, 10);
    name.replace(0, 5, "Nicholas");
}

void f1() {
    printf("name: %s\n", name.c_str());
}

int main() {
    std::cout << "Hello, World!\n";
    return 0;
}