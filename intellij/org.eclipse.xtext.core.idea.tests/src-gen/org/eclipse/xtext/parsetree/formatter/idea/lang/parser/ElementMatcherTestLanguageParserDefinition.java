package org.eclipse.xtext.parsetree.formatter.idea.lang.parser;

import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.lang.psi.impl.ElementMatcherTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ElementMatcherTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private ElementMatcherTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ElementMatcherTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
