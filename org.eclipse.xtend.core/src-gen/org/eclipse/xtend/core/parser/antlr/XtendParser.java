/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendParser;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class XtendParser extends AbstractAntlrParser {

	@Inject
	private XtendGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalXtendParser createParser(XtextTokenStream stream) {
		return new InternalXtendParser(stream, getGrammarAccess());
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
