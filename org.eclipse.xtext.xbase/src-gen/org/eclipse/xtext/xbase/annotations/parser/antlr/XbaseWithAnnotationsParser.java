/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.annotations.parser.antlr.internal.InternalXbaseWithAnnotationsParser;
import org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess;

public class XbaseWithAnnotationsParser extends AbstractAntlrParser {

	@Inject
	private XbaseWithAnnotationsGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalXbaseWithAnnotationsParser createParser(XtextTokenStream stream) {
		return new InternalXbaseWithAnnotationsParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "XAnnotation";
	}

	public XbaseWithAnnotationsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XbaseWithAnnotationsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
