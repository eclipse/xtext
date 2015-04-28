/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.access

import com.intellij.psi.PsiClass
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.access.TypeResource
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror
import org.eclipse.xtext.common.types.access.impl.ITypeFactory

import static extension org.eclipse.xtext.xbase.idea.types.psi.LoadingTypeResourcePhase.*

class PsiClassMirror extends AbstractClassMirror {

	val PsiClass psiClass

	val ITypeFactory<PsiClass, JvmDeclaredType> typeFactory

	new(PsiClass psiClass, ITypeFactory<PsiClass, JvmDeclaredType> typeFactory) {
		this.psiClass = psiClass
		this.typeFactory = typeFactory
	}

	override protected getTypeName() {
		psiClass.qualifiedName
	}

	override initialize(TypeResource typeResource) {
		val loadingTypeResource = typeResource.loadingTypeResource
		try {
			typeResource.loadingTypeResource = true
			typeResource.contents.add(typeFactory.createType(psiClass))
		} finally {
			typeResource.loadingTypeResource = loadingTypeResource
		}
	}

	override isSealed() {
		true
	}

}