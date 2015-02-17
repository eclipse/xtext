package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import static org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalEcoreTerminalsTestLanguageParser.*;

import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;

import com.google.inject.Singleton;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

@Singleton public class EcoreTerminalsTestLanguageTokenTypeProvider implements TokenTypeProvider {

	private static final IElementType[] tokenTypes = new IElementType[tokenNames.length];
	
	static {
		for (int i = 0; i < tokenNames.length; i++) {
			tokenTypes[i] = new IndexedElementType(tokenNames[i], i, EcoreTerminalsTestLanguageLanguage.INSTANCE);
		}
	}

	private static final TokenSet WHITESPACE_TOKENS = TokenSet.create(tokenTypes[RULE_WS]);
	private static final TokenSet COMMENT_TOKENS = TokenSet.EMPTY;
	private static final TokenSet STRING_TOKENS = TokenSet.EMPTY;

    public int getAntlrType(IElementType iElementType) {
        return ((IndexedElementType)iElementType).getLocalIndex();
    }
    
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
