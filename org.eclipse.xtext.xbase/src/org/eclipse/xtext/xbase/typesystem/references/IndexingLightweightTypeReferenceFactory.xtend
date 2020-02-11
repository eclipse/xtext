/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.common.types.JvmComponentType
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImplCustom
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.eclipse.xtext.xtype.impl.XFunctionTypeRefImplCustom

import static org.eclipse.xtext.common.types.TypesPackage.Literals.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

import static extension org.eclipse.xtext.xtype.util.XFunctionTypeRefs.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class IndexingLightweightTypeReferenceFactory extends LightweightTypeReferenceFactory {
	new(ITypeReferenceOwner owner) {
		super(owner)
	}

	new(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		super(owner, keepUnboundWildcards)
	}

	def dispatch JvmType getType(JvmTypeReference it) {
		throw new UnsupportedOperationException(
			'''It is not possible to get a type for the given jvm type reference: «it.class.name»''')
	}

	def dispatch JvmType getType(JvmGenericArrayTypeReferenceImplCustom it) {
		val componentTypeReference = componentType
		if (componentTypeReference === null) {
			return null
		}
		switch componentType : getType(componentTypeReference) {
			JvmComponentType: componentType.arrayType
			default: null
		}
	}

	def dispatch JvmType getType(JvmParameterizedTypeReference it) {
		getType(JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
	}

	def dispatch JvmType getType(XFunctionTypeRef it) {
		getType(XFUNCTION_TYPE_REF__TYPE)
	}

	def dispatch JvmType getType(XFunctionTypeRefImplCustom it) {
		val uri = computeTypeUri(procedure, paramTypes.size)
		eResource.resourceSet.getEObject(uri, true) as JvmType
	}

	def isProcedure(XFunctionTypeRefImplCustom it) {
		val returnType = returnType
		if (returnType === null)
			return true;
		val type = getType(returnType);
		if (type === null)
			return false;
		if (type.eIsProxy)
			return false;
		if (type instanceof JvmVoid)
			return true;
		return false;
	}

	def JvmType getType(EObject it, EReference reference) {
		switch proxy : eGet(reference, false) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				return eResource.resourceSet.getEObject(uri, true) as JvmType
			}
			JvmType: {
				proxy
			}
		}
	}

	override doVisitFunctionTypeReference(XFunctionTypeRef reference) {
		val result = new FunctionTypeReference(owner, getType(reference));
		for (JvmTypeReference parameter : reference.getParamTypes()) {
			val parameterType = visit(wrapIfNecessary(parameter))
			result.addParameterType(parameterType);

			val typeArgument = owner.newWildcardTypeReference()
			typeArgument.setLowerBound(parameterType)
			typeArgument.addUpperBound(javaLangObjectTypeReference)
			result.addTypeArgument(typeArgument);
		}
		if (reference.getReturnType() !== null) {
			val returnType = visit(wrapIfNecessary(reference.getReturnType()))
			result.setReturnType(returnType);
			if (reference instanceof XFunctionTypeRefImplCustom) {
				if (reference.isProcedure) {
					return result
				}
			}
			val typeArgument = owner.newWildcardTypeReference()
			typeArgument.addUpperBound(returnType)
			result.addTypeArgument(typeArgument);
		}
		return result;
	}

	def JvmTypeReference wrapIfNecessary(JvmTypeReference reference) {
		if (reference === null) {
			return null
		}
		val type = getType(reference)
		reference.wrapIfNecessary(type)
	}

	protected def getJavaLangObjectTypeReference() {
		return owner.newReferenceToObject
	}
	
}
