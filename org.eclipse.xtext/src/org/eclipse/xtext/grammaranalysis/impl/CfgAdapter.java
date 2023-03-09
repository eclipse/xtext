/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.formallang.Cfg;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CfgAdapter implements Cfg<AbstractElement, AbstractElement> {

	protected Grammar grammar;

	public CfgAdapter(Grammar grammar) {
		super();
		this.grammar = grammar;
	}

	@Override
	public Iterable<AbstractElement> getAlternativeChildren(AbstractElement ele) {
		switch (ele.eClass().getClassifierID()) {
			case XtextPackage.ALTERNATIVES:
				return ((Alternatives) ele).getElements();
			default:
				return null;
		}
	}

	@Override
	public AbstractElement getCall(AbstractElement ele) {
		switch (ele.eClass().getClassifierID()) {
			case XtextPackage.RULE_CALL:
				return ((RuleCall) ele).getRule().getAlternatives();
			default:
				return null;
		}
	}

	@Override
	public AbstractElement getParent(AbstractElement ele) {
		EObject cnt = ele.eContainer();
		return cnt instanceof AbstractElement ? (AbstractElement) cnt : null;
	}

	@Override
	public AbstractElement getRoot() {
		return grammar.getRules().size() > 0 ? grammar.getRules().get(0).getAlternatives() : null;
	}

	@Override
	public Iterable<AbstractElement> getSequentialChildren(AbstractElement ele) {
		switch (ele.eClass().getClassifierID()) {
			case XtextPackage.GROUP:
				return ((Group) ele).getElements();
			case XtextPackage.ASSIGNMENT:
				return Collections.singleton(((Assignment) ele).getTerminal());
			case XtextPackage.CROSS_REFERENCE:
				return Collections.singleton(((CrossReference) ele).getTerminal());
			default:
				return null;
		}
	}

	@Override
	public AbstractElement getToken(AbstractElement owner) {
		return owner;
	}

	@Override
	public Iterable<AbstractElement> getUnorderedChildren(AbstractElement ele) {
		switch (ele.eClass().getClassifierID()) {
			case XtextPackage.UNORDERED_GROUP:
				return ((UnorderedGroup) ele).getElements();
			default:
				return null;
		}
	}

	@Override
	public boolean isMany(AbstractElement ele) {
		return GrammarUtil.isMultipleCardinality(ele);
	}

	@Override
	public boolean isOptional(AbstractElement ele) {
		return GrammarUtil.isOptionalCardinality(ele);
	}

}
