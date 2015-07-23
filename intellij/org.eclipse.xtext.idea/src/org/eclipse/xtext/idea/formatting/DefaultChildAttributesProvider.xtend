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
import com.intellij.formatting.Block
import com.intellij.formatting.ChildAttributes
import com.intellij.formatting.Indent
import org.eclipse.emf.ecore.EObject

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class DefaultChildAttributesProvider implements ChildAttributesProvider {

	@Inject
	extension BlockExtension

	override getChildAttributes(Block block, int newChildIndex) {
		val indent = block.getChildIndent(newChildIndex) ?: Indent.noneIndent
		return new ChildAttributes(indent, null)
	}

	protected def Indent getChildIndent(Block block, int newChildIndex) {
		val children = block.subBlocks
		if (children.empty)
			return null

		if (newChildIndex >= children.size)
			return block.getAfterChildIndent(children.size)

		val indent = block.getBeforeChildIndent(newChildIndex)
		if (indent == null)
			return block.getAfterChildIndent(newChildIndex)

		return indent
	}

	protected def Indent getBeforeChildIndent(Block block, int newChildIndex) {
		val children = block.subBlocks
		if (children.empty)
			return null

		if (newChildIndex >= children.size)
			return null

		val child = children.get(newChildIndex)

		if (child.leaf)
			return child.beforeChildIndent

		return child.getChildIndent(0)
	}

	protected def Indent getAfterChildIndent(Block block, int newChildIndex) {
		if (newChildIndex == 0)
			return null

		val children = block.subBlocks
		if (children.empty)
			return null

		val childBefore = children.get(newChildIndex - 1)
		if (childBefore.leaf)
			return childBefore.afterChildIndent

		val size = childBefore.subBlocks.size
		return childBefore.getChildIndent(size)
	}

	protected def Indent getAfterChildIndent(Block block) {
		if (block == null)
			return null
		
		val grammarElementIndent = block.grammarElement.afterIndent
		if (grammarElementIndent != null)
			return grammarElementIndent

		if (block instanceof SyntheticXtextBlock)
			return block.indent

		if (block.opening)
			return block.bracePairForOpeningBrace.getIndent(false)

		return null
	}

	protected def Indent getAfterIndent(EObject grammarElement) {
		return null
	}

	protected def Indent getBeforeChildIndent(Block block) {
		if (block == null)
			return null

		val grammarElementIndent = block.grammarElement.beforeIndent
		if (grammarElementIndent != null)
			return grammarElementIndent

		if (block instanceof SyntheticXtextBlock)
			return block.indent

		if (block.closing)
			return block.bracePairForClosingBrace.getIndent(false)

		return null
	}

	protected def Indent getBeforeIndent(EObject grammarElement) {
		return null
	}

}