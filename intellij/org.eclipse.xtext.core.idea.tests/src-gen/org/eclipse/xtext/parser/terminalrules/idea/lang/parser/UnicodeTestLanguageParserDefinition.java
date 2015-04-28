package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.UnicodeTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class UnicodeTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private UnicodeTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new UnicodeTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
