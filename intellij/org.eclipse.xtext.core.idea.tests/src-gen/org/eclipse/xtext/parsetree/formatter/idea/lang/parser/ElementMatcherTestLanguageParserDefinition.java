package org.eclipse.xtext.parsetree.formatter.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.lang.psi.impl.ElementMatcherTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ElementMatcherTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private ElementMatcherTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ElementMatcherTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getModel_SimpleParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_RuleCallsParserRuleCall_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getRuleCalls_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getRuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getRuleCallsAss1_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getRuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getRuleCallsAss2_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_OptionalCallsParserRuleCall_2ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getOptionalCalls_NameIDTerminalRuleCall_3_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getOptionalCalls_OptionalCallsAction_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getOptionalCalls_NameIDTerminalRuleCall_3_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getOptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getOptionalCallsSub2_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getOptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getOptionalCallsSub3_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_NestedStartParserRuleCall_7ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getNestedStart_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
