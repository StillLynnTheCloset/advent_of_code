package com.stilllynnthecloset

open class Grid<T> constructor(
    protected val grid: List<MutableList<T>> = listOf(),
    val xSize: Int = grid.size,
    val ySize: Int = grid.first().size,
) {
    constructor(xSize: Int, ySize: Int, initializer: (x: Int, y: Int) -> T) : this(
        grid = (0 until xSize).map { x ->
            (0 until ySize).mapTo(mutableListOf()) { y ->
                initializer(x, y)
            }
        },
        xSize = xSize,
        ySize = ySize,
    )

    fun get(x: Int, y: Int, default: T? = null): T = if (x in 0 until xSize && y in 0 until ySize) grid[x][y] else default ?: throw IndexOutOfBoundsException("$xSize by $ySize grid has no position $x, $y")

    operator fun get(position: Position): T = get(position.x, position.y)

    operator fun get(position: Pair<Int, Int>): T = get(position.first, position.second)

    // Technically these are all "Indexed" versions, but the indices are even more important in this use case, so I'm not going to make non-indexed versions.

    fun onEach(block: (p: Position, value: T) -> Unit): Grid<T> {
        grid.indices.forEach { x ->
            grid[x].indices.forEach { y ->
                block(Position(x, y), grid[x][y])
            }
        }
        return this
    }

    fun <K> map(block: (p: Position, value: T) -> K): Grid<K> {
        return Grid(grid.indices.map { x ->
            grid[x].indices.mapTo(mutableListOf()) { y ->
                block(Position(x, y), grid[x][y])
            }
        }, xSize, ySize)
    }

    fun <K> flatMap(block: (p: Position, value: T) -> K): List<K> {
        return grid.indices.flatMap { x ->
            grid[x].indices.map { y ->
                block(Position(x, y), grid[x][y])
            }
        }
    }

    fun <K : Any> flatMapNotNull(block: (p: Position, value: T) -> K?): List<K> {
        return grid.indices.flatMap { x ->
            grid[x].indices.mapNotNull { y ->
                block(Position(x, y), grid[x][y])
            }
        }
    }

    fun print(transform: (T) -> String): String = grid.joinToString("\n") { row ->
        row.joinToString("") { cell ->
            transform(cell)
        }
    }

    fun flipCoords() = Grid(ySize, xSize) { x, y -> get(y, x) }

    fun mutate(x: Int, y: Int, value: T): Grid<T> {
        return Grid(xSize, ySize) { xIt, yIt ->
            if (x == xIt && y == yIt) {
                value
            } else {
                get(xIt, yIt)
            }
        }
    }

    fun findValidSurroundingPositions(x: Int, y: Int, diagonals: Boolean = false): List<Position> {
        return mutableListOf<Position>().also {
            if (x != 0) it.add(Position(x - 1, y))
            if (y != 0) it.add(Position(x, y - 1))
            if (x != grid.lastIndex) it.add(Position(x + 1, y))
            if (y != grid[x].lastIndex) it.add(Position(x, y + 1))
            if (diagonals) {
                if (x != 0 && y != 0) it.add(Position(x - 1, y - 1))
                if (y != 0 && x != grid.lastIndex) it.add(Position(x + 1, y - 1))
                if (x != grid.lastIndex && y != grid[x].lastIndex) it.add(Position(x + 1, y + 1))
                if (y != grid[x].lastIndex && x != 0) it.add(Position(x - 1, y + 1))
            }
        }
    }

    fun findValidSurroundingPositionsPositiveOnly(x: Int, y: Int, diagonals: Boolean = false): List<Position> {
        return mutableListOf<Position>().also {
            if (x != grid.lastIndex) it.add(Position(x + 1, y))
            if (y != grid[x].lastIndex) it.add(Position(x, y + 1))
        }
    }

    fun findValidSurroundingPositionsNegativeOnly(x: Int, y: Int, diagonals: Boolean = false): List<Position> {
        return mutableListOf<Position>().also {
            if (x != 0) it.add(Position(x - 1, y))
            if (y != 0) it.add(Position(x, y - 1))
        }
    }
}

class MutableGrid<T> constructor(
    grid: List<MutableList<T>> = listOf(),
    xSize: Int = grid.size,
    ySize: Int = grid.first().size,
) : Grid<T>(grid, xSize, ySize) {
    constructor(xSize: Int, ySize: Int, initializer: (x: Int, y: Int) -> T) : this(
        grid = (0 until xSize).map { x ->
            (0 until ySize).mapTo(mutableListOf()) { y ->
                initializer(x, y)
            }
        },
        xSize = xSize,
        ySize = ySize,
    )

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
