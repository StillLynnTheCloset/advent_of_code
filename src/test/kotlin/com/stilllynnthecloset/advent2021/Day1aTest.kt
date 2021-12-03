package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day1aTest {
    @Test
    fun example() {
        assertEquals(7, day1a(readFile("2021/day1example.txt")))
    }

    @Test
    fun test() {
        assertEquals(1532, day1a(readFile("2021/day1input.txt")))
    }
}
