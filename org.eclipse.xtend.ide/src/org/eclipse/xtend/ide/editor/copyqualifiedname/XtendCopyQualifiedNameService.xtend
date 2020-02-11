/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor.copyqualifiedname

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.xbase.ui.editor.copyqualifiedname.XbaseCopyQualifiedNameService

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
class XtendCopyQualifiedNameService extends XbaseCopyQualifiedNameService {

	def dispatch String getQualifiedName(XtendFunction it, EObject context) {
		toQualifiedName
	}

	def dispatch String getQualifiedName(XtendFunction it, Void context) {
		toQualifiedName
	}

	protected def String toQualifiedName(XtendFunction it) {
		'''«toFullyQualifiedName»(«parameters.toQualifiedNames[parameterType.simpleName]»)'''
	}

	def dispatch String getQualifiedName(XtendConstructor it, EObject context) {
		toQualifiedName
	}

	def dispatch String getQualifiedName(XtendConstructor it, Void context) {
		toQualifiedName
	}

	protected def String toQualifiedName(XtendConstructor it) {
		'''«toFullyQualifiedName»(«parameters.toQualifiedNames[parameterType.simpleName]»)'''
	}

}
