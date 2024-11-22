cmake_minimum_required(VERSION 3.10)

project(multi-files)

set(SOURCE 
  add.cpp 
  sub.cpp
)

add_executable(multi-files main.cpp ${SOURCE})
