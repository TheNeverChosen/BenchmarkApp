#include <jni.h>

#include <stdlib.h>
#include <stdio.h>


JNIEXPORT jint JNICALL
Java_com_example_myappbench_MainActivity_cpidigits(JNIEnv *env, jobject thiz, jint num) {
    return num;
}