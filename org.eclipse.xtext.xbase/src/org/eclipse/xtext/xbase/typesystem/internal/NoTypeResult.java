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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class NoTypeResult implements ITypeComputationResult {

	private EObject context;
	private ITypeReferenceOwner owner;

	public NoTypeResult(/* @Nullable */ EObject context, ITypeReferenceOwner owner) {
		this.context = context;
		this.owner = owner;
	}
	
	@Override
	public LightweightTypeReference getReturnType() {
		return owner.newAnyTypeReference();
	}
	
	/* @Nullable */
	@Override
	public XExpression getExpression() {
		return null;
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getActualExpressionType() {
		return null;
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedExpressionType() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	@Override
	public LightweightTypeReference getExpectedReturnType() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	/* @NonNull */
	@Override
	public EnumSet<ConformanceHint> getConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
	}
	
	@Override
	public int getConformanceFlags() {
		return ConformanceFlags.NONE;
	}
	
	/* @NonNull */
	@Override
	public EnumSet<ConformanceHint> getCheckedConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
	}
	
	@Override
	public int getCheckedConformanceFlags() {
		return ConformanceFlags.NONE;
	}
	
	@Override
	public String toString() {
		return String.format("No result in context of %s", String.valueOf(context));
	}

}
