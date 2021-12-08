package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day06Test {
    @Test
    fun examplesA() {
        assertEquals(1_000_000, day06a("turn on 0,0 through 999,999"))
        assertEquals(1_000, day06a("toggle 0,0 through 999,0"))
        assertEquals(4, day06a("turn on 499,499 through 500,500"))
    }

    @Test
    fun testA() {
        assertEquals(543903, day06a(readFile("2015/day06input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(1_000_000, day06b("turn on 0,0 through 999,999"))
        assertEquals(2_000, day06b("toggle 0,0 through 999,0"))
        assertEquals(4, day06b("turn on 499,499 through 500,500"))
    }

    @Test
    fun testB() {
        assertEquals(14687245, day06b(readFile("2015/day06input.txt")))
    }
}
