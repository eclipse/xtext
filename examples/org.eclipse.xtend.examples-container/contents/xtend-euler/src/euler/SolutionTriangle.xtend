package euler

import static extension java.lang.Integer.*
import static extension java.lang.Math.*
import java.util.ArrayList
import java.util.List

class SolutionTriangle {
	int result

	new(String triangle) {
		val it = new ArrayList(triangle.split('\n').map[ new ArrayList(split(' ').map[ s | s.parseInt ]) ]);
		((size-1)..1).forEach [ lineIndex |
			val line = get(lineIndex)
			(0..line.size - 2).forEach [ i |
				get(lineIndex - 1).addValue(i, line.get(i).max(line.get(i + 1)))
			]
		]
		result = get(0).get(0)
	}

	def addValue(List<Integer> list, int idx, int value) {
		list.set(idx, list.get(idx) + value)
	}

	override toString() {
		result.toString
	}

}