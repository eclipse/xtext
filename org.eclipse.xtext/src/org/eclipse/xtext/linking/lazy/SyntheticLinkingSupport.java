/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;

/**
 * Provides services to install proxies without node model.
 * 
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.7
 */
public class SyntheticLinkingSupport {
	
	@Inject
	private LazyLinker lazyLinker;
	
	public void createAndSetProxy(EObject obj, EReference eRef, String crossRefString) {
		createAndSetProxy(obj, eRef, crossRefString, 0, 1);
	}
	
	/**
	 * @since 2.10
	 */
	public void createAndSetProxy(EObject obj, EReference eRef, String crossRefString, int offset, int length) {
		INode crossReferenceNode = createCrossReferenceNode(obj, eRef, crossRefString, offset, length);
		lazyLinker.createAndSetProxy(obj, crossReferenceNode, eRef);
	}
	
	/**
	 * @since 2.10
	 */
	protected INode createCrossReferenceNode(EObject obj, EReference eRef, String crossRefString, int offset, int length) {
		CompositeNode parent = getParent(obj, eRef, crossRefString, offset, length);
		EObject grammarElement = getGrammarElement(obj, eRef, crossRefString, offset, length);
		return new SyntheticLinkingLeafNode(obj, crossRefString, offset, length, grammarElement, parent);
	}

	/**
	 * @since 2.10
	 */
	protected EObject getGrammarElement(EObject obj, EReference eRef, String crossRefString, int offset, int length) {
		return XtextFactory.eINSTANCE.createKeyword();
	}

	/**
	 * @since 2.10
	 */
	protected CompositeNode getParent(EObject obj, EReference eRef, String crossRefString, int offset, int length) {
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node != null) {
			ICompositeNode rootNode = node.getRootNode();
			if (rootNode instanceof CompositeNode)
				return (CompositeNode) rootNode;
		}
		Resource resource = obj.eResource();
		if (resource instanceof XtextResource) {
			IParseResult parseResult = ((XtextResource) resource).getParseResult();
			if (parseResult != null) {
				ICompositeNode rootNode = parseResult.getRootNode();
				if (rootNode instanceof CompositeNode)
					return (CompositeNode) rootNode;
			}
		}
		return null;
	}

}

class SyntheticLinkingLeafNode extends LeafNode {

	private final String text;
	private final EObject semanticElement;

	public SyntheticLinkingLeafNode(EObject semanticElement, String text, int offset, int length, EObject grammarElement, CompositeNode parent) {
		this.text = text;
		this.semanticElement = semanticElement;

		basicSetTotalOffset(offset);
		basicSetTotalLength(length);
		basicSetGrammarElement(grammarElement);
		basicSetParent(parent);
	}
	
	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public EObject getSemanticElement() {
		return semanticElement;
	}
	
	@Override
	protected EObject basicGetSemanticElement() {
		return semanticElement;
	}
	
	@Override
	protected boolean basicHasSiblings() {
		return false;
	}
	
	@Override
	protected boolean basicHasNextSibling() {
		return false;
	}
	
	@Override
	protected boolean basicHasPreviousSibling() {
		return false;
	}

}
