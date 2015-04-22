package org.eclipse.xtext.grammarinheritance.idea.lang.parser;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl.InheritanceTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class InheritanceTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private InheritanceTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new InheritanceTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
