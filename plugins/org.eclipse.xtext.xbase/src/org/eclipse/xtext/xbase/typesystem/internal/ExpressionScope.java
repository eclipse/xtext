/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.FeatureScopes;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExpressionScope implements IExpressionScope {

	private final FeatureScopes featureScopes;
	private final EObject context;
	private final List<FeatureScopeSessionToResolvedTypes> data;
	private final Anchor anchor;
	private final EReference reference;

	public ExpressionScope(FeatureScopes featureScopes, EObject context, EReference reference, List<FeatureScopeSessionToResolvedTypes> data, Anchor anchor) {
		this.featureScopes = featureScopes;
		this.context = context;
		this.reference = reference;
		this.data = data;
		this.anchor = anchor;
	}

	@NonNull
	public IScope getFeatureScope() {
		if (anchor != Anchor.RECEIVER) {
			FeatureScopeSessionToResolvedTypes dummy = data.get(0);
			return featureScopes.createSimpleFeatureCallScope(context, reference, dummy.getSession(), dummy.getTypes());
		} else if (context instanceof XExpression) {
			FeatureScopeSessionToResolvedTypes dummy = data.get(0);
			// receiver is missing
			IScope result = featureScopes.createFeatureCallScopeForReceiver(null, (XExpression) context, reference, dummy.getSession(), dummy.getTypes());
//			featureScopes.createFeatureCallScopeForReceiver(context, context, reference, dummy.getSession(), dummy.getTypes());
			return result;
		}
		return IScope.NULLSCOPE;
	}
	
	@NonNull
	public IScope getFeatureScope(@Nullable XAbstractFeatureCall currentFeatureCall) {
		if (anchor == Anchor.RECEIVER) {
			FeatureScopeSessionToResolvedTypes dummy = data.get(0);
			// receiver is missing
			IScope result = featureScopes.createFeatureCallScopeForReceiver(currentFeatureCall, (XExpression) context, reference, dummy.getSession(), dummy.getTypes());
//			featureScopes.createFeatureCallScopeForReceiver(context, context, reference, dummy.getSession(), dummy.getTypes());
			return result;
		}
		return getFeatureScope();
	}

	@NonNull
	public List<String> getTypeNamePrefix() {
		return Collections.emptyList();
	}

	public boolean isPotentialTypeLiteral() {
		return false;
	}
	
}
