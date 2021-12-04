package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day4Test {
    @Test
    fun exampleA() {
        assertEquals(4512, day4a(readFile("2021/day4example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(72770, day4a(readFile("2021/day4input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(1924, day4b(readFile("2021/day4example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(13912, day4b(readFile("2021/day4input.txt")))
    }
}
