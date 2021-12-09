package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day09Test {
    @Test
    fun exampleA() {
        assertEquals(15, day09a(readFile("2021/day09example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(423, day09a(readFile("2021/day09input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(1134, day09b(readFile("2021/day09example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(1198704, day09b(readFile("2021/day09input.txt")))
    }
}
