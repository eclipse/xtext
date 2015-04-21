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
		findClasses(qualifiedName, scope).head
	}

	override findClasses(String qualifiedName, GlobalSearchScope scope) {
		qualifiedName.variants.map[doFindClasses(scope)].flatten
	}

	protected def doFindClasses(String variant, GlobalSearchScope scope) {
		val qualifiedName = variant.toQualifiedName
		variant.findFiles(scope).map [
			getPsiClassesByQualifiedName(qualifiedName)
		].flatten
	}

	protected def getVariants(String qualifiedName) {
		#[qualifiedName] + new ClassNameVariants(qualifiedName).toIterable
	}

	protected def toQualifiedName(String variant) {
		QualifiedName.create(variant.split("\\."))
	}

	protected def findFiles(String qualifiedName, GlobalSearchScope scope) {
		exportedObjectQualifiedNameIndex.get(qualifiedName.toString, project, scope).filter [ xtextFile |
			xtextFile.language == language
		]
	}

}