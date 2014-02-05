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
import org.eclipse.xtext.xbase.scoping.batch.FeatureScopes;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope.Anchor;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmptyResolvedTypes extends ForwardingResolvedTypes {

	private FeatureScopes featureScopes;
	private IFeatureScopeSession session;

	public EmptyResolvedTypes(IFeatureScopeSession session, FeatureScopes featureScopes) {
		this.session = session;
		this.featureScopes = featureScopes;
	}
	
	@Override
	protected IResolvedTypes delegate() {
		return IResolvedTypes.NULL;
	}
	
	@Override
	public IExpressionScope getExpressionScope(EObject context, EReference reference, Anchor anchor) {
		List<FeatureScopeSessionToResolvedTypes> data = Collections.singletonList(new FeatureScopeSessionToResolvedTypes(session, this));
		return new ExpressionScope(featureScopes, context, reference, data, anchor);
	}

}
