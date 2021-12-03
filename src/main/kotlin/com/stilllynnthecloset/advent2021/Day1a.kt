package com.stilllynnthecloset.advent2021

fun day1a(input: String): Int = input
    .split("\n")
    .map { it.toInt() }
    .windowed(2) { it.first() < it.last() }
    .count { it }
