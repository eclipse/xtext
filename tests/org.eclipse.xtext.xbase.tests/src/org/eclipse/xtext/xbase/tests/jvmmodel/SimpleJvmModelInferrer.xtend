package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.XExpression

class SimpleJvmModelInferrer implements IJvmModelInferrer {
	
	@Inject extension JvmTypesBuilder
	@Inject TypeReferences references
	
	override void infer(EObject e, IAcceptor<JvmDeclaredType> acceptor, boolean prelinkingPhase) {
		acceptor.accept((e as XExpression).toClass("Test") [
			members += e.toMethod("doStuff", references.getTypeForName(typeof(String), e)) [
				parameters += e.toParameter("s", references.getTypeForName(typeof(String), e))
				setBody(e as XExpression)
			]
		])
	}
}