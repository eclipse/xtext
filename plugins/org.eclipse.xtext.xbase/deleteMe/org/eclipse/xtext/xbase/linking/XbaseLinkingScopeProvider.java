/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class XbaseLinkingScopeProvider implements IScopeProvider /* implements IDelegatingScopeProvider */ {
	
	@Inject
	private IScopeProvider delegate;
	
	@Inject
	private Provider<FeatureCallChecker> featureCallCheckerProvider;
	
	@Inject
	private TypeConformanceComputer conformanceComputer;
	
	@Inject
	private IRawTypeHelper rawTypeHelper;

	public IScope getScope(EObject context, EReference reference) {
		if (context == null || context.eResource() == null || context.eResource().getResourceSet() == null) {
			return IScope.NULLSCOPE;
		}
		final IScope scope = delegate.getScope(context, reference);
		if (isFeatureCallScope(reference)) {
			return wrapFeatureCallScope(scope, context, reference);
		}
		return scope;
	}

	protected IScope wrapFeatureCallScope(IScope scope, EObject context, EReference reference) {
		final FeatureCallChecker featureCallChecker = getFeatureCallChecker(context, reference);
		return new BestMatchingJvmFeatureScope(conformanceComputer, context, reference, scope, featureCallChecker, rawTypeHelper);
	}

	protected boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE || reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}
	
	protected FeatureCallChecker getFeatureCallChecker(final EObject context, final EReference reference) {
		final FeatureCallChecker predicate = featureCallCheckerProvider.get();
		predicate.initialize(context, reference);
		return predicate;
	}

	public IScopeProvider getDelegate() {
		return delegate;
	}
}
