#include <jni.h>
#include <string>

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_myappbench_MainActivity_cppidigits(JNIEnv *env, jobject thiz, jint num) {

        int n = num;

        // Define a precisão da computação
        long double a = 1.0L;
        long double b = 1.0L / sqrtl(2.0L);
        long double t = 0.25L;
        long double p = 1.0L;

        // Realiza iterações do método de Gauss-Legendre
        for (int i = 0; i < n; i++) {
            long double a_new = (a + b) / 2.0L;
            long double b_new = sqrtl(a * b);
            long double t_new = t - p * powl(a - a_new, 2.0L);
            long double p_new = 2.0L * p;

            a = a_new;
            b = b_new;
            t = t_new;
            p = p_new;
        }

        // Calcula o valor final de Pi
        long double pi = powl(a + b, 2.0L) / (4.0L * t);

        // Imprime o resultado com n dígitos de precisão
        printf("%.*Lf\n", n, pi);

        return 0;
}