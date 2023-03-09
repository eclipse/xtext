/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeReferenceVisitor<Result> implements ITypeReferenceVisitor<Result> {

	@Override
	public Result visit(JvmTypeReference reference) {
		if (reference == null) {
			Result result = handleNullReference();
			return result;
		}
		Result result = reference.accept(this);
		return result;
	}
	
	protected Result handleNullReference() {
		throw new NullPointerException("Given type reference was null");
	}
	
	@Override
	public Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference) {
		Result result = visit(reference.getDelegate());
		return result;
	}
	
	@Override
	public Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference) {
		Result result = visit(reference.getEquivalent());
		return result;
	}
	
	public static class InheritanceAware<Result> extends AbstractTypeReferenceVisitor<Result> {

		@Override
		public Result doVisitTypeReference(JvmTypeReference reference) {
			throw new IllegalStateException("doVisitTypeReference was invoked but not implemented for: " + reference);
		}

		@Override
		public Result doVisitAnyTypeReference(JvmAnyTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		@Override
		public Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		@Override
		public Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
			return doVisitTypeReference(reference);
		}
		
		@Override
		public Result doVisitInnerTypeReference(JvmInnerTypeReference reference) {
			return doVisitParameterizedTypeReference(reference);
		}

		@Override
		public Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		@Override
		public Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		@Override
		public Result doVisitMultiTypeReference(JvmMultiTypeReference reference) {
			return doVisitCompoundTypeReference(reference);
		}

		@Override
		public Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference) {
			return doVisitCompoundTypeReference(reference);
		}

		@Override
		public Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference) {
			return doVisitTypeReference(reference);
		}
		
	}
	
}
