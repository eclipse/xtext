package org.eclipse.xtend.core.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.CompilationContext
import org.eclipse.xtend.lib.macro.type.TypeReference
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions

class CompilationContextImpl implements CompilationContext {

	extension ReflectExtensions reflectExtensions = new ReflectExtensions

	ITreeAppendable appendable
	ImportManager importManager
	CompilationUnitImpl compilationUnit
	TypeReferenceSerializer typeRefSerializer

	new(ITreeAppendable appendable, CompilationUnitImpl compilationUnit, TypeReferenceSerializer typeRefSerializer) {
		this.appendable = appendable
		this.importManager = getImportManager(appendable)
		this.compilationUnit = compilationUnit
		this.typeRefSerializer = typeRefSerializer
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
		val typeRef = compilationUnit.toJvmTypeReference(typeref)
		typeRefSerializer.serialize(typeRef, compilationUnit.xtendFile, appendable)
		return appendable.toString
	}

}
