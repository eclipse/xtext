/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.searches.ReferencesSearch.SearchParameters
import com.intellij.util.Processor
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class JvmElementAwareReferenceSearcher implements IReferenceSearcher {

	@Inject extension IJvmModelAssociations

	override processQuery(SearchParameters queryParameters, Processor<PsiReference> consumer) {
		val element = queryParameters.elementToSearch
		val words = element.words
		if (words.empty)
			return;

		val caseSensitive = element.language.caseSensitive
		for (word : words)
			queryParameters.optimizer.searchWord(
				word,
				queryParameters.effectiveSearchScope,
				caseSensitive,
				element
			)
	}

	protected def getWords(PsiElement element) {
		if (element instanceof PsiEObject)
			return element.EObject.jvmElements.map[word].filter[!nullOrEmpty].toSet

		return emptySet
	}

	protected def getWord(EObject jvmElement) {
		if (jvmElement instanceof JvmIdentifiableElement)
			jvmElement.simpleName
	}

}