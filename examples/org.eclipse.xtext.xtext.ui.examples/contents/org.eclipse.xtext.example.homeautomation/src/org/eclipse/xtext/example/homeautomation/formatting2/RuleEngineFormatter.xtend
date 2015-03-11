/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.formatting2;

import com.google.inject.Inject
import org.eclipse.xtext.example.homeautomation.ruleEngine.Declaration
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule
import org.eclipse.xtext.example.homeautomation.ruleEngine.State
import org.eclipse.xtext.example.homeautomation.services.RuleEngineGrammarAccess
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.xbase.XBasicForLoopExpression
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XCatchClause
import org.eclipse.xtext.xbase.XDoWhileExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XSynchronizedExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XWhileExpression
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*

/**
 * The formatter is particularly important for languages with semantic whitespace, since it is responsible
 * for producing correct whitespace that reflects the semantic structure. This formatter actually modifies
 * the structure by converting single expressions in control statements to block expressions. For instance,
 * <pre>
 *     if (condition) println
 * </pre>
 * becomes
 * <pre>
 *     if (condition)
 *         println
 * </pre>
 */
class RuleEngineFormatter extends XbaseFormatter {
	
	@Inject extension RuleEngineGrammarAccess

	def dispatch void format(Model model, extension IFormattableDocument document) {
		model.prepend[setNewLines(0, 0, 1); noSpace]
		for (Declaration declaration : model.getDeclarations()) {
			format(declaration, document);
		}
	}

	def dispatch void format(Device device, extension IFormattableDocument document) {
		for (State state : device.getStates()) {
			if (state == device.states.last)
				state.append[setNewLines(1, 1, 2)]
			else
				state.append[noSpace]
			format(state, document);
		}
	}

	def dispatch void format(Rule rule, extension IFormattableDocument document) {
		format(rule.getThenPart(), document);
	}

	override dispatch void format(XBlockExpression expr, extension IFormattableDocument document) {
		val begin = expr.regionForRuleCallTo(BEGINRule)
		begin.prepend[setNewLines(1, 1, 2); increaseIndentation; noSpace]
		val end = expr.regionForRuleCallTo(ENDRule)
		if (expr.lastInBlock)
			end.append[decreaseIndentation]
		else
			end.append[setNewLines(1, 1, 2); decreaseIndentation; noSpace]
		for (child : expr.expressions) {
			val sem = child.immediatelyFollowingKeyword(";")
			if (sem != null) {
				sem.prepend[noSpace]
				if (child != expr.expressions.last)
					sem.append[setNewLines(1, 1, 2)]
			} else if (child != expr.expressions.last)
				child.append[setNewLines(1, 1, 2)]
			child.format(document)
		}
	}

	override dispatch void format(XSwitchExpression expr, extension IFormattableDocument document) {
		expr.regionForKeyword("switch").append[oneSpace]
		val begin = expr.regionForRuleCallTo(BEGINRule)
		begin.prepend[newLine; increaseIndentation; noSpace]
		val end = expr.regionForRuleCallTo(ENDRule)
		if (expr.lastInBlock)
			end.append[decreaseIndentation]
		else
			end.append[setNewLines(1, 1, 2); decreaseIndentation; noSpace]
		for (c : expr.cases) {
			if (c.typeGuard != null && c.^case != null) {
				c.typeGuard.append[oneSpace]
				c.^case.append[noSpace]
			} else if (c.typeGuard != null) {
				c.typeGuard.append[noSpace]
			} else if (c.^case != null) {
				c.^case.prepend[oneSpace].append[noSpace]
			}
			if (c.isFallThrough) {
				c.regionForFeature(XCASE_PART__FALL_THROUGH).prepend[noSpace].append[newLine]
			} else if (!(c.then instanceof XBlockExpression)) {
				c.then.prepend[newLine; increaseIndentation]
				if (expr.^default != null || c != expr.cases.last)
					c.then.append[newLine; decreaseIndentation]
				else
					c.then.append[decreaseIndentation]
			}
			c.^case.format(document)
			c.then.format(document)
		}
		if (expr.^default != null) {
			expr.regionForKeyword("default").append[noSpace]
			if (!(expr.^default instanceof XBlockExpression))
				expr.^default.prepend[newLine; increaseIndentation].append[decreaseIndentation]
			expr.^default.format(document)
		}
	}
	
	private def isLastInBlock(XExpression expr) {
		switch (expr.eContainer.eClass) {
			case XBLOCK_EXPRESSION: {
				val blockExpr = expr.eContainer as XBlockExpression
				return expr == blockExpr.expressions.last
			}
			case XSWITCH_EXPRESSION:
				return expr.eContainingFeature == XSWITCH_EXPRESSION__DEFAULT
			case XCASE_PART: {
				val casePart = expr.eContainer as XCasePart
				val switchExpr = casePart.eContainer as XSwitchExpression
				return expr.eContainingFeature == XCASE_PART__THEN
					&& switchExpr.^default == null && casePart == switchExpr.cases.last
			}
			case XIF_EXPRESSION: {
				val ifExpr = expr.eContainer as XIfExpression
				return expr.eContainingFeature == XIF_EXPRESSION__ELSE
					|| expr.eContainingFeature == XIF_EXPRESSION__THEN && ifExpr.^else == null
			}
			case XWHILE_EXPRESSION:
				return expr.eContainingFeature == XABSTRACT_WHILE_EXPRESSION__BODY
			case XFOR_LOOP_EXPRESSION:
				return expr.eContainingFeature == XFOR_LOOP_EXPRESSION__EACH_EXPRESSION
			case XBASIC_FOR_LOOP_EXPRESSION:
				return expr.eContainingFeature == XBASIC_FOR_LOOP_EXPRESSION__EACH_EXPRESSION
			case XSYNCHRONIZED_EXPRESSION:
				return expr.eContainingFeature == XSYNCHRONIZED_EXPRESSION__EXPRESSION
			case XTRY_CATCH_FINALLY_EXPRESSION:
				return expr.eContainingFeature == XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION
			case XCATCH_CLAUSE: {
				val catchClause = expr.eContainer as XCatchClause
				val tryCatchExpr = catchClause.eContainer as XTryCatchFinallyExpression
				return tryCatchExpr.finallyExpression == null && catchClause == tryCatchExpr.catchClauses.last
			}
		}
		return false
	}
	
	override dispatch void format(XIfExpression expr, extension IFormattableDocument document) {
		expr.regionForKeyword("if").append[oneSpace]
		expr.^if.surround[noSpace]
		expr.^if.format(document)
		if (!(expr.then instanceof XBlockExpression)) {
			expr.then.prepend[newLine; increaseIndentation]
			if (expr.^else != null)
				expr.then.append[newLine; decreaseIndentation]
			else
				expr.then.append[decreaseIndentation]
		}
		expr.then.format(document)
		if (expr.^else != null) {
			if (!(expr.^else instanceof XBlockExpression)) {
				expr.^else.prepend[newLine; increaseIndentation]
				expr.^else.append[decreaseIndentation]
			}
			expr.^else.format(document)
		}
	}
	
	override dispatch void format(XWhileExpression expr, extension IFormattableDocument format) {
		expr.regionForKeyword("while").append[oneSpace]
		expr.predicate.surround[noSpace]
		expr.predicate.format(format)
		if (!(expr.body instanceof XBlockExpression)) {
			expr.body.prepend[newLine; increaseIndentation].append[decreaseIndentation]
		}
		expr.body.format(format)
	}
	
	override dispatch void format(XDoWhileExpression expr, extension IFormattableDocument format) {
		expr.regionForKeyword("while").append[oneSpace]
		expr.predicate.surround[noSpace]
		expr.predicate.format(format)
		if (!(expr.body instanceof XBlockExpression)) {
			expr.body.prepend[newLine; increaseIndentation].append[newLine; decreaseIndentation]
		}
		expr.body.format(format)
	}
	
	override dispatch void format(XForLoopExpression expr, extension IFormattableDocument format) {
		expr.regionForKeyword("for").append[oneSpace]
		expr.declaredParam.prepend[noSpace].append[oneSpace]
		expr.forExpression.prepend[oneSpace].append[noSpace]
		expr.forExpression.format(format)
		if (!(expr.eachExpression instanceof XBlockExpression)) {
			expr.eachExpression.prepend[newLine; increaseIndentation].append[decreaseIndentation]
		}
		expr.eachExpression.format(format)
	}
	
	override dispatch void format(XBasicForLoopExpression expr, extension IFormattableDocument format) {
		expr.regionForKeyword("for").append[oneSpace]
		expr.regionForKeyword("(").append[noSpace]
		expr.regionsForKeywords(";").forEach[prepend[noSpace].append[noSpace lowPriority]]
		expr.regionsForKeywords(",").forEach[prepend[noSpace].append[oneSpace]]
		expr.regionForKeyword(")").prepend[noSpace]
		expr.initExpressions.forEach[it.format(format)]
		expr.expression.prepend[oneSpace]
		expr.expression.format(format)
		expr.updateExpressions.head.prepend[oneSpace]
		expr.updateExpressions.forEach[it.format(format)]
		if (!(expr.eachExpression instanceof XBlockExpression)) {
			expr.eachExpression.prepend[newLine; increaseIndentation].append[decreaseIndentation]
		}
		expr.eachExpression.format(format)
	}
	
	override dispatch void format(XSynchronizedExpression expr, extension IFormattableDocument format) {
		expr.param.surround[noSpace]
		expr.param.format(format)
		if (!(expr.expression instanceof XBlockExpression)) {
			expr.expression.prepend[newLine; increaseIndentation].append[decreaseIndentation]
		}
		expr.expression.format(format)
	}
	
	override dispatch void format(XTryCatchFinallyExpression expr, extension IFormattableDocument format) {
		if (!(expr.expression instanceof XBlockExpression)) {
			expr.expression.prepend[newLine; increaseIndentation].append[decreaseIndentation]
		}
		expr.expression.format(format)
		for (cc : expr.catchClauses) {
			if (!(cc.expression instanceof XBlockExpression)) {
				cc.expression.prepend[newLine; increaseIndentation]
				if (cc != expr.catchClauses.last || expr.finallyExpression != null)
					cc.expression.append[newLine; decreaseIndentation]
				else
					cc.expression.append[decreaseIndentation]
			}
			cc.format(format)
		}
		if (expr.finallyExpression != null) {
			if (!(expr.finallyExpression instanceof XBlockExpression)) {
				expr.finallyExpression.prepend[newLine; increaseIndentation].append[decreaseIndentation]
			}
			expr.finallyExpression.format(format)
		}
	}
	
	override dispatch void format(XCatchClause expr, extension IFormattableDocument format) {
		expr.regionForKeyword("catch").append[oneSpace]
		expr.declaredParam.surround[noSpace]
		expr.declaredParam.format(format)
		expr.expression.format(format)
	}
	
}
