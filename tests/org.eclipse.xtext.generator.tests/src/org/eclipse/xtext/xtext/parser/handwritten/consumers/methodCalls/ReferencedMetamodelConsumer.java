/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.handwritten.consumers.methodCalls;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.xtext.parser.handwritten.HandwrittenDelimiters;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class ReferencedMetamodelConsumer extends NonTerminalConsumer {

	private ITerminalConsumer stringConsumer;

	private ITerminalConsumer idConsumer;

	/**
	 * @param input
	 * @param markerFactory
	 * @param tokenAcceptor
	 * @param hiddenTokenHandler
	 * @param hiddenTokens
	 */
	public ReferencedMetamodelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	protected boolean doConsume() throws Exception {
		if (!consumeKeyword(XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele00KeywordImport(), null, false,
				false, HandwrittenDelimiters.idDelimiter()))
			return false;
		//				if (!consumeTerminal(STRINGConsumer, "ePackage", false, false)) break SEQUENCE$0;
		if (!consumeTerminal(stringConsumer, null, false, false, XtextGrammarAccess.INSTANCE.prReferencedMetamodel()
				.ele010CrossReferenceEStringEPackage(), HandwrittenDelimiters.allKeywords))
			return false;
		if (!parseOption())
			return false;
		return true;
	}

	/**
	 * @return
	 */
	private boolean parseOption() {
		doParseOption();
		return true;
	}

	private boolean doParseOption() {
		IMarker marker$3 = mark();
		if (!consumeKeyword(XtextGrammarAccess.INSTANCE.prReferencedMetamodel().ele10KeywordAs(), null, false, false,
				HandwrittenDelimiters.idDelimiter())) {
			marker$3.rollback();
			return false;
		}
		if (!consumeTerminal(idConsumer, "alias", false, false, XtextGrammarAccess.INSTANCE.prReferencedMetamodel()
				.ele110LexerRuleCallID(), HandwrittenDelimiters.allKeywords)) {
			marker$3.rollback();
			return false;
		}
		return true;
	}

	protected EObject getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "GeneratedMetamodel";
	}

	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}

	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}

}