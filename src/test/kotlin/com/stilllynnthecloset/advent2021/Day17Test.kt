package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day17Test {
    @Test
    fun exampleA() {
        assertEquals(0, day17a(readFile("2021/day17example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day17a(readFile("2021/day17input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day17b(readFile("2021/day17example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day17b(readFile("2021/day17input.txt")))
    }
}
