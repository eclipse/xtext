/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.SpacingBuilder
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings
import org.eclipse.emf.ecore.EObject

import static extension com.intellij.psi.formatter.FormatterUtil.*
import static extension com.intellij.psi.impl.source.tree.TreeUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class DefaultBlockFactory implements BlockFactory {

	static val char LINE_FEED = '\n'

	@Inject
	Injector injector

	@Inject
	extension BlockExtension

	override createRootBlock(PsiElement element, CodeStyleSettings settings) {
		val block = new DefaultXtextBlock(element.node, null, null)
		injector.injectMembers(block)
		block.spacingBuilder = createSpacingBuilder(settings, element.language)
		block
	}

	protected def SpacingBuilder createSpacingBuilder(CodeStyleSettings settings, Language language) {
		null
	}

	override DefaultXtextBlock createBlock(ASTNode node, Block parentBlock) {
		if (node.whitespaceOrEmpty)
			return null

		val blockTextRange = node.createTextRange
		if (blockTextRange == null || blockTextRange.empty || !parentBlock.textRange.contains(blockTextRange))
			return null

		val spacingBuilder = if(parentBlock instanceof ModifiableBlock) parentBlock.spacingBuilder

		val block = new DefaultXtextBlock(node, null, null)
		injector.injectMembers(block)
		block.textRange = blockTextRange
		block.spacingBuilder = spacingBuilder
		block.parentBlock = parentBlock
		block.indent = parentBlock.getChildIndent(block)
		block
	}

	protected def getChildIndent(Block parentBlock, DefaultXtextBlock childBlock) {
		if (childBlock.opening || childBlock.closing)
			return Indent.noneIndent

		val grammarElement = parentBlock.grammarElement

		if (grammarElement.continuation)
			return Indent.continuationWithoutFirstIndent

		if (grammarElement.structural)
			if (childBlock.structural)
				return Indent.noneIndent
			else
				return Indent.normalIndent

		return Indent.noneIndent
	}

	protected def isContinuation(EObject grammarElement) {
		return false
	}

	protected def isStructural(EObject grammarElement) {
		return false
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

	protected def ASTNode findNode(ASTNode node, (ASTNode)=>ASTNode provider, (ASTNode)=>boolean condition) {
		if (node == null)
			return null

		if (condition.apply(node))
			return node

		return provider.apply(node).findNode(provider, condition)
	}

}