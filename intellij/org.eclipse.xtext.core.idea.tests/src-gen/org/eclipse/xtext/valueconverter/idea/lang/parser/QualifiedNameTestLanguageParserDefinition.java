package org.eclipse.xtext.valueconverter.idea.lang.parser;

import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageElementTypeProvider;
import org.eclipse.xtext.valueconverter.idea.lang.psi.impl.QualifiedNameTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class QualifiedNameTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private QualifiedNameTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new QualifiedNameTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
