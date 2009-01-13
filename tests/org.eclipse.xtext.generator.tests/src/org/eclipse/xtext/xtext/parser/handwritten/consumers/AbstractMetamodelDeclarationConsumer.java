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
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class AbstractMetamodelDeclarationConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer generatedMetamodelConsumer;

	private INonTerminalConsumer referencedMetamodelConsumer;

	/**
	 * @param input
	 * @param markerFactory
	 * @param tokenAcceptor
	 * @param hiddenTokenHandler
	 * @param consumerUtil
	 * @param hiddenTokens
	 */
	public AbstractMetamodelDeclarationConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	protected boolean doConsume() throws Exception {
		ALTERNATIVE$0: {
			if (consumeNonTerminal(generatedMetamodelConsumer, null, false, false, XtextGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel()))
				break ALTERNATIVE$0;
			if (consumeNonTerminal(referencedMetamodelConsumer, null, false, false, XtextGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel()))
				break ALTERNATIVE$0;
			return false;
		}
		return true;
	}

	protected EObject getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractMetamodelDeclaration";
	}

	public void setGeneratedMetamodelConsumer(INonTerminalConsumer generatedMetamodelConsumer) {
		this.generatedMetamodelConsumer = generatedMetamodelConsumer;
	}

	public void setReferencedMetamodelConsumer(INonTerminalConsumer referencedMetamodelConsumer) {
		this.referencedMetamodelConsumer = referencedMetamodelConsumer;
	}
	
}