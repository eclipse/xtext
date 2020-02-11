/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ResolutionBasedComputationResult implements ITypeComputationResult {

	private final XExpression expression;
	private final ResolvedTypes resolution;

	public ResolutionBasedComputationResult(XExpression expression, ResolvedTypes resolution) {
		this.expression = expression;
		this.resolution = resolution;
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getActualExpressionType() {
		return resolution.getActualType(expression);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getReturnType() {
		return resolution.getReturnType(expression);
	}

	/* @NonNull */
	@Override
	public XExpression getExpression() {
		return expression;
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedExpressionType() {
		return resolution.getExpectedType(expression);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedReturnType() {
		return resolution.getExpectedReturnType(expression);
	}
	
	/* @NonNull */
	@Override
	public EnumSet<ConformanceHint> getConformanceHints() {
		return ConformanceHint.fromFlags(getConformanceFlags());
	}
	
	@Override
	public int getConformanceFlags() {
		TypeData typeData = resolution.getTypeData(expression, false);
		if (typeData == null)
			return ConformanceFlags.NONE;
		return typeData.getConformanceFlags();
	}

	/* @NonNull */
	@Override
	public EnumSet<ConformanceHint> getCheckedConformanceHints() {
		return ConformanceHint.fromFlags(getCheckedConformanceFlags());
	}
	
	@Override
	public int getCheckedConformanceFlags() {
		TypeData typeData = resolution.getTypeData(expression, false);
		if (typeData == null)
			return ConformanceFlags.NONE;
		return resolution.getConformanceFlags(typeData, false);
	}
	
	@Override
	public String toString() {
		return String.format("Result %s for %s", getActualExpressionType(), expression);
	}

}
