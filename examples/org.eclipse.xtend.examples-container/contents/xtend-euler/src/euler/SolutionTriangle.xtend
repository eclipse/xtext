/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sebastian Zarnekow
 * See https://github.com/szarnekow/xtend-euler 
 *******************************************************************************/
 package euler

import static extension java.lang.Integer.parseInt
import static extension java.lang.Math.max
import java.util.ArrayList
import java.util.List

class SolutionTriangle {
	int result

	new(String triangle) {
		val it = new ArrayList(triangle.split('\\r?\\n').map[ new ArrayList(split(' ').map[ parseInt ]) ]);
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