/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.search

import com.google.inject.Inject
import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.search.searches.ReferencesSearch.SearchParameters
import com.intellij.util.Processor
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations

class JvmElementsReferencesSearch extends QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters> {

	@Inject
	extension IPsiJvmModelAssociations

	val IXtextLanguage language

	new(IXtextLanguage language) {
		super(true)
		this.language = language
		this.language.injectMembers(this)
	}

	override processQuery(SearchParameters queryParameters, Processor<PsiReference> consumer) {
		val element = queryParameters.elementToSearch
		if (element.language != language) {
			return
		}
		try {
			for (psiJvmElement : element.jvmElements.filter(PsiNamedElement)) {
				queryParameters.optimizer.searchWord(psiJvmElement.name, queryParameters.effectiveSearchScope, true, psiJvmElement)
			}
		} catch (OperationCanceledError e) {
			throw e.wrapped
		}
	}

}
