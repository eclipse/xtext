package org.eclipse.xtext.parser.fragments.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExElementTypeProvider;
import org.eclipse.xtext.parser.fragments.idea.lang.psi.impl.FragmentTestLanguageExFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class FragmentTestLanguageExParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private FragmentTestLanguageExElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new FragmentTestLanguageExFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
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
		}
		return super.createElement(node);
	}

}
