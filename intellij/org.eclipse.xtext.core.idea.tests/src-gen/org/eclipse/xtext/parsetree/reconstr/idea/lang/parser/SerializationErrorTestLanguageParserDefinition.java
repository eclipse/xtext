package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SerializationErrorTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class SerializationErrorTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private SerializationErrorTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new SerializationErrorTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModelElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_TestAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_TestTestParserRuleCall_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_TestAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_TestParenthesisParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParenthesisElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParenthesis_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParenthesis_LeftParenthesisKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParenthesis_TestParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParenthesis_RightParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTestElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTest_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTest_TwoRequiredParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTest_TwoOptionsParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTest_IndentParserRuleCall_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoRequiredElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoRequired_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoRequired_TworequiredKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoRequired_OneAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoRequired_OneIDTerminalRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoRequired_TwoAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoRequired_TwoIDTerminalRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptionsElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_TwooptionsKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_OneKeyword_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_OneAssignment_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_OneIDTerminalRuleCall_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_TwoKeyword_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_TwoAssignment_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTwoOptions_TwoIDTerminalRuleCall_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndentElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_LeftCurlyBracketKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_ReqAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_ReqTwoRequiredParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_OptAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_OptTwoOptionsParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_IndentAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_IndentIndentParserRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIndent_RightCurlyBracketKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		throw new java.lang.IllegalStateException("Unexpected element type: " + elementType);
	}

}
