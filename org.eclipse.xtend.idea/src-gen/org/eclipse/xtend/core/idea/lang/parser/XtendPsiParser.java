/*******************************************************************************
 * Copyright (c) 2010-2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.lang.parser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtend.core.idea.lang.XtendElementTypeProvider;
import org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;

public class XtendPsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private XtendGrammarAccess grammarAccess;

	@Inject 
	private XtendElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXtendParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}
}
