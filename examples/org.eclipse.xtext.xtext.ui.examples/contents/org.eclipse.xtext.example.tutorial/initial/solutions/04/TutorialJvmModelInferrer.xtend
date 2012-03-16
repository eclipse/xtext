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
		// The qualified name provider by default concatenates the names of all eContainers using 
		// '.' as separator.
		acceptor.accept(source.toClass(source.fullyQualifiedName))
			.initializeLater [
			documentation = source.documentation
			// Iterate over all features of 'it'.
			for(feature: source.features)
				createProperty(feature, feature.name, feature.type)
		]
	}
	
	def createProperty(JvmDeclaredType it, EObject source, String name, JvmTypeReference typeRef) {
		// The last parameter of the method 
		//   JvmTypesBuilder.toField(JvmDeclaredType, String, JvmTypeRef, Procedure1<JvmField>) 
		// is a closure for initializing the newly created element. 
		members += source.toField(name, typeRef) [
			// JvmTypesBuilder.getDocumentation(EObject) retrieves the documentation specified as 
			// a comment preceding the element, similar to JavaDoc. 
			documentation = source.documentation
		]
		members += source.toGetter(name, typeRef)
		members += source.toSetter(name, typeRef)
	}
	
}
