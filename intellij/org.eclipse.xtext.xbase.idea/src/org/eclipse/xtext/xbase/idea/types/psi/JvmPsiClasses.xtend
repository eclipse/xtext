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
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.impl.BaseXtextFile

import static org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_DECLARED_TYPE

@Singleton
class JvmPsiClasses {

	@Inject
	extension IPsiModelAssociations

	def getPsiClassesByName(BaseXtextFile it, String name) {
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

	def getPsiClassesByQualifiedName(BaseXtextFile it, QualifiedName qualifiedName) {
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
	
	def getPsiClasses(BaseXtextFile it) {
		resource.contents.filter(JvmDeclaredType).map[psiElement].filter(JvmPsiClass)
	}

}
