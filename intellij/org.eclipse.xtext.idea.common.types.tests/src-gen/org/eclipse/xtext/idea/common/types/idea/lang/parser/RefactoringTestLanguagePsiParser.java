package org.eclipse.xtext.idea.common.types.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.common.types.idea.parser.antlr.internal.PsiInternalRefactoringTestLanguageParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class RefactoringTestLanguagePsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private RefactoringTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalRefactoringTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

}
