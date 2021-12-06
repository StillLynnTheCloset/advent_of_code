package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day06Test {
    @Test
    fun exampleA() {
        assertEquals(5934, day06a(readFile("2021/day06example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(373378, day06a(readFile("2021/day06input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(26_984_457_539, day06b(readFile("2021/day06example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(1_682_576_647_495, day06b(readFile("2021/day06input.txt")))
    }
}
