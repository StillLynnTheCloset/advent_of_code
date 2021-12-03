package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day2aTest {
    @Test
    fun example() {
        assertEquals(150, day2a(readFile("2021/day2example.txt")))
    }

    @Test
    fun test() {
        assertEquals(1727835, day2a(readFile("2021/day2input.txt")))
    }
}
