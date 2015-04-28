package org.eclipse.xtext.linking.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.LangATestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class LangATestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private LangATestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new LangATestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getType_ImplementsTypeCrossReference_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getType_ImplementsTypeCrossReference_3_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
