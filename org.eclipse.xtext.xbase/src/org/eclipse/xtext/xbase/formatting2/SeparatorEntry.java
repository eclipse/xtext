/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
public class SeparatorEntry<T extends Object, R extends ITextSegment> extends Entry<T, R> {
	private R separator;

	@Override
	public ObjectEntry<T, R> getLeadingObject() {
		return (ObjectEntry<T, R>) previous;
	}

	@Override
	public ObjectEntry<T, R> getTrailingObject() {
		return (ObjectEntry<T, R>) next;
	}

	@Override
	public SeparatorEntry<T, R> getLeadingSeparator() {
		Entry<T, R> result = null;
		if (previous != null) {
			result = previous.previous;
		}
		return (SeparatorEntry<T, R>) result;
	}

	@Override
	public SeparatorEntry<T, R> getTrailingSeparator() {
		Entry<T, R> result = null;
		if (next != null) {
			result = next.next;
		}
		return (SeparatorEntry<T, R>) result;
	}

	@Override
	public String toString() {
		return "\"" + separator.getText() + "\" at offset=" + separator.getOffset() + " lenght="
				+ separator.getLength();
	}

	public R getSeparator() {
		return separator;
	}

	public void setSeparator(R separator) {
		this.separator = separator;
	}
}
