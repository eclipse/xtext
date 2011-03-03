package org.eclipse.xtext.example.domainmodel.jvmmodel

import org.eclipse.xtext.example.domainmodel.domainmodel.*
import org.eclipse.xtext.xbase.linking.jvm.*
import org.eclipse.emf.ecore.*
import org.eclipse.xtext.common.types.*
import org.eclipse.xtext.common.types.util.*
import static org.eclipse.xtext.common.types.*
import java.util.*
import static org.eclipse.xtext.EcoreUtil2.*

class DomainmodelJvmModelInferrer implements IJvmModelInferrer {

	@Inject TypesFactory
	
	@Inject extension IJvmModelAssociator
		
	@Inject extension JvmVisibilityExtension
	
	inferJvmModel(EObject sourceObject) {
		transform(sourceObject).toList()		
	}	
	
	dispatch Iterable<EObject> transform(DomainModel model) {
		model.elements.map(e|transform(e)).flatten()
	}
	 
	dispatch Iterable<EObject> transform(PackageDeclaration packageDecl) {
		packageDecl.elements.map(e|transform(e)).flatten()
	}

	dispatch Iterable<EObject> transform(Entity entity) {
		val jvmClass = typesFactory.createJvmGenericType 
		jvmClass.simpleName = entity.name
		jvmClass.packageName = entity.packageName()
		entity.associatePrimary(jvmClass)
		jvmClass.setPublic()
		entity.features.forEach(feature|transform(feature, jvmClass))
		newArrayList(jvmClass as EObject) 	 
	}
	
	dispatch Iterable<EObject> transform(Import importDecl) {
		return newArrayList()
	}
	
	dispatch Iterable<EObject> transform(Void nothing) {
		return newArrayList()
	}
	
	dispatch void transform(Property property, JvmGenericType type) {
		val jvmField = typesFactory.createJvmField
		jvmField.simpleName = property.name
		jvmField.type = cloneWithProxies(property.type)
		jvmField.setPrivate()
		type.members += jvmField
		property.associatePrimary(jvmField)
		
		val jvmGetter = typesFactory.createJvmOperation
		jvmGetter.simpleName = "get" + property.name.toFirstUpper()
		jvmGetter.returnType = cloneWithProxies(property.type)
		jvmGetter.setPublic()
		type.members += jvmGetter
		property.associatePrimary(jvmGetter)
		
		val jvmSetter = typesFactory.createJvmOperation
		jvmSetter.simpleName = "set" + property.name.toFirstUpper()
		val parameter = typesFactory.createJvmFormalParameter
		parameter.name = property.name.toFirstUpper()
		parameter.parameterType = cloneWithProxies(property.type)
		jvmSetter.setPublic()
		jvmSetter.parameters += parameter
		type.members += jvmSetter
		property.associatePrimary(jvmSetter)
	}
	
	dispatch void transform(Operation operation, JvmGenericType type) {
		val jvmOperation = typesFactory.createJvmOperation
		jvmOperation.simpleName = operation.name
		jvmOperation.returnType = cloneWithProxies(operation.type)
		jvmOperation.parameters.addAll(operation.params.map(p|cloneWithProxies(p))) 
		jvmOperation.setPublic()
		type.members += jvmOperation
		operation.associatePrimary(jvmOperation)
	}
	 
	String packageName(EObject o) {
		switch(o) {
			Entity: o.eContainer.packageName()
			PackageDeclaration: concatPath(o.eContainer.packageName(), o.name)
			default: null
		}  
	}
	 
	concatPath(String x, String y) {
		if (x==null) y else x + "." + y
	}
	 
}
