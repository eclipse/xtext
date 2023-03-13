/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.Reader;

import org.antlr.runtime.CharStream;

/**
 * An implementation of Antlr's {@link CharStream} that does nothing
 * (as in <b>nothing</b>) besides holding a reference to a
 * {@link Reader} that can be obtained. This thing exists to funnel
 * a reader through the {@link org.eclipse.xtext.parser.antlr.AbstractAntlrParser existing API}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReaderCharStream implements CharStream {

	private Reader reader;

	public ReaderCharStream(Reader reader) {
		this.reader = reader;
	}
	
	public Reader getReader() {
		return reader;
	}
	
	@Override
	public void consume() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int LA(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int mark() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int index() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void rewind(int marker) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void rewind() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void release(int marker) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void seek(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getSourceName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String substring(int start, int stop) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int LT(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getLine() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLine(int line) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCharPositionInLine(int pos) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getCharPositionInLine() {
		throw new UnsupportedOperationException();
	}
	
}