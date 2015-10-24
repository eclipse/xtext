/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util

import org.eclipse.xtend.lib.annotations.Data

/**
 * A simple record with line and column information.
 * The line number is one-based, e.g. the first line in the document
 * has the line number 1.
 * The column number is one based, too, e.g the first column in a line
 * has the index 1.
 * 
 * Line breaks are part of the line itself, e.g. the first line break
 * in the document still has line number one. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class LineAndColumn {
	int line
	int column

	static def from(int line, int column) {
		val result = new LineAndColumn(line, column)
		if (line <= 0 || column <= 0) {
			throw new IllegalArgumentException(result.toString)
		}
		return result
	}
	
	private new(int line, int column) {
		this.line = line
		this.column = column
	}
}