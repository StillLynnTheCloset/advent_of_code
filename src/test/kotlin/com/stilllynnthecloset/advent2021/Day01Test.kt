package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day01Test {
    @Test
    fun exampleA() {
        assertEquals(7, day01a(readFile("2021/day01example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(1532, day01a(readFile("2021/day01input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(5, day01b(readFile("2021/day01example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(1571, day01b(readFile("2021/day01input.txt")))
    }
}
