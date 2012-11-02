/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XCatchClause
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XDoWhileExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XThrowExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XWhileExpression

import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray


@SuppressWarnings("restriction")
public class XtendFormatter {

	@Inject extension NodeModelAccess
	@Inject extension FormatterExtensions
	@Inject extension XtendGrammarAccess

	@Inject RichStringFormatter richStringFormatter

	@Property boolean allowIdentityEdits = false

	def List<TextReplacement> format(XtextResource res, int offset, int length, XtendFormatterConfig cfg) {
		val doc = res.parseResult.rootNode.text
		val format = new FormattableDocument(cfg, doc)
		format(res.contents.head as XtendFile, format)

		val edits = format.renderToEdits(offset, length)

		if (allowIdentityEdits)
			edits
		else
			edits.filter[ doc.substring(it.offset, it.offset + it.length) != text].toList
	}

	def protected dispatch void format(XtendFile xtendFile, FormattableDocument format) {
		format += xtendFile.nodeForKeyword("package").prepend[noSpace]
		val pkg = xtendFile.nodeForFeature(XTEND_FILE__PACKAGE)
		format += pkg.prepend[oneSpace]
		val pkgSemicolon = pkg.immediatelyFollowingKeyword(";")
		if (pkgSemicolon != null) {
			format += pkg.append[ space = ""]
			format += pkgSemicolon.append(format.cfg.newLinesAfterPackageName)
		} else {
			format += pkg.append(format.cfg.newLinesAfterPackageName)
		}
		for (imp : xtendFile.imports)
			if (imp != xtendFile.imports.last)
				format += imp.nodeForEObject.append(format.cfg.newLinesBetweenImports)
			else
				format += imp.nodeForEObject.append(format.cfg.newLinesAfterImportSection)
		for (clazz : xtendFile.xtendTypes) {
			clazz.format(format)
			if (clazz != xtendFile.xtendTypes.last)
				format += clazz.nodeForEObject.append(format.cfg.newLinesBetweenClasses)
		}

		format += xtendFile.nodeForEObject.append[newLine]
	}
	
	def protected void formatAnnotations(XtendAnnotationTarget target, FormattableDocument document) {
		if(target.annotations.isEmpty)
			return;
		for(a : target.annotations) {
			a.format(document)
			document += a.nodeForEObject.append(document.cfg.newLinesAfterAnnotations)
		}
	}
	
	def protected dispatch void format(XAnnotationValueArray ann, FormattableDocument document) {
		var node = ann.nodeForKeyword("{")
		for(value:ann.values) {
			document += node.append[if(value == ann.values.head) noSpace else oneSpace]
			value.format(document)
			node = value.nodeForEObject.immediatelyFollowingKeyword(",")
			document += node.prepend[noSpace]
		}
		document += ann.nodeForKeyword("}").prepend[noSpace]
	}
	
	def protected dispatch void format(XAnnotation ann, FormattableDocument document) {
		ann.nodeForKeyword("@") => [ document += append[noSpace] ]
		ann.nodeForKeyword("(") => [ document += prepend[noSpace] document += append[noSpace] ]
		if(ann.value != null) {
			ann.value.format(document)
			ann.nodeForKeyword(")") => [ document += prepend[noSpace] ]
		} else if(!ann.elementValuePairs.empty) {
			for(pair:ann.elementValuePairs) {
				pair.nodeForKeyword("=") => [ document += prepend[noSpace] document += append[noSpace] ]
				pair.value.format(document)
				val separator = pair.nodeForEObject.immediatelyFollowingKeyword(",")
				document += separator.prepend[noSpace]
				document += separator.append[oneSpace]
			}
			ann.nodeForKeyword(")") => [ document += prepend[noSpace] ]
		}
	}
	
	def protected dispatch void format(XtendClass clazz, FormattableDocument format) {
		formatAnnotations(clazz, format)
		format += clazz.nodeForKeyword("class").append[oneSpace]
		val clazzOpenBrace = clazz.nodeForKeyword("{")
		format += clazzOpenBrace.prepend[ space=" "]
		if (!clazz.members.empty) {
			format += clazzOpenBrace.append[increaseIndentation]
			format += clazzOpenBrace.append(format.cfg.newLinesBeforeFirstMember)
			for (i : 0 .. (clazz.members.size - 1)) {
				val current = clazz.members.get(i)
				current.format(format)
				if (i < clazz.members.size - 1) {
					val next = clazz.members.get(i + 1)
					if (current instanceof XtendField && next instanceof XtendField)
						format += current.nodeForEObject.append(format.cfg.newLinesBetweenFields)
					else if (current instanceof XtendFunction && next instanceof XtendFunction)
						format += current.nodeForEObject.append(format.cfg.newLinesBetweenMethods)
					else
						format += current.nodeForEObject.append(format.cfg.newLinesBetweenFieldsAndMethods)
				} else {
					val node = clazz.members.get(i).nodeForEObject
					format += node.append[decreaseIndentation]
					format += node.append(format.cfg.newLinesAfterLastMember)
				}
			}
		} else {
			format += clazzOpenBrace.append[newLine]
		}
	}

	def protected dispatch void format(XtendConstructor func, FormattableDocument format) {
		formatAnnotations(func, format)
		val open = func.nodeForKeyword("(")
		val close = func.nodeForKeyword(")")
		formatMemberParameter(func.parameters, open, close, format)
		
		func.expression.format(format)
	}
	
	def protected formatMemberParameter(Collection<XtendParameter> parameters, INode open, INode close, FormattableDocument format) {
		if (close?.whitespaceBefore?.text?.contains("\n")) {
			var INode comma = null
			if (parameters.empty)
				format += open.append[noSpace]
			else
				for (param : parameters) {
					if (param == parameters.head)
						format += open.append[ newLine; increaseIndentation]
					else if (comma != null)
						format += comma.append[newLine]
					if (param == parameters.last)
						format += param.nodeForEObject.append[ newLine; decreaseIndentation]
					param.format(format)
					comma = param.nodeForEObject.immediatelyFollowingKeyword(",")
				}
		} else {
			var INode comma = null
			var indented = false
			for (param : parameters) {
				if (format.fitsIntoLine(param)) {
					if (comma == null)
						format += open.append[noSpace]
					else
						format += comma.append[oneSpace]
				} else {
					val n = if(comma == null) open else comma
					format += n.append[newLine]
					if (!indented)
						format += n.append[increaseIndentation]
					indented = true
				}
				param.format(format)
				comma = param.nodeForEObject.immediatelyFollowingKeyword(",")
			}
			if (parameters.size > 0) {
				val last = parameters.last.nodeForEObject
				format += last.append[noSpace]
				if (indented)
					format += last.append[decreaseIndentation]
			} else
				format += open.append[noSpace]
		}
	}
	
	def protected dispatch void format(XtendFunction func, FormattableDocument format) {
		formatAnnotations(func, format)
		val nameNode = func.nodeForFeature(XtendPackage$Literals::XTEND_FUNCTION__NAME)
		val open = nameNode.immediatelyFollowingKeyword("(")
		val close = func.nodeForKeyword(")")
		formatMemberParameter(func.parameters, open, close, format)
		func.expression.format(format)
	}

	def protected dispatch void format(XtendParameter param, FormattableDocument format) {
		formatAnnotations(param, format)
		val nameNode = param.nodeForFeature(XTEND_PARAMETER__NAME)
		format += nameNode.prepend[oneSpace]
	}

	def protected dispatch void format(RichString rs, FormattableDocument format) {
		richStringFormatter.format(this, format, rs)
	}

	def protected dispatch void format(XVariableDeclaration expr, FormattableDocument format) {
		val nameNode = expr.nodeForFeature(XVARIABLE_DECLARATION__NAME)
		val rightNode = expr.nodeForFeature(XVARIABLE_DECLARATION__RIGHT)
		format += nameNode.prepend[oneSpace]
		format += nameNode.append[oneSpace]
		format += rightNode.prepend[oneSpace]
		expr.right.format(format)
	}

	def protected dispatch void format(Void expr, FormattableDocument format) {
	}

	def protected dispatch void format(EObject expr, FormattableDocument format) {
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
				} else if (node != null) {
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
			}
		if (indented)
			format += explicitParams.last.nodeForEObject.append[decreaseIndentation]
		if (builder != null) {
			format +=
				builder.nodeForEObject.prepend [
					if (builder.isMultilineLambda)
						oneSpace
					else
						noSpace
				]
			builder.format(format)
		}
	}

	def protected XClosure builder(List<XExpression> params) {
		if (params.last != null && (params.last.nodeForEObject as ICompositeNode).firstChild.grammarElement == XMemberFeatureCallAccess.memberCallArgumentsXClosureParserRuleCall_1_1_4_0)
			params.last as XClosure
	}

	def protected Iterable<XExpression> explicitParams(List<XExpression> params) {
		val builder = params.builder
		if(builder != null) params.take(params.size - 1) else params
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
					format += head.prepend[ newLine; increaseIndentation]
				} else if (node != null)
					format += node.append[newLine]
				if (arg == explicitParams.last)
					format += arg.nodeForEObject.append[ newLine; decreaseIndentation]
				arg.format(format)
				node = arg.nodeForEObject.immediatelyFollowingKeyword(",")
			}
		if (builder != null) {
			format +=
				builder.nodeForEObject.prepend [
					if (builder.isMultilineLambda)
						oneSpace
					else
						noSpace
				]
			builder.format(format)
		}
	}

	def protected dispatch void format(XConstructorCall expr, FormattableDocument format) {
		format += expr.nodeForKeyword("new").append[oneSpace]
		if (expr.isMultiParamInOwnLine(format))
			formatFeatureCallParamsMultiline(expr.nodeForKeyword("("), expr.arguments, format)
		else
			formatFeatureCallParamsWrapIfNeeded(expr.nodeForKeyword("("), expr.arguments, format)
	}

	def protected dispatch void format(XFeatureCall expr, FormattableDocument format) {
		format += expr.nodeForFeature(XFEATURE_CALL__DECLARING_TYPE).append[noSpace]
		if (expr.explicitOperationCall) {
			if (expr.isMultiParamInOwnLine(format))
				formatFeatureCallParamsMultiline(expr.nodeForKeyword("("), expr.featureCallArguments, format)
			else
				formatFeatureCallParamsWrapIfNeeded(expr.nodeForKeyword("("), expr.featureCallArguments, format)
		} else
			for (arg : expr.featureCallArguments)
				format(arg, format)
	}

	def protected dispatch void format(XMemberFeatureCall expr, FormattableDocument format) {
		var EObject top = expr
		var calls = <XMemberFeatureCall>newArrayList()
		while (top instanceof XMemberFeatureCall) {
			calls += top as XMemberFeatureCall
			top = (top as XMemberFeatureCall).memberCallTarget
		}
		format(top, format)

		var indented = false
		for (call : calls.reverse) {
			val featureNode = call.nodeForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
			val targetNode = call.memberCallTarget.nodeForEObject
			if (targetNode != null) {
				val callOffset = targetNode.offset + targetNode.length
				val op = call.nodeForKeyword(if (call.nullSafe) "?." else ".")
				format += op.prepend[noSpace]
				if (call.explicitOperationCall) {
					val callNode = call.nodeForEObject
					val callLength = callNode.offset + callNode.length - callOffset
					val open = call.nodeForKeyword("(")
					format += featureNode.append[noSpace]

					val lineLength = format.lineLengthBefore(callOffset)
					if (call.isMultiParamInOwnLine(format)) {
						if (lineLength + featureNode.length < format.cfg.maxLineWidth.value)
							format += op.append[noSpace]
						else
							format += op.append[newLine]
						formatFeatureCallParamsMultiline(open, call.memberCallArguments, format)
					} else {
						if (lineLength + (featureNode.length * 2) < format.cfg.maxLineWidth.value || format.fitsIntoLine(callOffset, callLength, [ f |
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
					if (shortLenght < format.cfg.maxLineWidth.value) {
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
						format +=
							builder.nodeForEObject.prepend [
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
		if (node != null && node.grammarElement instanceof CrossReference) {
			val terminal = (node.grammarElement as CrossReference).terminal
			if (terminal instanceof RuleCall)
				return (terminal as RuleCall).rule
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

	def protected dispatch void format(XSwitchExpression expr, FormattableDocument format) {
		val containsBlockExpr = expr.cases.exists[ then instanceof XBlockExpression]
		val switchSL = !containsBlockExpr && !expr.nodeForEObject.text.trim.contains("\n")
		val caseSL = !containsBlockExpr && !expr.cases.exists[ nodeForEObject.text.trim.contains("\n")]
		val open = expr.nodeForKeyword("{")
		val close = expr.nodeForKeyword("}")
		format += expr.nodeForKeyword("switch").append[oneSpace]
		if (switchSL) {
			format += open.prepend[ space=" "]
			format += open.append[ space=" "]
			for (c : expr.cases) {
				val cnode = c.then.nodeForEObject
				format += cnode.prepend[ space=" "]
				format += cnode.append[ space=" "]
			}
		} else if (caseSL) {
			format += open.prepend[ space=" "]
			format += open.append[ newLine; increaseIndentation]
			for (c : expr.cases) {
				format += c.then.nodeForEObject.prepend[ space=" "]
				if (c != expr.cases.last)
					format += c.nodeForEObject.append[newLine]
			}
			format += close.prepend[ newLine; decreaseIndentation]
		} else {
			format += open.prepend[ space=" "]
			format += open.append[ newLine; increaseIndentation]
			for (c : expr.cases) {
				val cnode = c.then.nodeForEObject
				if (c.then instanceof XBlockExpression) {
					format += cnode.prepend[ space = " "]
					if (c != expr.cases.last)
						format += cnode.append[newLine]
					else
						format += cnode.append[ newLine; decreaseIndentation]
				} else {
					format += cnode.prepend[ newLine; increaseIndentation]
					if (c != expr.cases.last)
						format += cnode.append[ newLine; decreaseIndentation]
					else
						format += cnode.append[ newLine; indentationChange = -2 ]
				}
			}
		}
		for (c : expr.cases) {
			if (c.typeGuard != null && c.^case != null) {
				val typenode = c.nodeForFeature(XCASE_PART__TYPE_GUARD)
				val casenode = c.nodeForFeature(XCASE_PART__CASE)
				format += typenode.append[ space=" "]
				format += casenode.prepend[ space=" "]
				format += casenode.append[noSpace]
			} else if (c.typeGuard != null) {
				val typenode = c.nodeForFeature(XCASE_PART__TYPE_GUARD)
				format += typenode.append[noSpace]
			} else if (c.^case != null) {
				val casenode = c.nodeForFeature(XCASE_PART__CASE)
				format += casenode.prepend[ space=" "]
				format += casenode.append[noSpace]
			}
			c.^case.format(format)
			c.then.format(format)
		}
	}

	def protected dispatch void format(XClosure expr, FormattableDocument format) {
		val open = expr.nodeForKeyword("[") ?: expr.eContainer.nodeForKeyword("(")
		val close = expr.nodeForKeyword("]") ?: expr.eContainer.nodeForKeyword(")")
		val children = switch x:expr.expression {
			XBlockExpression: x.expressions
			XExpression: newArrayList(x)
			default: <XExpression>emptyList
		}
		if (expr.declaredFormalParameters.empty && children.empty) {
			format += expr.nodeForKeyword("[").append[noSpace]
		} else if (expr.isMultilineLambda) {
			formatClosureMultiLine(expr, open, children, close, format)
		} else {
			formatClosureWrapIfNeeded(expr, open, children, close, format)
		}
	}

	def protected void formatClosureMultiLine(XClosure expr, INode open, Collection<XExpression> children, INode close,
		FormattableDocument format) {
		val explicit = expr.nodeForFeature(XCLOSURE__EXPLICIT_SYNTAX)
		if (explicit != null) {
			format += explicit.append[ newLine; increaseIndentation]
		} else {
			format += open?.append[ newLine; increaseIndentation]
		}
		for (c : children) {
			c.format(format)
			val node = c.nodeForEObject
			val semicolon = node.immediatelyFollowingKeyword(";")
			format += semicolon?.prepend[
				noSpace
			]
			if (c != children.last)
				format += (semicolon ?: node).append[newLine]
		}
		format += close?.prepend[ newLine; decreaseIndentation ]
	}

	def protected void formatClosureWrapIfNeeded(XClosure expr, INode open, Collection<XExpression> children,
		INode close, FormattableDocument format) {
		format += open.append[noSpace]
		var INode last = open
		var indented = false
		for (c : children) {
			if (format.fitsIntoLine(c)) {
				if (children.head != c)
					format += last.append[oneSpace]
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
			if (semicolon != null) {
				format += semicolon.prepend[noSpace]
				last = semicolon
			}
		}
		if (indented)
			format += children.last.nodeForEObject.append[decreaseIndentation]
		format += close.prepend[noSpace]
	}

	def protected boolean isMultiline(XExpression expression, FormattableDocument doc) {
		val node = expression.nodeForEObject
		return node.startLine != node.endLine
	}

	/**
	 * checks whether the given lambda should be formatted as a block.
	 * That includes newlines after and before the brackets, and a fresh line for each expression.
	 */
	def protected boolean isMultilineLambda(XClosure closure) {
		val closingBracket = closure.nodeForKeyword(']')
		if (closingBracket?.hiddenLeafsBefore != null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		return switch block : closure.expression {
			XBlockExpression : block.expressions.size > 1 && block.expressions.eachExpressionInOwnLine
			default : false
		}
	}

	def protected dispatch boolean isMultiParamInOwnLine(XMemberFeatureCall fc, FormattableDocument doc) {
		val closingBracket = fc.nodeForKeyword(')')
		if (closingBracket?.hiddenLeafsBefore != null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		val params = fc.memberCallArguments.explicitParams
		return params.size > 1 && params.eachExpressionInOwnLine
	}

	def protected dispatch boolean isMultiParamInOwnLine(XFeatureCall fc, FormattableDocument doc) {
		val closingBracket = fc.nodeForKeyword(')')
		if (closingBracket?.hiddenLeafsBefore != null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		val params = fc.featureCallArguments.explicitParams
		return params.size > 1 && params.eachExpressionInOwnLine
	}

	def protected dispatch boolean isMultiParamInOwnLine(XConstructorCall fc, FormattableDocument doc) {
		val closingBracket = fc.nodeForKeyword(')')
		if (closingBracket?.hiddenLeafsBefore != null) {
			return closingBracket.hiddenLeafsBefore.newLines > 0
		}
		val params = fc.arguments.explicitParams
		return params.size > 1 && params.eachExpressionInOwnLine
	}
	
	def private boolean isEachExpressionInOwnLine(Iterable<? extends XExpression> expressions) {
		var lastLine = -1
		for (e : expressions) {
			val node = e.nodeForEObject
			if (lastLine == node.startLine)
				return false
			lastLine = node.endLine
		}
		return true
	}

	def protected dispatch void format(XIfExpression expr, FormattableDocument format) {
		if (expr.eContainer instanceof XVariableDeclaration) {
			format += expr.nodeForKeyword("if").append[increaseIndentation]
			format += expr.nodeForEObject.append[decreaseIndentation]
		}
		val thennode = expr.then.nodeForEObject
		val elsenode = expr.^else?.nodeForEObject
		val multiline = thennode.text.trim.contains("\n") || thennode.whitespaceBefore?.text?.contains("\n") ||
			elsenode?.text?.trim?.contains("\n")
		if (expr.then instanceof XBlockExpression || multiline)
			format += expr.nodeForKeyword("if").append[oneSpace]
		else
			format += expr.nodeForKeyword("if").append[noSpace]
		if (expr.then instanceof XBlockExpression || !multiline) {
			format += thennode.prepend[ space = " "]
			if (expr.^else != null)
				format += thennode.append[ space = " "]
		} else {
			format += thennode.prepend[ newLine increaseIndentation]
			if (expr.^else != null)
				format += thennode.append[ newLine; decreaseIndentation]
			else
				format += thennode.append[decreaseIndentation]
		}
		if (expr.^else instanceof XIfExpression || expr.^else instanceof XBlockExpression || !multiline) {
			format += elsenode.prepend[ space = " "]
		} else {
			format += elsenode.prepend[ newLine increaseIndentation]
			format += elsenode.append[decreaseIndentation]
		}
		expr.then.format(format)
		if (expr.^else != null)
			expr.^else.format(format)
	}

	def protected dispatch void format(XForLoopExpression expr, FormattableDocument format) {
		expr.nodeForKeyword("for") => [ format += append[oneSpace] ]
		expr.declaredParam.nodeForEObject => [ format += prepend[noSpace] format += append[oneSpace] ]
		expr.forExpression.nodeForEObject => [ format += prepend[oneSpace] format += append[noSpace] ]
		val each = expr.eachExpression.nodeForEObject
		if (expr.eachExpression instanceof XBlockExpression) {
			format += each.prepend[oneSpace]
		} else {
			format += each.prepend[ newLine increaseIndentation]
			format += each.append[decreaseIndentation]
		}
		expr.forExpression.format(format)
		expr.eachExpression.format(format)
	}

	def protected dispatch void format(XWhileExpression expr, FormattableDocument format) {
		expr.nodeForKeyword("while") => [ format += append[oneSpace] ]
		expr.predicate.nodeForEObject => [ format += prepend[noSpace] format += append[noSpace] ]
		val body = expr.body.nodeForEObject
		if (expr.body instanceof XBlockExpression) {
			format += body.prepend[oneSpace]
		} else {
			format += body.prepend[ newLine increaseIndentation]
			format += body.append[decreaseIndentation]
		}
		expr.predicate.format(format)
		expr.body.format(format)
	}

	def protected dispatch void format(XDoWhileExpression expr, FormattableDocument format) {
		expr.nodeForKeyword("while") => [ format += append[oneSpace] ]
		expr.predicate.nodeForEObject => [ format += prepend[noSpace] format += append[noSpace] ]
		val body = expr.body.nodeForEObject
		if (expr.body instanceof XBlockExpression) {
			format += body.prepend[oneSpace]
			format += body.append[oneSpace]
		} else {
			format += body.prepend[ newLine increaseIndentation]
			format += body.append[ newLine decreaseIndentation]
		}
		expr.predicate.format(format)
		expr.body.format(format)
	}

	def protected dispatch void format(XBlockExpression expr, FormattableDocument format) {
		val open = expr.nodeForKeyword("{")
		val close = expr.nodeForKeyword("}")
		if (open != null && close != null) {
			if (expr.expressions.empty) {
				format += open.append[newLine]
			} else {
				format += open.append[increaseIndentation]
				format += open.append(format.cfg.newLinesAroundExpression)
				for (child : expr.expressions) {
					child.format(format)
					if (child != expr.expressions.last || close != null) {
						val childNode = child.nodeForEObject
						val sem = childNode.immediatelyFollowingKeyword(";")
						if (sem != null) {
							format += sem.prepend[noSpace]
							format += sem.append(format.cfg.newLinesAroundExpression)
						} else {
							format += childNode.append(format.cfg.newLinesAroundExpression)
						}
					}
				}
				format += close.prepend[decreaseIndentation]
			}
		}
	}

	def protected dispatch void format(XTypeLiteral expr, FormattableDocument format) {
		val typeNode = expr.nodeForFeature(XTYPE_LITERAL__TYPE)
		format += expr.nodeForKeyword("typeof").append[noSpace]
		format += typeNode.prepend[noSpace]
		format += typeNode.append[noSpace]
		var node = typeNode
		while (node != null) {
			node = node.immediatelyFollowingKeyword("[")
			if (node != null) {
				format += node.append[noSpace]
				node = node.immediatelyFollowingKeyword("]")
				if (node != null) {
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
			format += body.prepend[oneSpace]
			format += body.append[oneSpace]
		} else {
			format += body.prepend[ newLine increaseIndentation]
			format += body.append[ newLine decreaseIndentation]
		}
		expr.expression.format(format)
		for (cc : expr.catchClauses) {
			cc.format(format)
			if (cc != expr.catchClauses.last || expr.finallyExpression != null) {
				if (cc.expression instanceof XBlockExpression)
					format += cc.nodeForEObject.append[oneSpace]
				else
					format += cc.nodeForEObject.append[newLine]
			}
		}
		if (expr.finallyExpression != null) {
			val fin = expr.finallyExpression.nodeForEObject
			if (expr.finallyExpression instanceof XBlockExpression) {
				format += fin.prepend[oneSpace]
			} else {
				format += fin.prepend[ newLine increaseIndentation]
				format += fin.append[decreaseIndentation]
			}
			expr.finallyExpression.format(format)
		}
	}

	def protected dispatch void format(XCatchClause expr, FormattableDocument format) {
		format += expr.nodeForKeyword("catch").append[oneSpace]
		expr.declaredParam.nodeForEObject => [ format += prepend[noSpace] format += append[noSpace]]
		val body = expr.expression.nodeForEObject
		if (expr.expression instanceof XBlockExpression)
			format += body.prepend[oneSpace]
		else {
			format += body.prepend[ newLine increaseIndentation]
			format += body.append[decreaseIndentation]
		}
		expr.declaredParam.format(format)
		expr.expression.format(format)
	}

	def protected dispatch void format(JvmFormalParameter expr, FormattableDocument format) {
		if (expr.parameterType != null)
			format += expr.parameterType.nodeForEObject.append[oneSpace]
		expr.parameterType.format(format)
	}

	def protected dispatch void format(XExpression expr, FormattableDocument format) {
		for (obj : expr.eContents)
			switch (obj) {
				XExpression: obj.format(format)
			}
	}

	def protected String lookahead(FormattableDocument fmt, EObject expression) {
		val lookahead = new FormattableDocument(fmt)
		format(expression, lookahead)
		val node = expression.nodeForEObject
		lookahead.renderToString(node.offset, node.length)
	}

	def protected boolean fitsIntoLine(FormattableDocument fmt, EObject expression) {
		val node = expression.nodeForEObject
		val lookahead = fmt.lookahead(expression)
		if (lookahead.contains("\n")) {
			return false
		} else {
			val length = fmt.lineLengthBefore(node.offset) + lookahead.length
			return length <= fmt.cfg.maxLineWidth.value
		}
	}

}
/* class RichStringFormatter extends AbstractRichStringPartAcceptor$ForLoopOnce {
	
	override acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
		println('''super.acceptSemanticLineBreak(charCount=«charCount», origin, controlStructureSeen=«controlStructureSeen»)''')
		
	}
	
	override acceptSemanticText(CharSequence text, RichStringLiteral origin) {
		println('''super.acceptSemanticText(text=«text», origin)''')
	}
	
	override acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
		println('''super.acceptTemplateLineBreak(charCount=«charCount», origin)''')
		
	}
	
	override acceptTemplateText(CharSequence text, RichStringLiteral origin) {
		println('''super.acceptTemplateText(text=«text», origin)''')
	}
} */
// problem: Format is not being filled sequentially, therefore lookahead operations on it may be affected 
/*
 * def dispatch void genExpression(ExpCtx it, ForStmt forStmt) {
		genExpression("loop", forStmt.source,
			forStmt.
				newTypeRef(typeof(Iterable),
					wildCardExtends(forStmt.parameterType)))
	}
 */
/*
				members +=
					element.
						toMethod("toString", element.newTypeRef(typeof(String))) [
							body = [
								val type = findDeclaredType(typeof(ToStringHelper),
									element)
								append("return new ")
								append(type)
								append("().toString(this);");
							]
						]

  */
