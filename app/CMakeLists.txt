
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.19)
set(CMAKE_CXX_STANDARD 17)

# Declares and names the project.

project("myappbench")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

# GMP
set(JNI_LIBS_PATH src/main/jni)
set(GMP_WITH_CPLUSPLUS yes)
include(${JNI_LIBS_PATH}/gmp/CMakeLists.txt)
#===================================================================

# Benchmark Codes
set(DIR_SRC_C src/main/c)
add_library( # Sets the name of the library.
        bench_c

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ${DIR_SRC_C}/c_binarytree.c
        ${DIR_SRC_C}/c_pidigits.c
        ${DIR_SRC_C}/c_fannkuch.c
        ${DIR_SRC_C}/c_nbody.c)

set(DIR_SRC_CPP src/main/cpp)
add_library( # Sets the name of the library.
        bench_cpp

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ${DIR_SRC_CPP}/cpp_pidigits.cpp
        ${DIR_SRC_CPP}/cpp_binarytree.cpp
        ${DIR_SRC_CPP}/cpp_fannkuch.cpp
        ${DIR_SRC_CPP}/cpp_nbody.cpp)
#===================================================================

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        bench_c

        PRIVATE

        # Links the target library to the log library
        # included in the NDK.
        log gmp)

target_link_libraries( # Specifies the target library.
        bench_cpp

        PRIVATE

        # Links the target library to the log library
        # included in the NDK.
        log gmpxx gmp)
