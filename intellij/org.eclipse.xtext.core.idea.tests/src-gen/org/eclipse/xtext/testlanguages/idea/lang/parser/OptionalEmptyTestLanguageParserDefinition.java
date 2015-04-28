package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.OptionalEmptyTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class OptionalEmptyTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private OptionalEmptyTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new OptionalEmptyTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
