/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class LazyURIEncoder {
	
	private static final String XTEXT_LINK = "xtextLink_";
	private static final String SEP = "::";

	/**
	 * encodes the given three parameters into a string, so that they can be
	 * retrieved from a resource using {@link #decode(Resource, String)}
	 * 
	 * @param obj
	 * @param ref
	 * @param node
	 * @return
	 */
	public String encode(EObject obj, EReference ref, AbstractNode node) {
		StringBuilder fragment = new StringBuilder(40).append(XTEXT_LINK).append(SEP);
		fragment.append(obj.eResource().getURIFragment(obj)).append(SEP);
		fragment.append(EcoreUtil2.toExternalForm(ref)).append(SEP);
		getRelativePath(fragment, NodeUtil.getNodeAdapter(obj).getParserNode(), node);
		return fragment.toString();
	}

	/**
	 * decodes the uriFragment
	 * 
	 * @param res
	 * @param uriFragment
	 * @return
	 */
	public Triple<EObject, EReference, AbstractNode> decode(Resource res, String uriFragment) {
		String[] split = uriFragment.split(SEP);
		EObject source = res.getEObject(split[1]);
		Registry packageRegistry = res.getResourceSet().getPackageRegistry();
		EReference ref = EcoreUtil2.getEReferenceFromExternalForm(packageRegistry,split[2]);
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(source);
		if (nodeAdapter==null)
			throw new IllegalStateException("Couldn't resolve lazy link, because no node model is attached.");
		AbstractNode text = getNode(nodeAdapter.getParserNode(), split[3]);
		return Tuples.create(source, ref, text);
	}

	/**
	 * ONLY public to be testable
	 */
	public void getRelativePath(StringBuilder result, AbstractNode parserNode, AbstractNode node) {
		if (parserNode == node)
			return;
		if (EcoreUtil.isAncestor(parserNode, node)) {
			getRelativePath(result, parserNode, node.getParent());
			result.append("/").append(node.getParent().getChildren().indexOf(node));
		} else {
			result.append("/..");
			getRelativePath(result, parserNode.getParent(), node);
		}
	}

	/**
	 * ONLY public to be testable
	 */
	public AbstractNode getNode(final AbstractNode node, String path) {
		final String[] split = path.split("/");
		AbstractNode result = node;
		for (String string : split) {
			String trimmed = string.trim();
			if (trimmed.length() > 0) {
				if ("..".equals(trimmed)) {
					if (result.getParent() == null)
						throw new IllegalStateException("node has no parent");
					result = result.getParent();
				} else {
					int index = Integer.parseInt(string);
					if (index >= 0) {
						result = ((CompositeNode) result).getChildren().get(index);
					}
				}
			}
		}
		return result;
	}

	public boolean isCrossLinkFragment(Resource res, String s) {
		return s.startsWith(XTEXT_LINK);
	}
}
