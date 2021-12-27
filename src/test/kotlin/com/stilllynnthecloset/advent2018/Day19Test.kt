package com.stilllynnthecloset.advent2018

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day19Test {
    @Test
    fun exampleA() {
        assertEquals(0, day19a(readFile("2018/day19example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day19a(readFile("2018/day19input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day19b(readFile("2018/day19example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day19b(readFile("2018/day19input.txt")))
    }
}
