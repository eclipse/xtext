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

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class URIFragmentEncoder {
	
	private static final String XTEXT_LINK = "xtextLink_";
	private static final String SEP = "::";
	
	public static class Data {
		private final EObject rootModel;
		private final EObject context;
		private final EReference reference;
		private final AbstractNode node;
		
		public Data(EObject rootModel, EObject context, EReference reference, AbstractNode node) {
			this.rootModel = rootModel;
			this.context = context;
			this.reference = reference;
			this.node = node;
		}

		public EObject getRootModel() {
			return rootModel;
		}

		public EObject getContext() {
			return context;
		}

		public EReference getReference() {
			return reference;
		}

		public AbstractNode getNode() {
			return node;
		}
	}

	/**
	 * encodes the given three parameters into a string, so that they can be
	 * retrieved from a resource using {@link #decode(Resource, String)}
	 * 
	 * @param obj
	 * @param ref
	 * @param node
	 * @return
	 */
	public String encode(EObject rootModel, EObject context, EReference ref, AbstractNode node) {
		StringBuilder fragment = new StringBuilder(40).append(XTEXT_LINK).append(SEP);
		fragment.append(rootModel.eResource().getURIFragment(rootModel)).append(SEP);
		fragment.append(context.eResource().getURIFragment(context)).append(SEP);
		fragment.append(EcoreUtil.getURI(ref)).append(SEP);
		getRelativePath(fragment, NodeUtil.getNodeAdapter(context).getParserNode(), node);
		return fragment.toString();
	}

	/**
	 * decodes the uriFragment
	 * 
	 * @param res
	 * @param uriFragment
	 * @return
	 */
	public Data decode(Resource res, String uriFragment) {
		String[] split = uriFragment.split(SEP);
		EObject rootModel = res.getEObject(split[1]);
		EObject context = res.getEObject(split[2]);
		EReference ref = (EReference) res.getResourceSet().getEObject(URI.createURI(split[3]), true);
		AbstractNode node = getNode(NodeUtil.getNodeAdapter(context).getParserNode(), split[4]);
		return new Data(rootModel, context, ref, node);
	}

	/**
	 * ONLY public to be testable
	 */
	public void getRelativePath(StringBuilder result, AbstractNode parserNode, AbstractNode node) {
		if (parserNode == node)
			return;
		getRelativePath(result, parserNode, node.getParent());
		result.append("/").append(node.getParent().getChildren().indexOf(node));
	}

	/**
	 * ONLY public to be testable
	 */
	public AbstractNode getNode(final AbstractNode node, String path) {
		final String[] split = path.split("/");
		AbstractNode result = node;
		for (String string : split) {
			if (string.trim().length() > 0) {
				int index = Integer.parseInt(string);
				if (index >= 0) {
					result = ((CompositeNode) result).getChildren().get(index);
				}
			}
		}
		return result;
	}

	public boolean isCrossLinkFragment(Resource res, String s) {
		return s.startsWith(XTEXT_LINK);
	}
}
