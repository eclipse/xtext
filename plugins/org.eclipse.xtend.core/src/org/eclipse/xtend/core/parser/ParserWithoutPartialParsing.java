/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.Reader;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.core.parser.antlr.XtendParser;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Disable partial parsing for Xtend. The partial parsing regions
 * almost always covered the complete file anyway and it is conceptually
 * hard to get the lookahead right.
 * 
 * @since 2.5
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class ParserWithoutPartialParsing extends XtendParser {

	// TODO make the provider's #get from the super type available
	@Inject
	private Provider<NodeModelBuilder> nodeModelBuilder;
	
	@Inject
	private FlexerFactory flexerFactory;
	
	@Override
	protected boolean isReparseSupported() {
		return false;
	}
	
	@Override
	protected TokenSource createLexer(CharStream stream) {
		if (stream instanceof ReaderCharStream) {
			Reader reader = ((ReaderCharStream) stream).getReader();
			return flexerFactory.createTokenSource(reader);
		}
		throw new IllegalArgumentException(stream.getClass().getName());
	}
	
	@Override
	public IParseResult doParse(Reader reader) {
		return parse(getDefaultRuleName(), new ReaderCharStream(reader));
	}
	
	@Override
	public IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead) {
		NodeModelBuilder builder = nodeModelBuilder.get();
		builder.setForcedFirstGrammarElement(ruleCall);
		IParseResult parseResult = doParse(ruleCall.getRule().getName(), new ReaderCharStream(reader), builder, initialLookAhead);
		return parseResult;
	}
	
	static class ReaderCharStream implements CharStream {

		private Reader reader;

		ReaderCharStream(Reader reader) {
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
	
}
