cmake_minimum_required(VERSION 3.19)

set(GMP_PATH ${CMAKE_CURRENT_LIST_DIR})

############################
# Definition for headers   #
############################
include_directories(${GMP_PATH}/${ANDROID_ABI})

############################
# Definition for libgmp    #
############################
add_library(gmp SHARED IMPORTED)
set_target_properties(gmp PROPERTIES IMPORTED_LOCATION ${GMP_PATH}/${ANDROID_ABI}/libgmp.so)

############################
# Definition for libgmpxx  #
############################
if(GMP_WITH_CPLUSPLUS STREQUAL "yes")
    add_library(gmpxx SHARED IMPORTED)
    set_target_properties(gmpxx PROPERTIES IMPORTED_LOCATION ${GMP_PATH}/${ANDROID_ABI}/libgmpxx.so)
endif()