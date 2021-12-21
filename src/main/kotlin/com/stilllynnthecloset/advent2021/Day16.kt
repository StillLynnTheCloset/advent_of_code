package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.asBinary
import com.stilllynnthecloset.product
import com.stilllynnthecloset.takeThrough
import java.lang.Long.parseLong

sealed class Packet {
    abstract val version: Int
    abstract fun evaluate(): Long
}

data class ConstantPacket constructor(override val version: Int, val value: Long) : Packet() {
    override fun evaluate(): Long {
        return value
    }
}

sealed class OperatorPacket : Packet() {
    abstract val subPackets: List<Packet>
}

data class SumPacket constructor(
    override val version: Int,
    override val subPackets: List<Packet>,
) : OperatorPacket() {
    override fun evaluate(): Long = subPackets.sumOf { it.evaluate() }
}

data class ProductPacket constructor(
    override val version: Int,
    override val subPackets: List<Packet>,
) : OperatorPacket() {
    override fun evaluate(): Long = subPackets.map { it.evaluate() }.product()
}

data class MinimumPacket constructor(
    override val version: Int,
    override val subPackets: List<Packet>,
) : OperatorPacket() {
    override fun evaluate(): Long = subPackets.minOf { it.evaluate() }
}

data class MaximumPacket constructor(
    override val version: Int,
    override val subPackets: List<Packet>,
) : OperatorPacket() {
    override fun evaluate(): Long = subPackets.maxOf { it.evaluate() }
}

data class GreaterPacket constructor(
    override val version: Int,
    override val subPackets: List<Packet>,
) : OperatorPacket() {
    init {
        require(subPackets.size == 2) { "Boolean operation requires exactly 2 sub packets" }
    }

    override fun evaluate(): Long = if (subPackets.first().evaluate() > subPackets.last().evaluate()) 1 else 0
}

data class LessPacket constructor(
    override val version: Int,
    override val subPackets: List<Packet>,
) : OperatorPacket() {
    init {
        require(subPackets.size == 2) { "Boolean operation requires exactly 2 sub packets" }
    }

    override fun evaluate(): Long = if (subPackets.first().evaluate() < subPackets.last().evaluate()) 1 else 0
}

data class EqualPacket constructor(
    override val version: Int,
    override val subPackets: List<Packet>,
) : OperatorPacket() {
    init {
        require(subPackets.size == 2) { "Boolean operation requires exactly 2 sub packets" }
    }

    override fun evaluate(): Long = if (subPackets.first().evaluate() == subPackets.last().evaluate()) 1 else 0
}

fun day16a(input: String): Int = input
    .map { it.digitToInt(16) }
    .joinToString("") { String.format("%4s", Integer.toBinaryString(it)).replace(' ', '0') }
    .parsePacket()
    .first
    .sumVersions()


private fun String.parsePacket(): Pair<Packet, Int> {
    if (length < 6) {
        throw IllegalStateException("Packet too short: $this")
    }
    val version = take(3).asBinary()
    return when (val type = drop(3).take(3).asBinary()) {
        4 -> {
            val groups = drop(6)
                .windowed(5, step = 5)
                .toMutableList()
                .takeThrough { it.first() == '0' }

            val constVal = parseLong(groups.joinToString("") { it.drop(1) }, 2)
            ConstantPacket(version, constVal) to (6 + 5 * groups.size)

        }
        else -> {
            val lengthType = drop(6).first()

            val lengthTypeLength = if (lengthType == '0') 15 else 11
            val len = drop(7).take(lengthTypeLength).asBinary()

            val subPackets = if (lengthType == '0') {
                drop(7 + lengthTypeLength).parseSubPacketsLength(len)
            } else {
                drop(7 + lengthTypeLength).parseSubPacketsCount(len)
            }

            val packet = when (type) {
                0 -> SumPacket(version, subPackets.first)
                1 -> ProductPacket(version, subPackets.first)
                2 -> MinimumPacket(version, subPackets.first)
                3 -> MaximumPacket(version, subPackets.first)
                5 -> GreaterPacket(version, subPackets.first)
                6 -> LessPacket(version, subPackets.first)
                7 -> EqualPacket(version, subPackets.first)
                else -> throw IllegalStateException("Got a packet of type $type")
            }

            packet to (7 + lengthTypeLength + subPackets.second)
        }
    }
}

private fun String.parseSubPacketsCount(immediateChildCount: Int): Pair<List<Packet>, Int> {
    val packets = mutableListOf<Packet>()
    var totalLen = 0
    var currentString = this
    repeat(immediateChildCount) {
        val (packet, len) = currentString.parsePacket()
        currentString = currentString.drop(len)
        packets.add(packet)
        totalLen += len
    }

    return packets to totalLen
}

private fun String.parseSubPacketsLength(subPacketLength: Int): Pair<List<Packet>, Int> {
    val packets = mutableListOf<Packet>()
    var currentString = take(subPacketLength)
    while (currentString.isNotEmpty()) {
        try {
            val (packet, len) = currentString.parsePacket()
            currentString = currentString.drop(len)
            packets.add(packet)
        } catch (e: IllegalStateException) {
            // This is allowed to handle a partial packet
            break
        }
    }

    return packets to subPacketLength
}

private fun Packet.sumVersions(): Int = when (this) {
    is ConstantPacket -> version
    is OperatorPacket -> version + subPackets.sumOf { it.sumVersions() }
}

fun day16b(input: String): Long = input
    .map { it.digitToInt(16) }
    .joinToString("") { String.format("%4s", Integer.toBinaryString(it)).replace(' ', '0') }
    .parsePacket()
    .first
    .evaluate()
