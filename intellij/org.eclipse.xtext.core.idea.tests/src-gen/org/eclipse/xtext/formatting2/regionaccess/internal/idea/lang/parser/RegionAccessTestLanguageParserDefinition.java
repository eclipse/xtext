package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.psi.impl.RegionAccessTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class RegionAccessTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private RegionAccessTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new RegionAccessTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getRoot_SimpleParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getDelegation_DelegateDelegateParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getDelegate_NameIDTerminalRuleCall_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getUnassigned_DelegateParserRuleCall_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getDelegate_NameIDTerminalRuleCall_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getPrefixedDelegate_DelegateParserRuleCall_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getDelegate_NameIDTerminalRuleCall_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExpression_PrimaryParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getPrimary_NameIDTerminalRuleCall_0_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getPrimary_NamedAction_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getPrimary_NameIDTerminalRuleCall_0_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExpression_RightPrimaryParserRuleCall_1_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getPrimary_NameIDTerminalRuleCall_0_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getRoot_MixedParserRuleCall_5_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getMixed_ActionAction_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getMixed_AssignedActionChildAction_4_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getRoot_MixedMixedParserRuleCall_6_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getMixed_MixedParserRuleCall_2_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getMixed_BodyMixedParserRuleCall_4_2_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
