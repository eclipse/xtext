/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.Data
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.Action
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Moitz Eysholdt - Initial contribution and API
 */
public class XtendFormatter2 {

	@Inject extension XtendGrammarAccess;
	@Inject IWhitespaceInformationProvider whitespaeInfo

	def void format(XtextResource res, int offset, int length, (int, int, String)=>void textEditAcceptor) {
		val root = res.parseResult.rootNode
		val uri = root.semanticElement.eResource.URI
		val lineSeparator = whitespaeInfo.getLineSeparatorInformation(uri).lineSeparator
		val indentation = whitespaeInfo.getIndentationInformation(uri).indentString
		format(root, new FormatterState(), new FormatterCfg(lineSeparator, indentation), textEditAcceptor)
	}
	
	def protected void format(INode node, FormatterState state, FormatterCfg cfg, (int, int, String)=>void textEditAcceptor) {
		switch node {
			ILeafNode case node.hidden: {
				state.lastHiddens += node
			}
			ILeafNode case !node.hidden: {
				
				// match before LeafNode
				switch(node.grammarElement) {
					case classAccess.rightCurlyBracketKeyword_10: { state.wrap = 1 state.indentation = state.indentation - 1 } 
					case XBlockExpressionAccess.rightCurlyBracketKeyword_3: { state.wrap = 1 state.indentation = state.indentation - 1 }
//					case XClosureAccess.rightSquareBracketKeyword_3: {
//						val closure = sem as XClosure 
//						if(!closure.explicitSyntax) state.space = ""
//						if((closure.expression as XBlockExpression).expressions.size > 1) { state.wrap = 1 state.indentation = state.indentation - 1 }
//					} 
					case XBlockExpressionAccess.semicolonKeyword_2_1: { state.space = "" } 
					case XExpressionInClosureAccess.semicolonKeyword_1_1: { state.space = "" } 
					case node.text == ".": { if(state.last?.text != "=") state.space = "" } 
					case node.text == ",": { if(state.last?.text != "=") state.space = "" } 
					case node.text == "(": { if(state.last?.text != "=") state.space = "" } 
					case node.text == ")": { if(state.last?.text != "=") state.space = "" } 
					case node.text == "<": { if(state.last?.text != "=") state.space = "" } 
					case node.text == ">": { if(state.last?.text != "=") state.space = "" } 
					case node.text == "[": { if(state.last?.text != "=") state.space = "" } 
					case node.text == "::": { state.space = "" } 
					case node.text == "..": { state.space = "" } 
				}
				
				// apply formatting
				val oldText = state.lastHiddens.map[text].join
				val oldOffset = if(state.lastHiddens.empty) node.offset else state.lastHiddens.head.offset
				val oldLength = if(state.lastHiddens.empty) 0 else oldText.length
				val newText   = if(state.wrap > 0 && state.space.length != 0) cfg.getWrap(state.wrap) + cfg.getIndentation(state.indentation) else state.space
				if(oldText != newText) 
					textEditAcceptor.apply(oldOffset, oldLength, newText)
//				println('''replacing "«oldText.replace("\n", "\\n")»" with "«newText.replace("\n", "\\n")»"''')
				state.lastHiddens.clear()
				state.wrap = 0
				state.space = " "
				state.last = node
				
				// match after LeafNode
				switch(node.grammarElement) {
					case classAccess.leftCurlyBracketKeyword_8: { state.wrap = 1 state.indentation = state.indentation + 1 }
					case XBlockExpressionAccess.leftCurlyBracketKeyword_1: { state.wrap = 1 state.indentation = state.indentation + 1 }
//					case XClosureAccess.leftSquareBracketKeyword_0_0_1: {
//						val closure = sem as XClosure 
//						if(!closure.explicitSyntax && state.last?.text != "=") state.space = ""
//						if((closure.expression as XBlockExpression).expressions.size > 1 && !closure.explicitSyntax) { state.wrap = 1 state.indentation = state.indentation - 1 }
//					} 
//					case XClosureAccess.explicitSyntaxVerticalLineKeyword_1_0_1_0: {
//						val closure = sem as XClosure 
//						if((closure.expression as XBlockExpression).expressions.size > 1) { state.wrap = 1 state.indentation = state.indentation - 1 }
//					} 
					case node.text == ".": { state.space = "" }
					case node.text == "(": { state.space = "" } 
					case node.text == "<": { state.space = "" } 
					case node.text == ">": { state.space = "" } 
					case node.text == "@": { state.space = "" } 
					case node.text == "::": { state.space = "" } 
					case node.text == "..": { state.space = "" } 
					case node.text == "!": { state.space = "" } 
				}
			}
			ICompositeNode: {
				val memberAction = newHashSet(memberAccess.xtendFunctionAnnotationInfoAction_2_1_0,
					                          memberAccess.xtendConstructorAnnotationInfoAction_2_2_0)
				
				// match before CompositeNode
//				val title = new GrammarElementTitleSwitch().showQualified.showAssignments.doSwitch(node.grammarElement)
//				if(title.equals("then=XExpression"))
//					println(title)
				switch ge:node.grammarElement {
					RuleCall case XIfExpressionAccess.thenXExpressionParserRuleCall_5_0: { if(!((node.semanticElement as XIfExpression).^then instanceof XBlockExpression)) { state.wrap = 1 state.indentation = state.indentation + 1 } }
					RuleCall case XIfExpressionAccess.elseXExpressionParserRuleCall_6_1_0: { if(!((node.semanticElement as XIfExpression).^else instanceof XBlockExpression)) { state.wrap = 1 state.indentation = state.indentation + 1 } }
					RuleCall: switch rule:ge.rule {
						case importRule: { state.wrap = if((node.semanticElement.eContainer as XtendFile).imports.head == node.semanticElement) 2 else 1 }  
						case classRule: state.wrap = 2
					} 
					Action case memberAccess.xtendFieldAnnotationInfoAction_2_0_0: state.wrap = 1 
					Action case memberAction.contains(ge): state.wrap = if(state.last?.grammarElement == classAccess.leftCurlyBracketKeyword_8) 1 else 2 
					Action case XAnnotationAccess.XAnnotationAction_0: if(state.wrap < 1) state.wrap = 1 
				}

				// format children				
				for(INode child:node.children)
					format(child, state, cfg, textEditAcceptor)
					
				// match after CompositeNode
				switch ge:node.grammarElement {
					case XBlockExpressionAccess.expressionsXExpressionInsideBlockParserRuleCall_2_0_0: state.wrap = 1
					RuleCall case XIfExpressionAccess.thenXExpressionParserRuleCall_5_0: { if(!((node.semanticElement as XIfExpression).^then instanceof XBlockExpression)) { state.wrap = 1 state.indentation = state.indentation - 1 } } 
					RuleCall case XIfExpressionAccess.elseXExpressionParserRuleCall_6_1_0: { if(!((node.semanticElement as XIfExpression).^else instanceof XBlockExpression)) { state.wrap = 1 state.indentation = state.indentation - 1 } } 
					RuleCall: switch rule:ge.rule {
						case importRule: state.wrap = 1 
						case classRule: state.wrap = 2
					}
					Action case XAnnotationAccess.XAnnotationAction_0: if(node.semanticElement.eContainer instanceof XtendClass) state.wrap = 1 
				}
			}
		}
		
	}
}


class FormatterState {
	@Property val List<ILeafNode> lastHiddens = newArrayList()
	@Property ILeafNode last = null
	@Property int wrap
	@Property int indentation = 0
	@Property String space = ""
	
}

@Data class FormatterCfg {
	String lineSeparator
	String indentation
	
	def getIndentation(int levels) {
		if(levels > 0) 
			(0..levels - 1).map[_indentation].join 
		else 
			""
	}
	
	def getWrap(int levels) {
		if(levels > 0) 
			(0..levels - 1).map[_lineSeparator].join 
		else 
			""
	}
}