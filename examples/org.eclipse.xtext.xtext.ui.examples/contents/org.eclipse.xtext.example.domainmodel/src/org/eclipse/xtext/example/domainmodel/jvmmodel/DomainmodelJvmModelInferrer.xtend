package org.eclipse.xtext.example.domainmodel.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.example.domainmodel.domainmodel.Visibility
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder

	def dispatch infer(Entity e, IAcceptor<JvmDeclaredType> acceptor, boolean prelinkingPhase) {
		acceptor.accept(
			e.toClass( e.fullName ) [
				
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
								visibility = f.visibility.toJvm
								for (p : f.params) {
									parameters.add(p.toParameter(p.name, p.parameterType))
								}
								setBody(f.body)
							]
						}
					}
				}
			]
		)
	}
	
	def String fullName(EObject x) {
		switch x {
			Entity : x.eContainer.fullName + x.name
			PackageDeclaration : x.eContainer.fullName + x.name + "."
			default : ""
		}
	}
	
	def toJvm(Visibility visibility) {
		switch visibility {
			case Visibility::PRIVATE : JvmVisibility::PRIVATE
			case Visibility::PROTECTED : JvmVisibility::PROTECTED
			default : JvmVisibility::PUBLIC
		}
	}
}