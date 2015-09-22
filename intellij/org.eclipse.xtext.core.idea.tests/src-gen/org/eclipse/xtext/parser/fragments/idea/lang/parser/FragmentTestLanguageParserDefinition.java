package org.eclipse.xtext.parser.fragments.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.fragments.idea.lang.psi.impl.FragmentTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class FragmentTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private FragmentTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new FragmentTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getPRFNamedFragment_NameIDTerminalRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getPRFNamedFragment_NameIDTerminalRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPRFWithPredicate_PRFNamedFragmentParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getPRFNamedFragment_NameIDTerminalRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getPRFNamedRef_RefPRFNamedCrossReference_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
