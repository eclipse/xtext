package org.eclipse.xtext.parser.assignments.idea.lang.parser;

import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.lang.psi.impl.AssignmentsTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class AssignmentsTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private AssignmentsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new AssignmentsTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
