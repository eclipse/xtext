/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations

@Singleton
class JvmPsiClasses {

	@Inject
	extension IPsiModelAssociations

	@Inject
	extension IPsiJvmModelAssociations

	def Iterable<PsiClass> getPsiClasses(BaseXtextFile it) {
		resource.contents.filter(JvmDeclaredType).map[psiElement].filter(PsiClass)
	}

	def Iterable<PsiClass> getPsiClasses(PsiElement element) {
		element.jvmElements.filter(PsiClass)
	}

}
