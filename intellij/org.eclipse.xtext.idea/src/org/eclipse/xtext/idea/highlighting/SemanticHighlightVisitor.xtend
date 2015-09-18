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
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import org.eclipse.xtext.Constants
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.psi.XtextPsiUtils

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
abstract class SemanticHighlightVisitor implements HighlightVisitor {
	
	@Inject @Named(Constants.LANGUAGE_NAME) String languageId
 
 	@Inject ISemanticHighlightingCalculator highlightCalculator
 	
 	@Inject extension IdeaHighlightingAttributesProvider 
 	
 	@Inject OperationCanceledManager operationCanceledManager
 	
	IHighlightedPositionAcceptor acceptor
 	
	override analyze(PsiFile file, boolean updateWholeFile, HighlightInfoHolder holder, Runnable action) {
		val virtualFile = XtextPsiUtils.findVirtualFile(file);
		if(!FileEditorManager.getInstance(file.project).isFileOpen(virtualFile)) 
			return true
		acceptor = [
			offset, length, styles |
			styles.forEach [
				if(length > 0) {
					val info = HighlightInfo
						.newHighlightInfo(highlightInfoType)
						.range(offset, offset + length)
						.description(it)
						.create
					holder.add(info)			
				}
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
	
	volatile long lastRun
	
	override visit(PsiElement element) {
 		try {
			if (element instanceof BaseXtextFile)  {
				val resource = element.resource
					lastRun = resource.modificationStamp
					highlightCalculator.provideHighlightingFor(resource, acceptor, CancelIndicator.NullImpl)			
				
			}
		} catch (OperationCanceledError error) {
			operationCanceledManager.propagateIfCancelException(error)
		}
	}
	
	override clone() {
		getClass.newInstance => [
			it.acceptor = this.acceptor
		]
	}
	
}