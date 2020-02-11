/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Jan Köhnlein
 * 
 */
public class Pair<T, U> {

	private final T first;

	private final U second;

	Pair(final T firstElement, final U secondElement) {
		this.first = firstElement;
		this.second = secondElement;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (this.getClass().equals(other.getClass())) {
			Pair<?, ?> otherPair = (Pair<?, ?>) other;
			boolean isEqual = (first == null) ? otherPair.getFirst() == null : first.equals(otherPair.getFirst());

			if (!isEqual)
				return false;

			return (second == null) ? otherPair.getSecond() == null : second.equals(otherPair.getSecond());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return first == null ? 0 : first.hashCode() + 17 * (second == null ? 0 : second.hashCode());
	}

	@Override
	public String toString() {
		return "Pair(" + first + ", " + second + ")";
	}

}
