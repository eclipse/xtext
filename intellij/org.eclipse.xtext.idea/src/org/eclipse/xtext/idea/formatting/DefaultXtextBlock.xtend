/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.common.collect.LinkedListMultimap
import com.google.inject.Inject
import com.google.inject.Injector
import com.intellij.formatting.ASTBlock
import com.intellij.formatting.Alignment
import com.intellij.formatting.Block
import com.intellij.formatting.ChildAttributes
import com.intellij.formatting.Indent
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiComment
import com.intellij.psi.formatter.common.AbstractBlock
import java.util.LinkedList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider

import static extension com.intellij.psi.formatter.FormatterUtil.*
import static extension com.intellij.psi.impl.source.tree.TreeUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultXtextBlock extends AbstractBlock implements ModifiableBlock {

	static val char LINE_FEED = '\n'

	@Accessors TextRange textRange
	@Accessors Indent indent = Indent.noneIndent
	@Accessors SpacingBuilder spacingBuilder

	@Inject
	Injector injector

	@Inject
	IBracePairProvider bracePairProvider

	new(ASTNode node, Wrap wrap, Alignment alignment) {
		super(node, wrap, alignment)
	}

	override getTextRange() {
		if (textRange != null)
			return textRange
		return super.textRange
	}

	override protected buildChildren() {
		myNode.getChildren(null).filter[!whitespaceOrEmpty].map[buildSubBlock].filterNull.group
	}

	protected def List<Block> group(Iterable<Block> blocks) {
		val openingBlockIndex = LinkedListMultimap.create
		val stack = <Block>newLinkedList
		for (block : blocks) {
			if (block.opening) {
				val openingBrace = block.node.text
				val bracePair = bracePairProvider.pairs.findFirst[leftBrace == openingBrace]
				openingBlockIndex.put(bracePair, stack.size)
			}
			if (block.closing) {
				val closingBrace = block.node.text
				val bracePair = bracePairProvider.pairs.findFirst[rightBrace == closingBrace]
				val index = openingBlockIndex.get(bracePair).last
				if (index != null) {
					openingBlockIndex.remove(bracePair, index)

					group(stack, index)
				}
			}
			stack.addLast(block)
		}
		for (index : openingBlockIndex.values.sort.reverse) {
			group(stack, index)
		}
		stack
	}

	protected def void group(LinkedList<Block> stack, Integer openingBlockIndex) {
		val children = <Block>newLinkedList
		for (var i = stack.size - 1; i > openingBlockIndex; i--) {
			children.addFirst(stack.removeLast)
		}
					
		if(!children.empty)
			stack.addLast(children.createGroup(Indent.normalIndent))
	}

	protected def createGroup(Iterable<Block> children, Indent indent) {
		val groupBlock = new SyntheticXtextBlock()
		injector.injectMembers(this)
		groupBlock.spacingBuilder = spacingBuilder
		groupBlock.children += children
		groupBlock.indent = indent
		groupBlock
	}

	protected def Block buildSubBlock(ASTNode node) {
		val blockTextRange = node.createTextRange
		if (blockTextRange == null || blockTextRange.empty || !getTextRange.contains(blockTextRange))
			return null

		val block = new DefaultXtextBlock(node, null, null)
		injector.injectMembers(block)
		block.textRange = blockTextRange
		block.spacingBuilder = spacingBuilder
		block
	}

	protected def TextRange createTextRange(ASTNode node) {
		val textRange = node.textRange
		if (node instanceof PsiComment) {
			val chars = node.chars
			if (chars.charAt(chars.length - 1) == LINE_FEED) {
				return new TextRange(textRange.startOffset, textRange.endOffset - 1)
			}
			return textRange
		}
		if (node.firstChildNode == null)
			return textRange

		val firstNonHiddenLeafNode = node.findFirstLeaf.findNode([nextLeaf], [
			!whitespaceOrEmpty || !textRange.contains(it.textRange)
		])
		if (firstNonHiddenLeafNode == null || !textRange.contains(firstNonHiddenLeafNode.textRange))
			return null

		val startOffset = firstNonHiddenLeafNode.startOffset
		val endOffset = node.findLastLeaf.findNode([prevLeaf], [!whitespaceOrEmpty]).textRange.endOffset
		new TextRange(startOffset, endOffset)
	}

	override getChildAttributes(int newChildIndex) {
		val children = subBlocks
		if (children.empty)
			return new ChildAttributes(Indent.noneIndent, null)

		val indent = if (newChildIndex >= children.size) {
				val block = children.get(children.size - 1)
				if (block instanceof SyntheticXtextBlock || block.opening || block.between)
					Indent.normalIndent
			} else {
				val block = children.get(newChildIndex)
				if (block instanceof SyntheticXtextBlock || block.closing || block.between)
					Indent.normalIndent
			}

		return new ChildAttributes(indent ?: Indent.noneIndent, null)
	}

	protected def getNode(Block block) {
		if(block instanceof ASTBlock) block.node
	}

	protected def isOpening(Block block) {
		if(block instanceof ASTBlock) block.node.opening
	}

	protected def isClosing(Block block) {
		if(block instanceof ASTBlock) block.node.closing
	}

	protected def isBetween(Block block) {
		if(block instanceof ASTBlock) block.node.between
	}

	protected def isOpening(ASTNode node) {
		if (node == null)
			return false

		val text = node.text
		bracePairProvider.pairs.exists[text == leftBrace]
	}

	protected def isBetween(ASTNode node) {
		if (node == null || node.opening || node.closing)
			return false

		bracePairProvider.pairs.exists[bracePair|node.isBetween(bracePair)]
	}

	protected def isBetween(ASTNode node, BracePair bracePair) {
		val foundNode = node.treePrev.findNode([treePrev]) [
			text == bracePair.leftBrace || text == bracePair.rightBrace
		]
		foundNode != null && foundNode.text == bracePair.leftBrace
	}

	protected def isClosing(ASTNode node) {
		if (node == null)
			return false

		val text = node.text
		bracePairProvider.pairs.exists[text == rightBrace]
	}

	override isLeaf() {
		myNode.firstChildNode == null
	}

	protected def ASTNode findNode(ASTNode node, (ASTNode)=>ASTNode provider, (ASTNode)=>boolean condition) {
		if (node == null)
			return null

		if (condition.apply(node))
			return node

		return provider.apply(node).findNode(provider, condition)
	}

	override getSpacing(Block child1, Block child2) {
		spacingBuilder.getSpacing(this, child1, child2)
	}

}
