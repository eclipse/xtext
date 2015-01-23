/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.types.psi

import com.google.inject.Inject
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElementFinder
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex

class JvmTypesElementFinder extends PsiElementFinder {
	
	@Inject
	extension PsiJvmDeclaredTypes
	
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
		val result = newArrayList 
		for (xtextFile : exportedObjectQualifiedNameIndex.get(qualifiedName, project, scope)) {
			if (xtextFile.language == language) {
				result += xtextFile.getPsiJvmDeclaredTypes(QualifiedName.create(qualifiedName.split("\\.")))
			}
		}
		result
	}
	
}