/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMember
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider

import static org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_DECLARED_TYPE

@Singleton
class JvmPsiClasses {

	@Inject
	extension IPsiModelAssociations

	@Inject
	extension IPsiJvmModelAssociations

	@Inject
	extension IPsiLogicalContainerProvider

	def Iterable<JvmPsiClass> getPsiClassesByName(BaseXtextFile it, String name) {
		val resource = resource

		val result = newArrayList
		for (description : resourceDescription.getExportedObjectsByType(JVM_DECLARED_TYPE)) {
			switch jvmDeclaredType : resource.resourceSet.getEObject(description.getEObjectURI, true) {
				JvmDeclaredType case jvmDeclaredType.simpleName == name:
					result += jvmDeclaredType.psiElement as JvmPsiClass
			}
		}
		result
	}

	def Iterable<JvmPsiClass> getPsiClassesByQualifiedName(BaseXtextFile it, QualifiedName qualifiedName) {
		val resource = resource

		val result = newArrayList
		for (description : resourceDescription.getExportedObjects(JVM_DECLARED_TYPE, qualifiedName, false)) {
			switch jvmDeclaredType : resource.resourceSet.getEObject(description.getEObjectURI, true) {
				JvmDeclaredType:
					result += jvmDeclaredType.psiElement as JvmPsiClass
			}
		}
		result
	}

	def Iterable<JvmPsiClass> getPsiClasses(BaseXtextFile it) {
		resource.contents.filter(JvmDeclaredType).map[psiElement].filter(JvmPsiClass)
	}

	def Iterable<JvmPsiClass> getPsiClasses(PsiElement element) {
		element.jvmElements.filter(JvmPsiClass)
	}

	def dispatch Iterable<JvmPsiClass> findPsiClasses(BaseXtextFile element) {
		element.psiClasses
	}

	def dispatch Iterable<JvmPsiClass> findPsiClasses(PsiElement element) {
		switch container : element.nearestLogicalContainer {
			PsiClass:
				#[container].filter(JvmPsiClass)
			PsiMember:
				#[container.containingClass].filter(JvmPsiClass)
			default: {
				val psiClasses = element.psiClasses
				if (psiClasses.empty)
					element.parent.findPsiClasses
				else
					psiClasses
			}
		}
	}

	def dispatch Iterable<JvmPsiClass> findPsiClasses(Void element) {
		emptyList
	}

}
