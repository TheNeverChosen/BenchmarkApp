cmake_minimum_required(VERSION 3.18.1)

set(GMP_PATH ${CMAKE_CURRENT_LIST_DIR})

set(ANDROID_ABI arm64-v8a)

############################
# Definition for libgmp    #
############################
add_library(gmp SHARED IMPORTED)
set_target_properties(gmp PROPERTIES IMPORTED_LOCATION ${GMP_PATH}/${ANDROID_ABI}/libgmp.so)
set_target_properties(gmp PROPERTIES INTERFACE_INCLUDE_DIRECTORIES ${GMP_PATH}/${ANDROID_ABI})


############################
# Definition for libgmpxx  #
############################
if(GMP_WITH_CPLUSPLUS STREQUAL "yes")
    add_library(gmpxx SHARED IMPORTED)
    set_target_properties(gmpxx PROPERTIES IMPORTED_LOCATION ${GMP_PATH}/${ANDROID_ABI}/libgmpxx.so)
    set_target_properties(gmpxx PROPERTIES INTERFACE_INCLUDE_DIRECTORIES ${GMP_PATH}/${ANDROID_ABI})
endif()