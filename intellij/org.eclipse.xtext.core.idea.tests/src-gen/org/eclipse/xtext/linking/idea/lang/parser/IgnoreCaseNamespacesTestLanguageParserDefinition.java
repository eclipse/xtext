package org.eclipse.xtext.linking.idea.lang.parser;

import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.IgnoreCaseNamespacesTestLanguageFileImpl;
import org.eclipse.xtext.linking.idea.lang.parser.AbstractIgnoreCaseLinkingTestLanguageParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class IgnoreCaseNamespacesTestLanguageParserDefinition extends AbstractIgnoreCaseLinkingTestLanguageParserDefinition {

	@Inject 
	private IgnoreCaseNamespacesTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new IgnoreCaseNamespacesTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
