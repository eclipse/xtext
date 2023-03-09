/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope.Anchor;

import com.google.common.collect.Maps;

/**
 * An implementation of the {@link IFeatureScopeTracker} that really does 
 * tracking. It's usually only necessary to use this implementation in an interactive
 * editor environment where content assist is used.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeTracker implements IFeatureScopeTracker {

	private final Map<EObject, EnumMap<IExpressionScope.Anchor, ExpressionScope>> featureScopeSessions;
	
	public FeatureScopeTracker() {
		featureScopeSessions = Maps.newHashMapWithExpectedSize(256);
	}
	
	@Override
	public IExpressionScope getExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		EnumMap<Anchor, ExpressionScope> recordedScopes = featureScopeSessions.get(context);
		if (recordedScopes == null) {
			return IExpressionScope.NULL;
		}
		ExpressionScope result = recordedScopes.get(anchor);
		if (result == null && anchor == IExpressionScope.Anchor.RECEIVER) {
			result = recordedScopes.get(IExpressionScope.Anchor.AFTER);
		}
		if (result == null) {
			return IExpressionScope.NULL;
		}
		return result.withAnchor(anchor);
	}
	
	@Override
	public boolean hasExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		Map<Anchor,ExpressionScope> recordedScopes = featureScopeSessions.get(context);
		return recordedScopes != null && recordedScopes.containsKey(anchor);
	}
	
	@Override
	public void addExpressionScope(ResolvedTypes current, EObject context, IFeatureScopeSession session, Anchor anchor) {
		EnumMap<Anchor, ExpressionScope> recordedScopes = featureScopeSessions.get(context);
		if (recordedScopes == null) {
			recordedScopes = Maps.newEnumMap(Anchor.class);
			featureScopeSessions.put(context, recordedScopes);
		}
		ExpressionScope scope = recordedScopes.get(anchor);
		if (scope == null) {
			scope = new ExpressionScope(current.getResolver().getFeatureScopes(), context, anchor, current.getReferenceOwner());
			recordedScopes.put(anchor, scope);
		}
		scope.addData(session, current.withFlattenedReassignedTypes());
	}
	
	@Override
	public void replacePreviousExpressionScope(EObject context, IFeatureScopeSession session, IExpressionScope.Anchor anchor) {
		EnumMap<Anchor, ExpressionScope> recordedScopes = featureScopeSessions.get(context);
		if (recordedScopes == null) {
			throw new IllegalStateException("Cannot replace scope that was never recorded");
		}
		ExpressionScope scope = recordedScopes.get(anchor);
		if (scope == null) {
			throw new IllegalStateException("Cannot replace scope that was never recorded");
		}
		scope.replacePreviousData(session);
	}
	
}
