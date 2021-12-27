package com.stilllynnthecloset.advent2019

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day15Test {
    @Test
    fun exampleA() {
        assertEquals(0, day15a(readFile("2019/day15example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day15a(readFile("2019/day15input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day15b(readFile("2019/day15example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day15b(readFile("2019/day15input.txt")))
    }
}