#include <jni.h>

//
// Created by ricardofilho on 06/02/2023.
//

#include <stdio.h>
#include <stdlib.h>


JNIEXPORT jint JNICALL
Java_com_example_myappbench_MainActivity_cpidigits(JNIEnv *env, jobject thiz, jint num) {
    return num;
}