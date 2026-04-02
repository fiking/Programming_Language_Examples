// 自定义异常
class InvalidAgeException(message: String) : Exception(message)

fun checkAge(age: Int): String {
   throw Exception("default error")
}

fun checkAge2(age: Int): String {
    checkAge(age)
    return "ok"
}

fun main() {
    try {
        val result = checkAge(16)
    } catch (e: Exception) {
	return;
    }
    return;
}

