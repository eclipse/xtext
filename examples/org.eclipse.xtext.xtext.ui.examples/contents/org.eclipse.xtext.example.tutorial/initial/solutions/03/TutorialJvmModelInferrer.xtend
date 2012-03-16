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
		// In the pre-indexing phase, we return the empty class only 
		acceptor.accept(source.toClass("tutorial.Person"))
			// We use the implicit closure parameter 'it'. Its type inferred from the parameter type of 
			// intializeLater, i.e. JvmDeclaredType
			.initializeLater [
				// So the following line is equivalent to
				//     _jvmTypesBuilder.setDocumentation(it, "...")
				// Note the syntactic sugar here:
				// - _jvmTypesBuilder.setDocumentation(JvmGenericType, String) is on the extension scope, 
				//   i.e. callable as
				//     it.setDocumentation("...")
				// - The receiver 'it' must not be explicitly specified, just like 'this' in Java:
				//     setDocumentation("...")
				// - We use the assignment syntax for setDocumentation("...")
				//     documentation = "..."
				documentation = "A simple entity to describe a Person"
				
				// JmvTypesBuilder.newTypeRef(Class<?>) creates a new type reference 
				createProperty(source, "firstName", newTypeRef(typeof(String)))
				createProperty(source, "lastName", newTypeRef(typeof(String)))
				createProperty(source, "birthday", newTypeRef(typeof(Date)))
		]
	}
	
	
	// We explicitly assign 'it' here to benefit from the syntactic shortcuts.  
	def createProperty(JvmDeclaredType it, EObject source, String name, JvmTypeReference typeRef) {
		
		// Syntactic sugar similar to above. The following line is equivalent to
		//   it.getMembers().add(_jvmtypesBuilder.toField(source, name, typeRef))
		members += source.toField(name, typeRef)
		members += source.toGetter(name, typeRef)
		members += source.toSetter(name, typeRef)
	}
}
