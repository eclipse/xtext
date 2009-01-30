/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler.IHiddenTokenState;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class NonTerminalConsumer extends AbstractConsumer implements INonTerminalConsumer, INonTerminalConsumerConfiguration {
	
	private final IHiddenTokenHandler hiddenTokenHandler;
	
	private final IMarkerFactory markerFactory;
	
	private final ITerminalConsumer[] hiddenTokens;
	
	private final IConsumerUtility consumerUtil;

	protected NonTerminalConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration.getInput(), configuration.getTokenAcceptor(), configuration.getRecoveryStateHolder());
		this.markerFactory = configuration.getMarkerFactory();
		this.hiddenTokenHandler = configuration.getHiddenTokenHandler();
		this.consumerUtil = configuration.getConsumerUtil();
		this.hiddenTokens = hiddenTokens;
	}

	public int consume(String feature, boolean isMany, boolean isDatatype, AbstractElement grammarElement) throws Exception {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		int prevOffset = getOffset();
		acceptor.accept(new ParsedNonTerminal(input.getOffset(), grammarElement != null ? grammarElement : getGrammarElement(), getDefaultTypeName()));
		int result = doConsume();
		if (result != ConsumeResult.SUCCESS) {
			acceptor.accept(new ErrorToken(prevOffset, 0, null, "Expected " + getDefaultTypeName() + ", but could not find."));
		}
		acceptor.accept(new ParsedNonTerminalEnd(input.getOffset(), feature, isMany, isDatatype));
		marker.commit();
		prevState.restore();
		return result;
	}
	
	public boolean isDefiningHiddens() {
		return hiddenTokens != null;
	}

	public void consumeAsRoot(IRootConsumerListener listener) {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		acceptor.accept(new ParsedNonTerminal(input.getOffset(), getGrammarElement(), getDefaultTypeName()));
		listener.afterNonTerminalBegin(this, this);
		int result;
		try {
			result = doConsume();
		} catch(Exception e) {
			result = ConsumeResult.EXCEPTION;
			listener.handleException(this, e, this);
		}
		listener.beforeNonTerminalEnd(this, result, this);
		acceptor.accept(new ParsedNonTerminalEnd(input.getOffset(), null, false, false));
		marker.commit();
		prevState.restore();
	}
	
	protected final IMarker mark() {
		return markerFactory.mark();
	}
	
	protected final void error(String message, AbstractElement grammarElement) {
		acceptor.accept(new ErrorToken(getOffset(), 0, grammarElement, message));
	}
	
	protected final int consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean, ICharacterClass notFollowedBy) {
		return consumerUtil.consumeKeyword(keyword, feature, isMany, isBoolean, notFollowedBy);
	}
	
	protected final int consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany, boolean isBoolean, AbstractElement grammarElement, ISequenceMatcher notMatching) {
		return consumerUtil.consumeTerminal(consumer, feature, isMany, isBoolean, grammarElement, notMatching);
	}
	
	protected final int consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany, boolean isDatatype, AbstractElement grammarElement) throws Exception {
		return consumerUtil.consumeNonTerminal(consumer, feature, isMany, isDatatype, grammarElement);
	}
	
	protected final void consumeAction(Action action, String typeName, boolean isMany) {
		consumerUtil.consumeAction(action, typeName, isMany);
	}
	
	protected abstract int doConsume() throws Exception;
	
	// TODO: replace by getDefaultType: EClassifier
	protected abstract String getDefaultTypeName(); 
	
	protected abstract EObject getGrammarElement();

	public IConsumerUtility getConsumerUtil() {
		return consumerUtil;
	}

	public IHiddenTokenHandler getHiddenTokenHandler() {
		return hiddenTokenHandler;
	}

	public IMarkerFactory getMarkerFactory() {
		return markerFactory;
	}

	@Override
	public String toString() {
		return "NonTerminalConsumer " + getClass().getSimpleName() + " for type '" + getDefaultTypeName()  + "'";
	}
}