/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class EObjectAtOffsetHelper {

	@Inject
	private TokenUtil tokenUtil;

	/**
	 * @return the declared or the referenced element next to the offset
	 */
	public EObject resolveElementAt(XtextResource resource, int offset) {
		return internalResolveElementAt(resource, offset, false);
	}

	/**
	 * @return the declared element next to the offset
	 * @since 2.3
	 */
	public EObject resolveContainedElementAt(XtextResource resource, int offset) {
		return internalResolveElementAt(resource, offset, true);
	}
	
	/**
	 * @return the cross referenced EObject under, right or left to the cursor (in that order) or
	 *         <code>null</code> if there is no cross referenced object next to the offset.
	 */
	public EObject resolveCrossReferencedElementAt(XtextResource resource, int offset) {
		INode node = getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (node != null)
			return getCrossReferencedElement(node);
		return null;
	}
	
	/**
	 * @since 2.1
	 */
	public INode getCrossReferenceNode(XtextResource resource, ITextRegion region) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset());
			INode crossRefNode = findCrossReferenceNode(leaf);
			// if not a cross reference position and the cursor is at the beginning of a node try the previous one.
			if (crossRefNode == null && leaf != null && region.getLength()==0 && leaf.getOffset() == region.getOffset()) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset() - 1);
				return findCrossReferenceNode(leaf);
			} else if (crossRefNode != null && crossRefNode.getEndOffset() >= region.getOffset() + region.getLength()) {
				return crossRefNode;
			}
		}
		return null;
	}
	
	/**
	 * @param node a node with an associated {@link CrossReference} grammar element.
	 * @return the {@link EObject} referenced by this node
	 * @since 2.1
	 */
	public EObject getCrossReferencedElement(INode node) {
		if (!(node.getGrammarElement() instanceof CrossReference))
			throw new IllegalArgumentException("Passed node not a cross reference node.");
		return resolveCrossReferencedElement(node);
	}

	/**
	 * @param node a node (possibly null)
	 * @return if the given node is part of a cross reference this method returns the node pointing to the
	 *         {@link CrossReference} <code>null</code> if the passed node was a null reference or if the passed node is
	 *         not part of a cross reference.
	 * @since 2.1
	 */
	protected INode findCrossReferenceNode(INode node) {
		if (node == null)
			return null;
		if (node.getGrammarElement() instanceof CrossReference)
			return node;
		while (node.getGrammarElement() != null && isElementOfDatatypeRule(node.getGrammarElement())) {
			node = node.getParent();
			if (node.getGrammarElement() instanceof CrossReference)
				return node;
		}
		return null;
	}

	/**
	 * @since 2.1
	 */
	protected boolean isElementOfDatatypeRule(final EObject grammarElement) {
		final AbstractRule rule = EcoreUtil2.getContainerOfType(grammarElement, AbstractRule.class);
		return GrammarUtil.isDatatypeRule(rule);
	}

	protected EObject internalResolveElementAt(XtextResource resource, int offset, boolean containment) {
		if(!containment) {
			EObject crossRef = resolveCrossReferencedElementAt(resource, offset);
			if (crossRef != null)
				return crossRef;
		}
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			if (leaf != null) {
				return NodeModelUtils.findActualSemanticObjectFor(leaf);
			}
			return parseResult.getRootASTElement();
		}
		return null;
	}

	protected EObject resolveCrossReferencedElement(INode node) {
		EObject referenceOwner = NodeModelUtils.findActualSemanticObjectFor(node);
		if (referenceOwner != null) {
			EReference crossReference = GrammarUtil.getReference((CrossReference) node.getGrammarElement(),
					referenceOwner.eClass());
			if (!crossReference.isMany()) {
				return (EObject) referenceOwner.eGet(crossReference);
			} else {
				List<?> listValue = (List<?>) referenceOwner.eGet(crossReference);
				List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(referenceOwner, crossReference);
				int currentIndex = 0;
				for (INode nodeForFeature : nodesForFeature) {
					if (currentIndex >= listValue.size())
						return null;
					if (nodeForFeature.getTotalOffset() <= node.getTotalOffset()
							&& nodeForFeature.getTotalEndOffset() >= node.getTotalEndOffset())
						return (EObject) listValue.get(currentIndex);
					currentIndex++;
				}
			}
		}
		return null;
	}

	/**
	 * Find the leaf node at the given offset that defines a named element or cross-references to such an element. May
	 * return <code>null</code> if the given offset is not valid or if such an object cannot be found at the given
	 * offset.
	 * 
	 * @param resource
	 *            the {@link XtextResource} May be <code>null</code>.
	 * @param offset
	 *            the offset where the leaf node is to be searched.
	 * @return the leaf node with an identifier at the given offset or <code>null</code>.
	 * @since 2.28
	 */
	public EObject getElementWithNameAt(XtextResource resource, int offset) {
		if (offset >= 0 && resource != null) {
			IParseResult parseResult = resource.getParseResult();
			if (parseResult != null) {
				ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
				if (!tokenUtil.isWhitespaceOrCommentNode(leaf)) {						
					EObject crossRef = resolveCrossReferencedElementAt(resource, offset);
					if (crossRef != null) {
						return crossRef;
					}
					EObject definition = resolveElementAt(resource, offset);
					final EStructuralFeature structuralFeature = SimpleAttributeResolver.NAME_RESOLVER.getAttribute(definition);
					List<INode> nodesForNameFeature = NodeModelUtils.findNodesForFeature(definition, structuralFeature);
					for (INode nodeForNameFeature :nodesForNameFeature) {
						for (INode leafNodeForNameFeature: nodeForNameFeature.getLeafNodes()) {							
							if (leafNodeForNameFeature.equals(leaf)) {						
								return definition;
							}
						}					
					}
				}
			}
		}
		return null;
	}
}
