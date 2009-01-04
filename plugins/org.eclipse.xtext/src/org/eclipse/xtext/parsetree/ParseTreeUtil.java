/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;

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

	private static final Logger logger = Logger.getLogger(ParseTreeUtil.class);
	/**
	 * @param rootNode
	 * @param offset
	 *            the text position within the the current sentence
	 * @return the set of elements which are <i>valid</i> or <i>possible</i>
	 *         from the given position according to the grammar
	 */
	public static Set<AbstractElement> getElementSetValidFromOffset(CompositeNode rootNode, int offset) {
		return getElementSetValidFromOffset(rootNode, getLastCompleteNodeByOffset(rootNode, offset), offset);
	}

	/**
	 * @param rootNode
	 *            the root node of the tree
	 * @param last
	 *            complete node element (with an associated grammar element)
	 *            within the given rootNode
	 * @param offset
	 *            the text position within the the current sentence
	 * @return the set of elements which are <i>valid</i> or <i>possible</i>
	 *         from the given position according to the grammar
	 */
	public static Set<AbstractElement> getElementSetValidFromOffset(CompositeNode rootNode,
			AbstractNode lastCompleteNode, int offset) {

		AbstractElement grammarElement = getGrammarElementFromNode(lastCompleteNode);

		return calculatePossibleElementSet(lastCompleteNode, grammarElement);

	}

	/**
	 * 
	 * @param abstractNode
	 *            the node to inspect
	 * @param grammarElementClass
	 *            to match
	 * @return a set of abstractNode associated with a grammarelement class
	 *         matching the given class
	 */
	public static Set<AbstractNode> getNodesByGrammarElement(AbstractNode abstractNode, Class<?> grammarElementClass) {

		assertParameterNotNull(abstractNode, "abstractNode");
		assertParameterNotNull(grammarElementClass, "grammarElementClass");

		Set<AbstractNode> abstractNodeSet = new LinkedHashSet<AbstractNode>();

		if (abstractNode.getGrammarElement() != null
				&& grammarElementClass.isAssignableFrom(abstractNode.getGrammarElement().getClass())) {
			abstractNodeSet.add(abstractNode);
		}

		for (AbstractNode leafNode : abstractNode.getLeafNodes()) {
			abstractNodeSet.addAll(getNodesByGrammarElement(leafNode, grammarElementClass));
		}

		return abstractNodeSet;
	}

	/**
	 * Dump the composite structure (parsetree) of the given node.
	 * 
	 * @param abstractNode
	 *            the node to dump
	 */
	public static final void dumpNode(AbstractNode abstractNode) {
		if (logger.isDebugEnabled()) {
			assertParameterNotNull(abstractNode, "abstractNode");
			logger.debug("dump parsetree with root node '" + EcoreUtil.getIdentification(abstractNode) + "'");
			doDumpNode(abstractNode, "\t");
		}
	}

	/**
	 * @param contextNode
	 *            the node representing the 'scope' of the current lookup
	 * @param offsetPosition
	 *            the text position within the the current sentence
	 * @return the last 'complete' (an associated grammar element is available)
	 *         node element contained within the given contextNode at the
	 *         provided position
	 */
	public static final AbstractNode getLastCompleteNodeByOffset(AbstractNode contextNode, int offsetPosition) {

		assertParameterNotNull(contextNode, "contextNode");

		AbstractNode abstractNode = contextNode.eContainer()==null ? contextNode : null;
		
		if (contextNode.getTotalOffset() < offsetPosition
				|| (0 == offsetPosition && offsetPosition == contextNode.getTotalOffset())) {

			for (AbstractNode childNode : contextNode.getLeafNodes()) {
				AbstractNode lastElementByOffset = getLastCompleteNodeByOffset(childNode, offsetPosition);

				if (lastElementByOffset != null) {
					abstractNode = lastElementByOffset;
				}
			}

			if (abstractNode == null && contextNode.getTotalOffset() + contextNode.getTotalLength() <= offsetPosition) {
				EObject grammarElement = contextNode.getGrammarElement();
				if (grammarElement instanceof AbstractElement || grammarElement instanceof ParserRule) {
					abstractNode = contextNode;
				}
			}

		}

		return abstractNode;
	}

	/**
	 * 
	 * @param contextNode
	 *            the node representing the 'scope' of the current lookup
	 * @param offsetPosition
	 *            the text position within the the current sentence
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
						
						if (abstractNode instanceof LeafNode && 
								abstractNode.getTotalOffset()==offsetPosition && ((LeafNode)abstractNode).isHidden()) {
							;
						} else {
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
	 * @param contextNode
	 *            the node representing the 'scope' of the current lookup
	 * @param offsetPosition
	 *            the text position within the the current sentence
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
//		
//		if (contextNode instanceof CompositeNode) {
//			if (contextNode.getOffset() > offsetPosition) {
//				return findFirstVisibleLeaf(contextNode);
//			} else if (contextNode.getLength() + contextNode.getOffset() <= offsetPosition){
//				return findLastVisibleLeaf(contextNode);
//			} else {
//				final List<AbstractNode> children = ((CompositeNode) contextNode).getChildren();
//				for(int i = 0; i < children.size(); i++) {
//					final AbstractNode child = children.get(i);
//					if (child.getOffset() == offsetPosition) {
//						if (child instanceof CompositeNode)
//							return findFirstVisibleLeaf(child);
//					}
//					if (child.getOffset() > offsetPosition) {
//						if (i == 0) {
//							return findFirstVisibleLeaf(child);
//						} else {
//							for (int j = i - 1; j >= 0; j--) {
//								final AbstractNode prevChild = children.get(j);
//								final LeafNode result = findLastVisibleLeaf(prevChild);
//								if (!result.isHidden())
//									return result;
//							}
//							return findFirstVisibleLeaf(child);
//						}
//					} else if (child.getTotalOffset() <= offsetPosition && child.getTotalLength() + child.getTotalOffset() > offsetPosition) {
//						LeafNode result = getCurrentOrPrecedingVisibleNodeByOffset(child, offsetPosition);
//						if (result.getSyntaxError() == null && result.isHidden()) {
//							for (int j = i - 1; j >= 0; j--) {
//								final AbstractNode prevChild = children.get(j);
//								result = findLastVisibleLeaf(prevChild);
//								if (result.getSyntaxError() != null || !result.isHidden())
//									return result;
//							}
//						}
//						return result;
//					}						
//				}
//				return findFirstVisibleLeaf(contextNode);
//			}
//		} else {
//			return (LeafNode) contextNode;
//		}

		
//		EList<LeafNode> leafNodes = contextNode.getLeafNodes();
//		for (Iterator<LeafNode> iterator = leafNodes.iterator(); iterator.hasNext() && leafNode==null;) {
//			LeafNode childNode = iterator.next();
//			if (childNode.getTotalOffset() <= offsetPosition && offsetPosition <= childNode.getTotalOffset() + childNode.getTotalLength()) {
//				if (!childNode.isHidden())
//					leafNode = childNode;
//			}
//		}
//
//		return leafNode;
	}

	
	/**
	 * 
	 * This method returns the parent grammar of the given eObject by recursive
	 * 'upwards' invocations, passing the eContainer property as parameter until
	 * some Grammar level object is reached.
	 * 
	 * @param eObject
	 *            an object contained or referenced within some 'root' grammar
	 * @return the {@link org.eclipse.xtext.Grammar} of the given object.
	 */
	public static final Grammar getGrammar(EObject eObject) {
		assertParameterNotNull(eObject, "eObject");

		if (eObject instanceof Grammar) {
			return (Grammar) eObject;
		}
		else {
			return getGrammar(eObject.eContainer());
		}

	}

	/**
	 * asserts if the given parameter object isnt null
	 * 
	 * @param parameter
	 *            reference to assert
	 * @param parameterName
	 *            the name of the parameter
	 */
	public static final void assertParameterNotNull(Object parameter, String parameterName) {
		if (parameter == null)
			throw new IllegalArgumentException("parameter '" + parameterName + "' must not be null.");
	}

	/**
	 * 
	 * @param abstractNode
	 *            the node of the asociated grammar element
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
		else if (abstractNode.getGrammarElement() instanceof ParserRule) {
			abstractElement = ((ParserRule) abstractNode.getGrammarElement()).getAlternatives();

		}
		return abstractElement;
	}

	private static Set<AbstractElement> calculatePossibleElementSet(AbstractNode contextNode,
			AbstractElement grammarElement) {

		assertParameterNotNull(contextNode, "parameter 'contextNode' must not be null");
		assertParameterNotNull(grammarElement, "parameter 'grammarElement' must not be null");

		Set<AbstractElement> elementSet = new LinkedHashSet<AbstractElement>();

		if (grammarElement.eContainer() instanceof ParserRule) {

			/**
			 * we have completed the rule of the current context.continue at the
			 * parent context
			 */
			contextNode = contextNode.getParent();

			while (contextNode != null && contextNode.getGrammarElement() == null) {
				contextNode = contextNode.getParent();
			}

			if (null != contextNode) {

				elementSet.addAll(calculatePossibleElementSet(contextNode, ParseTreeUtil
						.getGrammarElementFromNode(contextNode)));

			}
			else if (grammarElement.eContainer() instanceof ParserRule) {

				if (isDefaultRule((ParserRule) grammarElement.eContainer()) 
						|| GrammarUtil.isMultipleCardinality(grammarElement)) {
					elementSet.add(grammarElement);
				}
			}
		}
		else if (grammarElement.eContainer() instanceof Alternatives) {
			/**
			 * one out of the alternatives is already fullfilled so we can
			 * simply skip and proceed to the parent
			 */

			elementSet.addAll(calculatePossibleElementSet(contextNode, (AbstractElement) grammarElement.eContainer()));

		}
		else if (grammarElement.eContainer() instanceof Group) {

			EList<AbstractElement> contents = ((Group) grammarElement.eContainer()).getAbstractTokens();

			int indexOf = contents.indexOf(grammarElement) + 1;

			int size = contents.size();

			// add the current one if has an oneOrMore cardinality
			if (GrammarUtil.isOneOrMoreCardinality(grammarElement)) {
				elementSet.add(grammarElement);
			}

			/**
			 * start at the current (maybe the last) or at the following one
			 * with optional cardinality and add all following with optional
			 * cardinality
			 */
			AbstractElement last = GrammarUtil.isAnyCardinality(grammarElement) || indexOf == size ? grammarElement
					: contents.get(indexOf++);

			while (GrammarUtil.isOptionalCardinality(last) && indexOf < size) {
				elementSet.add(last);
				last = indexOf < size ? contents.get(indexOf++) : last;
			}

			// always add the following if available or the last one if has an
			// any cardinality
			if (last != grammarElement || GrammarUtil.isAnyCardinality(last)) {
				elementSet.add(last);
			}

			// ask parent groups only if we've completed the whole group
			if (indexOf == size) {

				boolean startedAtlastGrammarElementInGroup = last == grammarElement;

				if (startedAtlastGrammarElementInGroup || GrammarUtil.isOptionalCardinality(last)) {

					elementSet.addAll(calculatePossibleElementSet(contextNode, (AbstractElement) grammarElement
							.eContainer()));
				}
			}
		}
		else {
			elementSet.addAll(calculatePossibleElementSet(contextNode, (AbstractElement) grammarElement.eContainer()));

		}

		return elementSet;
	}

	/**
	 * @param abstractNode
	 * @param indentString
	 */
	private static final void doDumpNode(AbstractNode abstractNode, String indentString) {
		if (logger.isDebugEnabled()) {
			if (abstractNode instanceof CompositeNode) {
	
				// CompositeNode compositeNode = (CompositeNode) abstractNode;
	
				logger.debug(indentString + "line '" + abstractNode.getTotalLine() + "' offset '" + abstractNode.getTotalOffset()
						+ "'  length '" + abstractNode.getTotalLength() + "' grammar-hierarchy  ("
						+ dumpParentHierarchy(abstractNode) + ")");
	
			}
			else if (abstractNode instanceof LeafNode) {
	
				LeafNode leafNode = (LeafNode) abstractNode;
				// ommit hidden channel
				if (!leafNode.isHidden()) {
	
					logger.debug(indentString + "'" + "line '" + leafNode.getTotalLine() + "' offset '" + leafNode.getTotalOffset()
							+ " length '" + leafNode.getTotalLength() + "' "
							+ (leafNode.getFeature() != null ? leafNode.getFeature() + " = " : "") + " text '"
							+ leafNode.getText() + "' grammar-hierarchy (" + dumpParentHierarchy(leafNode) + ")");
	
				}
	
			}
	
			for (AbstractNode childNode : abstractNode.getLeafNodes()) {
				doDumpNode(childNode, indentString + indentString);
			}
		}

	}

	private static final String dumpParentHierarchy(AbstractNode abstractNode) {
		StringBuilder stringBuilder = new StringBuilder();
		while (null != abstractNode) {
			stringBuilder.append(abstractNode.getGrammarElement().getClass().getSimpleName());
			if (abstractNode.getGrammarElement() instanceof ParserRule) {
				stringBuilder.append("[" + ((ParserRule) abstractNode.getGrammarElement()).getName() + "]");
			}
			else if (abstractNode.getGrammarElement() instanceof RuleCall) {
				stringBuilder.append("[" + ((RuleCall) abstractNode.getGrammarElement()).getRule().getName() + "]");

			}
			abstractNode = abstractNode.getParent();
			if (null != abstractNode) {
				stringBuilder.append("->");
			}
		}
		return stringBuilder.toString();
	}
	
	private static boolean isDefaultRule(ParserRule parserRule) {
		return ((Grammar)parserRule.eContainer()).getRules().indexOf(parserRule)==0;
	}


}