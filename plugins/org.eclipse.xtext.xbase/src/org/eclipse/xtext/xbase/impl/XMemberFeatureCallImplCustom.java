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
public class XMemberFeatureCallImplCustom extends XMemberFeatureCallImpl {
	
	@Override
	public String toString() {
		return getExpressionAsString(getMemberCallTarget())+"."+getConcreteSyntaxFeatureName()+getExpressionsAsString(getMemberCallArguments(),isExplicitOperationCall());
	}
	
	@Override
	public EList<XExpression> getExplicitArguments() {
		BasicEList<XExpression> result = new BasicEList<XExpression>();
		if (getMemberCallTarget()!=null)
			result.add(getMemberCallTarget());
		result.addAll(getMemberCallArguments());
		return result;
	}
	
	@Override
	public boolean isExplicitOperationCallOrBuilderSyntax() {
		return super.isExplicitOperationCall() || !getMemberCallArguments().isEmpty();
	}
	
	@Override
	public EList<XExpression> getActualArguments() {
		return getActualArguments(getMemberCallTarget(), getMemberCallArguments());
	}
	
	@Override
	public XExpression getActualReceiver() {
		return getActualReceiver(getMemberCallTarget());
	}
	
	@Override
	public boolean isExtension() {
		return isExtension(getMemberCallTarget());
	}
}
