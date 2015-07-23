/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.inject.Inject
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultFormattingModelBuilder implements FormattingModelBuilder {

	@Inject
	extension BlockFactory

	override createModel(PsiElement element, CodeStyleSettings settings) {
		val block = element.createRootBlock(settings)
		FormattingModelProvider.createFormattingModelForPsiFile(element.containingFile, block, settings)
	}

	override getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
		null
	}

}
