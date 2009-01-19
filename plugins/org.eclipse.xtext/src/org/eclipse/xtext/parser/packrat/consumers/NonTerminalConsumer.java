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
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler.IHiddenTokenState;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class NonTerminalConsumer implements INonTerminalConsumer {
	
	private final IParsedTokenAcceptor parser;
	
	private final IHiddenTokenHandler hiddenTokenHandler;
	
	private final IMarkerFactory markerFactory;
	
	private final ICharSequenceWithOffset input;

	private final ITerminalConsumer[] hiddenTokens;
	
	private final IConsumerUtility consumerUtil;

	/**
	 * @param consumerUtil TODO
	 * @param abstractPackratParser
	 */
	protected NonTerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory, 
			IParsedTokenAcceptor tokenAcceptor,	IHiddenTokenHandler hiddenTokenHandler,
			IConsumerUtility consumerUtil, ITerminalConsumer[] hiddenTokens) {
		this.input = input;
		this.markerFactory = markerFactory;
		this.parser = tokenAcceptor;
		this.hiddenTokenHandler = hiddenTokenHandler;
		this.consumerUtil = consumerUtil;
		this.hiddenTokens = hiddenTokens;
	}

	public boolean consume(String feature, boolean isMany, boolean isDatatype, AbstractElement grammarElement) throws Exception {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		parser.accept(new ParsedNonTerminal(input, input.getOffset(), grammarElement != null ? grammarElement : getGrammarElement(), getDefaultTypeName()));
		boolean result = doConsume();
		if (result) {
			parser.accept(new ParsedNonTerminalEnd(input, input.getOffset(), feature, isMany, isDatatype));
		} else marker.rollback();
		prevState.restore();
		return result;
	}
	
	public boolean consumeAsRoot(IRootConsumerListener listener) throws Exception {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		parser.accept(new ParsedNonTerminal(input, input.getOffset(), getGrammarElement(), getDefaultTypeName()));
		boolean result = doConsume();
		if (result)
			result = listener.beforeNonTerminalEnd(this);
		if (result) {
			parser.accept(new ParsedNonTerminalEnd(input, input.getOffset(), null, false, false));
		} else marker.rollback();
		prevState.restore();
		return result;
	}
	
	protected final IMarker mark() {
		return markerFactory.mark();
	}
	
	protected final boolean consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean, ICharacterClass notFollowedBy) {
		return consumerUtil.consumeKeyword(keyword, feature, isMany, isBoolean, notFollowedBy);
	}
	
	protected final boolean consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany, boolean isBoolean, AbstractElement grammarElement, ISequenceMatcher notMatching) {
		return consumerUtil.consumeTerminal(consumer, feature, isMany, isBoolean, grammarElement, notMatching);
	}
	
	protected final boolean consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany, boolean isDatatype, AbstractElement grammarElement) throws Exception {
		return consumerUtil.consumeNonTerminal(consumer, feature, isMany, isDatatype, grammarElement);
	}
	
	protected final void consumeAction(String typeName, String feature, boolean isMany) {
		consumerUtil.consumeAction(typeName, feature, isMany);
	}
	
	protected abstract boolean doConsume() throws Exception;
	
	protected abstract String getDefaultTypeName(); // TODO: replace by getDefaultType: EClassifier
	
	protected abstract EObject getGrammarElement();

	@Override
	public String toString() {
		return "NonTerminalConsumer " + getClass().getSimpleName() + " for type '" + getDefaultTypeName()  + "'";
	}
	
}