package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day16Test {
    @Test
    fun exampleA() {
        assertEquals(6, day16a("D2FE28"))
        assertEquals(9, day16a("38006F45291200"))
        assertEquals(14, day16a("EE00D40C823060"))
        assertEquals(16, day16a("8A004A801A8002F478"))
        assertEquals(12, day16a("620080001611562C8802118E34"))
        assertEquals(23, day16a("C0015000016115A2E0802F182340"))
        assertEquals(31, day16a("A0016C880162017C3686B18A3D4780"))
        // First child of the full input
        assertEquals(17,
            day16a("E2004100AA9C0199CA6A3D9D6352294D47B3AC6A4335FBE3FDD24")
        )
    }

    @Test
    fun testA() {
        assertEquals(925, day16a(readFile("2021/day16input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(3, day16b("C200B40A82"))
        assertEquals(54, day16b("04005AC33890"))
        assertEquals(7, day16b("880086C3E88112"))
        assertEquals(9, day16b("CE00C43D881120"))
        assertEquals(1, day16b("D8005AC2A8F0"))
        assertEquals(0, day16b("F600BC2D8F"))
        assertEquals(0, day16b("9C005AC2F8F0"))
        assertEquals(1, day16b("9C0141080250320F1802104A08"))
    }

    @Test
    fun testB() {
        assertEquals(342997120375, day16b(readFile("2021/day16input.txt")))
    }
}
