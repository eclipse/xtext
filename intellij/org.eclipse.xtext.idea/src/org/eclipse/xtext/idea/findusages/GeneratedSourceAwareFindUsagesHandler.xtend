/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesOptions
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.usageView.UsageInfo
import com.intellij.util.Processor
import java.util.Collection
import java.util.Map

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class GeneratedSourceAwareFindUsagesHandler extends FindUsagesHandler {

	val FindUsagesHandler primaryHandler
	Collection<PsiElement> primaryElements = newArrayList
	Collection<PsiElement> secondaryElements = newArrayList
	val Map<PsiElement, FindUsagesHandler> secondaryHandlers = newLinkedHashMap

	new(FindUsagesHandler primaryHandler) {
		super(primaryHandler.psiElement)
		this.primaryHandler = primaryHandler
	}

	def void addSecondaryHandler(FindUsagesHandler secondaryHandler) {
		secondaryHandlers.put(secondaryHandler.psiElement, secondaryHandler)
	}

	override getPrimaryElements() {
		primaryElements = primaryHandler.primaryElements.toList
		primaryElements
	}

	override getSecondaryElements() {
		secondaryElements = primaryHandler.secondaryElements.toList
		secondaryElements + secondaryHandlers.keySet
	}

	override getFindUsagesDialog(boolean isSingleFile, boolean toShowInNewTab, boolean mustOpenInNewTab) {
		primaryHandler.getFindUsagesDialog(isSingleFile, toShowInNewTab, mustOpenInNewTab)
	}

	override getFindUsagesOptions(DataContext dataContext) {
		primaryHandler.getFindUsagesOptions(dataContext)
	}

	override processElementUsages(PsiElement element, Processor<UsageInfo> processor, FindUsagesOptions options) {
		element.findUsagesHandler?.processElementUsages(element, processor, options)
	}

	override processUsagesInText(PsiElement element, Processor<UsageInfo> processor, GlobalSearchScope searchScope) {
		element.findUsagesHandler?.processUsagesInText(element, processor, searchScope)
	}

	protected def getFindUsagesHandler(PsiElement element) {
		if (primaryElements.contains(element) || secondaryElements.contains(element))
			return primaryHandler

		return secondaryHandlers.get(element)
	}

}