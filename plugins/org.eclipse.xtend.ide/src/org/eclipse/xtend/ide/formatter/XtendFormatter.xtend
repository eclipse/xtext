/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatter

import com.google.inject.Inject
import java.util.List
import org.eclipse.jface.text.IRegion
import org.eclipse.text.edits.MultiTextEdit
import org.eclipse.text.edits.TextEdit
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.xtext.RuleCall

/**
 * @author Moitz Eysholdt - Initial contribution and API
 */
public class XtendFormatter {

	@Inject extension XtendGrammarAccess;
	@Inject IWhitespaceInformationProvider whitespaeInfo

	def TextEdit format(ICompositeNode root, IRegion region) {
		val uri = root.semanticElement.eResource.URI
		val edit = new MultiTextEdit()
		val lineSeparator = whitespaeInfo.getLineSeparatorInformation(uri).lineSeparator
		val indentation = whitespaeInfo.getIndentationInformation(uri).indentString
		format(edit, root, new FormatterState(), new FormatterCfg(lineSeparator, indentation))
		edit	
	}
	
	def void format(MultiTextEdit edit, INode node, FormatterState state, FormatterCfg cfg) {
		switch node {
			ILeafNode case node.hidden: {
				state.lastHiddens += node
			}
			ILeafNode case !node.hidden: {
				
				// match before LeafNode
				switch(node.grammarElement) {
					case classAccess.rightCurlyBracketKeyword_10: { state.wrap = true state.indentation = state.indentation - 1 } 
					case XBlockExpressionAccess.rightCurlyBracketKeyword_3: { state.wrap = true state.indentation = state.indentation - 1 } 
					case XBlockExpressionAccess.semicolonKeyword_2_1: { state.wrap = false state.space = "" } 
					case node.text == ".": { state.wrap = false state.space = "" } 
				}
				
				// apply formatting
				val oldText = state.lastHiddens.map[text].join
				val oldOffset = if(state.lastHiddens.empty) node.offset else state.lastHiddens.head.offset
				val oldLength = if(state.lastHiddens.empty) 0 else oldText.length
				val newText   = if(state.wrap) cfg.lineSeparator + cfg.getIndentation(state.indentation) else state.space 
				val textEdit = new ReplaceEdit(oldOffset, oldLength, newText)
//				println('''replacing "«oldText.replace("\n", "\\n")»" with "«newText.replace("\n", "\\n")»"''')
				edit.addChild(textEdit)
				state.lastHiddens.clear()
				state.wrap = false
				state.space = " "
				
				// match after LeafNode
				switch(node.grammarElement) {
					case classAccess.leftCurlyBracketKeyword_8: { state.wrap = true state.indentation = state.indentation + 1 }
					case XBlockExpressionAccess.leftCurlyBracketKeyword_1: { state.wrap = true state.indentation = state.indentation + 1 }
					case node.text == ".": { state.wrap = false state.space = "" }
				}
			}
			ICompositeNode: {
				// match before CompositeNode
				switch ge:node.grammarElement {
					RuleCall: switch rule:ge.rule {
						case importRule: state.wrap = true 
						case memberRule: state.wrap = true 
						case classRule: state.wrap = true 
					} 
				}

				// format children				
				for(INode child:node.children)
					format(edit, child, state, cfg)
					
				// match after CompositeNode
				switch ge:node.grammarElement {
					case XBlockExpressionAccess.expressionsXExpressionInsideBlockParserRuleCall_2_0_0: state.wrap = true 
					RuleCall: switch rule:ge.rule {
						case importRule: state.wrap = true 
						case memberRule: state.wrap = true 
						case classRule: state.wrap = true 
					} 
				}
			}
		}
		
	}
}


class FormatterState {
	@Property val List<ILeafNode> lastHiddens = newArrayList()
	@Property boolean wrap
	@Property int indentation = 0
	@Property String space = ""
	
}

@Data class FormatterCfg {
	String lineSeparator
	String indentation
	
	def getIndentation(int levels) {
		if(levels > 0) 
			(0..levels).map[_indentation].join 
		else 
			""
	}
}