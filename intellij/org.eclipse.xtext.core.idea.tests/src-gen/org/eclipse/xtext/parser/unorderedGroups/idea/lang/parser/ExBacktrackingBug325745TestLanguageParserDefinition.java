package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl.ExBacktrackingBug325745TestLanguageFileImpl;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser.BacktrackingBug325745TestLanguageParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ExBacktrackingBug325745TestLanguageParserDefinition extends BacktrackingBug325745TestLanguageParserDefinition {

	@Inject 
	private ExBacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ExBacktrackingBug325745TestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
