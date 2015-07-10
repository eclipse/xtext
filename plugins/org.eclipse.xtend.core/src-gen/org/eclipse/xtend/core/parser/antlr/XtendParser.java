/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtend.core.services.XtendGrammarAccess;

public class XtendParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private XtendGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.xtend.core.parser.antlr.internal.InternalXtendParser createParser(XtextTokenStream stream) {
		return new org.eclipse.xtend.core.parser.antlr.internal.InternalXtendParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "File";
	}
	
	public XtendGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(XtendGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
