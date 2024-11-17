// clang hello.m -o hello -framework Foundation

#include <stdio.h>
#include <Foundation/Foundation.h>

int callee(int a) {
  return a;
}

void caller() {
  NSDate * start = [NSDate date];
  
  for (int i=1; i<=10000000; i++) {
    int b = callee(i);
  }

  NSDate * end = [NSDate date];
  double timeTaken = [end timeIntervalSinceDate:start] * 1000;
  NSLog(@"%f", timeTaken);
}

int main(int argc, char *argv[]) {
  caller(); 
//  NSLog(@"hello Objective-C"); 
}
