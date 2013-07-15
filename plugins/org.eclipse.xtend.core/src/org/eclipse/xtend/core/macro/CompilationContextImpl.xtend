/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions

class CompilationContextImpl implements CompilationStrategy.CompilationContext {

	extension ReflectExtensions reflectExtensions = new ReflectExtensions

	ITreeAppendable appendable
	ImportManager importManager
	CompilationUnitImpl compilationUnit

	new(ITreeAppendable appendable, CompilationUnitImpl compilationUnit) {
		this.appendable = appendable
		this.importManager = getImportManager(appendable)
		this.compilationUnit = compilationUnit
	}

	def ImportManager getImportManager(ITreeAppendable appendable) {
		return appendable.get('state')?.get('importManager')
	}

	override toJavaCode(TypeReference typeref) {
		val appendable = if (importManager != null) {
				new StringBuilderBasedAppendable(importManager)
			} else {
				new StringBuilderBasedAppendable()
			}
		val typeRef = compilationUnit.toLightweightTypeReference(typeref)
		appendable.append(typeRef)
		return appendable.toString
	}

}
