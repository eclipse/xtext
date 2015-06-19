/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.findusages

import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.psi.PsiElement
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiMethod

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class GeneratedSourceAwareUsagesHandlerFactory extends FindUsagesHandlerFactory {
	
	private static final Logger LOG = Logger.getInstance("#com.intellij.find.findParameterUsages.FindUsagesManager");
	
	override canFindUsages(PsiElement element) {
		if (element instanceof PsiMethod) {
			if (delegateFindFactory(element) !== null) {
				return true
			}
			for (gen: element.containingClass.findMethodsByName(element.name + "gen", false)) {
				if (delegateFindFactory(gen) !== null) {
					return true
				}
			}
		}
		return false
	}
	
	def delegateFindFactory(PsiElement element) {
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
		return delegateFindFactory(element).createFindUsagesHandler(element, forHighlightUsages);
	}
	
}