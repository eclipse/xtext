/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import java.util.Map
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.macro.declaration.GeneratedClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceTypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.type.TypeReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

class CompilationUnitImpl implements CompilationUnit {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getPackageName() {
		xtendFile.getPackage()
	}
	
	override getSourceTypeDeclarations() {
		xtendFile.xtendTypes.map[toSourceTypeDeclaration(it)]
	}
	
	override getSourceClassDeclarations() {
		sourceTypeDeclarations.filter(typeof(SourceClassDeclaration)).toList
	}
	
	override getGeneratedTypeDeclarations() {
		xtendFile.eResource.contents.filter(typeof(JvmDeclaredType)).map[toTypeDeclaration(it) as GeneratedTypeDeclaration].toList
	}
	
	override getGeneratedClassDeclarations() {
		generatedTypeDeclarations.filter(typeof(GeneratedClassDeclaration)).toList
	}
	
	@Property XtendFile xtendFile
	@Inject CommonTypeComputationServices services;
	Map<EObject, Object> identityCache = newHashMap
	OwnedConverter typeRefConverter
	
	def void setXtendFile(XtendFile xtendFile) {
		this._xtendFile = xtendFile
		this.typeRefConverter = new OwnedConverter(new StandardTypeReferenceOwner(services, xtendFile.eResource.resourceSet))
	} 

	def private <IN extends EObject, OUT> OUT get(IN in, (IN)=>OUT provider) {
		if (identityCache.containsKey(in))
			return identityCache.get(in) as OUT
		val result = provider.apply(in)
		identityCache.put(in, result)
		return result
	}
	
	def private isGenerated(JvmIdentifiableElement element) {
		element.eResource == xtendFile.eResource
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
					if (delegate.isGenerated) {
						//TODO
					} else {
						new InterfaceDeclarationJavaImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					}
				JvmGenericType:
					if (delegate.isGenerated) {
						new GeneratedClassDeclarationImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					} else {
						new ClassDeclarationJavaImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					}
				JvmAnnotationType:
					null //TODO
				JvmEnumerationType:
					null //TODO
			}
		]
	}

	def TypeParameterDeclaration toTypeParameterDeclaration(JvmTypeParameter delegate) {
		get(delegate) [
			if (delegate.isGenerated) {
				new GeneratedTypeParameterDeclarationImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
			} else {
				new TypeParameterDeclarationImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
			}
		]
	}
	
	def ParameterDeclaration toParameterDeclaration(JvmFormalParameter delegate) {
		get(delegate) [
			if (delegate.isGenerated) {
				new GeneratedParameterDeclarationImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
			} else {
				new ParameterDeclarationJavaImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
			}
		]
	}

	def MemberDeclaration toMemberDeclaration(JvmMember delegate) {
		get(delegate) [
			switch delegate {
				JvmDeclaredType : toTypeDeclaration(delegate)
				JvmOperation : {
					// TODO handle annotation properties	
					(if (delegate.isGenerated) {
						new GeneratedMethodDeclarationImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					} else {
						new MethodDeclarationJavaImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					}) as MemberDeclaration	//TODO bug in Xtend
				} 
				JvmConstructor: 
					(if (delegate.isGenerated) {
						new GeneratedConstructorDeclarationImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					} else {
						new ConstructorDeclarationJavaImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					}) as MemberDeclaration //TODO bug in Xtend
				JvmField :
					(if (delegate.isGenerated) {
						new GeneratedFieldDeclarationImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					} else {
						new FieldDeclarationJavaImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					}) as MemberDeclaration //TODO bug in Xtend
				//TODO JvmEnumerationLiteral
			}
		]
	}

	def TypeReference toTypeReference(JvmTypeReference delegate) {
		/*
		 * Nested JvmTypeReference's identity will not be preserved
		 * i.e. given 'List<String> myField' we will get the same TypeReference instance when asking
		 * the field for its type. But when asking for type arguments on that TypeReference we will 
		 * get a new instance representing 'String' each time.
		 */
		if (delegate == null)
			return null
		get(delegate) [
			toTypeReference(typeRefConverter.toLightweightReference(delegate))
		]
	}
	
	def TypeReference toTypeReference(LightweightTypeReference delegate) {
		if (delegate == null)
			return null
		new TypeReferenceImpl => [
			it.delegate = delegate 
			it.compilationUnit = this
		]
	}

	def SourceTypeDeclaration toSourceTypeDeclaration(XtendTypeDeclaration delegate) {
		get(delegate) [
			switch (delegate) {
				XtendClass : new SourceClassDeclarationImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				//TODO XtendAnnotationType 
			}
		]
	}

	def SourceMemberDeclaration toSourceMemberDeclaration(XtendMember delegate) {
		get(delegate) [
			switch (delegate) {
				XtendTypeDeclaration : toSourceTypeDeclaration(delegate)
				XtendFunction : new SourceMethodDeclarationImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				XtendConstructor : new SourceConstructorDeclarationImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
				XtendField : new SourceFieldDeclarationImpl => [
					it.delegate = delegate 
					it.compilationUnit = this
				]
			}
		]
	}
	
	def SourceParameterDeclaration toSourceParameterDeclaration(XtendParameter delegate) {
		get(delegate) [
			new SourceParameterDeclarationImpl => [
				it.delegate = delegate 
				it.compilationUnit = this
			]
		]
	}
	
	def SourceTypeParameterDeclaration toSourceTypeParameterDeclaration(JvmTypeParameter delegate) {
		get(delegate) [
			new SourceTypeParameterDeclarationImpl => [
				it.delegate = delegate 
				it.compilationUnit = this
			]
		]
	}
}
