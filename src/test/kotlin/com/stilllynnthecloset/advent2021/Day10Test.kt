package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day10Test {
    @Test
    fun exampleA() {
        assertEquals(26397, day10a(readFile("2021/day10example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(216297, day10a(readFile("2021/day10input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(288957, day10b(readFile("2021/day10example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(2165057169, day10b(readFile("2021/day10input.txt")))
    }
}
