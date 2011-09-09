package org.eclipse.xtext.example.domainmodel.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity

class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder

	def dispatch infer(Entity e, IAcceptor<JvmDeclaredType> acceptor) {
		acceptor.accept(
			e.toClazz( e.name ) [
				
				if (e.superType != null)
					superTypes += e.superType.cloneWithProxies
				
				for ( f : e.features ) {
					switch f {
				
						Property : {
							members += f.toField(f.name, f.type)
							members += f.toGetter(f.name, f.type)
							members += f.toSetter(f.name, f.type)
						}
				
						Operation : {
							members += f.toMethod(f.name, f.type) [
								for (p : f.params) {
									parameters.add(p.toParameter(p.name, p.parameterType))
								}
							]
						}
					}
				}
			]
		)
	}	
}