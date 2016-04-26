/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.lang.parser;

import com.google.inject.Singleton;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.antlr.runtime.Token;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.example.entities.idea.parser.antlr.internal.PsiInternalEntitiesParser;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;

@Singleton
public class EntitiesTokenTypeProvider implements TokenTypeProvider {

	private static final String[] TOKEN_NAMES = new PsiInternalEntitiesParser(null).getTokenNames();

	private static final IElementType[] tokenTypes = new IElementType[TOKEN_NAMES.length];
	
	static {
		for (int i = 0; i < TOKEN_NAMES.length; i++) {
			tokenTypes[i] = new IndexedElementType(TOKEN_NAMES[i], i, EntitiesLanguage.INSTANCE);
		}
	}

	private static final TokenSet WHITESPACE_TOKENS = TokenSet.create(tokenTypes[PsiInternalEntitiesParser.RULE_WS]);
	private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[PsiInternalEntitiesParser.RULE_SL_COMMENT], tokenTypes[PsiInternalEntitiesParser.RULE_ML_COMMENT]);
	private static final TokenSet STRING_TOKENS = TokenSet.create(tokenTypes[PsiInternalEntitiesParser.RULE_STRING]);

	@Override
	public int getAntlrType(IElementType iElementType) {
		return (iElementType instanceof IndexedElementType) ? ((IndexedElementType) iElementType).getLocalIndex() : Token.INVALID_TOKEN_TYPE;
	}

	@Override
	public IElementType getIElementType(int antlrType) {
		return tokenTypes[antlrType];
	}

	@Override
	public TokenSet getWhitespaceTokens() {
		return WHITESPACE_TOKENS;
	}

	@Override
	public TokenSet getCommentTokens() {
		return COMMENT_TOKENS;
	}

	@Override
	public TokenSet getStringLiteralTokens() {
		return STRING_TOKENS;
	}

}
