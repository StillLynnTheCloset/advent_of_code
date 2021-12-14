package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day13Test {
    @Test
    fun exampleA() {
        assertEquals(17, day13a(readFile("2021/day13example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(675, day13a(readFile("2021/day13input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(16, day13b(readFile("2021/day13example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(98, day13b(readFile("2021/day13input.txt")))
    }
}
