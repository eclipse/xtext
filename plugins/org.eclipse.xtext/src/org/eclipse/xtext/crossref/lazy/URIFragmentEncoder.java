/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.lazy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class URIFragmentEncoder {
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
		String fragment = XTEXT_LINK + SEP;
		fragment += obj.eResource().getURIFragment(obj) + SEP;
		fragment += EcoreUtil.getURI(ref) + SEP;
		fragment += getRelativePath(NodeUtil.getNodeAdapter(obj).getParserNode(), node);
		return fragment;
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
		EReference ref = (EReference) res.getResourceSet().getEObject(URI.createURI(split[2]), true);
		AbstractNode text = getNode(NodeUtil.getNodeAdapter(source).getParserNode(), split[3]);
		return Tuples.create(source, ref, text);
	}

	/**
	 * ONLY public to be testable
	 */
	public StringBuffer getRelativePath(AbstractNode parserNode, AbstractNode node) {
		if (parserNode == node)
			return new StringBuffer();
		StringBuffer buff = getRelativePath(parserNode, node.getParent());
		buff.append("/").append(node.getParent().getChildren().indexOf(node));
		return buff;
	}

	/**
	 * ONLY public to be testable
	 */
	public AbstractNode getNode(AbstractNode node, String path) {
		String[] split = path.split("/");
		for (String string : split) {
			if (string.trim().length() > 0) {
				Integer integer = Integer.valueOf(string);
				if (integer >= 0) {
					node = ((CompositeNode) node).getChildren().get(integer);
				}
			}
		}
		return node;
	}

	public boolean isCrossLinkFragment(Resource res, String s) {
		return s.startsWith(XTEXT_LINK);
	}
}
