/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XBinaryOperationImplCustom extends XBinaryOperationImpl {
	
	@Override
	public EList<XExpression> getAllArguments() {
		EList<XExpression> result = new BasicEList<XExpression>(3);
		if (getImplicitReceiver()!=null) {
			result.add(getImplicitReceiver());
		}
		result.add(getLeftOperand());
		result.add(getRightOperand());
		return result;
	}

	@Override
	public String toString() {
		return getExpressionAsString(getLeftOperand())+" "+getConcreteSyntaxFeatureName()+" "+getExpressionAsString(getLeftOperand());
	}
}
