/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.handwritten.consumers;

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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class GrammarConsumer extends NonTerminalConsumer {

	private ITerminalConsumer idConsumer;
	
	private INonTerminalConsumer abstractMetamodelDeclarationConsumer;

	private INonTerminalConsumer abstractRuleConsumer;

	public GrammarConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory, IParsedTokenAcceptor tokenAcceptor,
			IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil, ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	protected String getDefaultTypeName() {
		return "Grammar";
	}

	protected boolean doConsume() throws Exception {
		SEQUENCE$0: {
			ALTERNATIVE$1: {
				if (consumeKeyword(getRule().ele0000000KeywordAbstractLanguage(),
						"abstract", false, true))
					break ALTERNATIVE$1;
				if (consumeKeyword(getRule().ele000001KeywordLanguage(), null, false,
						false))
					break ALTERNATIVE$1;
				break SEQUENCE$0;
			}
			if (!consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000010LexerRuleCallID()))
				break SEQUENCE$0;
			LOOP$2: while (true) { // * cardinality - while(true)
				SEQUENCE$3: {
					IMarker marker$4 = mark(); // first part of alternative is sequence, so mark the position before the sequence
					// '.'
					if (!consumeKeyword(getRule().ele00010KeywordFullStop(), null, false,
							false))
						break SEQUENCE$3;
					// idElements+=ID
					if (!consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000110LexerRuleCallID())) {
						marker$4.rollback();
						break SEQUENCE$3; // jump back into previous alternative, because we were optional
					}
					continue LOOP$2;
				}
				break LOOP$2;
			}

			OPTION$5: do {
				SEQUENCE$5: {
					IMarker marker$5 = mark();
					if (!consumeKeyword(getRule().ele00100KeywordExtends(), null, false,
							false))
						break SEQUENCE$5;
					if (!consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010LexerRuleCallID())) {
						marker$5.rollback();
						break SEQUENCE$5;
					}
					LOOP$6: while (true) { // * cardinality - while(true)
						SEQUENCE$7: {
							IMarker marker$8 = mark(); // first part of alternative is sequence, so mark the position before the sequence
							// '\\\\'
							if (!consumeKeyword(getRule().ele00010KeywordFullStop(),
									null, false, false))
								break SEQUENCE$7;
							if (!consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010LexerRuleCallID())) {
								marker$8.rollback();
								break SEQUENCE$7;
							}
							continue LOOP$6;
						}
						break LOOP$6;
					}
					continue OPTION$5;
				}
				break OPTION$5;
			} while (false);

			LOOP$9: while (true) {
				if (!consumeNonTerminal(abstractMetamodelDeclarationConsumer, "metamodelDeclarations", true, false, getRule().ele010ParserRuleCallAbstractMetamodelDeclaration()))
					break LOOP$9;
				continue LOOP$9;
			}
			
			if (!consumeNonTerminal(abstractRuleConsumer, "rules", true, false, getRule().ele10ParserRuleCallAbstractRule()))
				break SEQUENCE$0;
			LOOP$10: while (true) {
				if (!consumeNonTerminal(abstractRuleConsumer, "rules", true, false, getRule().ele10ParserRuleCallAbstractRule()))
					break LOOP$10;
				continue LOOP$10;
			}

			return true;
		}
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