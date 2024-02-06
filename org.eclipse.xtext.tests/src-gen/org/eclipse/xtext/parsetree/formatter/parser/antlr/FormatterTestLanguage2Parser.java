/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parsetree.formatter.parser.antlr.internal.InternalFormatterTestLanguage2Parser;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguage2GrammarAccess;

public class FormatterTestLanguage2Parser extends AbstractAntlrParser {

	@Inject
	private FormatterTestLanguage2GrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalFormatterTestLanguage2Parser createParser(XtextTokenStream stream) {
		return new InternalFormatterTestLanguage2Parser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Root";
	}

	public FormatterTestLanguage2GrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(FormatterTestLanguage2GrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
