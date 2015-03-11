package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

class SimpleJvmModelInferrer implements IJvmModelInferrer {
	
	@Inject extension JvmTypesBuilder
	@Inject TypeReferences references
	
	override void infer(EObject e, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		acceptor.accept((e as XExpression).toClass("Test")) [
			members += e.toMethod("doStuff", references.getTypeForName(typeof(String), e)) [
				parameters += e.toParameter("s", references.getTypeForName(typeof(String), e))
				setBody(e as XExpression)
			]
		]
	}
}