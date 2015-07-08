package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import static org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalBug292245TestLanguageParser.*;

import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalBug292245TestLanguageParser;

import com.google.inject.Singleton;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

@Singleton public class Bug292245TestLanguageTokenTypeProvider implements TokenTypeProvider {

	private static final String[] TOKEN_NAMES = new PsiInternalBug292245TestLanguageParser(null).getTokenNames();

	private static final IElementType[] tokenTypes = new IElementType[TOKEN_NAMES.length];
	
	static {
		for (int i = 0; i < TOKEN_NAMES.length; i++) {
			tokenTypes[i] = new IndexedElementType(TOKEN_NAMES[i], i, Bug292245TestLanguageLanguage.INSTANCE);
		}
	}

	private static final TokenSet WHITESPACE_TOKENS = TokenSet.create(tokenTypes[RULE_WS]);
	private static final TokenSet COMMENT_TOKENS = TokenSet.EMPTY;
	private static final TokenSet STRING_TOKENS = TokenSet.EMPTY;

	@Override
    public int getAntlrType(IElementType iElementType) {
        return (iElementType instanceof IndexedElementType) ? ((IndexedElementType) iElementType).getLocalIndex()
        				: org.antlr.runtime.Token.INVALID_TOKEN_TYPE;
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
