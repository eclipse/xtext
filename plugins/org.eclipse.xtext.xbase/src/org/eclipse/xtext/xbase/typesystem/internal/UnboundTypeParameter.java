/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterSubstitutor;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnboundTypeParameter extends AbstractReentrantTypeReferenceProvider {

	private final XExpression expression;
	private final JvmTypeParameter typeParameter;
	private final CommonTypeComputationServices services;
	private final List<JvmTypeReference> expectations;
	private JvmTypeReference boundTo;
	
	public UnboundTypeParameter(XExpression expression, JvmTypeParameter typeParameter, CommonTypeComputationServices services) {
		this.expression = expression;
		this.typeParameter = typeParameter;
		this.services = services;
		this.expectations = Lists.newArrayList();
	}
	
	@Override
	protected JvmTypeReference doGetTypeReference() {
		if (boundTo != null) {
			return boundTo;
		}
		if (!expectations.isEmpty()) {
			JvmTypeReference superType = services.getTypeConformanceComputer().getCommonSuperType(expectations);
			if (superType != null) {
				boundTo = superType;
				return superType;
			}
		}
		UnboundTypeParameterSubstitutor unboundSubstitutor = new UnboundTypeParameterSubstitutor(
				Collections.<JvmTypeParameter, JvmTypeReference>emptyMap(), services);
		JvmTypeReference substitute = unboundSubstitutor.substitute(services.getTypeReferences().createTypeRef(typeParameter));
		boundTo = substitute;
		return substitute;
	}
	
	public void acceptHint(JvmTypeReference expectedType) {
		expectations.add(expectedType);
	}
	
	public XExpression getExpression() {
		return expression;
	}
	
	public JvmTypeParameter getTypeParameter() {
		return typeParameter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + ((typeParameter == null) ? 0 : typeParameter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnboundTypeParameter other = (UnboundTypeParameter) obj;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (typeParameter == null) {
			if (other.typeParameter != null)
				return false;
		} else if (!typeParameter.equals(other.typeParameter))
			return false;
		return true;
	}

}
