package com.stilllynnthecloset.advent2021

private data class Operation constructor(
    val action: Boolean,
    val x1: Int,
    val x2: Int,
    val y1: Int,
    val y2: Int,
    val z1: Int,
    val z2: Int,
)

private fun String.parse(): List<Operation> = split("\n")
    .mapNotNull {
        Regex("(.*?) x=(.*)\\.\\.(.*),y=(.*)\\.\\.(.*),z=(.*)\\.\\.(.*)").matchEntire(it)?.let { match ->
            match.groupValues.let {
                Operation(
                    action = when (it[1]) {
                        "on" -> true
                        "off" -> false
                        else -> throw IllegalStateException(it.joinToString() + it[0])
                    },
                    x1 = it[2].toInt(),
                    x2 = it[3].toInt(),
                    y1 = it[4].toInt(),
                    y2 = it[5].toInt(),
                    z1 = it[6].toInt(),
                    z2 = it[7].toInt(),
                )
            }
        }
    }

fun day23a(input: String): Int = input
    .parse()
    .limitToInitializationRegion()
    .run {
        val cubes = Array(101) { Array(101) { BooleanArray(101) { false } } }
        forEach { cubes.runOperation(it) }
        cubes
    }
    .sumOf { it.sumOf { it.count { it } } }

private fun List<Operation>.limitToInitializationRegion(): List<Operation> = this
    .onEach { println(it) }
    .filterNot {
        it.x1 > 50 ||
                it.x2 < -50 ||
                it.y1 > 50 ||
                it.y2 < -50 ||
                it.z1 > 50 ||
                it.z2 < -50
    }
    .onEach { println(it) }
    .map {
        Operation(
            action = it.action,
            x1 = it.x1.coerceAtLeast(-50).coerceAtMost(50) + 50,
            x2 = it.x2.coerceAtLeast(-50).coerceAtMost(50) + 50,
            y1 = it.y1.coerceAtLeast(-50).coerceAtMost(50) + 50,
            y2 = it.y2.coerceAtLeast(-50).coerceAtMost(50) + 50,
            z1 = it.z1.coerceAtLeast(-50).coerceAtMost(50) + 50,
            z2 = it.z2.coerceAtLeast(-50).coerceAtMost(50) + 50,
        )
    }

private fun Array<Array<BooleanArray>>.runOperation(operation: Operation) {
    iterate(operation) { x, y, z -> this[x][y][z] = operation.action }
}

private fun Array<Array<BooleanArray>>.iterate(
    operation: Operation,
    action: Array<Array<BooleanArray>>.(Int, Int, Int) -> Unit
) {
    (operation.x1..operation.x2).forEach { x ->
        (operation.y1..operation.y2).forEach { y ->
            (operation.z1..operation.z2).forEach { z ->
                action(
                    x,
                    y,
                    z
                )
            }
        }
    }
}

fun day23b(input: String): Int = input
    .parse()
    .size
