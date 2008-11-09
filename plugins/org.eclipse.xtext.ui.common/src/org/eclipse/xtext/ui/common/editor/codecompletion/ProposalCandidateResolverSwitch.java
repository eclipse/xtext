/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * Represents a <b>Switch</b> for the Xtext model's inheritance hierarchy to resolve
 * potential completion proposal candidate's.
 * 
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} instead of
 * typical <code>if (x instanceof y)</code> code blocks.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.xtext.util.XtextSwitch
 */
public class ProposalCandidateResolverSwitch extends XtextSwitch<List<EObject>> implements Iterable<List<EObject>> {

	private Iterator<? extends EObject> delegatingIterator;

	/**
	 * @param elementCollection
	 *            to iterate and resolve
	 */
	public ProposalCandidateResolverSwitch(Collection<? extends EObject> elementCollection) {
		this.delegatingIterator = elementCollection.iterator();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<List<EObject>> iterator() {
		return new Iterator<List<EObject>>() {
			public boolean hasNext() {
				return delegatingIterator.hasNext();
			}

			public List<EObject> next() {
				return doSwitch(delegatingIterator.next());
			}

			public void remove() {
				delegatingIterator.remove();
			}

		};
	}

	@Override
	public List<EObject> caseAlternatives(Alternatives alternatives) {
		List<EObject> elementList = new ArrayList<EObject>();
		for (AbstractElement alternativeElement : alternatives.getGroups()) {
			addWithNullCheck(elementList, doSwitch(alternativeElement));
		}
		return elementList;
	}

	@Override
	public List<EObject> caseGroup(Group group) {
		List<EObject> elementList = new ArrayList<EObject>();
		boolean includeNext = true;
		for (Iterator<AbstractElement> iterator = group.getAbstractTokens().iterator(); iterator.hasNext()
				&& includeNext;) {
			AbstractElement groupElement = iterator.next();
			addWithNullCheck(elementList, doSwitch(groupElement));
			includeNext = GrammarUtil.isOptionalCardinality(groupElement);
		}
		return elementList;
	}

	@Override
	public List<EObject> caseAssignment(Assignment assignment) {
		List<EObject> elementList = new ArrayList<EObject>();
		if (assignment.getTerminal() instanceof RuleCall) {
			addWithNullCheck(elementList, doSwitch(assignment.getTerminal()));
		}
		else if (assignment.getTerminal() instanceof Alternatives) {
			addWithNullCheck(elementList, doSwitch(assignment.getTerminal()));
		}
		elementList.add(assignment);
		return elementList;
	}

	@Override
	public List<EObject> caseRuleCall(RuleCall ruleCall) {
		List<EObject> elementList = new ArrayList<EObject>();
		elementList.add(ruleCall);

		AbstractRule abstractRule = GrammarUtil.calledRule(ruleCall);

		if (abstractRule instanceof ParserRule) {
			addWithNullCheck(elementList, doSwitch(((ParserRule) abstractRule).getAlternatives()));
		}
		return elementList;
	}
	
	@Override
	public List<EObject> caseCrossReference(CrossReference crossReference) {
		return Collections.singletonList(crossReference.eContainer());
	}

	@Override
	public List<EObject> defaultCase(EObject object) {
		return Collections.singletonList(object);
	}

	private void addWithNullCheck(List<EObject> source, List<EObject> list) {
		if (null != list) {
			source.addAll(list);
		}
	}

}
