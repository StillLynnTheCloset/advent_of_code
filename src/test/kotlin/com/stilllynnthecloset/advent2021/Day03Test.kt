package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun exampleA() {
        assertEquals(198, day03a(readFile("2021/day3example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(4006064, day03a(readFile("2021/day3input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(230, day03b(readFile("2021/day3example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(5941884, day03b(readFile("2021/day3input.txt")))
    }
}
