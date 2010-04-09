/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.ParserRule;

/**
 *
 * Represents a class wich provides various static helper functions used to
 * support the work with object models containing
 * {@link org.eclipse.xtext.AbstractElement} and
 * {@link org.eclipse.xtext.parsetree.AbstractNode} composite structure models.
 *
 *
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 *
 * @see org.eclipse.xtext.AbstractElement
 * @see org.eclipse.xtext.parsetree.AbstractNode
 */
public final class ParseTreeUtil {

	/**
	 * @param contextNode		the node representing the 'scope' of the current lookup
	 * @param offsetPosition	the text position within the the current sentence
	 * @return the last 'complete' (an associated grammar element is available)
	 *         node element contained within the given contextNode at the
	 *         provided position
	 */
	public static final AbstractNode getLastCompleteNodeByOffset(AbstractNode contextNode, int offsetPosition) {
		assertParameterNotNull(contextNode, "contextNode");
		AbstractNode result = contextNode.eContainer()==null ? contextNode : null;
		TreeIterator<EObject> allContentsTreeIterator = EcoreUtil.getRootContainer(contextNode).eAllContents();
		while (allContentsTreeIterator.hasNext()) {
			EObject eObject = allContentsTreeIterator.next();
			if (eObject instanceof AbstractNode) {
				AbstractNode abstractNode = (AbstractNode) eObject;
				if (abstractNode.getOffset() >= offsetPosition ) {
					break;
				} else if ((abstractNode instanceof LeafNode || null == result) &&
						   (abstractNode.getGrammarElement() == null ||
						    abstractNode.getGrammarElement() instanceof AbstractElement ||
					    	abstractNode.getGrammarElement() instanceof ParserRule)) {
					result = abstractNode;
				}
			}
		}
		return result;
	}
	/**
	 * @param contextNode		the node representing the 'scope' of the current lookup
	 * @param offsetPosition	the text position within the the current sentence
	 *
	 * @return the node element that starts at or spans across the provided position
	 */
	public static final AbstractNode getCurrentOrFollowingNodeByOffset(AbstractNode contextNode, int offsetPosition) {
		assertParameterNotNull(contextNode, "contextNode");

		AbstractNode result = contextNode;
		TreeIterator<EObject> allContentsTreeIterator = EcoreUtil.getRootContainer(contextNode).eAllContents();

		while (allContentsTreeIterator.hasNext()) {
			EObject eObject = allContentsTreeIterator.next();
			if (eObject instanceof AbstractNode) {
				AbstractNode abstractNode = (AbstractNode) eObject;
				if ((abstractNode.getTotalOffset() + abstractNode.getTotalLength())<offsetPosition ) {
					allContentsTreeIterator.prune();
				} else if (abstractNode.getTotalOffset() <= offsetPosition &&
						           		  offsetPosition <= abstractNode.getTotalOffset() + abstractNode.getTotalLength()) {
					if (abstractNode.getTotalLength() > 0
							|| (result==null || result.getTotalLength()==0)) {

						if (!(abstractNode instanceof LeafNode &&
								abstractNode.getTotalOffset()==offsetPosition && ((LeafNode)abstractNode).isHidden())) {
							result = abstractNode;
						}
					}
				} else if (abstractNode.getTotalOffset() > offsetPosition ) {
					break;
				}
			}
		}

		return null==result ? contextNode : result;
	}
	/**
	 * @param contextNode		the node representing the 'scope' of the current lookup
	 * @param offsetPosition	the text position within the the current sentence
	 *
	 * @return the node element that starts at or spans across the provided position
	 */
	public static final AbstractNode getCurrentOrPrecedingNodeByOffset(AbstractNode contextNode, int offsetPosition) {
		assertParameterNotNull(contextNode, "contextNode");

		if (contextNode.getTotalOffset() > offsetPosition || contextNode.getTotalOffset() + contextNode.getTotalLength() < offsetPosition)
			throw new IllegalArgumentException("contextNode does not cover offsetPosition: " + contextNode + "/" + offsetPosition);

		int offset = contextNode.getOffset();
		if (offset > offsetPosition || offset + contextNode.getLength() < offsetPosition)
			return contextNode;

		if (contextNode instanceof CompositeNode) {
			final List<AbstractNode> children = ((CompositeNode) contextNode).getChildren();
			for(int i = 0; i < children.size(); i++) {
				AbstractNode child = children.get(i);
				int childOffset = child.getOffset();
				if (childOffset <= offsetPosition && offsetPosition <= childOffset + child.getLength()) {
					AbstractNode result = getCurrentOrPrecedingNodeByOffset(child, offsetPosition);
					if (result instanceof LeafNode && ((LeafNode) result).isHidden() && offsetPosition < childOffset + child.getLength())
						return contextNode;
					if (!(result instanceof LeafNode && ((LeafNode) result).isHidden()))
						return result;
				}
				if (child.getTotalOffset() > offsetPosition) {
					return contextNode;
				}
			}
		}
		return contextNode;
	}

	/**
	 * asserts if the given parameter object isnt null
	 *
	 * @param parameter		the reference to assert
	 * @param parameterName	the name of the parameter
	 */
	public static final void assertParameterNotNull(Object parameter, String parameterName) {
		if (parameter == null)
			throw new IllegalArgumentException("parameter '" + parameterName + "' must not be null.");
	}
	/**
	 *
	 * @param abstractNode	the node of the asociated grammar element
	 *
	 * @return the grammar element of the given node or null if its neither a
	 *         abstractElement or a parserRule
	 */
	public static final AbstractElement getGrammarElementFromNode(AbstractNode abstractNode) {
		assertParameterNotNull(abstractNode, "abstractNode");

		AbstractElement abstractElement = null;

		if (abstractNode.getGrammarElement() instanceof AbstractElement) {
			abstractElement = (AbstractElement) abstractNode.getGrammarElement();
		}
		else if ((abstractNode.getGrammarElement() instanceof ParserRule) ||
				(abstractNode.getGrammarElement() instanceof EnumRule)) {
			abstractElement = ((AbstractRule) abstractNode.getGrammarElement()).getAlternatives();

		}
		return abstractElement;
	}

}