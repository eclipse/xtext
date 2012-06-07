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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class DefaultReentrantTypeResolver implements IReentrantTypeResolver {

	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private ITypeComputer typeComputer;
	
	@Inject
	private ScopeProviderAccess scopeProviderAccess;
	
	@Inject
	private IBatchScopeProvider batchScopeProvider;
	
	@Inject
	private BoundTypeArgumentMerger typeArgumentMerger;
	
	private EObject root;
	
	private boolean resolving = false;
	
	public void initializeFrom(@NonNull EObject root) {
		this.root = root;
	}
	
	protected EObject getRoot() {
		return root;
	}
	
	@NonNull
	public IResolvedTypes reentrantResolve() {
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
	
	protected IResolvedTypes resolve() {
		ResolvedTypes result = new ResolvedTypes(this);
		IFeatureScopeSession session = batchScopeProvider.newSession(root.eResource());
		computeTypes(result, session);
		return result;
	}
	
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		computeTypes(resolvedTypes, session, root);
	}
	
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session, EObject element) {
		if (element instanceof XExpression) {
			_computeTypes(resolvedTypes, session, (XExpression) element);
		} else {
			throw new IllegalArgumentException("element: " + element);
		}
	}

	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session, XExpression expression) {
		RootExpressionComputationState state = new RootExpressionComputationState(resolvedTypes, session, expression, this);
		state.computeTypes();
	}
	
	protected ITypeComputer getTypeComputer() {
		return typeComputer;
	}

	protected void setTypeComputer(ITypeComputer typeComputer) {
		this.typeComputer = typeComputer;
	}
	
	protected ScopeProviderAccess getScopeProviderAccess() {
		return scopeProviderAccess;
	}

	protected IBatchScopeProvider getBatchScopeProvider() {
		return batchScopeProvider;
	}

	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	protected BoundTypeArgumentMerger getTypeArgumentMerger() {
		return typeArgumentMerger;
	}
}
