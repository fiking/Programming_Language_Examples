func callee() {
  throw Exception("default error")
}

main() {
  try {
    callee()
  } catch(e: Exception) {
    return
  }
  return
}
