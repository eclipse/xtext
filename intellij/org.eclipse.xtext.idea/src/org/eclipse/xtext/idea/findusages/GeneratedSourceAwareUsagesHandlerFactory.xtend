/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import java.util.List

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO decorate all find usage requests and use a custom Processor<UsageInfo> in the FindUsagesHandler to redirect navigation requests
 */
class GeneratedSourceAwareUsagesHandlerFactory extends FindUsagesHandlerFactory {
	
	private static final Logger LOG = Logger.getInstance("#com.intellij.find.findParameterUsages.FindUsagesManager");
	
	override canFindUsages(PsiElement element) {
		return delegateFindFactory(element) !== null || 
			element.generatedElements.exists [
				delegateFindFactory !== null
			] || element.originalElements.exists [
				delegateFindFactory !== null
			]
	}
	
	protected def List<PsiElement> getOriginalElements(PsiElement element) {
		// TODO delegate to GenerateSource.. extension point
		if (element instanceof PsiMethod) {
			return element.containingClass.findMethodsByName(element.name + "gen", false)
		}
		return emptyList
	}
	
	protected def List<PsiElement> getGeneratedElements(PsiElement element) {
		// TODO delegate to GenerateSource.. extension point
		if (element instanceof PsiMethod) {
			if (element.name.endsWith("gen")) {
				return element.containingClass.findMethodsByName(element.name.substring(0, element.name.length - 3), false)
			}
		}
		return emptyList
	}
	
	protected def delegateFindFactory(PsiElement element) {
		var delegates = Extensions.getExtensions(FindUsagesHandlerFactory.EP_NAME, element.project);
		for(delegate: delegates) {
			if (delegate !== this) {
				try {
					if (delegate.canFindUsages(element)) {
						return delegate;
					}
				} catch (IndexNotReadyException e) {
					throw e;
				} catch (Exception e) {
					LOG.error(e);
				}
			}
		}
		return null
	}
	
	override createFindUsagesHandler(PsiElement element, boolean forHighlightUsages) {
		// highlighting is only done with the real element under the cursor or with its derived elements
		// not vice versa
		val primaryDelegate = delegateFindFactory(element).createFindUsagesHandler(element, forHighlightUsages)
		if (forHighlightUsages) {
			val generatedElements = getGeneratedElements(element)
			return if (generatedElements.isEmpty)
					primaryDelegate
				else new GeneratedSourceAwareFindUsagesHandler(primaryDelegate, true) => [
					addDelegates(generatedElements, forHighlightUsages)
				]
				
		}
		// check if this is a generated artifact - use the original element as the primary and search for the primary element and visualize the 
		// primary element but only search for references to this element
		val originalElements = element.originalElements
		if (originalElements.isEmpty) {
			val generatedElements = element.generatedElements
			return if (generatedElements.isEmpty)
					primaryDelegate	
				else
					new GeneratedSourceAwareFindUsagesHandler(primaryDelegate, true) => [
						addDelegates(generatedElements, forHighlightUsages)
					]
		} else {
			return new GeneratedSourceAwareFindUsagesHandler(primaryDelegate, true) => [
				addDelegates(originalElements, forHighlightUsages)
			]
		}
	}
	
	def addDelegates(GeneratedSourceAwareFindUsagesHandler result, List<PsiElement> elements, boolean forHighlightUsages) {
		elements.forEach [
			val delegateFactory = delegateFindFactory
			if (delegateFactory !== null) {
				val delegateHandler = delegateFactory.createFindUsagesHandler(it, forHighlightUsages)
				if (delegateHandler !== null && delegateHandler !== FindUsagesHandler.NULL_HANDLER)
					result.addDelegate(delegateHandler)
			}
		]
	}
	
}