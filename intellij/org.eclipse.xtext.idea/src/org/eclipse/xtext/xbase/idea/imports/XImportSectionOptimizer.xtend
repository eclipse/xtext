/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.imports

import com.google.inject.Inject
import com.google.inject.name.Named
import com.intellij.lang.ImportOptimizer
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import org.eclipse.xtext.Constants
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.xbase.imports.ImportOrganizer
import com.intellij.openapi.util.EmptyRunnable

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XImportSectionOptimizer implements ImportOptimizer {
	
	@Inject @Named(Constants.LANGUAGE_NAME) String languageId
	@Inject ImportOrganizer importOrganizer
	
	override processFile(PsiFile file) {
		if (file instanceof BaseXtextFile) {
			val changes = importOrganizer.getOrganizedImportChanges(file.resource).sortBy[offset * -1]
			return [
				val document = PsiDocumentManager.getInstance(file.project).getDocument(file)
				for (change : changes) {
					document.replaceString(change.offset, change.endOffset, change.text)
				}
			]
		} else {
			return EmptyRunnable.INSTANCE
		}
	}
	
	override supports(PsiFile file) {
		return languageId == file.language.ID
	}
	
}