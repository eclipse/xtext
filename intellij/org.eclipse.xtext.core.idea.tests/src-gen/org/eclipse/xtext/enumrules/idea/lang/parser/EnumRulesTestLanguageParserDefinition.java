package org.eclipse.xtext.enumrules.idea.lang.parser;

import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.lang.psi.impl.EnumRulesTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EnumRulesTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private EnumRulesTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EnumRulesTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
