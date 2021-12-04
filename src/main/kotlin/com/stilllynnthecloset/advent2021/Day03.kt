package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.bitsToInt

fun day03a(input: String): Int = input
    .split("\n")
    .map { it.toList().map { it.digitToInt() } }
    .let { nums ->
        val total = nums.size
        val sums = nums.reduce { acc, list -> acc.zip(list) { a, b -> a + b } }
        val gamma = sums.map { if (it >= total / 2) 1 else 0 }.fold(0) {acc, i -> acc * 2 + i }
        val epsilon = sums.map { if (it >= total / 2) 0 else 1 }.fold(0) {acc, i -> acc * 2 + i }
        gamma * epsilon
    }

fun day03b(input: String): Int = input
    .split("\n")
    .let { nums ->
        val gamma = nums.filtering { mostCommonAtIndex(it) }
        val epsilon = nums.filtering { leastCommonAtIndex(it) }
        gamma.bitsToInt() * epsilon.bitsToInt()
    }

private fun List<String>.filtering(filter: List<String>.(Int) -> Char?): String {
    var remaining = this
    var index = 0
    while (remaining.size > 1) {
        val mostCommon = remaining.filter(index)
        remaining = remaining.filter { it[index] == mostCommon }
        index++
    }
    return remaining.first()
}

private fun List<String>.mostCommonAtIndex(index: Int): Char? = this
    .map { it[index] }
    .groupBy { it }
    .let { if (it.values.first().size == it.values.last().size) '1' else it.maxByOrNull { it.value.size }?.key }

private fun List<String>.leastCommonAtIndex(index: Int): Char? = this
    .map { it[index] }
    .groupBy { it }
    .let { if (it.values.first().size == it.values.last().size) '0' else it.minByOrNull { it.value.size }?.key }
