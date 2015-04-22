package org.eclipse.xtext.xtext.ecoreInference.idea.lang.parser;

import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageElementTypeProvider;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.psi.impl.UnassignedRuleCallTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class UnassignedRuleCallTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private UnassignedRuleCallTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new UnassignedRuleCallTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
