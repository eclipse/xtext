/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.xtend2.impl;

import java.util.List;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DeclaredDependencyImplCustom extends DeclaredDependencyImpl {

	@Override
	public String getName() {
		if (super.getName() != null) {
			return super.getName();
		}
		List<INode> list = NodeModelUtils.findNodesForFeature(getType(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		if (list.size()!=1) {
			return "<unkown>";
		}
		StringBuilder result = new StringBuilder();
		for(INode node: list) {
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden())
					result.append(leaf.getText());
			}
		}
		final String qualifiedName = result.toString();
		int indexOf = qualifiedName.lastIndexOf('.');
		final String simpleName = indexOf==-1?qualifiedName: qualifiedName.substring(indexOf+1);
		return Strings.toFirstLower(simpleName);
	}

	protected void internalAppend(INode node, List<INode> result) {
		result.add(node);
		if (node instanceof ICompositeNode) {
			ICompositeNode composite = (ICompositeNode) node;
			for (INode n : composite.getChildren())
				internalAppend(n, result);
		}
	}

	@Override
	public String getSimpleName() {
		return getName();
	}

	@Override
	public String getIdentifier() {
		return eContainer != null ? ((XtendClass) eContainer()).getIdentifier() + "." + getSimpleName()
				: getSimpleName();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return eContainer != null ? ((XtendClass) eContainer()).getQualifiedName(innerClassDelimiter) + "." + getSimpleName()
				: getSimpleName();
	}
}
