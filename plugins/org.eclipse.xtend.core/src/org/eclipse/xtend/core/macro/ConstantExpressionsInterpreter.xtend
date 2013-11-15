package org.eclipse.xtend.core.macro

import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration

class ConstantExpressionsInterpreter extends XbaseInterpreter {
	
	@Property CompilationUnitImpl compilationUnit
	
	dispatch protected def doEvaluate(XAnnotation literal, IEvaluationContext context, CancelIndicator indicator) {
		getCompilationUnit.toAnnotationReference(literal)
	}
	
	override protected translateJvmTypeToResult(JvmType type) {
		return getCompilationUnit.toType(type)
	}
	
	override protected getJavaType(JvmType type) throws ClassNotFoundException {
		if (type.getQualifiedName() == 'java.lang.Class') {
			return TypeDeclaration
		}
		super.getJavaType(type)
	}
	
}