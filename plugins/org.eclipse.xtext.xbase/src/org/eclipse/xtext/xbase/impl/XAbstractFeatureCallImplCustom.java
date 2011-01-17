/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XAbstractFeatureCallImplCustom extends XAbstractFeatureCallImpl {
	
	
	@Override
	public String getFeatureName() {
		List<INode> list = NodeModelUtils.findNodesForFeature(this, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		if (list.size()!=1) {
			throw new IllegalStateException("A feature call should have exactly one leafnode for the 'feature' reference, but was "+list.size());
		}
		INode node = list.get(0);
		if (node instanceof ILeafNode) {
			return node.getText();
		}
		StringBuilder result = new StringBuilder();
		for(ILeafNode leafNode: node.getLeafNodes()) {
			if (!leafNode.isHidden())
				result.append(leafNode.getText());
		}
		return result.toString();
	}
	
	protected String getExpressionsAsString(List<XExpression> expressions, boolean explicitOperationCall) {
		if (!explicitOperationCall && expressions.isEmpty())
			return "";
		String s = "(";
		for (Iterator<XExpression> iterator = expressions.iterator(); iterator.hasNext();) {
			XExpression type = iterator.next();
			s+=getExpressionAsString(type);
			if (iterator.hasNext())
				s+=",";
		}
		return s+")";
	}
	
	protected String getExpressionAsString(XExpression x) {
		if (x == null)
			return "<null>";
		return "<"+x.getClass().getSimpleName()+">";
	}

	protected EList<XExpression> asArguments(XExpression... arguments) {
		EList<XExpression> result = new EObjectResolvingEList<XExpression>(XExpression.class, this, XbasePackage.XABSTRACT_FEATURE_CALL__ARGUMENTS);
		for (XExpression arg : arguments) {
			if(arg != null){
				result.add(arg);
			}
		}
		return result;
	}
	
	@Override
	public JvmIdentifyableElement getImplicitReceiver() {
		// call getFeature(), because the implicitReceiver is set as a side effect of a resolution of the feature.
		// see {@link org.eclipse.xtext.xbase.linking.BestMatchingJvmFeatureScope#setImplicitReceiver(IEObjectDescription)}
		getFeature();
		return super.getImplicitReceiver();
	}
	
	@Override
	public boolean isTargetsMemberSyntaxCall() {
		// call getFeature(), because the implicitReceiver is set as a side effect of a resolution of the feature.
		// see {@link org.eclipse.xtext.xbase.linking.BestMatchingJvmFeatureScope#setImplicitReceiver(IEObjectDescription)}
		getFeature();
		return super.isTargetsMemberSyntaxCall();
	}
	
	@Override
	public boolean isValidFeature() {
		return Strings.isEmpty(getInvalidFeatureIssueCode());
	}
	
	@Override
	public String getInvalidFeatureIssueCode() {
		// call getFeature(), because the implicitReceiver is set as a side effect of a resolution of the feature.
		// see {@link org.eclipse.xtext.xbase.linking.BestMatchingJvmFeatureScope#setImplicitReceiver(IEObjectDescription)}
		getFeature();
		return super.getInvalidFeatureIssueCode();
	}
	
	
}
