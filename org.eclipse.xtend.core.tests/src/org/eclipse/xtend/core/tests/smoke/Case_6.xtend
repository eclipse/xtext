/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature

class Case_6 {
	
	def dispatch Object transform(EPackage packageDecl) {
		packageDecl.eContents.map(e | transform(e as EStructuralFeature))
	}
	
	def dispatch Object transform(EStructuralFeature entity) {
		val inferredType = null
		newArrayList(inferredType as EObject) 	 
	}
	
	def dispatch Object transform(EClass model) {
		model.ETypeParameters.map(e| transform(e))
	}

}