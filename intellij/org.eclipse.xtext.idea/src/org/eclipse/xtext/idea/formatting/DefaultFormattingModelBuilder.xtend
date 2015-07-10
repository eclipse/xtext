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
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.formatting.SpacingBuilder
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.idea.lang.IElementTypeProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultFormattingModelBuilder implements FormattingModelBuilder {

	@Inject
	Injector injector

	@Inject
	extension IGrammarAccess

	@Inject
	extension IElementTypeProvider elementTypeProvider

	override createModel(PsiElement element, CodeStyleSettings settings) {
		val rootBlock = new DefaultXtextBlock(element.node, null, null)
		injector.injectMembers(rootBlock)
		rootBlock.spacingBuilder = createSpacingBuilder(settings, element.language)
		FormattingModelProvider.createFormattingModelForPsiFile(element.containingFile, rootBlock, settings)
	}

	def createSpacingBuilder(CodeStyleSettings settings, Language language) {
		val spacingBuilder = new SpacingBuilder(settings, language)
		for (pair : findKeywordPairs('{', '}').map [
			first.findElementType -> second.findElementType
		]) {
			spacingBuilder.before(pair.key).spaces(1)
			spacingBuilder.withinPair(pair.key, pair.value).lineBreakInCode
		}
		for (commaType : #[','].findKeywords.map[findElementType]) {
			spacingBuilder.before(commaType).spaces(0)
			spacingBuilder.after(commaType).spaces(1)
		}
		for (pair : findKeywordPairs('(', ')').map [
			first.findElementType -> second.findElementType
		]) {
			spacingBuilder.withinPair(pair.key, pair.value).none
			spacingBuilder.around(pair.key).spaces(0)
			spacingBuilder.before(pair.value).spaces(0)
			spacingBuilder.after(pair.value).spaces(1)
		}
		spacingBuilder
	}

	override getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
		null
	}

}
