/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvmmodel

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.psi.PsiElementProvider
import org.eclipse.xtext.xbase.idea.jvm.PsiJvmFileImpl
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

class PsiJvmModelAssociator extends JvmModelAssociator {

	@Inject
	extension IPsiModelAssociator

	@Inject
	Provider<JvmPsiClassProvider> psiClassProviderProvider

	override associate(EObject sourceElement, EObject jvmElement) {
		super.associate(sourceElement, jvmElement)
		val psiElementProvider = createPsiElementProvider(sourceElement, jvmElement)
		if (psiElementProvider != null) {
			jvmElement.associate(psiElementProvider)
		}
	}

	override associatePrimary(EObject sourceElement, EObject jvmElement) {
		super.associatePrimary(sourceElement, jvmElement)
		val psiElementProvider = createPsiElementProvider(sourceElement, jvmElement)
		if (psiElementProvider != null) {
			jvmElement.associatePrimary(psiElementProvider)
		}
	}

	protected def PsiElementProvider createPsiElementProvider(EObject sourceElement, EObject jvmElement) {
		[
			val root = jvmElement.rootContainer
			val psiClass = if (root instanceof JvmDeclaredType) {
					val provider = psiClassProviderProvider.get
					provider.jvmDeclaredType = root
					provider.sourceElement = sourceElement
					provider.get
				}
			if (root == jvmElement) {
				return psiClass
			}
			val psiFile = psiClass.containingFile
			if (psiFile instanceof PsiJvmFileImpl) {
				psiFile.mapping.get(jvmElement)
			}
		]
	}

}