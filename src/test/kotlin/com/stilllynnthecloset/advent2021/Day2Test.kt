package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day2Test {
    @Test
    fun exampleA() {
        assertEquals(150, day2a(readFile("2021/day2example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(1727835, day2a(readFile("2021/day2input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(900, day2b(readFile("2021/day2example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(1544000595, day2b(readFile("2021/day2input.txt")))
    }
}
