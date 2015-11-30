package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.HiddenTerminalsTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class HiddenTerminalsTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new HiddenTerminalsTestLanguageFileImpl(viewProvider);
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
			if (elementType == elementTypeProvider.getModel_WithoutHiddensParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_WithHiddensParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_OverridingHiddensParserRuleCall_2ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_InheritingHiddensParserRuleCall_3ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_DatatypeHiddensParserRuleCall_4ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getWithoutHiddensElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getWithHiddensElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getOverridingHiddensElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getOverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getOverridingHiddensCallElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInheritingHiddensElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getDatatypeHiddensElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getHidingHiddensElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getHidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInheritingHiddensCallElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
