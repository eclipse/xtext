/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.parser.antlr.internal.InternalXtypeParser;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

public class XtypeParser extends AbstractAntlrParser {

	@Inject
	private XtypeGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalXtypeParser createParser(XtextTokenStream stream) {
		return new InternalXtypeParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "JvmTypeReference";
	}

	public XtypeGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XtypeGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
