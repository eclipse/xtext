package org.eclipse.xtext.example.tutorial.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.example.tutorial.tutorial.Entity
import org.eclipse.xtext.example.tutorial.tutorial.Property
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * <p>Translates entities to Java classes.</p> 
 */
class TutorialJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder
	
	@Inject extension IQualifiedNameProvider 
	
	def dispatch infer(Entity entity, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		// the acceptor can accept any number of Java classes.
		// the full initialization of the inferred Java class is done in a second step.
		acceptor.accept(entity.toClass(entity.fullyQualifiedName)).initializeLater [
			// first we copy over the documentation
			it.documentation = entity.documentation
			// Iterate over all features and proper JavaBeans properties.
			for(feature: entity.features)
				it.addJavaBeansProperty(feature)
		]
	}

	/**
	 * Adds a field, a setter and a getter according to JavaBeans conventions for the given property. 
	 */	
	def addJavaBeansProperty(JvmDeclaredType javaClass, Property property) {
		javaClass.members += property.toField(property.name, property.type) [
			it.documentation = property.documentation
		]
		javaClass.members += property.toGetter(property.name, property.type)
		javaClass.members += property.toSetter(property.name, property.type)
	}
	
}
