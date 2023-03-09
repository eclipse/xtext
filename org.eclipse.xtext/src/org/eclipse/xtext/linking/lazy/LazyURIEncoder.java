/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class LazyURIEncoder {
	
	/**
	 * @since 2.3
	 * 
	 * deprecated use {@link #isCrossLinkFragment(Resource, String)} instead
	 * 
	 * @noreference This field is not intended to be referenced by clients.
	 */
	public static final String XTEXT_LINK = "|";
	/**
	 * @since 2.3
	 * 
	 */
	public static final String SEP = "::";
	
	/**
	 * @since 2.7
	 */
	public final static String USE_INDEXED_FRAGMENTS_BINDING = "org.eclipse.xtext.linking.lazy.LazyURIEncoder.isUseIndexFragment";
			
	@Inject(optional=true) @Named(value=USE_INDEXED_FRAGMENTS_BINDING)
	private boolean isUseIndexFragment = false;
	
	/**
	 * @since 2.7
	 */
	public boolean isUseIndexFragment(Resource context) {
		return isUseIndexFragment && context instanceof LazyLinkingResource;
	}

	/**
	 * encodes the given three parameters into a string, so that they can be
	 * retrieved from a resource using {@link #decode(Resource, String)}
	 * 
	 * @param obj the feature holder
	 * @param ref the cross reference
	 * @param node the node that provided the value for the reference
	 * @return a portable string that may be used as a {@link URI#fragment() fragment}
	 */
	public String encode(EObject obj, EReference ref, INode node) {
		if (isUseIndexFragment(obj.eResource())) {
			return getIndexFragment(obj, ref, node);
		}
		StringBuilder fragment = new StringBuilder(4).append(XTEXT_LINK).append(SEP);
		appendShortFragment(obj, fragment);
		fragment.append(SEP);
		fragment.append(toShortExternalForm(obj.eClass(), ref)).append(SEP);
		getRelativePath(fragment, NodeModelUtils.getNode(obj), node);
		return fragment.toString();
	}
	
	/**
	 * @since 2.7
	 */
	protected String getIndexFragment(EObject obj, EReference ref, INode node) {
		Resource resource = obj.eResource();
		if (!(resource instanceof LazyLinkingResource)) {
			throw new IllegalStateException("Context object must be contained in a LazyLinkingResource : "+obj.eResource());
		}
		LazyLinkingResource lazyResource = (LazyLinkingResource) resource;
		int idx = lazyResource.addLazyProxyInformation(obj,ref,node);
		return XTEXT_LINK + idx;
	}

	public void appendShortFragment(EObject obj, StringBuilder target) {
		EReference containmentFeature = obj.eContainmentFeature();
		if (containmentFeature == null) {
			target.append(obj.eResource().getContents().indexOf(obj));
		} else {
			EObject container = obj.eContainer();
			appendShortFragment(container, target);
			target.append('.').append(container.eClass().getFeatureID(containmentFeature));
			if (containmentFeature.isMany()) {
				List<?> list = (List<?>) container.eGet(containmentFeature);
				target.append('.').append(list.indexOf(obj));
			}
		}
	}
	
	public String toShortExternalForm(EClass clazz, EReference ref) {
		return Integer.toString(clazz.getFeatureID(ref));
	}

	/**
	 * decodes the uriFragment
	 * 
	 * @param res the resource that contains the feature holder
	 * @param uriFragment the fragment that should be decoded
	 * @return the decoded information
	 * @see LazyURIEncoder#encode(EObject, EReference, INode)
	 */
	public Triple<EObject, EReference, INode> decode(Resource res, String uriFragment) {
		if (isUseIndexFragment(res)) {
			return getLazyProxyInformation(res, uriFragment);
		}
		List<String> split = Strings.split(uriFragment, SEP);
		EObject source = resolveShortFragment(res, split.get(1));
		EReference ref = fromShortExternalForm(source.eClass(), split.get(2));
		INode compositeNode = NodeModelUtils.getNode(source);
		if (compositeNode==null)
			throw new IllegalStateException("Couldn't resolve lazy link, because no node model is attached.");
		INode textNode = getNode(compositeNode, split.get(3));
		return Tuples.create(source, ref, textNode);
	}
	
	/**
	 * @since 2.7
	 */
	protected Triple<EObject, EReference, INode> getLazyProxyInformation(Resource res, String uriFragment) {
		if (!(res instanceof LazyLinkingResource)) {
			throw new IllegalArgumentException("Given resource not a LazyLinkingResource");
		}
		int idx = getIndex(uriFragment);
		LazyLinkingResource lazyResource = (LazyLinkingResource) res;
		return lazyResource.getLazyProxyInformation(idx);
	}

	/**
	 * @since 2.7
	 */
	public int getIndex(String uriFragment) {
		int idx = -1;
		try {
			String string = uriFragment.substring(XTEXT_LINK.length());
			idx = Integer.parseInt(string); 
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("Couldn't parse index from fragment '"+uriFragment+"'", e);
		}
		return idx;
	}

	public EObject resolveShortFragment(Resource res, String shortFragment) {
		List<String> split = Strings.split(shortFragment, '.');
		int contentsIdx = Integer.parseInt(split.get(0));
		EObject result = res.getContents().get(contentsIdx);
		int splitIdx = 1;
		while(splitIdx < split.size()) {
			int featureId = Integer.parseInt(split.get(splitIdx++));
			EReference reference = (EReference) result.eClass().getEStructuralFeature(featureId);
			if (reference.isMany()) {
				List<?> list = (List<?>) result.eGet(reference);
				int listIdx = Integer.parseInt(split.get(splitIdx++));
				result = (EObject) list.get(listIdx);
			} else {
				result = (EObject) result.eGet(reference);
			}
		}
		return result;
	}
	
	public EReference fromShortExternalForm(EClass clazz, String shortForm) {
		int featureId = Integer.parseInt(shortForm);
		return (EReference) clazz.getEStructuralFeature(featureId);
	}

	/**
	 * ONLY public to be testable
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void getRelativePath(StringBuilder result, INode parserNode, INode node) {
		if (parserNode == node)
			return;
		if (isAncestor(parserNode, node)) {
			ICompositeNode parent = node.getParent();
			getRelativePath(result, parserNode, parent);
			int idx = 0;
			INode child = parent.getFirstChild();
			while(child != node && child.hasNextSibling()) {
				idx++;
				child = child.getNextSibling();
			}
			result.append("/").append(idx);
		} else {
			result.append("/..");
			getRelativePath(result, parserNode.getParent(), node);
		}
	}
	
	protected boolean isAncestor(INode parent, INode child) {
		for (INode node = child; node != null; node = node.getParent()) {
			if (node.equals(parent)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @since 2.4
	 */
	public INode getNode(EObject object, String fragment) {
		if (isUseIndexFragment(object.eResource())) {
			return decode(object.eResource(), fragment).getThird();
		}
		INode compositeNode = NodeModelUtils.getNode(object);
		if (compositeNode == null)
			throw new IllegalStateException("Couldn't resolve lazy link, because no node model is attached.");
		List<String> split = Strings.split(fragment, LazyURIEncoder.SEP);
		INode node = getNode(compositeNode, split.get(3));
		return node;
	}

	/**
	 * ONLY public to be testable
	 */
	public INode getNode(final INode node, String path) {
		final List<String> split = Strings.split(path, '/');
		INode result = node;
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
						INode child = ((ICompositeNode) result).getFirstChild();
						while(index > 0) {
							child = child.getNextSibling();
							index--;
						}
						result = child;
					}
				}
			}
		}
		return result;
	}

	public boolean isCrossLinkFragment(Resource res, String s) {
		return s != null && s.startsWith(XTEXT_LINK);
	}
}
