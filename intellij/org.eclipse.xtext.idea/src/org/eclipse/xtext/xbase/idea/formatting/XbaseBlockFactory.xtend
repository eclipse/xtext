/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.formatting

import com.google.inject.Inject
import com.intellij.formatting.SpacingBuilder
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.CodeStyleSettings
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.idea.formatting.DefaultBlockFactory
import org.eclipse.xtext.idea.lang.IElementTypeProvider
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess
import com.google.inject.Singleton

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class XbaseBlockFactory extends DefaultBlockFactory {

	@Inject
	extension XbaseGrammarAccess

	@Inject
	extension IElementTypeProvider elementTypeProvider

	protected override createSpacingBuilder(CodeStyleSettings settings, Language language) {
		val spacingBuilder = new SpacingBuilder(settings, language)
		for (pair : findKeywordPairs('{', '}').map [
			first.findElementType -> second.findElementType
		]) {
			spacingBuilder.before(pair.key).spaces(1)
			spacingBuilder.withinPair(pair.key, pair.value).lineBreakInCode
		}
		for (commaType : #[','].findKeywords.map[findElementType]) {
			spacingBuilder.before(commaType).spaces(0)
			spacingBuilder.after(commaType).spaces(1)
		}
		for (pair : findKeywordPairs('(', ')').map [
			first.findElementType -> second.findElementType
		]) {
			spacingBuilder.withinPair(pair.key, pair.value).none
			spacingBuilder.around(pair.key).spaces(0)
			spacingBuilder.before(pair.value).spaces(0)
			spacingBuilder.after(pair.value).spaces(1)
		}
		spacingBuilder
	}

	protected override isContinuation(EObject grammarElement) {
		if(grammarElement == null) return false

		switch grammarElement {
			case XAssignmentAccess.XAssignmentAction_0_0,
			case XAssignmentAccess.XBinaryOperationLeftOperandAction_1_1_0_0_0,
			case XOrExpressionAccess.XBinaryOperationLeftOperandAction_1_0_0_0,
			case XAndExpressionAccess.XBinaryOperationLeftOperandAction_1_0_0_0,
			case XEqualityExpressionAccess.XBinaryOperationLeftOperandAction_1_0_0_0,
			case XRelationalExpressionAccess.XInstanceOfExpressionExpressionAction_1_0_0_0_0,
			case XRelationalExpressionAccess.XBinaryOperationLeftOperandAction_1_1_0_0_0,
			case XOtherOperatorExpressionAccess.XBinaryOperationLeftOperandAction_1_0_0_0,
			case XAdditiveExpressionAccess.XBinaryOperationLeftOperandAction_1_0_0_0,
			case XMultiplicativeExpressionAccess.XBinaryOperationLeftOperandAction_1_0_0_0,
			case XUnaryOperationAccess.XUnaryOperationAction_0_0,
			case XCastedExpressionAccess.XCastedExpressionTargetAction_1_0_0_0,
			case XPostfixOperationAccess.XPostfixOperationOperandAction_1_0_0,
			case XMemberFeatureCallAccess.XAssignmentAssignableAction_1_0_0_0_0,
			case XShortClosureAccess.XClosureAction_0_0_0:
				true
			default:
				false
		}
	}

	protected override isStructural(EObject grammarElement) {
		if(grammarElement == null) return false

		switch grammarElement {
			case XIfExpressionAccess.thenXExpressionParserRuleCall_5_0,
			case XIfExpressionAccess.elseXExpressionParserRuleCall_6_1_0,
			case XSwitchExpressionAccess.defaultXExpressionParserRuleCall_5_2_0,
			case XCasePartAccess.thenXExpressionParserRuleCall_3_0_1_0,
			case XForLoopExpressionAccess.eachExpressionXExpressionParserRuleCall_3_0,
			case XBasicForLoopExpressionAccess.eachExpressionXExpressionParserRuleCall_9_0,
			case XWhileExpressionAccess.bodyXExpressionParserRuleCall_5_0,
			case XDoWhileExpressionAccess.bodyXExpressionParserRuleCall_2_0,
			case XVariableDeclarationAccess.rightXExpressionParserRuleCall_3_1_0,
			case XThrowExpressionAccess.expressionXExpressionParserRuleCall_2_0,
			case XReturnExpressionAccess.expressionXExpressionParserRuleCall_2_0,
			case XTryCatchFinallyExpressionAccess.expressionXExpressionParserRuleCall_2_0,
			case XTryCatchFinallyExpressionAccess.finallyExpressionXExpressionParserRuleCall_3_0_1_1_0,
			case XTryCatchFinallyExpressionAccess.finallyExpressionXExpressionParserRuleCall_3_1_1_0,
			case XCatchClauseAccess.expressionXExpressionParserRuleCall_4_0,
			case XSynchronizedExpressionAccess.expressionXExpressionParserRuleCall_3_0:
				true
			default:
				false
		}
	}

}