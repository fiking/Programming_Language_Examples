// kotlinc-native hello.kt

fun callint(a: Int): Int {
  var ba = a + 1;
  return ba;
}

fun main() {
  println("hello kotlin/native!")
  
  var ret = callint(1);
  println(ret);
}
