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
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendPackage$Literals
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XVariableDeclaration

import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*

@SuppressWarnings("restriction")
public class XtendFormatter {
	
	@Inject extension NodeModelAccess
	@Inject extension FormatterExtensions
	@Inject extension XtendGrammarAccess
	
	@Inject IWhitespaceInformationProvider whitespaeInfo
	@Inject RichStringFormatter richStringFormatter
	
	@Property boolean allowIdentityEdits = false
	
	def List<TextReplacement> format(XtextResource res, int offset, int length, RendererConfiguration cfg) {
		cfg.lineSeparator = whitespaeInfo.getLineSeparatorInformation(res.URI).lineSeparator
		cfg.indentation = whitespaeInfo.getIndentationInformation(res.URI).indentString
		
		val doc = res.parseResult.rootNode.text
		val format = new FormattableDocument(cfg, doc)
		format(res.contents.head as XtendFile, format)

		val edits = format.renderToEdits(offset, length)
		
		if(allowIdentityEdits)
			edits
		else 
			edits.filter[doc.substring(it.offset, it.offset + it.length) != text].toList		
	}
	
	def protected dispatch void format(XtendFile xtendFile, FormattableDocument format) {
		val pkg = xtendFile.nodeForFeature(XTEND_FILE__PACKAGE)
		val pkgSemicolon = pkg.immediatelyFollowingKeyword(";")
		if(pkgSemicolon != null) {
			format += pkg.append[space=""]
			format += pkgSemicolon.append[newLines = 2]
		} else {
			format += pkg.append[newLines = 2]
		}
		for(imp:xtendFile.imports)
			if(imp != xtendFile.imports.last)
				format += imp.nodeForEObject.append[newLine]
			else 
				format += imp.nodeForEObject.append[newLines = 2] 
		for(clazz : xtendFile.xtendTypes) 
			clazz.format(format)
		
		format += xtendFile.nodeForEObject.append[newLine]
	}
	
	def protected dispatch void format(XtendClass clazz, FormattableDocument format) {
		for(annotation:clazz.annotations)
			format += annotation.nodeForEObject.append[newLine]
		val clazzOpenBrace = clazz.nodeForKeyword("{")
		format += clazzOpenBrace.prepend[space=" "]
		if(!clazz.members.empty) {
			format += clazzOpenBrace.append[newLine; increaseIndentation]
			for(i: 0..(clazz.members.size - 1)) { 
				val current = clazz.members.get(i)
				current.format(format)
				if(i < clazz.members.size - 1) {
					val next = clazz.members.get(i + 1)
					if(current instanceof XtendField && next instanceof XtendField)
						format += current.nodeForEObject.append[newLine]
					else 
						format += current.nodeForEObject.append[newLines = 2]
				} else {
					format += clazz.members.get(i).nodeForEObject.append[newLine decreaseIndentation]
				} 
			}
		} else {
			format += clazzOpenBrace.append[newLine]
		}
	}
	
	def protected dispatch void format(XtendFunction func, FormattableDocument format) {
		val nameNode = func.nodeForFeature(XtendPackage$Literals::XTEND_FUNCTION__NAME)
		val open = nameNode.immediatelyFollowingKeyword("(")
		val close = func.nodeForKeyword(")")
		if(close?.whitespaceBefore?.text?.contains("\n")) {
			var INode comma = null
			if(func.parameters.empty)
				format += open.append[noSpace]
			else for(param:func.parameters) {
				if(param == func.parameters.head) 
 					format += open.append[newLine; increaseIndentation]
 				else if(comma != null)
 					format += comma.append[newLine]
 				if(param == func.parameters.last) 
 					format += param.nodeForEObject.append[newLine; decreaseIndentation]
				comma = param.nodeForEObject.immediatelyFollowingKeyword(",") 
			} 
		} else {
			var INode comma = null
			var indented = false
			for(param:func.parameters) {
				if(format.fitsIntoLine(param)) {
					if(comma == null) 
						format += open.append[noSpace]
					else 
						format += comma.append[oneSpace]
				} else {
					val n = if(comma == null) open else comma 
					format += n.append[newLine]
					if(!indented)
						format += n.append[increaseIndentation]
					indented = true
				}
				comma = param.nodeForEObject.immediatelyFollowingKeyword(",") 
			}
			if(func.parameters.size > 0) {
				val last = func.parameters.last.nodeForEObject
				format += last.append[noSpace]
				if(indented)
					format += last.append[decreaseIndentation]
			} else 
				format += open.append[noSpace]
		}
		func.expression.format(format) 
	}
	
	def protected dispatch void format(XtendParameter param, FormattableDocument format) {
		
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
	
	def protected void formatFeatureCallParamsWrapIfNeeded(INode open, List<XExpression> params, FormattableDocument format) {
		val builder = params.builder
		val explicitParams = params.explicitParams		
		var INode node = null
		var indented = false
		
		if(explicitParams.empty) {
			format += open.append[noSpace]
		} else for(arg : explicitParams) {
			if(arg == explicitParams.head) {
				val head = arg.nodeForEObject
				if(format.fitsIntoLine(arg)) {
					format += head.prepend[noSpace]
				} else { 
					format += head.prepend[newLine]
					if(!indented)
						format += head.prepend[increaseIndentation]
					indented = true
				}
			} else if(node != null) {
				if(format.fitsIntoLine(arg)) {
					format += node.append[oneSpace]
				} else { 
					format += node.append[newLine]
					if(!indented)
						format += node.append[increaseIndentation]
					indented = true
				}
			}
			if(arg == explicitParams.last) {
				format += arg.nodeForEObject.append[noSpace]
			} 
			arg.format(format)
			node = arg.nodeForEObject.immediatelyFollowingKeyword(",")
		}
		if(indented)
			format += explicitParams.last.nodeForEObject.append[decreaseIndentation]
		if(builder != null) {
			format += builder.nodeForEObject.prepend[noSpace]
			builder.format(format)
		}
	}
	
	def protected XExpression builder(List<XExpression> params) {
		if(params.last != null && (params.last.nodeForEObject as ICompositeNode).firstChild.grammarElement == XMemberFeatureCallAccess.memberCallArgumentsXClosureParserRuleCall_1_1_4_0) 
			params.last
	}
	
	def protected Iterable<XExpression> explicitParams(List<XExpression> params) {
		val builder = params.builder
		if(builder != null) params.take(params.size -1) else params
	}
	
	def protected void formatFeatureCallParamsMultiline(INode open, List<XExpression> params, FormattableDocument format) {
		val builder = params.builder
		val explicitParams = params.explicitParams		
		var INode node = null
		
		if(explicitParams.empty) {
			format += open.append[noSpace]
		} else for(arg : explicitParams) {
			if(arg == explicitParams.head) {
				val head = arg.nodeForEObject
				format += head.prepend[newLine;increaseIndentation]
			} else if(node != null)
				format += node.append[newLine]
			if(arg == explicitParams.last) 
				format += arg.nodeForEObject.append[newLine;decreaseIndentation]
			arg.format(format)
			node = arg.nodeForEObject.immediatelyFollowingKeyword(",")
		}
		if(builder != null) {
			format += builder.nodeForEObject.prepend[noSpace]
			builder.format(format)
		}
	}
	
	def protected dispatch void format(XConstructorCall expr, FormattableDocument format) {
		if(expr.useStyleMultiline(format))
			formatFeatureCallParamsMultiline(expr.nodeForKeyword("("), expr.arguments, format)
		else
			formatFeatureCallParamsWrapIfNeeded(expr.nodeForKeyword("("), expr.arguments, format)
	}
	
	def protected dispatch void format(XFeatureCall expr, FormattableDocument format) {
		if(expr.explicitOperationCall) {
			if(expr.useStyleMultiline(format))
				formatFeatureCallParamsMultiline(expr.nodeForKeyword("("), expr.featureCallArguments, format)
			else
				formatFeatureCallParamsWrapIfNeeded(expr.nodeForKeyword("("), expr.featureCallArguments, format)
		}
		else for(arg : expr.featureCallArguments)
			format(arg, format)
	}
	
	def protected dispatch void format(XMemberFeatureCall expr, FormattableDocument format) {
		var EObject top = expr
		var calls = <XMemberFeatureCall>newArrayList()
		while(top instanceof XMemberFeatureCall) {
			calls += top as XMemberFeatureCall
			top = (top as XMemberFeatureCall).memberCallTarget
		}
		format(top, format)
		
		var indented = false
		for(call:calls.reverse) {
			val featureNode = call.nodeForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
			val targetNode = call.memberCallTarget.nodeForEObject
			if(targetNode != null) {
				val callOffset = targetNode.offset + targetNode.length
				val op = call.nodeForKeyword(if(call.nullSafe) "?." else if(call.spreading) "*." else ".")
				format += op.prepend[noSpace]
				if(call.explicitOperationCall) {
					val callNode = call.nodeForEObject
					val callLength = callNode.offset + callNode.length - callOffset
					val open = call.nodeForKeyword("(")
					format += featureNode.append[noSpace]
					
					val lineLength = format.lineLengthBefore(callOffset)
					if(call.useStyleMultiline(format)) {
						if(lineLength + featureNode.length < format.cfg.maxLineWidth) 
							format += op.append[noSpace]
						else
							format += op.append[newLine]
						formatFeatureCallParamsMultiline(open, call.memberCallArguments, format)
					} else {
						if(lineLength + (featureNode.length * 2) < format.cfg.maxLineWidth || format.fitsIntoLine(callOffset, callLength, [ f |
							f += op.append[noSpace] 
							formatFeatureCallParamsWrapIfNeeded(open, call.memberCallArguments, f)
						])) {
							format += op.append[noSpace]
						} else {
							format += op.append[newLine]
							if(!indented) {
								indented = true
								format += op.append[increaseIndentation]
							}
						}
						formatFeatureCallParamsWrapIfNeeded(open, call.memberCallArguments, format)
					}
				} else {
					val shortLenght = format.lineLengthBefore(callOffset) + featureNode.length
					if(shortLenght < format.cfg.maxLineWidth) {
						format += op.append[noSpace]
					} else {
						format += op.append[newLine]
						if(!indented) {
							indented = true
							format += op.append[increaseIndentation]
						}
					}
					for(arg : call.memberCallArguments)
						format(arg, format)
				} 
			}
		}
		if(indented)
			format += calls.last.nodeForEObject.append[decreaseIndentation]
	}
	
	def protected AbstractRule binaryOperationPrecedence(EObject op) {
		val node = op.nodeForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
		if(node != null && node.grammarElement instanceof CrossReference) {
			val terminal = (node.grammarElement as CrossReference).terminal
			if(terminal instanceof RuleCall)
				return (terminal as RuleCall).rule
		}
	}
	
	def protected dispatch void format(XBinaryOperation expr, FormattableDocument format) {
		var precendece = expr.binaryOperationPrecedence
		var EObject top = expr
		var calls = <XBinaryOperation>newArrayList()
		while(top.binaryOperationPrecedence == precendece) {
			calls += top as XBinaryOperation
			top = (top as XBinaryOperation).leftOperand
		}
		format(top, format)
		
		var indented = false
		for(call:calls.reverse) {
			val op = call.nodeForFeature(XABSTRACT_FEATURE_CALL__FEATURE)
			format += op.prepend[oneSpace]
			
			if(call.rightOperand.useStyleMultiline(format) || format.fitsIntoLine(call.rightOperand)) {
				format += op.append[oneSpace]
			} else {
				format += op.append[newLine]
				if(!indented) {
					indented = true
					format += op.append[increaseIndentation]
				}
			}
			format(call.rightOperand, format)
		}
		if(indented)
			format += calls.last.nodeForEObject.append[decreaseIndentation]
	}
	
	def protected dispatch void format(XSwitchExpression expr, FormattableDocument format) {
		val containsBlockExpr = expr.cases.exists[then instanceof XBlockExpression]
		val switchSL = !containsBlockExpr && !expr.nodeForEObject.text.trim.contains("\n")
		val caseSL = !containsBlockExpr && !expr.cases.exists[nodeForEObject.text.trim.contains("\n")]
		val open = expr.nodeForKeyword("{")
		val close = expr.nodeForKeyword("}")
		if(switchSL) {
			format += open.prepend[space=" "]
			format += open.append[space=" "]
			for(c:expr.cases) { 
				val cnode = c.then.nodeForEObject
				format += cnode.prepend[space=" "]
				format += cnode.append[space=" "]
			}
		} else if(caseSL) {
			format += open.prepend[space=" "]
			format += open.append[newLine; increaseIndentation]
			for(c:expr.cases) {
				format += c.then.nodeForEObject.prepend[space=" "] 
				if(c != expr.cases.last)
					format += c.nodeForEObject.append[newLine]
			}
			format += close.prepend[newLine; decreaseIndentation]
		} else {
			format += open.prepend[space=" "]
			format += open.append[newLine; increaseIndentation]
			for(c:expr.cases) {
				val cnode = c.then.nodeForEObject
				if(c.then instanceof XBlockExpression) {
					format += cnode.prepend[space = " "]
					if(c != expr.cases.last) 
						format += cnode.append[newLine]
				 	else 
						format += cnode.append[newLine; decreaseIndentation]
				} else {
					format += cnode.prepend[newLine; increaseIndentation]
					if(c != expr.cases.last) 
							format += cnode.append[newLine; decreaseIndentation]
					 	else 
							format += cnode.append[newLine; indentationChange = -2 ]
				}
			}
		}
		for(c:expr.cases) {
			if(c.typeGuard != null && c.^case != null) {
				val typenode = c.nodeForFeature(XCASE_PART__TYPE_GUARD)
				val casenode = c.nodeForFeature(XCASE_PART__CASE)
				format += typenode.append[space=" "]
				format += casenode.prepend[space=" "]
				format += casenode.append[noSpace]
			} else if(c.typeGuard != null) {
				val typenode = c.nodeForFeature(XCASE_PART__TYPE_GUARD)
				format += typenode.append[noSpace]
			} else if(c.^case != null) {
				val casenode = c.nodeForFeature(XCASE_PART__CASE)
				format += casenode.prepend[space=" "]
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
		switch child:expr.expression {
			case expr.declaredFormalParameters.empty && children.empty:
				format += expr.nodeForKeyword("[").append[noSpace]
			case expr.useStyleMultiline(format):
				formatClosureMultiLine(expr, open, children, close, format)
			case expr.useStyleClosureNoWhitespace():
				formatClosureNoWhitespace(expr, open, children, close, format)
			default:
				formatClosureWrapIfNeeded(expr, open, children, close, format)
		}
	}
	
	def protected void formatClosureMultiLine(XClosure expr, INode open, Collection<XExpression> children, INode close, FormattableDocument format) {
		val explicit = expr.nodeForFeature(XCLOSURE__EXPLICIT_SYNTAX)
		if(explicit != null)
			format += explicit.append[newLine; increaseIndentation]
		else
			format += open?.append[newLine; increaseIndentation]
		for(c:children) {
			c.format(format)
			val node = c.nodeForEObject
			val semicolon = node.immediatelyFollowingKeyword(";")
			format += semicolon?.prepend[ noSpace ]
			if(c != children.last)
				format += (semicolon ?: node).append[ newLine ]
		}
		format += close?.prepend[ newLine; decreaseIndentation ]
	}
	
	def protected void formatClosureWrapIfNeeded(XClosure expr, INode open, Collection<XExpression> children, INode close, FormattableDocument format) {
		var INode last = open
		var indented = false
		for(c:children) {
			if(format.fitsIntoLine(c))
				format += last.append[oneSpace]
			else {
				if(!indented) {
					indented = true
					format += last.append[increaseIndentation]	
				}
				format += last.append[newLine]
			}
			c.format(format)
			last = c.nodeForEObject
			val semicolon = last.immediatelyFollowingKeyword(";")
			if(semicolon != null) {
				format += semicolon.prepend[noSpace]
				last = semicolon
			}
		}
		if(indented)
			format += children.last.nodeForEObject.append[decreaseIndentation]
	}
	
	def protected void formatClosureNoWhitespace(XClosure expr, INode open, Collection<XExpression> children, INode close, FormattableDocument format) {
		if(!expr.declaredFormalParameters.empty) {
			val n = expr.declaredFormalParameters.get(0).nodeForEObject
			format += n.prepend[noSpace]
			format += n.append[noSpace]
		}
		val c = children.head.nodeForEObject
		format += c.prepend[noSpace]
		format += c.append[noSpace]
	}
	
	def protected dispatch boolean useStyleMultiline(XExpression closure, FormattableDocument doc) {
		false
	}
	
	def protected dispatch boolean useStyleMultiline(XClosure closure, FormattableDocument doc) {
		val close = closure.nodeForKeyword("]") ?: closure.eContainer.nodeForKeyword(")")
		return close != null && close?.whitespaceBefore?.text?.contains("\n")
	}
	
	def protected dispatch boolean useStyleMultiline(XMemberFeatureCall fc, FormattableDocument doc) {
		val close = fc.nodeForKeyword(")")
		if(close != null && close?.whitespaceBefore?.text?.contains("\n")) 
			return true;
		fc.memberCallArguments.explicitParams.exists[useStyleMultiline(doc)]
	}
	
	def protected dispatch boolean useStyleMultiline(XFeatureCall fc, FormattableDocument doc) {
		val close = fc.nodeForKeyword(")")
		if(close != null && close?.whitespaceBefore?.text?.contains("\n")) 
			return true;
		fc.featureCallArguments.explicitParams.exists[useStyleMultiline(doc)]
	}
	
	def protected dispatch boolean useStyleMultiline(XConstructorCall fc, FormattableDocument doc) {
		val close = fc.nodeForKeyword(")")
		if(close != null && close?.whitespaceBefore?.text?.contains("\n")) 
			return true;
		fc.arguments.explicitParams.exists[useStyleMultiline(doc)]
	}
	
	def protected boolean useStyleClosureNoWhitespace(XExpression expression) {
		switch expression {
			XClosure: 
				expression.declaredFormalParameters.size <= 1 && expression.expression.useStyleClosureNoWhitespace
			XBlockExpression: 
				if(expression.expressions.size != 1) 
					false 
				else 
					expression.expressions.get(0).useStyleClosureNoWhitespace
			XFeatureCall: 
				true
			XBinaryOperation: 
				false
			default:
				false 
		}
	}
	
	def protected dispatch void format(XIfExpression expr, FormattableDocument format) {
		if(expr.eContainer instanceof XVariableDeclaration) {
			format += expr.nodeForKeyword("if").append[increaseIndentation]
			format += expr.nodeForEObject.append[decreaseIndentation]
		}
		val thennode = expr.then.nodeForEObject
		val elsenode = expr.^else?.nodeForEObject
		val multiline = thennode.text.trim.contains("\n") || 
		                thennode.whitespaceBefore?.text?.contains("\n") || 
		                elsenode?.text?.trim?.contains("\n") 
		if(expr.then instanceof XBlockExpression || !multiline) {
			format += thennode.prepend[space = " "]
			if(expr.^else != null)
				format += thennode.append[space = " "]
		} else {
			format += thennode.prepend[newLine increaseIndentation]
			if(expr.^else != null)
				format += thennode.append[newLine; decreaseIndentation]
			else
				format += thennode.append[decreaseIndentation]
		}
		if(expr.^else instanceof XIfExpression || expr.^else instanceof XBlockExpression || !multiline) {
			format += elsenode.prepend[space = " "]
		} else {
			format += elsenode.prepend[newLine increaseIndentation]
			format += elsenode.append[decreaseIndentation]
		}
		expr.then.format(format)
		if(expr.^else != null)
			expr.^else.format(format)
	}
	
	def protected dispatch void format(XForLoopExpression expr, FormattableDocument format) {
		if(expr.eachExpression instanceof XBlockExpression) {
		} else {
			val each = expr.eachExpression.nodeForEObject 
			format += each.prepend[newLine increaseIndentation]
			format += each.append[decreaseIndentation]
		}
		expr.forExpression.format(format)
		expr.eachExpression.format(format)
	}
	
	def protected dispatch void format(XBlockExpression expr, FormattableDocument format) {
		val open = expr.nodeForKeyword("{")
		val close = expr.nodeForKeyword("}")
		if(open != null && close != null) {
			if(expr.expressions.empty) {
				format += open.append[ newLine ] 
			} else { 
				format += open.append[ newLine; increaseIndentation ]
				for(child:expr.expressions) {
					child.format(format)
					if(child != expr.expressions.last || close != null) {
						val childNode = child.nodeForEObject
						val sem = childNode.immediatelyFollowingKeyword(";")
						if(sem != null) {
							format += sem.prepend[noSpace]
							format += sem.append[newLine]
						} else {
							format += childNode.append[ newLine ]
						}
					}
				}
				format += close.prepend[ decreaseIndentation ]
			}
		}
	}
	
	def protected dispatch void format(XExpression expr, FormattableDocument format) {
		for(obj:expr.eContents)
			switch(obj) {
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
		if(lookahead.contains("\n")) {
			return false
		} else {
			val length = fmt.lineLengthBefore(node.offset) + lookahead.length
			return length <= fmt.cfg.maxLineWidth
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
