package org.eclipse.xtext.xtend2.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.xtend2.services.Xtend2GrammarAccess;

@SuppressWarnings("restriction")
public class AbstractXtend2SyntacticSequencer extends AbstractSyntacticSequencer {

	protected Xtend2GrammarAccess grammarAccess;
	protected AbstractElementAlias match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a;
	protected AbstractElementAlias match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p;
	protected AbstractElementAlias match_XAnnotationElementValue_XBooleanLiteral_LeftParenthesisKeyword_7_0_a_FalseKeyword_1_0_RightParenthesisKeyword_7_2_p;
	protected AbstractElementAlias match_XAnnotation_XAnnotationElementValue___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q_RightParenthesisKeyword_7_2_p;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (Xtend2GrammarAccess) access;
		match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a = new TokenAlias(true, true, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0());
		match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p = new TokenAlias(false, true, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0());
		match_XAnnotationElementValue_XBooleanLiteral_LeftParenthesisKeyword_7_0_a_FalseKeyword_1_0_RightParenthesisKeyword_7_2_p = new GroupAlias(false, false, new TokenAlias(true, true, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0()), new TokenAlias(false, true, grammarAccess.getXAnnotationElementValueAccess().getRightParenthesisKeyword_7_2()));
		match_XAnnotation_XAnnotationElementValue___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q_RightParenthesisKeyword_7_2_p = new GroupAlias(false, false, new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2())), new TokenAlias(false, true, grammarAccess.getXAnnotationElementValueAccess().getRightParenthesisKeyword_7_2()));
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(true, false, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new TokenAlias(false, false, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1()), new TokenAlias(false, false, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()), new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(true, false, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()), new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new TokenAlias(false, false, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0()), new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new TokenAlias(false, false, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0()), new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new TokenAlias(false, false, grammarAccess.getXNullLiteralAccess().getNullKeyword_1()), new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new TokenAlias(false, false, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1()), new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new TokenAlias(false, false, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1()), new TokenAlias(false, true, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(ruleCall, node);
		return "";
	}
	
	protected String getOpSingleAssignToken(RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		if(match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a.equals(transition.getAmbiguousSyntax()))
			emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p.equals(transition.getAmbiguousSyntax()))
			emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p(semanticObject, transition, fromNode, toNode);
		else if(match_XAnnotationElementValue_XBooleanLiteral_LeftParenthesisKeyword_7_0_a_FalseKeyword_1_0_RightParenthesisKeyword_7_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XAnnotationElementValue_XBooleanLiteral_LeftParenthesisKeyword_7_0_a_FalseKeyword_1_0_RightParenthesisKeyword_7_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XAnnotation_XAnnotationElementValue___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q_RightParenthesisKeyword_7_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XAnnotation_XAnnotationElementValue___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q_RightParenthesisKeyword_7_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_XParenthesizedExpression_LeftParenthesisKeyword_0_p_LeftCurlyBracketKeyword_1_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_0_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else acceptNodes(transition, fromNode, toNode);
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('* 'false' ')'+
	 */
	protected void emit_XAnnotationElementValue_XBooleanLiteral_LeftParenthesisKeyword_7_0_a_FalseKeyword_1_0_RightParenthesisKeyword_7_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')? ')'+
	 */
	protected void emit_XAnnotation_XAnnotationElementValue___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q_RightParenthesisKeyword_7_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
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
	 *     ';'? '}' ')'+
	 */
	protected void emit_XBlockExpression_XParenthesizedExpression_SemicolonKeyword_2_1_q_RightCurlyBracketKeyword_3_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('* 'false' ')'+
	 */
	protected void emit_XBooleanLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_a_FalseKeyword_1_0_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
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
	 *     '('+ 'null' ')'+
	 */
	protected void emit_XNullLiteral_XParenthesizedExpression_LeftParenthesisKeyword_0_p_NullKeyword_1_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
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
	 *     '('+
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('* 'return' ')'+
	 */
	protected void emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_a_ReturnKeyword_1_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+ 'return' ')'+
	 */
	protected void emit_XParenthesizedExpression_XReturnExpression_LeftParenthesisKeyword_0_p_ReturnKeyword_1_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
}
