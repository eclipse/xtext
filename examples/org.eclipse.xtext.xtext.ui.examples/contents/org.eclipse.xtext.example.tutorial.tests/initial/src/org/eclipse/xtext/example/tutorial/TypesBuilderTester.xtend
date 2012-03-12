package org.eclipse.xtext.example.tutorial

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.XbaseStandaloneSetup
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import java.io.Serializable

class TypesBuilderTester implements IJvmModelInferrer {
	
	@Inject MockSetup mock
	@Inject extension JvmTypesBuilder
	
	override infer(EObject it, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		acceptor.accept(toClass("EmptyClass")).initializeLater [
			superTypes += newTypeRef(typeof(Serializable))
		]
	}
	
	def run() {
		mock.use(this)
	}
	
	def static void main(String[] args) {
		val injector = new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration
		injector.getInstance(typeof(TypesBuilderTester)).run
	}
	
}