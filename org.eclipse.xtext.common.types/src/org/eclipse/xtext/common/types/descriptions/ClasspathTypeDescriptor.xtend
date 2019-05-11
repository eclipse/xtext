/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions

import com.google.common.base.Splitter
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.naming.QualifiedName

@FinalFieldsConstructor
@EqualsHashCode
@Accessors
class ClasspathTypeDescriptor implements ITypeDescriptor {

	static val PACKAGE_AND_NESTED_CLASS_SPLITTER = Splitter.onPattern('\\.|\\$')

	val String name

	// TODO may also need access flags of enclosing classes to determine visibility
	val int modifiers

	override getSimpleName() {
		qualifiedName.lastSegment
	}

	override getQualifiedName() {
		QualifiedName.create(PACKAGE_AND_NESTED_CLASS_SPLITTER.split(name))
	}

}
