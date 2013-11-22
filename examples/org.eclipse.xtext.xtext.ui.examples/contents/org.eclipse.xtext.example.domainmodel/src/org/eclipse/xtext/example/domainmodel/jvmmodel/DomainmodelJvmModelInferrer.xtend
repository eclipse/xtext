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
import org.eclipse.xtext.common.types.JvmField

class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider

	def dispatch infer(Entity entity, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		acceptor.accept(
			entity.toClass( entity.fullyQualifiedName )
		).initializeLater [
			documentation = entity.documentation
			if (entity.superType != null)
				superTypes += entity.superType.cloneWithProxies
			val procedure = entity.newTypeRef(Procedure1, it.newTypeRef())
			members += entity.toConstructor() []
			members += entity.toConstructor() [
				parameters += entity.toParameter("initializer", procedure)
				body = '''initializer.apply(this);'''
			]
			val fields = <JvmField>newArrayList()
			for ( f : entity.features ) {
				switch f {
			
					Property : {
						val field = f.toField(f.name, f.type)
						fields += field
						members += field
						members += f.toGetter(f.name, f.type)
						members += f.toSetter(f.name, f.type)
					}
			
					Operation : {
						members += f.toMethod(f.name, f.type ?: inferredType) [
							documentation = f.documentation
							for (p : f.params) {
								parameters += p.toParameter(p.name, p.parameterType)
							}
							body = f.body
						]
					}
				}
			}
			members += entity.toToStringMethod(it)
		]
	}
	
}