package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day05Test {
    @Test
    fun exampleA() {
        assertEquals(5, day05a(readFile("2021/day05example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(4993, day05a(readFile("2021/day05input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(12, day05b(readFile("2021/day05example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(21101, day05b(readFile("2021/day05input.txt")))
    }
}
