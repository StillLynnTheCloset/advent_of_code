package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.product

fun day2b(input: String): Int = input
    .split("\n")
    .sumOf { line ->
        val sides = line.split('x').map { it.toInt() }
        sides.product() + sides.sorted().dropLast(1).sum() * 2
    }
