/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmGenericArrayTypeReferenceImplCustom extends JvmGenericArrayTypeReferenceImpl {
	
	@Override
	public JvmArrayType getType() {
		JvmTypeReference componentTypeReference = getComponentType();
		if (componentTypeReference != null) {
			JvmType componentType = componentTypeReference.getType();
			if (componentType instanceof JvmComponentType) {
				JvmArrayType result = ((JvmComponentType) componentType).getArrayType();
				return result;
			}
		}
		return null;
	}
	
	@Override
	public int getDimensions() {
		JvmArrayType arrayType = getType();
		if (arrayType != null)
			return arrayType.getDimensions();
		return -1;
	}
	
	@Override
	public String getIdentifier() {
		JvmTypeReference componentType = getComponentType();
		if (componentType != null)
			return componentType.getIdentifier() + "[]";
		return null;
	}
	
	@Override
	public String getSimpleName() {
		JvmTypeReference componentType = getComponentType();
		if (componentType != null)
			return componentType.getSimpleName() + "[]";
		return null;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmTypeReference componentType = getComponentType();
		if (componentType != null)
			return componentType.getQualifiedName(innerClassDelimiter) + "[]";
		return null;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (componentType == null) {
			result.append(" type is null");
		} else if (componentType.eIsProxy()) {
			result.append(" (type uri: ");
			result.append(((InternalEObject) componentType).eProxyURI());
			result.append(')');
		} else {
			result.append(getIdentifier());
		}
		return result.toString();
	}
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitGenericArrayTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitGenericArrayTypeReference(this, parameter);
		return result;
	}
	
}
