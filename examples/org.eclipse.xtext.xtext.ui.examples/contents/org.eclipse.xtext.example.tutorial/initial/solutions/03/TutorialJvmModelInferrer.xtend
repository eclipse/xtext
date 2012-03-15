package org.eclipse.xtext.example.tutorial.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.common.types.JvmTypeReference
import java.util.Date

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class TutorialJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder
	
	override infer(EObject source, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		acceptor.accept(source.toClass("tutorial.Person")).initializeLater [
			documentation = "A simple entity to describe a Person"
			createProperty(source, "firstName", newTypeRef(typeof(String)))
			createProperty(source, "lastName", newTypeRef(typeof(String)))
			createProperty(source, "birthday", newTypeRef(typeof(Date)))
		]
	}
	
	def createProperty(JvmDeclaredType it, EObject source, String name, JvmTypeReference typeRef) {
		members += source.toField(name, typeRef)
		members += source.toGetter(name, typeRef)
		members += source.toSetter(name, typeRef)
	}
}
