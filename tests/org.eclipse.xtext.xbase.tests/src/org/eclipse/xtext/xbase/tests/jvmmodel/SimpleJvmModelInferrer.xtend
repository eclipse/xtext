package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.common.types.util.TypeReferences

class SimpleJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder
	@Inject TypeReferences references
	
	def dispatch void infer(XExpression e, IAcceptor<JvmDeclaredType> acceptor, boolean prelinkingPhase) {
		acceptor.accept(e.toClass("Test") [
			members += e.toMethod("doStuff", references.getTypeForName(typeof(String), e)) [
				parameters += e.toParameter("s", references.getTypeForName(typeof(String), e))
				e.associate(it)
			]
			null as Void
		])
	}
}