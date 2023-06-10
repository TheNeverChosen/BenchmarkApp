cmake_minimum_required(VERSION 3.19)

set(BOOST_PATH ${CMAKE_CURRENT_LIST_DIR})

############################
# Definition for headers   #
############################
include_directories(${BOOST_PATH}/${ANDROID_ABI}/include/boost-1_82)

############################
# Definition for container     #
############################
add_library(boost_container STATIC IMPORTED)
target_compile_options(boost_container INTERFACE -fexceptions -frtti)
set_target_properties(boost_container PROPERTIES IMPORTED_LOCATION ${BOOST_PATH}/${ANDROID_ABI}/lib/libboost_container-clang-mt-1_82.a)