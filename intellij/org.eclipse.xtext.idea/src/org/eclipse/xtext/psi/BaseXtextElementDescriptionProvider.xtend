/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi

import com.intellij.psi.ElementDescriptionLocation
import com.intellij.psi.ElementDescriptionProvider
import com.intellij.psi.PsiElement
import com.intellij.usageView.UsageViewTypeLocation
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.IXtextLanguage

class BaseXtextElementDescriptionProvider implements ElementDescriptionProvider {

	@Accessors
	val IXtextLanguage language

	new(IXtextLanguage language) {
		this.language = language
		language.injectMembers(this)
	}

	override final getElementDescription(PsiElement element, ElementDescriptionLocation location) {
		if (element?.language == language) {
			doGetElementDescription(element, location)
		}
	}

	def doGetElementDescription(PsiElement element, ElementDescriptionLocation location) {
		if (location == UsageViewTypeLocation.INSTANCE) {
			if (element instanceof PsiEObject) {
				val eObject = element.EObject
				if (eObject != null) {
					return eObject.eClass.name
				}
			}
		}
	}

}
