package com.stilllynnthecloset

import okio.buffer
import okio.source
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest

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

fun String.bitsToInt() = fold(0) {acc, i -> acc * 2 + i.digitToInt() }