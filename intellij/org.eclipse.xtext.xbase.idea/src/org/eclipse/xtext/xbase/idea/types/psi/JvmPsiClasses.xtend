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
import com.intellij.psi.search.GlobalSearchScope
import javax.inject.Provider
import org.eclipse.xtext.idea.resource.ScopeBasedResourceDescriptions
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.ISelectable
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider
import org.eclipse.xtext.xbase.idea.types.psi.impl.StubBasedJvmPsiClass

import static org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_DECLARED_TYPE

@Singleton
class JvmPsiClasses {

	@Inject
	extension IPsiJvmModelAssociations

	@Inject
	extension IPsiLogicalContainerProvider

	@Inject
	Provider<StubBasedJvmPsiClass> stubBasedJvmPsiClassProvider

	@Inject
	Provider<ScopeBasedResourceDescriptions> resourceDescriptionsProvider

	def getPsiClassesByName(BaseXtextFile xtextFile, String name) {
		new PsiFileBasedResourceDescription(xtextFile).getPsiClassesByName(name)
	}

	def getPsiClassesByName(String name, GlobalSearchScope scope) {
		scope.resourceDescriptions.getPsiClassesByName(name)
	}

	protected def getPsiClassesByName(ISelectable selectable, String name) {
		selectable.getExportedObjectsByType(JVM_DECLARED_TYPE).filter [ description |
			description.qualifiedName.shortName == name
		].map [
			toPsiClass
		]
	}

	def getPsiClassesByQualifiedName(BaseXtextFile xtextFile, QualifiedName qualifiedName) {
		new PsiFileBasedResourceDescription(xtextFile).getPsiClassesByQualifiedName(qualifiedName)
	}

	def getPsiClassesByQualifiedName(QualifiedName qualifiedName, GlobalSearchScope scope) {
		scope.resourceDescriptions.getPsiClassesByQualifiedName(qualifiedName)
	}

	protected def getPsiClassesByQualifiedName(ISelectable selectable, QualifiedName qualifiedName) {
		selectable.getExportedObjects(JVM_DECLARED_TYPE, qualifiedName, false).map [
			toPsiClass
		]
	}

	protected def getResourceDescriptions(GlobalSearchScope scope) {
		val resourceDescriptions = resourceDescriptionsProvider.get
		resourceDescriptions.scope = scope
		resourceDescriptions
	}

	def getPsiClasses(BaseXtextFile xtextFile) {
		new PsiFileBasedResourceDescription(xtextFile).getExportedObjectsByType(JVM_DECLARED_TYPE).map[toPsiClass]
	}

	protected def PsiClass toPsiClass(IEObjectDescription description) {
		val stubBasedJvmPsiClass = stubBasedJvmPsiClassProvider.get
		stubBasedJvmPsiClass.objectDescription = description
		stubBasedJvmPsiClass
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
				#[container]
			PsiMember:
				#[container.containingClass]
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

	/**
	 * Computes a short name from a qualified name. If the qualified name is a name with a name of a nested type,
	 * only the innermost name is returned as the short name, e.g {@code 'java.util.Map$Entry'.shortName} yields {@code 'Entry'}
	 */
	def getShortName(QualifiedName qualifiedName) {
		val lastSegment = qualifiedName.lastSegment
		val index = lastSegment.lastIndexOf('$')
		if (index == -1)
			lastSegment
		else
			lastSegment.substring(index)
	}

}
