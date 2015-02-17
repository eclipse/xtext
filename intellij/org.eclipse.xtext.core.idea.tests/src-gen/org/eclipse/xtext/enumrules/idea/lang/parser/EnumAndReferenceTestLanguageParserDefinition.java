package org.eclipse.xtext.enumrules.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.lang.psi.impl.EnumAndReferenceTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EnumAndReferenceTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private EnumAndReferenceTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EnumAndReferenceTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getEntityWithEnumAndReference_RefEntityWithEnumAndReferenceCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
