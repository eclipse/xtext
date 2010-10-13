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
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XAbstractFeatureCallImplCustom extends XAbstractFeatureCallImpl {
	
	@Override
	public String getFeatureName() {
		List<AbstractNode> list = NodeUtil.findNodesForFeature(this, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		if (list.size()!=1) {
			throw new IllegalStateException("A feature call should have exactly one leafnode for the 'feature' reference, but was "+list.size());
		}
		AbstractNode abstractNode = list.get(0);
		if (abstractNode instanceof LeafNode) {
			return abstractNode.serialize();
		}
		EList<LeafNode> leafNodes = abstractNode.getLeafNodes();
		StringBuilder result = new StringBuilder();
		for (LeafNode leafNode : leafNodes) {
			if (!leafNode.isHidden())
				result.append(leafNode.getText());
		}
		return result.toString();
	}
	
	protected String getExpressionsAsString(List<XExpression> expressions) {
		if (expressions.isEmpty())
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
}
