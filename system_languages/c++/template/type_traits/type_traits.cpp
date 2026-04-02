#include <iostream>
#include <type_traits>

int main(){
    typedef std::integral_constant<int32_t, 33> int_value_33_t;
    typedef std::bool_constant<true> my_true_t;

    int_value_33_t test_value;

    std::cout << "int_value_33_t:" << int_value_33_t::value << "\tcoversion function:"
              << test_value << "\tcaller function:" << test_value() << std::endl;                                                                            

    std::cout << std::boolalpha;
    std::cout << "std::true_type:" << std::true_type::value << std::endl;
    std::cout << "std::true_type:" << std::false_type::value << std::endl;
    std::cout << "my_true_t:" << my_true_t::value << std::endl;

    return 0;
}
