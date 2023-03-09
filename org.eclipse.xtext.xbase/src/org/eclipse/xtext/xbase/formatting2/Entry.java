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
public abstract class Entry<T extends Object, R extends ITextSegment> {
	protected Entry<T, R> next;

	protected Entry<T, R> previous;

	public abstract ObjectEntry<T, R> getLeadingObject();

	public abstract ObjectEntry<T, R> getTrailingObject();

	public abstract SeparatorEntry<T, R> getLeadingSeparator();

	public abstract SeparatorEntry<T, R> getTrailingSeparator();

	public Entry<T, R> getNext() {
		return next;
	}

	public void setNext(Entry<T, R> next) {
		this.next = next;
	}

	public Entry<T, R> getPrevious() {
		return previous;
	}

	public void setPrevious(Entry<T, R> previous) {
		this.previous = previous;
	}
}
