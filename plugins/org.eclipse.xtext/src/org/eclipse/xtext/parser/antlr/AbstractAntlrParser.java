/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractAntlrParser extends AbstractParser implements IAntlrParser {

	@Inject
	private IAstFactory elementFactory;

	@Inject(optional = true)
	private IPartialParsingHelper partialParser;

	@Inject
	private ITokenDefProvider tokenDefProvider;

	@Inject
	private ISyntaxErrorMessageProvider syntaxErrorProvider;

	@Inject
	private Provider<IUnorderedGroupHelper> unorderedGroupHelper;

	@Inject
	@Named(LexerBindings.RUNTIME)
	private Provider<Lexer> lexerProvider;

	@Override
	public IParseResult doParse(Reader reader) {
		try {
			return parse(getDefaultRuleName(), new ANTLRReaderStream(reader));
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	@Override
	public IParseResult doParse(CharSequence sequence) {
		return parse(getDefaultRuleName(), new StringReader(sequence.toString()));
	}

	public IAstFactory getElementFactory() {
		return elementFactory;
	}

	public void setElementFactory(IAstFactory elementFactory) {
		this.elementFactory = elementFactory;
	}

	protected abstract String getDefaultRuleName();

	protected abstract IParseResult parse(String ruleName, CharStream in);

	public IParseResult parse(String ruleName, Reader reader) {
		try {
			IParseResult parseResult = parse(ruleName, new ANTLRReaderStream(reader));
			return parseResult;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	@Deprecated
	public IParseResult parse(String ruleName, InputStream in) {
		try {
			return parse(ruleName, new InputStreamReader(in, getDefaultEncoding()));
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	@Override
	protected IParseResult doReparse(CompositeNode originalRootNode, int offset, int length, String change) {
		return partialParser.reparse(this, originalRootNode, offset, length, change);
	}

	@Override
	protected boolean isReparseSupported() {
		return partialParser != null;
	}

	public void setPartialParser(IPartialParsingHelper partialParser) {
		this.partialParser = partialParser;
	}

	public IPartialParsingHelper getPartialParser() {
		return partialParser;
	}

	protected TokenSource createLexer(CharStream stream) {
		Lexer lexer = lexerProvider.get();
		lexer.setCharStream(stream);
		return lexer;
	}

	protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
		return new XtextTokenStream(tokenSource, getTokenDefProvider());
	}

	public Provider<Lexer> getLexerProvider() {
		return this.lexerProvider;
	}

	public void setLexerProvider(Provider<Lexer> lexerProvider) {
		this.lexerProvider = lexerProvider;
	}

	public void setTokenDefProvider(ITokenDefProvider tokenDefProvider) {
		this.tokenDefProvider = tokenDefProvider;
	}

	public ITokenDefProvider getTokenDefProvider() {
		return tokenDefProvider;
	}

	public ISyntaxErrorMessageProvider getSyntaxErrorProvider() {
		return syntaxErrorProvider;
	}

	public void setSyntaxErrorProvider(ISyntaxErrorMessageProvider syntaxErrorProvider) {
		this.syntaxErrorProvider = syntaxErrorProvider;
	}

	public void setUnorderedGroupHelper(Provider<IUnorderedGroupHelper> unorderedGroupHelper) {
		this.unorderedGroupHelper = unorderedGroupHelper;
	}

	public Provider<IUnorderedGroupHelper> getUnorderedGroupHelper() {
		return unorderedGroupHelper;
	}

}
