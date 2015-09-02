/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.google.inject.Inject
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.util.PsiTreeUtil
import java.util.Collections
import java.util.List
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO decorate all find usage requests and use a custom Processor<UsageInfo> in the FindUsagesHandler to redirect navigation requests
 */
class GeneratedSourceAwareUsagesHandlerFactory extends FindUsagesHandlerFactory {
	
	private static final Logger LOG = Logger.getInstance("#com.intellij.find.findParameterUsages.FindUsagesManager");
	
	@Inject ITraceForVirtualFileProvider traceProvider
	
	new() {
		IdeaSharedInjectorProvider.injectMembers(this)
	}
	
	override canFindUsages(PsiElement element) {
		return delegateFindFactory(element) !== null || 
			element.generatedElements.exists [
				delegateFindFactory !== null
			] || element.originalElements.exists [
				delegateFindFactory !== null
			]
	}
	
	override createFindUsagesHandler(PsiElement element, boolean forHighlightUsages) {
		val primaryHandler = element.delegateFindUsagesHandler(forHighlightUsages)
		if (primaryHandler.nullHandler)
			return null
		
		val secondaryHandlers = element.getSecondaryHandlers(forHighlightUsages)
		if (secondaryHandlers.empty)
			return primaryHandler 
		
		val handler = new GeneratedSourceAwareFindUsagesHandler(primaryHandler)
		for (secondaryHandler : secondaryHandlers)
			handler.addSecondaryHandler(secondaryHandler)
		return handler
	}
	
	protected def getSecondaryHandlers(PsiElement element, boolean forHighlightUsages) {
		val secondaryElements = element.getSecondaryElements(forHighlightUsages)
		secondaryElements.map[
			delegateFindUsagesHandler(forHighlightUsages)
		].filter[
			!nullHandler
		]
	}
	
	protected def getSecondaryElements(PsiElement element, boolean forHighlightUsages) {
		val generatedElements = element.generatedElements
		if (!generatedElements.empty)
			return generatedElements
			
		// highlighting is only done with the real element under the cursor or with its derived elements
		// not vice versa
		if (forHighlightUsages)
			return emptyList
			
		// check if this is a generated artifact - use the original element as the primary and search for the primary element and visualize the 
		// primary element but only search for references to this element
		return element.originalElements
	}
	
	protected def List<? extends PsiElement> getOriginalElements(PsiElement element) {
		if (element instanceof PsiNameIdentifierOwner) {
			return getOriginalElements(element.nameIdentifier)
		}
		val result = traceProvider.getOriginalElements(element).map[PsiTreeUtil.getParentOfType(it, PsiNamedElement, false)].filterNull.toSet.toList
		return result;
	}
	
	protected def List<? extends PsiElement> getGeneratedElements(PsiElement element) {
		if (element instanceof PsiNameIdentifierOwner) {
			val nameIdentifier = element.nameIdentifier
			if (nameIdentifier === null) {
				return Collections.emptyList
			}
			return getGeneratedElements(nameIdentifier)
		}
		val result = newArrayList
		for (generatedElement : traceProvider.getGeneratedElements(element)) {
			val parent = PsiTreeUtil.getParentOfType(generatedElement, PsiNamedElement, false)
			if (parent != null && !result.contains(parent)) {
				result.add(parent)
			}	
		}
		return result
	}
	
	protected def isNullHandler(FindUsagesHandler handler) {
		handler === null || handler === FindUsagesHandler.NULL_HANDLER
	}
	
	protected def delegateFindUsagesHandler(PsiElement element, boolean forHighlightUsages) {
		element.delegateFindFactory?.createFindUsagesHandler(element, forHighlightUsages)
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
				} catch (ProcessCanceledException e) {
					throw e;
				} catch (Exception e) {
					LOG.error(e);
				}
			}
		}
		return null
	}
	
}