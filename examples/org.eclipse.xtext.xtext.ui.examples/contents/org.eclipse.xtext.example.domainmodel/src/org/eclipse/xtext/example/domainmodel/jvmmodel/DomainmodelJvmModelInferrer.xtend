/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.jvmmodel

import org.eclipse.xtext.example.domainmodel.domainmodel.*
import org.eclipse.xtext.example.domainmodel.*
import org.eclipse.xtext.xbase.jvmmodel.*
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
	
	@Inject extension DomainmodelExtensions

	override List<JvmDeclaredType> inferJvmModel(EObject sourceObject) {
		sourceObject.disassociate
		transform( sourceObject ).toList
	}
	
	dispatch Iterable<JvmDeclaredType> transform(DomainModel model) {
		model.elements.map(e | transform(e)).flatten
	}
	 
	dispatch Iterable<JvmDeclaredType> transform(PackageDeclaration packageDecl) {
		packageDecl.elements.map(e | transform(e)).flatten
	}

	dispatch Iterable<JvmDeclaredType> transform(Entity entity) {
		val jvmClass = typesFactory.createJvmGenericType 
		jvmClass.simpleName = entity.name
		jvmClass.packageName = entity.packageName
		entity.associatePrimary(jvmClass)
		jvmClass.setPublic
		for(f : entity.features) {
			transform(f, jvmClass)
		} 
		newArrayList(jvmClass as JvmDeclaredType) 	 
	}
	
	dispatch Iterable<JvmDeclaredType> transform(Import importDecl) {
		emptyList
	}
	
	dispatch void transform(Property property, JvmGenericType type) {
		val jvmField = typesFactory.createJvmField
		jvmField.simpleName = property.name
		jvmField.type = cloneWithProxies(property.type)
		jvmField.setPrivate
		type.members += jvmField
		property.associatePrimary(jvmField)
		
		val jvmGetter = typesFactory.createJvmOperation
		jvmGetter.simpleName = "get" + property.name.toFirstUpper
		jvmGetter.returnType = cloneWithProxies(property.type)
		jvmGetter.setPublic
		type.members += jvmGetter
		property.associatePrimary(jvmGetter)
		
		val jvmSetter = typesFactory.createJvmOperation
		jvmSetter.simpleName = "set" + property.name.toFirstUpper
		val parameter = typesFactory.createJvmFormalParameter
		parameter.name = property.name.toFirstUpper
		parameter.parameterType = cloneWithProxies(property.type)
		jvmSetter.setPublic
		jvmSetter.parameters += parameter
		type.members += jvmSetter
		property.associatePrimary(jvmSetter)
	}
	
	dispatch void transform(Operation operation, JvmGenericType type) {
		val jvmOperation = typesFactory.createJvmOperation
		jvmOperation.simpleName = operation.name
		jvmOperation.returnType = cloneWithProxies(operation.type)
		jvmOperation.parameters.addAll(operation.params.map(p|cloneWithProxies(p))) 
		jvmOperation.setPublic
		type.members += jvmOperation
		operation.associatePrimary(jvmOperation)
	}
	 
}
