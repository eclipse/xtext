package org.eclipse.xtext.resource.idea.lang.parser;

import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageElementTypeProvider;
import org.eclipse.xtext.resource.idea.lang.psi.impl.LiveContainerBuilderIntegerationTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class LiveContainerBuilderIntegerationTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private LiveContainerBuilderIntegerationTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new LiveContainerBuilderIntegerationTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
