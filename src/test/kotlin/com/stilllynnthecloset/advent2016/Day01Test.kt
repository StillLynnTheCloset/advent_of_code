package com.stilllynnthecloset.advent2016

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day01Test {
    @Test
    fun exampleA() {
        assertEquals(0, day01a(readFile("2016/day01example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day01a(readFile("2016/day01input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day01b(readFile("2016/day01example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day01b(readFile("2016/day01input.txt")))
    }
}
