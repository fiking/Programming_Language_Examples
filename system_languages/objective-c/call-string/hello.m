#include <stdio.h>
#include <Foundation/Foundation.h>

NSString *callee(NSString *a) {
  return a;
}

void caller() {
  NSString *a = @"ococc caller";
  NSDate * start = [NSDate date];
 
  for (int i=1; i<=10000000; i++) {
    NSString *b = callee(a);
  }

  NSDate * end = [NSDate date];
  double timeTaken = [end timeIntervalSinceDate:start] * 1000;
  NSLog(@"%f", timeTaken);
}

int main(int argc, char *argv[]) {
  caller(); 
//  NSLog(@"hello Objective-C"); 
}
