package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl.ExUnorderedGroupsTestLanguageFileImpl;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser.UnorderedGroupsTestLanguageParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ExUnorderedGroupsTestLanguageParserDefinition extends UnorderedGroupsTestLanguageParserDefinition {

	@Inject 
	private ExUnorderedGroupsTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ExUnorderedGroupsTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
