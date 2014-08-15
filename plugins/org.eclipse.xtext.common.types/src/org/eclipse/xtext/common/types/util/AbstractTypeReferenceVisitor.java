/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	public Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference) {
		Result result = visit(reference.getDelegate());
		return result;
	}
	
	public Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference) {
		Result result = visit(reference.getEquivalent());
		return result;
	}
	
	public static class InheritanceAware<Result> extends AbstractTypeReferenceVisitor<Result> {

		public Result doVisitTypeReference(JvmTypeReference reference) {
			throw new IllegalStateException("doVisitTypeReference was invoked but not implemented for: " + reference);
		}

		public Result doVisitAnyTypeReference(JvmAnyTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
			return doVisitTypeReference(reference);
		}
		
		public Result doVisitInnerTypeReference(JvmInnerTypeReference reference) {
			return doVisitParameterizedTypeReference(reference);
		}

		public Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitMultiTypeReference(JvmMultiTypeReference reference) {
			return doVisitCompoundTypeReference(reference);
		}

		public Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference) {
			return doVisitCompoundTypeReference(reference);
		}

		public Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference) {
			return doVisitTypeReference(reference);
		}
		
	}
	
}
