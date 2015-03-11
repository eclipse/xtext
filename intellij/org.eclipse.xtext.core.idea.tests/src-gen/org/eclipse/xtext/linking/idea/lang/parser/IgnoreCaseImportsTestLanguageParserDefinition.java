package org.eclipse.xtext.linking.idea.lang.parser;

import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.IgnoreCaseImportsTestLanguageFileImpl;
import org.eclipse.xtext.linking.idea.lang.parser.AbstractIgnoreCaseLinkingTestLanguageParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class IgnoreCaseImportsTestLanguageParserDefinition extends AbstractIgnoreCaseLinkingTestLanguageParserDefinition {

	@Inject 
	private IgnoreCaseImportsTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new IgnoreCaseImportsTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
