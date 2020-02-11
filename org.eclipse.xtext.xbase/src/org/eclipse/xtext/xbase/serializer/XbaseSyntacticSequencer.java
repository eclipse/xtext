/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;

public class XbaseSyntacticSequencer extends AbstractXbaseSyntacticSequencer {
	
	boolean semicolonBeforeNextExpressionRequired = false;
	
	/**
	 * Syntax: '('*
	 */
	@Override
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject,
			ISynNavigable transition, List<INode> nodes) {

		Keyword kw = grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0();

		if (nodes == null) {
			if (semanticObject instanceof XIfExpression || semanticObject instanceof XTryCatchFinallyExpression) {
				EObject cnt = semanticObject.eContainer();
				if (cnt instanceof XExpression && !(cnt instanceof XBlockExpression)
						&& !(cnt instanceof XForLoopExpression))
					acceptUnassignedKeyword(kw, kw.getValue(), null);
			}
			if (semanticObject instanceof XConstructorCall) {
				XConstructorCall call = (XConstructorCall) semanticObject;
				if (!call.isExplicitConstructorCall() && call.getArguments().isEmpty()) {
					acceptUnassignedKeyword(kw, kw.getValue(), null);
				}
			}
		}
		acceptNodes(transition, nodes);
	}
	
	protected boolean startsWithUnaryOperator(EObject obj) {
		if(obj instanceof XUnaryOperation)
			return true;
		if(obj instanceof XBinaryOperation)
			return startsWithUnaryOperator(((XBinaryOperation)obj).getLeftOperand());
		if(obj instanceof XPostfixOperation) {
			return startsWithUnaryOperator(((XPostfixOperation)obj).getOperand());
		}
		return false;
	}
	
	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		if (rc == grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0()) {
			semicolonBeforeNextExpressionRequired = startsWithUnaryOperator(semanticChild);
		} else
			semicolonBeforeNextExpressionRequired = false;
		return super.enterAssignedParserRuleCall(rc, semanticChild, node);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	@Override
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		if (semicolonBeforeNextExpressionRequired) {
			ILeafNode node = nodes != null && nodes.size() == 1 && nodes.get(0) instanceof ILeafNode ? (ILeafNode) nodes.get(0) : null;
			Keyword kw = grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1();
			acceptUnassignedKeyword(kw, kw.getValue(), node);
		} else
			acceptNodes(transition, nodes);
	}
	
	@Override
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
}
