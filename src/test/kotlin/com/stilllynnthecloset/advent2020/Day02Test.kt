package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day02Test {
    @Test
    fun exampleA() {
        assertEquals(0, day02a(readFile("2020/day02example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day02a(readFile("2020/day02input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day02b(readFile("2020/day02example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day02b(readFile("2020/day02input.txt")))
    }
}
