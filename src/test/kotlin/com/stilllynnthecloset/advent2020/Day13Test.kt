package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day13Test {
    @Test
    fun exampleA() {
        assertEquals(0, day13a(readFile("2020/day13example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day13a(readFile("2020/day13input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day13b(readFile("2020/day13example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day13b(readFile("2020/day13input.txt")))
    }
}