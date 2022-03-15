package com.stilllynnthecloset

import okio.buffer
import okio.source
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest

data class Position constructor(val x: Int, val y: Int)

// Not Android safe.
fun readFile(path: String): String = Thread
    .currentThread()
    .contextClassLoader
    .getResourceAsStream(path)
    ?.source()
    ?.buffer()
    ?.readUtf8()
    .orEmpty()

fun Iterable<Int>.product(): Int = fold(1) { acc, i -> acc * i }

fun Iterable<Long>.product(): Long = fold(1) { acc, i -> acc * i }

fun MessageDigest.md5(str: String): ByteArray = digest(str.toByteArray(UTF_8))

fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }

fun String.bitsToInt() = fold(0) { acc, i -> acc * 2 + i.digitToInt() }

fun String.asBinary(): Int = Integer.parseInt(this, 2)

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

infix fun Int.rangeTo(other: Int): IntProgression =
    if (other > this) {
        IntProgression.fromClosedRange(other, this, -1)
    } else {
        IntProgression.fromClosedRange(other, this, 1)
    }

fun List<Int>.range(): IntRange = (minOf { it }..maxOf { it })

fun List<Long>.range(): LongRange = (minOf { it }..maxOf { it })

fun <T> List<List<T>>.gridOnEach(block: (x: Int, y: Int, value: T) -> Unit): List<List<T>> {
    this.indices.forEach { x ->
        this[x].indices.forEach { y ->
            block(x, y, this[x][y])
        }
    }
    return this
}

// Takes the values starting from the beginning up to and including the element for which predicate is false
inline fun <T> Iterable<T>.takeThrough(predicate: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()
    for (item in this) {
        list.add(item)
        if (predicate(item)) {
            break
        }
    }
    return list
}

fun <T : Any?> coalesce(vararg items: T?): T? {
    return items.firstOrNull { it != null }
}

fun <T : Collection<*>?> coalesceNotEmpty(vararg items: T?): T? {
    return items.firstOrNull { it != null && !it.isEmpty() }
}

fun <T : CharSequence?> coalesceNotBlank(vararg items: T?): T? {
    return items.firstOrNull { it != null && it.isNotBlank() }
}

fun String?.unlessBlank(): String? = this?.takeUnless { it.isBlank() }

/**
 *  Sum the elements in this list by the specified long field #selector and return Long which is the
 *  total sum of the field selector.
 */
inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    var sum = 0L
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

/**
 * We can't use `Map.forEach { key: K, value: V ->` on API < 24
 * So instead we will iterate through the pairs and manually de-structure them.
 *
 * @receiver The map through which to iterate.
 * @param K The type of keys in this map.
 * @param V The type of values in this map.
 * @param block The block of code to run for each entry pair in this map.
 */
inline fun <K, V> Map<K, V>.forEachPair(block: (K, V) -> Unit) {
    entries.forEach { (key, value) ->
        block(key, value)
    }
}

inline fun <K, V> List<Pair<K, V>>.forEachPair(block: (K, V) -> Unit) {
    forEach { (key, value) ->
        block(key, value)
    }
}

inline fun <reified R> Iterable<*>.firstInstance(): R {
    for (element in this) if (element is R) return element
    throw NoSuchElementException("Collection contains no element of the given type.")
}

inline fun <reified R> Iterable<*>.firstInstanceOrNull(): R? {
    for (element in this) if (element is R) return element
    return null
}

fun Iterable<Int?>.sumOrNull(): Int? {
    this.filterNotNull().ifEmpty { return null }
    return this.filterNotNull().sum()
}

fun Iterable<Double?>.sumOrNull(): Double? {
    this.filterNotNull().ifEmpty { return null }
    return this.filterNotNull().sum()
}

fun Iterable<Long?>.sumOrNull(): Long? {
    this.filterNotNull().ifEmpty { return null }
    return this.filterNotNull().sum()
}

fun Iterable<Float?>.sumOrNull(): Float? {
    this.filterNotNull().ifEmpty { return null }
    return this.filterNotNull().sum()
}

fun anyAreNotNull(vararg elements: Any?) = elements.any { it != null }

fun anyAreNotNullOrBlank(vararg elements: String?) = elements.any { !it.isNullOrBlank() }

fun allAreNotNullOrBlank(vararg elements: String?) = elements.all { !it.isNullOrBlank() }

inline fun <T> Iterable<T>.indexOfFirstOrNull(predicate: (T) -> Boolean): Int? = indexOfFirst(predicate).takeUnless { it == -1 }

inline fun <T> Iterable<T>.noneIndexed(predicate: (index: Int, T) -> Boolean): Boolean {
    forEachIndexed { index, element ->
        if (predicate(index, element)) { return false }
    }
    return true
}

fun <K, V> MutableMap<K, V>.putNotNull(pair: Pair<K, V?>) {
    pair.second?.also { this[pair.first] = it }
}

inline fun <T> MutableCollection<T>.addReplace(item: T, predicate: (T) -> Boolean): MutableCollection<T> {
    val match = find(predicate)
    if (match != null) {
        remove(match)
    }
    add(item)
    return this
}

inline fun <K, V, R : Any> Map<out K, V>.mapValuesNotNull(transform: (Map.Entry<K, V>) -> R?): Map<K, R> {
    return mapValues(transform).filterValuesNotNull()
}

fun <K, V : Any> Map<out K, V?>.filterValuesNotNull(): Map<K, V> {
    return mutableMapOf<K, V>().also {
        forEachPair { k, v ->
            if (v != null) {
                it[k] = v
            }
        }
    }
}

/**
 * Will compare two collections to make sure that all elements in @receiver are in @param [other], and visa versa
 */
fun <T> Collection<T>.contentsAreEqualWith(other: Collection<T>): Boolean {
    val receiverGroups = this.groupBy { it }
    val otherGroups = other.groupBy { it }
    return if (receiverGroups.size == otherGroups.size) {
        receiverGroups.all { (key, value) ->
            val matchingGroup = otherGroups[key]
            matchingGroup != null && matchingGroup.size == value.size
        }
    } else {
        false
    }
}

/**
 * Pick a random number in a range.
 * From:
 * https://stackoverflow.com/a/49507413
 */
fun ClosedRange<Int>.random(): Int = (Math.random() * ((endInclusive + 1) - start) + start).toInt()

fun capitalize(s: String?): String? {
    if (s == null || s.isEmpty()) {
        return s
    }
    val first = s[0]
    return if (Character.isUpperCase(first)) {
        s
    } else {
        first.uppercaseChar().toString() + s.substring(1)
    }
}