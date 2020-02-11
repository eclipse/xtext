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
public class JvmSpecializedTypeReferenceImplCustom extends JvmSpecializedTypeReferenceImpl {

	@Override
	public JvmType getType() {
		JvmTypeReference resolvedEquivalent = getEquivalent();
		if (resolvedEquivalent != null)
			return resolvedEquivalent.getType();
		return null;
	}
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitSpecializedTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitSpecializedTypeReference(this, parameter);
		return result;
	}
	
	@Override
	public String getIdentifier() {
		JvmTypeReference equivalent = getEquivalent();
		if (equivalent != null)
			return equivalent.getIdentifier();
		return super.getIdentifier();
	}

	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmTypeReference equivalent = getEquivalent();
		if (equivalent != null)
			return equivalent.getQualifiedName(innerClassDelimiter);
		return super.getQualifiedName(innerClassDelimiter);
	}
	
	@Override
	public String getSimpleName() {
		JvmTypeReference equivalent = getEquivalent();
		if (equivalent != null)
			return equivalent.getSimpleName();
		return super.getSimpleName();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (equivalent == null) {
			result.append(" equivalent is not yet computed");
		} else if (equivalent.eIsProxy()) {
			result.append(" (equivalent uri: ");
			result.append(((InternalEObject) equivalent).eProxyURI());
			result.append(')');
		} else {
			result.append(equivalent.toString());
		}
		return result.toString();
	}
}
