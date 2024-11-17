// cinterop -def hello.def -compiler-options -I.  -o hello
// kotlinc-native main.kt -library hello -o main

import hello.*
@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
fun main(args: Array<String>) {
  sayHello()

  var two = callint(2, 3);
  println(two);

  var struct = callstruct();
  println(struct);
}
