package com.stilllynnthecloset.advent2015

fun day1a(input: String): Int =
    input.fold(0) { acc, c -> if (c == '(') acc + 1 else acc - 1 }
