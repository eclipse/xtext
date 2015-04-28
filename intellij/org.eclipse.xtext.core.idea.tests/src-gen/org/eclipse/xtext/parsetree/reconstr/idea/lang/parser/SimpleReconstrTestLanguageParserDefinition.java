package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SimpleReconstrTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class SimpleReconstrTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private SimpleReconstrTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new SimpleReconstrTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getType_ExtendsTypeCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getEObjectRef_RefEObjectCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getCrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getCrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
