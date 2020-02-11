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
public abstract class TypeReferenceVisitorWithParameterAndResult<Param, Result> {

	/**
	 * @param param
	 *            some parameter.
	 */
	protected Result doVisitTypeReference(LightweightTypeReference reference, Param param) {
		throw new UnsupportedOperationException("Missing implementation for " + reference);
	}

	protected Result doVisitAnyTypeReference(AnyTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	protected Result doVisitUnknownTypeReference(UnknownTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	protected Result doVisitCompoundTypeReference(CompoundTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	protected Result doVisitMultiTypeReference(CompoundTypeReference reference, Param param) {
		return doVisitCompoundTypeReference(reference, param);
	}

	protected Result doVisitSynonymTypeReference(CompoundTypeReference reference, Param param) {
		return doVisitCompoundTypeReference(reference, param);
	}

	protected Result doVisitArrayTypeReference(ArrayTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	protected Result doVisitFunctionTypeReference(FunctionTypeReference reference, Param param) {
		return doVisitParameterizedTypeReference(reference, param);
	}

	protected Result doVisitInnerFunctionTypeReference(InnerFunctionTypeReference reference, Param param) {
		return doVisitFunctionTypeReference(reference, param);
	}

	protected Result doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	protected Result doVisitInnerTypeReference(InnerTypeReference reference, Param param) {
		return doVisitParameterizedTypeReference(reference, param);
	}

	protected Result doVisitUnboundTypeReference(UnboundTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

	protected Result doVisitWildcardTypeReference(WildcardTypeReference reference, Param param) {
		return doVisitTypeReference(reference, param);
	}

}
