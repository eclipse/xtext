/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import java.io.CharArrayWriter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CharArrayWriterAsSequence extends CharArrayWriter implements CharSequence {

	@Override
	public char charAt(int index) {
		return buf[index];
	}

	@Override
	public int length() {
		return count;
	}

	public CharArrayWriterAsSequence(int initial) {
		super(initial <= 32 ? 512 : initial);
	}
	
	public CharArrayWriterAsSequence() {
		super(1024);
	}
	
	@Override
	public CharSequence subSequence(int start, int end) {
		return new SubSequence(this, start, end);
	}
	
	public static class SubSequence implements CharSequence {
		private final CharArrayWriterAsSequence base;
		private final int start;
		private final int end;

		public SubSequence(CharArrayWriterAsSequence base, int start, int end){
			this.base = base;
			this.start = start;
			this.end = end;
		}

		@Override
		public char charAt(int index) {
			return base.charAt(index + start);
		}

		@Override
		public int length() {
			return end - start;
		}

		@Override
		public CharSequence subSequence(int start, int end) {
			return new SubSequence(base, this.start + start, this.start + end);
		}

		@Override
		public String toString() {
			return new String(base.buf, start, end - start);
		}
		
	}

}
