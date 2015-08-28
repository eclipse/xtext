/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.google.inject.Inject
import com.intellij.find.findUsages.CustomUsageSearcher
import com.intellij.find.findUsages.FindUsagesOptions
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.Computable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.PsiSearchHelper
import com.intellij.psi.search.SearchRequestCollector
import com.intellij.psi.search.SearchSession
import com.intellij.usageView.UsageInfo
import com.intellij.usages.Usage
import com.intellij.usages.UsageInfoToUsageConverter
import com.intellij.util.Processor
import java.util.Collection
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class GeneratedSourceAwareUsageSearcher extends CustomUsageSearcher {

	@Inject ITraceForVirtualFileProvider traceProvider

	new() {
		IdeaSharedInjectorProvider.injectMembers(this)
	}

	override processElementUsages(PsiElement element, Processor<Usage> processor, FindUsagesOptions options) {
		try {
			PsiSearchHelper.SERVICE.getInstance(element.project).processRequests(options.fastTrack) [ reference |
				val usages = ApplicationManager.application.runReadAction(convert(element, reference))
				if (usages.empty)
					return false

				for (usage : usages)
					if (!processor.process(usage))
						return false

				return true
			]
		} finally {
			options.fastTrack = new SearchRequestCollector(new SearchSession)
		}
	}

	protected def Computable<Collection<Usage>> convert(PsiElement element, PsiReference reference) {
		[
			val referencingElement = reference.element
			if (!referencingElement.valid)
				return emptyList

			val originalElements = traceProvider.getOriginalElements(referencingElement)
			if (originalElements.empty)
				return #[
					toUsage(element, reference)
				]

			originalElements.map [ originalElement |
				element.toUsage(originalElement)
			]
		]
	}

	protected def toUsage(PsiElement element, PsiReference reference) {
		val usageInfo = new UsageInfo(reference)
		UsageInfoToUsageConverter.convert(#[element], usageInfo)
	}

	protected def toUsage(PsiElement element, PsiElement originalElement) {
		val usageInfo = new UsageInfo(originalElement)
		UsageInfoToUsageConverter.convert(#[element], usageInfo)
	}

}