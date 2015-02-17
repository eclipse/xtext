package org.eclipse.xtext.parsetree.unassignedtext.idea.lang.parser;

import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.psi.impl.UnassignedTextTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class UnassignedTextTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private UnassignedTextTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new UnassignedTextTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
