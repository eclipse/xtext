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
public interface ITypeReferenceVisitorWithParameter<Parameter, Result> {

	Result visit(JvmTypeReference reference, Parameter param);
	
	Result doVisitTypeReference(JvmTypeReference reference, Parameter param);
	Result doVisitAnyTypeReference(JvmAnyTypeReference reference, Parameter param);
	Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Parameter param);
	Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Parameter param);
	Result doVisitInnerTypeReference(JvmInnerTypeReference reference, Parameter param);
	Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Parameter param);
	Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Parameter param);
	Result doVisitMultiTypeReference(JvmMultiTypeReference reference, Parameter param);
	Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference, Parameter param);
	Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference, Parameter param);
	Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference, Parameter param);
	Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference, Parameter param);
	
}
