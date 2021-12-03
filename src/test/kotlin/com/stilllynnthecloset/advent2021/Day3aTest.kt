package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day3aTest {
    @Test
    fun example() {
        assertEquals(198, day3a(readFile("2021/day3example.txt")))
    }

    @Test
    fun test() {
        assertEquals(4006064, day3a(readFile("2021/day3input.txt")))
    }
}
