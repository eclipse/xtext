/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.EnumSet;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeComputationResult {

	LightweightTypeReference getActualExpressionType();
	
	LightweightTypeReference getReturnType();
	
	@Nullable LightweightTypeReference getExpectedExpressionType();
	
	@Nullable LightweightTypeReference getActualType(JvmIdentifiableElement element);
	
	@Nullable XExpression getExpression();
	
	@Nullable EnumSet<ConformanceHint> getConformanceHints();
	
}
