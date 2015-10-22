package org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.psi.impl.BeeLangTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class BeeLangTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private BeeLangTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new BeeLangTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getModel_UnitsUnitParserRuleCall_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getUnit_NameIDTerminalRuleCall_3_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getUnit_UnitAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getUnit_NameIDTerminalRuleCall_3_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getProvidedCapability_NameIDTerminalRuleCall_2_1_1_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getProvidedCapability_ProvidedCapabilityAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getProvidedCapability_NameIDTerminalRuleCall_2_1_1_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAliasedRequiredCapability_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getRequiredCapability_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getRequiredCapability_RequiredCapabilityAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getRequiredCapability_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_2_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_FunctionsFunctionParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getFunction_NameIDTerminalRuleCall_5_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getFunction_NameIDTerminalRuleCall_5_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTopLevelExpression_VarDeclarationParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getVarDeclaration_NameIDTerminalRuleCall_2_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getVarDeclaration_DefValueAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getVarDeclaration_NameIDTerminalRuleCall_2_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTopLevelExpression_ValDeclarationParserRuleCall_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getValDeclaration_NameIDTerminalRuleCall_4_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getValDeclaration_DefValueAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getValDeclaration_NameIDTerminalRuleCall_4_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getUnaryExpression_ExprInfixExpressionParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getInfixExpression_CallFeatureFuncExprAction_1_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getInfixExpression_AtExpressionObjExprAction_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getInfixExpression_FeatureExpressionObjExprAction_1_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getPreopExpression_ExprInfixExpressionParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getPostopExpression_InfixExpressionParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getPrimaryExpression_ValueParserRuleCall_2ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getValue_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getValue_VariableExpressionAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getValue_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getFeatureCall_OperationCallParserRuleCallElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getOperationCall_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getOperationCall_CallNamedFunctionAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getOperationCall_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
