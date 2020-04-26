/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @deprecated use {@link IHiddenRegionFormatter}
 */
@Deprecated
public class NewLineData extends FormattingData {
	private final Integer newLines;

	@Override
	public boolean isEmpty() {
		return newLines == null;
	}

	public NewLineData(int offset, int length, int increaseIndentationChange, int decreaseIndentationChange,
			Throwable trace, Integer newLines) {
		super(offset, length, increaseIndentationChange, decreaseIndentationChange, trace);
		this.newLines = newLines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((newLines == null) ? 0 : newLines.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewLineData other = (NewLineData) obj;
		if (newLines == null) {
			if (other.newLines != null)
				return false;
		} else if (!newLines.equals(other.newLines))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).addAllFields().toString();
	}

	public Integer getNewLines() {
		return newLines;
	}
}
