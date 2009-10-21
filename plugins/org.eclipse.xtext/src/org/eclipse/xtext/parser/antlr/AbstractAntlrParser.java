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

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractAntlrParser extends AbstractParser<InputStream> implements IAntlrParser {

	@Inject
	private IAstFactory elementFactory;
	
	@Inject(optional=true)
	private IPartialParsingHelper partialParser;
	
	@Inject 
    private ITokenDefProvider tokenDefProvider;
	
	@Inject
	@Named(LexerBindings.RUNTIME)
	private Provider<Lexer> lexerProvider;

	@Override
	public IParseResult doParse(InputStream in) {
		return parse(getDefaultRuleName(), in);
	}

	public IAstFactory getElementFactory() {
		return elementFactory;
	}

	public void setElementFactory(IAstFactory elementFactory) {
		this.elementFactory = elementFactory;
	}

	protected abstract String getDefaultRuleName();

	protected abstract IParseResult parse(String ruleName, ANTLRInputStream in);

	public IParseResult parse(String ruleName, InputStream in) {
        try {
            IParseResult parseResult = parse(ruleName, new ANTLRInputStream(in));
            return parseResult;
        } catch (IOException e) {
            throw new WrappedException(e);
        }
    }

	@Override
	protected IParseResult doReparse(CompositeNode originalRootNode, int offset, int length, String change) {
		return partialParser.reparse(this, originalRootNode, offset, length, change);
	}

	@Override
	protected InputStream createParseable(CharSequence s) {
		return new StringInputStream(s.toString());
	}

	@Override
	protected InputStream createParseable(InputStream in) {
		return in;
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

}
