package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals
class Day15Test {
    @Test
    fun exampleA() {
        assertEquals(40, day15a(readFile("2021/day15example.txt")))
    }

    @Test
    fun exampleA2() {
        assertEquals(9, day15a(
            """
            19111
            11191
            99991
            11111
        """.trimIndent()
        )
        )
    }

    @Test
    fun testA() {
        assertEquals(447, day15a(readFile("2021/day15input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(315, day15b(readFile("2021/day15example.txt")))
    }


    @Test
    fun testB() {
        assertEquals(2825, day15b(readFile("2021/day15input.txt")))
    }
}

