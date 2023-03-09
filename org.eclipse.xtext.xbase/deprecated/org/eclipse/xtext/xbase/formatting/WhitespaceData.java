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
public class WhitespaceData extends FormattingData {
	private final String space;

	@Override
	public boolean isEmpty() {
		return space == null;
	}

	public WhitespaceData(int offset, int length, int increaseIndentationChange, int decreaseIndentationChange,
			Throwable trace, String space) {
		super(offset, length, increaseIndentationChange, decreaseIndentationChange, trace);
		this.space = space;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((space == null) ? 0 : space.hashCode());
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
		WhitespaceData other = (WhitespaceData) obj;
		if (space == null) {
			if (other.space != null)
				return false;
		} else if (!space.equals(other.space))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).addAllFields().toString();
	}

	public String getSpace() {
		return space;
	}
}
