cmake_minimum_required(VERSION 3.19)

set(GOALGO_PATH ${CMAKE_CURRENT_LIST_DIR})

############################
# Definition for headers   #
############################
include_directories(${GOALGO_PATH}/${ANDROID_ABI})

############################
# Definition for GOALGO    #
############################
add_library(goalgo SHARED IMPORTED)
set_target_properties(goalgo PROPERTIES IMPORTED_LOCATION ${GOALGO_PATH}/${ANDROID_ABI}/goalgo.so)