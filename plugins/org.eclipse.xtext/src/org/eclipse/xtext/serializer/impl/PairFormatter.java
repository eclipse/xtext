/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISequencer;
import org.eclipse.xtext.util.EmfFormatter;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PairFormatter {
	public static String addCrossRefOrAssignemnt(String result, AbstractElement ele) {
		CrossReference cr = GrammarUtil.containingCrossReference(ele);
		if (cr != null)
			result = "[" + cr.getType().getClassifier().getName() + "|" + result + "]";
		Assignment ass = GrammarUtil.containingAssignment(ele);
		if (ass != null)
			result = ass.getFeature() + ass.getOperator() + result;
		return result;
	}

	public static String toStr(AbstractElement ele) {
		if (ele instanceof RuleCall) {
			RuleCall rc = (RuleCall) ele;
			return addCrossRefOrAssignemnt(rc.getRule().getName(), rc);
		} else if (ele instanceof Action) {
			Action action = (Action) ele;
			return "{" + action.getType().getClassifier().getName() + "." + action.getFeature() + "}";
		} else if (ele instanceof Keyword) {
			Keyword keyword = (Keyword) ele;
			return addCrossRefOrAssignemnt("'" + keyword.getValue() + "'", keyword);
		}
		return "(unknown)";
	}

	public static String toStr(AbstractElement ele, Object value) {
		return toStr(ele) + " => " + toStr(value);

	}

	public static String toStr(ISequencer.IGrammarValuePair pair) {
		return toStr(pair.getGrammarElement(), pair.getValue());
	}

	public static String toStr(Object value) {
		if (value == null)
			return "(null)";
		else if (value instanceof EObject)
			return EmfFormatter.objPath((EObject) value);
		else
			return value.toString();
	}
}
