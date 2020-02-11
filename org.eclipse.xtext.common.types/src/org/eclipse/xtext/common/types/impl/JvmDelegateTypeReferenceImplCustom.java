/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmDelegateTypeReferenceImplCustom extends JvmDelegateTypeReferenceImpl {

	@Override
	public JvmType getType() {
		JvmTypeReference resolvedDelegate = getDelegate();
		if (resolvedDelegate == null || resolvedDelegate.eIsProxy())
			return null;
		return resolvedDelegate.getType();
	}
	
	@Override
	public String getIdentifier() {
		JvmTypeReference resolvedDelegate = getDelegate();
		if (resolvedDelegate == null || resolvedDelegate.eIsProxy())
			return null;
		return resolvedDelegate.getIdentifier();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmTypeReference resolvedDelegate = getDelegate();
		if (resolvedDelegate == null || resolvedDelegate.eIsProxy())
			return null;
		return resolvedDelegate.getQualifiedName(innerClassDelimiter);
	}
	
	@Override
	public String getSimpleName() {
		JvmTypeReference resolvedDelegate = getDelegate();
		if (resolvedDelegate == null || resolvedDelegate.eIsProxy())
			return null;
		return resolvedDelegate.getSimpleName();
	}
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitDelegateTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitDelegateTypeReference(this, parameter);
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (delegate == null) {
			result.append(" equivalent is not yet computed");
		} else if (delegate.eIsProxy()) {
			result.append(" (equivalent uri: ");
			result.append(((InternalEObject) delegate).eProxyURI());
			result.append(')');
		} else {
			result.append(delegate.toString());
		}
		return result.toString();
	}
}
