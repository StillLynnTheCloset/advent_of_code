package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day2bTest {
    @Test
    fun example() {
        assertEquals(900, day2b(readFile("2021/day2example.txt")))
    }

    @Test
    fun test() {
        assertEquals(1544000595, day2b(readFile("2021/day2input.txt")))
    }
}
