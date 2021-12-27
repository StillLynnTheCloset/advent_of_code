package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day05Test {
    @Test
    fun exampleA() {
        assertEquals(0, day05a(readFile("2020/day05example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day05a(readFile("2020/day05input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day05b(readFile("2020/day05example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day05b(readFile("2020/day05input.txt")))
    }
}
