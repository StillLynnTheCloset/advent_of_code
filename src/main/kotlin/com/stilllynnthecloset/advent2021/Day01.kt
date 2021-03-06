package com.stilllynnthecloset.advent2021

fun day01a(input: String): Int = input
    .split("\n")
    .map { it.toInt() }
    .windowed(2) { it.first() < it.last() }
    .count { it }

fun day01b(input: String): Int = input
    .split("\n")
    .map { it.toInt() }
    .windowed(3) { it.sum() } // Comment out for task 1
    .windowed(2) { it.first() < it.last() }
    .count { it }
