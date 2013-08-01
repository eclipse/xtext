/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.copyqualifiedname

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import com.google.inject.Inject

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
class DefaultCopyQualifiedNameService implements CopyQualifiedNameService {

	@Inject
	IQualifiedNameProvider qualifiedNameProvider

	@Inject
	IQualifiedNameConverter qualifiedNameConverter

	def dispatch getQualifiedName(EObject it, EObject context) {
		toFullyQualifiedName
	}

	def dispatch getQualifiedName(EObject it, Void context) {
		toFullyQualifiedName
	}

	def protected dispatch getQualifiedName(Void it, EObject context) {
		null
	}

	def protected dispatch getQualifiedName(Void it, Void context) {
		null
	}

	def protected <T> toQualifiedNames(List<T> it, (T)=>String toQualifiedNameFunction) {
		if (it == null || size == 0) {
			return ""
		}
		'''«FOR element : it SEPARATOR ', '»«toQualifiedNameFunction.apply(element)»«ENDFOR»'''
	}

	def protected toFullyQualifiedName(EObject it) {
		if (eIsProxy) {
			return null
		}
		toString(fullyQualifiedName)
	}

	def protected getFullyQualifiedName(EObject it) {
		if (it == null) {
			return null
		}
		qualifiedNameProvider.getFullyQualifiedName(it)
	}

	def protected toString(EObject it, QualifiedName fullyQualifiedName) {
		if (fullyQualifiedName == null) {
			return null
		}
		qualifiedNameConverter.toString(fullyQualifiedName)
	}

}
