package org.eclipse.xtext.parsetree.formatter.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.lang.psi.impl.FormatterTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class FormatterTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private FormatterTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new FormatterTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getFqnRef_RefFqnObjCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
