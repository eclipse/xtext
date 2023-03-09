/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting2

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmTypeConstraint
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBasicForLoopExpression
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XCollectionLiteral
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XDoWhileExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XInstanceOfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XPostfixOperation
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XSynchronizedExpression
import org.eclipse.xtext.xbase.XThrowExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XWhileExpression
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

/**
 * @author Moritz Eysholdt - Initial implementation and API
 * @author Lorenzo Bettini - https://bugs.eclipse.org/bugs/show_bug.cgi?id=471239
 */
class XbaseFormatter extends XtypeFormatter {

	@Inject @Accessors(PUBLIC_GETTER) extension XbaseGrammarAccess grammar

	def dispatch void format(XCollectionLiteral literal, extension IFormattableDocument document) {
		literal.regionFor.keyword('#').append[noSpace]
		val open = literal.regionFor.keyword("[") ?: literal.regionFor.keyword("{")
		val close = literal.regionFor.keyword("]") ?: literal.regionFor.keyword("}")
		formatCommaSeparatedList(literal.elements, open, close, document)
	}

	def protected void formatCommaSeparatedList(
		Collection<? extends EObject> elements,
		ISemanticRegion open,
		ISemanticRegion close,
		extension IFormattableDocument format
	) {
		if (close === null || open === null) {
			// broken, do nothing
		} else if (elements.empty) {
			open.append[noSpace]
		} else if (close.previousHiddenRegion.multiline) {
			open.append[newLine]
			for (elem : elements) {
				elem.format
				elem.immediatelyFollowing.keyword(",").prepend[noSpace].append[newLine]
			}
			elements.last.append[newLine]
			interior(open, close)[indent]
		} else {
			val indent = new IndentOnceAutowrapFormatter(close.previousHiddenRegion)
			val region = new TextSegment(textRegionAccess, open.endOffset, close.offset - open.endOffset)
			val items = new SeparatorRegions<EObject, ISemanticRegion>(region)
			for (ele : elements)
				items.appendWithTrailingSeparator(ele, ele.immediatelyFollowing.keyword(","))
			for (ele : items) {
				val sep = ele.leadingSeparator?.separator
				if (ele.object.prependNewLineIfMultiline) {
					if (sep === null)
						open.append[noSpace; autowrap(ele.region.length); onAutowrap = indent]
					else
						sep.append[oneSpace; autowrap(ele.region.length); onAutowrap = indent]
				} else {
					sep.append[oneSpace]
				}
				sep.prepend[noSpace]
				ele.object.format
			}
			close.prepend[noSpace]
		}
	}

	def dispatch void format(JvmGenericArrayTypeReference array, extension IFormattableDocument document) {
		for (region : array.regionFor.ruleCallsTo(arrayBracketsRule)) {
			addReplacer(new ArrayBracketsFormattingReplacer(region))
		}
		array.componentType.format
	}

	def dispatch void format(JvmTypeConstraint constraint, extension IFormattableDocument document) {
		constraint.typeReference.prepend[oneSpace].format
	}

	def dispatch void format(XVariableDeclaration expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("val").append[oneSpace]
		expr.regionFor.keyword("var").append[oneSpace]
		expr.type.append[oneSpace]
		expr.regionFor.keyword("=").surround[oneSpace]
		expr.type.format
		expr.right.format
	}

	def dispatch void format(XAssignment expr, extension IFormattableDocument format) {
		expr.regionFor.ruleCallTo(opSingleAssignRule).surround[oneSpace]
		expr.regionFor.keyword(if(expr.explicitStatic) '::' else '.').surround[noSpace]
		expr.assignable.format
		expr.value.format
	}

	// def protected void formatStaticQualifier(INode node, extension IFormattableDocument document) {
	// if (node instanceof ICompositeNode) {
	// val leafs = node.leafNodes
	// for (n : leafs)
	// if (n.grammarElement instanceof Keyword && n.text == "::") {
	// n.prepend[noSpace]
	// if (n != leafs.last)
	// n.append[noSpace]
	// }
	// }
	// }
	def protected void formatFeatureCallParams(List<XExpression> params, ISemanticRegion open, ISemanticRegion close,
		extension IFormattableDocument format) {
		val builder = params.builder
		val explicitParams = params.explicitParams
		formatCommaSeparatedList(explicitParams.toList, open, close, format)
		formatBuilderWithLeadingGap(builder, format)
	}

	def protected void formatBuilderWithLeadingGap(XClosure closure, extension IFormattableDocument format) {
		if (closure !== null) {
			val offset = closure.previousHiddenRegion.offset
			val length = closure.nextHiddenRegion.offset - offset
			formatConditionally(offset, length, [ doc |
				val extension it = doc.requireFitsInLine
				closure.prepend[noSpace]
				closure.format
			], [ extension it |
				closure.prepend[oneSpace]
				closure.format
			])
		}
	}

	def protected XClosure builder(List<XExpression> params) {
		if (params.last !== null) {
			val grammarElement = params.last.grammarElement
			if (grammarElement == XMemberFeatureCallAccess.memberCallArgumentsXClosureParserRuleCall_1_1_4_0 ||
				grammarElement == XFeatureCallAccess.featureCallArgumentsXClosureParserRuleCall_4_0 ||
				grammarElement == XConstructorCallAccess.argumentsXClosureParserRuleCall_5_0)
				params.last as XClosure
		}
	}

	def protected Iterable<XExpression> explicitParams(List<XExpression> params) {
		val builder = params.builder
		if(builder !== null) params.take(params.size - 1) else params
	}

	def dispatch void format(XConstructorCall expr, extension IFormattableDocument format) {
		expr.regionFor.feature(XCONSTRUCTOR_CALL__CONSTRUCTOR).prepend[oneSpace]
		if (!expr.typeArguments.empty) {
			expr.regionFor.keyword("<").surround[noSpace]
			for (arg : expr.typeArguments) {
				arg.format
				arg.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			}
			expr.regionFor.keyword(">").prepend[noSpace]
		}
		val open = expr.regionFor.keyword("(")
		val close = expr.regionFor.keyword(")")
		open.prepend[noSpace]
		formatFeatureCallParams(expr.arguments, open, close, format)
	}

	def protected void formatFeatureCallTypeParameters(XAbstractFeatureCall expr,
		extension IFormattableDocument format) {
		if (!expr.typeArguments.empty) {
			expr.regionFor.keyword("<").append[noSpace]
			for (arg : expr.typeArguments) {
				arg.format
				arg.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			}
			expr.regionFor.keyword(">").surround[noSpace]
		}
	}

	def dispatch void format(XFeatureCall expr, extension IFormattableDocument format) {
		formatFeatureCallTypeParameters(expr, format)
		if (expr.explicitOperationCall) {
			val open = expr.regionFor.keyword(grammar.XFeatureCallAccess.explicitOperationCallLeftParenthesisKeyword_3_0_0).prepend[noSpace]
			val close = expr.regionFor.keyword(grammar.XFeatureCallAccess.rightParenthesisKeyword_3_2)
			formatFeatureCallParams(expr.featureCallArguments, open, close, format)
		} else
			for (arg : expr.featureCallArguments)
				format(arg, format)
	}

	def dispatch void format(XMemberFeatureCall expr, extension IFormattableDocument format) {
		var EObject top = expr
		var calls = new SeparatorRegions<XMemberFeatureCall, ISemanticRegion>(expr.regionForEObject)
		while (top instanceof XMemberFeatureCall) {
			val op = switch it: top { case nullSafe: "?." case explicitStatic: "::" default: "." }
			val separator = top.regionFor.keyword(op)
			calls.prependWithLeadingSeparator(top, separator)
			top = top.memberCallTarget
		}
		top.format
		val indentOnce = new IndentOnceAutowrapFormatter(expr.nextHiddenRegion)
		for (entry : calls) {
			val call = entry.object
			val operator = entry.leadingSeparator.separator
			formatFeatureCallTypeParameters(call, format)
			val feature = call.regionFor.feature(XABSTRACT_FEATURE_CALL__FEATURE)
			if (feature !== null) {
				val autowrapLength = Math.min(entry.region.length, feature.length * 2)
				operator.prepend[noSpace].append[noSpace; autowrap(autowrapLength) onAutowrap = indentOnce]
				if (call.explicitOperationCall) {
					val open = call.regionFor.keyword(grammar.XMemberFeatureCallAccess.explicitOperationCallLeftParenthesisKeyword_1_1_3_0_0).prepend[noSpace]
					val close = call.regionFor.keyword(grammar.XMemberFeatureCallAccess.rightParenthesisKeyword_1_1_3_2)
					formatFeatureCallParams(call.memberCallArguments, open, close, format)
				} else if (!call.memberCallArguments.empty) {
					formatBuilderWithLeadingGap(call.memberCallArguments.builder, format)
				}
			}
		}
	}

	def protected AbstractRule binaryOperationPrecedence(EObject op) {
		val node = op.regionFor.feature(XABSTRACT_FEATURE_CALL__FEATURE)
		if (node !== null && node.grammarElement instanceof RuleCall) {
			return (node.grammarElement as RuleCall).rule
		}
	}

	def dispatch void format(XBinaryOperation expr, extension IFormattableDocument format) {
		val precendece = expr.binaryOperationPrecedence
		val calls = new SeparatorRegions<XBinaryOperation, ISemanticRegion>(expr.regionForEObject)
		var EObject top = expr
		while (top.binaryOperationPrecedence == precendece) {
			calls.prependWithLeadingSeparator(top as XBinaryOperation,
				top.regionFor.feature(XABSTRACT_FEATURE_CALL__FEATURE))
			top = (top as XBinaryOperation).leftOperand
		}
		format(top, format)
		val indent = new IndentOnceAutowrapFormatter(expr.nextHiddenRegion)
		for (ele : calls) {
			val sep = ele.leadingSeparator?.separator
			if (ele.object.prependNewLineIfMultiline)
				sep.append[oneSpace; autowrap(ele.region.length); onAutowrap = indent]
			else
				sep.append[oneSpace]

			sep.prepend[oneSpace]
			ele.object.rightOperand.format
		}
	}

	def protected boolean prependNewLineIfMultiline(EObject obj) {
		switch obj {
			XMemberFeatureCall: obj.memberCallArguments.builder.prependNewLineIfMultiline
			XClosure: false
			XBlockExpression: false
			default: true
		}
	}

	def dispatch void format(XSynchronizedExpression expr, extension IFormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			expr.surround[indent]
		}
		val multiline = expr.expression.multiline || expr.expression.previousHiddenRegion.multiline
		expr.param.surround[noSpace]
		if (expr.expression instanceof XBlockExpression || multiline)
			expr.regionFor.keyword("synchronized").append(whitespaceBetweenKeywordAndParenthesisML)
		else
			expr.regionFor.keyword("synchronized").append(whitespaceBetweenKeywordAndParenthesisSL)
		expr.param.format
		expr.expression.formatBody(false, format)
	}

	def dispatch void format(XIfExpression expr, extension IFormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			expr.surround[indent]
		}
		val multiline = expr.then.multilineOrInNewLine || expr.^else.multilineOrInNewLine
		expr.^if.surround[noSpace]
		if (expr.then instanceof XBlockExpression || multiline)
			expr.regionFor.keyword("if").append(whitespaceBetweenKeywordAndParenthesisML)
		else
			expr.regionFor.keyword("if").append(whitespaceBetweenKeywordAndParenthesisSL)
		expr.^if.format
		if (expr.^else === null) {
			expr.then.formatBody(multiline, format)
		} else {
			expr.then.formatBodyInline(multiline, format)
			if (expr.^else instanceof XIfExpression || !multiline) {
				expr.^else.prepend[oneSpace]
				expr.^else.format
			} else {
				expr.^else.formatBody(multiline, format)
			}
		}
	}

	def dispatch void format(XForLoopExpression expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("for").append[oneSpace]
		expr.declaredParam.prepend[noSpace].append[oneSpace]
		expr.forExpression.prepend[oneSpace].append[noSpace].format
		expr.eachExpression.formatBody(true, format)
	}

	def dispatch void format(XBasicForLoopExpression expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("for").append[oneSpace]
		expr.regionFor.keyword("(").append[noSpace]
		expr.regionFor.keywords(";").forEach[prepend[noSpace].append[noSpace lowPriority]]
		expr.regionFor.keywords(",").forEach[prepend[noSpace].append[oneSpace]]
		expr.regionFor.keyword(")").prepend[noSpace]
		expr.initExpressions.forEach[it.format]
		expr.expression.prepend[oneSpace]
		expr.expression.format
		expr.updateExpressions.head.prepend[oneSpace]
		expr.updateExpressions.forEach[it.format]
		expr.eachExpression.formatBody(true, format)
	}

	def dispatch void format(XWhileExpression expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("while").append(whitespaceBetweenKeywordAndParenthesisML)
		expr.predicate.prepend[noSpace].append[noSpace].format
		expr.body.formatBody(true, format)
	}

	def dispatch void format(XDoWhileExpression expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("while").append(whitespaceBetweenKeywordAndParenthesisML)
		expr.predicate.prepend[noSpace].append[noSpace].format
		expr.body.formatBodyInline(true, format)
	}

	def dispatch void format(XBlockExpression expr, extension IFormattableDocument format) {
		val open = expr.regionFor.keyword("{")
		val close = expr.regionFor.keyword("}")
		if (expr.eContainer === null)
			expr.surround[noSpace]
		if (open !== null && close !== null) {
			if (expr.isSingleLineBlock) {
				expr.formatConditionally(
					[ f |
					formatExpressionsSingleline(expr.expressions, open, close, f.requireFitsInLine)
				], [ f |
					formatExpressionsMultiline(expr.expressions, open, close, f)
				])
			} else
				formatExpressionsMultiline(expr.expressions, open, close, format)
		}
	}

	def protected isSingleLineBlock(XBlockExpression expr) {
		return false;
	}

	def dispatch void format(XTypeLiteral expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("typeof").append[noSpace]
		expr.regionFor.feature(XTYPE_LITERAL__TYPE).prepend[noSpace].append[noSpace]
		for (region : expr.regionFor.ruleCallsTo(arrayBracketsRule)) {
			region.append[noSpace]
			addReplacer(new ArrayBracketsFormattingReplacer(region))
		}
	}

	def dispatch void format(XThrowExpression expr, extension IFormattableDocument format) {
		expr.expression.prepend[oneSpace]
		expr.expression.format
	}

	def dispatch void format(XReturnExpression expr, extension IFormattableDocument format) {
		expr.expression.prepend[oneSpace]
		expr.expression.format
	}

	def dispatch void format(XTryCatchFinallyExpression expr, extension IFormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			expr.surround[indent]
		}
		expr.expression.formatBodyInline(true, format)
		for (cc : expr.catchClauses) {
			cc.regionFor.keyword("catch").append(whitespaceBetweenKeywordAndParenthesisML)
			cc.declaredParam.prepend[noSpace].append[noSpace].format
			if (cc != expr.catchClauses.last || expr.finallyExpression !== null)
				cc.expression.formatBodyInline(true, format)
			else
				cc.expression.formatBody(true, format)
		}
		expr.finallyExpression.formatBody(true, format)
	}

	def dispatch void format(JvmFormalParameter expr, extension IFormattableDocument format) {
		expr.parameterType?.append[oneSpace]
		expr.parameterType.format
	}

	def dispatch void format(XExpression expr, extension IFormattableDocument format) {
		for (obj : expr.eContents)
			switch (obj) {
				XExpression: obj.format
			}
	}

	def dispatch void format(XSwitchExpression expr, extension IFormattableDocument format) {
		val containsBlockExpr = expr.cases.exists[then instanceof XBlockExpression]
		val switchSL = !containsBlockExpr && !expr.multiline
		val caseSL = !containsBlockExpr && (!expr.cases.empty || expr.^default !== null) &&
			!expr.cases.exists[multiline] && !expr.^default.multilineOrInNewLine
		val open = expr.regionFor.keyword("{")
		val close = expr.regionFor.keyword("}")
		expr.regionFor.keyword("switch").append[oneSpace]
		if (switchSL) {
			open.prepend[oneSpace]
			open.append[oneSpace]
			for (c : expr.cases) {
				c.^case.format
				c.then.format
				if (c.then === null) {
					c.append[oneSpace]
				} else {
					c.then.prepend[oneSpace].append[oneSpace]
				}
			}
			if (expr.^default !== null) {
				expr.regionFor.keyword("default").append[noSpace]
				expr.^default.surround[oneSpace].format
			}
		} else if (caseSL) {
			open.prepend(bracesInNewLine)
			if (!expr.cases.empty) {
				open.append[newLine]
			}
			interior(open, close)[indent]
			for (c : expr.cases) {
				c.^case.format
				c.then.format
				c.then.prepend[oneSpace]
				if (c != expr.cases.last)
					c.append[newLine]
			}
			if (expr.^default !== null) {
				expr.regionFor.keyword("default").prepend[newLine].append[noSpace]
				expr.^default.prepend[oneSpace].format
			}
			close.prepend[newLine]
		} else {
			open.prepend(bracesInNewLine).append[newLine]
			if (!expr.cases.empty || expr.^default !== null) {
				interior(open, close)[indent]
			}
			for (c : expr.cases) {
				c.^case.format
				c.then.formatBodyParagraph(format)
				c.regionFor.feature(XCASE_PART__FALL_THROUGH).prepend[noSpace].append[newLine]
			}
			if (expr.^default !== null) {
				expr.regionFor.keyword("default").append[noSpace]
				expr.^default.formatBodyParagraph(format)
			}
		}
		for (c : expr.cases) {
			if (c.typeGuard !== null && c.^case !== null) {
				c.typeGuard.append[oneSpace]
				c.^case.prepend[oneSpace].append[noSpace]
			} else if (c.typeGuard !== null) {
				c.typeGuard.append[noSpace]
			} else if (c.^case !== null) {
				c.^case.prepend[oneSpace].append[noSpace]
			}
		}
	}

	def protected ISemanticRegion formatClosureParams(XClosure expr, ISemanticRegion open,
		extension IFormattableDocument format, (IHiddenRegionFormatter)=>void init) {
		if (expr.explicitSyntax) {
			val last = expr.regionFor.feature(XCLOSURE__EXPLICIT_SYNTAX)
			if (expr.declaredFormalParameters.empty) {
				open.append[noSpace]
			} else {
				for (param : expr.declaredFormalParameters) {
					param.format
					param.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
				}
				open.append(init)
				if (!expr.declaredFormalParameters.empty)
					last.prepend(init)
			}
			return last
		}
		return open
	}

	def dispatch void format(XClosure expr, extension IFormattableDocument format) {
		val open = expr.regionFor.keyword("[") ?: expr.immediatelyPreceding.keyword("(")
		val close = expr.regionFor.keyword("]") ?: expr.immediatelyFollowing.keyword(")")
		val children = switch x:expr.expression {
			XBlockExpression: x.expressions
			default: newArrayList(x)
		}
		if (open === null || close === null) {
			// broken, do nothing
		} else if (children.empty) {
			if (open.nextHiddenRegion.containsComment)
				open.append[newLine; indent]
			else
				open.append[noSpace]
		} else if (close.previousHiddenRegion.multiline) {
			val last = expr.formatClosureParams(open, format)[oneSpace]
			formatExpressionsMultiline(children, last, close, format)
		} else {
			val offset = open.previousHiddenRegion.nextSemanticRegion.endOffset
			val length = close.offset - offset
			formatConditionally(offset, length, [ doc |
				val extension it = doc.requireFitsInLine
				val last = expr.formatClosureParams(open, it)[noSpace]
				last.append[noSpace]
				for (c : children) {
					c.format
					val semicolon = c.immediatelyFollowing.keyword(";")
					if (semicolon !== null)
						semicolon.prepend[noSpace].append[if(c == children.last) noSpace else oneSpace]
					else
						c.append[if(c == children.last) noSpace else oneSpace]
				}
			], [ doc |
				val last = expr.formatClosureParams(open, doc)[oneSpace]
				formatExpressionsMultiline(children, last, close, doc)
			])
		}
	}

	def protected void formatBody(XExpression expr, boolean forceMultiline, extension IFormattableDocument doc) {
		if (expr === null)
			return;
		if (expr instanceof XBlockExpression) {
			expr.prepend(bracesInNewLine)
		} else if (forceMultiline || expr.previousHiddenRegion.isMultiline) {
			expr.prepend[newLine].surround[indent]
		} else {
			expr.prepend[oneSpace]
		}
		expr.format
	}

	def protected void formatBodyInline(XExpression expr, boolean forceMultiline, extension IFormattableDocument doc) {
		if (expr === null)
			return;
		if (expr instanceof XBlockExpression) {
			expr.prepend(bracesInNewLine).append(bracesInNewLine)
		} else if (forceMultiline || expr.previousHiddenRegion.isMultiline) {
			expr.prepend[newLine].surround[indent].append[newLine]
		} else {
			expr.surround[oneSpace]
		}
		expr.format
	}

	def protected void formatBodyParagraph(XExpression expr, extension IFormattableDocument doc) {
		if (expr === null)
			return;
		if (expr instanceof XBlockExpression) {
			expr.prepend(bracesInNewLine).append[newLine]
		} else {
			expr.prepend[newLine].surround[indent].append[newLine]
		}
		expr.format
	}

	def dispatch void format(XInstanceOfExpression expr, extension IFormattableDocument doc) {
		expr.regionFor.keyword("instanceof").surround[oneSpace]
		expr.expression.format
		expr.type.format
	}

	def dispatch void format(XCastedExpression expr, extension IFormattableDocument doc) {
		expr.regionFor.keyword("as").surround[oneSpace]
		expr.target.format
		expr.type.format
	}

	def dispatch void format(XPostfixOperation expr, extension IFormattableDocument doc) {
		expr.regionFor.feature(XABSTRACT_FEATURE_CALL__FEATURE).prepend[noSpace]
		expr.operand.format
	}

	def protected void formatExpressionsMultiline(Collection<? extends XExpression> expressions, ISemanticRegion open,
		ISemanticRegion close, extension IFormattableDocument format) {
		interior(open, close)[indent]
		if (expressions.empty) {
			open.append[newLine]
		} else {
			open.append(blankLinesAroundExpression)
			for (child : expressions) {
				child.format
				val sem = child.immediatelyFollowing.keyword(";")
				if (sem !== null)
					sem.prepend[noSpace].append(blankLinesAroundExpression)
				else
					child.append(blankLinesAroundExpression)
			}
		}
	}

	def protected void formatExpressionsSingleline(Collection<? extends XExpression> expressions, ISemanticRegion open,
		ISemanticRegion close, extension IFormattableDocument format) {
		if (expressions.empty) {
			open.append[noSpace]
		} else {
			open.append[oneSpace]
			for (child : expressions) {
				child.format
				val sem = child.immediatelyFollowing.keyword(";")
				if (sem !== null)
					sem.prepend[noSpace].append[oneSpace]
				else
					child.append[oneSpace]
			}
		}
	}

	def protected boolean isMultilineOrInNewLine(EObject obj) {
		obj !== null && (obj.multiline || obj.previousHiddenRegion.multiline)
	}

}
