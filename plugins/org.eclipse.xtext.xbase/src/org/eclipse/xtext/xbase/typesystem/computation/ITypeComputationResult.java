/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * TODO JavaDoc, toString
 */
public interface ITypeComputationResult {

	@Nullable XExpression getExpression();
	
	JvmTypeReference getActualExpressionType();
	
	@Nullable JvmTypeReference getExpectedExpressionType();
	
	@Nullable JvmTypeReference getActualType(JvmIdentifiableElement element);
	
	@Nullable JvmTypeReference resolve(@Nullable JvmTypeReference unresolved);
	
}
