package org.eclipse.xtext.lexer.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

public class BacktrackingLexerTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public BacktrackingLexerTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(BacktrackingLexerTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
