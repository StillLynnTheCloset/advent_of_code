package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day10Test {
    @Test
    fun exampleA() {
        assertEquals(0, day10a(readFile("2015/day10example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day10a(readFile("2015/day10input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day10b(readFile("2015/day10example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day10b(readFile("2015/day10input.txt")))
    }
}