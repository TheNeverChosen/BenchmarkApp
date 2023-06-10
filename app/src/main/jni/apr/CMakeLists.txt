cmake_minimum_required(VERSION 3.19)

set(APR_PATH ${CMAKE_CURRENT_LIST_DIR})

############################
# Definition for headers   #
############################
include_directories(${APR_PATH}/${ANDROID_ABI}/include/apr-1)

############################
# Definition for APR       #
############################
add_library(apr SHARED IMPORTED)
#target_compile_options(apr INTERFACE -fexceptions -frtti)
set_target_properties(apr PROPERTIES IMPORTED_LOCATION ${APR_PATH}/${ANDROID_ABI}/lib/libapr-1.so)