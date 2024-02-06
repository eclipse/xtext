/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.common.types.xtext.ui.parser.antlr.internal.InternalRefactoringTestLanguage1Parser;
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguage1GrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class RefactoringTestLanguage1Parser extends AbstractAntlrParser {

	@Inject
	private RefactoringTestLanguage1GrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalRefactoringTestLanguage1Parser createParser(XtextTokenStream stream) {
		return new InternalRefactoringTestLanguage1Parser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Entry";
	}

	public RefactoringTestLanguage1GrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RefactoringTestLanguage1GrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
