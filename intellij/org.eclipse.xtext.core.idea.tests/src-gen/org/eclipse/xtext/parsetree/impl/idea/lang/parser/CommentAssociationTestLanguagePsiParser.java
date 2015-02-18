package org.eclipse.xtext.parsetree.impl.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.impl.idea.parser.antlr.internal.PsiInternalCommentAssociationTestLanguageParser;
import org.eclipse.xtext.parsetree.impl.services.CommentAssociationTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class CommentAssociationTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private CommentAssociationTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private CommentAssociationTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalCommentAssociationTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
