/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractResolvedReference<Expression extends XExpression> extends AbstractLinkingCandidate<Expression> {
	
	protected final JvmIdentifiableElement resolvedElement;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	
	protected AbstractResolvedReference(
			Expression expression, 
			JvmIdentifiableElement resolvedElement,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(expression, expectation, state);
		this.resolvedElement = resolvedElement;
		this.typeParameterMapping = initializeTypeParameterMapping();
	}

	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}

	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		// nothing to do
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		// nothing to do
		return true;
	}
	
	@Override
	public JvmIdentifiableElement getFeature() {
		return resolvedElement;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + resolvedElement.getIdentifier() + "]";
	}

}
