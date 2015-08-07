/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.documentation

import com.google.inject.Inject
import com.intellij.codeInsight.documentation.DocumentationManager
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiIdentifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class IdeaDocumentationProvider extends AbstractDocumentationProvider {

	@Inject IResourceServiceProvider.Registry resourceServiceProviderRegistry
	@Inject ITraceForVirtualFileProvider traceProvider

	override getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
		val gen = findDocumentationInGeneratedCode(element, originalElement)
		if (gen != null) {
			val result = gen.delegate.getQuickNavigateInfo(gen.generatedElement, gen.generatedOriginalElement)
			if (result != null)
				return result
		}
		if (element instanceof PsiEObject) {
			val eobj = element.EObject
			val result = eobj.calleeDocumentationProvider?.getQuickNavigateInfo(element)
			if (result != null)
				return result
			return EcoreUtil.getURI(eobj).toString
		}
		return null
	}

	override generateDoc(PsiElement element, PsiElement originalElement) {
		val gen = findDocumentationInGeneratedCode(element, originalElement)
		if (gen != null) {
			val result = gen.delegate.generateDoc(gen.generatedElement, gen.generatedOriginalElement)
			if (result != null)
				return result
		}
		if (element instanceof PsiEObject) {
			val eobj = element.EObject
			val result = eobj.calleeDocumentationProvider?.generateDoc(element)
			if (result != null)
				return result
			return EcoreUtil.getURI(eobj).toString
		}
		return null
	}

	def protected IdeaDeclarationDocumentationProvider getCalleeDocumentationProvider(EObject object) {
		if (object == null || object.eIsProxy)
			return null
		val uri = object.eResource.URI
		val resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(uri)
		if (resourceServiceProvider == null)
			return null
		return resourceServiceProvider?.get(IdeaDeclarationDocumentationProvider)
	}

	def protected GeneratedCodeDelegate findDocumentationInGeneratedCode(PsiElement element,
		PsiElement originalElement) {
		val generatedElement = element.generatedElement
		if (generatedElement == null)
			return null
		val generatedOriginalElement = originalElement.generatedElement ?: originalElement
		val delegate = DocumentationManager.getProviderFromElement(generatedElement, generatedOriginalElement)
		if (delegate == null)
			return null
		return new GeneratedCodeDelegate(generatedElement, generatedOriginalElement, delegate)
	}

	@Accessors static class GeneratedCodeDelegate {
		val PsiElement generatedElement
		val PsiElement generatedOriginalElement
		val DocumentationProvider delegate
	}

	def private PsiElement getGeneratedElement(PsiElement element) {
		val elements = traceProvider.getGeneratedElements(element)
		val result = elements.head
		if (result instanceof PsiIdentifier)
			return result.parent
		return result
	}
}

