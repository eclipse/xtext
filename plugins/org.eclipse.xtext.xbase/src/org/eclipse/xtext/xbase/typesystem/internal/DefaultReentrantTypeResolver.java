/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.validation.FeatureNameValidator;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class DefaultReentrantTypeResolver extends AbstractRootedReentrantTypeResolver implements Cloneable {

	protected static class AbortTypeComputation extends RuntimeException {

		private static final long serialVersionUID = 1L;

		private IScope scope;

		public AbortTypeComputation(IScope scope) {
			this.scope = scope;
		}
		
		public IScope getScope() {
			return scope;
		}
		
	}
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private ITypeComputer typeComputer;
	
	@Inject
	private ScopeProviderAccess scopeProviderAccess;
	
	@Inject
	private IBatchScopeProvider batchScopeProvider;
	
	@Inject
	private ExpressionArgumentFactory expressionArgumentFactory;
	
	@Inject
	private FeatureNameValidator featureNameValidator;
	
	@Inject
	private IssueSeveritiesProvider issueSeveritiesProvider;
	
	private EObject root;
	
	private boolean resolving = false;
	
	public final void initializeFrom(EObject root) {
		if (this.root != null) {
			throw new IllegalStateException("Cannot reinitialize. Resolver has already a root: " + this.root);
		}
		this.root = root;
	}

	@Override
	protected final EObject getRoot() {
		return root;
	}

	@Override
	protected boolean isHandled(XExpression expression) {
		return EcoreUtil.getRootContainer(expression) == getRoot();
	}
	
	@Override
	protected boolean isHandled(JvmIdentifiableElement identifiableElement) {
		return EcoreUtil.getRootContainer(identifiableElement) == getRoot();
	}
	
	protected IssueSeveritiesProvider getIssueSeveritiesProvider() {
		return issueSeveritiesProvider;
	}
	
	public IResolvedTypes reentrantResolve() {
		if (resolving) {
			throw new UnsupportedOperationException("TODO: import a functional handle on the type resolution that delegates to the best available (current, but evolving) result");
		}
		StoppedTask task = Stopwatches.forTask("DefaultReentrantTypeResolver.resolve");
		try {
			task.start();
			resolving = true;
			return resolve();
		} finally {
			resolving = false;
			task.stop();
		}
	}
	
	protected IResolvedTypes resolve() {
		if (root == null || root.eResource() == null || root.eResource().getResourceSet() == null) {
			return IResolvedTypes.NULL;
		}
		RootResolvedTypes result = createResolvedTypes();
		IFeatureScopeSession session = batchScopeProvider.newSession(root.eResource());
		computeTypes(result, session);
		result.resolveUnboundTypeParameters();
		result.resolveProxies();
		result.addDiagnostics(root.eResource());
		return result;
	}
	
	@Override
	protected IScope getFeatureScope(XAbstractFeatureCall featureCall) {
		ResolvedTypes resolvedTypes = createResolvedTypesForScoping(featureCall);
		IFeatureScopeSession session = batchScopeProvider.newSession(root.eResource());
		try {
			computeTypes(resolvedTypes, session);
		} catch(AbortTypeComputation e) {
			return e.getScope();
		}
		return IScope.NULLSCOPE;
	}

	protected RootResolvedTypes createResolvedTypes() {
		return new RootResolvedTypes(this);
	}
	
	protected final ResolvedTypes createResolvedTypesForScoping(final XAbstractFeatureCall featureCall) {
		DefaultReentrantTypeResolver clone = clone();
		clone.scopeProviderAccess = createAbortingScopeProviderAccess(featureCall);
		return new RootResolvedTypes(clone);
	}

	@Override
	public DefaultReentrantTypeResolver clone() {
		try {
			return (DefaultReentrantTypeResolver) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
	}
	
	protected ScopeProviderAccess createAbortingScopeProviderAccess(final XAbstractFeatureCall abortOn) {
		return new ScopeProviderAccess() {
			@Override
			@Nullable
			protected IFeatureLinkingCandidate getKnownFeature(XAbstractFeatureCall featureCall, AbstractTypeComputationState state, ResolvedTypes resolvedTypes) {
				if (abortOn == featureCall) {
					return null;
				}
				return scopeProviderAccess.getKnownFeature(featureCall, state, resolvedTypes);
			}
			
			@Override
			public Iterable<IEObjectDescription> getCandidateDescriptions(XExpression expression, EReference reference, @Nullable EObject toBeLinked,
					IFeatureScopeSession session, IResolvedTypes types) throws IllegalNodeException {
				if (expression == abortOn) {
					IScope scope = session.getScope(expression, reference, types);
					throw new AbortTypeComputation(scope);
				}
				return scopeProviderAccess.getCandidateDescriptions(expression, reference, toBeLinked, session, types);
			}
		};
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
		ExpressionBasedRootTypeComputationState state = new ExpressionBasedRootTypeComputationState(resolvedTypes, session, expression);
		state.computeTypes();
	}
	
	protected boolean isShadowingAllowed(QualifiedName name) {
		return featureNameValidator.isShadowingAllowed(name);
	}
	
	protected boolean isDisallowedName(QualifiedName name) {
		return featureNameValidator.isDisallowedName(name);
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
	
	protected ExpressionArgumentFactory getExpressionArgumentFactory() {
		return expressionArgumentFactory;
	}

	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	protected BoundTypeArgumentMerger getTypeArgumentMerger() {
		return services.getBoundTypeArgumentMerger();
	}

	protected EObject getSourceElement(EObject element) {
		return element;
	}
}
