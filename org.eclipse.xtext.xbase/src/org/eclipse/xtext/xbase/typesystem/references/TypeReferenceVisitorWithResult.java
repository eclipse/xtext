/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class TypeReferenceVisitorWithResult<Result> {

	protected Result doVisitTypeReference(LightweightTypeReference reference) {
		throw new UnsupportedOperationException("Missing implementation for " + reference);
	}
	
	protected Result doVisitAnyTypeReference(AnyTypeReference reference) {
		return doVisitTypeReference(reference);
	}
	
	protected Result doVisitUnknownTypeReference(UnknownTypeReference reference) {
		return doVisitTypeReference(reference);
	}
	
	protected Result doVisitCompoundTypeReference(CompoundTypeReference reference) {
		return doVisitTypeReference(reference);
	}
	
	protected Result doVisitMultiTypeReference(CompoundTypeReference reference) {
		return doVisitCompoundTypeReference(reference);
	}
	
	protected Result doVisitSynonymTypeReference(CompoundTypeReference reference) {
		return doVisitCompoundTypeReference(reference);
	}

	protected Result doVisitArrayTypeReference(ArrayTypeReference reference) {
		return doVisitTypeReference(reference);
	}

	protected Result doVisitFunctionTypeReference(FunctionTypeReference reference) {
		return doVisitParameterizedTypeReference(reference);
	}
	
	protected Result doVisitInnerFunctionTypeReference(InnerFunctionTypeReference reference) {
		return doVisitFunctionTypeReference(reference);
	}

	protected Result doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		return doVisitTypeReference(reference);
	}

	protected Result doVisitInnerTypeReference(InnerTypeReference reference) {
		return doVisitParameterizedTypeReference(reference);
	}
	
	protected Result doVisitUnboundTypeReference(UnboundTypeReference reference) {
		return doVisitTypeReference(reference);
	}

	protected Result doVisitWildcardTypeReference(WildcardTypeReference reference) {
		return doVisitTypeReference(reference);
	}
	
}
