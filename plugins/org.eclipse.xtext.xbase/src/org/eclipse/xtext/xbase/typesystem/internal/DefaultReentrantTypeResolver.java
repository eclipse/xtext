/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.ITypeResolution;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class DefaultReentrantTypeResolver implements IReentrantTypeResolver {

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private ITypeComputer typeComputer;
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;
	
	@Inject(optional = true)
	private XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;
	
	@Inject
	private ScopeProviderAccess scopeProviderAccess;
	
	private EObject root;
	
	private boolean resolving = false;
	
	public void initializeFrom(@NonNull EObject root) {
		this.root = root;
	}
	
	protected EObject getRoot() {
		return root;
	}
	
	@NonNull
	public ITypeResolution reentrantResolve() {
		if (resolving) {
			throw new UnsupportedOperationException("TODO: import a functional handle on the type resolution that delegates to the best available (current, but evolving) result");
		}
		try {
			resolving = true;
			return resolve();
		} finally {
			resolving = false;
		}
	}
	
	protected ITypeResolution resolve() {
		TypeResolution typeResolution = new TypeResolution(this);
		computeTypes(typeResolution);
		return typeResolution;
	}

	
	protected void computeTypes(TypeResolution typeResolution) {
		computeTypes(typeResolution, root);
	}
	
	protected void computeTypes(TypeResolution typeResolution, EObject element) {
		if (element instanceof XExpression) {
			_computeTypes(typeResolution, (XExpression) element);
		} else {
			throw new IllegalArgumentException("element: " + element);
		}
	}

	protected void _computeTypes(TypeResolution typeResolution, XExpression expression) {
		RootExpressionComputationState state = new RootExpressionComputationState(typeResolution, expression, this);
		state.computeTypes();
	}
	
	protected ITypeComputer getTypeComputer() {
		return typeComputer;
	}
	
	protected TypeReferences getTypeReferences() {
		return typeReferences;
	}
	
	protected ScopeProviderAccess getScopeProviderAccess() {
		return scopeProviderAccess;
	}

	protected TypeConformanceComputer getConformanceComputer() {
		return typeConformanceComputer;
	}

	protected XtypeFactory getXtypeFactory() {
		return xtypeFactory;
	}

}
