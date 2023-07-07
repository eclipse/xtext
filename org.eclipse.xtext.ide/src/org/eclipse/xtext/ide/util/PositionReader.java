/*******************************************************************************
 * Copyright (c) 2022 Avaloq Evolution AG (http://www.avaloq.com).
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.eclipse.lsp4j.Position;

import com.google.common.annotations.Beta;

/**
 * A reader that can return a {@link Position} on the current input string.
 *
 * @author Ruben Porras Campo - Initial Contribution and API
 * @author Joao Dinis Ferreira - Correct handling of files with carriage-return line endings
 */
@Beta
public class PositionReader extends BufferedReader {

	/** The current line. */
	private int line;

	/** The current column. */
	private int column;

	/** The marked line, if any. */
	private int markedLine;

	/** The marked column, if any. */
	private int markedColumn;

	/**
	 * Create a new position reader, using the input string.
	 *
	 * @param in
	 *            The input string
	 */
	public PositionReader(final String in) {
		super(new StringReader(in));
	}

	public Position getPosition() {
		return new Position(line, column);
	}

	@Override
	public int read() throws IOException {
		synchronized (lock) {
			int c = super.read();

			if (c == '\n' || (c == '\r' && peek() != '\n')) {
				line++;
				column = 0;
			} else if (c != '\r' && c != -1) {
				column++;
			}

			return c;
		}
	}

	@Override
	public int read(final char[] cbuf, final int off, final int len) throws IOException {
		throw new UnsupportedOperationException();
	}

	private int peek() throws IOException {
		mark(2);
		int c = super.read();
		reset();
		return c;
	}

	@Override
	public long skip(final long n) throws IOException {
		long read = 0;

		while (read < n) {
			if (read() == -1) {
				return read;
			}
			read++;
		}
		return read;
	}

	@Override
	public void mark(final int readAheadLimit) throws IOException {
		synchronized (lock) {
			super.mark(readAheadLimit);
			markedLine = line;
			markedColumn = column;
		}
	}

	@Override
	public void reset() throws IOException {
		synchronized (lock) {
			super.reset();
			line = markedLine;
			column = markedColumn;
		}
	}
}