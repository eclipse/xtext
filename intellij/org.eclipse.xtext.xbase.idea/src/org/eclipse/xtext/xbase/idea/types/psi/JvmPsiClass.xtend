/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi

import com.google.inject.Provider
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.UserDataHolderEx
import com.intellij.psi.PsiClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.service.OperationCanceledError

import static extension org.eclipse.xtext.xbase.idea.types.psi.LoadingTypeResourcePhase.*
import com.intellij.psi.PsiMirrorElement

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmPsiClass implements PsiClass, UserDataHolderEx, PsiMirrorElement {

	@Accessors
	PsiClass stub

	@Accessors
	JvmDeclaredType type

	PsiClass myPsiClass

	@Accessors
	Provider<PsiClass> psiClassProvider

	@Delegate
	def PsiClass getDelegate() {
		if (type.loadingTypeResource)
			stub
		else
			psiClass
	}

	protected synchronized def getPsiClass() {
		if (myPsiClass == null)
			try {
				myPsiClass = psiClassProvider.get
			} catch (OperationCanceledError e) {
				throw e.wrapped
			}
		myPsiClass
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

	override <T> putUserDataIfAbsent(Key<T> key, T value) {
		(delegate as UserDataHolderEx).putUserDataIfAbsent(key, value)
	}

	override <T> replace(Key<T> key, T oldValue, T newValue) {
		(delegate as UserDataHolderEx).replace(key, oldValue, newValue)
	}
	
	override getPrototype() {
		this
	}

}