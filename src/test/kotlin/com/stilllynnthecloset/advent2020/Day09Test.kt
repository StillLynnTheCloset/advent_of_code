package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day09Test {
    @Test
    fun exampleA() {
        assertEquals(0, day09a(readFile("2020/day09example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day09a(readFile("2020/day09input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day09b(readFile("2020/day09example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day09b(readFile("2020/day09input.txt")))
    }
}