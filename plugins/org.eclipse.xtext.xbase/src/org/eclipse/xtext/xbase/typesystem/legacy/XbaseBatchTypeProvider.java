/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
@Singleton
public class XbaseBatchTypeProvider extends XbaseTypeProvider {
	
	@Inject private IBatchTypeResolver typeResolver;
	@Inject private ILogicalContainerProvider containerProvider;
	
	@NonNull
	protected IResolvedTypes getResolvedTypes(EObject object) {
		return typeResolver.resolveTypes(object);
	}

	@Override
	public JvmTypeReference getExpectedReturnType(XExpression expression, boolean rawType) {
		JvmIdentifiableElement container = containerProvider.getNearestLogicalContainer(expression);
		if (container instanceof JvmOperation) {
			return ((JvmOperation) container).getReturnType();
		}
		return getExpectedType(expression);
	}

	@Override
	public JvmTypeReference getExpectedType(XExpression expression) {
		LightweightTypeReference expectedType = getResolvedTypes(expression).getExpectedType(expression);
		if (expectedType != null)
			return expectedType.toTypeReference();
		return null;
	}

	@Override
	public JvmTypeReference getExpectedType(XExpression expression, boolean rawType) {
		return getResolvedTypes(expression).getExpectedType(expression).toTypeReference();
	}

	@Override
	public JvmTypeReference getType(XExpression expression) {
		return getResolvedTypes(expression).getActualType(expression).toTypeReference();
	}

	@Override
	public JvmTypeReference getType(XExpression expression, boolean rawType) {
		LightweightTypeReference actualType = getResolvedTypes(expression).getActualType(expression);
		if (actualType == null)
			return null;
		return actualType.toTypeReference();
	}

	@Override
	public JvmTypeReference getType(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		return getResolvedTypes(identifiableElement).getActualType(identifiableElement).toTypeReference();
	}

	@Override
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return getResolvedTypes(identifiableElement).getActualType(identifiableElement).toTypeReference();
	}

	@Override
	public JvmTypeReference getCommonReturnType(XExpression expression, boolean assumeImplicitReturn) {
		return getType(expression, false);
	}

	@Override
	public ITypeArgumentContext getTypeArgumentContext(XAbstractFeatureCall featureCall,
			List<XExpression> actualArguments, Provider<JvmTypeReference> receiverTypeProvider,
			JvmIdentifiableElement feature) {
		return null;
	}

	@Override
	public ITypeArgumentContext getTypeArgumentContext(XConstructorCall constructorCall, JvmConstructor constructor) {
		throw new UnsupportedOperationException();
	}

}
