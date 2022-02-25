/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.PrimitiveType
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator

class TypeReferenceProviderImpl implements TypeReferenceProvider {
	
	extension CompilationUnitImpl compilationUnit
	
	new (CompilationUnitImpl compilationUnit) {
		this.compilationUnit = compilationUnit
	}
	
	override getAnyType() {
		toTypeReference(typeReferences.createAnyTypeReference(xtendFile))
	}
	
	override getList(TypeReference param) {
		newTypeReference("java.util.List", param)
	}
	
	override getObject() {
		toTypeReference(createTypeRef(typeReferences.findDeclaredType(Object, xtendFile)))
	}
	
	override getPrimitiveBoolean() {
		newTypeReference("boolean")
	}
	
	override getPrimitiveByte() {
		newTypeReference("byte")
	}
	
	override getPrimitiveChar() {
		newTypeReference("char")
	}
	
	override getPrimitiveDouble() {
		newTypeReference("double")
	}
	
	override getPrimitiveFloat() {
		newTypeReference("float")
	}
	
	override getPrimitiveInt() {
		newTypeReference("int")
	}
	
	override getPrimitiveLong() {
		newTypeReference("long")
	}
	
	override getPrimitiveShort() {
		newTypeReference("short")
	}
	
	override getPrimitiveVoid() {
		newTypeReference("void")
	}
	
	override getSet(TypeReference param) {
		newTypeReference("java.util.Set", param)
	}
	
	override getString() {
		newTypeReference("java.lang.String")
	}
	
	override newArrayTypeReference(TypeReference componentType) {
		checkCanceled
		toTypeReference(typeReferences.createArrayType(componentType.toJvmTypeReference))
	}
	
	override newTypeReference(String typeName, TypeReference... typeArguments) {
		checkCanceled
		val type = typeReferences.findDeclaredType(typeName, xtendFile)
		if (type === null)
			return null
		toTypeReference(createTypeRef(type, typeArguments.map[toJvmTypeReference] as JvmTypeReference[]))
	}
	
	def createTypeRef(JvmType type, JvmTypeReference... typeArgs) {
		if (type === null) {
			throw new NullPointerException("type")
		}
		val reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.type = type
		for (typeArg : typeArgs) {
			reference.arguments.add(EcoreUtil2.cloneIfContained(typeArg))
		}
		if (type instanceof JvmGenericType) {
			val list = type.typeParameters
			if (!reference.arguments.empty && list.size != reference.arguments.size) {
				throw new IllegalArgumentException(
					"The type " + type.getIdentifier() + " expects " + list.size() + " type arguments, but was " +
						reference.arguments.size + ". Either pass zero arguments (raw type) or the correct number.");
			}
		}
		return reference
	}
	
	override newTypeReference(Type typeDeclaration, TypeReference... typeArguments) {
		checkCanceled
		val type = switch typeDeclaration {
			JvmTypeDeclarationImpl<? extends JvmDeclaredType> : {
				typeDeclaration.delegate
			}
			XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> : {
				jvmModelAssociations.getInferredType(typeDeclaration.delegate)
			}
			JvmTypeParameterDeclarationImpl : {
				typeDeclaration.delegate
			}
			PrimitiveTypeImpl : {
				return switch typeDeclaration.kind {
					case PrimitiveType.Kind.BOOLEAN : primitiveBoolean
					case PrimitiveType.Kind.BYTE : primitiveByte
					case PrimitiveType.Kind.CHAR : primitiveChar
					case PrimitiveType.Kind.DOUBLE : primitiveDouble
					case PrimitiveType.Kind.FLOAT : primitiveFloat
					case PrimitiveType.Kind.INT : primitiveInt
					case PrimitiveType.Kind.LONG : primitiveLong
					case PrimitiveType.Kind.SHORT : primitiveShort
				}
			}
			VoidTypeImpl : {
				return primitiveVoid
			}
			default : {
				throw new IllegalArgumentException("couldn't construct type reference for type "+typeDeclaration)
			}
		}
		
		if (type === null)
			return null
		toTypeReference(createTypeRef(type, typeArguments.map[toJvmTypeReference] as JvmTypeReference[]))
	}
	
	override newWildcardTypeReference() {
		newWildcardTypeReference(null);
	}
	
	override newWildcardTypeReference(TypeReference upperBound) {
		if (upperBound === null) {
			toTypeReference(typeReferences.wildCard())
		} else {
			toTypeReference(typeReferences.wildCardExtends(upperBound.toJvmTypeReference))
		}
	}
	
	override newWildcardTypeReferenceWithLowerBound(TypeReference lowerBound) {
		if (lowerBound === null) {
			toTypeReference(typeReferences.wildCard())
		} else {
			toTypeReference(typeReferences.wildCardSuper(lowerBound.toJvmTypeReference))
		}
	}
	
	override newTypeReference(Class<? extends Object> clazz, TypeReference... typeArguments) {
		newTypeReference(clazz.name, typeArguments)
	}
	
	override newSelfTypeReference(Type typeDeclaration) {
		if (typeDeclaration instanceof TypeParameterDeclarator) {
			newTypeReference(typeDeclaration, typeDeclaration.typeParameters.map[newTypeReference])
		} else {
			newTypeReference(typeDeclaration)
		}
	}
	
}