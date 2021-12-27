package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day24Test {
    @Test
    fun exampleA() {
        assertEquals(0, day24a(readFile("2020/day24example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day24a(readFile("2020/day24input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day24b(readFile("2020/day24example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day24b(readFile("2020/day24input.txt")))
    }
}
