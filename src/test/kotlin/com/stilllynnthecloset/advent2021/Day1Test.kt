package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {
    @Test
    fun exampleA() {
        assertEquals(7, day1a(readFile("2021/day1example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(1532, day1a(readFile("2021/day1input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(5, day1b(readFile("2021/day1example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(1571, day1b(readFile("2021/day1input.txt")))
    }
}
