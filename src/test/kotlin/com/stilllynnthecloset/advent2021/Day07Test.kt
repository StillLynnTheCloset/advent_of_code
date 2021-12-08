package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day07Test {
    @Test
    fun exampleA() {
        assertEquals(37, day07a(readFile("2021/day07example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(355150, day07a(readFile("2021/day07input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(168, day07b(readFile("2021/day07example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(98368490, day07b(readFile("2021/day07input.txt")))
    }
}
