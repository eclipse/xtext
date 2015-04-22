package org.eclipse.xtext.parsetree.impl.idea.lang.parser;

import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.impl.idea.lang.psi.impl.CommentAssociationTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class CommentAssociationTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private CommentAssociationTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new CommentAssociationTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
