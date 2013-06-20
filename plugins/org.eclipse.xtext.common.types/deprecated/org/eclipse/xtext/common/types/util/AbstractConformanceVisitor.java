/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public abstract class AbstractConformanceVisitor<T extends JvmTypeReference> extends 
		AbstractTypeReferenceVisitorWithParameter.InheritanceAware<TypeConformanceComputationArgument.Internal<T>, TypeConformanceResult> {
	
	@Override
	protected TypeConformanceResult handleNullReference(TypeConformanceComputationArgument.Internal<T> parameter) {
		return new TypeConformanceResult(
				TypeConformanceResult.Kind.EXCEPTION, 
				new NullPointerException("Reference was null. Arguments were: " + parameter));
	}
	
}