package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SerializationErrorTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;

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
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getModelElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_TestTestParserRuleCall_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_TestParenthesisParserRuleCall_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesisElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesis_TestParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTestElementType()) {
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
			if (elementType == elementTypeProvider.getTwoOptionsElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getIndentElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getIndent_ReqTwoRequiredParserRuleCall_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getIndent_OptTwoOptionsParserRuleCall_2_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getIndent_IndentIndentParserRuleCall_3_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
