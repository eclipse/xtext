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
import org.eclipse.xtext.services.XtextGrammarAccess.TypeRefElements;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeRefConsumer extends NonTerminalConsumer {

	private ITerminalConsumer idConsumer;

	public TypeRefConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	@Override
	protected boolean doConsume() throws Exception {
		SEQUENCE$0: {
			OPTION$1: do {
				SEQUENCE$2: {
					IMarker marker$4 = mark();
					if (!consumeTerminal(idConsumer, null, false, false, getRule().ele000CrossReferenceEStringAbstractMetamodelDeclaration())) break SEQUENCE$2;
					if (!consumeKeyword(getRule().ele01KeywordColonColon(), null, false, false)) {
						marker$4.rollback();
						break SEQUENCE$2;
					}
					continue OPTION$1;
				}
				break OPTION$1;
			} while(false);
			
			if (!consumeTerminal(idConsumer, null, false, false, getRule().ele10CrossReferenceEStringEClassifier()))
				break SEQUENCE$0;
			return true;
		}
		return false;
	}

	@Override
	protected String getDefaultTypeName() {
		return "TypeRef";
	}

	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	private TypeRefElements getRule() {
		return XtextGrammarAccess.INSTANCE.prTypeRef();
	}

	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}

}
