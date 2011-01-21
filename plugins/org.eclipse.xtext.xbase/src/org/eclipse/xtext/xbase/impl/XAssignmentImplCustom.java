/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import static java.util.Collections.*;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XAssignmentImplCustom extends XAssignmentImpl {
	
	@Override
	public EList<XExpression> getAllArguments() {
		EList<XExpression> result = new BasicEList<XExpression>(3);
		XExpression receiver = getActualReceiver();
		if (receiver!=null)
			result.add(receiver);
		result.add(getValue());
		return result;
	}
	
	@Override
	public EList<XExpression> getActualArguments() {
		return new BasicEList<XExpression>(singleton(getValue()));
	}
	
	@Override
	public XExpression getActualReceiver() {
		if (getImplicitReceiver()!=null) {
			return getImplicitReceiver();
		}
		return getAssignable();
	}
	
	@Override
	public String toString() {
		return getExpressionAsString(getAssignable())+" "+getConcreteSyntaxFeatureName()+" "+getExpressionAsString(getValue());
	}
}
