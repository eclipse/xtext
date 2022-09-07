/*******************************************************************************
 * Copyright (c) 2022 Avaloq Evolution AG (http://www.avaloq.com).
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.semantictokens;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

import org.eclipse.lsp4j.Position;

/**
 * A position reader inspired by {@link LineNumberReader}.
 */
public class PositionReader extends StringReader {

	/** The current line number. */
	private int lineNumber;
	private int column;

	/** The line number of the mark, if any. */
	private int markedLineNumber;
	private int markedOffset;

	/** If the next character is a line feed, skip it. */
	private boolean skipLF;

	/** The skipLF flag when the mark was set. */
	private boolean markedSkipLF;

	/**
	 * Create a new position reader, using the input string.
	 *
	 * @param in
	 *            A Reader object to provide the input string
	 */
	public PositionReader(final String in) {
		super(in);
	}

	public Position getPosition() {
		return new Position(lineNumber, column);
	}

	private void newLine() {
		lineNumber++;
		column = 0;
	}

	@Override
	public int read() throws IOException {
		synchronized (lock) {
			int c = super.read();
			if (skipLF) {
				if (c == '\n') {
					c = super.read();
				}
				skipLF = false;
			}
			switch (c) { // NOPMD TooFewBranchesForASwitchStatement
			case '\r':
				skipLF = true;
				newLine();
				break;
			case '\n':
				newLine();
				return '\n';
			default:
				column++;
			}
			return c;
		}
	}

	@Override
	public int read(final char[] cbuf, final int off, final int len) throws IOException {
		synchronized (lock) {
			int n = super.read(cbuf, off, len);

			for (int i = off; i < off + n; i++) {
				int c = cbuf[i];
				if (skipLF) {
					skipLF = false;
					if (c == '\n') {
						continue;
					}
				}
				switch (c) { // NOPMD TooFewBranchesForASwitchStatement
				case '\r':
					skipLF = true;
					newLine();
					break;
				case '\n':
					newLine();
					break;
				default:
					column++;
				}
			}

			return n;
		}
	}

	/** Maximum skip-buffer size. */
	private static final int MAX_SKIP_BUFFER_SIZE = 8192;

	/** Skip buffer, null until allocated. */
	private char[] skipBuffer;

	@Override
	public long skip(final long n) throws IOException {
		if (n < 0) {
			throw new IllegalArgumentException("skip() value is negative"); //$NON-NLS-1$
		}
		int nn = (int) Math.min(n, MAX_SKIP_BUFFER_SIZE);
		synchronized (lock) {
			if ((skipBuffer == null) || (skipBuffer.length < nn)) {
				skipBuffer = new char[nn];
			}
			long r = n;
			while (r > 0) {
				int nc = read(skipBuffer, 0, (int) Math.min(r, nn));
				if (nc == -1) {
					break;
				}
				r -= nc;
			}
			return n - r;
		}
	}

	@Override
	public void mark(final int readAheadLimit) throws IOException {
		synchronized (lock) {
			// If the most recently read character is '\r', then increment the
			// read ahead limit as in this case if the next character is '\n',
			// two characters would actually be read by the next read().
			if (skipLF) {
				super.mark(readAheadLimit + 1);
			} else {
				super.mark(readAheadLimit);
			}
			markedLineNumber = lineNumber;
			markedOffset = column;
			markedSkipLF = skipLF;
		}
	}

	@Override
	public void reset() throws IOException {
		synchronized (lock) {
			super.reset();
			lineNumber = markedLineNumber;
			column = markedOffset;
			skipLF = markedSkipLF;
		}
	}
}

/* Copyright (c) Avaloq Evolution AG */