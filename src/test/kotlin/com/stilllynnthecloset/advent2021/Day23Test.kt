package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day23Test {
    @Test
    fun exampleA() {
        assertEquals(590784, day23a(readFile("2021/day23example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(576028, day23a(readFile("2021/day23input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(34220375, day23b(readFile("2021/day23example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(34220375, day23b(readFile("2021/day23input.txt")))
    }
}
