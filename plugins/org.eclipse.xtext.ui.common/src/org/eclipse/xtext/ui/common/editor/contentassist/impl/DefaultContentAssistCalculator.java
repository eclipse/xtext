/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistCalculator;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.inject.Inject;

/**
 * Provides a default implementation of interface {@link IContentAssistContext} designed as <b>Switch</b> over the
 * Xtext ecore inheritance hierarchy to calculate and resolve (or flatten) 'container' level elements like
 * <code>Group</code> or <code>Alternatives</code> to gather potential completion proposal candidates.
 *
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} instead of
 * typical <code>if (x instanceof y)</code> code blocks.
 *
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.xtext.util.XtextSwitch
 */
public class DefaultContentAssistCalculator extends XtextSwitch<List<AbstractElement>> implements IContentAssistCalculator {

	@Inject
	private ILinkingService linkingService;

	public List<AbstractElement> computeProposalElements(IContentAssistContext contentAssistContext) {

		List<AbstractElement> computedElementList = new ArrayList<AbstractElement>();

		Set<AbstractElement> nextValidElementSet = new LinkedHashSet<AbstractElement>();

		AbstractNode referenceNode=contentAssistContext.getReferenceNode();
		/**
		 * in case of a cross reference which isn't linked properly we evaluate or
		 * propose it again
		 */
		if (referenceNode != null && referenceNode.getGrammarElement() instanceof CrossReference && !isLinked(referenceNode)) {
			nextValidElementSet.add(getAbstractElement(referenceNode));
			nextValidElementSet.addAll(ParseTreeUtil.getElementSetValidFromOffset(contentAssistContext.getRootNode(),
					referenceNode, contentAssistContext.getOffSet()));
		} else if (referenceNode == contentAssistContext.getNode()) {
			if (referenceNode == null)
				throw new NullPointerException("Unexpected: referenceNode is null.");
			/**
			 * in case of 'at-the-end' of the previous,completed element we evaluate
			 * it again for 'right-to-left-backtracking' cases (e.g. for keyword
			 * 'kind' kind>|< |=cursorpos)
			 */
			Assignment containingAssignment = GrammarUtil.containingAssignment(referenceNode.getGrammarElement());

			if (referenceNode.getGrammarElement() instanceof RuleCall && containingAssignment != null) {
				nextValidElementSet.add(containingAssignment);
				nextValidElementSet.addAll(ParseTreeUtil.getElementSetValidFromOffset(contentAssistContext
						.getRootNode(), referenceNode, contentAssistContext.getOffSet()));
			}
			else {
				nextValidElementSet = ParseTreeUtil.getElementSetValidFromOffset(contentAssistContext.getRootNode(),
						referenceNode, contentAssistContext.getOffSet());
				nextValidElementSet.add(getAbstractElement(referenceNode));
			}
		}
		else if (referenceNode != null){
			nextValidElementSet = ParseTreeUtil.getElementSetValidFromOffset(contentAssistContext.getRootNode(),
					referenceNode, contentAssistContext.getOffSet());
		}

		for (Iterator<AbstractElement> iterator = nextValidElementSet.iterator(); iterator.hasNext();) {
			AbstractElement abstractElement = iterator.next();
			computedElementList.addAll(doSwitch(abstractElement));
		}

		return computedElementList;
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
	public List<AbstractElement> caseGroup(Group group) {
		List<AbstractElement> elementList = new ArrayList<AbstractElement>();
		boolean includeNext = true;
		for (Iterator<AbstractElement> iterator = group.getAbstractTokens().iterator(); iterator.hasNext()
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
        } else if (assignment.getTerminal() instanceof Keyword) {
            addWithNullCheck(elementList, doSwitch(assignment.getTerminal()));
        }
		elementList.add(assignment);
		return elementList;
	}

	@Override
	public List<AbstractElement> caseRuleCall(RuleCall ruleCall) {
		List<AbstractElement> elementList = new ArrayList<AbstractElement>();

		elementList.add(ruleCall);

		AbstractRule abstractRule = ruleCall.getRule();

		if (abstractRule instanceof ParserRule) {
			addWithNullCheck(elementList, doSwitch(((ParserRule) abstractRule).getAlternatives()));
		}
		return elementList;
	}

	@Override
	public List<AbstractElement> caseCrossReference(CrossReference crossReference) {
		return Collections.singletonList(((AbstractElement)crossReference.eContainer()));
	}

	@Override
	public List<AbstractElement> defaultCase(EObject object) {
		return Collections.singletonList(((AbstractElement)object));
	}

	private void addWithNullCheck(List<AbstractElement> source, List<AbstractElement> list) {
		if (null != list) {
			source.addAll(list);
		}
	}

	private AbstractElement getAbstractElement(AbstractNode lastCompleteNode) {
		return (AbstractElement) (lastCompleteNode.getGrammarElement() instanceof ParserRule ?
				((ParserRule)lastCompleteNode.getGrammarElement()).getAlternatives(): lastCompleteNode.getGrammarElement());
	}

	private boolean isLinked(AbstractNode lastCompleteNode) {
		EObject semanticModel = NodeUtil.getNearestSemanticObject(lastCompleteNode);
		CrossReference crossReference = (CrossReference) lastCompleteNode.getGrammarElement();
		EReference eReference = GrammarUtil.getReference(crossReference, semanticModel.eClass());

		List<EObject> referencedObjects = EcoreUtil2.getAllReferencedObjects(semanticModel, eReference);

		if (referencedObjects.isEmpty())
			return false;
		try {
			List<EObject> linkCandidates = linkingService.getLinkedObjects(semanticModel, eReference, lastCompleteNode);
			return !linkCandidates.isEmpty() && referencedObjects.containsAll(linkCandidates);
		} catch( IllegalNodeException ex) {
			return false;
		}
	}

	private boolean isOptional(AbstractElement groupElement) {
		boolean isOptional = true;

		if ((groupElement instanceof Group || groupElement instanceof Alternatives) && !GrammarUtil.isOptionalCardinality(groupElement)) {

			EList<AbstractElement> abstractTokens = groupElement instanceof Group ? ((Group) groupElement)
					.getAbstractTokens() : ((Alternatives) groupElement).getGroups();

			for (Iterator<AbstractElement> iterator = abstractTokens.iterator(); isOptional && iterator.hasNext();) {
				AbstractElement abstractElement = iterator.next();
				isOptional = isOptional(abstractElement);
			}

		} else {
			isOptional = GrammarUtil.isOptionalCardinality(groupElement);
		}
		return isOptional;
	}


}
