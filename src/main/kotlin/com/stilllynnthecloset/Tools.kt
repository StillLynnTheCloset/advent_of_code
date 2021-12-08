package com.stilllynnthecloset

import okio.buffer
import okio.source
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest

data class Position constructor(val x: Int, val y: Int)

fun readFile(path: String): String = Thread
    .currentThread()
    .contextClassLoader
    .getResourceAsStream(path)
    ?.source()
    ?.buffer()
    ?.readUtf8()
    .orEmpty()

fun Iterable<Int>.product(): Int = fold(1) { acc, i -> acc * i }

fun MessageDigest.md5(str: String): ByteArray = digest(str.toByteArray(UTF_8))

fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }

fun String.bitsToInt() = fold(0) { acc, i -> acc * 2 + i.digitToInt() }

inline fun <T> Iterable<T>.anyIndexed(predicate: (Int, T) -> Boolean): Boolean {
    var index = 0
    if (this is Collection && isEmpty()) return false
    for (element in this) if (predicate(index++, element)) return true
    return false
}

inline fun <T> Iterable<T>.allIndexed(predicate: (Int, T) -> Boolean): Boolean {
    var index = 0
    if (this is Collection && isEmpty()) return true
    for (element in this) if (!predicate(index++, element)) return false
    return true
}

fun intProgression(a: Int, b: Int): IntProgression =
    if (a > b) {
        IntProgression.fromClosedRange(a, b, -1)
    } else {
        IntProgression.fromClosedRange(a, b, 1)
    }

fun List<Int>.range(): IntRange = (minOf { it }..maxOf { it })

fun List<Long>.range(): LongRange = (minOf { it }..maxOf { it })
