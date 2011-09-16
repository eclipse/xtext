/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.impl.JvmUnknownTypeReferenceImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeReferenceVisitor<Result> {

	Result visit(JvmTypeReference reference);
	
	Result doVisitTypeReference(JvmTypeReference reference);
	Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference);
	Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference);
	Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference);
	Result doVisitMultiTypeReference(JvmMultiTypeReference reference);
	Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference);
	Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference);
	Result doVisitUnknownTypeReference(JvmUnknownTypeReferenceImpl reference);
	Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference);
	
}
