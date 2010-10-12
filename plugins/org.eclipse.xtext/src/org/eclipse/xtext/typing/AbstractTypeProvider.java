/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AbstractTypeProvider<T> implements ITypeProvider<T> {

	private final PolymorphicDispatcher<T> dispatcher = PolymorphicDispatcher
			.createForSingleTarget("_type", 2, 2, this);
	private ValidationMessageAcceptor issueAcceptor;
	
	@Inject
	private ITypeConformanceComputer<T> conformanceChecker;
	
	public void setConformanceChecker(ITypeConformanceComputer<T> conformanceChecker) {
		this.conformanceChecker = conformanceChecker;
	}

	protected ValidationMessageAcceptor getIssueAcceptor() {
		return issueAcceptor;
	}

	public T getType(EObject astNode, T expectedType, ValidationMessageAcceptor issueAcceptor) {
		if (astNode == null)
			throw new IllegalArgumentException("expression was null");
		ValidationMessageAcceptor oldAcceptor = issueAcceptor;
		try {
			this.issueAcceptor = issueAcceptor != null ? issueAcceptor : ValidationMessageAcceptor.NULL;
			return internalGetType(astNode, expectedType);
		} finally {
			this.issueAcceptor = oldAcceptor;
		}
	}
	
	/**
	 * Is used to allow invocation of type provider on root element
	 * and override for certain expression containing AST nodes.
	 */
	public T _type(EObject stNode,T expectedType) {
		for (EObject child : stNode.eContents()) {
			internalGetType(child, expectedType);
		}
		return null;
	}

	protected T internalGetType(EObject expression, T expected) {
		if (expression == null)
			throw new IllegalArgumentException("expression was null");
		T actual = dispatcher.invoke(expression, expected);
		if (actual == null)
			return null;
		if (expected != null) {
			checkConformance(expression, expected, actual);
		}
		return actual;
	}

	protected void checkConformance(EObject expression, T expected, T actual) {
		if (!conformanceChecker.isConformant(expected, actual)) {
			getIssueAcceptor().acceptError(
					"Type mismatch: cannot convert from " + getName(actual) + " to "
							+ getName(expected), expression, null,
					ITypeConformanceComputer.ISSUE_NON_CONFORMANT_TYPES);
		}
	}

	protected String getName(T actual) {
		return actual!=null?actual.toString():"null";
	}

}
