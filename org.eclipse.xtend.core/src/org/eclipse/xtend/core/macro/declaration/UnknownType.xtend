/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.annotations.Data

@Data
class UnknownType implements Type {
	
	CompilationUnit compilationUnit
	String qualifiedName
	
	override isAssignableFrom(Type otherType) {
		return false;
	}
	
	override getSimpleName() {
		val idx = qualifiedName.lastIndexOf('.')
		if (idx >0 ) {
			qualifiedName.substring(idx)
		} else {
			qualifiedName
		}
	}
	
}