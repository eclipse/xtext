/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.linking;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.BestMatchingJvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.CallableFeaturePredicate;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseLinkingScopeProvider implements IScopeProvider {
	
	@Inject
	private IScopeProvider delegate;
	
	@Inject
	private Provider<CallableFeaturePredicate> featurePredicateProvider;
	
	@Inject
	private IJvmTypeConformanceComputer conformanceChecker;

	public IScope getScope(EObject context, EReference reference) {
		final IScope scope = delegate.getScope(context, reference);
		if (isFeatureCallScope(reference)) {
			return wrapFeatureCallScope(scope, context, reference);
		}
		return scope;
	}

	protected IScope wrapFeatureCallScope(IScope scope, EObject context, EReference reference) {
		final ISelector featurePredicateSelector = getFeaturePredicateSelector(context, reference);
		return new BestMatchingJvmFeatureScope(conformanceChecker, context, reference, scope,
				featurePredicateSelector);
	}

	protected boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}
	
	protected ISelector getFeaturePredicateSelector(final EObject context, final EReference reference) {
		return new ISelector() {
			public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
				final CallableFeaturePredicate predicate = featurePredicateProvider.get();
				predicate.iniitialize(context, reference);
				return filter(elements,predicate);
			}
		};
	}
}
