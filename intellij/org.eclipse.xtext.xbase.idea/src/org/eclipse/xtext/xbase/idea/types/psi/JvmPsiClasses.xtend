/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi

import com.google.inject.Singleton
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.impl.BaseXtextFile

@Singleton
class JvmPsiClasses {

	def Iterable<PsiClass> getPsiClassesByName(BaseXtextFile xtextFile, String name) {
		emptyList
	}

	def Iterable<PsiClass> getPsiClassesByName(String name, GlobalSearchScope scope) {
		emptyList
	}

	def Iterable<PsiClass> getPsiClassesByQualifiedName(BaseXtextFile xtextFile, QualifiedName qualifiedName) {
		emptyList
	}

	def Iterable<PsiClass> getPsiClassesByQualifiedName(QualifiedName qualifiedName, GlobalSearchScope scope) {
		emptyList
	}

	def Iterable<PsiClass> getPsiClasses(PsiElement element) {
		emptyList
	}

	def Iterable<PsiClass> findPsiClasses(PsiElement element) {
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
