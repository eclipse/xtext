package org.eclipse.xtext.xbase.formatting2

import com.google.inject.Inject
import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeConstraint
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.formatting2.ISubFormatter
import org.eclipse.xtext.formatting2.ITextReplacerContext
import org.eclipse.xtext.formatting2.AbstractFormatter
import org.eclipse.xtext.formatting2.AbstractTextReplacer
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
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
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess
import org.eclipse.xtext.xtype.XFunctionTypeRef

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class XbaseFormatter extends AbstractFormatter {

	@Inject @Accessors(PUBLIC_GETTER) extension XbaseGrammarAccess grammar

	override protected format(IFormattableDocument document) {
		format(document.request.textRegionAccess.resource.contents.head, document)
	}

	def protected dispatch void format(Void expr, extension IFormattableDocument format) {
	}

	def protected dispatch void format(EObject expr, extension IFormattableDocument format) {
	}

	def protected dispatch void format(XCollectionLiteral literal, extension IFormattableDocument document) {
		literal.regionForKeyword('#').append[noSpace]
		val open = literal.regionForKeyword("[") ?: literal.regionForKeyword("{")
		val close = literal.regionForKeyword("]") ?: literal.regionForKeyword("}")
		formatCommaSeparatedList(literal.elements, open, close, document)
	}

	def protected formatCommaSeparatedList(
		Collection<? extends EObject> elements,
		ISemanticRegion open,
		ISemanticRegion close,
		extension IFormattableDocument format
	) {
		if (elements.empty) {
			open.append[noSpace]
		} else if (close.previousHiddenRegion.multiline) {
			open.append[newLine; increaseIndentation]
			for (elem : elements) {
				elem.format(format)
				elem.immediatelyFollowingKeyword(",").prepend[noSpace].append[newLine]
			}
			elements.last.append[newLine; decreaseIndentation]
		} else {
			val ISubFormatter fmt = [ extension sub |
				val head = elements.head
				val offset = head.leadingHiddenRegion.offset
				val lenght = head.trailingHiddenRegion.offset - offset
				sub.formatConditionally(offset, lenght,
					[ doc |
						val extension it = doc.requireFitsInLine
						head.prepend[noSpace; autowrap].format(it)
					],
					[ extension doc |
						if (head.prependNewLineIfMultiline)
							head.prepend[newLine]
						else
							head.prepend[noSpace]
						head.format(doc)
					])
				for (arg : elements.tail) {
					val argoffset = arg.immediatelyPrecedingKeyword(",").previousHiddenRegion.offset
					val arglenght = arg.trailingHiddenRegion.offset - argoffset
					sub.formatConditionally(argoffset, arglenght,
						[ doc |
							val extension it = doc.requireFitsInLine
							arg.immediatelyPrecedingKeyword(",").prepend[noSpace].append[oneSpace; autowrap]
							arg.format(it)
						],
						[ extension doc |
							val comma = arg.immediatelyPrecedingKeyword(",").prepend[noSpace]
							if (arg.prependNewLineIfMultiline)
								comma.append[newLine]
							else
								comma.append[noSpace]
							arg.format(doc)
						])
				}
				elements.last.append[noSpace]
			]
			val offset = elements.head.leadingHiddenRegion.offset
			val lenght = elements.last.trailingHiddenRegion.endOffset - offset
			formatConditionally(offset, lenght,
				[ doc |
					fmt.format(doc.requireFitsInLine)
				],
				[ extension doc |
					elements.head.prepend[increaseIndentation]
					fmt.format(doc)
					elements.last.append[decreaseIndentation]
				])
		}
	}

	def protected dispatch void format(XAnnotation ann, extension IFormattableDocument document) {
		ann.regionForKeyword("@").append[noSpace]
		ann.regionForKeyword("(").surround[noSpace]
		if (ann.value != null) {
			ann.value.format(document)
			ann.regionForKeyword(")").prepend[noSpace]
		} else if (!ann.elementValuePairs.empty) {
			for (pair : ann.elementValuePairs) {
				pair.regionForKeyword("=").surround[noSpace]
				pair.value.format(document)
				pair.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			ann.regionForKeyword(")").prepend[noSpace]
		}
	}

	def protected dispatch void format(JvmGenericArrayTypeReference array, extension IFormattableDocument document) {
		addReplacer(new ArrayBracketsFormattingReplacer(document, array.regionForRuleCallTo(arrayBracketsRule)))
		array.componentType.format(document)
	}

	def protected dispatch void format(XFunctionTypeRef func, extension IFormattableDocument document) {
		func.regionForKeyword("(").append[noSpace]
		for (param : func.paramTypes) {
			param.format(document)
			param.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
		}
		func.regionForKeyword(")").prepend[if(!func.paramTypes.empty) noSpace].append[noSpace]
		func.regionForKeyword("=>").append[noSpace]
		func.returnType.format(document)
	}

	def protected dispatch void format(JvmTypeParameter ref, extension IFormattableDocument document) {
		for (c : ref.constraints) {
			c.prepend[oneSpace]
			c.format(document)
		}
	}

	def protected dispatch void format(JvmParameterizedTypeReference ref, extension IFormattableDocument document) {
		ref.regionForKeyword("<").surround[noSpace]
		for (arg : ref.arguments) {
			arg.format(document)
			arg.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
		}
		if (!ref.arguments.empty)
			ref.regionForKeyword(">").prepend[noSpace]
	}

	def protected dispatch void format(JvmWildcardTypeReference ref, extension IFormattableDocument document) {
		if (!ref.constraints.empty)
			ref.regionForKeyword("?").append[oneSpace]
		for (c : ref.constraints)
			c.format(document)
	}

	def protected dispatch void format(JvmTypeConstraint constraint, extension IFormattableDocument document) {
		constraint.typeReference.prepend[oneSpace].format(document)
	}

	def protected dispatch void format(XVariableDeclaration expr, extension IFormattableDocument format) {
		expr.regionForKeyword("val").append[oneSpace]
		expr.regionForKeyword("var").append[oneSpace]
		expr.type.append[oneSpace]
		expr.regionForKeyword("=").surround[oneSpace]
		expr.type.format(format)
		expr.right.format(format)
	}

	def protected dispatch void format(XAssignment expr, extension IFormattableDocument format) {
		expr.regionForRuleCallTo(opSingleAssignRule).surround[oneSpace]
		expr.regionForKeyword(if(expr.explicitStatic) '::' else '.').surround[noSpace]
		expr.assignable.format(format)
		expr.value.format(format)
	}

	//	def protected void formatStaticQualifier(INode node, extension IFormattableDocument document) {
	//		if (node instanceof ICompositeNode) {
	//			val leafs = node.leafNodes
	//			for (n : leafs)
	//				if (n.grammarElement instanceof Keyword && n.text == "::") {
	//					n.prepend[noSpace]
	//					if (n != leafs.last)
	//						n.append[noSpace]
	//				}
	//		}
	//	}
	def protected void formatFeatureCallParams(List<XExpression> params, ISemanticRegion open, ISemanticRegion close,
		extension IFormattableDocument format) {
		val builder = params.builder
		val explicitParams = params.explicitParams
		formatCommaSeparatedList(explicitParams.toList, open, close, format)
		formatBuilderWithLeadingGap(builder, format)
	}

	def protected void formatBuilderWithLeadingGap(XClosure closure, extension IFormattableDocument format) {
		if (closure != null) {
			val offset = closure.leadingHiddenRegion.offset
			val length = closure.trailingHiddenRegion.offset - offset
			formatConditionally(offset, length,
				[ doc |
					val extension it = doc.requireFitsInLine
					closure.prepend[noSpace]
					closure.format(it)
				],
				[ extension it |
					closure.prepend[oneSpace]
					closure.format(it)
				])
		}
	}

	def protected XClosure builder(List<XExpression> params) {
		if (params.last != null) {

			//			val grammarElement = (params.last.tokenForEObject as ICompositeNode).firstChild.grammarElement
			val grammarElement = params.last.invokingGrammarElement
			if (grammarElement == XMemberFeatureCallAccess.memberCallArgumentsXClosureParserRuleCall_1_1_4_0 ||
				grammarElement == XFeatureCallAccess.featureCallArgumentsXClosureParserRuleCall_4_0 ||
				grammarElement == XConstructorCallAccess.argumentsXClosureParserRuleCall_5_0)
				params.last as XClosure
		}
	}

	def protected Iterable<XExpression> explicitParams(List<XExpression> params) {
		val builder = params.builder
		if(builder != null) params.take(params.size - 1) else params
	}

	def protected dispatch void format(XConstructorCall expr, extension IFormattableDocument format) {
		expr.regionForFeature(XCONSTRUCTOR_CALL__CONSTRUCTOR).prepend[oneSpace]
		if (!expr.typeArguments.empty) {
			expr.regionForKeyword("<").surround[noSpace]
			for (arg : expr.typeArguments) {
				arg.format(format)
				arg.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			expr.regionForKeyword(">").prepend[noSpace]
		}
		val open = expr.regionForKeyword("(")
		val close = expr.regionForKeyword(")")
		open.prepend[noSpace]
		formatFeatureCallParams(expr.arguments, open, close, format)
	}

	def protected void formatFeatureCallTypeParameters(XAbstractFeatureCall expr, extension IFormattableDocument format) {
		if (!expr.typeArguments.empty) {
			expr.regionForKeyword("<").append[noSpace]
			for (arg : expr.typeArguments) {
				arg.format(format)
				arg.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			expr.regionForKeyword(">").surround[noSpace]
		}
	}

	def protected dispatch void format(XFeatureCall expr, extension IFormattableDocument format) {
		formatFeatureCallTypeParameters(expr, format)
		if (expr.explicitOperationCall) {
			val open = expr.regionForKeyword("(").prepend[noSpace]
			val close = expr.regionForKeyword(")")
			formatFeatureCallParams(expr.featureCallArguments, open, close, format)
		} else
			for (arg : expr.featureCallArguments)
				format(arg, format)
	}

	def protected dispatch void format(XMemberFeatureCall expr, extension IFormattableDocument format) {
		var EObject top = expr
		var calls = <XMemberFeatureCall>newArrayList()
		while (top instanceof XMemberFeatureCall) {
			calls += top
			top = top.memberCallTarget
		}
		top.format(format)
		Collections.reverse(calls)
		val indentOnce = new IndentOnceAutowrapFormatter(calls.last.trailingHiddenRegion)
		for (call : calls) {
			formatFeatureCallTypeParameters(call, format)
			val op = switch it: call { case nullSafe: "?." case explicitStatic: "::" default: "." }
			call.regionForKeyword(op).prepend[noSpace].append[noSpace; onAutowrap = indentOnce]
			if (call.explicitOperationCall) {
				val open = call.regionForKeyword("(").prepend[noSpace]
				val close = call.regionForKeyword(")")
				formatFeatureCallParams(call.memberCallArguments, open, close, format)
			} else if (!call.memberCallArguments.empty) {
				formatBuilderWithLeadingGap(call.memberCallArguments.builder, format)
			}
		}
	}

	def protected AbstractRule binaryOperationPrecedence(EObject op) {
		val node = op.regionForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
		if (node != null && node.grammarElement instanceof CrossReference) {
			val terminal = (node.grammarElement as CrossReference).terminal
			if (terminal instanceof RuleCall)
				return terminal.rule
		}
	}

	def protected dispatch void format(XBinaryOperation expr, extension IFormattableDocument format) {
		val precendece = expr.binaryOperationPrecedence
		val calls = <XBinaryOperation>newArrayList()
		var EObject top = expr
		while (top.binaryOperationPrecedence == precendece) {
			calls += top as XBinaryOperation
			top = (top as XBinaryOperation).leftOperand
		}
		format(top, format)
		Collections.reverse(calls)
		val ISubFormatter formatCalls = [ extension x |
			for (call : calls) {
				val op = call.regionForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
				val offset = op.previousHiddenRegion.offset
				val length = call.rightOperand.trailingHiddenRegion.offset - offset
				x.formatConditionally(offset, length,
					[ doc |
						val extension it = doc.requireFitsInLine
						op.prepend[oneSpace].append[oneSpace; autowrap]
						format(call.rightOperand, it)
					],
					[ extension it |
						op.prepend[oneSpace]
						if (call.rightOperand.prependNewLineIfMultiline)
							op.append[newLine]
						else
							op.append[oneSpace]
						format(call.rightOperand, it)
					])
			}
		]
		val offset = calls.head.regionForFeature(XABSTRACT_FEATURE_CALL__FEATURE).previousHiddenRegion.offset
		val length = calls.last.rightOperand.trailingHiddenRegion.offset - offset
		formatConditionally(offset, length,
			[ doc |
				formatCalls.format(doc.requireFitsInLine)
			],
			[ extension it |
				calls.head.regionForFeature(XABSTRACT_FEATURE_CALL__FEATURE).prepend[increaseIndentation]
				formatCalls.format(it)
				calls.last.regionForFeature(XABSTRACT_FEATURE_CALL__FEATURE).append[decreaseIndentation]
			])
	}

	def protected boolean prependNewLineIfMultiline(EObject obj) {
		switch obj {
			XMemberFeatureCall: obj.memberCallArguments.builder.prependNewLineIfMultiline
			XClosure: false
			XBlockExpression: false
			default: true
		}
	}

	def protected dispatch void format(XSynchronizedExpression expr, extension IFormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			expr.regionForKeyword("synchronized").append[increaseIndentation]
			expr.append[decreaseIndentation]
		}
		val multiline = expr.expression.multiline || expr.expression.leadingHiddenRegion.multiline
		expr.param.surround[noSpace]
		if (expr.expression instanceof XBlockExpression || multiline)
			expr.regionForKeyword("synchronized").append(whitespaceBetweenKeywordAndParenthesisML)
		else
			expr.regionForKeyword("synchronized").append(whitespaceBetweenKeywordAndParenthesisSL)
		if (expr.expression instanceof XBlockExpression) {
			expr.expression.prepend(bracesInNewLine)
		} else if (!multiline) {
			expr.expression.prepend[oneSpace]
		} else {
			expr.expression.prepend[newLine increaseIndentation].append[decreaseIndentation]
		}
		expr.param.format(format)
		expr.expression.format(format)
	}

	def protected dispatch void format(XIfExpression expr, extension IFormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			expr.regionForKeyword("if").append[increaseIndentation]
			expr.append[decreaseIndentation]
		}
		val multiline = expr.then.multilineOrInNewLine || expr.^else.multilineOrInNewLine
		expr.^if.surround[noSpace]
		if (expr.then instanceof XBlockExpression || multiline)
			expr.regionForKeyword("if").append(whitespaceBetweenKeywordAndParenthesisML)
		else
			expr.regionForKeyword("if").append(whitespaceBetweenKeywordAndParenthesisSL)
		if (expr.then instanceof XBlockExpression) {
			expr.then.prepend(bracesInNewLine)
			if (expr.^else != null)
				expr.then.append(bracesInNewLine)
		} else if (!multiline) {
			expr.then.prepend[oneSpace]
			if (expr.^else != null)
				expr.then.append[oneSpace]
		} else {
			expr.then.prepend[newLine increaseIndentation]
			if (expr.^else != null)
				expr.then.append[newLine; decreaseIndentation]
			else
				expr.then.append[decreaseIndentation]
		}
		if (expr.^else instanceof XBlockExpression) {
			expr.^else.prepend(bracesInNewLine)
		} else if (expr.^else instanceof XIfExpression || !multiline) {
			expr.^else.prepend[oneSpace]
		} else {
			expr.^else.prepend[newLine increaseIndentation]
			expr.^else.append[decreaseIndentation]
		}
		expr.^if.format(format)
		expr.then.format(format)
		if (expr.^else != null)
			expr.^else.format(format)
	}

	def protected dispatch void format(XForLoopExpression expr, extension IFormattableDocument format) {
		expr.regionForKeyword("for").append[oneSpace]
		expr.declaredParam.prepend[noSpace].append[oneSpace]
		expr.forExpression.prepend[oneSpace].append[noSpace]
		if (expr.eachExpression instanceof XBlockExpression) {
			expr.eachExpression.prepend(bracesInNewLine)
		} else {
			expr.eachExpression.prepend[newLine increaseIndentation]
			expr.eachExpression.append[decreaseIndentation]
		}
		expr.forExpression.format(format)
		expr.eachExpression.format(format)
	}

	def protected dispatch void format(XBasicForLoopExpression expr, extension IFormattableDocument format) {
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
		if (expr.eachExpression instanceof XBlockExpression) {
			expr.eachExpression.prepend(bracesInNewLine)
		} else {
			expr.eachExpression.prepend[newLine increaseIndentation]
			expr.eachExpression.append[decreaseIndentation]
		}
		expr.eachExpression.format(format)
	}

	def protected dispatch void format(XWhileExpression expr, extension IFormattableDocument format) {
		expr.regionForKeyword("while").append(whitespaceBetweenKeywordAndParenthesisML)
		expr.predicate.prepend[noSpace].append[noSpace]
		if (expr.body instanceof XBlockExpression) {
			expr.body.prepend(bracesInNewLine)
		} else {
			expr.body.prepend[newLine increaseIndentation]
			expr.body.append[decreaseIndentation]
		}
		expr.predicate.format(format)
		expr.body.format(format)
	}

	def protected dispatch void format(XDoWhileExpression expr, extension IFormattableDocument format) {
		expr.regionForKeyword("while").append(whitespaceBetweenKeywordAndParenthesisML)
		expr.predicate.prepend[noSpace].append[noSpace]
		if (expr.body instanceof XBlockExpression) {
			expr.body.prepend(bracesInNewLine).append(bracesInNewLine)
		} else {
			expr.body.prepend[newLine increaseIndentation].append[newLine decreaseIndentation]
		}
		expr.predicate.format(format)
		expr.body.format(format)
	}

	def protected dispatch void format(XBlockExpression expr, extension IFormattableDocument format) {
		val open = expr.regionForKeyword("{")
		if (expr.eContainer == null)
			open.prepend[noSpace]
		val close = expr.regionForKeyword("}")
		if (open != null && close != null)
			formatExpressionsMultiline(expr.expressions, open, close, format)
	}

	def protected dispatch void format(XTypeLiteral expr, extension IFormattableDocument format) {
		expr.regionForKeyword("typeof").append[noSpace]
		expr.regionForFeature(XTYPE_LITERAL__TYPE).prepend[noSpace].append[noSpace]
		for (region : expr.regionsForRuleCallsTo(arrayBracketsRule)) {
			region.append[noSpace]
			addReplacer(new ArrayBracketsFormattingReplacer(format, region))
		}
	}

	def protected dispatch void format(XThrowExpression expr, extension IFormattableDocument format) {
		expr.expression.prepend[oneSpace]
		expr.expression.format(format)
	}

	def protected dispatch void format(XReturnExpression expr, extension IFormattableDocument format) {
		expr.expression.prepend[oneSpace]
		expr.expression.format(format)
	}

	def protected dispatch void format(XTryCatchFinallyExpression expr, extension IFormattableDocument format) {
		if (expr.expression instanceof XBlockExpression) {
			expr.expression.prepend(bracesInNewLine).append(bracesInNewLine)
		} else {
			expr.expression.prepend[newLine increaseIndentation].append[newLine decreaseIndentation]
		}
		expr.expression.format(format)
		for (cc : expr.catchClauses) {
			cc.format(format)
			if (cc != expr.catchClauses.last || expr.finallyExpression != null) {
				if (cc.expression instanceof XBlockExpression)
					cc.append(bracesInNewLine)
				else
					cc.append[newLine]
			}
		}
		if (expr.finallyExpression != null) {
			if (expr.finallyExpression instanceof XBlockExpression) {
				expr.finallyExpression.prepend(bracesInNewLine)
			} else {
				expr.finallyExpression.prepend[newLine increaseIndentation].append[decreaseIndentation]
			}
			expr.finallyExpression.format(format)
		}
	}

	def protected dispatch void format(XCatchClause expr, extension IFormattableDocument format) {
		expr.regionForKeyword("catch").append(whitespaceBetweenKeywordAndParenthesisML)
		expr.declaredParam.prepend[noSpace].append[noSpace]

		//		val body = .tokenForEObject
		if (expr.expression instanceof XBlockExpression)
			expr.expression.prepend(bracesInNewLine)
		else {
			expr.expression.prepend[newLine increaseIndentation]
			expr.expression.append[decreaseIndentation]
		}
		expr.declaredParam.format(format)
		expr.expression.format(format)
	}

	def protected dispatch void format(JvmFormalParameter expr, extension IFormattableDocument format) {
		expr.parameterType?.append[oneSpace]
		expr.parameterType.format(format)
	}

	def protected dispatch void format(XExpression expr, extension IFormattableDocument format) {
		for (obj : expr.eContents)
			switch (obj) {
				XExpression: obj.format(format)
			}
	}

	def protected dispatch void format(XSwitchExpression expr, extension IFormattableDocument format) {
		val containsBlockExpr = expr.cases.exists[then instanceof XBlockExpression]
		val switchSL = !containsBlockExpr && !expr.multiline
		val caseSL = !containsBlockExpr && (!expr.cases.empty || expr.^default != null) &&
			!expr.cases.exists[multiline] && !expr.^default.multilineOrInNewLine
		val open = expr.regionForKeyword("{")
		val close = expr.regionForKeyword("}")
		expr.regionForKeyword("switch").append[oneSpace]
		if (switchSL) {
			open.prepend[oneSpace]
			open.append[oneSpace]
			for (c : expr.cases) {
				if (c.then == null) {
					c.append[oneSpace]
				} else {
					c.then.prepend[oneSpace].append[oneSpace]
				}
			}
			if (expr.^default != null) {
				expr.regionForKeyword("default").append[noSpace]
				expr.^default.surround[oneSpace]
			}
		} else if (caseSL) {
			open.prepend(bracesInNewLine)
			if (!expr.cases.empty) {
				open.append[newLine]
			}
			open.append[increaseIndentation]
			for (c : expr.cases) {
				c.then.prepend[oneSpace]
				if (c != expr.cases.last)
					c.append[newLine]
			}
			if (expr.^default != null) {
				expr.regionForKeyword("default").prepend[newLine].append[noSpace]
				expr.^default.prepend[oneSpace]
			}
			close.prepend[newLine; decreaseIndentation]
		} else {
			open.prepend(bracesInNewLine)
			open.append[newLine]
			if (!expr.cases.empty || expr.^default != null) {
				open.append[increaseIndentation]
			}
			for (c : expr.cases) {
				if (c.then instanceof XBlockExpression) {
					c.then.prepend(bracesInNewLine)
					if (expr.^default != null || c != expr.cases.last)
						c.then.append[newLine]
					else
						c.then.append[newLine; decreaseIndentation]
				} else {
					c.then.prepend[newLine; increaseIndentation]
					if (expr.^default != null || c != expr.cases.last)
						c.then.append[newLine; decreaseIndentation]
					else
						c.then.append[newLine; decreaseIndentation = 2]
				}
			}
			if (expr.^default != null) {
				expr.regionForKeyword("default").append[noSpace]
				if (expr.^default instanceof XBlockExpression) {
					expr.^default.prepend(bracesInNewLine).append[newLine; decreaseIndentation]
				} else {
					expr.^default.prepend[newLine; increaseIndentation].append[newLine; decreaseIndentation = 2]
				}
			}
		}
		for (c : expr.cases) {
			if (c.typeGuard != null && c.^case != null) {
				val typenode = c.regionForFeature(XCASE_PART__TYPE_GUARD)
				val casenode = c.regionForFeature(XCASE_PART__CASE)
				typenode.append[oneSpace]
				casenode.prepend[oneSpace]
				casenode.append[noSpace]
			} else if (c.typeGuard != null) {
				val typenode = c.regionForFeature(XCASE_PART__TYPE_GUARD)
				typenode.append[noSpace]
			} else if (c.^case != null) {
				c.^case.prepend[oneSpace].append[noSpace]

			//				val casenode = c.tokenForFeature(XCASE_PART__CASE)
			//				casenode.prepend[oneSpace]
			//				casenode.append[noSpace]
			}
			c.^case.format(format)
			c.then.format(format)
		}
		if (expr.^default != null)
			expr.^default.format(format)
	}

	def protected ISemanticRegion formatClosureParams(XClosure expr, ISemanticRegion open,
		extension IFormattableDocument format, (IHiddenRegionFormatter)=>void init) {
		if (expr.explicitSyntax) {
			for (param : expr.declaredFormalParameters) {
				param.format(format)
				param.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			open.append(init)
			val last = expr.regionForFeature(XCLOSURE__EXPLICIT_SYNTAX)
			if (!expr.declaredFormalParameters.empty)
				last.prepend(init)
			return last
		}
		return open
	}

	def protected dispatch void format(XClosure expr, extension IFormattableDocument format) {
		val open = expr.regionForKeyword("[") ?: expr.immediatelyPrecedingKeyword("(")
		val close = expr.regionForKeyword("]") ?: expr.immediatelyFollowingKeyword(")")
		val children = switch x:expr.expression {
			XBlockExpression: x.expressions
			default: newArrayList(x)
		}
		if (children.empty) {
			if (open.nextHiddenRegion.containsComment)
				open.append[newLine increaseIndentation decreaseIndentation]
			else
				open.append[noSpace]
		} else if (close.previousHiddenRegion.multiline) {
			val last = expr.formatClosureParams(open, format)[oneSpace]
			formatExpressionsMultiline(children, last, close, format)
		} else {
			val offset = open.previousHiddenRegion.nextSemanticRegion.endOffset
			val length = close.nextHiddenRegion.offset - offset
			formatConditionally(offset, length,
				[ doc |
					val extension it = doc.requireFitsInLine
					val last = expr.formatClosureParams(open, it)[noSpace]
					last.append[noSpace]
					for (c : children) {
						c.format(it)
						val semicolon = c.immediatelyFollowingKeyword(";")
						if (semicolon != null)
							semicolon.prepend[noSpace].append[if(c == children.last) noSpace else oneSpace]
						else
							c.append[if(c == children.last) noSpace else oneSpace]
					}
				],
				[ doc |
					val last = expr.formatClosureParams(open, format)[oneSpace]
					formatExpressionsMultiline(children, last, close, doc)
				])
		}
	}

	def protected void formatExpressionsMultiline(Collection<? extends XExpression> expressions, ISemanticRegion open,
		ISemanticRegion close, extension IFormattableDocument format) {
		if (expressions.empty) {
			if (open.nextHiddenRegion.containsComment)
				open.append[newLine increaseIndentation decreaseIndentation]
			else
				open.append[newLine]
		} else {
			open.append(blankLinesAroundExpression).append[increaseIndentation]
			for (child : expressions) {
				child.format(format)
				val sem = child.immediatelyFollowingKeyword(";")
				if (sem != null)
					sem.prepend[noSpace].append(blankLinesAroundExpression)
				else
					child.append(blankLinesAroundExpression)
			}
			close.prepend[decreaseIndentation]
		}
	}

	def protected boolean isMultilineOrInNewLine(EObject obj) {
		obj != null && (obj.multiline || obj.leadingHiddenRegion.multiline)
	}

}

class ArrayBracketsFormattingReplacer extends AbstractTextReplacer {

	protected new(IFormattableDocument document, ISemanticRegion region) {
		super(document, region.offset, region.length)
	}

	override createReplacements(ITextReplacerContext it) {
		val t = text
		for (var i = 0; i < t.length; i++)
			if (Character.isWhitespace(t.charAt(i)))
				replaceText(offset + i, 1, "")
		return it
	}
}
