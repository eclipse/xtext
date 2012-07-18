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
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.lib.util.ToStringHelper

import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*

import static extension com.google.common.collect.Multimaps.*

public class XtendFormatter {
	
	@Inject IWhitespaceInformationProvider whitespaeInfo
	@Inject TextRenderer renderer
	
	def void format(XtextResource res, int offset, int length, (int, int, String)=>void out ) {
		val cfg = new RendererConfiguration() => [
			lineSeparator = whitespaeInfo.getLineSeparatorInformation(res.URI).lineSeparator
			indentation = whitespaeInfo.getIndentationInformation(res.URI).indentString
		]
		
		val format = (res.contents.head as XtendFile).format.filterNull
		
		val range2edit = format.index[it.offset -> it.length]
		val mergededits = range2edit.asMap.values.map[if(size == 1) iterator.next else mergeEdits]
		
		val edits = renderer.render(res.parseResult.rootNode.text, cfg, mergededits)
		
		edits.filter[e|e.offset >= offset && e.offset + e.length <= offset + length].forEach[e|out.apply(e.offset, e.length, e.text)]
	}
	
	def protected FormattingData mergeEdits(Collection<FormattingData> edits) {
		newFormattingData(edits.head.offset -> edits.head.length, [
			for(e:edits)
				switch e {
					AnchoredData: {
						if(e.leftAnchor != null) {
							if(leftAnchor == null)
								leftAnchor = e.leftAnchor
							else 
								throw new IllegalStateException("can not merge formatting data.")
						}
						if(e.rightAnchor != null) {
							if(rightAnchor == null) 
								rightAnchor = e.rightAnchor
							else 
								throw new IllegalStateException("can not merge formatting data.")
						}
						switch e {
							WhitespaceData: {
								if(e.space != null) {
									if(space == null)
										space = e.space
									else 
										throw new IllegalStateException("can not merge formatting data.")
								}
								canWrap = canWrap || e.canWrap
							}
							NewLineData: {
								newLines = Math::max(newLines, e.newLines)
								indentationChange = indentationChange + e.indentationChange
							}
						}	
					}
				}
				if(newLines > 0)
					space = null
		])
	}
	
	def protected dispatch format(XtendFile xtendFile) {
		val format = <FormattingData>newArrayList()
		
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
		for(clazz:xtendFile.xtendClasses) 
			format += clazz.format
		
		format += xtendFile.nodeForEObject.append[newLine]
		format
	}
	
	def protected dispatch format(XtendClass clazz) {
		val format = <FormattingData>newArrayList()
		for(annotation:clazz.annotations)
			format += annotation.nodeForEObject.append[newLine]
		val clazzOpenBrace = clazz.nodeForKeyword("{")
		format += clazzOpenBrace.prepend[space=" "]
		if(!clazz.members.empty) {
			format += clazzOpenBrace.append[newLine; increaseIndentation]
			for(i: 0..(clazz.members.size - 1)) { 
				switch member : clazz.members.get(i) {
					XtendFunction: {
						format += member.expression.format
					}
				}
				if(i < clazz.members.size - 1) {
					val current = clazz.members.get(i)
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
		format
	}
	
	def protected dispatch List<FormattingData> format(XVariableDeclaration expr) {
		expr.right.format				
	}
	
	def protected dispatch List<FormattingData> format(Void expr) {
		<FormattingData>emptyList
	}
	
	def protected dispatch List<FormattingData> format(XFeatureCall expr) {
		val format = <FormattingData>newArrayList()
		for(arg : expr.featureCallArguments)
			format += arg.format
		format
	}
	
	def protected dispatch List<FormattingData> format(XMemberFeatureCall expr) {
		val format = <FormattingData>newArrayList()
		for(arg : expr.memberCallArguments)
			format += arg.format
		format
	}
	
	def protected dispatch List<FormattingData> format(XSwitchExpression expr) {
		val format = <FormattingData>newArrayList()
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
			format += c.^case.format
			format += c.then.format
		}
		format
	}
	
	def protected dispatch List<FormattingData> format(XClosure expr) {
		val format = <FormattingData>newArrayList()
		val open = expr.nodeForKeyword("[")
		val close = expr.nodeForKeyword("]")
		val explicit = expr.nodeForFeature(XCLOSURE__EXPLICIT_SYNTAX)
		val multiline = expr.nodeForEObject.text.trim.contains("\n")
		switch child:expr.expression {
			XBlockExpression case expr.declaredFormalParameters.empty && child.expressions.empty: {
				format += open?.append[noSpace]
			}
			XBlockExpression case multiline: {
				if(explicit != null)
					format += explicit.append[newLine; increaseIndentation]
				else
					format += open?.append[newLine; increaseIndentation]
				for(c:child.expressions) {
					format += format(c)
					if(c != child.expressions.last)
						format += c.nodeForEObject.append[ newLine ]
				}
				format += close?.prepend[ newLine; decreaseIndentation ]
			}
			XBlockExpression case expr.useNoSpaceInsideClosure: {
				if(!expr.declaredFormalParameters.empty) {
					val n = expr.declaredFormalParameters.get(0).nodeForEObject
					format += n.prepend[noSpace]
					format += n.append[noSpace]
				}
				val c = child.expressions.get(0).nodeForEObject
				format += c.prepend[noSpace]
				format += c.append[noSpace]
			}
			XBlockExpression: {
				format += open?.append[ space = " " ]
				for(c:child.expressions) {
					format += format(c)
					format += c.nodeForEObject.append[ space = " " ]
				}
			}
			XExpression: {
				format += child.format
			}
		}
		format
	}
	
	def protected boolean useNoSpaceInsideClosure(XExpression expression) {
		switch expression {
			XClosure: 
				expression.declaredFormalParameters.size <= 1 && expression.expression.useNoSpaceInsideClosure
			XBlockExpression: 
				if(expression.expressions.size != 1) 
					false 
				else 
					expression.expressions.get(0).useNoSpaceInsideClosure
			XFeatureCall: 
				true
			XBinaryOperation: 
				false
			default:
				false 
		}
	}
	
	def protected dispatch format(XIfExpression expr) {
		val format = <FormattingData>newArrayList()
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
			format += thennode.append[newLine decreaseIndentation]
		}
		if(expr.^else instanceof XBlockExpression || !multiline) {
			format += elsenode.prepend[space = " "]
		} else {
			format += elsenode.prepend[newLine increaseIndentation]
			format += elsenode.append[newLine decreaseIndentation]
		}
		format += expr.then.format
		if(expr.^else != null)
			format += expr.^else.format
		format
	}
	
	def protected dispatch format(XForLoopExpression expr) {
		val format = <FormattingData>newArrayList()
		if(expr.eachExpression instanceof XBlockExpression) {
		} else {
			val each = expr.eachExpression.nodeForEObject 
			format += each.prepend[newLine increaseIndentation]
			format += each.append[newLine decreaseIndentation]
		}
		format += expr.forExpression.format
		format += expr.eachExpression.format
		format
	}
	
	def protected dispatch format(XBlockExpression expr) {
		val format = <FormattingData>newArrayList()
		val open = expr.nodeForKeyword("{")
		val close = expr.nodeForKeyword("}")
		if(open != null && close != null) {
			if(expr.expressions.empty) {
				format += open.append[ newLine ] 
			} else { 
				format += open.append[ newLine; increaseIndentation ]
				for(child:expr.expressions) {
					format += child.format
					if(child != expr.expressions.last) {
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
				format += close.prepend[ newLine; decreaseIndentation ]
			}
		}
		format
	}
	
	def protected dispatch format(XExpression expr) {
		val format = <FormattingData>newArrayList()
		for(obj:expr.eContents)
			switch(obj) {
				XExpression: format += obj.format
			}
		format
	}
	
//	def operator_add(FormattingGroup group, Format data) {
//		switch data {
//			FormattingData: group.data.add(data) 
//			FormattingGroup: group.data.addAll(data.data) 
//		}
//	}
	
	def INode nodeForEObject(EObject obj) {
		NodeModelUtils::findActualNodeFor(obj)
	}
	
	def ILeafNode nodeForKeyword(EObject obj, String kw) {
		val node = NodeModelUtils::findActualNodeFor(obj)
		node.asTreeIterable.findFirst[semanticElement == obj && grammarElement instanceof Keyword && text == kw] as ILeafNode
	}
	
	def INode nodeForFeature(EObject obj, EStructuralFeature feature) {
		NodeModelUtils::findNodesForFeature(obj, feature).head
	}
	
	def Iterable<INode> features(EObject obj, EStructuralFeature feature) {
		NodeModelUtils::findNodesForFeature(obj, feature)
	}
	
	def ILeafNode immediatelyFollowingKeyword(INode node, String kw) {
		var current = node
		while(current instanceof ICompositeNode) 
			current = (current as ICompositeNode).lastChild
		val current1 = current
		val result = current1.findNextLeaf[current1 != it && grammarElement instanceof Keyword]
		if(result != null && result.text == kw) result
	}
	
	def protected Pair<Integer, Integer> getRangeBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val previous = start.findPreviousLeaf
		if(previous.hidden)
			previous.offset -> previous.length
		else  
			start.offset -> 0
	}
	
	def protected whitespaceBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val previous = start.findPreviousLeaf
		if(previous.hidden) 
			previous
	}
	
	def protected Pair<Integer, Integer> getRangeAfter(INode node) {
		val start = node.findPreviousLeaf[!hidden]
		val next = start.findNextLeaf
		if(next != null) {
			if(next.hidden) 
				next.offset -> next.length
			else  
				start.offset + start.length -> 0
		}
	}
	
	def protected FormattingData append(INode node, (FormattingDataInit)=>void init) {
		if(node != null) {
			node.rangeAfter?.newFormattingData(init)
		}
	}
	
	def protected FormattingData prepend(INode node, (FormattingDataInit)=>void init) {
		if(node != null) {
			node.rangeBefore?.newFormattingData(init)
		}
	}
	
	def protected FormattingData newFormattingData(Pair<Integer, Integer> range, (FormattingDataInit)=>void init) {
		val it = new FormattingDataInit()
		init.apply(it)
		if(newLines == 0 && indentationChange == 0)
			return new WhitespaceData(range.key, range.value, leftAnchor, rightAnchor, space ?: " ", canWrap)
		else if(space == null)
			return new NewLineData(range.key, range.value, leftAnchor, rightAnchor, newLines, indentationChange)
		else 
			throw new IllegalStateException(init.toString) 
	}
	
	def protected ILeafNode findNextLeaf(INode node, (ILeafNode) => boolean matches) {
		if(node instanceof ILeafNode && matches.apply(node as ILeafNode))
			return node as ILeafNode
		val ni = new NodeIterator(node)
		while(ni.hasNext) {
			val next = ni.next
			if(next instanceof ILeafNode && matches.apply(next as ILeafNode))
				return next as ILeafNode
		}
	}
	
	def protected ILeafNode findNextLeaf(INode node) {
		val ni = new NodeIterator(node)
		while(ni.hasNext) {
			val next = ni.next
			if(next instanceof ILeafNode)
				return next as ILeafNode
		}
	}
	
	def protected ILeafNode findPreviousLeaf(INode node, (ILeafNode) => boolean matches) {
		var current = node
		while(current instanceof ICompositeNode)
			current = (current as ICompositeNode).lastChild
		if(current instanceof ILeafNode && matches.apply(current as ILeafNode))
			return current as ILeafNode
		val ni = new NodeIterator(current)
		while(ni.hasPrevious) {
			val previous = ni.previous
			if(previous instanceof ILeafNode && matches.apply(previous as ILeafNode))
				return previous as ILeafNode
		}
	}
	
	def protected ILeafNode findPreviousLeaf(INode node) {
		var current = node
		while(current instanceof ICompositeNode)
			current = (current as ICompositeNode).lastChild
		val ni = new NodeIterator(current)
		while(ni.hasPrevious) {
			val previous = ni.previous
			if(previous != current && previous instanceof ILeafNode)
				return previous as ILeafNode
		}
	}
}

//@Data class Whitespace {
//	int offset
//	int length
//	FormatterCfg cfg
//	
//	def setNoSpace() {
//		cfg.out.apply(offset, length, "")
//	}
//	
//	def setSpace(String space) {
//		cfg.out.apply(offset, length, space)
//	}
//	
//	def setNewLine(int indentation) {
//		cfg.out.apply(offset, length, cfg.getWrap(1) + cfg.getIndentation(indentation))
//	}
//	
//	def setNewLine() {
//		cfg.out.apply(offset, length, cfg.getWrap(1))
//	}
//	
//	def setNewLines(int newLines, int indentation) {
//		cfg.out.apply(offset, length, cfg.getWrap(newLines) + cfg.getIndentation(indentation))
//	}
//	
//}

//@Data class FormatterCfg {
//	String lineSeparator
//	String indentation
//	(int, int, String)=>void out
//	
//	def getIndentation(int levels) {
//		if(levels > 0) 
//			(0..levels - 1).map[_indentation].join 
//		else 
//			""
//	}
//	
//	def getWrap(int levels) {
//		if(levels > 0) 
//			(0..levels - 1).map[_lineSeparator].join 
//		else 
//			""
//	}
//}

class FormattingDataInit {
	public Object leftAnchor
	public Object rightAnchor
	public String space = null
	public boolean canWrap = true
	public int newLines = 0
	public int indentationChange = 0
	
	def newLine() {
		newLines = 1
	}
	
	def noSpace() {
		space = ""
	}
	
	def increaseIndentation() {
		indentationChange = indentationChange + 1
	}
	
	def decreaseIndentation() {
		indentationChange = indentationChange - 1
	}
	
	override toString() {
		new ToStringHelper().toString(this)
	}
	
}
