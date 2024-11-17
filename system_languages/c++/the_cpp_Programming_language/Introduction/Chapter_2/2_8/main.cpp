#include <iostream>
#include <complex>
#include <vector>
#include <list>
//using namespace std;

template <class In, class Out> void copy1(In from, In too_far, Out to) {
    while (from != too_far) {
        *to = *from;
        ++to;
        ++from;
    }
}

char vc1[200];
char vc2[500];
void f() {
    copy1(&vc1[0], &vc1[200], &vc2[0]);
}

std::complex<float> ac[200];
void g(std::vector<std::complex<float>> &vc, std::list<std::complex<float>> &lc) {
    copy1(&ac[0], &ac[200], lc.begin());
    copy1(lc.begin(), lc.end(), vc.begin());
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}