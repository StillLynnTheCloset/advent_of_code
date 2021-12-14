package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day14Test {
    @Test
    fun exampleA() {
        assertEquals(1588, day14a(readFile("2021/day14example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(2375, day14a(readFile("2021/day14input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(2188189693529, day14b(readFile("2021/day14example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(1976896901756, day14b(readFile("2021/day14input.txt")))
    }
}
