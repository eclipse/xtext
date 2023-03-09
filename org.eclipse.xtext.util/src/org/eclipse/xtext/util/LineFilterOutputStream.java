/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Filters any line, that contains the given pattern right from the beginning.
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @deprecated this class is obsolete and will be removed in a future release of Xtext.
 */
@Deprecated(forRemoval = true)
public class LineFilterOutputStream extends FilterOutputStream {

	private final byte[] pattern;

	private final byte[] buffer;

	private int index;

	private final byte[] newline;

	private int newlineIndex;

	/**
	 * <code>true</code> if we found a newline or at the beginning of the stream.
	 */
	private boolean searching;

	public LineFilterOutputStream(OutputStream out, String pattern) {
		this(out, pattern, Strings.newLine());
	}

	public LineFilterOutputStream(OutputStream out, String pattern, String newLine) {
		super(out);
		this.pattern = pattern.getBytes();
		this.buffer = new byte[pattern.length()];
		this.newline = newLine.getBytes();
		index = 0;
		newlineIndex = 0;
		searching = true;
	}

	@Override
	public void write(int b) throws IOException {
		if (searching) {
			if (newline[0] == b) { // eol
				if (index == pattern.length) {
					// successful match, skip the buffer
					index = 0;
					if (newline.length > 1) {
						newlineIndex++;
						searching = false;
					} else {
						searching = true;
					}
				} else {
					// newline to early, flush the buffer
					for (int i = 0; i < index; i++) {
						super.write(buffer[i]);
					}
					if (newline.length > 1) {
						newlineIndex++;
						searching = false;
					} else {
						searching = true;
					}
					index = 0;
					super.write(b);
				}
			} else if (index >= pattern.length || pattern[index] != b) {
				// eol to late, flush buffer
				for (int i = 0; i < index; i++) {
					super.write(buffer[i]);
				}
				searching = false;
				index = 0;
				super.write(b);
			} else {
				// match, buffer the byte
				buffer[index] = (byte)b;
				index++;
			}
		} else {
			// newline has more then 1 character and we are at the second one
			if (newline.length > 1 && newlineIndex > 0 && b == newline[newlineIndex]) {
				searching = true;
				newlineIndex = 0;
				super.write(b);
			} else if (newline[0] == b) {
				// newline found
				if (newline.length > 1) {
					newlineIndex++;
				} else {
					searching = true;
				}
				super.write(b);
			} else {
				super.write(b);
			}
		}
	}

	@Override
	public void flush() throws IOException {
		if (index != pattern.length)
			for (int i = 0; i < index; i++) {
				super.write(buffer[i]);
			}
		super.flush();
	}

}
