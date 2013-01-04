/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.type.TypeReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnyTypeReference
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUnknownTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import javax.inject.Inject
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

class CompilationUnitImpl implements CompilationUnit {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getPackageName() {
		xtendFile.getPackage()
	}
	
	override getSourceTypeDeclarations() {
		xtendFile.xtendTypes.map[toTypeDeclaration(it)]
	}
	
	override getGeneratedTypeDeclarations() {
		xtendFile.eResource.contents.filter(typeof(JvmDeclaredType)).map[toTypeDeclaration(it)].toList
	}
	
	@Property XtendFile xtendFile
	@Inject TypeReferenceSerializer serializer 

	Map<EObject, Object> identityCache = newHashMap

	def private <IN extends EObject, OUT> OUT get(IN in, (IN)=>OUT provider) {
		if (identityCache.containsKey(in))
			return identityCache.get(in) as OUT
		val result = provider.apply(in)
		identityCache.put(in, result)
		return result
	}

	def Visibility toVisibility(JvmVisibility delegate) {
		switch delegate {
			case JvmVisibility::DEFAULT: Visibility::DEFAULT
			case JvmVisibility::PRIVATE: Visibility::PRIVATE
			case JvmVisibility::PROTECTED: Visibility::PROTECTED
			case JvmVisibility::PUBLIC: Visibility::PUBLIC
		}
	}
	
	def Type toType(JvmType delegate) {
		get(delegate) [
			switch delegate {
				JvmDeclaredType: toTypeDeclaration(delegate)
				JvmTypeParameter: toTypeParameterDeclaration(delegate)
				JvmVoid: new VoidTypeImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				JvmPrimitiveType: new PrimitiveTypeImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
			}
		]
	}

	def TypeDeclaration toTypeDeclaration(JvmDeclaredType delegate) {
		get(delegate) [
			switch delegate {
				JvmGenericType case delegate.isInterface:
					new InterfaceDeclarationJavaImpl => [
						it.delegate = delegate 
						it.compilationUnit = this
					]
				JvmGenericType:
					new ClassDeclarationJavaImpl => [
						it.delegate = delegate 
						it.compilationUnit = this
					]
				JvmAnnotationType:
					null //TODO
				JvmEnumerationType:
					null //TODO
			}
		]
	}

	def TypeParameterDeclaration toTypeParameterDeclaration(JvmTypeParameter delegate) {
		get(delegate) [
			new TypeParameterDeclartionImpl => [
				it.delegate = delegate 
				it.compilationUnit = this
			]
		]
	}

	def MemberDeclaration toMemberDeclaration(JvmMember delegate) {
		get(delegate) [
			switch delegate {
				JvmDeclaredType : toTypeDeclaration(delegate)
				JvmOperation : {
					// TODO handle annotation properties					
					new MethodDeclarationJavaImpl => [
						it.delegate = delegate 
						it.compilationUnit = this
					]
				} 
				JvmConstructor: new ConstructorDeclarationJavaImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				JvmField : new FieldDeclarationJavaImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				//TODO JvmEnumerationLiteral
			}
		]
	}

	def TypeReference toTypeReference(JvmTypeReference delegate) {
		get(delegate) [
			switch delegate {
				JvmParameterizedTypeReference: new ParameterizedTypeReferenceImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
					it.serializer = this.serializer
				]
				JvmWildcardTypeReference: new WildCardTypeReferenceImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
					it.serializer = this.serializer
				]
				JvmAnyTypeReference: new AnyTypeReferenceImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
					it.serializer = this.serializer
				]
				JvmUnknownTypeReference: new UnknownTypeReferenceImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
					it.serializer = this.serializer
				]
				JvmGenericArrayTypeReference: new ArrayTypeReferenceImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
					it.serializer = this.serializer
				]
			}
		]
	}

	def TypeDeclaration toTypeDeclaration(XtendTypeDeclaration delegate) {
		get(delegate) [
			switch (delegate) {
				XtendClass : new ClassDeclarationXtendImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				//TODO XtendAnnotationType 
			}
		]
	}

	def MemberDeclaration toMemberDeclaration(XtendMember delegate) {
		get(delegate) [
			switch (delegate) {
				XtendTypeDeclaration : toTypeDeclaration(delegate)
				XtendFunction : new MethodDeclarationXtendImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				XtendConstructor : new ConstructorDeclarationXtendImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				XtendField : new FieldDeclarationXtendImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
			}
		]
	}
}
