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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
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
	@Inject private ILogicalContainerProvider containerProvider;
	@Inject private CommonTypeComputationServices services;
	@Inject private TypeArgumentContextProvider legacyContextProvider;
	
	@NonNull
	protected IResolvedTypes getResolvedTypes(EObject object) {
		return typeResolver.resolveTypes(object);
	}

	public JvmTypeReference getExpectedReturnType(XExpression expression, boolean rawType) {
		XClosure containingClosure = EcoreUtil2.getContainerOfType(expression, XClosure.class);
		if (containingClosure != null) {
			return getExpectedType(containingClosure.getExpression());
		}
		JvmIdentifiableElement container = containerProvider.getNearestLogicalContainer(expression);
		if (container instanceof JvmOperation) {
			return ((JvmOperation) container).getReturnType();
		}
		return getExpectedType(expression);
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
		if (type == null)
			return null;
		return type.toTypeReference();
	}

	public JvmTypeReference getType(XExpression expression, boolean rawType) {
		LightweightTypeReference actualType = getResolvedTypes(expression).getActualType(expression);
		if (actualType == null)
			return null;
		return actualType.toTypeReference();
	}

	public JvmTypeReference getType(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		throw new UnsupportedOperationException();
	}

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		LightweightTypeReference actualType = getResolvedTypes(identifiableElement).getActualType(identifiableElement);
		if (actualType == null)
			return null;
		return actualType.toTypeReference();
	}

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return getTypeForIdentifiable(identifiableElement);
	}

	public JvmTypeReference getCommonReturnType(XExpression expression, boolean assumeImplicitReturn) {
		LightweightTypeReference returnType = getResolvedTypes(expression).getReturnType(expression);
		if (returnType == null)
			return null;
		return returnType.toTypeReference();
	}
}
