#include <algorithm>
#include <cinttypes>
#include <cstddef>
#include <cstdint>
#include <tuple>

#include <iostream>

template <typename T>
constexpr T AlignUp(T size, T alignment) {
    return (size + alignment - 1) & ~(alignment - 1);
}

inline void* AlignUp(void* ptr, size_t alignment) {
    static_assert(sizeof(void*) == sizeof(size_t), "size_t size must be equal to pointer size for this to work");
    return reinterpret_cast<void*>(AlignUp(reinterpret_cast<size_t>(ptr), alignment));
}

namespace type_layout {
namespace internal {
template <typename T, typename = void>
struct has_descriptor : std::false_type {};

template <typename T>
struct has_descriptor<T, std::void_t<typename T::descriptor>> : std::true_type {};

template <typename... FieldDescriptors>
constexpr size_t alignment(FieldDescriptors... fieldDescriptors) noexcept {
  if constexpr (sizeof...(FieldDescriptors) == 0) {
    return 1;
  } else {
    return [](auto head, auto... tail) constexpr noexcept { return std::max(head.alignment(), alignment(tail...)); }
    (fieldDescriptors...);
  }
}
} // internal

template <typename T, bool = internal::has_descriptor<T>::value>
struct descriptor {
  using type = typename T::descriptor;
};

template <typename T>
struct descriptor<T, false> {
  struct type {
    using value_type = T;
    static constexpr size_t alignment() noexcept {
      std::cout << "align = " << alignof(T) << std::endl;
      return alignof(T); 
    }
    static constexpr size_t size() noexcept { return sizeof(T) == 0 ? 0 : AlignUp(sizeof(T), alignment());}
    static constexpr value_type* construct(uint8_t* ptr) noexcept { return new (ptr) T(); }
  };
};

template <typename T>
using descriptor_t = typename descriptor<T>::type;

template <typename T, typename... Fields>
class Composite {
public:
  using value_type = T;
  constexpr Composite() noexcept = default;
  constexpr explicit Composite(descriptor<Fields>::type... fields) noexcept : fields_(fields...) {}
  constexpr size_t alignment() const noexcept {
    std::cout << "Composite Fields alignment" << std::endl;
    return std::apply(internal::alignment<descriptor_t<Fields>...>, fields_); 
  }
private:
  std::tuple<descriptor_t<Fields>...> fields_;
};


template<typename T>
class Composite<T> {
public:
  using value_type = T;

  constexpr Composite() noexcept = default;

  constexpr size_t alignment() const noexcept {
    std::cout << "Composite alignment" << std::endl;
    return 1;
  }
  constexpr size_t size() const noexcept { return 0; }
  constexpr value_type* construct(uint8_t* ptr) noexcept {}

  template <size_t index>
  constexpr uint64_t fieldOffset() const noexcept {
    static_assert(index == 0);
    return 0;
  }
};

} // type_layout



// ======================================================= //

struct TEmpty {
  using descriptor = type_layout::Composite<TEmpty>;
};

struct T323232 {
  using descriptor = type_layout::Composite<T323232, int32_t, int32_t, int32_t>;

//  int32_t f0;
//  int32_t f1;
//  int32_t f2;
};

int main() {
  if (type_layout::descriptor_t<TEmpty>().alignment() == alignof(TEmpty)) {
    std::cout << "type_layout if" << std::endl;
  } else {
    std::cout << "type_layout else" << std::endl;
  }

  if (type_layout::descriptor_t<T323232>().alignment() == alignof(type_layout::descriptor_t<T323232>::value_type)) {
    std::cout << "T323232 if" << std::endl;
  } else {
    std::cout << "T323232 else" << std::endl;
  }
  return 0;
}
