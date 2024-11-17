#include <stdio.h>
#include <Foundation/Foundation.h>

NSArray *callee(NSArray *a) {
  return a;
}

void caller() {
  NSArray *array = @[@"1", @"2", @"42"];
  NSDate * start = [NSDate date];
  
  for (int i=1; i<=10000000; i++) {
    NSArray *b = callee(array);
  }

  NSDate * end = [NSDate date];
  double timeTaken = [end timeIntervalSinceDate:start] * 1000;
  NSLog(@"%f", timeTaken);
}

int main(int argc, char *argv[]) {
  caller(); 
//  NSLog(@"hello Objective-C"); 
}
