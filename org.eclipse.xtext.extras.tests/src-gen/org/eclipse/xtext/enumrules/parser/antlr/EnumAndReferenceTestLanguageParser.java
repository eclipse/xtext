/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.enumrules.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.enumrules.parser.antlr.internal.InternalEnumAndReferenceTestLanguageParser;
import org.eclipse.xtext.enumrules.services.EnumAndReferenceTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class EnumAndReferenceTestLanguageParser extends AbstractAntlrParser {

	@Inject
	private EnumAndReferenceTestLanguageGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalEnumAndReferenceTestLanguageParser createParser(XtextTokenStream stream) {
		return new InternalEnumAndReferenceTestLanguageParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "EntityWithEnumAndReference";
	}

	public EnumAndReferenceTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(EnumAndReferenceTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
