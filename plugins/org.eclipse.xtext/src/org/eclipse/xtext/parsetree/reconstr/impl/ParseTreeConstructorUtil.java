/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ParseTreeConstructorUtil {

	private static List<Follower> calcCalledRules(AbstractElement ele) {
		List<Follower> callees = new ArrayList<Follower>();
		List<RuleCall> calls = new ArrayList<RuleCall>();
		if (ele instanceof RuleCall)
			calls.add((RuleCall) ele);
		else if (ele instanceof Assignment)
			calls.addAll(GrammarUtil.containedRuleCalls(ele));
		for (RuleCall r : calls)
			if (r.getRule() instanceof ParserRule) {
				ParserRule pr = (ParserRule) r.getRule();
				if (!GrammarUtil.isDatatypeRule(pr))
					callees.add(new Follower(pr.getAlternatives(), true));
			}
		return callees;
	}

	public static List<Follower> calcFollowers(AbstractElement ele) {
		if (!isCodeElement(ele))
			return Collections.emptyList();
		List<Follower> r = calcCalledRules(ele);
		return r.size() == 0 ? calcFollowersLocal(ele) : r;
	}

	private static List<Follower> calcFollowersLocal(AbstractElement ele) {
		List<Follower> r = new ArrayList<Follower>();
		if (ele instanceof Group) {
			Group g = (Group) ele;
			for (int i = g.getTokens().size() - 1; i >= 0; i--) {
				r.add(new Follower(g.getTokens().get(i), false));
				if (!GrammarUtil.isOptionalCardinality(g.getTokens().get(i)))
					break;
			}

		} else if (ele instanceof Alternatives)
			for (AbstractElement e : ((Alternatives) ele).getGroups())
				r.add(new Follower(e, false));
		else {
			if (GrammarUtil.isMultipleCardinality(ele))
				r.add(new Follower(ele, false));
			calcFollowersOther(ele, r);
		}
		return r;
	}

	private static void calcFollowersOther(AbstractElement ele, List<Follower> r) {
		if (ele.eContainer() instanceof Alternatives) {
			Alternatives containingAlt = (Alternatives) ele.eContainer();
			if (GrammarUtil.isMultipleCardinality(containingAlt))
				r.add(new Follower(containingAlt, false));
			calcFollowersOther(containingAlt, r);
		} else if (ele.eContainer() instanceof Group) {
			Group containingGroup = (Group) ele.eContainer();
			int i = containingGroup.getTokens().indexOf(ele);
			if (i <= 0) {
				if (GrammarUtil.isMultipleCardinality(containingGroup))
					r.add(new Follower(containingGroup, false));
				calcFollowersOther(containingGroup, r);
			} else {
				AbstractElement next = containingGroup.getTokens().get(i - 1);
				r.add(new Follower(next, false));
				if (GrammarUtil.isOptionalCardinality(next))
					calcFollowersOther(next, r);
			}
		} else if (ele.eContainer() instanceof AbstractRule)
			r.add(new Follower(null, false));
	}

	public static List<Follower> calcParentFollowers(AbstractElement ele) {
		if (!isCodeElement(ele) || calcCalledRules(ele).size() == 0)
			return Collections.emptyList();
		return calcFollowersLocal(ele);
	}

	public static List<Follower> calcRootFollowers(Grammar g) {
		List<Follower> callees = new ArrayList<Follower>();
		for (AbstractRule r : g.getRules())
			if (r instanceof ParserRule) {
				ParserRule pr = (ParserRule) r;
				if (!GrammarUtil.isDatatypeRule(pr))
					callees.add(new Follower(pr.getAlternatives(), true));
			}
		return callees;
	}

	public static List<AbstractElement> getNestedElementsFromAssignment(
			Assignment assignment) {
		AbstractElement t = assignment.getTerminal();
		ArrayList<AbstractElement> r = new ArrayList<AbstractElement>();
		if (t instanceof Keyword || t instanceof RuleCall
				|| t instanceof CrossReference)
			r.add(t);
		else {
			r.addAll(GrammarUtil.containedKeywords(t));
			r.addAll(GrammarUtil.containedRuleCalls(t));
			r.addAll(GrammarUtil.containedCrossReferences(t));
		}
		return r;
	}

	public static String getPackage(Grammar g) {
		return GrammarUtil.getNamespace(g) + ".parseTreeConstruction";
	}

	public static String getParseTreeConstructorName(Grammar g) {
		return getPackage(g) + "." + GrammarUtil.getName(g)
				+ "ParsetreeConstructor";
	}

	public static boolean isAssignmentRequired(Assignment assignment) {
		if (GrammarUtil.isOptionalCardinality(assignment))
			return false;
		if (assignment.eContainer() instanceof Group)
			return !isOptionalGroup((Group) assignment.eContainer());
		return true;
	}

	private static boolean isCodeElement(AbstractElement ele) {
		if (ele.eContainer() instanceof Alternatives
				|| ele.eContainer() instanceof Group)
			return isCodeElement((AbstractElement) ele.eContainer());
		if (ele.eContainer() instanceof AbstractRule)
			return true;
		return false;
	}

	public static boolean isElementCallable(AbstractElement ele) {
		return ele.eContainer() instanceof AbstractRule;
	}

	private static boolean isOptionalGroup(Group group) {
		if (GrammarUtil.containedAssignments(group).size() != 1)
			return false;
		if (GrammarUtil.isOptionalCardinality(group))
			return true;
		if (group.eContainer() instanceof Group)
			return isOptionalGroup((Group) group.eContainer());
		return false;
	}

}
