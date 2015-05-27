/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.contentassist

import java.lang.reflect.Modifier

final package class TypeMatchFilters {
	
	public static val ITypeFilter INTERNAL = [ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
		if (simpleTypeName.startsWith('$'))
			return true
		if (enclosingTypeNames.length >= 1) {
			if (enclosingTypeNames.get(0).startsWith('$'))
				return true
		}
		return false
	]
	
	public static val ITypeFilter ABSTRACT = [ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
		Modifier.isAbstract(modifiers)
	]
	
	public static val ITypeFilter INTERFACE = [ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
		Modifier.isInterface(modifiers)
	]
	
	static def ITypeFilter operator_not(ITypeFilter filter) {
		[ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
			!filter.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)
		]
	}
	
	static def ITypeFilter operator_and(ITypeFilter filter1, ITypeFilter filter2) {
		[ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
			filter1.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)
				&& filter2.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)
		]
	}
	
	static def ITypeFilter operator_or(ITypeFilter filter1, ITypeFilter filter2) {
		[ modifiers, packageName, simpleTypeName, enclosingTypeNames, path |
			filter1.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)
				|| filter2.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)
		]
	}
	
}
