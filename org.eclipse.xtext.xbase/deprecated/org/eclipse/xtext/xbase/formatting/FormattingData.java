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
public abstract class FormattingData {
	private final int offset;

	private final int length;

	private final int increaseIndentationChange;

	private final int decreaseIndentationChange;

	private final Throwable trace;

	public abstract boolean isEmpty();

	public int getIndentationChange() {
		return (increaseIndentationChange + decreaseIndentationChange);
	}

	public FormattingData(int offset, int length, int increaseIndentationChange, int decreaseIndentationChange,
			Throwable trace) {
		this.offset = offset;
		this.length = length;
		this.increaseIndentationChange = increaseIndentationChange;
		this.decreaseIndentationChange = decreaseIndentationChange;
		this.trace = trace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + decreaseIndentationChange;
		result = prime * result + increaseIndentationChange;
		result = prime * result + length;
		result = prime * result + offset;
		result = prime * result + ((trace == null) ? 0 : trace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormattingData other = (FormattingData) obj;
		if (decreaseIndentationChange != other.decreaseIndentationChange)
			return false;
		if (increaseIndentationChange != other.increaseIndentationChange)
			return false;
		if (length != other.length)
			return false;
		if (offset != other.offset)
			return false;
		if (trace == null) {
			if (other.trace != null)
				return false;
		} else if (!trace.equals(other.trace))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("offset", offset);
		b.add("length", length);
		b.add("increaseIndentationChange", increaseIndentationChange);
		b.add("decreaseIndentationChange", decreaseIndentationChange);
		b.add("trace", trace);
		return b.toString();
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public int getIncreaseIndentationChange() {
		return increaseIndentationChange;
	}

	public int getDecreaseIndentationChange() {
		return decreaseIndentationChange;
	}

	public Throwable getTrace() {
		return trace;
	}
}
