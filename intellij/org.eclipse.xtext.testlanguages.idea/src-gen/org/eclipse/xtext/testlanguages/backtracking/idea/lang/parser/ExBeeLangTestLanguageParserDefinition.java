package org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.psi.impl.ExBeeLangTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.BeeLangTestLanguageParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ExBeeLangTestLanguageParserDefinition extends BeeLangTestLanguageParserDefinition {

	@Inject 
	private ExBeeLangTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ExBeeLangTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
