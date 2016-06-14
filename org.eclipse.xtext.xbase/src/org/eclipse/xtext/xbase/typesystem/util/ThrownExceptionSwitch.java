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
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
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
		List<XCatchClause> clauses = object.getCatchClauses();
		if (clauses.isEmpty()) {
			return Boolean.TRUE;
		}
		final List<LightweightTypeReference> caughtExceptions = Lists.newArrayList();
		boolean wasThrowable = false;
		for(XCatchClause clause: clauses) {
			JvmTypeReference caught = clause.getDeclaredParam().getParameterType();
			if (caught != null) {
				LightweightTypeReference caughtException = delegate.toLightweightReference(caught).getRawTypeReference();
				if (caughtException.isType(Throwable.class)) {
					wasThrowable = true;
				}
				caughtExceptions.add(caughtException);
			}
			delegate.collectThrownExceptions(clause.getExpression());
		}
		delegate.collectThrownExceptions(object.getFinallyExpression());
		if (wasThrowable) {
			return Boolean.FALSE;
		}
		delegate.catchExceptions(caughtExceptions).collectThrownExceptions(object.getExpression());
		return Boolean.FALSE;
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
