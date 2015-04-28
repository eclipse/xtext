package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.Bug317840TestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class Bug317840TestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private Bug317840TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new Bug317840TestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
