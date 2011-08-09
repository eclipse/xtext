/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.jvmmodel

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.example.domainmodel.DomainmodelExtensions
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Import
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer

import static org.eclipse.xtext.EcoreUtil2.*

class DomainmodelJvmModelInferrer implements IJvmModelInferrer {

	@Inject TypesFactory typesFactory
	
	@Inject extension IJvmModelAssociator jvmModelAssociator
		
	@Inject extension DomainmodelExtensions domainmodelExtensions

	override List<JvmDeclaredType> inferJvmModel(EObject sourceObject) {
		sourceObject.disassociate
		transform( sourceObject ).toList
	}
	
	def dispatch Iterable<JvmDeclaredType> transform(DomainModel model) {
		model.elements.map(e | transform(e)).flatten
	}
	 
	def dispatch Iterable<JvmDeclaredType> transform(PackageDeclaration packageDecl) {
		packageDecl.elements.map(e | transform(e)).flatten
	}

	def dispatch Iterable<JvmDeclaredType> transform(Entity entity) {
		val jvmClass = typesFactory.createJvmGenericType 
		jvmClass.simpleName = entity.name
		jvmClass.packageName = entity.packageName
		entity.associatePrimary(jvmClass)
		jvmClass.visibility = JvmVisibility::PUBLIC
		if (entity.superType != null)
			jvmClass.superTypes += cloneWithProxies(entity.superType)
		for(f : entity.features) {
			transform(f, jvmClass)
		} 
		newArrayList(jvmClass as JvmDeclaredType) 	 
	}
	
	def dispatch Iterable<JvmDeclaredType> transform(Import importDecl) {
		emptyList
	}
	
	def dispatch void transform(Property property, JvmGenericType type) {
		val jvmField = typesFactory.createJvmField
		jvmField.simpleName = property.name
		jvmField.type = cloneWithProxies(property.type)
		jvmField.visibility = JvmVisibility::PRIVATE
		type.members += jvmField
		property.associatePrimary(jvmField)
		
		val jvmGetter = typesFactory.createJvmOperation
		jvmGetter.simpleName = "get" + property.name.toFirstUpper
		jvmGetter.returnType = cloneWithProxies(property.type)
		jvmGetter.visibility = JvmVisibility::PUBLIC
		type.members += jvmGetter
		property.associatePrimary(jvmGetter)
		
		val jvmSetter = typesFactory.createJvmOperation
		jvmSetter.simpleName = "set" + property.name.toFirstUpper
		val parameter = typesFactory.createJvmFormalParameter
		parameter.name = property.name.toFirstUpper
		parameter.parameterType = cloneWithProxies(property.type)
		jvmSetter.visibility = JvmVisibility::PUBLIC
		jvmSetter.parameters += parameter
		type.members += jvmSetter
		property.associatePrimary(jvmSetter)
	}
	
	def dispatch void transform(Operation operation, JvmGenericType type) {
		val jvmOperation = typesFactory.createJvmOperation
		jvmOperation.simpleName = operation.name
		jvmOperation.returnType = cloneWithProxies(operation.type)
		jvmOperation.parameters.addAll(operation.params.map(p|cloneWithProxies(p))) 
		jvmOperation.visibility = JvmVisibility::PUBLIC
		type.members += jvmOperation
		operation.associatePrimary(jvmOperation)
	}
	 
}
