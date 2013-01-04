/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.PrimitiveType
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.declaration.VoidType
import org.eclipse.xtend.lib.macro.type.TypeReference
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

abstract class AbstractDeclarationImpl<T> {
	@Property T delegate
	@Property CompilationUnitImpl compilationUnit
}

class TypeReferenceImpl extends AbstractDeclarationImpl<LightweightTypeReference> implements TypeReference {
	
	override getType() {
		return compilationUnit.toType(delegate.type)
	}
	
	override toString() {
		return delegate.toString
	}

	override getActualTypeArguments() {
		delegate.typeArguments.map[compilationUnit.toTypeReference(it)]
	}
	
	override getArrayComponentType() {
		compilationUnit.toTypeReference(delegate.componentType)
	}
	
	override getLowerBound() {
		compilationUnit.toTypeReference(delegate.lowerBoundSubstitute)
	}
	
	override getPrimitiveIfWrapper() {
		compilationUnit.toTypeReference(delegate.primitiveIfWrapperType)
	}
	
	override getUpperBound() {
		compilationUnit.toTypeReference(delegate.upperBoundSubstitute)
	}
	
	override getWrapperIfPrimitive() {
		compilationUnit.toTypeReference(delegate.wrapperTypeIfPrimitive)
	}
	
	override isAnyType() {
		delegate.any
	}
	
	override isArray() {
		delegate.array
	}
	
	override isAssignableFrom(TypeReference typeReference) {
		delegate.isAssignableFrom((typeReference as TypeReferenceImpl).delegate)
	}
	
	override isPrimitive() {
		delegate.primitive
	}
	
	override isPrimitiveVoid() {
		delegate.primitiveVoid
	}
	
	override isWildCard() {
		delegate.wildcard
	}
	
	override isWrapper() {
		delegate.wrapper
	}
	
}

// types

class VoidTypeImpl extends AbstractDeclarationImpl<JvmVoid> implements VoidType {
	
	override getName() {
		'void'
	}
} 

class PrimitiveTypeImpl extends AbstractDeclarationImpl<JvmPrimitiveType> implements PrimitiveType {

	override getKind() {
		switch name {
			case 'boolean' : PrimitiveType$Kind::BOOLEAN
			case 'int' : PrimitiveType$Kind::INT
			case 'char' : PrimitiveType$Kind::CHAR
			case 'double' : PrimitiveType$Kind::DOUBLE
			case 'long' : PrimitiveType$Kind::LONG
			case 'short' : PrimitiveType$Kind::SHORT
			case 'float' : PrimitiveType$Kind::FLOAT
			case 'byte' : PrimitiveType$Kind::BYTE
		}
	}
	
	override getName() {
		delegate.identifier
	}
	
}

class TypeParameterDeclartionImpl extends AbstractDeclarationImpl<JvmTypeParameter> implements TypeParameterDeclaration {
	
	override getUpperBounds() {
		delegate.constraints.filter(typeof(JvmUpperBound)).map[compilationUnit.toTypeReference(typeReference)].toList
	}
	
	override getMembers() {
		emptyList
	}
	
	override getPackageName() {
		null
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getName() {
		delegate.name
	}
	
	override getDeclaringType() {
		//TODO this one might be contained in an Xtend element or a JVM element
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getVisibility() {
		Visibility::PRIVATE
	}
	
}
