package com.stilllynnthecloset.advent2015

fun day1b(input: String): Int =
    input.runningFold(0) { acc, c -> if (c == '(') acc + 1 else acc - 1 }.indexOfFirst { it == -1 }// + 1
