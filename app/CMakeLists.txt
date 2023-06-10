# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.
set(CMAKE_CXX_STANDARD 17)
cmake_minimum_required(VERSION 3.19)

# Declares and names the project.

project("urutauappfinal")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

# GMP
set(JNI_LIBS_PATH src/main/jni)
set(GMP_WITH_CPLUSPLUS yes)
include(${JNI_LIBS_PATH}/gmp/CMakeLists.txt)
include(${JNI_LIBS_PATH}/boost/CMakeLists.txt)
include(${JNI_LIBS_PATH}/apr/CMakeLists.txt)
#===================================================================

# Benchmark Codes
set(DIR_SRC_C src/main/c)
add_library( # Sets the name of the library.
        bench_c

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ${DIR_SRC_C}/c_binarytrees.c
        ${DIR_SRC_C}/c_pidigits.c
        ${DIR_SRC_C}/c_fannkuch.c
        ${DIR_SRC_C}/c_nbody.c
        ${DIR_SRC_C}/c_fasta.c)

set(DIR_SRC_CPP src/main/cpp)
add_library( # Sets the name of the library.
        bench_cpp

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ${DIR_SRC_CPP}/cpp_pidigits.cpp
        ${DIR_SRC_CPP}/cpp_binarytrees.cpp
        ${DIR_SRC_CPP}/cpp_fannkuch.cpp
        ${DIR_SRC_CPP}/cpp_nbody.cpp
        ${DIR_SRC_CPP}/cpp_fasta.cpp)

#===================================================================

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

#C LIB
target_link_libraries( # Specifies the target library.
        bench_c

        PRIVATE

        # Links the target library to the log library
        # included in the NDK.
        log gmp apr)

#CPP LIB
target_link_libraries(
        bench_cpp
        PRIVATE
        log gmp boost_container)

add_library( # Sets the name of the library.
        urutauappfinal

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        src/main/cpp/native-lib.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        urutauappfinal

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})