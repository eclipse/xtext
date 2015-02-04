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
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XVariableDeclaration

class RuleEngineFormatter extends XbaseFormatter {
	
	@Inject extension RuleEngineGrammarAccess

	def dispatch void format(Model model, extension IFormattableDocument document) {
		model.prepend[setNewLines(0, 0, 1); noSpace].append[newLine]
		for (Declaration declaration : model.getDeclarations()) {
			format(declaration, document);
//			declaration.append[setNewLines(1, 1, 2)]
		}
	}

	def dispatch void format(Device device, extension IFormattableDocument document) {
		for (State state : device.getStates()) {
			format(state, document);
		}
	}

	def dispatch void format(Rule rule, extension IFormattableDocument document) {
		format(rule.getThenPart(), document);
	}

	override dispatch void format(XBlockExpression expr, extension IFormattableDocument document) {
		val begin = expr.regionForRuleCallTo(BEGINRule)
		begin.prepend[newLine; increaseIndentation; noSpace]
		val end = expr.regionForRuleCallTo(ENDRule)
		end.append[newLine; decreaseIndentation; noSpace]
		if (begin != null && end != null) {
			formatExpressionsMultiline(expr.expressions, begin, end, document)
		}
	}

	override dispatch void format(XSwitchExpression expr, extension IFormattableDocument document) {
		expr.regionForKeyword("switch").append[oneSpace]
		val begin = expr.regionForRuleCallTo(BEGINRule)
		begin.prepend[newLine; increaseIndentation; noSpace]
		val end = expr.regionForRuleCallTo(ENDRule)
		end.append[newLine; decreaseIndentation; noSpace]
		for (c : expr.cases) {
			if (c.then instanceof XBlockExpression) {
				c.then.prepend[newLine]
				if (expr.^default != null || c != expr.cases.last)
					c.then.append[newLine]
			} else if (c.isFallThrough) {
				c.regionForFeature(XbasePackage.Literals.XCASE_PART__FALL_THROUGH).prepend[noSpace].append[newLine]
			} else {
				c.then.prepend[newLine; increaseIndentation]
				if (expr.^default != null || c != expr.cases.last)
					c.then.append[newLine; decreaseIndentation]
				else
					c.then.append[decreaseIndentation]
			}
		}
		if (expr.^default != null) {
			expr.regionForKeyword("default").append[noSpace]
			if (expr.^default instanceof XBlockExpression) {
				expr.^default.prepend[newLine].append[newLine; decreaseIndentation]
			} else {
				expr.^default.prepend[newLine; increaseIndentation].append[decreaseIndentation]
			}
		}
		for (c : expr.cases) {
			if (c.typeGuard != null && c.^case != null) {
				c.typeGuard.append[oneSpace]
				c.^case.prepend[oneSpace].append[noSpace]
			} else if (c.typeGuard != null) {
				c.typeGuard.append[noSpace]
			} else if (c.^case != null) {
				c.^case.prepend[oneSpace].append[noSpace]
			}
			c.^case.format(document)
			c.then.format(document)
		}
		if (expr.^default != null)
			expr.^default.format(document)
	}
	
	override dispatch void format(XIfExpression expr, extension IFormattableDocument document) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			expr.regionForKeyword("if").append[increaseIndentation]
			expr.append[decreaseIndentation]
		}
		expr.^if.surround[noSpace]
		expr.regionForKeyword("if").append[oneSpace]
		if (!(expr.then instanceof XBlockExpression)) {
			expr.then.prepend[newLine; increaseIndentation]
			expr.then.append[newLine; decreaseIndentation]
		}
		if (!(expr.^else instanceof XBlockExpression)) {
			expr.^else.prepend[newLine; increaseIndentation]
			expr.^else.append[newLine; decreaseIndentation]
		}
		expr.^if.format(document)
		expr.then.format(document)
		if (expr.^else != null)
			expr.^else.format(document)
	}
	
}
