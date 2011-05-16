package org.eclipse.xtext.xbase.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.analysis.NfaToGrammar.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.NfaToGrammar.ElementAlias;
import org.eclipse.xtext.serializer.analysis.NfaToGrammar.GroupAlias;
import org.eclipse.xtext.serializer.impl.AbstractSyntacticSequencer;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractXbaseSyntacticSequencer extends AbstractSyntacticSequencer {

	protected XbaseGrammarAccess grammarAccess;
	protected AbstractElementAlias<AbstractElement> match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias<AbstractElement> match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a;
	protected AbstractElementAlias<AbstractElement> match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias<AbstractElement> match_XBlockExpression_ExpressionsXExpressionInsideBlockParserRuleCall_2_0_0;
	protected AbstractElementAlias<AbstractElement> match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_a;
	protected AbstractElementAlias<AbstractElement> match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias<AbstractElement> match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias<AbstractElement> match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_a;
	protected AbstractElementAlias<AbstractElement> match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias<AbstractElement> match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_a_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a;
	protected AbstractElementAlias<AbstractElement> match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias<AbstractElement> match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias<AbstractElement> match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_NullKeyword_1_RightParenthesisKeyword_2_a;
	protected AbstractElementAlias<AbstractElement> match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XbaseGrammarAccess) access;
		match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(true, false, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()), new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(true, false, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()), new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXNullLiteralAccess().getNullKeyword_1()), new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBlockExpression_ExpressionsXExpressionInsideBlockParserRuleCall_2_0_0 = new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0());
		match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_a = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0()), new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()), new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1()), new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_a = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1()), new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0()), new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_a_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()), new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XBlockExpression_SemicolonKeyword_2_1_q = new ElementAlias<AbstractElement>(true, false, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_NullKeyword_1_RightParenthesisKeyword_2_a = new GroupAlias<AbstractElement>(false, false, new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new ElementAlias<AbstractElement>(false, false, grammarAccess.getXNullLiteralAccess().getNullKeyword_1()), new ElementAlias<AbstractElement>(true, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new ElementAlias<AbstractElement>(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(ruleCall, node);
		return "";
	}
	
	protected String getOpSingleAssignToken(RuleCall ruleCall, INode node) {
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		if(match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_ExpressionsXExpressionInsideBlockParserRuleCall_2_0_0.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_ExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_a.equals(transition.getAmbiguousSyntax()))
			emit_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_a(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_a.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_a(semanticObject, transition, fromNode, toNode);
		else if(match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_a_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_a_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_NullKeyword_1_RightParenthesisKeyword_2_a.equals(transition.getAmbiguousSyntax()))
			emit_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_NullKeyword_1_RightParenthesisKeyword_2_a(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, transition, fromNode, toNode);
		else acceptNodes(transition, fromNode, toNode);
	}

	/**
	 * Syntax:
	 *     ';'?? '}' ')'*
	 */
	protected void emit_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     ';'?? '}' ')'+
	 */
	protected void emit_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+ 'null' ')'+
	 */
	protected void emit_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     expressions+=XExpressionInsideBlock
	 */
	protected void emit_XBlockExpression_ExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('* 'false' ')'*
	 */
	protected void emit_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+ '{' '}' ')'+
	 */
	protected void emit_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+ 'return' ')'+
	 */
	protected void emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('* 'return' ')'*
	 */
	protected void emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+ 'false' ')'+
	 */
	protected void emit_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('* '{' '}' ')'*
	 */
	protected void emit_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_a_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     ';'??
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('* 'null' ')'*
	 */
	protected void emit_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_NullKeyword_1_RightParenthesisKeyword_2_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
}
