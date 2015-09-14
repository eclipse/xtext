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
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping

import static extension org.eclipse.xtext.xbase.util.PropertyUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class JvmElementAwareReferenceSearcher implements IReferenceSearcher {

	@Inject extension OperatorMapping

	@Inject extension IJvmModelAssociations

	override processQuery(SearchParameters queryParameters, Processor<PsiReference> consumer) {
		val element = queryParameters.elementToSearch
		val words = element.collectWords
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

	protected def Set<String> collectWords(PsiElement element) {
		val words = newHashSet
		val acceptor = [String word|words.accept(word)]
		if (element instanceof PsiEObject)
			for (jvmElement : element.EObject.jvmElements)
				jvmElement.collectWords(acceptor)
		words
	}

	protected def void accept(Set<String> words, String word) {
		if (word != null)
			words += word
	}

	protected def dispatch void collectWords(EObject jvmElement, (String)=>void acceptor) {
		// do nothing	
	}

	protected def dispatch void collectWords(Void jvmElement, (String)=>void acceptor) {
		// do nothing
	}

	protected def dispatch void collectWords(JvmIdentifiableElement jvmElement, (String)=>void acceptor) {
		acceptor.apply(jvmElement.simpleName)
	}

	protected def dispatch void collectWords(JvmFeature jvmElement, (String)=>void acceptor) {
		acceptor.apply(jvmElement.simpleName)
		
		val simpleOperator = QualifiedName.create(jvmElement.simpleName).operator
		if (simpleOperator != null) {
			acceptor.apply(simpleOperator.toString)
			val compoundOperator = simpleOperator.compoundOperator
			if (compoundOperator != null)
				acceptor.apply(compoundOperator.toString)
		} else
			acceptor.apply(jvmElement.propertyName)
	}

}