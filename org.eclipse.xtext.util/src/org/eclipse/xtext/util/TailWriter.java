/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.IOException;
import java.io.Writer;

/**
 * Used to remove the timestamp from generated antlr parsers and lexers to
 * prevent noise in cvs.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TailWriter extends Writer {

	private final Writer delegate;
	
	private int suppressLineCount;

	public TailWriter(Writer delegate, int suppressLineCount) {
		this.delegate = delegate;
		this.suppressLineCount = suppressLineCount;
	}
	
	@Override
	public void close() throws IOException {
		delegate.close();
	}

	@Override
	public void flush() throws IOException {
		delegate.flush();
	}

	/**
	 * Filter everything until we found the first NL character.
	 */
	@Override
	public void write(final char[] cbuf, final int off, final int len) throws IOException {
		int offset = off;
		int length = len;
		while (suppressLineCount > 0 && length > 0) {
			length = -1;
			for (int i = 0; i < len && suppressLineCount > 0; i++) {
				if (cbuf[off + i] == '\n') {
					offset = off + i + 1;
					length = len - i - 1;
					suppressLineCount--;
				}
			}
			if (length <= 0)
				return;
		}
		delegate.write(cbuf, offset, length);
	}

}
