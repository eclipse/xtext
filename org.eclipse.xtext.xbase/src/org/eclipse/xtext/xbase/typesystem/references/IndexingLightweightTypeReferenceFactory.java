/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImplCustom;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;
import org.eclipse.xtext.xtype.impl.XFunctionTypeRefImplCustom;
import org.eclipse.xtext.xtype.util.XFunctionTypeRefs;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class IndexingLightweightTypeReferenceFactory extends LightweightTypeReferenceFactory {
	public IndexingLightweightTypeReferenceFactory(ITypeReferenceOwner owner) {
		super(owner);
	}

	public IndexingLightweightTypeReferenceFactory(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		super(owner, keepUnboundWildcards);
	}

	protected JvmType _getType(JvmTypeReference it) {
		throw new UnsupportedOperationException(
				"It is not possible to get a type for the given jvm type reference: " + it.getClass().getName());
	}

	protected JvmType _getType(JvmGenericArrayTypeReferenceImplCustom it) {
		JvmTypeReference componentTypeReference = it.getComponentType();
		if (componentTypeReference == null) {
			return null;
		}
		JvmType componentType = getType(componentTypeReference);
		if (componentType instanceof JvmComponentType) {
			return ((JvmComponentType) componentType).getArrayType();
		}
		return null;
	}

	protected JvmType _getType(JvmParameterizedTypeReference it) {
		return getType(it, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
	}

	protected JvmType _getType(XFunctionTypeRef it) {
		return getType(it, XtypePackage.Literals.XFUNCTION_TYPE_REF__TYPE);
	}

	protected JvmType _getType(XFunctionTypeRefImplCustom it) {
		URI uri = XFunctionTypeRefs.computeTypeUri(isProcedure(it), it.getParamTypes().size());
		return (JvmType) it.eResource().getResourceSet().getEObject(uri, true);
	}

	public boolean isProcedure(XFunctionTypeRefImplCustom it) {
		JvmTypeReference returnType = it.getReturnType();
		if (returnType == null) {
			return true;
		}
		JvmType type = getType(returnType);
		if (type == null) {
			return false;
		}
		if (type.eIsProxy()) {
			return false;
		}
		if (type instanceof JvmVoid) {
			return true;
		}
		return false;
	}

	public JvmType getType(EObject it, EReference reference) {
		Object proxy = it.eGet(reference, false);
		if (proxy instanceof EObject) {
			if (((EObject) proxy).eIsProxy()) {
				URI uri = ((InternalEObject) proxy).eProxyURI();
				return (JvmType) it.eResource().getResourceSet().getEObject(uri, true);
			}
		}
		if (proxy instanceof JvmType) {
			return (JvmType) proxy;
		}
		return null;
	}

	@Override
	public LightweightTypeReference doVisitFunctionTypeReference(XFunctionTypeRef reference) {
		FunctionTypeReference result = new FunctionTypeReference(getOwner(), getType(reference));
		for (JvmTypeReference parameter : reference.getParamTypes()) {
			LightweightTypeReference parameterType = visit(wrapIfNecessary(parameter));
			result.addParameterType(parameterType);
			WildcardTypeReference typeArgument = getOwner().newWildcardTypeReference();
			typeArgument.setLowerBound(parameterType);
			typeArgument.addUpperBound(getJavaLangObjectTypeReference());
			result.addTypeArgument(typeArgument);
		}
		if (reference.getReturnType() != null) {
			LightweightTypeReference returnType = visit(wrapIfNecessary(reference.getReturnType()));
			result.setReturnType(returnType);
			if (reference instanceof XFunctionTypeRefImplCustom) {
				if (isProcedure((XFunctionTypeRefImplCustom) reference)) {
					return result;
				}
			}
			WildcardTypeReference typeArgument = getOwner().newWildcardTypeReference();
			typeArgument.addUpperBound(returnType);
			result.addTypeArgument(typeArgument);
		}
		return result;
	}

	public JvmTypeReference wrapIfNecessary(JvmTypeReference reference) {
		if (reference == null) {
			return null;
		}
		JvmType type = getType(reference);
		return XFunctionTypeRefs.wrapIfNecessary(reference, type);
	}

	protected LightweightTypeReference getJavaLangObjectTypeReference() {
		return getOwner().newReferenceToObject();
	}

	@Override
	public JvmType getType(JvmTypeReference it) {
		if (it instanceof XFunctionTypeRefImplCustom) {
			return _getType((XFunctionTypeRefImplCustom) it);
		} else if (it instanceof JvmGenericArrayTypeReferenceImplCustom) {
			return _getType((JvmGenericArrayTypeReferenceImplCustom) it);
		} else if (it instanceof XFunctionTypeRef) {
			return _getType((XFunctionTypeRef) it);
		} else if (it instanceof JvmParameterizedTypeReference) {
			return _getType((JvmParameterizedTypeReference) it);
		} else if (it != null) {
			return _getType(it);
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(it).toString());
		}
	}
}
