// run command: 
//   dart cfg.dart

int daicfg(int a, int b, int c) {
  for (int i = 0; i < c; i++) {
    a = b * c;
    if (a > b) {
      a = c - i;
    }
  }
  return a; 
}

void main() {
  int a = 1;
  int b = 2;
  int c = 3;
  c = daicfg(a, b, c);
  print(c);
  print("Hello, World!");
}
