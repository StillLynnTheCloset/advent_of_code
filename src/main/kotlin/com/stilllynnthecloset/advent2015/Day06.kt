package com.stilllynnthecloset.advent2015


private enum class Action {
    On,
    Off,
    Toggle,
}

private data class Operation constructor(val action: Action, val top: Int, val left: Int, val bottom: Int, val right: Int)

private fun String.parse(): List<Operation> = split("\n")
    .mapNotNull {
        Regex("(.*?) ([0-9]*),([0-9]*) through ([0-9]*),([0-9]*)").matchEntire(it)?.let { match ->
            match.groupValues.let {
                Operation(
                    action = when (it[1]) {
                        "turn on" -> Action.On
                        "toggle" -> Action.Toggle
                        "turn off" -> Action.Off
                        else -> throw IllegalStateException(it.joinToString() + it[0])
                    },
                    top = it[2].toInt(),
                    left = it[3].toInt(),
                    bottom = it[4].toInt(),
                    right = it[5].toInt(),
                )
            }
        }
    }

fun day06a(input: String): Int = input
    .parse()
    .run {
        val lights = Array(1000) { IntArray(1000) { 0 } }
        forEach { lights.runOperationA(it) }
        lights
    }
    .sumOf { it.sum() }

private fun Array<IntArray>.runOperationA(operation: Operation) {
    when (operation.action) {
        Action.On -> iterate(operation) { v, h -> this[v][h] = 1 }
        Action.Off -> iterate(operation) { v, h -> this[v][h] = 0 }
        Action.Toggle -> iterate(operation) { v, h -> this[v][h] = if (this[v][h] == 1) 0 else 1 }
    }
}

private fun Array<IntArray>.iterate(operation: Operation, action: Array<IntArray>.(Int, Int) -> Unit) {
    (operation.top..operation.bottom).forEach { v -> (operation.left..operation.right).forEach { h -> action(v, h) } }
}

private fun Array<IntArray>.runOperationB(operation: Operation) {
    when (operation.action) {
        Action.On -> iterate(operation) { v, h -> this[v][h] = this[v][h] + 1 }
        Action.Off -> iterate(operation) { v, h -> this[v][h] = (this[v][h] - 1).coerceAtLeast(0) }
        Action.Toggle -> iterate(operation) { v, h -> this[v][h] = this[v][h] + 2 }
    }
}

fun day06b(input: String): Int = input
    .parse()
    .run {
        val lights = Array(1000) { IntArray(1000) { 0 } }
        forEach { lights.runOperationB(it) }
        lights
    }
    .sumOf { it.sum() }
