/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parseTreeConstructor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstState;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstructionNFAProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ParseTreeConstructorUtil {

	public static TreeConstState getTreeConstState(AbstractElement e) {
		return new TreeConstructionNFAProvider().getNFA(e);
	}

	public static List<AbstractElement> calcRootFollowers(Grammar g) {
		List<AbstractElement> callees = new ArrayList<AbstractElement>();
		for (AbstractRule r : GrammarUtil.allRules(g))
			if (r instanceof ParserRule) {
				ParserRule pr = (ParserRule) r;
				if (!GrammarUtil.isDatatypeRule(pr))
					callees.add(pr.getAlternatives());
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
