/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class NodeUtil {
	public static NodeAdapter getNodeAdapter(EObject obj) {
		return (NodeAdapter) EcoreUtil.getAdapter(obj.eAdapters(), AbstractNode.class);
	}
	
	protected static boolean removeNodeAdapter(EObject obj) {
		NodeAdapter adapter = getNodeAdapter(obj);
		if (adapter == null)
			return false;
		while (adapter!=null) {
			adapter.getParserNode().setParent(null);
			adapter = getNodeAdapter(obj);
		}
		return true;
	}

	public static CompositeNode getRootNode(EObject obj) {
		NodeAdapter adapter = getNodeAdapter(obj);
		if (adapter==null)
			return null;
		CompositeNode parserNode = adapter.getParserNode();
		if (parserNode==null)
			return null;
		return (CompositeNode) EcoreUtil.getRootContainer(parserNode);
	}
}
