/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeConstraint
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBasicForLoopExpression
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XCatchClause
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XCollectionLiteral
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XDoWhileExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XSynchronizedExpression
import org.eclipse.xtext.xbase.XThrowExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XWhileExpression
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess
import org.eclipse.xtext.xtype.XFunctionTypeRef

import static org.eclipse.xtext.common.types.TypesPackage.Literals.*
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys.*

/**
 * @deprecated use {@link XbaseFormatter}
 */
@Deprecated class XbaseFormatter2 extends AbstractFormatter {
	@Inject extension NodeModelAccess
	@Inject extension HiddenLeafAccess
	@Inject extension FormattingDataFactory
	@Inject extension XbaseGrammarAccess

	def protected dispatch void format(XCollectionLiteral literal, FormattableDocument document) {
		document += literal.nodeForKeyword('#').append[noSpace]
		val open = literal.nodeForKeyword("[") ?: literal.nodeForKeyword("{")
		val close = literal.nodeForKeyword("]") ?: literal.nodeForKeyword("}")
		formatCommaSeparatedList(literal.elements, open, close, document) 
	}

	def protected formatCommaSeparatedList(Collection<? extends EObject> elements, INode open, INode close,
		FormattableDocument format) {
		if (close?.hiddenLeafsBefore?.newLines > 0) {
			var INode comma = null
			if (elements.empty)
				format += open.append[noSpace]
			else
				for (elem : elements) {
					if (elem == elements.head)
						format += open.append[newLine; increaseIndentation]
					else if (comma !== null)
						format += comma.append[newLine]
					if (elem == elements.last)
						format += elem.nodeForEObject.append[newLine; decreaseIndentation]
					elem.format(format)
					comma = elem.nodeForEObject.immediatelyFollowingKeyword(",")
					format += comma.prepend[noSpace]
				}
		} else {
			var INode comma = null
			var indented = false
			for (elem : elements) {
				if (format.fitsIntoLine(elem)) {
					if (comma === null)
						format += open.append[noSpace]
					else
						format += comma.append[oneSpace]
				} else {
					val n = if (comma === null) open else comma
					format += n.append[newLine]
					if (!indented)
						format += n.append[increaseIndentation]
					indented = true
				}
				elem.format(format)
				comma = elem.nodeForEObject.immediatelyFollowingKeyword(",")
				format += comma.prepend[noSpace]
			}
			if (elements.size > 0) {
				val last = elements.last.nodeForEObject
				format += last.append[noSpace]
				if (indented)
					format += last.append[decreaseIndentation]
			} else
				format += open.append[noSpace]
		}
	}


	def protected dispatch void format(XAnnotation ann, FormattableDocument document) {
		ann.nodeForKeyword("@") => [document += append[noSpace]]
		ann.nodeForKeyword("(") => [document += prepend[noSpace] document += append[noSpace]]
		if (ann.value !== null) {
			ann.value.format(document)
			ann.nodeForKeyword(")") => [document += prepend[noSpace]]
		} else if (!ann.elementValuePairs.empty) {
			for (pair : ann.elementValuePairs) {
				pair.nodeForKeyword("=") => [document += prepend[noSpace] document += append[noSpace]]
				pair.value.format(document)
				val separator = pair.nodeForEObject.immediatelyFollowingKeyword(",")
				document += separator.prepend[noSpace]
				document += separator.append[oneSpace]
			}
			ann.nodeForKeyword(")") => [document += prepend[noSpace]]
		}
	}

	def protected dispatch void format(JvmGenericArrayTypeReference array, FormattableDocument document) {
		document += array.nodeForKeyword("[").prepend[noSpace]
		document += array.nodeForKeyword("]").prepend[noSpace]
		array.componentType.format(document)
	}

	def protected dispatch void format(XFunctionTypeRef func, FormattableDocument document) {
		document += func.nodeForKeyword("(").append[noSpace]
		for (param : func.paramTypes) {
			param.format(document)
			document += param.nodeForEObject.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
		}
		document += func.nodeForKeyword(")").surround([if (!func.paramTypes.empty) noSpace], [noSpace])
		document += func.nodeForKeyword("=>").append[noSpace]
		func.returnType.format(document)
	}

	def protected dispatch void format(JvmTypeParameter ref, FormattableDocument document) {
		for (c : ref.constraints) {
			document += c.nodeForEObject.prepend[oneSpace]
			c.format(document)
		}
	}

	def protected dispatch void format(JvmParameterizedTypeReference ref, FormattableDocument document) {
		document += ref.nodeForKeyword("<").surround[noSpace]
		for (arg : ref.arguments) {
			arg.format(document)
			document += arg.nodeForEObject.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
		}
		if (!ref.arguments.empty)
			document += ref.nodeForKeyword(">").prepend[noSpace]
	}

	def protected dispatch void format(JvmWildcardTypeReference ref, FormattableDocument document) {
		if (!ref.constraints.empty)
			document += ref.nodeForKeyword("?").append[oneSpace]
		for (c : ref.constraints)
			c.format(document)
	}

	def protected dispatch void format(JvmTypeConstraint constraint, FormattableDocument document) {
		document += constraint.nodeForFeature(JVM_TYPE_CONSTRAINT__TYPE_REFERENCE).prepend[oneSpace]
		constraint.typeReference.format(document)
	}

	def protected dispatch void format(XVariableDeclaration expr, FormattableDocument format) {
		format += expr.nodeForKeyword("val").append[oneSpace]
		format += expr.nodeForKeyword("var").append[oneSpace]
		format += expr.nodeForFeature(XVARIABLE_DECLARATION__TYPE).append[oneSpace]
		format += expr.nodeForKeyword("=").surround[oneSpace]
		expr.type.format(format)
		expr.right.format(format)
	}

	def protected dispatch void format(XAssignment expr, FormattableDocument format) {
		format += expr.nodeForKeyword("=").surround[oneSpace]
		format += expr.nodeForKeyword(if (expr.explicitStatic) '::' else '.').surround[noSpace]
		expr.assignable.format(format)
		expr.value.format(format)
	}

	def protected void formatStaticQualifier(INode node, FormattableDocument document) {
		if (node instanceof ICompositeNode) {
			val leafs = node.leafNodes
			for (n : leafs)
				if (n.grammarElement instanceof Keyword && n.text == "::") {
					document += n.prepend[noSpace]
					if (n != leafs.last)
						document += n.append[noSpace]
				}
		}
	}

	def protected boolean fitsIntoLine(FormattableDocument fmt, EObject expression) {
		val node = expression.nodeForEObject
		val lookahead = fmt.lookahead(expression)
		if (node === null || lookahead.contains("\n")) {
			return false
		} else {
			val length = fmt.lineLengthBefore(node.offset) + lookahead.length
			return length <= fmt.cfg.get(maxLineWidth)
		}
	}

	def protected String lookahead(FormattableDocument fmt, EObject expression) {
		val lookahead = new FormattableDocument(fmt)
		format(expression, lookahead)
		val node = expression.nodeForEObject
		if (node !== null) {
			val textRegion = node.textRegion
			lookahead.renderToString(textRegion.offset, textRegion.length)
		} else {
			""
		}
	}

	def protected void formatFeatureCallParamsWrapIfNeeded(INode open, List<XExpression> params,
		FormattableDocument format) {
		val builder = params.builder
		val explicitParams = params.explicitParams
		var INode node = null
		var indented = false

		if (explicitParams.empty) {
			format += open.append[noSpace]
		} else
			for (arg : explicitParams) {
				if (arg == explicitParams.head) {
					val head = arg.nodeForEObject
					if (format.fitsIntoLine(arg)) {
						format += head.prepend[noSpace]
					} else {
						format += head.prepend[newLine]
						if (!indented)
							format += head.prepend[increaseIndentation]
						indented = true
					}
				} else if (node !== null) {
					if (format.fitsIntoLine(arg)) {
						format += node.append[oneSpace]
					} else {
						format += node.append[newLine]
						if (!indented)
							format += node.append[increaseIndentation]
						indented = true
					}
				}
				if (arg == explicitParams.last) {
					format += arg.nodeForEObject.append[noSpace]
				}
				arg.format(format)
				node = arg.nodeForEObject.immediatelyFollowingKeyword(",")
				format += node.prepend[noSpace]
			}
		if (indented)
			format += explicitParams.last.nodeForEObject.append[decreaseIndentation]
		if (builder !== null) {
			format += builder.nodeForEObject.prepend [
				if (builder.isMultilineLambda)
					oneSpace
				else
					noSpace
			]
			builder.format(format)
		}
	}

	def protected XClosure builder(List<XExpression> params) {
		if (params.last !== null){
			val grammarElement = (params.last.nodeForEObject as ICompositeNode).firstChild.grammarElement
			if(grammarElement == XMemberFeatureCallAccess.memberCallArgumentsXClosureParserRuleCall_1_1_4_0 || 
				grammarElement == XFeatureCallAccess.featureCallArgumentsXClosureParserRuleCall_4_0 ||
				grammarElement == XConstructorCallAccess.argumentsXClosureParserRuleCall_5_0
			)
				params.last as XClosure
		}
	}

	def protected Iterable<XExpression> explicitParams(List<XExpression> params) {
		val builder = params.builder
		if (builder !== null) params.take(params.size - 1) else params
	}

	def protected void formatFeatureCallParamsMultiline(INode open, List<XExpression> params, FormattableDocument format) {
		val builder = params.builder
		val explicitParams = params.explicitParams
		var INode node = null

		if (explicitParams.empty) {
			format += open.append[noSpace]
		} else
			for (arg : explicitParams) {
				if (arg == explicitParams.head) {
					val head = arg.nodeForEObject
					format += head.prepend[newLine; increaseIndentation]
				} else if (node !== null)
					format += node.append[newLine]
				if (arg == explicitParams.last)
					format += arg.nodeForEObject.append[newLine; decreaseIndentation]
				arg.format(format)
				node = arg.nodeForEObject.immediatelyFollowingKeyword(",")
				format += node.prepend[noSpace]
			}
		if (builder !== null) {
			format += builder.nodeForEObject.prepend [
				if (builder.isMultilineLambda)
					oneSpace
				else
					noSpace
			]
			builder.format(format)
		}
	}

	/**
	 * checks whether the given lambda should be formatted as a block.
	 * That includes newlines after and before the brackets, and a fresh line for each expression.
	 */
	def protected boolean isMultilineLambda(XClosure closure) {
		val closingBracket = closure.nodeForKeyword(']')
		if (closingBracket?.hiddenLeafsBefore !== null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		return switch block : closure.expression {
			XBlockExpression: block.expressions.size > 1 && block.expressions.eachExpressionInOwnLine
			default : false
		}
	}

	def protected boolean isEachExpressionInOwnLine(Iterable<? extends XExpression> expressions) {
		var lastLine = -1
		for (e : expressions) {
			val node = e.nodeForEObject
			if (lastLine == node.startLine)
				return false
			lastLine = node.endLine
		}
		return true
	}

	def protected dispatch void format(XConstructorCall expr, FormattableDocument format) {
		format += expr.nodeForFeature(XCONSTRUCTOR_CALL__CONSTRUCTOR).prepend[oneSpace]
		if (!expr.typeArguments.empty) {
			format += expr.nodeForKeyword("<").surround[noSpace]
			for (arg : expr.typeArguments) {
				arg.format(format)
				format += arg.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
			}
			format += expr.nodeForKeyword(">").prepend[noSpace]
		}
		val open = expr.nodeForKeyword("(")
		format += open.prepend[noSpace]
		if (expr.isMultiParamInOwnLine(format))
			formatFeatureCallParamsMultiline(open, expr.arguments, format)
		else
			formatFeatureCallParamsWrapIfNeeded(open, expr.arguments, format)
	}

	def protected void formatFeatureCallTypeParameters(XAbstractFeatureCall expr, FormattableDocument format) {
		if (!expr.typeArguments.empty) {
			format += expr.nodeForKeyword("<").append[noSpace]
			for (arg : expr.typeArguments) {
				arg.format(format)
				format += arg.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
			}
			format += expr.nodeForKeyword(">").surround[noSpace]
		}
	}

	def protected dispatch void format(XFeatureCall expr, FormattableDocument format) {
		formatFeatureCallTypeParameters(expr, format)
		if (expr.explicitOperationCall) {
			val open = expr.nodeForKeyword("(")
			format += open.prepend[noSpace]
			if (expr.isMultiParamInOwnLine(format))
				formatFeatureCallParamsMultiline(open, expr.featureCallArguments, format)
			else
				formatFeatureCallParamsWrapIfNeeded(open, expr.featureCallArguments, format)
		} else
			for (arg : expr.featureCallArguments)
				format(arg, format)
	}

	def protected dispatch boolean isMultiParamInOwnLine(XMemberFeatureCall fc, FormattableDocument doc) {
		val closingBracket = fc.nodeForKeyword(')')
		if (closingBracket?.hiddenLeafsBefore !== null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		val params = fc.memberCallArguments.explicitParams
		return params.size > 1 && params.eachExpressionInOwnLine
	}

	def protected dispatch boolean isMultiParamInOwnLine(XFeatureCall fc, FormattableDocument doc) {
		val closingBracket = fc.nodeForKeyword(')')
		if (closingBracket?.hiddenLeafsBefore !== null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		val params = fc.featureCallArguments.explicitParams
		return params.size > 1 && params.eachExpressionInOwnLine
	}

	def protected dispatch boolean isMultiParamInOwnLine(XConstructorCall fc, FormattableDocument doc) {
		val closingBracket = fc.nodeForKeyword(')')
		if (closingBracket?.hiddenLeafsBefore !== null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		val params = fc.arguments.explicitParams
		return params.size > 1 && params.eachExpressionInOwnLine
	}

	def protected dispatch void format(XMemberFeatureCall expr, FormattableDocument format) {
		var EObject top = expr
		var calls = <XMemberFeatureCall>newArrayList()
		while (top instanceof XMemberFeatureCall) {
			calls += top
			top = top.memberCallTarget
		}
		format(top, format)

		var indented = false
		for (call : calls.reverse) {
			formatFeatureCallTypeParameters(call, format)
			val featureNode = call.nodeForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
			val targetNode = call.memberCallTarget.nodeForEObject
			if (targetNode !== null) {
				val callOffset = targetNode.endOffset
				val op = call.nodeForKeyword(switch it: call {
					case nullSafe: "?."
					case explicitStatic: "::"
					default: "."
				})
				format += op.prepend[noSpace]
				if (call.explicitOperationCall) {
					val callNode = call.nodeForEObject
					val callLength = callNode.endOffset - callOffset
					val open = call.nodeForKeyword("(")
					format += featureNode.append[noSpace]

					val lineLength = format.lineLengthBefore(callOffset)
					if (call.isMultiParamInOwnLine(format)) {
						if (lineLength + featureNode.length < format.cfg.get(maxLineWidth))
							format += op.append[noSpace]
						else
							format += op.append[newLine]
						formatFeatureCallParamsMultiline(open, call.memberCallArguments, format)
					} else {
						if (lineLength + (featureNode.length * 2) < format.cfg.get(maxLineWidth) || format.
							fitsIntoLine(callOffset, callLength,
								[ f |
									f += op.append[noSpace]
									formatFeatureCallParamsWrapIfNeeded(open, call.memberCallArguments, f)
								])) {
							format += op.append[noSpace]
						} else {
							format += op.append[newLine]
							if (!indented) {
								indented = true
								format += op.append[increaseIndentation]
							}
						}
						formatFeatureCallParamsWrapIfNeeded(open, call.memberCallArguments, format)
					}
				} else {
					val shortLenght = format.lineLengthBefore(callOffset) + featureNode.length
					if (shortLenght < format.cfg.get(maxLineWidth)) {
						format += op.append[noSpace]
					} else {
						format += op.append[newLine]
						if (!indented) {
							indented = true
							format += op.append[increaseIndentation]
						}
					}
					if (!call.memberCallArguments.empty) {
						val builder = call.memberCallArguments.builder

						// add single space if lambda is multi-line
						format += builder.nodeForEObject.prepend [
							if (builder.multilineLambda)
								oneSpace
							else
								noSpace
						]
						builder.format(format)
					}
				}
			}
		}
		if (indented)
			format += calls.last.nodeForEObject.append[decreaseIndentation]
	}

	def protected AbstractRule binaryOperationPrecedence(EObject op) {
		val node = op.nodeForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
		if (node !== null && node.grammarElement instanceof CrossReference) {
			val terminal = (node.grammarElement as CrossReference).terminal
			if (terminal instanceof RuleCall)
				return terminal.rule
		}
	}

	def protected boolean isMultiline(XExpression expression, FormattableDocument doc) {
		val node = expression.nodeForEObject
		return node !== null && {
			val textRegion = node.textRegionWithLineInformation
			textRegion.lineNumber != textRegion.endLineNumber
		}
	}

	def protected dispatch void format(XBinaryOperation expr, FormattableDocument format) {
		var precendece = expr.binaryOperationPrecedence
		var EObject top = expr
		var calls = <XBinaryOperation>newArrayList()
		while (top.binaryOperationPrecedence == precendece) {
			calls += top as XBinaryOperation
			top = (top as XBinaryOperation).leftOperand
		}
		format(top, format)

		var indented = false
		for (call : calls.reverse) {
			val op = call.nodeForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
			format += op.prepend[oneSpace]

			if (call.rightOperand.isMultiline(format) || format.fitsIntoLine(call.rightOperand)) {
				format += op.append[oneSpace]
			} else {
				format += op.append[newLine]
				if (!indented) {
					indented = true
					format += op.append[increaseIndentation]
				}
			}
			format(call.rightOperand, format)
		}
		if (indented)
			format += calls.last.nodeForEObject.append[decreaseIndentation]
	}
	
	def protected dispatch void format(XSynchronizedExpression expr, FormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			format += expr.nodeForKeyword("synchronized").append[increaseIndentation]
			format += expr.nodeForEObject.append[decreaseIndentation]
		}
		val expressionnode = expr.expression.nodeForEObject
		val multiline = expressionnode?.text?.trim?.contains("\n") || expressionnode?.hiddenLeafsBefore?.newLines > 0
		format += expr.nodeForFeature(XSYNCHRONIZED_EXPRESSION__PARAM).surround[noSpace]
		if (expr.expression instanceof XBlockExpression || multiline)
			format += expr.nodeForKeyword("synchronized").append[cfg(whitespaceBetweenKeywordAndParenthesisML)]
		else
			format += expr.nodeForKeyword("synchronized").append[cfg(whitespaceBetweenKeywordAndParenthesisSL)]
		if (expr.expression instanceof XBlockExpression) {
			format += expressionnode.prepend[cfg(bracesInNewLine)]
		} else if (!multiline) {
			format += expressionnode.prepend[oneSpace]
		} else {
			format += expressionnode.prepend[newLine increaseIndentation]
			format += expressionnode.append[decreaseIndentation]
		}
		expr.param.format(format)
		expr.expression.format(format)
	}

	def protected dispatch void format(XIfExpression expr, FormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			format += expr.nodeForKeyword("if").append[increaseIndentation]
			format += expr.nodeForEObject.append[decreaseIndentation]
		}
		val thennode = expr.then.nodeForEObject
		val elsenode = expr.^else?.nodeForEObject
		val multiline = thennode?.text?.trim?.contains("\n") || thennode?.hiddenLeafsBefore?.newLines > 0 ||
			elsenode?.text?.trim?.contains("\n")
		format += expr.nodeForFeature(XIF_EXPRESSION__IF).surround[noSpace]
		if (expr.then instanceof XBlockExpression || multiline)
			format += expr.nodeForKeyword("if").append[cfg(whitespaceBetweenKeywordAndParenthesisML)]
		else
			format += expr.nodeForKeyword("if").append[cfg(whitespaceBetweenKeywordAndParenthesisSL)]
		if (expr.then instanceof XBlockExpression) {
			format += thennode.prepend[cfg(bracesInNewLine)]
			if (expr.^else !== null)
				format += thennode.append[cfg(bracesInNewLine)]
		} else if (!multiline) {
			format += thennode.prepend[oneSpace]
			if (expr.^else !== null)
				format += thennode.append[oneSpace]
		} else {
			format += thennode.prepend[newLine increaseIndentation]
			if (expr.^else !== null)
				format += thennode.append[newLine; decreaseIndentation]
			else
				format += thennode.append[decreaseIndentation]
		}
		if (expr.^else instanceof XBlockExpression) {
			format += elsenode.prepend[cfg(bracesInNewLine)]
		} else if (expr.^else instanceof XIfExpression || !multiline) {
			format += elsenode.prepend[oneSpace]
		} else {
			format += elsenode.prepend[newLine increaseIndentation]
			format += elsenode.append[decreaseIndentation]
		}
		expr.^if.format(format)
		expr.then.format(format)
		if (expr.^else !== null)
			expr.^else.format(format)
	}

	def protected dispatch void format(XForLoopExpression expr, FormattableDocument format) {
		expr.nodeForKeyword("for") => [format += append[oneSpace]]
		expr.declaredParam.nodeForEObject => [format += prepend[noSpace] format += append[oneSpace]]
		expr.forExpression.nodeForEObject => [format += prepend[oneSpace] format += append[noSpace]]
		val each = expr.eachExpression.nodeForEObject
		if (expr.eachExpression instanceof XBlockExpression) {
			format += each.prepend[cfg(bracesInNewLine)]
		} else {
			format += each.prepend[newLine increaseIndentation]
			format += each.append[decreaseIndentation]
		}
		expr.forExpression.format(format)
		expr.eachExpression.format(format)
	}
	
	def protected dispatch void format(XBasicForLoopExpression expr, FormattableDocument format) {
		var INode previousFormattedNode = expr.nodeForKeyword("for") => [format += append[oneSpace]]
		
		val initExpressions = expr.initExpressions
		if (!initExpressions.empty) {
			for (initExpression : initExpressions) {
				if (initExpression == expr.initExpressions.head) {
					previousFormattedNode = initExpression.nodeForEObject => [format += prepend[noSpace] format += append[noSpace]]
				} else {
					previousFormattedNode = initExpression.nodeForEObject => [format += prepend[oneSpace] format += append[noSpace]]
				}
				initExpression.format(format)
			}
		} else {
			previousFormattedNode = previousFormattedNode.immediatelyFollowingKeyword("(") => [format += append[noSpace]]
		}
		
		val expression = expr.expression
		if (expression !== null) {
			previousFormattedNode = expression.nodeForEObject => [format += prepend[oneSpace] format += append[noSpace]]
			expression.format(format)
		} else {
			previousFormattedNode = previousFormattedNode.immediatelyFollowingKeyword(";") => [format += append[noSpace]]
		}
		
		val updateExpressions = expr.updateExpressions
		if (!updateExpressions.empty) {
			for (updateExpression : updateExpressions) {
				previousFormattedNode = updateExpression.nodeForEObject => [format += prepend[oneSpace] format += append[noSpace]]
				updateExpression.format(format)
			}
		} else {
			previousFormattedNode = previousFormattedNode.immediatelyFollowingKeyword(";") => [format += append[noSpace]]
		}
		
		val each = expr.eachExpression.nodeForEObject
		if (expr.eachExpression instanceof XBlockExpression) {
			format += each.prepend[cfg(bracesInNewLine)]
		} else {
			format += each.prepend[newLine increaseIndentation]
			format += each.append[decreaseIndentation]
		}
		expr.eachExpression.format(format)
	}

	def protected dispatch void format(XWhileExpression expr, FormattableDocument format) {
		format += expr.nodeForKeyword("while").append[cfg(whitespaceBetweenKeywordAndParenthesisML)]
		format += expr.predicate.nodeForEObject.surround([noSpace], [noSpace])
		val body = expr.body.nodeForEObject
		if (expr.body instanceof XBlockExpression) {
			format += body.prepend[cfg(bracesInNewLine)]
		} else {
			format += body.prepend[newLine increaseIndentation]
			format += body.append[decreaseIndentation]
		}
		expr.predicate.format(format)
		expr.body.format(format)
	}

	def protected dispatch void format(XDoWhileExpression expr, FormattableDocument format) {
		format += expr.nodeForKeyword("while").append[cfg(whitespaceBetweenKeywordAndParenthesisML)]
		format += expr.predicate.nodeForEObject.surround([noSpace], [noSpace])
		val body = expr.body.nodeForEObject
		if (expr.body instanceof XBlockExpression) {
			format += body.prepend[cfg(bracesInNewLine)]
			format += body.append[cfg(bracesInNewLine)]
		} else {
			format += body.prepend[newLine increaseIndentation]
			format += body.append[newLine decreaseIndentation]
		}
		expr.predicate.format(format)
		expr.body.format(format)
	}

	def protected dispatch void format(XBlockExpression expr, FormattableDocument format) {
		val open = expr.nodeForKeyword("{")
		if(expr.eContainer === null)
			format += open.prepend[noSpace]
		val close = expr.nodeForKeyword("}")
		if (open !== null && close !== null) {
			val multiLine = !expr.isSingleLineBlock(format)
			if (expr.expressions.empty) {
				if(open.hiddenLeafsAfter.containsComment) {
					if (multiLine) {
						format += open.append[newLine increaseIndentation decreaseIndentation]
					} else {
						format += open.append[oneSpace]
					}
				} else {
					format += open.append[if (multiLine) newLine else noSpace]
				}
			} else {
				if (multiLine) {
					format += open.append[cfg(blankLinesAroundExpression) increaseIndentation]
				} else {
					format += open.append[oneSpace]
				}
				for (child : expr.expressions) {
					child.format(format)
					if (child != expr.expressions.last || close !== null) {
						val childNode = child.nodeForEObject
						val sem = childNode.immediatelyFollowingKeyword(";")
						if (sem !== null) {
							format += sem.prepend[noSpace]
							format += sem.append[if (multiLine) cfg(blankLinesAroundExpression) else oneSpace]
						} else {
							format += childNode.append[if (multiLine) cfg(blankLinesAroundExpression) else oneSpace]
						}
					}
				}
				if (multiLine) {
					format += close.prepend[decreaseIndentation]
				}
			}
		}
	}
	
	def protected isSingleLineBlock(XBlockExpression expr, FormattableDocument format) {
		return false;
	}

	def protected dispatch void format(XTypeLiteral expr, FormattableDocument format) {
		val typeNode = expr.nodeForFeature(XTYPE_LITERAL__TYPE)
		format += expr.nodeForKeyword("typeof").append[noSpace]
		format += typeNode.prepend[noSpace]
		format += typeNode.append[noSpace]
		var node = typeNode
		while (node !== null) {
			node = node.immediatelyFollowingKeyword("[")
			if (node !== null) {
				format += node.append[noSpace]
				node = node.immediatelyFollowingKeyword("]")
				if (node !== null) {
					format += node.append[noSpace]
				}
			}
		}
	}

	def protected dispatch void format(XThrowExpression expr, FormattableDocument format) {
		format += expr.expression.nodeForEObject.prepend[oneSpace]
		expr.expression.format(format)
	}

	def protected dispatch void format(XReturnExpression expr, FormattableDocument format) {
		format += expr.expression.nodeForEObject.prepend[oneSpace]
		expr.expression.format(format)
	}

	def protected dispatch void format(XTryCatchFinallyExpression expr, FormattableDocument format) {
		val body = expr.expression.nodeForEObject
		if (expr.expression instanceof XBlockExpression) {
			format += body.prepend[cfg(bracesInNewLine)]
			format += body.append[cfg(bracesInNewLine)]
		} else {
			format += body.prepend[newLine increaseIndentation]
			format += body.append[newLine decreaseIndentation]
		}
		expr.expression.format(format)
		for (cc : expr.catchClauses) {
			cc.format(format)
			if (cc != expr.catchClauses.last || expr.finallyExpression !== null) {
				if (cc.expression instanceof XBlockExpression)
					format += cc.nodeForEObject.append[cfg(bracesInNewLine)]
				else
					format += cc.nodeForEObject.append[newLine]
			}
		}
		if (expr.finallyExpression !== null) {
			val fin = expr.finallyExpression.nodeForEObject
			if (expr.finallyExpression instanceof XBlockExpression) {
				format += fin.prepend[cfg(bracesInNewLine)]
			} else {
				format += fin.prepend[newLine increaseIndentation]
				format += fin.append[decreaseIndentation]
			}
			expr.finallyExpression.format(format)
		}
	}

	def protected dispatch void format(XCatchClause expr, FormattableDocument format) {
		format += expr.nodeForKeyword("catch").append[cfg(whitespaceBetweenKeywordAndParenthesisML)]
		expr.declaredParam.nodeForEObject => [format += prepend[noSpace] format += append[noSpace]]
		val body = expr.expression.nodeForEObject
		if (expr.expression instanceof XBlockExpression)
			format += body.prepend[cfg(bracesInNewLine)]
		else {
			format += body.prepend[newLine increaseIndentation]
			format += body.append[decreaseIndentation]
		}
		expr.declaredParam.format(format)
		expr.expression.format(format)
	}

	def protected dispatch void format(JvmFormalParameter expr, FormattableDocument format) {
		if (expr.parameterType !== null)
			format += expr.parameterType.nodeForEObject.append[oneSpace]
		expr.parameterType.format(format)
	}

	def protected dispatch void format(XExpression expr, FormattableDocument format) {
		for (obj : expr.eContents)
			switch (obj) {
				XExpression: obj.format(format)
			}
	}

	def protected dispatch void format(XSwitchExpression expr, FormattableDocument format) {
		val containsBlockExpr = expr.cases.exists[then instanceof XBlockExpression]
		val switchSL = !containsBlockExpr && !expr.nodeForEObject.text.trim.contains("\n")
		val caseSL = !containsBlockExpr && (!expr.cases.empty || expr.^default !== null) && !expr.cases.exists[nodeForEObject.text.trim.contains("\n")] && !expr.^default?.nodeForEObject?.text?.contains("\n")
		val open = expr.nodeForKeyword("{")
		val close = expr.nodeForKeyword("}")
		format += expr.nodeForKeyword("switch").append[oneSpace]
		if (switchSL) {
			format += open.prepend[oneSpace]
			format += open.append[oneSpace]
			for (c : expr.cases) {
				if (c.then === null) {
					format += c.nodeForEObject.append[oneSpace]
				} else {
					val cnode = c.then.nodeForEObject
					format += cnode.prepend[oneSpace]
					format += cnode.append[oneSpace]
				}
			}
			if(expr.^default !== null) {
				format += expr.nodeForKeyword("default").append[noSpace]
				format += expr.^default.nodeForEObject.surround[oneSpace]
			}
		} else if (caseSL) {
			format += open.prepend[cfg(bracesInNewLine)]
			if (!expr.cases.empty) {
				format += open.append[newLine]	
			}
			format += open.append[increaseIndentation]
			for (c : expr.cases) {
				format += c.then.nodeForEObject.prepend[oneSpace]
				if (c != expr.cases.last)
					format += c.nodeForEObject.append[newLine]
			}
			if(expr.^default !== null) {
				format += expr.nodeForKeyword("default").surround([newLine], [noSpace])
				format += expr.^default.nodeForEObject.prepend[oneSpace]
			}
			format += close.prepend[newLine; decreaseIndentation]
		} else {
			format += open.prepend[cfg(bracesInNewLine)]
			format += open.append[newLine]
			if (!expr.cases.empty || expr.^default !== null) {
				format += open.append[increaseIndentation]	
			}
			for (c : expr.cases) {
				val cnode = c.then.nodeForEObject?:c.nodeForFeature(XCASE_PART__FALL_THROUGH)
				if (c.then instanceof XBlockExpression) {
					format += cnode.prepend[cfg(bracesInNewLine)]
					if (expr.^default !== null || c != expr.cases.last)
						format += cnode.append[newLine]
					else
						format += cnode.append[newLine; decreaseIndentation]
				} else {
					if (c.isFallThrough) {
						format += cnode.append[increaseIndentation]
					} else {
						format += cnode.prepend[newLine; increaseIndentation]
					}
					if (expr.^default !== null || c != expr.cases.last)
						format += cnode.append[newLine; decreaseIndentation]
					else
						format += cnode.append[newLine; decreaseIndentationChange = -2]
				}
			}
			if(expr.^default !== null) {
				format += expr.nodeForKeyword("default").append[noSpace]
				if (expr.^default instanceof XBlockExpression) {
					format += expr.^default.nodeForEObject.surround([cfg(bracesInNewLine)], [newLine; decreaseIndentation])
				} else {
					format += expr.^default.nodeForEObject.surround([newLine; increaseIndentation], [newLine; decreaseIndentationChange = -2])
				}
			}
		}
		for (c : expr.cases) {
			if (c.typeGuard !== null && c.^case !== null) {
				val typenode = c.nodeForFeature(XCASE_PART__TYPE_GUARD)
				val casenode = c.nodeForFeature(XCASE_PART__CASE)
				format += typenode.append[oneSpace]
				format += casenode.prepend[oneSpace]
				format += casenode.append[noSpace]
			} else if (c.typeGuard !== null) {
				val typenode = c.nodeForFeature(XCASE_PART__TYPE_GUARD)
				format += typenode.append[noSpace]
			} else if (c.^case !== null) {
				val casenode = c.nodeForFeature(XCASE_PART__CASE)
				format += casenode.prepend[oneSpace]
				format += casenode.append[noSpace]
			}
			c.^case.format(format)
			c.then.format(format)
		}
		if(expr.^default !== null)
			expr.^default.format(format)
	}

	def protected dispatch void format(XClosure expr, FormattableDocument format) {
		val open = expr.nodeForKeyword("[") 
		val close = expr.nodeForKeyword("]")
		val children = switch x:expr.expression {
			XBlockExpression: x.expressions
			default: newArrayList(x)
		}
		if (expr.declaredFormalParameters.empty && children.empty) {
			if(open.hiddenLeafsAfter.containsComment)
				format += open.append[newLine increaseIndentation decreaseIndentation]
			else
				format += open.append[noSpace]
		} else if (expr.isMultilineLambda) {
			formatClosureMultiLine(expr, open, children, close, format)
		} else {
			formatClosureWrapIfNeeded(expr, open, children, close, format)
		}
	}

	def protected void formatClosureMultiLine(XClosure expr, INode open, Collection<XExpression> children, INode close,
		FormattableDocument format) {
		formatClosureParameters(expr, format)
		val explicit = expr.nodeForFeature(XCLOSURE__EXPLICIT_SYNTAX)
		if (explicit !== null) {
			if (expr.declaredFormalParameters.empty) {
				format += explicit.prepend[noSpace]
			} else {
				format += open.append[oneSpace]
				format += explicit.prepend[oneSpace]
			}
			format += explicit.append[newLine; increaseIndentation]
		} else {
			format += open.append[newLine; increaseIndentation]
		}
		for (c : children) {
			c.format(format)
			val node = c.nodeForEObject
			val semicolon = node.immediatelyFollowingKeyword(";")
			format += semicolon.prepend[noSpace]
			if (c != children.last)
				format += (semicolon ?: node).append[newLine]
		}
		format += close.prepend[newLine; decreaseIndentation]
	}

	def protected formatClosureParameters(XClosure expr, FormattableDocument format) {
		if (expr.explicitSyntax) {
			for (param : expr.declaredFormalParameters) {
				param.format(format)
				format += param.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
			}
		}
	}

	def protected void formatClosureWrapIfNeeded(XClosure expr, INode open, Collection<XExpression> children,
		INode close, FormattableDocument format) {
		formatClosureParameters(expr, format)
		var INode last = open
		if (expr.explicitSyntax) {
			format += open.append[noSpace]
			last = expr.nodeForFeature(XCLOSURE__EXPLICIT_SYNTAX)
			if(!expr.declaredFormalParameters.empty)
				format += last.prepend[noSpace]
		}
		var indented = false
		for (c : children) {
			if (format.fitsIntoLine(c)) {
				format += last.append[if (children.head == c) noSpace else oneSpace]
			} else {
				if (!indented) {
					indented = true
					format += last.append[increaseIndentation]
				}
				format += last.append[newLine]
			}
			c.format(format)
			last = c.nodeForEObject
			val semicolon = last.immediatelyFollowingKeyword(";")
			if (semicolon !== null) {
				format += semicolon.prepend[noSpace]
				last = semicolon
			}
		}
		if (indented)
			format += children.last.nodeForEObject.append[decreaseIndentation]
		format += close.prepend[noSpace]
	}

}
