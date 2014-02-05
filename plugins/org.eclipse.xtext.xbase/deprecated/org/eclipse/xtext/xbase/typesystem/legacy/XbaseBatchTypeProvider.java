/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("deprecation")
@Singleton
public class XbaseBatchTypeProvider implements ITypeProvider {
	
	@Inject private IBatchTypeResolver typeResolver;
	
	@NonNull
	protected IResolvedTypes getResolvedTypes(EObject object) {
		return typeResolver.resolveTypes(object);
	}

	public JvmTypeReference getExpectedReturnType(XExpression expression, boolean rawType) {
		LightweightTypeReference expectedType = getResolvedTypes(expression).getExpectedReturnType(expression);
		if (expectedType != null) {
			return expectedType.toTypeReference();
		}
		return null;
	}

	public JvmTypeReference getExpectedType(XExpression expression) {
		LightweightTypeReference expectedType = getResolvedTypes(expression).getExpectedType(expression);
		if (expectedType != null)
			return expectedType.toTypeReference();
		return null;
	}

	public JvmTypeReference getExpectedType(XExpression expression, boolean rawType) {
		return getExpectedType(expression);
	}

	public JvmTypeReference getType(XExpression expression) {
		LightweightTypeReference type = getResolvedTypes(expression).getActualType(expression);
		if (type != null)
			return type.toTypeReference();
		return null;
	}

	public JvmTypeReference getType(XExpression expression, boolean rawType) {
		return getType(expression);
	}

	public JvmTypeReference getType(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		return getType(expression);
	}

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		LightweightTypeReference actualType = getResolvedTypes(identifiableElement).getActualType(identifiableElement);
		if (actualType != null)
			return actualType.toTypeReference();
		return null;
	}

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return getTypeForIdentifiable(identifiableElement);
	}

	public JvmTypeReference getCommonReturnType(XExpression expression, boolean assumeImplicitReturn) {
		LightweightTypeReference returnType = getResolvedTypes(expression).getReturnType(expression);
		if (returnType != null)
			return returnType.toTypeReference();
		return null;
	}
	
}
