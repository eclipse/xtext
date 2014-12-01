package org.eclipse.xtext.xbase.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.xbase.idea.lang.XbaseElementTypeProvider;
import org.eclipse.xtext.xbase.idea.lang.psi.impl.XbaseFileImpl;
import org.eclipse.xtext.xbase.idea.lang.parser.XtypeParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class XbaseParserDefinition extends XtypeParserDefinition {

	@Inject 
	private XbaseElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new XbaseFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType(),
				elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getFullJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_XVariableDeclarationAction_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType(),
				elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
