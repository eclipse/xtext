/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parseTreeConstructor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstState;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstructionNFAProvider;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
public class ParseTreeConstructorUtil {

	public static TreeConstState getTreeConstState(AbstractElement e) {
		return new TreeConstructionNFAProvider().getNFA(e);
	}

	public static List<AbstractElement> calcRootFollowers(Grammar g) {
		List<AbstractElement> callees = new ArrayList<AbstractElement>();
		for (AbstractRule r : GrammarUtil.allRules(g))
			if (r instanceof ParserRule) {
				ParserRule pr = (ParserRule) r;
				if (!GrammarUtil.isDatatypeRule(pr) && !pr.isFragment())
					callees.add(pr.getAlternatives());
			}
		return callees;
	}

	public static List<AbstractElement> getNestedElementsFromAssignment(Assignment assignment) {
		AbstractElement t = assignment.getTerminal();
		ArrayList<AbstractElement> r = new ArrayList<AbstractElement>();
		if (t instanceof Keyword || t instanceof RuleCall || t instanceof CrossReference)
			r.add(t);
		else {
			r.addAll(GrammarUtil.containedKeywords(t));
			r.addAll(GrammarUtil.containedRuleCalls(t));
			r.addAll(GrammarUtil.containedCrossReferences(t));
		}
		return r;
	}

	public static String getPackage(Grammar g, Naming n) {
		return n.basePackageRuntime(g) + ".parseTreeConstruction";
	}

	public static String getParseTreeConstructorName(Grammar g, Naming n) {
		return getPackage(g, n) + "." + GrammarUtil.getSimpleName(g) + "ParsetreeConstructor";
	}

	private static List<CrossReference> getCrossReferencesWithSameEReference(CrossReference cr) {
		Grammar g = GrammarUtil.getGrammar(cr);
		EReference ref = GrammarUtil.getReference(cr);
		List<CrossReference> result = Lists.newArrayList();
		for (CrossReference c : EcoreUtil2.getAllContentsOfType(g, CrossReference.class))
			if (GrammarUtil.getReference(c) == ref)
				result.add(c);
		return result;
	}

	public static boolean crossReferenceExistsWithDifferentTerminal(CrossReference cr) {
		List<CrossReference> crossRefs = getCrossReferencesWithSameEReference(cr);
		if (crossRefs.isEmpty())
			return false;
		for (CrossReference c : crossRefs)
			if (!EcoreUtil.equals(cr.getTerminal(), c.getTerminal()))
				return true;
		return false;
	}

	public static boolean isAssignmentRequired(Assignment assignment) {
		if (GrammarUtil.isOptionalCardinality(assignment))
			return false;
		if (assignment.eContainer() instanceof Group)
			return !isOptionalGroup((Group) assignment.eContainer());
		if (assignment.eContainer() instanceof UnorderedGroup)
			return isOptionalUnorderedGroup((UnorderedGroup) assignment.eContainer());
		return true;
	}

	private static boolean isOptionalGroup(Group group) {
		if (GrammarUtil.containedAssignments(group).size() != 1)
			return false;
		if (GrammarUtil.isOptionalCardinality(group))
			return true;
		if (group.eContainer() instanceof Group)
			return isOptionalGroup((Group) group.eContainer());
		if (group.eContainer() instanceof UnorderedGroup)
			return isOptionalUnorderedGroup((UnorderedGroup) group.eContainer());
		return false;
	}

	private static boolean isOptionalUnorderedGroup(UnorderedGroup group) {
		if (GrammarUtil.containedAssignments(group).size() != 1)
			return false;
		if (GrammarUtil.isOptionalCardinality(group))
			return true;
		if (group.eContainer() instanceof Group)
			return isOptionalGroup((Group) group.eContainer());
		if (group.eContainer() instanceof UnorderedGroup)
			return isOptionalUnorderedGroup((UnorderedGroup) group.eContainer());
		return false;
	}

}
