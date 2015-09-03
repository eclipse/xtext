/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.google.inject.Inject
import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileSystemItem
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.SyntheticFileSystemItem
import com.intellij.psi.meta.PsiMetaOwner
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.search.searches.ReferencesSearch.SearchParameters
import com.intellij.util.Processor
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider

import static extension com.intellij.psi.util.PsiTreeUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class GeneratedSourceAwareReferencesSearcher extends QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters> {

	@Inject extension ITraceForVirtualFileProvider

	new() {
		super(true)
		IdeaSharedInjectorProvider.injectMembers(this)
	}

	override processQuery(SearchParameters queryParameters, Processor<PsiReference> consumer) {
		val element = queryParameters.elementToSearch
		val caseSensitive = element.caseSensitive
		for (word : element.generatedElements.map[word].filter[!nullOrEmpty])
			queryParameters.optimizer.searchWord(
				word,
				queryParameters.effectiveSearchScope,
				caseSensitive,
				element
			)
	}

	protected def isCaseSensitive(PsiElement element) {
		switch element {
			SyntheticFileSystemItem:
				element.language.caseSensitive
			PsiFileSystemItem:
				false
			default:
				element.language.caseSensitive
		}
	}

	protected def getWord(PsiElement element) {
		if (element instanceof PsiFileSystemItem) {
			if (element instanceof SyntheticFileSystemItem)
				return element.metaDataName

			return element.virtualFile?.nameWithoutExtension ?: element.metaDataName
		}
		val namedElement = element?.getParentOfType(PsiNamedElement, false)
		namedElement.metaDataName ?: namedElement?.name
	}

	protected def getMetaDataName(PsiElement element) {
		if (element instanceof PsiMetaOwner)
			element.metaData?.name
	}

}