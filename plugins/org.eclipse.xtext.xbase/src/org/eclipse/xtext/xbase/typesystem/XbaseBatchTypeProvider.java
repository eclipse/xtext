/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseBatchTypeProvider implements ITypeProvider {
	
	@Inject private IBatchTypeResolver typeResolver;
	@Inject private ILogicalContainerProvider containerProvider;
	
	protected IResolvedTypes getResolvedTypes(EObject x) {
		return typeResolver.resolveTypes(x);
	}

	public JvmTypeReference getExpectedReturnType(XExpression expression, boolean rawType) {
		JvmIdentifiableElement container = containerProvider.getNearestLogicalContainer(expression);
		if (container instanceof JvmOperation) {
			return ((JvmOperation) container).getReturnType();
		}
		throw new UnsupportedOperationException("TODO");
	}

	public JvmTypeReference getExpectedType(XExpression expression) {
		return getResolvedTypes(expression).getExpectedType(expression).toTypeReference();
	}

	public JvmTypeReference getExpectedType(XExpression expression, boolean rawType) {
		return getResolvedTypes(expression).getExpectedType(expression).toTypeReference();
	}

	public JvmTypeReference getType(XExpression expression) {
		return getResolvedTypes(expression).getActualType(expression).toTypeReference();
	}

	public JvmTypeReference getType(XExpression expression, boolean rawType) {
		return getResolvedTypes(expression).getActualType(expression).toTypeReference();
	}

	public JvmTypeReference getType(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		throw new UnsupportedOperationException();
	}

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		return getResolvedTypes(identifiableElement).getActualType(identifiableElement).toTypeReference();
	}

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return getResolvedTypes(identifiableElement).getActualType(identifiableElement).toTypeReference();
	}

	public JvmTypeReference getCommonReturnType(XExpression expression, boolean assumeImplicitReturn) {
		return getExpectedReturnType(expression, false);
	}

	public Iterable<JvmTypeReference> getThrownExceptionTypes(XExpression expression) {
		// TODO
		return emptyList();
	}

	public Iterable<JvmTypeReference> getThrownExceptionForIdentifiable(JvmIdentifiableElement identifiable) {
		// TODO
		return emptyList();
	}

	public ITypeArgumentContext getTypeArgumentContext(XAbstractFeatureCall featureCall,
			List<XExpression> actualArguments, Provider<JvmTypeReference> receiverTypeProvider,
			JvmIdentifiableElement feature) {
		throw new UnsupportedOperationException();
	}

	public ITypeArgumentContext getTypeArgumentContext(XConstructorCall constructorCall, JvmConstructor constructor) {
		throw new UnsupportedOperationException();
	}

}
