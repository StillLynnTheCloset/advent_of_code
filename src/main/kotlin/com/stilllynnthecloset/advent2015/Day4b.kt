package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.md5
import com.stilllynnthecloset.toHex
import java.security.MessageDigest

fun day4b(input: String): Int = input
    .let {
        val md = MessageDigest.getInstance("MD5")
        var index = 0
        while (true) {
            if (md.md5(input + index).toHex().startsWith("000000")) {
                break
            }
            index++
        }
        index
    }

