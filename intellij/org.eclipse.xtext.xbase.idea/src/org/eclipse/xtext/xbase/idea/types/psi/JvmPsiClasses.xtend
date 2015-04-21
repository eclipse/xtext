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
import org.eclipse.xtext.resource.XtextResource
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

	def Iterable<PsiClass> getPsiClassesByName(BaseXtextFile xtextFile, String name) {
		val resource = xtextFile.resource

		resource.resourceDescription.getExportedObjectsByType(JVM_DECLARED_TYPE).filter [ description |
			description.qualifiedName.shortName == name
		].map [ description |
			description.getPsiElement(resource)
		].filter(PsiClass)
	}

	def Iterable<PsiClass> getPsiClassesByQualifiedName(BaseXtextFile xtextFile, QualifiedName qualifiedName) {
		val resource = xtextFile.resource

		resource.resourceDescription.getExportedObjects(JVM_DECLARED_TYPE, qualifiedName, false).map [ description |
			description.getPsiElement(resource)
		].filter(PsiClass)
	}
	
	protected def getResourceDescription(XtextResource resource) {
		resource.resourceServiceProvider.resourceDescriptionManager.getResourceDescription(resource)
	}

	def Iterable<PsiClass> getPsiClasses(BaseXtextFile it) {
		resource.contents.filter(JvmDeclaredType).map[psiElement].filter(PsiClass)
	}

	def Iterable<PsiClass> getPsiClasses(PsiElement element) {
		element.jvmElements.filter(PsiClass)
	}

	def dispatch Iterable<PsiClass> findPsiClasses(BaseXtextFile element) {
		element.psiClasses
	}

	def dispatch Iterable<PsiClass> findPsiClasses(PsiElement element) {
		switch container : element.nearestLogicalContainer {
			PsiClass:
				#[container].filter(PsiClass)
			PsiMember:
				#[container.containingClass].filter(PsiClass)
			default: {
				val psiClasses = element.psiClasses
				if (psiClasses.empty)
					element.parent.findPsiClasses
				else
					psiClasses
			}
		}
	}

	def dispatch Iterable<PsiClass> findPsiClasses(Void element) {
		emptyList
	}

	def getShortName(QualifiedName qualifiedName) {
		val lastSegment = qualifiedName.lastSegment
		val index = lastSegment.indexOf('$')
		if (index == -1)
			lastSegment
		else
			lastSegment.substring(index)
	}

}
