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
import com.intellij.formatting.Alignment
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock
import java.util.LinkedList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultXtextBlock extends AbstractBlock implements ModifiableBlock {

	@Accessors Block parentBlock
	@Accessors Boolean incomplete
	@Accessors TextRange textRange
	@Accessors Indent indent = Indent.noneIndent
	@Accessors SpacingBuilder spacingBuilder

	@Inject
	Injector injector

	@Inject
	extension BlockFactory

	@Inject
	extension BlockExtension

	@Inject
	ChildAttributesProvider childAttributesProvider

	new(ASTNode node, Wrap wrap, Alignment alignment) {
		super(node, wrap, alignment)
	}

	override isIncomplete() {
		if (incomplete != null)
			return incomplete

		return super.isIncomplete()
	}

	override getTextRange() {
		if (textRange != null)
			return textRange
		return super.textRange
	}

	override protected buildChildren() {
		myNode.getChildren(null).map[createBlock(this)].filterNull.group
	}

	protected def List<Block> group(Iterable<Block> blocks) {
		val openingBlockIndex = LinkedListMultimap.create
		val stack = <Block>newLinkedList
		for (block : blocks) {
			if (block.opening) {
				val bracePair = block.bracePairForOpeningBrace
				openingBlockIndex.put(bracePair, stack.size)
			}
			if (block.closing) {
				val bracePair = block.bracePairForClosingBrace
				val index = openingBlockIndex.get(bracePair).last
				if (index != null) {
					openingBlockIndex.remove(bracePair, index)

					group(stack, index, bracePair, block)
				}
			}
			stack.addLast(block)
		}
		for (entry : openingBlockIndex.entries.sortWith[$0.value.compareTo($1.value)].reverse) {
			group(stack, entry.value, entry.key, null)
		}
		stack
	}

	protected def void group(
		LinkedList<Block> stack,
		Integer openingBlockIndex,
		BracePair bracePair,
		Block closingBlock
	) {
		val children = stack.collectChildren(openingBlockIndex)
		if (children.empty)
			return

		val groupBlock = children.createGroup
		groupBlock.incomplete = closingBlock == null || closingBlock.elementType == TokenType.ERROR_ELEMENT

		val enforceIndentToChildren = children.shouldEnforceIndentToChildren
		groupBlock.indent = bracePair.getIndent(enforceIndentToChildren)

		groupBlock.parentBlock = children.filter(ModifiableBlock).head.parentBlock
		children.filter(ModifiableBlock).forEach[child|child.parentBlock = groupBlock]

		stack.addLast(groupBlock)
	}

	protected def List<Block> collectChildren(LinkedList<Block> stack, Integer openingBlockIndex) {
		val children = <Block>newLinkedList
		for (var i = stack.size - 1; i > openingBlockIndex; i--) {
			val childBlock = stack.removeLast
			children.addFirst(childBlock)
		}
		children
	}

	protected def boolean shouldEnforceIndentToChildren(List<Block> children) {
		if (children.size > 3)
			return true

		val bracePair = children.head.bracePairForOpeningBrace
		if (bracePair == null || !bracePair.structural)
			return true

		return children.last.bracePairForClosingBrace != bracePair
	}

	protected def createGroup(Iterable<Block> children) {
		val groupBlock = new SyntheticXtextBlock
		injector.injectMembers(groupBlock)
		groupBlock.spacingBuilder = spacingBuilder
		groupBlock.children += children
		groupBlock
	}

	override getChildAttributes(int newChildIndex) {
		childAttributesProvider.getChildAttributes(this, newChildIndex)
	}

	override isLeaf() {
		myNode.firstChildNode == null
	}

	override getSpacing(Block child1, Block child2) {
		spacingBuilder?.getSpacing(this, child1, child2)
	}

}
