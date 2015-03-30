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
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.psi.PsiElementProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator

import static extension org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions.*

class PsiJvmModelAssociator extends JvmModelAssociator {

	@Inject
	extension IPsiModelAssociator

	@Inject
	extension IPsiModelAssociations

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
		switch jvmElement {
			JvmDeclaredType case jvmElement.declaringType == null:
				psiClassProviderProvider.get => [ provider |
					provider.jvmDeclaredType = jvmElement
					provider.sourceElement = sourceElement
				]
			JvmDeclaredType:
				[
					val psiClass = jvmElement.declaringType.psiElement
					if (psiClass instanceof PsiClass)
						psiClass.innerClasses.findByJvmElement(jvmElement)
				]
			JvmExecutable:
				[
					val psiClass = jvmElement.declaringType.psiElement
					if (psiClass instanceof PsiClass)
						psiClass.methods.findByJvmElement(jvmElement)
				]
			JvmField:
				[
					val psiClass = jvmElement.declaringType.psiElement
					if (psiClass instanceof PsiClass)
						psiClass.fields.findByJvmElement(jvmElement)
				]
			JvmFormalParameter:
				[
					val psiMethod = jvmElement.eContainer.psiElement
					if (psiMethod instanceof PsiMethod)
						psiMethod.parameterList.parameters.findByJvmElement(jvmElement)
				]
		}
	}

	protected def findByJvmElement(PsiElement[] elements, EObject jvmElement) {
		elements.findFirst [ element |
			element.jvmElement == jvmElement
		]
	}

}