/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.common;

import com.google.common.base.Preconditions;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class IgnoreCaseString implements CharSequence {

	private final String value;
	
	IgnoreCaseString(String value) {
		Preconditions.checkNotNull(value);
		this.value = value;
	}

	public char charAt(int index) {
		return value.charAt(index);
	}

	public int length() {
		return value.length();
	}

	public CharSequence subSequence(int start, int end) {
		return value.subSequence(start, end);
	}
	
	@Override
	public String toString() {
		return value;
	}

	@Override
	public int hashCode() {
		return value.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IgnoreCaseString other = (IgnoreCaseString) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equalsIgnoreCase(other.value))
			return false;
		return true;
	}
	
}
