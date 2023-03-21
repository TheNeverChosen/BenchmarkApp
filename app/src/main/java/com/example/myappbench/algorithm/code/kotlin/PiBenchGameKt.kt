package com.example.benchmarkapp.algorithm.code.kotlin

import java.math.BigInteger

class PiBenchGameKt {

    fun run(n: Int) {
        val L = 10
        var n = n
        var j = 0
        val digits = PiDigitSpigot()
        while (n > 0) {
            j += if (n >= L) {
                for (i in 0 until L) digits.next()
                L
            } else {
                for (i in 0 until n) print(digits.next())
                for (i in n until L) print(" ")
                n
            }
            print("\t:")
            println(j)
            n -= L
        }
    }


    internal class PiDigitSpigot {
        var z: Transformation
        var x: Transformation
        var inverse: Transformation

        init {
            z = Transformation(1, 0, 0, 1)
            x = Transformation(0, 0, 0, 0)
            inverse = Transformation(0, 0, 0, 0)
        }

        operator fun next(): Int {
            val y = digit()
            return if (isSafe(y)) {
                z = produce(y)
                y
            } else {
                z = consume(x.next())
                next()
            }
        }

        fun digit(): Int {
            return z.extract(3)
        }

        fun isSafe(digit: Int): Boolean {
            return digit == z.extract(4)
        }

        fun produce(i: Int): Transformation {
            return inverse.qrst(10, -10 * i, 0, 1).compose(z)
        }

        fun consume(a: Transformation): Transformation {
            return z.compose(a)
        }
    }

    internal class Transformation {
        var q: BigInteger
        var r: BigInteger
        var s: BigInteger
        var t: BigInteger
        var k: Int

        constructor(q: Int, r: Int, s: Int, t: Int) {
            this.q = BigInteger.valueOf(q.toLong())
            this.r = BigInteger.valueOf(r.toLong())
            this.s = BigInteger.valueOf(s.toLong())
            this.t = BigInteger.valueOf(t.toLong())
            k = 0
        }

        constructor(q: BigInteger, r: BigInteger, s: BigInteger, t: BigInteger) {
            this.q = q
            this.r = r
            this.s = s
            this.t = t
            k = 0
        }

        operator fun next(): Transformation {
            k++
            q = BigInteger.valueOf(k.toLong())
            r = BigInteger.valueOf((4 * k + 2).toLong())
            s = BigInteger.valueOf(0)
            t = BigInteger.valueOf((2 * k + 1).toLong())
            return this
        }

        fun extract(j: Int): Int {
            val bigj = BigInteger.valueOf(j.toLong())
            val numerator = q.multiply(bigj).add(r)
            val denominator = s.multiply(bigj).add(t)
            return numerator.divide(denominator).toInt()
        }

        fun qrst(q: Int, r: Int, s: Int, t: Int): Transformation {
            this.q = BigInteger.valueOf(q.toLong())
            this.r = BigInteger.valueOf(r.toLong())
            this.s = BigInteger.valueOf(s.toLong())
            this.t = BigInteger.valueOf(t.toLong())
            k = 0
            return this
        }

        fun compose(a: Transformation): Transformation {
            return Transformation(
                q.multiply(a.q),
                q.multiply(a.r).add(r.multiply(a.t)),
                s.multiply(a.q).add(t.multiply(a.s)),
                s.multiply(a.r).add(t.multiply(a.t))
            )
        }
    }
}