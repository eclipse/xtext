/** 
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

/** 
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class ReferencedInvalidTypeFinder extends TypeReferenceVisitorWithResult<LightweightTypeReference> {

	@Inject CommonTypeComputationServices services

	def LightweightTypeReference findReferencedInvalidType(JvmIdentifiableElement element) {
		return element.internalFindReferencedInvalidType
	}

	def protected dispatch LightweightTypeReference internalFindReferencedInvalidType(JvmIdentifiableElement field) {
		return null
	}
	
	def protected dispatch LightweightTypeReference internalFindReferencedInvalidType(Void field) {
		return null
	}

	def protected dispatch LightweightTypeReference internalFindReferencedInvalidType(JvmField field) {
		val type = field.type.toLightweightTypeReference
		if (type.primitiveVoid)
			return type
		
		return type.findUnknownType
	}

	def protected dispatch LightweightTypeReference internalFindReferencedInvalidType(JvmOperation operation) {
		val unknownType = operation.returnType.findUnknownType 
		if(unknownType !== null)
			return unknownType
		
		return _internalFindReferencedInvalidType(operation as JvmExecutable)
	}

	def protected dispatch LightweightTypeReference internalFindReferencedInvalidType(JvmExecutable executable) {
		for (typeReference : executable.typeParameters.map[constraints].flatten.map[typeReference]) {
			val unknownType = typeReference.findUnknownType
			if(unknownType !== null)
				return unknownType
		}
		for (parameterType : executable.parameters.map[parameterType.toLightweightTypeReference]) {
			if(parameterType.primitiveVoid)
				return parameterType
			
			val unknownType = parameterType.findUnknownType
			if(unknownType !== null)
				return unknownType
		}
		for (exception : executable.exceptions) {
			val unknownType = exception.findUnknownType
			if(unknownType !== null)
				return unknownType
		}
		return null
	}

	def protected LightweightTypeReference findUnknownType(JvmTypeReference reference) {
		return reference.toLightweightTypeReference.findUnknownType
	}

	def protected LightweightTypeReference findUnknownType(LightweightTypeReference type) {
		return type.accept(this)
	}

	override protected LightweightTypeReference doVisitTypeReference(LightweightTypeReference reference) {
		if(reference.unknown)
			return reference

		return null
	}

	override protected LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference) {
		return reference.componentType.accept(this)
	}

	override protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference) {
		val unknownType = reference.upperBounds.visit
		if(unknownType !== null)
			return unknownType

		val lowerBound = reference.lowerBound
		if(lowerBound !== null)
			return lowerBound.accept(this)

		return null
	}

	override protected LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		return reference.typeArguments.visit
	}

	override protected LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference) {
		return reference.multiTypeComponents.visit
	}

	def protected LightweightTypeReference visit(List<LightweightTypeReference> references) {
		return references.map[accept(this)].filterNull.head
	}

	def protected LightweightTypeReference toLightweightTypeReference(JvmTypeReference typeRef) {
		return new StandardTypeReferenceOwner(services, typeRef).toLightweightTypeReference(typeRef)
	}
}
