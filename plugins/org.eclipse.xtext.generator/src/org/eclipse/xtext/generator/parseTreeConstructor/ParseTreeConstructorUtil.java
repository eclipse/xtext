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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

public class ParseTreeConstructorUtil {

	private static String toIDString(String val) {
		if (val == null)
			return "";
		return val.replaceAll("[^a-zA-Z0-9_]", "");
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

	public static String getUniqueElementName(AbstractElement ele) {
		if (ele == null)
			return "null";
		EObject obj = ele;
		// String r = ele.eClass().getName();
		String r = "";
		if (ele instanceof Keyword)
			r = ((Keyword) ele).getValue();
		else if (ele instanceof Assignment)
			r = ((Assignment) ele).getFeature();
		else if (ele instanceof RuleCall)
			r = ((RuleCall) ele).getRule().getName();
		else if (ele instanceof Action) {
			Action a = (Action) ele;
			r = a.getType().getClassifier().getName();
			if(a.getFeature() != null && !"".equals(a.getFeature()))
				r += "_" + a.getFeature();
		}
		r = toIDString(r);
		if (r.equals(""))
			r = ele.eClass().getName();
		else
			r = ele.eClass().getName() + "_" + r;

		while ((!(obj.eContainer() instanceof AbstractRule)) && obj.eContainer() != null) {
			EObject tmp = obj.eContainer();
			r = tmp.eContents().indexOf(obj) + "_" + r;
			obj = tmp;
		}
		if (obj.eContainer() instanceof AbstractRule)
			return ((AbstractRule) obj.eContainer()).getName() + "_" + r;
		return "UnknownRule_" + r;
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

	public static String getParseTreeConstructorName(Grammar g) {
		return getPackage(g)+"."+GrammarUtil.getName(g)+"ParsetreeConstructor";
	}

	/**
	 * @param g
	 * @return
	 */
	public static String getPackage(Grammar g) {
		return GrammarUtil.getNamespace(g)+".parseTreeConstruction";
	}

}
