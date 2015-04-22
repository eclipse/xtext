package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.parser;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl.MultiGenMMTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class MultiGenMMTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private MultiGenMMTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new MultiGenMMTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
