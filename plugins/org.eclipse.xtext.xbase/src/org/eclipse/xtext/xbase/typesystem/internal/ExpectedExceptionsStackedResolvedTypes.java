/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@NonNullByDefault
public class ExpectedExceptionsStackedResolvedTypes extends StackedResolvedTypes {

	private List<LightweightTypeReference> expectedExceptions;

	protected ExpectedExceptionsStackedResolvedTypes(ResolvedTypes parent, List<LightweightTypeReference> expectedExceptions) {
		super(parent);
		if (expectedExceptions.isEmpty()) {
			this.expectedExceptions = parent.getExpectedExceptions();
		} else {
			this.expectedExceptions = Lists.newArrayList(parent.getExpectedExceptions());
			this.expectedExceptions.addAll(expectedExceptions);
		}
	}
	
	protected ExpectedExceptionsStackedResolvedTypes(ResolvedTypes parent) {
		super(parent);
		this.expectedExceptions = Collections.emptyList();
	}

	@Override
	public List<LightweightTypeReference> getExpectedExceptions() {
		return expectedExceptions;
	}
	
	@Override
	public void acceptLinkingInformation(XExpression expression, ILinkingCandidate candidate) {
		getParent().acceptLinkingInformation(expression, candidate);
	}

	@Override
	protected OwnedConverter getConverter() {
		return getParent().getConverter();
	}

	@Override
	protected void acceptType(XExpression expression, TypeData typeData) {
		getParent().acceptType(expression, typeData);
	}

	@Override
	protected void setPropagatedType(XExpression expression) {
		getParent().setPropagatedType(expression);
	}
	
	@Override
	protected void setRefinedType(XExpression expression) {
		getParent().setRefinedType(expression);
	}
	
	@Override
	public void setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		getParent().setType(identifiable, reference);
	}

	@Override
	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		getParent().acceptHint(handle, boundTypeArgument);
	}

	@Override
	protected void acceptUnboundTypeReference(Object handle, UnboundTypeReference reference) {
		getParent().acceptUnboundTypeReference(handle, reference);
	}

	@Override
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		getParent().addDiagnostic(diagnostic);
	}

	@Override
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		return getParent().getAllHints(handle);
	}

	@Override
	protected void mergeInto(ResolvedTypes parent) {
		throw new UnsupportedOperationException("Should not be invoked");
	}

	@Override
	protected UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter type) {
		throw new UnsupportedOperationException("Should not be invoked");
	}

	@Override
	protected void mergeIntoParent() {
		throw new UnsupportedOperationException("Should not be invoked");
	}

	@Override
	protected void performMergeIntoParent() {
		throw new UnsupportedOperationException("Should not be invoked");
	}

	@Override
	protected void prepareMergeIntoParent() {
		throw new UnsupportedOperationException("Should not be invoked");
	}

	@Override
	public void reassignType(JvmIdentifiableElement identifiable, @Nullable LightweightTypeReference reference) {
		getParent().reassignType(identifiable, reference);
	}

	@Override
	public void reassignTypeWithoutMerge(JvmIdentifiableElement identifiable, @Nullable LightweightTypeReference reference) {
		getParent().reassignTypeWithoutMerge(identifiable, reference);
	}
	
	@Override
	protected void appendContent(StringBuilder result, String indentation) {
		appendContent(expectedExceptions, "expectedExceptions", result, indentation);
		super.appendContent(result, indentation);
	}

}
