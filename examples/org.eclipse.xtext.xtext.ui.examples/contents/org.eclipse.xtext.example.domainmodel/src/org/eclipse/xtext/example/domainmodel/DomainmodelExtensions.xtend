/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration

class DomainmodelExtensions {
	
	/**
	 * computes the qualified name if its 
	 *  a PackageDeclaration, an Entity or a JvmDeclaredType
	 * returns null otherwise
	 */
	def String packageName(Object o) {
		switch(o) {
			PackageDeclaration : concatPath(packageName(o.eContainer), o.name)
			EObject : packageName(o.eContainer)
			JvmDeclaredType : o.packageName
			default: null
		}
	}
	
	def concatPath(String prefix, String suffix) {
		if (prefix.nullOrEmpty) 
			suffix 
		else 
			prefix + "." + suffix
	}
	
}