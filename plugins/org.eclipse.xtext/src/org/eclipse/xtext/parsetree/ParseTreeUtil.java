/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.XtextSwitch;

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
	 * @param rootNode	the root node of the tree
	 * @param offset	the text position within the the current sentence
	 * @return the set of elements which are <i>valid</i> or <i>possible</i>
	 *         from the given position according to the grammar
	 */
	public static Set<AbstractElement> getElementSetValidFromOffset(CompositeNode rootNode, int offset) {
		return getElementSetValidFromOffset(rootNode, getLastCompleteNodeByOffset(rootNode, offset), offset);
	}
	/**
     * @param rootNode      the root node of the tree
     * @param last          the last node element with an associated grammar element within the given rootNode
     * @param offset        the text position within the the current sentence
     * @return      the set of elements which are <i>valid</i> or <i>possible</i> from the given position according to
     *              the grammar
     */
    public static Set<AbstractElement> getElementSetValidFromOffset(
                    CompositeNode rootNode, AbstractNode lastCompleteNode, int offset) {
            Set<AbstractElement> abstractElementSet = new HashSet<AbstractElement>();
            AbstractElement grammarElement = getGrammarElementFromNode(lastCompleteNode);
            if (grammarElement != null)
            	abstractElementSet.addAll(backtrackAlternativeAssignments(lastCompleteNode, grammarElement));
            abstractElementSet.addAll(calculatePossibleElementSet(lastCompleteNode,null));
            return abstractElementSet;
    }
	/**
	 * @param abstractNode			the node to inspect
	 * @param grammarElementClass	the to match
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
	 * @param abstractNode		the node to dump
	 */
	public static final void dumpNode(AbstractNode abstractNode) {
		if (logger.isDebugEnabled()) {
			assertParameterNotNull(abstractNode, "abstractNode");
			logger.debug("dump parsetree with root node '" + EcoreUtil.getIdentification(abstractNode) + "'");
			doDumpNode(abstractNode, "\t");
		}
	}

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
	 *
	 * This method returns the parent grammar of the given eObject by recursive
	 * 'upwards' invocations, passing the eContainer property as parameter until
	 * some Grammar level object is reached.
	 *
	 * @param eObject		the object contained or referenced within some 'root' grammar
	 * @return the {@link org.eclipse.xtext.Grammar} of the given object.
	 */
	public static final Grammar getGrammar(EObject eObject) {
		assertParameterNotNull(eObject, "eObject");

		if (eObject instanceof Grammar) {
			return (Grammar) eObject;
		}
		return getGrammar(eObject.eContainer());
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

	private static Set<AbstractElement> calculatePossibleElementSet(AbstractNode node, AbstractElement abstractElement) {
		assertParameterNotNull(node, "parameter 'node' must not be null");

		Set<AbstractElement> elementSet = new LinkedHashSet<AbstractElement>();
		AbstractNode contextNode = node;
		AbstractElement initialGrammarElement = abstractElement != null ? abstractElement
				: getGrammarElementFromNode(node);
		if (initialGrammarElement != null && initialGrammarElement.eContainer() instanceof ParserRule
				&& isDefaultRule((ParserRule) initialGrammarElement.eContainer())) {
			elementSet.add(initialGrammarElement);
		} else if (contextNode.getGrammarElement() instanceof RuleCall
				&& (!(((RuleCall) contextNode.getGrammarElement()).getRule() instanceof TerminalRule))) {
			elementSet.add(initialGrammarElement);
		}
		for (; contextNode != null; contextNode = contextNode.getParent()) {
			for (EObject grammarElementObject = null != abstractElement ? abstractElement
					: getGrammarElementFromNode(contextNode); grammarElementObject instanceof AbstractElement
					&& !(grammarElementObject instanceof Action); grammarElementObject = grammarElementObject
					.eContainer()) {

				AbstractElement grammarElement = (AbstractElement) grammarElementObject;
				if (grammarElement.eContainer() instanceof Group) {
					List<AbstractElement> contents = ((Group) grammarElement.eContainer()).getTokens();
					int indexOf = contents.indexOf(grammarElement) + 1;
					int size = contents.size();
					if (GrammarUtil.isOneOrMoreCardinality(grammarElement)) {
						elementSet.add(grammarElement);
					}
					AbstractElement last = GrammarUtil.isAnyCardinality(grammarElement) || indexOf == size ? grammarElement
							: contents.get(indexOf++);
					while (GrammarUtil.isOptionalCardinality(last) && indexOf < size) {
						elementSet.add(last);
						last = indexOf < size ? contents.get(indexOf++) : last;
					}
					if (last != grammarElement || GrammarUtil.isAnyCardinality(last)) {
						elementSet.add(last);
					}
					if (last != grammarElement && !GrammarUtil.isOptionalCardinality(last)) {
						return elementSet;
					}
				} else if (GrammarUtil.isMultipleCardinality(grammarElement)) {
					elementSet.add(grammarElement);
				}
			}
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
				logger.debug(indentString + "line '" + abstractNode.getTotalLine() + "' offset '"
						+ abstractNode.getTotalOffset()
						+ "'  length '" + abstractNode.getTotalLength() + "' grammar-hierarchy  ("
						+ dumpParentHierarchy(abstractNode) + ")"
						+ " {CompositeNode}");
			}
			else if (abstractNode instanceof LeafNode) {
				LeafNode leafNode = (LeafNode) abstractNode;
				// ommit hidden channel
				if (!leafNode.isHidden()) {
					logger.debug(indentString + "line '" + leafNode.getTotalLine() + "' offset '"
							+ leafNode.getTotalOffset()
							+ "' length '" + leafNode.getTotalLength() + "' "
							+ (leafNode.getFeature() != null ? leafNode.getFeature() + " = " : "")
							+ "text '"	+ leafNode.getText()
							+ "' grammar-hierarchy (" + dumpParentHierarchy(leafNode) + ")"
							+ " {LeafNode}");
				}
			}

			for (AbstractNode childNode : abstractNode.getLeafNodes()) {
				doDumpNode(childNode, indentString + indentString);
			}
		}

	}

	private static final String dumpParentHierarchy(final AbstractNode node) {
		StringBuilder stringBuilder = new StringBuilder();
		AbstractNode abstractNode = node;
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


	private static Set<AbstractElement> backtrackAlternativeAssignments(AbstractNode lastCompleteNode,
			AbstractElement grammarElement) {
		Set<AbstractElement> abstractElementSet = new HashSet<AbstractElement>();
		if (grammarElement.eContainer() instanceof Assignment) {
			AbstractElement outermost = getOutermostAlternativesElement(lastCompleteNode);
			if (outermost != null) {
				List<AbstractElement> filteredAssignments = new AlternativesTypeFilter(((Assignment) grammarElement
						.eContainer())).doSwitch(outermost);
				for (Iterator<AbstractElement> assignmentsIterator = filteredAssignments.iterator(); assignmentsIterator
						.hasNext();) {
					abstractElementSet
							.addAll(calculatePossibleElementSet(lastCompleteNode, assignmentsIterator.next()));
				}
			}
		}
		return abstractElementSet;
	}

	private static AbstractElement getOutermostAlternativesElement(final AbstractNode node) {
		AbstractElement result = null;
		for (AbstractNode baseNode = node; baseNode.getParent() != null;
			baseNode = baseNode.getParent()) {
			for (EObject abstractElement = baseNode.getGrammarElement();
				abstractElement instanceof AbstractElement;
					abstractElement = abstractElement.eContainer()) {
				if (abstractElement instanceof Group) {
					return result;
				} else if (abstractElement instanceof Alternatives || abstractElement instanceof UnorderedGroup) {
					result = (AbstractElement) abstractElement;
				}
			}
		}
		return result;
	}

	private static class AlternativesTypeFilter extends XtextSwitch<List<AbstractElement>> {

		private final Assignment assignment;

		public AlternativesTypeFilter(Assignment assignment) {
			this.assignment = assignment;
		}

		@Override
		public List<AbstractElement> caseAlternatives(Alternatives alternatives) {
			List<AbstractElement> elementList = new ArrayList<AbstractElement>();
			for (AbstractElement alternativeElement : alternatives.getGroups()) {
				addWithNullCheck(elementList, doSwitch(alternativeElement));
			}
			return elementList;
		}
		
		@Override
		public List<AbstractElement> caseUnorderedGroup(UnorderedGroup group) {
			List<AbstractElement> elementList = new ArrayList<AbstractElement>();
			for (AbstractElement element : group.getElements()) {
				addWithNullCheck(elementList, doSwitch(element));
			}
			return elementList;
		}

		@Override
		public List<AbstractElement> caseGroup(Group group) {
			List<AbstractElement> elementList = new ArrayList<AbstractElement>();
			boolean includeNext = true;
			for (Iterator<AbstractElement> iterator = group.getTokens().iterator(); iterator.hasNext()
					&& includeNext;) {
				AbstractElement groupElement = iterator.next();
				addWithNullCheck(elementList, doSwitch(groupElement));
				includeNext = isOptional(groupElement);
			}
			return elementList;
		}

		@Override
		public List<AbstractElement> caseAssignment(Assignment assignment) {
			List<AbstractElement> elementList = new ArrayList<AbstractElement>();
			if (assignment.getTerminal() instanceof RuleCall) {
				addWithNullCheck(elementList, doSwitch(assignment.getTerminal()));
			} else if (assignment.getTerminal() instanceof Alternatives) {
				addWithNullCheck(elementList, doSwitch(assignment.getTerminal()));
			}
			AbstractRule assigmentRule = getRule(this.assignment);
			if (!this.assignment.equals(assignment) && null != assigmentRule
					&& assigmentRule.equals(getRule(assignment))) {
				elementList.add(assignment);
			}
			return elementList;
		}

		@Override
		public List<AbstractElement> caseRuleCall(RuleCall ruleCall) {
			List<AbstractElement> elementList = new ArrayList<AbstractElement>();
			AbstractRule abstractRule = ruleCall.getRule();
			if (abstractRule instanceof ParserRule) {
				addWithNullCheck(elementList, doSwitch(((ParserRule) abstractRule).getAlternatives()));
			}
			return elementList;
		}

		@Override
		public List<AbstractElement> caseCrossReference(CrossReference crossReference) {
			return Collections.singletonList(((AbstractElement) crossReference.eContainer()));
		}

		@Override
		public List<AbstractElement> caseKeyword(Keyword keyword) {
			return Collections.emptyList();
		}

		@Override
		public List<AbstractElement> defaultCase(EObject object) {
			return Collections.singletonList(((AbstractElement) object));
		}

		private void addWithNullCheck(List<AbstractElement> source, List<AbstractElement> list) {
			if (null != list) {
				source.addAll(list);
			}
		}

		private boolean isOptional(AbstractElement groupElement) {
			boolean isOptional = true;
			if ((groupElement instanceof Group || groupElement instanceof Alternatives || groupElement instanceof UnorderedGroup)
					&& !GrammarUtil.isOptionalCardinality(groupElement)) {
				List<AbstractElement> children;
				if (groupElement instanceof Group)
					children = ((Group) groupElement).getTokens();
				else if (groupElement instanceof Alternatives)
					children = ((Alternatives) groupElement).getGroups();
				else
					children = ((UnorderedGroup) groupElement).getElements();
				for (Iterator<AbstractElement> iterator = children.iterator(); isOptional && iterator.hasNext();) {
					AbstractElement abstractElement = iterator.next();
					isOptional = isOptional(abstractElement);
				}
			} else {
				isOptional = GrammarUtil.isOptionalCardinality(groupElement);
			}
			return isOptional;
		}

		private static AbstractRule getRule(Assignment assignment) {
			AbstractRule rule = null;
			AbstractElement terminal = assignment.getTerminal();
			if (terminal instanceof CrossReference) {
				terminal = ((CrossReference) terminal).getTerminal();
			}
			if (terminal instanceof RuleCall) {
				rule = ((RuleCall) terminal).getRule();
			}
			return rule;
		}
	}


}