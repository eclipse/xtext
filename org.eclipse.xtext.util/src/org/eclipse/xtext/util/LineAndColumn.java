/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A simple record with line and column information. The line number is
 * one-based, e.g. the first line in the document has the line number 1. The
 * column number is one based, too, e.g the first column in a line has the index
 * 1.
 * 
 * Line breaks are part of the line itself, e.g. the first line break in the
 * document still has line number one.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class LineAndColumn {
	private final int line;

	private final int column;

	public static LineAndColumn from(int line, int column) {
		LineAndColumn result = new LineAndColumn(line, column);
		if (line <= 0 || column <= 0) {
			throw new IllegalArgumentException(result.toString());
		}
		return result;
	}

	private LineAndColumn(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.line;
		return prime * result + this.column;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LineAndColumn other = (LineAndColumn) obj;
		if (other.line != line) {
			return false;
		}
		if (other.column != column) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("line", line);
		b.add("column", column);
		return b.toString();
	}

}
