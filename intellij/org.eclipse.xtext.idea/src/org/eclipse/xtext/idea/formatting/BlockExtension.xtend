/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.formatting.ASTBlock
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class BlockExtension {

	@Inject
	IBracePairProvider bracePairProvider

	def getParentBlock(Block block) {
		if(block instanceof ModifiableBlock) block.parentBlock
	}

	def getNode(Block block) {
		if(block instanceof ASTBlock) block.node
	}

	def getElementType(Block block) {
		block.node?.elementType
	}

	def getGrammarElement(Block block) {
		val elementType = block.elementType
		if (elementType instanceof IGrammarAwareElementType)
			elementType.grammarElement
	}

	def isOpening(Block block) {
		if(block instanceof ASTBlock) block.node.opening
	}

	def isClosing(Block block) {
		if(block instanceof ASTBlock) block.node.closing
	}

	def isOpening(ASTNode node) {
		if (node == null)
			return false

		val text = node.text
		bracePairs.exists[text == leftBrace]
	}

	def isClosing(ASTNode node) {
		if (node == null)
			return false

		val text = node.text
		bracePairs.exists[text == rightBrace]
	}

	def getBracePairForOpeningBrace(Block block) {
		block.node.bracePairForOpeningNode
	}

	def getBracePairForOpeningNode(ASTNode node) {
		if (node == null)
			return null

		val openingBrace = node.text
		bracePairs.findFirst[leftBrace == openingBrace]
	}

	def getBracePairForClosingBrace(Block block) {
		block.node.bracePairForClosingNode
	}

	def getBracePairForClosingNode(ASTNode node) {
		if (node == null)
			return null

		val openingBrace = node.text
		bracePairs.findFirst[rightBrace == openingBrace]
	}

	def isStructural(Block block) {
		val node = block.node
		val offset = block.textRange.startOffset - node.startOffset
		val leafElement = node.findLeafElementAt(offset)
		val bracePair = leafElement.bracePairForOpeningNode
		bracePair != null && bracePair.structural
	}

	def getBracePairs() {
		bracePairProvider.pairs
	}

	public static val STRUCTURAL_INDENT = Indent.getIndent(Indent.Type.NORMAL, false, true)

	def getIndent(BracePair bracePair, boolean enforceIndentToChildren) {
		if (bracePair == null)
			return Indent.noneIndent

		if (bracePair.structural)
			if (enforceIndentToChildren)
				return STRUCTURAL_INDENT
			else
				return Indent.normalIndent

		return Indent.continuationIndent
	}

}