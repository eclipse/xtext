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
public class XAssignmentImplCustom extends XAssignmentImpl {
	
	@Override
	public String toString() {
		return getExpressionAsString(getAssignable())+"."+getConcreteSyntaxFeatureName()+" = "+getExpressionAsString(getValue());
	}
	
	@Deprecated
	@Override
	public EList<XExpression> getExplicitArguments() {
		BasicEList<XExpression> result = new BasicEList<XExpression>();
		if (getAssignable()!=null)
			result.add(getAssignable());
		if (getValue()!=null)
			result.add(getValue());
		return result;
	}
	
	@Override
	public EList<XExpression> getActualArguments() {
		return getActualArguments(getAssignable(), getValue());
	}
	
	@Override
	public XExpression getActualReceiver() {
		return getActualReceiver(getAssignable());
	}
	
	@Override
	public boolean isExtension() {
		return isExtension(getAssignable());
	}
}
