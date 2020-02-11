/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public void incOffset() {
		offset++;
	}

	@Override
	public void incOffset(int amount) {
		offset+=amount;
	}

	@Override
	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public char charAt(int index) {
		return value.charAt(index);
	}

	@Override
	public int length() {
		return value.length();
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return value.subSequence(start, end);
	}

	@Override
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
		
		@Override
		public void rollback() {
			StringWithOffset.this.setOffset(offset);
		}

		@Override
		public String toString() {
			return "Marker@" + offset;
		}

		@Override
		public void commit() {
		}

		@Override
		public IMarker fork() {
			return new Marker(offset);
		}

		@Override
		public IMarker join(IMarker forkedMarker) {
			return this;
		}

		@Override
		public void flush() {
		}
	}
}
