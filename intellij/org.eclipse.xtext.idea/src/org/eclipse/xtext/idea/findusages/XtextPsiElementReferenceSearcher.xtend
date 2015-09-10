/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.psi.PsiReference
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.search.searches.ReferencesSearch.SearchParameters
import com.intellij.util.Processor
import org.eclipse.xtext.psi.XtextPsiElement

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextPsiElementReferenceSearcher extends QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters> {

	new() {
		super(true)
	}

	override processQuery(SearchParameters queryParameters, Processor<PsiReference> consumer) {
		val element = queryParameters.elementToSearch
		if (element instanceof XtextPsiElement) {
			val referenceSearcher = element.xtextLanguage.getInstance(IReferenceSearcher)
			referenceSearcher.processQuery(queryParameters, consumer)
		}
	}

}