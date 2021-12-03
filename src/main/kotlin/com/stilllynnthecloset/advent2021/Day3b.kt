package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.bitsToInt

fun day3b(input: String): Int = input
    .split("\n")
    .let { nums ->
        val gamma = nums.filtering { mostCommonAtIndex(it) }
        val epsilon = nums.filtering { leastCommonAtIndex(it) }
        gamma.bitsToInt() * epsilon.bitsToInt()
    }

fun List<String>.filtering(filter: List<String>.(Int) -> Char?): String {
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
