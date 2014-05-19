/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class TypeReferenceVisitorWithNonNullResult<Result> extends TypeReferenceVisitorWithResult<Result> {

	@Override
	protected Result doVisitTypeReference(LightweightTypeReference reference) {
		throw new UnsupportedOperationException("Missing implementation for " + reference);
	}
	
	@Override
	protected Result doVisitAnyTypeReference(AnyTypeReference reference) {
		return doVisitTypeReference(reference);
	}
	
	@Override
	protected Result doVisitCompoundTypeReference(CompoundTypeReference reference) {
		return doVisitTypeReference(reference);
	}
	
	@Override
	protected Result doVisitMultiTypeReference(CompoundTypeReference reference) {
		return doVisitCompoundTypeReference(reference);
	}
	
	@Override
	protected Result doVisitSynonymTypeReference(CompoundTypeReference reference) {
		return doVisitCompoundTypeReference(reference);
	}

	@Override
	protected Result doVisitArrayTypeReference(ArrayTypeReference reference) {
		return doVisitTypeReference(reference);
	}

	@Override
	protected Result doVisitFunctionTypeReference(FunctionTypeReference reference) {
		return doVisitParameterizedTypeReference(reference);
	}

	@Override
	protected Result doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		return doVisitTypeReference(reference);
	}

	@Override
	protected Result doVisitUnboundTypeReference(UnboundTypeReference reference) {
		return doVisitTypeReference(reference);
	}

	@Override
	protected Result doVisitWildcardTypeReference(WildcardTypeReference reference) {
		return doVisitTypeReference(reference);
	}
	
}
