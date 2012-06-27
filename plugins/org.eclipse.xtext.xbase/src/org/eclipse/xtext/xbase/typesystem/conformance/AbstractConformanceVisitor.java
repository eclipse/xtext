/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndNonNullResult;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConformanceVisitor<T extends LightweightTypeReference>
		extends	TypeReferenceVisitorWithParameterAndNonNullResult<TypeConformanceComputationArgument.Internal<T>, TypeConformanceResult> {

}