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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
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
 * 
 * @see org.eclipse.xtext.AbstractElement
 * @see org.eclipse.xtext.parsetree.AbstractNode
 */
public final class ParseTreeUtil {

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
		System.out.println("dump parsetree with root node '" + EcoreUtil.getIdentification(abstractNode) + "'");
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

			if (contextNode.getGrammarElement() instanceof AbstractElement
					|| contextNode.getGrammarElement() instanceof ParserRule) {

				abstractNode = contextNode;
			}
			for (AbstractNode childNode : contextNode.getLeafNodes()) {

				AbstractNode lastElementByOffset = getLastCompleteNodeByOffset(childNode, offsetPosition);

				if (lastElementByOffset != null) {
					abstractNode = lastElementByOffset;
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
	 * @return the last node element at the provided position
	 */
	public static final LeafNode getCurrentNodeByOffset(AbstractNode contextNode, int offsetPosition) {

		assertParameterNotNull(contextNode, "contextNode");

		LeafNode leafNode = null;

		for (AbstractNode childNode : contextNode.getLeafNodes()) {

			if (childNode.getOffset() + childNode.getLength() <= offsetPosition) {
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
		} else {
			return getGrammar(eObject.eContainer());
		}

	}

	//
	// /**
	// *
	// * Returns a list of all assignment to the given rule.
	// *
	// * @param parserRule
	// * the rule of the assignments (ruleCall) to match
	// * @return a list containing all {@see org.eclipse.xtext.Assignment} to
	// the
	// * given rule.
	// */
	// public static final List<AbstractElement>
	// getParserRuleAssignments(ParserRule parserRule) {
	// assertParameterNotNull(parserRule, "parserRule");
	// List<AbstractElement> list = new ArrayList<AbstractElement>();
	// Grammar grammar = (Grammar) parserRule.eContainer();
	// // filter and search
	// for (ParserRule rule : GrammarUtil.allParserRules(grammar)) {
	// // excluded?
	// if (!parserRule.equals(rule)) {
	// Assignment ruleAssignment =
	// getParserRuleAssignment(rule.getAlternatives(), parserRule);
	// if (ruleAssignment != null) {
	// list.add(ruleAssignment);
	// }
	// }
	// }
	// return list;
	// }

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
		} else if (abstractNode.getGrammarElement() instanceof ParserRule) {
			abstractElement = ((ParserRule) abstractNode.getGrammarElement()).getAlternatives();

		}
		return abstractElement;
	}

	// /**
	// *
	// * @param contextElement
	// * element searched for assignments to the given rule
	// * @param parserRule
	// * the rule of the assignments to search for
	// * @return an assignment object containing a rulecall to the given
	// * parserRule or null if not found.
	// */
	// private static final Assignment getParserRuleAssignment(AbstractElement
	// contextElement, ParserRule parserRule) {
	//
	// assertParameterNotNull(contextElement, "contextElement");
	// assertParameterNotNull(parserRule, "parserRule");
	//
	// Assignment assignment = null;
	// if (contextElement instanceof Group) {
	// Group group = (Group) contextElement;
	// for (AbstractElement groupElement : group.getAbstractTokens()) {
	// assignment = getParserRuleAssignment(groupElement, parserRule);
	// if (null != assignment) {
	// break;
	// }
	// }
	// }
	// else if (contextElement instanceof Alternatives) {
	// Alternatives alternatives = (Alternatives) contextElement;
	// for (AbstractElement groupElement : alternatives.getGroups()) {
	// assignment = getParserRuleAssignment(groupElement, parserRule);
	// if (null != assignment) {
	// break;
	// }
	// }
	// }
	// else if (contextElement instanceof Assignment) {
	// Assignment assignmentToMatch = (Assignment) contextElement;
	// if (assignmentToMatch.getTerminal() instanceof RuleCall
	// && ((RuleCall)
	// assignmentToMatch.getTerminal()).getName().equalsIgnoreCase
	// (parserRule.getName())) {
	// assignment = assignmentToMatch;
	// }
	// }
	// return assignment;
	// }

	/**
	 * @param abstractNode
	 * @param indentString
	 */
	private static final void doDumpNode(AbstractNode abstractNode, String indentString) {

		if (abstractNode instanceof CompositeNode) {

			// CompositeNode compositeNode = (CompositeNode) abstractNode;

			System.out.println(indentString + "line '" + abstractNode.getLine() + "' offset '"
					+ abstractNode.getOffset() + "'  length '" + abstractNode.getLength() + "' grammar-hierarchy  ("
					+ dumpParentHierarchy(abstractNode) + ")");

		} else if (abstractNode instanceof LeafNode) {

			LeafNode leafNode = (LeafNode) abstractNode;
			// ommit hidden channel
			if (!leafNode.isHidden()) {

				System.out.println(indentString + "'" + "line '" + leafNode.getLine() + "' offset '"
						+ leafNode.getOffset() + " length '" + leafNode.getLength() + "' "
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
			} else if (abstractNode.getGrammarElement() instanceof RuleCall) {
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