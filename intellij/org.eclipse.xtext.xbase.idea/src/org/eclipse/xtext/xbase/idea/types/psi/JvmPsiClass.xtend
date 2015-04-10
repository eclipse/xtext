/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi

import com.google.inject.Provider
import com.intellij.psi.PsiClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.service.OperationCanceledError

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmPsiClass implements PsiClass {

	@Accessors
	PsiClass stub

	PsiClass psiClass

	@Accessors
	Provider<PsiClass> psiClassProvider

	@Delegate
	def synchronized PsiClass getDelegate() {
		if (psiClass == null)
			try {
				psiClass = psiClassProvider.get
			} catch (OperationCanceledError e) {
				throw e.wrapped
			}
		psiClass
	}

	protected def getPsiClassOrStub() {
		if(psiClass != null) psiClass else stub
	}

	override getName() {
		psiClassOrStub.name
	}

	override getQualifiedName() {
		psiClassOrStub.qualifiedName
	}

	override getModifierList() {
		psiClassOrStub.modifierList
	}

	override hasModifierProperty(String name) {
		psiClassOrStub.hasModifierProperty(name)
	}

	override hasTypeParameters() {
		psiClassOrStub.hasTypeParameters
	}

	override getContainingClass() {
		psiClassOrStub.containingClass
	}

	override getContainingFile() {
		psiClassOrStub.containingFile
	}

	override isInterface() {
		psiClassOrStub.interface
	}

	override isEnum() {
		psiClassOrStub.enum
	}

	override isAnnotationType() {
		psiClassOrStub.annotationType
	}
	
	override equals(Object obj) {
		delegate.equals(obj)
	}
	
	override hashCode() {
		delegate.hashCode
	}
	
	override toString() {
		class.simpleName + ':' + delegate.toString
	}

}