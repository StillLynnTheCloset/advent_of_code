package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day07Test {
    @Test
    fun exampleA() {
        assertEquals(0, day07a(readFile("2020/day07example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day07a(readFile("2020/day07input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day07b(readFile("2020/day07example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day07b(readFile("2020/day07input.txt")))
    }
}
