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
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.GrammarElements;
import org.eclipse.xtext.xtext.parser.handwritten.HandwrittenDelimiters;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class GrammarConsumer extends NonTerminalConsumer {

	private ITerminalConsumer idConsumer;

	private INonTerminalConsumer abstractMetamodelDeclarationConsumer;

	private INonTerminalConsumer abstractRuleConsumer;

	public GrammarConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	protected String getDefaultTypeName() {
		return "Grammar";
	}

	protected boolean doConsume() throws Exception {
		if (!parseOption())
			return false;
		if (!consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000010LexerRuleCallID(),
				HandwrittenDelimiters.allKeywords))
			return false;
		if (!parseIds())
			return false;
		if (!parseExtends())
			return false;
		if (!parseMetamodels())
			return false;

		if (!parseRules())
			return false;

		return true;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private boolean parseRules() throws Exception {
		if (parseRulesImpl()) {
			while (parseRulesImpl())
				;
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private boolean parseRulesImpl() throws Exception {
		return consumeNonTerminal(abstractRuleConsumer, "rules", true, false, getRule()
				.ele10ParserRuleCallAbstractRule());
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private boolean parseMetamodels() throws Exception {
		while (parseMetamodelsImpl())
			;
		return true;
	}

	private boolean parseMetamodelsImpl() throws Exception {
		return consumeNonTerminal(abstractMetamodelDeclarationConsumer, "metamodelDeclarations", true, false, getRule()
				.ele010ParserRuleCallAbstractMetamodelDeclaration());
	}

	private boolean parseExtends() {
		parseExtendsImpl();
		return true;
	}

	private boolean parseExtendsImpl() {
		IMarker marker = mark();
		if (!consumeKeyword(getRule().ele00100KeywordExtends(), null, false, false, HandwrittenDelimiters.idDelimiter())) {
			marker.rollback();
			return false;
		}
		if (!consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010LexerRuleCallID(),
				HandwrittenDelimiters.allKeywords)) {
			marker.rollback();
			return false;
		}
		if (!parseSuperIds()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	/**
	 * @return
	 */
	private boolean parseSuperIds() {
		while (parseSuperIdsImpl())
			;
		return true;
	}

	private boolean parseSuperIdsImpl() {
		IMarker marker = mark(); // first part of alternative is sequence, so mark the position before the sequence
		// '\\\\'
		if (!consumeKeyword(getRule().ele00010KeywordFullStop(), null, false, false, null)) {
			marker.rollback();
			return false;
		}
		if (!consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010LexerRuleCallID(),
				HandwrittenDelimiters.allKeywords)) {
			marker.rollback();
			return false;
		}
		return true;
	}

	private boolean parseIds() {
		while (parseIdsImpl())
			;
		return true;
	}

	/**
	 * @return
	 */
	private boolean parseIdsImpl() {
		IMarker marker = mark(); // first part of alternative is sequence, so mark the position before the sequence
		if (!consumeKeyword(getRule().ele00010KeywordFullStop(), null, false, false, null)) {
			marker.rollback();
			return false;
		}
		if (!consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000110LexerRuleCallID(),
				HandwrittenDelimiters.allKeywords)) {
			marker.rollback();
			return false;
		}
		return true;
	}

	/**
	 * @return
	 * 
	 */
	private boolean parseOption() {
		if (consumeKeyword(getRule().ele0000000KeywordAbstractLanguage(), "abstract", false, true,
				HandwrittenDelimiters.idDelimiter()))
			return true;
		if (consumeKeyword(getRule().ele000001KeywordLanguage(), null, false, false, null))
			return true;
		return false;
	}

	private GrammarElements getRule() {
		return XtextGrammarAccess.INSTANCE.prGrammar();
	}

	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}

	public void setAbstractMetamodelDeclarationConsumer(INonTerminalConsumer abstractMetamodelDeclarationConsumer) {
		this.abstractMetamodelDeclarationConsumer = abstractMetamodelDeclarationConsumer;
	}

	public void setAbstractRuleConsumer(INonTerminalConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}

}