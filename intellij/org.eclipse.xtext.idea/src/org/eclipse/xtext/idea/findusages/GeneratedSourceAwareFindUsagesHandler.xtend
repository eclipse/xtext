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
import com.intellij.psi.search.SearchScope
import com.intellij.usageView.UsageInfo
import com.intellij.util.Processor
import java.util.List

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class GeneratedSourceAwareFindUsagesHandler extends FindUsagesHandler {
	
	val List<FindUsagesHandler> delegates = newArrayList
	val boolean includeAll
	
	new(FindUsagesHandler primaryDelegate, boolean includeAll) {
		super(primaryDelegate.psiElement)
		this.includeAll = includeAll
		addDelegate(primaryDelegate)
	}
	
	def void addDelegate(FindUsagesHandler next) {
		delegates += next
	}
	
	override findReferencesToHighlight(PsiElement target, SearchScope searchScope) {
		primaryDelegate.findReferencesToHighlight(target, searchScope)
	}
	
	protected def getPrimaryDelegate() {
		delegates.head
	}
	
	override getFindUsagesDialog(boolean isSingleFile, boolean toShowInNewTab, boolean mustOpenInNewTab) {
		primaryDelegate.getFindUsagesDialog(isSingleFile, toShowInNewTab, mustOpenInNewTab)
	}
	
	override getFindUsagesOptions() {
		primaryDelegate.findUsagesOptions
	}
	
	override getFindUsagesOptions(DataContext dataContext) {
		primaryDelegate.getFindUsagesOptions(dataContext)
	}
	
	override getPrimaryElements() {
		return delegates.map[primaryElements.toList].flatten
	}
	
	override getSecondaryElements() {
		return delegates.map[secondaryElements.toList].flatten
	}
	
	override processElementUsages(PsiElement element, Processor<UsageInfo> processor, FindUsagesOptions options) {
		getRelevantDelegates().findFirst[ handles(element) ]?.processElementUsages(element, processor, options)
	}
	
	def getRelevantDelegates() {
		if (includeAll) {
			delegates
		} else {
			delegates.subList(0, 1)
		}
	}
	
	def protected handles(FindUsagesHandler handler, PsiElement element) {
		handler.primaryElements.contains(element) || handler.secondaryElements.contains(element)
	}
	
	override processUsagesInText(PsiElement element, Processor<UsageInfo> processor, GlobalSearchScope searchScope) {
		getRelevantDelegates().findFirst[ handles(element) ]?.processUsagesInText(element, processor, searchScope)
	}
	
}