package com.stilllynnthecloset.advent2021

fun day06a(input: String): Long = input
    .parse()
    .runSimulation(80)

fun day06b(input: String): Long = input
    .parse()
    .runSimulation(256)

private fun String.parse(): LongArray =
    split(',')
        .map { it.toInt() }
        .groupBy { it }
        .let { groups ->
            LongArray(9)
                .also { array ->
                    groups.forEach {
                        array[it.key] = it.value.size.toLong()
                    }
                }
        }

private tailrec fun LongArray.runSimulation(days: Int): Long =
    if (days == 0) sumOf { it } else runDay().runSimulation(days - 1)

private fun LongArray.runDay(): LongArray = LongArray(9).also { newArray ->
    newArray.indices.forEach { newArray[it] = this[(it + 1) % newArray.size] }
    newArray[6] += this[0]
}
