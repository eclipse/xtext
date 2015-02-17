package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.LookaheadTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class LookaheadTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private LookaheadTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new LookaheadTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
