/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;
import org.eclipse.xtext.parser.packrat.Marker.IMarkerClient;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.IRootConsumerListener;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.KeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.RecoveryState;
import org.eclipse.xtext.parser.packrat.consumers.RecoveryStateHolder;
import org.eclipse.xtext.parser.packrat.debug.DebugCharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.debug.DebugConsumerUtility;
import org.eclipse.xtext.parser.packrat.debug.DebugHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.debug.DebugMarkerFactory;
import org.eclipse.xtext.parser.packrat.debug.DebugParsedTokenAcceptor;
import org.eclipse.xtext.parser.packrat.debug.DebugUtil;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parser.packrat.tokens.ParsedAction;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractPackratParser extends AbstractParser<CharSequence> implements
	IPackratParser,
	IMarkerFactory, 
	IMarkerClient,
	ICharSequenceWithOffset, 
	IParsedTokenAcceptor,
	IHiddenTokenHandler, 
	IConsumerUtility {
	
	private class HiddenTokenState implements IHiddenTokenHandler.IHiddenTokenState {
		private ITerminalConsumer[] hiddens;
		
		public HiddenTokenState(ITerminalConsumer[] previousHiddens) {
			this.hiddens = previousHiddens;
		}
		
		public void restore() {
			setHiddens(this.hiddens);
		}

		@Override
		public String toString() {
			return "HiddenTokenState holding " + Arrays.toString(hiddens);
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
	
	private ITerminalConsumer[] hiddens;
	
	private int offset;
	
	private final KeywordConsumer keywordConsumer;
	
	private final IParserConfiguration parserConfiguration;
	
	private static final int MARKER_BUFFER_SIZE = 100;
	
	private final Marker[] markerBuffer;
	
	private int markerBufferSize;
	
	private Marker activeMarker;
	
	private final RecoveryStateHolder recoveryStateHolder;
	
	protected AbstractPackratParser() {
		recoveryStateHolder = new RecoveryStateHolder();
		parserConfiguration = createParserConfiguration();
		keywordConsumer = createKeywordConsumer();
		markerBuffer = new Marker[MARKER_BUFFER_SIZE];
		hiddens = parserConfiguration.getInitialHiddenTerminals();
		for(ITerminalConsumer hidden: this.hiddens)
			hidden.setHidden(true);
	}
	
	private IParserConfiguration createParserConfiguration() {
		final ICharSequenceWithOffset localInput = DebugUtil.INPUT_DEBUG ? new DebugCharSequenceWithOffset(this) : this;
		final IMarkerFactory localMarkerFactory = DebugUtil.MARKER_FACTORY_DEBUG ? new DebugMarkerFactory(this) : this;
		final IParsedTokenAcceptor localTokenAcceptor = DebugUtil.TOKEN_ACCEPTOR_DEBUG ? new DebugParsedTokenAcceptor(this) : this;
		final IHiddenTokenHandler localHiddenTokenHandler = DebugUtil.HIDDEN_TOKEN_HANDLER_DEBUG ? new DebugHiddenTokenHandler(this) : this;
		final IConsumerUtility localConsumerUtil = DebugUtil.CONSUMER_UTIL_DEBUG ? new DebugConsumerUtility(this) : this;
		
		IParserConfiguration result = createParserConfiguration(new IInternalParserConfiguration() {
			public IConsumerUtility getConsumerUtil() {
				return localConsumerUtil;
			}
			public IHiddenTokenHandler getHiddenTokenHandler() {
				return localHiddenTokenHandler;
			}
			public ICharSequenceWithOffset getInput() {
				return localInput;
			}
			public IMarkerFactory getMarkerFactory() {
				return localMarkerFactory;
			}
			public RecoveryStateHolder getRecoveryStateHolder() {
				return recoveryStateHolder;
			}
			public IParsedTokenAcceptor getTokenAcceptor() {
				return localTokenAcceptor;
			}
		});
		result.createTerminalConsumers();
		result.createNonTerminalConsumers();
		result.configureConsumers();
		return result;
	}

	protected abstract IParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration);

	protected KeywordConsumer createKeywordConsumer() {
		return parserConfiguration.createKeywordConsumer();
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
		this.offset = 0;
		Arrays.fill(markerBuffer, null);
		this.markerBufferSize = 0;
		return parse(consumer);
	}

	private class RootConsumerListener implements IRootConsumerListener {
		public void beforeNonTerminalEnd(INonTerminalConsumer nonTerminalConsumer, int result, INonTerminalConsumerConfiguration configuration) {
			if (result == ConsumeResult.SUCCESS && offset != length())
				consumeHiddens();
			if (offset != length()) {
				configuration.getTokenAcceptor().accept(new ErrorToken(offset, length() - offset, null, "<EOF> expected."));
				offset = length();
			}
		}

		public void afterNonTerminalBegin(INonTerminalConsumer nonTerminalConsumer, INonTerminalConsumerConfiguration configuration) {
			consumeHiddens();
		}

		public void handleException(NonTerminalConsumer nonTerminalConsumer, Exception e, INonTerminalConsumerConfiguration configuration) {
			configuration.getTokenAcceptor().accept(new ErrorToken(offset, length() - offset, null, e.getMessage()));
			offset = length();
		}
	}
	
	protected final IParseResult parse(INonTerminalConsumer consumer) {
		if (activeMarker != null)
			throw new IllegalStateException("cannot parse now. Active marker is already assigned.");
		IMarker rootMarker = mark();
		IRootConsumerListener listener = new RootConsumerListener();
		try {
			recoveryStateHolder.setState(new RecoveryState());
			consumer.consumeAsRoot(listener);
			IParseResult result = getParseResultFactory().createParseResult(activeMarker, input);
			rootMarker.commit();
			if (activeMarker != null)
				throw new IllegalStateException("cannot finish parse: active marker is still present.");
			recoveryStateHolder.getState().assertLevelIsReset();
			recoveryStateHolder.setState(null);
			return result;
		} catch(Exception e) {
			throw new WrappedException(e);
		} 
	}
	
	protected INonTerminalConsumer getRootConsumer() {
		return parserConfiguration.getRootConsumer();
	}
	
	protected void consumeHiddens() {
		boolean anySuccess = true;
		while(anySuccess) {
			anySuccess = false;
			for (ITerminalConsumer consumer: hiddens) {
				if (consumer.consume(null, false, false, null, ISequenceMatcher.Factory.nullMatcher()) == ConsumeResult.SUCCESS) {
					anySuccess = true;
					break;
				}
			}
		}
	}
	
	public IMarker mark() {
		return getNextMarker(activeMarker, offset);
	}
	
	public Marker getActiveMarker() {
		return activeMarker;
	}

	public Marker getNextMarker(Marker parent, int offset) {
		return markerBufferSize > 0 ? 
				markerBuffer[--markerBufferSize].reInit(offset, parent, this, this) : 
				new Marker(parent, offset, this, this);
	}

	public void setActiveMarker(Marker marker) {
		this.activeMarker = marker;
	}
	
	public void releaseMarker(Marker marker) {
		if (markerBufferSize < MARKER_BUFFER_SIZE)
			markerBuffer[markerBufferSize++] = marker;
	}

	public int consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean, ICharacterClass notFollowedBy) {
		keywordConsumer.configure(keyword, notFollowedBy);
		return consumeTerminal(keywordConsumer, feature, isMany, isBoolean, keyword, ISequenceMatcher.Factory.nullMatcher());
	}
	
	public int consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany, boolean isBoolean, AbstractElement grammarElement, ISequenceMatcher notMatching) {
		IMarker marker = mark();
		consumeHiddens();
		int result = consumer.consume(feature, isMany, isBoolean, grammarElement, notMatching != null ? notMatching : ISequenceMatcher.Factory.nullMatcher());
		if (result == ConsumeResult.SUCCESS) {
			marker.commit();
			return result;
		} 
		marker.rollback();
		return result;
	}
	
	public int consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany, 
			boolean isDatatype, boolean isBoolean, AbstractElement grammarElement) throws Exception {
		if (!consumer.isDefiningHiddens())
			return consumer.consume(feature, isMany, isDatatype, isBoolean, grammarElement);
		
		// either consume hiddens and have success or leave them and try again
		// TODO: rollback hidden tokens step by step
		IMarker marker = mark();
		IMarker currentMarker = marker.fork();
		int result = consumer.consume(feature, isMany, isDatatype, isBoolean, grammarElement);
		if (result == ConsumeResult.SUCCESS) {
			marker = currentMarker.join(marker);
			marker.commit();
			return result;
		}
		// no success, read hidden tokens and try again
		marker = marker.join(currentMarker);
		currentMarker = marker.fork();
		consumeHiddens();
		int nextResult = consumer.consume(feature, isMany, isDatatype, isBoolean, grammarElement);
		if (nextResult == ConsumeResult.SUCCESS) {
			marker = currentMarker.join(marker);
			marker.commit();
			return nextResult;
		} 
		// keep better result
		if (nextResult > result) {
			marker = currentMarker.join(marker);
			result = nextResult;
		} else {
			marker = marker.join(currentMarker);
		}
		// commit latest error
		marker.commit();
		return result;
	}
	
	public void consumeAction(Action action, String typeName, boolean isMany) {
		accept(new ParsedAction(offset, action, typeName, isMany));
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
		activeMarker.accept(token);
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

	@Override
	protected CharSequence createParseable(CharSequence sequence) {
		return sequence;
	}

	@Override
	protected CharSequence createParseable(InputStream stream) {
		try {
			char[] buff = new char[1024];
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			CharArrayWriterAsSequence result = new CharArrayWriterAsSequence(stream.available());
			int chars = 0;
			while((chars = reader.read(buff)) != -1) {
				result.write(buff, 0, chars);
			}
			reader.close();
			return result;
		} catch(IOException ex) {
			throw new WrappedException(ex);
		}
	}

	@Override
	protected IParseResult doParse(CharSequence sequence) {
		return parse(sequence);
	}
	
}
