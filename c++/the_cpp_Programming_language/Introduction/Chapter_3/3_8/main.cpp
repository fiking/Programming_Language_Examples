#include <iostream>
#include <vector>
#include <list>
#include <algorithm>
#include <string>
#include <complex>
#include <iterator>
#include <fstream>
#include <map>

using namespace std;

class Entry {
    int a;
public:
    bool operator==(Entry &e) {
        return a == e.a;
    }

    bool operator<(Entry &e) {
        return a < e.a;
    }
};

void f1(vector<Entry> &ve, list<Entry> &le) {
    sort(ve.begin(), ve.end());
    unique_copy(ve.begin(), ve.end(), le.begin());
}

void f2(vector<Entry> &ve, list<Entry> &le) {
    sort(ve.begin(), ve.end());
    unique_copy(ve.begin(), ve.end(), back_inserter(le));
}

int count(const string &s, char c) {
    int n = 0;
    string::const_iterator i = find(s.begin(), s.end(), c);
    while (i != s.end()) {
        ++n;
        i = find(i + 1, s.end(), c);
    }
    return n;
}

void f3() {
    string m = "Mary had a little lamb";
    int a_count = count(m, 'a');
}

template <class C, class T>
int count(const C &v, T val) {
    typename C::const_iterator i = find(v.begin(), v.end(), val);
    int n = 0;
    while (i != v.end()) {
        ++n;
        ++i;
        i = find(i, v.end(), val);
    }
    return n;
}

void f4(list<complex<int>> &lc, vector<string> &vs, string s) {
    int i1 = count(lc.begin(), lc.end(), complex<int>(1, 3));
    int i2 = count(vs.begin(), vs.end(), "Diogenes");
    int i3 = count(s.begin(), s.end(), 'x');
}

void g(char cs[], int sz) {
    int i1 = count(&cs[0], &cs[sz], 'z');
    int i2 = count(&cs[0], &cs[sz/2], 'z');
}

ostream_iterator<string> oo(cout);
int main_383_1() {
    *oo = "Hello, ";
    ++oo;
    *oo = "world!\n";
    return 0;
}

istream_iterator<string> ii(cin);
istream_iterator<string> eos;
int main_383_2() {
    string s1 = *ii;
    ++ii;
    string s2 = *ii;
    cout << s1 << ' ' << s2 << '\n';
    return 0;
}

int main_383_3() {
    string from, to;
    cin >> from >> to;

    ifstream is(from.c_str());
    istream_iterator<string> ii(is);
    istream_iterator<string> eos;

    vector<string> b(ii, eos);
    sort(b.begin(), b.end());

    ofstream os(to.c_str());
    ostream_iterator<string> oo(os, "\n");

    unique_copy(b.begin(), b.end(), oo);

    return !is.eof() || !os;
}

map<string, int> histogram;
void record(const string &s) {
    histogram[s]++;
}

void print(const pair<const string, int> &r) {
    cout << r.first << ' ' << r.second << '\n';
}

int main_383_4() {
    istream_iterator<string> ii;
    istream_iterator<string> eos;
    for_each(ii, eos, record);
    for_each(histogram.begin(), histogram.end(), print);
    return 0;
}

bool gt_42(const pair<const string, int> &r) {
    return r.second > 42;
}

void f(map<string, int> &m) {
    typedef map<string, int>::const_iterator MI;
    MI i = find_if(m.begin(), m.end(), gt_42);
}

void g(const map<string, int> &m) {
    int c42 = count_if(m.begin(), m.end(), gt_42);
}

class Shape {
public:
    void draw() {}
};

void draw(Shape *p) {
    p->draw();
}

void fpointer(list<Shape*> &sh) {
    for_each(sh.begin(), sh.end(), draw);
}

void gpointer(list<Shape*> &sh) {
    for_each(sh.begin(), sh.end(), mem_fun(&Shape::draw));
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}