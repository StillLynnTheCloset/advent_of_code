package com.stilllynnthecloset.advent2021

fun day3a(input: String): Int = input
    .split("\n")
    .map { it.toList().map { it.digitToInt() } }
    .let { nums ->
        val total = nums.size
        val sums = nums.reduce { acc, list -> acc.zip(list) { a, b -> a + b } }
        val gamma = sums.map { if (it >= total / 2) 1 else 0 }.fold(0) {acc, i -> acc * 2 + i }
        val epsilon = sums.map { if (it >= total / 2) 0 else 1 }.fold(0) {acc, i -> acc * 2 + i }
        gamma * epsilon
    }

