package org.eclipse.xtext.validation.idea.lang.parser;

import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageElementTypeProvider;
import org.eclipse.xtext.validation.idea.lang.psi.impl.ConcreteSyntaxValidationTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ConcreteSyntaxValidationTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private ConcreteSyntaxValidationTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ConcreteSyntaxValidationTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
