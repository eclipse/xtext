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

	public JvmTypeReference getConvertedType(XExpression astNode);
	public JvmTypeReference getType(XExpression astNode);
	
	public JvmTypeReference getConvertedExpectedType(XExpression astNode);
	public JvmTypeReference getExpectedType(XExpression astNode);
	
}
