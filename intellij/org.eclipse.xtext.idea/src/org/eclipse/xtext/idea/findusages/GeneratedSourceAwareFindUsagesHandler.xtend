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
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.usageView.UsageInfo
import com.intellij.util.Processor
import java.util.Collection
import java.util.Map

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Anton Kosyakov - Refactoring and testing
 */
class GeneratedSourceAwareFindUsagesHandler extends FindUsagesHandler {

	static val LOG = Logger.getInstance("#org.eclipse.xtext.idea.findusages.GeneratedSourceAwareFindUsagesHandler")

	val FindUsagesHandler primaryHandler
	val Map<PsiElement, FindUsagesHandler> secondaryHandlers

	Collection<PsiElement> primaryElements = newArrayList
	Collection<PsiElement> secondaryElements = newArrayList

	new(FindUsagesHandler primaryHandler, Iterable<FindUsagesHandler> secondaryHandlers) {
		super(primaryHandler.psiElement)
		this.primaryHandler = primaryHandler

		LOG.assertTrue(!secondaryHandlers.empty)
		this.secondaryHandlers = secondaryHandlers.toMap[psiElement]
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

	override findReferencesToHighlight(PsiElement target, SearchScope searchScope) {
		throw new UnsupportedOperationException('GeneratedSourceAwareFindUsagesHandler should not be used to find references to highlight.')
	}

}