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
public abstract class AbstractTypeReferenceVisitorWithParameter<Parameter, Result> implements ITypeReferenceVisitorWithParameter<Parameter, Result> {

	public Result visit(JvmTypeReference reference, Parameter parameter) {
		if (reference == null) {
			Result result = handleNullReference(parameter);
			return result;
		}
		Result result = reference.accept(this, parameter);
		return result;
	}
	
	protected Result handleNullReference(Parameter parameter) {
		throw new NullPointerException("Given type reference was null");
	}
	
	public Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference, Parameter parameter) {
		Result result = visit(reference.getDelegate(), parameter);
		return result;
	}
	
	public Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference, Parameter parameter) {
		Result result = visit(reference.getEquivalent(), parameter);
		return result;
	}
	
	public static class InheritanceAware<Parameter, Result> extends AbstractTypeReferenceVisitorWithParameter<Parameter, Result> {

		public Result doVisitTypeReference(JvmTypeReference reference, Parameter param) {
			throw new IllegalStateException("doVisitTypeReference was invoked but not implemented for: " + reference + " / " + param);
		}

		public Result doVisitAnyTypeReference(JvmAnyTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}
		
		public Result doVisitInnerTypeReference(JvmInnerTypeReference reference, Parameter param) {
			return doVisitParameterizedTypeReference(reference, param);
		}

		public Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitMultiTypeReference(JvmMultiTypeReference reference, Parameter param) {
			return doVisitCompoundTypeReference(reference, param);
		}

		public Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference, Parameter param) {
			return doVisitCompoundTypeReference(reference, param);
		}

		public Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}
		
	}
}
