/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.KeywordConsumer;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parser.packrat.tokens.ParsedAction;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTokenSequence;
import org.eclipse.xtext.service.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractPackratParser implements
	IPackratParser,
	IMarkerFactory, 
	ICharSequenceWithOffset, 
	IParsedTokenAcceptor,
	IHiddenTokenHandler, 
	IConsumerUtility {
	
	private class Marker implements IMarkerFactory.IMarker {
		
		private ParsedTokenSequence.Marker marker;
		
		private int offset;
		
		/**
		 * @param mark
		 * @param offset2
		 */
		public Marker(ParsedTokenSequence.Marker marker, int offset) {
			this.marker = marker;
			this.offset = offset;
		}

		public void rollback() {
			marker.rollback();
			AbstractPackratParser.this.offset = offset;
		}
	}
	
	private class HiddenTokenState implements IHiddenTokenHandler.IHiddenTokenState {

		private ITerminalConsumer[] hiddens;
		
		public HiddenTokenState(ITerminalConsumer[] previousHiddens) {
			this.hiddens = previousHiddens;
		}
		
		public void restore() {
			setHiddens(this.hiddens);
		}
		
	}
	
	private static final IHiddenTokenState NULL_HIDDEN_TOKEN_STATE = new IHiddenTokenState() {
		public void restore() {
		}
	};
	
	@Inject
	private IGrammarAccess grammarAccess;
	
	@Inject
	private IParseResultFactory parseResultFactory;
	
	private CharSequence input;
	
	private ITerminalConsumer[] hiddens = EMPTY_HIDDENS;
	
	private int offset;
	
	private final KeywordConsumer keywordConsumer;
	
	private final ParsedTokenSequence tokenSequence;
	
	private final IParserConfiguration parserConfiguration;
	
	protected AbstractPackratParser() {
		tokenSequence = createTokenSequence();
		keywordConsumer = createKeywordConsumer();
		parserConfiguration = createParserConfiguration();
	}
	
	private IParserConfiguration createParserConfiguration() {
		// TODO use debug wrappers if configured
		IParserConfiguration result = createParserConfiguration(this, this, this, this, this);
		result.createTerminalConsumers();
		result.createNonTerminalConsumers();
		result.configureConsumers();
		return result;
	}

	protected abstract IParserConfiguration createParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil);

	protected KeywordConsumer createKeywordConsumer() {
		return new KeywordConsumer(this, this, this);
	}

	protected ParsedTokenSequence createTokenSequence() {
		return new ParsedTokenSequence();
	}

	public IGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}

	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	public CharSequence getInput() {
		return input;
	}

	public final IParseResult parse(CharSequence input) {
		return parse(input, getRootConsumer());
	}
	
	public final IParseResult parse(CharSequence input, INonTerminalConsumer consumer) {
		this.input = input;
		this.tokenSequence.clear();
		return parse(consumer);
	}

	protected final IParseResult parse(INonTerminalConsumer consumer) {
		try {
			if (consumer.consume(null, false, false, null)) {
				return getParseResultFactory().createParseResult(tokenSequence);
			}
		} catch(Exception e) {
			throw new WrappedException(e);
		}
		return new ParseResult();
	}
	
	protected INonTerminalConsumer getRootConsumer() {
		return parserConfiguration.getRootConsumer();
	}
	
	protected void consumeHiddens() {
		boolean anySuccess = true;
		while(anySuccess) {
			anySuccess = false;
			for (ITerminalConsumer consumer: hiddens) {
				if (consumer.consume(null, false, false, null)) {
					anySuccess = true;
					break;
				}
			}
		}
	}
	
	public IMarker mark() {
		return new Marker(tokenSequence.mark(), offset);
	}
	
	protected void rollback(int position) {
		this.offset = position;
	}
	
	public boolean consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean) {
		keywordConsumer.setKeyword(keyword);
		return consumeTerminal(keywordConsumer, feature, isMany, isBoolean, keyword);
	}
	
	public boolean consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany, boolean isBoolean, AbstractElement grammarElement) {
		IMarker marker = mark();
		consumeHiddens();
		if (consumer.consume(feature, isMany, isBoolean, grammarElement)) {
			return true;
		} else marker.rollback();
		return false;
	}
	
	public boolean consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany, boolean isDatatype, AbstractElement grammarElement) throws Exception {
		return consumer.consume(feature, isMany, isDatatype, grammarElement);
	}
	
	public void consumeAction(String typeName, String feature, boolean isMany) {
		accept(new ParsedAction(input, offset, typeName, feature, isMany));
	}
	
	public void setParseResultFactory(IParseResultFactory parseResultFactory) {
		this.parseResultFactory = parseResultFactory;
	}

	public IParseResultFactory getParseResultFactory() {
		return parseResultFactory;
	}

	public int getOffset() {
		return offset;
	}

	public char charAt(int index) {
		return input.charAt(index);
	}

	public int length() {
		return input.length();
	}

	public CharSequence subSequence(int start, int end) {
		return input.subSequence(start, end);
	}

	public void incOffset() {
		offset++;
	}

	public void incOffset(int amount) {
		offset+=amount;
	}

	public void accept(AbstractParsedToken token) {
		tokenSequence.append(token);
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public IHiddenTokenState replaceHiddenTokens(ITerminalConsumer... consumers) {
		if (consumers == null)
			return NULL_HIDDEN_TOKEN_STATE;
		IHiddenTokenState result = new HiddenTokenState(this.hiddens);
		setHiddens(consumers);
		return result;
	}

	private void setHiddens(ITerminalConsumer... hiddenConsumers) {
		for(ITerminalConsumer hidden: this.hiddens)
			hidden.setHidden(false);
		this.hiddens = hiddenConsumers;
		for(ITerminalConsumer hidden: this.hiddens)
			hidden.setHidden(true);
	}
	
}
