//
// Created by fiking on 2022/8/31.
//

#ifndef INC_2_5_COMPLEX_H
#define INC_2_5_COMPLEX_H

class complex {
    double re, im;
public:
    complex(double r, double i) { re = r; im = i; }
    complex(double r) { re = r; im = 0; }
    complex() { re = im = 0; }

    friend complex operator+(complex, complex);
    friend complex operator-(complex, complex);
    friend complex operator-(complex);
    friend complex operator*(complex, complex);
    friend complex operator/(complex, complex);

    friend bool operator==(complex, complex);
    friend bool operator!=(complex, complex);
};

complex operator+(complex a1, complex a2) {
    return complex(a1.re + a2.re, a1.im + a2.im);
}

void f(complex z) {
    complex a = 2.3;
    complex b = 1/a;
    complex c = a + b * complex(1, 2.3);

    if (c != b) c = -(b / a) + 2 * b;
}

#endif //INC_2_5_COMPLEX_H
