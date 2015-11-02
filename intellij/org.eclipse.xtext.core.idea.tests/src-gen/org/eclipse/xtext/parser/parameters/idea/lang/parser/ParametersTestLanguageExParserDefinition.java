package org.eclipse.xtext.parser.parameters.idea.lang.parser;

import org.eclipse.xtext.parser.parameters.idea.lang.psi.impl.ParametersTestLanguageExFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ParametersTestLanguageExParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private ParametersTestLanguageExElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ParametersTestLanguageExFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getParserRuleParametersElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParserRuleParameters_ParserRuleParametersParserRuleCallElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getScenario1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getScenario1_Scenario1ParserRuleCallElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParametersElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ParserRuleParametersAction_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario1ParserRuleCall_1_0_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario1ParserRuleCall_1_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_2_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_3_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_4_0_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_5_0_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario3ParserRuleCall_1_6_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario3ParserRuleCall_1_7_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_8_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_8_1_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_9_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_9_1_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_10_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_10_1_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_11_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_11_1_1_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParametersTestLanguageScenario1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getScenario2ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getScenario3ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getScenario4ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
