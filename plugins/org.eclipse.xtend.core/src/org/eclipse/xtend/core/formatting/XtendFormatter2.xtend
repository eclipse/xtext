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
import org.eclipse.xtend.lib.Data
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode

/**
 * @author Moitz Eysholdt - Initial contribution and API
 */
public class XtendFormatter2 {

	@Inject extension XtendGrammarAccess;
	@Inject IWhitespaceInformationProvider whitespaeInfo

	def void format(ICompositeNode root, int offset, int length, (int, int, String)=>void textEditAcceptor) {
		val uri = root.semanticElement.eResource.URI
		val lineSeparator = whitespaeInfo.getLineSeparatorInformation(uri).lineSeparator
		val indentation = whitespaeInfo.getIndentationInformation(uri).indentString
		format(root, new FormatterState(), new FormatterCfg(lineSeparator, indentation), textEditAcceptor)
	}
	
	def void format(INode node, FormatterState state, FormatterCfg cfg, (int, int, String)=>void textEditAcceptor) {
		switch node {
			ILeafNode case node.hidden: {
				state.lastHiddens += node
			}
			ILeafNode case !node.hidden: {
				
				// match before LeafNode
				switch(node.grammarElement) {
					case classAccess.rightCurlyBracketKeyword_10: { state.wrap = 1 state.indentation = state.indentation - 1 } 
					case XBlockExpressionAccess.rightCurlyBracketKeyword_3: { state.wrap = 1 state.indentation = state.indentation - 1 } 
					case XBlockExpressionAccess.semicolonKeyword_2_1: { state.wrap = 1 state.space = "" } 
					case node.text == ".": { state.wrap = 2 state.space = "" } 
				}
				
				// apply formatting
				val oldText = state.lastHiddens.map[text].join
				val oldOffset = if(state.lastHiddens.empty) node.offset else state.lastHiddens.head.offset
				val oldLength = if(state.lastHiddens.empty) 0 else oldText.length
				val newText   = if(state.wrap >0 ) cfg.getWrap(state.wrap) + cfg.getIndentation(state.indentation) else state.space 
				textEditAcceptor.apply(oldOffset, oldLength, newText)
//				println('''replacing "«oldText.replace("\n", "\\n")»" with "«newText.replace("\n", "\\n")»"''')
				state.lastHiddens.clear()
				state.wrap = 0
				state.space = " "
				
				// match after LeafNode
				switch(node.grammarElement) {
					case classAccess.leftCurlyBracketKeyword_8: { state.wrap = 1 state.indentation = state.indentation + 1 }
					case XBlockExpressionAccess.leftCurlyBracketKeyword_1: { state.wrap = 1 state.indentation = state.indentation + 1 }
					case node.text == ".": { state.wrap = 1 state.space = "" }
				}
			}
			ICompositeNode: {
				// match before CompositeNode
				switch ge:node.grammarElement {
					RuleCall: switch rule:ge.rule {
						case importRule: state.wrap = 2 
						case memberRule: state.wrap = 2 
						case classRule: state.wrap = 2
					} 
				}

				// format children				
				for(INode child:node.children)
					format(child, state, cfg, textEditAcceptor)
					
				// match after CompositeNode
				switch ge:node.grammarElement {
					case XBlockExpressionAccess.expressionsXExpressionInsideBlockParserRuleCall_2_0_0: state.wrap = 1 
					RuleCall: switch rule:ge.rule {
						case importRule: state.wrap = 2 
						case memberRule: state.wrap = 2 
						case classRule: state.wrap = 2
					} 
				}
			}
		}
		
	}
}


class FormatterState {
	@Property val List<ILeafNode> lastHiddens = newArrayList()
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