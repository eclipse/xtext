/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IXExpressionTypeProvider {

	/**
	 * implementers assure that they never call {@link #getExpectedType(XExpression)} for the given expression.
	 * This method is mostly used from linking and from within implementations of {@link #getType(XExpression)}.
	 * 
	 * @return the type of expression - which might not be fully resolved (i.e. has unbound TypeParameters).
	 */
	public JvmTypeReference getSelfContainedType(XExpression expression);
	
	/**
	 * implementers assure that they never call {@link #getType(XExpression)} on the given expression, to avoid
	 * stack over flows.
	 * This method is mostly used from linking and from within implementations of {@link #getType(XExpression)}.
	 * 
	 * @return the expected type of the given expression - might not be fully resolved
	 */
	public JvmTypeReference getExpectedType(XExpression expression);
	
	/**
	 * @return the fully-resolved type of this expression, given a correct, fully-linkable model is given.
	 */
	public JvmTypeReference getType(XExpression expression);
	
	
}
