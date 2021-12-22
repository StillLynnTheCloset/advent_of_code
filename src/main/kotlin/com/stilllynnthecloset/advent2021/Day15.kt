package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.Grid
import com.stilllynnthecloset.MutableGrid
import com.stilllynnthecloset.Position
import java.util.PriorityQueue

fun day15a(input: String): Int = input
    .lines()
    .map { it.toList().mapTo(mutableListOf()) { it.digitToInt() } }
    .let { Grid(it) }
    .findMinPath()

private fun Grid<Int>.findMinPath(): Int {
    val end = Position(xSize - 1, ySize - 1)
    val visitedNodes = mutableSetOf<Position>()
    val costs = MutableGrid<Int?>(xSize, ySize) { _, _ -> null }
    val queue = PriorityQueue(Comparator<Pair<Position, Int>> { o1, o2 -> o1.second.compareTo(o2.second) })
    queue.add(Position(0, 0) to 0)

    while (queue.isNotEmpty()) {
        val (node, _) = queue.remove()
        if (node in visitedNodes) {
            // https://www.youtube.com/watch?v=zxMvva0ZSyA
            continue
        }
        if (node == end) {
            return costs[node] ?: throw IllegalStateException("Visited end node but cost wasn't set")
        }

        visitedNodes.add(node)

        findValidSurroundingPositions(node.x, node.y)
            .filter { it !in visitedNodes }
            .forEach { pos ->
                val risk = get(pos.x, pos.y)
                val cost = (costs[node] ?: 0) + risk
                val currentCostAtPosition = costs[pos]
                costs[pos] = if (currentCostAtPosition == null) cost else cost.coerceAtMost(currentCostAtPosition)
                queue.offer(pos to cost)
            }
    }
    throw IllegalStateException("Didn't find end node")
}

fun day15b(input: String): Int = input
    .lines()
    .map { it.toList().mapTo(mutableListOf()) { it.digitToInt() } }
    .let { Grid(it) }
    .buildBiggerGrid()
    .findMinPath()

private fun Grid<Int>.buildBiggerGrid(): Grid<Int> {
    return Grid(xSize * 5, ySize * 5) { x, y ->
        val risk = get(x % xSize, y % ySize) + x / xSize + y / ySize

        ((risk - 1) % 9) + 1
    }
}
