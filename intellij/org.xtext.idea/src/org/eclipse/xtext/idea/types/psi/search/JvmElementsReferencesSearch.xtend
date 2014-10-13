package org.eclipse.xtext.idea.types.psi.search

import com.google.inject.Inject
import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.search.searches.ReferencesSearch.SearchParameters
import com.intellij.util.Processor
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.PsiNamedEObject
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

class JvmElementsReferencesSearch extends QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters> {

	@Inject
	extension IPsiModelAssociations

	@Inject
	extension IJvmModelAssociations

	val IXtextLanguage language

	new(IXtextLanguage language) {
		this.language = language
		this.language.injectMembers(this)
	}

	override processQuery(SearchParameters queryParameters, Processor<PsiReference> consumer) {
		val element = queryParameters.elementToSearch
		if (element.language != language) {
			return
		}
		try {
			if (element instanceof PsiNamedEObject<?>) {
				for (psiJvmElement : element.EObject.jvmElements.map[psiElement].filter(PsiNamedElement)) {
					queryParameters.optimizer.searchWord(psiJvmElement.name, queryParameters.effectiveSearchScope, true, psiJvmElement)
				}
			}
		} catch (OperationCanceledError e) {
			throw e.wrapped
		}
	}

}
