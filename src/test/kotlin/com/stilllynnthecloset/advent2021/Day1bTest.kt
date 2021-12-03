package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day1bTest {
    @Test
    fun example() {
        assertEquals(5, day1b(readFile("2021/day1example.txt")))
    }

    @Test
    fun test() {
        assertEquals(1571, day1b(readFile("2021/day1input.txt")))
    }
}
