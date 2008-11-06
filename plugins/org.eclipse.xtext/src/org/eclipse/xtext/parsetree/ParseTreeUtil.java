/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
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
		assertParameterNotNull(abstractNode, "abstractNode");
		logger.debug("dump parsetree with root node '" + EcoreUtil.getIdentification(abstractNode) + "'");
		doDumpNode(abstractNode, "\t");
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

		AbstractNode abstractNode = null;

		if (contextNode.getOffset() < offsetPosition
				|| (0 == offsetPosition && offsetPosition == contextNode.getOffset())) {

			for (AbstractNode childNode : contextNode.getLeafNodes()) {
				AbstractNode lastElementByOffset = getLastCompleteNodeByOffset(childNode, offsetPosition);

				if (lastElementByOffset != null) {
					abstractNode = lastElementByOffset;
				}
			}

			if (abstractNode == null && contextNode.getOffset() + contextNode.getLength() <= offsetPosition) {
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
	public static final LeafNode getCurrentNodeByOffset(AbstractNode contextNode, int offsetPosition) {

		assertParameterNotNull(contextNode, "contextNode");

		LeafNode leafNode = null;

		EList<LeafNode> leafNodes = contextNode.getLeafNodes();
		for (Iterator<LeafNode> iterator = leafNodes.iterator(); iterator.hasNext() && leafNode==null;) {
			LeafNode childNode = iterator.next();
			if (childNode.getOffset() <= offsetPosition && offsetPosition <= childNode.getOffset() + childNode.getLength()) {
				leafNode = (LeafNode) childNode;
			}
		}

		return leafNode;
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
			boolean hasLeafNodes = false;

			for (Iterator<LeafNode> iterator = contextNode.getLeafNodes().listIterator(); !hasLeafNodes
					&& iterator.hasNext(); hasLeafNodes = !iterator.next().isHidden()) {
				;
			}

			contextNode = contextNode.getParent();

			while (contextNode != null && contextNode.getGrammarElement() == null) {
				contextNode = contextNode.getParent();
			}

			if (null != contextNode) {

				elementSet.addAll(calculatePossibleElementSet(contextNode, ParseTreeUtil
						.getGrammarElementFromNode(contextNode)));

			}
			else if (grammarElement.eContainer() instanceof ParserRule) {

				if (!hasLeafNodes || GrammarUtil.isMultipleCardinality(grammarElement)) {
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

		if (abstractNode instanceof CompositeNode) {

			// CompositeNode compositeNode = (CompositeNode) abstractNode;

			logger.debug(indentString + "line '" + abstractNode.getLine() + "' offset '" + abstractNode.getOffset()
					+ "'  length '" + abstractNode.getLength() + "' grammar-hierarchy  ("
					+ dumpParentHierarchy(abstractNode) + ")");

		}
		else if (abstractNode instanceof LeafNode) {

			LeafNode leafNode = (LeafNode) abstractNode;
			// ommit hidden channel
			if (!leafNode.isHidden()) {

				logger.debug(indentString + "'" + "line '" + leafNode.getLine() + "' offset '" + leafNode.getOffset()
						+ " length '" + leafNode.getLength() + "' "
						+ (leafNode.getFeature() != null ? leafNode.getFeature() + " = " : "") + " text '"
						+ leafNode.getText() + "' grammar-hierarchy (" + dumpParentHierarchy(leafNode) + ")");

			}

		}

		for (AbstractNode childNode : abstractNode.getLeafNodes()) {
			doDumpNode(childNode, indentString + indentString);
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
				stringBuilder.append("[" + ((RuleCall) abstractNode.getGrammarElement()).getName() + "]");

			}
			abstractNode = abstractNode.getParent();
			if (null != abstractNode) {
				stringBuilder.append("->");
			}
		}
		return stringBuilder.toString();
	}

}