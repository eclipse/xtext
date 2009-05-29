/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;

import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StringWithOffset implements ICharSequenceWithOffset, IMarkerFactory {

	private final String value;
	private int offset;
	
	public StringWithOffset(String value) {
		this.value = Strings.emptyIfNull(value);
		this.offset = 0;
	}
	
	public int getOffset() {
		return offset;
	}

	public void incOffset() {
		offset++;
	}

	public void incOffset(int amount) {
		offset+=amount;
	}

	public void setOffset(int offset) {
		this.offset = offset;
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

	public IMarker mark() {
		return new Marker();
	}

	private class Marker implements IMarker {

		private int offset;
		
		public Marker() {
			this(StringWithOffset.this.offset);
		}
		
		private Marker(int offset) {
			this.offset = offset;
		}
		
		public void rollback() {
			StringWithOffset.this.setOffset(offset);
		}

		@Override
		public String toString() {
			return "Marker@" + offset;
		}

		public void commit() {
		}

		public IMarker fork() {
			return new Marker(offset);
		}

		public IMarker join(IMarker forkedMarker) {
			return this;
		}

		public void flush() {
		}
	}
}
