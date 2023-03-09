/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractAntlrParser extends AbstractParser {

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
	private Provider<NodeModelBuilder> nodeModelBuilder;

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
		return doParse(new StringReader(sequence.toString()));
	}

	public IAstFactory getElementFactory() {
		return elementFactory;
	}

	public void setElementFactory(IAstFactory elementFactory) {
		this.elementFactory = elementFactory;
	}

	protected abstract String getDefaultRuleName();

	protected IParseResult parse(String ruleName, CharStream in) {
		return doParse(ruleName, in, nodeModelBuilder.get(), 0);
	}

	protected IParseResult doParse(String ruleName, CharStream in, NodeModelBuilder nodeModelBuilder, int initialLookAhead) {
		TokenSource tokenSource = createLexer(in);
		XtextTokenStream tokenStream = createTokenStream(tokenSource);
		tokenStream.initCurrentLookAhead(initialLookAhead);
		setInitialHiddenTokens(tokenStream);
		AbstractInternalAntlrParser parser = createParser(tokenStream);
		parser.setTokenTypeMap(getTokenDefProvider().getTokenDefMap());
		parser.setSyntaxErrorProvider(getSyntaxErrorProvider());
		parser.setNodeModelBuilder(nodeModelBuilder);
		parser.setSemanticModelBuilder(getElementFactory());
		IUnorderedGroupHelper helper = getUnorderedGroupHelper().get();
		parser.setUnorderedGroupHelper(helper);
		helper.initializeWith(parser);
		try {
			if(ruleName != null)
				return parser.parse(ruleName);
			return parser.parse();
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
	}
	
	protected abstract AbstractInternalAntlrParser createParser(XtextTokenStream stream);

	@Override
	public IParseResult parse(ParserRule rule, Reader reader) {
		try {
			IParseResult parseResult = parse(rule.getName(), new ANTLRReaderStream(reader));
			return parseResult;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	@Override
	public IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead) {
		try {
			NodeModelBuilder builder = nodeModelBuilder.get();
			builder.setForcedFirstGrammarElement(ruleCall);
			IParseResult parseResult = doParse(ruleCall.getRule().getName(), new ANTLRReaderStream(reader), builder, initialLookAhead);
			return parseResult;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	@Override
	protected IParseResult doReparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		return partialParser.reparse(this, previousParseResult, replaceRegion);
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
	
	/**
	 * @since 2.5
	 */
	protected NodeModelBuilder createNodeModelBuilder() {
		return nodeModelBuilder.get();
	}

}
