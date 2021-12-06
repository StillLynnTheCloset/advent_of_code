package com.stilllynnthecloset.advent2021

fun day06a(input: String): Long = input
    .split(',')
    .map { it.toInt() }
    .runSimulation(80)

fun day06b(input: String): Long = input
    .split(',')
    .map { it.toInt() }
    .runSimulation(256)


private fun List<Int>.runSimulation(days: Int): Long =
    groupBy { it }
        .let { groups ->
            LongArray(9)
                .also { array ->
                    groups.forEach {
                        array[it.key] = it.value.size.toLong()
                    }
                }
        }
        .let {
            (0 until days).fold(it) { acc, _ ->
                runDay(acc)
            }
        }
        .sumOf { it }

private fun runDay(fish: LongArray): LongArray = LongArray(9).also {
    it[0] = fish[1]
    it[1] = fish[2]
    it[2] = fish[3]
    it[3] = fish[4]
    it[4] = fish[5]
    it[5] = fish[6]
    it[6] = fish[7] + fish[0]
    it[7] = fish[8]
    it[8] = fish[0]
}
