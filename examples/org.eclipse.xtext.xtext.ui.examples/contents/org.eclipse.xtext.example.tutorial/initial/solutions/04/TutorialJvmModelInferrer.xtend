package org.eclipse.xtext.example.tutorial.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.example.tutorial.tutorial.Entity
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class TutorialJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder
	
	@Inject extension IQualifiedNameProvider 
	
	def dispatch infer(Entity source, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		acceptor.accept(source.toClass(source.fullyQualifiedName)).initializeLater [
			documentation = source.documentation
			for(feature: source.features)
				createProperty(feature, feature.name, feature.type)
		]
	}
	
	def createProperty(JvmDeclaredType it, EObject source, String name, JvmTypeReference typeRef) {
		members += source.toField(name, typeRef) [
			documentation = source.documentation
		]
		members += source.toGetter(name, typeRef)
		members += source.toSetter(name, typeRef)
	}
	
}
