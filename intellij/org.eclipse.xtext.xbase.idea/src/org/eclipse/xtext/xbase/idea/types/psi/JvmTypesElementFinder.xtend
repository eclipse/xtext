/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi

import com.google.inject.Inject
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElementFinder
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider.ClassNameVariants
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex

// TODO make this a shared service
// currently we mix language specific and language independent aspects here
class JvmTypesElementFinder extends PsiElementFinder {

	@Inject
	extension JvmPsiClasses

	@Inject
	ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex

	val Project project

	val IXtextLanguage language

	new(IXtextLanguage language, Project project) {
		language.injectMembers(this)
		this.project = project
		this.language = language
	}

	override findClass(String qualifiedName, GlobalSearchScope scope) {
		// avoid wrapping / array creation
		doFindClasses(qualifiedName, scope).head
	}

	override findClasses(String qualifiedName, GlobalSearchScope scope) {
		doFindClasses(qualifiedName, scope)
	}
	
	def protected doFindClasses(String qualifiedName, GlobalSearchScope scope) {
		qualifiedName.variants.map[doFindClassesByVariant(scope)].flatten
	}

	protected def doFindClassesByVariant(String variant, GlobalSearchScope scope) {
		val qualifiedName = variant.toQualifiedName
		variant.findFiles(scope).map [
			getPsiClassesByQualifiedName(qualifiedName)
		].flatten
	}

	protected def getVariants(String qualifiedName) {
		#[qualifiedName] + [new ClassNameVariants(qualifiedName)]
	}

	protected def toQualifiedName(String variant) {
		QualifiedName.create(variant.split("\\."))
	}

	protected def findFiles(String qualifiedName, GlobalSearchScope scope) {
		exportedObjectQualifiedNameIndex.get(qualifiedName, project, scope).filter [ xtextFile |
			xtextFile.language == language
		]
	}
	
	override getClassesFilter(GlobalSearchScope scope) {
		[ psiClass |
			if (psiClass instanceof JvmPsiClass) {
				return true
			}
			return psiClass.qualifiedName.findClass(scope) == null
		]
	}

}