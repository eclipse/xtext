/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EObject
import java.util.List

class Case_9 extends Case_8 {
	
	def dispatch CharSequence generateTypeRef(ENamedElement c) {
		  if (c.eContainer !== null)
		    c.eContainer.generateTypeRef
		  else if (c.eIsProxy)
		    '''«c.name»'''
		  else
		    ''''''
		}

	def dispatch CharSequence generateTypeRef(EObject o) {
	  	o.eContainer.generateTypeRef
	}  
	
	override <T1> /*List<List<T1>>*/ foo(T1 t) {
        val List<List<T1>> x = super.foo(t)
        x.toString
        return null
    }
		
}