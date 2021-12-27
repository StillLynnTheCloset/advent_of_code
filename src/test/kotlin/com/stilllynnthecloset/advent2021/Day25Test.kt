package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day25Test {
    @Test
    fun exampleA() {
        assertEquals(0, day25a(readFile("2021/day25example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day25a(readFile("2021/day25input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day25b(readFile("2021/day25example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day25b(readFile("2021/day25input.txt")))
    }
}
