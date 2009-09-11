/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.xtext.ISetup;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IContentAssistProcessorTestSetup {

	ISetup getRefGrammarSetup();

	ISetup getXtextGrammarTestSetup();

	ISetup getXtextSetup();

	ISetup getContentAssistGrammarSetup();

	ISetup getKeywordsLangSetup();

	ISetup getEnumsLangSetup();
	
	ISetup getContentAssistContextTestLanguageSetup();
	
	ISetup getCrossReferenceProposalTestLanguageSetup();

	ISetup getDatatypeRuleTestLanguageSetup();
	
	ISetup getLookAheadContentAssistTestLanguageSetup();
	
	ISetup getBug286935TestLanguageSetup();
	
	ISetup getBug287941TestLanguageSetup();
	
	ISetup getBug288734TestLanguageSetup();
	
	ISetup getBug289187TestLanguageSetup();
}