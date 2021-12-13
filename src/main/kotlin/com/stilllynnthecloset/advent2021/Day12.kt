package com.stilllynnthecloset.advent2021

private data class Node constructor(
    val name: String,
    val connections: MutableList<Node> = mutableListOf(),
    val isLarge: Boolean = name.first().isUpperCase(),
) {
    override fun toString(): String {
        return "$name(${connections.joinToString { it.name }})"
    }
}

fun day12a(input: String): Int = input
    .lines()
    .buildGraph()
    .findPathsA()
    .size

private fun List<String>.buildGraph(directed: Boolean = false): Map<String, Node> = mutableMapOf<String, Node>()
    .apply {
        this@buildGraph.forEach {
            val names = it.split("-")
            val node1 = getOrDefault(names.first(), Node(names.first()))
            val node2 = getOrDefault(names.last(), Node(names.last()))

            node1.connections.add(node2)
            if (!directed) {
                node2.connections.add(node1)
            }

            put(node1.name, node1)
            put(node2.name, node2)
        }
    }

private fun Map<String, Node>.findPathsA(): List<List<Node>> {
    val start = get("start") ?: throw IllegalStateException("Graph must have a node named start")
    val end = get("end") ?: throw IllegalStateException("Graph must have a node named end")

    val successfulPaths = mutableListOf<List<Node>>()
    val queue = mutableListOf(listOf(start))
    while (queue.isNotEmpty()) {
        val currentPath = queue.removeFirst()
        val currentNode = currentPath.last()

        if (currentNode == end) {
            successfulPaths.add(currentPath)
        } else {
            currentNode.connections.forEach {
                if (it.isLarge || it !in currentPath) {
                    queue.add(currentPath + it)
                }
            }
        }
    }
    return successfulPaths
}

private data class Path constructor(val nodes: List<Node>, val hasReVisitedSmallNode: Boolean)

fun day12b(input: String): Int = input
    .lines()
    .buildGraph()
    .findPathsB()
    .size


private fun Map<String, Node>.findPathsB(): List<Path> {
    val start = get("start") ?: throw IllegalStateException("Graph must have a node named start")
    val end = get("end") ?: throw IllegalStateException("Graph must have a node named end")

    val successfulPaths = mutableListOf<Path>()
    val queue = mutableListOf(Path(listOf(start), false))
    while (queue.isNotEmpty()) {
        val currentPath = queue.removeFirst()
        val currentNode = currentPath.nodes.last()

        if (currentNode == end) {
            successfulPaths.add(currentPath)
        } else {
            currentNode.connections.forEach {
                val isRevisit = it in currentPath.nodes
                val isSmallRevisit = isRevisit && !it.isLarge
                val canRevisit = !currentPath.hasReVisitedSmallNode
                if (it != start && (!isSmallRevisit || canRevisit)) {
                    val path = Path(currentPath.nodes + it, currentPath.hasReVisitedSmallNode || isSmallRevisit)
                    queue.add(path)
                }
            }
        }
    }
    return successfulPaths
}