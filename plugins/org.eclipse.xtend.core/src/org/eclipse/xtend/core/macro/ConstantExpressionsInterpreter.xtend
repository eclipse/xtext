package org.eclipse.xtend.core.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter

class ConstantExpressionsInterpreter extends XbaseInterpreter {
	
	@Property CompilationUnitImpl compilationUnit
	
	dispatch protected def doEvaluate(XAnnotation literal, IEvaluationContext context, CancelIndicator indicator) {
		getCompilationUnit.toAnnotationReference(literal)
	}
	
	override protected translateJvmTypeToResult(JvmType type, int arrayDimensions) {
		var resultTypeRef = getCompilationUnit.typeReferenceProvider.newTypeReference(compilationUnit.toType(type))
		for (i:0..<arrayDimensions) {
			resultTypeRef = compilationUnit.typeReferenceProvider.newArrayTypeReference(resultTypeRef)
		}
		return resultTypeRef
	}
	
	override protected getJavaType(JvmType type) throws ClassNotFoundException {
		if (type.getQualifiedName() == 'java.lang.Class') {
			return TypeReference
		}
		if (type instanceof JvmEnumerationType) {
			return EnumerationValueDeclaration
		}
		super.getJavaType(type)
	}
	
	dispatch protected override doEvaluate(XMemberFeatureCall featureCall, IEvaluationContext context, CancelIndicator indicator) {
		switch f : featureCall.feature {
			JvmEnumerationLiteral : compilationUnit.toNamedElement(f)
			default : super._doEvaluate(featureCall, context, indicator)  
		}
	}
	
}