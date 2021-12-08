package com.stilllynnthecloset.advent2021

import kotlin.math.abs

fun day07a(input: String): Pair<Int, Int> = input
    .parse()
    .testPossibilities(::costA)

fun day07b(input: String): Pair<Int, Int> = input
    .parse()
    .testPossibilities(::costB)

private fun String.parse(): List<Int> =
    split(',')
        .map { it.toInt() }

private fun List<Int>.testPossibilities(cost: (Int) -> Int): Pair<Int, Int> =
    (minOf { it }..maxOf { it }).map { it to findFuelUsage(it, cost) }.minByOrNull { it.second } ?: Pair(0, 0)

private fun List<Int>.findFuelUsage(target: Int, cost: (Int) -> Int): Int =
    sumOf { cost(abs(target - it)) }

private fun costA(distance: Int): Int = distance

private fun costB(distance: Int): Int = distance * (distance + 1) / 2
