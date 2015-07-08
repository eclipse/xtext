/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.highlighting

import com.google.inject.Inject
import com.google.inject.name.Named
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightInfoType.HighlightInfoTypeImpl
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import org.eclipse.xtext.Constants
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.psi.impl.BaseXtextFile
import com.google.inject.Provider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class SemanticHighlightVisitor implements HighlightVisitor {
	
	@Inject @Named(Constants.LANGUAGE_NAME) String languageId
 
 	@Inject ISemanticHighlightingCalculator highlightCalculator
 	
 	@Inject extension IHighlightingConfiguration 
 	
	@Inject Provider<SemanticHighlightVisitor> cloneProvider

	IHighlightedPositionAcceptor acceptor
 	
	override analyze(PsiFile file, boolean updateWholeFile, HighlightInfoHolder holder, Runnable action) {
		acceptor = [
			offset, length, styles |
			styles.forEach [
				val info = HighlightInfo
					.newHighlightInfo(highlightInfoType)
					.range(offset, offset + length)
					.create
				holder.add(info)			
			]
		]
	    try {
	      action.run
	    }
	    finally {
	      acceptor = null
	    }
		return true
	}
	
	override order() {
		0
	}
	
	override suitableForFile(PsiFile file) {
		return file instanceof BaseXtextFile && languageId == file.language.ID
	}
	
	override visit(PsiElement element) {
		if (element instanceof BaseXtextFile) 
			highlightCalculator.provideHighlightingFor(element.resource, acceptor)
	}
	
	def HighlightInfoType getHighlightInfoType(String xtextStyle) {
		new HighlightInfoTypeImpl(HighlightSeverity.INFORMATION, xtextStyle.textAttributesKey)
	}
	
	override clone() {
		cloneProvider.get => [
			it.acceptor = this.acceptor
		]
	}
}