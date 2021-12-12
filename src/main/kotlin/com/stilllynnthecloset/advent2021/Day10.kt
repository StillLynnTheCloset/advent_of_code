package com.stilllynnthecloset.advent2021

fun day10a(input: String): Int = input
    .lines()
    .mapNotNull {
        it.findCorruptChar()
    }
    .sumOf { it.scoreA() }

private fun String.findCorruptChar(stack: List<Char> = emptyList()): Char? {
    return if (isEmpty()) {
        null
    } else {
        val last = stack.lastOrNull()
        val current = first()
        if (current.isOpen()) {
            drop(1).findCorruptChar(stack + current)
        } else if (last != null && isMatch(last, current)) {
            drop(1).findCorruptChar(stack.dropLast(1))
        } else {
            current
        }
    }
}

private val openChars = listOf('(', '[', '{', '<')
private fun Char.isOpen(): Boolean = this in openChars

private fun isMatch(open: Char, close: Char): Boolean = when (open) {
    '(' -> close == ')'
    '[' -> close == ']'
    '{' -> close == '}'
    '<' -> close == '>'
    else -> false
}

private fun Char.scoreA(): Int = when (this) {
    ')' -> 3
    ']' -> 57
    '}' -> 1197
    '>' -> 25137
    else -> throw IllegalStateException("Expecting close character, got $this")
}

fun day10b(input: String): Long = input
    .lines()
    .mapNotNull {
        it.findEndStack()?.reversed()?.score()
    }
    .sorted()
    .let { it[it.size / 2] }


private fun String.findEndStack(stack: List<Char> = emptyList()): List<Char>? {
    return if (isEmpty()) {
        stack
    } else {
        val last = stack.lastOrNull()
        val current = first()
        if (current.isOpen()) {
            drop(1).findEndStack(stack + current)
        } else if (last != null && isMatch(last, current)) {
            drop(1).findEndStack(stack.dropLast(1))
        } else {
            null // found corruption
        }
    }
}

private fun List<Char>.score(): Long = fold(0) { acc, c -> acc * 5L + c.scoreB() }

private fun Char.scoreB(): Int = when (this) {
    '(' -> 1
    '[' -> 2
    '{' -> 3
    '<' -> 4
    else -> throw IllegalStateException("Expecting open character, got $this")
}
