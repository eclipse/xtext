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
				// Features now can be Properties or Operations. 
				// We use dynamic dispatch to make the distinction at runtime.
				createFeature(feature)
		]
	}
	
	// Dispatch case method for a Property.
	def dispatch createFeature(JvmDeclaredType it, Property source) {
		val name = source.name
		val typeRef = source.type
		members += source.toField(name, typeRef) [
			documentation = source.documentation
		]
		members += source.toGetter(name, typeRef)
		members += source.toSetter(name, typeRef)
	}
	
	// Dispatch case method for an Operation.
	def dispatch createFeature(JvmDeclaredType it, Operation source) {
		members += source.toMethod(source.name, source.type) [
			documentation = source.documentation
			// We could have used a for-loop here. Here are some more features of Xtend
			// - the operator_add (+=) can also take an Iterable as second parameter. In this case
			//   it maps to Java's addAll().
			// - the higher-order function map, applies a closure to all elements of an Iterable 
			//   and returns the results as an Iterable.
			parameters += source.params.map[toParameter(name, parameterType)]
			body = source.body
		]
	}
	
}
