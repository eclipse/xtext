/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.copyqualifiedname

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
class DefaultCopyQualifiedNameService implements CopyQualifiedNameService {

	@Inject
	private IResourceServiceProvider.Registry registry;
	
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
		'''«toQualifiedNameFunction.apply(head)»«FOR element : tail», «toQualifiedNameFunction.apply(element)»«ENDFOR»'''
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

	def protected getQualifiedNameProvider(EObject it) {
		getService(IQualifiedNameProvider)
	}

	def protected getQualifiedNameConverter(EObject it) {
		getService(IQualifiedNameConverter)
	}

	def protected <T> T getService(EObject it, Class<T> serviceClass) {
		registry.getResourceServiceProvider(eResource.URI).get(serviceClass)
	}

}
