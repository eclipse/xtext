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
import org.eclipse.xtext.common.types.impl.NameConcatHelper.NameType;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmParameterizedTypeReferenceImplCustom extends JvmParameterizedTypeReferenceImpl {

	@Override
	public String getIdentifier() {
		return NameConcatHelper.computeFor(this, '$', NameType.ID);
	}
	
	@Override
	public String getSimpleName() {
		return NameConcatHelper.computeFor(this, '$', NameType.SIMPLE);
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return NameConcatHelper.computeFor(this, innerClassDelimiter, NameType.QUALIFIED);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (type == null) {
			result.append(" type is null");
		} else if (type.eIsProxy()) {
			result.append(" (type uri: ");
			result.append(((InternalEObject) type).eProxyURI());
			result.append(')');
		} else {
			result.append(NameConcatHelper.computeFor(this, '$', NameType.TO_STRING));
		}
		return result.toString();
	}

	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitParameterizedTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitParameterizedTypeReference(this, parameter);
		return result;
	}
}
