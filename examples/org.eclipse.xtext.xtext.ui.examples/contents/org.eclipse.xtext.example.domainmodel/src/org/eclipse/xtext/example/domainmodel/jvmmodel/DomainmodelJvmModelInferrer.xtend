package org.eclipse.xtext.example.domainmodel.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider

	def dispatch infer(Entity entity, extension IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		accept(entity.toClass( entity.fullyQualifiedName )) [
			documentation = entity.documentation
			if (entity.superType != null)
				superTypes += entity.superType.cloneWithProxies
			
			// let's add a default constructor
			members += entity.toConstructor []
			
			// and one which can be called with a lambda for initialization.
			val procedureType = typeRef(Procedure1, typeRef(it)) /* Procedure<MyEntity> */ 
			members += entity.toConstructor [
				parameters += entity.toParameter("initializer", procedureType)
				// here we implement the body using black box Java code.
				body = '''
					initializer.apply(this);
				'''
			]
			
			// now let's go over the features
			for ( f : entity.features ) {
				switch f {
			
					// for properties we create a field, a getter and a setter
					Property : {
						val field = f.toField(f.name, f.type)
						members += field
						members += f.toGetter(f.name, f.type)
						members += f.toSetter(f.name, f.type)
					}
			
					// operations are mapped to methods
					Operation : {
						members += f.toMethod(f.name, f.type ?: inferredType) [
							documentation = f.documentation
							for (p : f.params) {
								parameters += p.toParameter(p.name, p.parameterType)
							}
							// here the body is implemented using a user expression.
							// Note that by doing this we set the expression into the context of this method, 
							// The parameters, 'this' and all the members of this method will be visible for the expression. 
							body = f.body
						]
					}
				}
			}
			
			// finally we want to have a nice toString methods.
			members += entity.toToStringMethod(it)
		]
	}
	
}