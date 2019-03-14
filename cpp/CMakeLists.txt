cmake_minimum_required(VERSION 3.13)
project(cpp)

set(CMAKE_CXX_STANDARD 14)

add_executable(cpp src/main.cpp src/LiDAR.cpp src/LiDAR.h src/Sensor.cpp src/Sensor.h src/Rotator.cpp src/Rotator.h)