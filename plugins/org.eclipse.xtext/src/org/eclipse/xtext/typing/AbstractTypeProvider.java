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

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AbstractTypeProvider<T> implements ITypeProvider<T> {

	private final PolymorphicDispatcher<T> dispatcher = PolymorphicDispatcher
			.createForSingleTarget("_type", 2, 2, this);
	@Inject
	private ITypeConformanceComputer<T> conformanceChecker;

	public void setConformanceChecker(ITypeConformanceComputer<T> conformanceChecker) {
		this.conformanceChecker = conformanceChecker;
	}

	public T getType(EObject astNode, Context<T> context) {
		if (astNode == null)
			throw new IllegalArgumentException("expression was null");
		return internalGetType(astNode, context);
	}


	protected T internalGetType(EObject expression, Context<T> context) {
		if (expression == null)
			throw new IllegalArgumentException("expression was null");
		if (context == null)
			context = Context.newCtx();
		T actual = dispatch_type(expression, context);
		if (actual == null)
			return null;
		if (context.getExpectedType() != null) {
			checkConformance(expression, context, actual);
		}
		return actual;
	}

	protected T dispatch_type(EObject expression, Context<T> context) {
		return dispatcher.invoke(expression, context);
	}

	/**
	 * Is used to allow invocation of type provider on root element and override for certain expression containing AST
	 * nodes.
	 */
	public T _type(EObject stNode, Context<T> context) {
		for (EObject child : stNode.eContents()) {
			internalGetType(child, context);
		}
		return null;
	}

	protected void checkConformance(EObject expression, Context<T> context, T actual) {
		if (context.getExpectedType()!=null && !conformanceChecker.isConformant(context.getExpectedType(), actual)) {
			context.acceptError(
					"Type mismatch: cannot convert from " + getName(actual) + " to " + getName(context.getExpectedType()), expression,
					null, ITypeConformanceComputer.ISSUE_NON_CONFORMANT_TYPES);
		}
	}

	protected String getName(T actual) {
		return actual != null ? actual.toString() : "null";
	}

}
