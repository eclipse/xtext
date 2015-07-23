/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.inject.Inject
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.SpacingBuilder
import com.intellij.openapi.util.TextRange
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author kosyakov - Initial contribution and API
 */
class SyntheticXtextBlock implements ModifiableBlock {

	@Accessors Block parentBlock
	@Accessors Boolean incomplete = false
	@Accessors Indent indent = Indent.noneIndent
	@Accessors SpacingBuilder spacingBuilder

	@Accessors val List<Block> children = newArrayList

	@Inject
	ChildAttributesProvider childAttributesProvider

	override isIncomplete() {
		incomplete
	}

	override isLeaf() {
		false
	}

	override getAlignment() {
		null
	}

	override getChildAttributes(int newChildIndex) {
		childAttributesProvider.getChildAttributes(this, newChildIndex)
	}

	override getSpacing(Block child1, Block child2) {
		spacingBuilder?.getSpacing(this, child1, child2)
	}

	override getSubBlocks() {
		children
	}

	override getWrap() {
		null
	}

	override getTextRange() {
		val startOffset = children.head.textRange.startOffset
		val endOffset = children.last.textRange.endOffset
		new TextRange(startOffset, endOffset)
	}

	override toString() {
		children.toString + ' ' + textRange.toString
	}

}