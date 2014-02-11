/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	public void consume() {
		throw new UnsupportedOperationException();
	}

	public int LA(int i) {
		throw new UnsupportedOperationException();
	}

	public int mark() {
		throw new UnsupportedOperationException();
	}

	public int index() {
		throw new UnsupportedOperationException();
	}

	public void rewind(int marker) {
		throw new UnsupportedOperationException();
	}

	public void rewind() {
		throw new UnsupportedOperationException();
	}

	public void release(int marker) {
		throw new UnsupportedOperationException();
	}

	public void seek(int index) {
		throw new UnsupportedOperationException();
	}

	public int size() {
		throw new UnsupportedOperationException();
	}

	public String getSourceName() {
		throw new UnsupportedOperationException();
	}

	public String substring(int start, int stop) {
		throw new UnsupportedOperationException();
	}

	public int LT(int i) {
		throw new UnsupportedOperationException();
	}

	public int getLine() {
		throw new UnsupportedOperationException();
	}

	public void setLine(int line) {
		throw new UnsupportedOperationException();
	}

	public void setCharPositionInLine(int pos) {
		throw new UnsupportedOperationException();
	}

	public int getCharPositionInLine() {
		throw new UnsupportedOperationException();
	}
	
}