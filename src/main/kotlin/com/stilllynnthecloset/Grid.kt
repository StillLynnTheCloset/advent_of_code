package com.stilllynnthecloset

open class Grid<T> constructor(
    protected val grid: List<MutableList<T>> = listOf(),
    val xSize: Int,
    val ySize: Int,
) {
    constructor(xSize: Int, ySize: Int, initializer: (x: Int, y: Int) -> T) : this(
        grid = (0..xSize).map { x ->
            (0..ySize).mapTo(mutableListOf()) { y ->
                initializer(x, y)
            }
        },
        xSize = xSize,
        ySize = ySize,
    )

    fun get(x: Int, y: Int): T = grid[x][y]

    operator fun get(position: Position): T = grid[position.x][position.y]

    operator fun get(position: Pair<Int, Int>): T = grid[position.first][position.second]

    // Technically these are all "Indexed" versions, but the indices are even more important in this use case, so I'm not going to make non-indexed versions.

    fun onEach(block: (x: Int, y: Int, value: T) -> Unit): Grid<T> {
        grid.indices.forEach { x ->
            grid[x].indices.forEach { y ->
                block(x, y, grid[x][y])
            }
        }
        return this
    }

    fun <K> map(block: (x: Int, y: Int, value: T) -> K): Grid<K> {
        return Grid(grid.indices.map { x ->
            grid[x].indices.mapTo(mutableListOf()) { y ->
                block(x, y, grid[x][y])
            }
        }, xSize, ySize)
    }

    fun <K> flatMap(block: (x: Int, y: Int, value: T) -> K): List<K> {
        return grid.indices.flatMap { x ->
            grid[x].indices.map { y ->
                block(x, y, grid[x][y])
            }
        }
    }

    fun <K : Any> flatMapNotNull(block: (x: Int, y: Int, value: T) -> K?): List<K> {
        return grid.indices.flatMap { x ->
            grid[x].indices.mapNotNull { y ->
                block(x, y, grid[x][y])
            }
        }
    }

    fun print(transform: (T) -> String): String = grid.joinToString("\n") { row ->
        row.joinToString("") { cell ->
            transform(cell)
        }
    }

    fun flipCoords() = Grid(ySize, xSize) { x, y -> get(y, x) }

}

class MutableGrid<T> constructor(
    grid: List<MutableList<T>> = listOf(),
    xSize: Int,
    ySize: Int,
) : Grid<T>(grid, xSize, ySize) {
    operator fun set(position: Position, value: T) {
        grid[position.x][position.y] = value
    }

    operator fun set(position: Pair<Int, Int>, value: T) {
        grid[position.first][position.second] = value
    }

    fun set(x: Int, y: Int, value: T) {
        grid[x][y] = value
    }
}
