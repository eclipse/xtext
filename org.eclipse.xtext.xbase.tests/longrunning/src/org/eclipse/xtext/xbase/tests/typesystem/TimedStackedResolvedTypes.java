/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow
 */
public class TimedStackedResolvedTypes extends StackedResolvedTypes {
	private TypeResolutionTimes times;

	public TimedStackedResolvedTypes(ResolvedTypes parent, TypeResolutionTimes times) {
		super(parent);
		this.times = times;
	}

	@Override
	public StackedResolvedTypes pushReassigningTypes() {
		return new TimedReassigningResolvedTypes(this, times);
	}

	@Override
	public StackedResolvedTypes pushTypes() {
		return new TimedStackedResolvedTypes(this, times);
	}

	@Override
	public ExpressionAwareStackedResolvedTypes pushTypes(XExpression context) {
		return new TimedExpressionAwareResolvedTypes(this, context, times);
	}

	@Override
	public IFeatureLinkingCandidate doGetFeature(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = null;
		try {
			times.getFeatureTask.start();
			result = super.getFeature(featureCall);
		} finally {
			times.getFeatureTask.stop();
		}
		return result;
	}

	@Override
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = null;
		try {
			times.getActualTypeTask.start();
			result = super.getActualType(identifiable);
		} finally {
			times.getActualTypeTask.stop();
		}
		return result;
	}

	@Override
	public LightweightTypeReference getActualType(XExpression expression) {
		LightweightTypeReference result = null;
		try {
			times.getActualExpressionTypeTask.start();
			result = super.getActualType(expression);
		} finally {
			times.getActualExpressionTypeTask.stop();
		}
		return result;
	}

	@Override
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		List<LightweightBoundTypeArgument> result = null;
		try {
			times.getHintsTask.start();
			result = super.getAllHints(handle);
		} finally {
			times.getHintsTask.stop();
		}
		return result;
	}
}
