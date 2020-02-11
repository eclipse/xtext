/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
		return getExpressionAsString(getMemberCallTarget())+
				(isExplicitStatic() ? "::" : ".")+
				getConcreteSyntaxFeatureName()+getExpressionsAsString(getMemberCallArguments(),isExplicitOperationCall());
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
		if (isStaticWithDeclaringType()) {
			return getMemberCallArguments();
		}
		return getActualArguments(getMemberCallTarget(), getMemberCallArguments());
	}
	
	@Override
	public XExpression getActualReceiver() {
		if (isStaticWithDeclaringType())
			return null;
		return getActualReceiver(getMemberCallTarget());
	}
	
	@Override
	public boolean isExtension() {
		if (isStaticWithDeclaringType()) {
			return false;
		}
		return isExtension(getMemberCallTarget());
	}
	
	@Override
	public boolean isPackageFragment() {
		ensureFeatureLinked();
		return super.isPackageFragment();
	}
	
	@Override
	public boolean isTypeLiteral() {
		ensureFeatureLinked();
		return super.isTypeLiteral();
	}
	
	@Override
	public boolean isStaticWithDeclaringType() {
		ensureFeatureLinked();
		return super.isStaticWithDeclaringType();
	}
}
