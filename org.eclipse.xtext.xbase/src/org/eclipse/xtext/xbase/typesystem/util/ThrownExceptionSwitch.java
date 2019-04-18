/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.util.XbaseSwitch;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ThrownExceptionSwitch extends XbaseSwitch<Boolean> {
	
	private IThrownExceptionDelegate delegate;

	public ThrownExceptionSwitch(IThrownExceptionDelegate delegate) {
		this.delegate = delegate;
	}
	
	protected void accept(LightweightTypeReference type) {
		delegate.accept(type);
	}
	
	protected LightweightTypeReference getType(XExpression expr) {
		return delegate.getActualType(expr);
	}
	
	@Override
	public Boolean defaultCase(EObject object) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseXExpression(XExpression object) {
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseXClosure(XClosure object) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseXCasePart(XCasePart object) {
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseXThrowExpression(XThrowExpression object) {
		accept(getType(object.getExpression()));
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseXCatchClause(XCatchClause object) {
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseXTryCatchFinallyExpression(XTryCatchFinallyExpression object) {
		List<XVariableDeclaration> resources = object.getResources();
		List<XCatchClause> clauses = object.getCatchClauses();

		if (clauses.isEmpty()) {
			// collect exceptions thrown by automatic close method
			// of given resources
			processExceptionsFromAutoclosable(resources, delegate);
			// let procedure traverse child elements, to check if they throw
			// exceptions
			return Boolean.TRUE;
		}

		// traverse child elements explicitly, to filter for caught exceptions
		final List<LightweightTypeReference> caughtExceptions = Lists.newArrayList();
		boolean wasThrowable = false;
		for (XCatchClause clause : clauses) {
			JvmTypeReference caught = clause.getDeclaredParam().getParameterType();
			if (caught != null) {
				LightweightTypeReference caughtException = delegate.toLightweightReference(caught)
						.getRawTypeReference();
				if (caughtException.isType(Throwable.class)) {
					wasThrowable = true;
				}
				if (caughtException.isSynonym()) {
					caughtExceptions.addAll(caughtException.getMultiTypeComponents());
				} else {
					caughtExceptions.add(caughtException);
				}
			}
			delegate.collectThrownExceptions(clause.getExpression());
		}
		delegate.collectThrownExceptions(object.getFinallyExpression());
		if (wasThrowable) {
			// Stop child traversing of procedure
			return Boolean.FALSE;
		}

		// Filter caught exceptions from all thrown excpetions
		// (thrown by resource constructor/automatic close, try expressions)
		IThrownExceptionDelegate filteredDelegate = delegate.catchExceptions(caughtExceptions);
		processExceptionsFromAutoclosable(resources, filteredDelegate);
		filteredDelegate.collectThrownExceptions(object.getExpression());
		// Stop child traversing of procedure
		return Boolean.FALSE;
	}
	
	/**
	 * Checks if the automatically called close method of resources in
	 * try block (implementing AutoCloseable) throws exceptions.
	 * Add those those exceptions to the list of the thrownExceptionDelegate.
	 * 
	 * @param resources the resources of the try statement
	 * @param thrownExceptionDelegate the (filtered) delegate holding the utilities
	 * 
	 * @since 2.18
	 */
	protected void processExceptionsFromAutoclosable(List<XVariableDeclaration> resources,
			IThrownExceptionDelegate thrownExceptionDelegate) {
		
		// If no resources are give, no exceptions are thrown
		if (resources.isEmpty()) {
			return;
		}
		
		// Check for each resource which exceptions are thrown
		for (XVariableDeclaration resource : resources) {
			LightweightTypeReference autoClosableType = thrownExceptionDelegate.getActualType((JvmIdentifiableElement) resource);
			JvmOperation closeMethod = findCloseMethod(autoClosableType);
			// Collect all exceptions
			if (autoClosableType != null && closeMethod != null) {
				IResolvedExecutable resolvedCloseMethod = thrownExceptionDelegate.getResolvedFeature(closeMethod, autoClosableType);
				List<LightweightTypeReference> declaredExceptions = resolvedCloseMethod.getResolvedExceptions();
				for(LightweightTypeReference exception: declaredExceptions) {
					thrownExceptionDelegate.accept(exception);
				}
			}
		}
	}

	/**
	 * @since 2.18
	 */
	protected JvmOperation findCloseMethod(LightweightTypeReference resourceType) {
		// Find the real close method,
		// which is an operation without arguments.
		// There can only be one real close method.
		for(JvmType rawType: resourceType.getRawTypes()) {
			if (rawType instanceof JvmDeclaredType) {
				Iterable<JvmFeature> candidates = ((JvmDeclaredType) rawType).findAllFeaturesByName("close");
				for(JvmFeature candidate: candidates) {
					if (candidate instanceof JvmOperation
							&& ((JvmOperation) candidate).getParameters().isEmpty()) {
						return (JvmOperation) candidate;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public Boolean caseXAbstractFeatureCall(XAbstractFeatureCall object) {
		JvmIdentifiableElement feature = object.getFeature();
		if (feature instanceof JvmExecutable) {
			accept((JvmExecutable)feature);
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean caseXConstructorCall(XConstructorCall object) {
		JvmConstructor constructor = object.getConstructor();
		accept(constructor);
		return Boolean.TRUE;
	}
	
	protected void accept(JvmExecutable executable) {
		// TODO handle generic exceptions
		for(JvmTypeReference exception: executable.getExceptions()) {
			accept(delegate.toLightweightReference(exception).getRawTypeReference());
		}
	}

}
