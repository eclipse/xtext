/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class NoTypeResult implements ITypeComputationResult {

	public XExpression getExpression() {
		return null;
	}
	
	public JvmTypeReference getActualExpressionType() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public JvmTypeReference getExpectedExpressionType() {
		throw new UnsupportedOperationException("TODO implement me");
	}

	public JvmTypeReference getActualType(JvmIdentifiableElement element) {
		throw new UnsupportedOperationException("TODO implement me");
	}

	public JvmTypeReference resolve(@Nullable JvmTypeReference unresolved) {
		throw new UnsupportedOperationException("TODO implement me");
	}

}
