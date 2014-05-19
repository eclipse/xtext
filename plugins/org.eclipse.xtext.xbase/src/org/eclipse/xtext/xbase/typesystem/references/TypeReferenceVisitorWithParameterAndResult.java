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
public abstract class TypeReferenceVisitorWithParameterAndResult<Param, Result> {

	/* @Nullable */
	protected Result doVisitTypeReference(LightweightTypeReference reference, Param param) {
		throw new UnsupportedOperationException("Missing implementation for " + reference);
	}
	
	/* @Nullable */
	protected Result doVisitAnyTypeReference(AnyTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}
	
	/* @Nullable */
	protected Result doVisitUnknownTypeReference(UnknownTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}
	
	/* @Nullable */
	protected Result doVisitCompoundTypeReference(CompoundTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}
	
	/* @Nullable */
	protected Result doVisitMultiTypeReference(CompoundTypeReference reference, Param param) {
		return doVisitCompoundTypeReference(reference, param);
	}
	
	/* @Nullable */
	protected Result doVisitSynonymTypeReference(CompoundTypeReference reference, Param param) {
		return doVisitCompoundTypeReference(reference, param);
	}

	/* @Nullable */
	protected Result doVisitArrayTypeReference(ArrayTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	/* @Nullable */
	protected Result doVisitFunctionTypeReference(FunctionTypeReference reference, Param param) {
		return doVisitParameterizedTypeReference(reference, param);
	}

	/* @Nullable */
	protected Result doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	/* @Nullable */
	protected Result doVisitUnboundTypeReference(UnboundTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	/* @Nullable */
	protected Result doVisitWildcardTypeReference(WildcardTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}
	
}
