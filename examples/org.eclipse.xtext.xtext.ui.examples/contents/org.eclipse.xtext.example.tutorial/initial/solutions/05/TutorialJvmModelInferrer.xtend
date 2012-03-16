package org.eclipse.xtext.example.tutorial.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.example.tutorial.tutorial.Entity
import org.eclipse.xtext.example.tutorial.tutorial.Operation
import org.eclipse.xtext.example.tutorial.tutorial.Property
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
				createFeature(feature)
		]
	}
	
	def dispatch createFeature(JvmDeclaredType it, Property source) {
		val name = source.name
		val typeRef = source.type
		members += source.toField(name, typeRef) [
			documentation = source.documentation
		]
		members += source.toGetter(name, typeRef)
		members += source.toSetter(name, typeRef)
	}
	
	def dispatch createFeature(JvmDeclaredType it, Operation source) {
		members += source.toMethod(source.name, source.type) [
			documentation = source.documentation
			parameters += source.params.map[toParameter(name, parameterType)]
			body = source.body
		]
	}
	
}
