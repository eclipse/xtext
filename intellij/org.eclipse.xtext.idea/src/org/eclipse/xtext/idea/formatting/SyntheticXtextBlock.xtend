/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.intellij.formatting.Block
import com.intellij.formatting.ChildAttributes
import com.intellij.formatting.Indent
import com.intellij.formatting.SpacingBuilder
import com.intellij.openapi.util.TextRange
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author kosyakov - Initial contribution and API
 */
class SyntheticXtextBlock implements ModifiableBlock {

	@Accessors Indent indent = Indent.noneIndent
	@Accessors SpacingBuilder spacingBuilder

	@Accessors val List<Block> children = newArrayList
	
	@Accessors var (List<Block>, int)=>ChildAttributes childAttributesProvider

	override isLeaf() {
		false
	}

	override getAlignment() {
		null
	}

	override getChildAttributes(int newChildIndex) {
		if (childAttributesProvider == null)
			return new ChildAttributes(Indent.noneIndent, null)
			
		return childAttributesProvider.apply(subBlocks, newChildIndex)
	}

	override getSpacing(Block child1, Block child2) {
		spacingBuilder.getSpacing(this, child1, child2)
	}

	override getSubBlocks() {
		children
	}

	override getWrap() {
		null
	}

	override isIncomplete() {
		children.last.incomplete
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