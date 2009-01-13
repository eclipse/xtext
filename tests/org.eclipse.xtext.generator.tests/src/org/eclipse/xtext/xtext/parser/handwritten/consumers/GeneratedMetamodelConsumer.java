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
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.xtext.parser.handwritten.HandwrittenDelimiters;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class GeneratedMetamodelConsumer extends NonTerminalConsumer {
	
	private ITerminalConsumer idConsumer;
	
	private ITerminalConsumer stringConsumer;

	public GeneratedMetamodelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	protected boolean doConsume() throws Exception {
		SEQUENCE$0: {
			if (!consumeKeyword(XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele000KeywordGenerate(), null,
					false, false, HandwrittenDelimiters.idDelimiter()))
				break SEQUENCE$0;
			if (!consumeTerminal(idConsumer, "name", false, false, XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele0010LexerRuleCallID(), HandwrittenDelimiters.allKeywords))
				break SEQUENCE$0;
			//				if (!consumeTerminal(STRINGConsumer, "ePackage", false, false)) break SEQUENCE$0;
			if (!consumeTerminal(stringConsumer, null, false, false, XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele010CrossReferenceEStringEPackage(), HandwrittenDelimiters.allKeywords))
				break SEQUENCE$0;
			OPTION$1: {
				SEQUENCE$2: {
					IMarker marker$3 = mark();
					if (!consumeKeyword(XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele10KeywordAs(), null,
							false, false, HandwrittenDelimiters.idDelimiter()))
						break SEQUENCE$2;
					if (!consumeTerminal(idConsumer, "alias", false, false, XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().ele110LexerRuleCallID(), HandwrittenDelimiters.allKeywords)) {
						marker$3.rollback();
						break SEQUENCE$2;
					}
				}
				break OPTION$1;
			}
			return true;
		}
		return false;
	}

	protected EObject getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prGeneratedMetamodel().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "GeneratedMetamodel";
	}

	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}

	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
}