package euler

/**
 * Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.
 * How many routes are there through a 20×20 grid?
 *
 * @see http://projecteuler.net/problem=15
 */
class Solution_015b {

	def static void main(String[] args) {
		val gridSize = 20
		val it = <Long>newArrayList()
		(1..gridSize+1).forEach[ col | add(1L) ]
		(1..gridSize).forEach[ row |
			(1..gridSize).forEach[ col |
				set(col, get(col - 1) + get(col))
			]
		]
		println(last)
	}
}