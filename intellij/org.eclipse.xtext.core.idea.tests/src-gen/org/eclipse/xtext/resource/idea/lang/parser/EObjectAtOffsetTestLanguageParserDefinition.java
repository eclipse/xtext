package org.eclipse.xtext.resource.idea.lang.parser;

import org.eclipse.xtext.resource.idea.lang.psi.impl.EObjectAtOffsetTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EObjectAtOffsetTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private EObjectAtOffsetTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EObjectAtOffsetTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getModelElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_FoosFooParserRuleCall_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_BarsAbstractBarParserRuleCall_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractBarElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractBar_BarParserRuleCall_2ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractBar_FooBarBarAction_3_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getBarElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getFooElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
