/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.SynStateType;
import org.eclipse.xtext.serializer.sequencer.RuleCallStack;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
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
		}
		acceptNodes(transition, nodes);
	}
	
	protected boolean startsWithUnaryOperator(EObject obj) {
		if(obj instanceof XUnaryOperation)
			return true;
		if(obj instanceof XBinaryOperation)
			return startsWithUnaryOperator(((XBinaryOperation)obj).getLeftOperand());
		return false;
	}
	
	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		if (rc == grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()) {
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

	/**
	 * XConstructorCall returns XExpression:
	 *    {XConstructorCall}
	 *    'new' constructor=[types::JvmConstructor|QualifiedName] 
	 *    (=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	 *    (=>'(' 
	 *      (
	 *          arguments+=XShortClosure
	 *        | arguments+=XExpression (',' arguments+=XExpression)*
	 *      )? 
	 *    ')')?
	 *    =>arguments+=XClosure?;
	 */
	@Override
	protected void emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(
			EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		if (semanticObject instanceof XConstructorCall) {
			Keyword kw = grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0();
			if (nodes != null) {
				for(INode node: nodes) {
					if (kw.equals(node.getGrammarElement())) {
						acceptUnassignedKeyword(kw, kw.getValue(), (ILeafNode) node);
						return;
					}
				}
			}
			
			XConstructorCall constructorCall = (XConstructorCall) semanticObject;
			if (constructorCall.eContainer() instanceof XMemberFeatureCall) {
				XMemberFeatureCall container = (XMemberFeatureCall) constructorCall.eContainer();
				if (container.getMemberCallTarget() == constructorCall && !container.isNullSafe()) {
					if (constructorCall.getArguments().isEmpty() && constructorCall.getTypeArguments().isEmpty()) {
						if (nodes != null) {
							ISynNavigable fromState = transition;
							RuleCallStack stack = contexts.peek().getStack().clone();
							List<ISynState> path = fromState.getShortestStackpruningPathTo(grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), stack);
							if (path != null) {
								for(ISynState synState: path) {
									if (synState.getType() != SynStateType.UNASSIGNED_PARSER_RULE_EXIT) {
										if (synState.getGrammarElement() == grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()) {
											super.emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(semanticObject, transition,	nodes);
											return;
										}		
									}
								}
							}
						}
						acceptUnassignedKeyword(kw, kw.getValue(), null);
						return;		
					}
				}
			} else if (constructorCall.getArguments().isEmpty() && constructorCall.getTypeArguments().isEmpty() && nodes == null) {
				acceptUnassignedKeyword(kw, kw.getValue(), null);
				return;
			}
		}
		super.emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(semanticObject, transition,	nodes);
	}
	
}
