/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;

import com.google.common.base.CaseFormat;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureLiterals {

	public static String getFeatureLiteral(Action action) {
		String typeName = action.getType().getClassifier().getName();
		String featureName = action.getFeature();
		
		return getAsFeatureLiteral(typeName, featureName);
	}

	public static String getFeatureLiteral(Assignment assignment) {
		String typeName = getTypeOfCurrent(assignment).getName();
		String featureName = assignment.getFeature();
		
		return getAsFeatureLiteral(typeName, featureName);
	}
	
	private static EClassifier getTypeOfCurrent(Assignment assignment) {
		Action action = getPrecedingAction(assignment);
		if (action != null) {
			return action.getType().getClassifier();
		}
		ParserRule rule = GrammarUtil.containingParserRule(assignment);
		return rule.getType().getClassifier();
	}

	private static Action getPrecedingAction(AbstractElement element) {
		EObject container = element.eContainer();
		if (container instanceof Group) {
			Group group =  ((Group) container);
			int childIndex = group.getElements().indexOf(element);
			for(int i = 0; i < childIndex; i++) {
				EObject child = group.getElements().get(i);
				if (child instanceof Action) {
					return (Action) child;
				}
				if (child instanceof Group && !GrammarUtil.isOptionalCardinality((AbstractElement) child)) {
					Action result = findActionInGroup((Group) child);
					if (result != null)
						return result;
				}
			}
			
		}
		if (container instanceof AbstractElement)
			return getPrecedingAction((AbstractElement) container);
		return null;
	}

	private static Action findActionInGroup(Group group) {
		for(AbstractElement element: group.getElements()) {
			if (element instanceof Action)
				return (Action) element;
			if (element instanceof Group && !GrammarUtil.isOptionalCardinality(element)) {
				Action result = findActionInGroup((Group) element);
				if (result != null)
					return result;
			}
		}
		return null;
	}

	private static String getAsFeatureLiteral(String typeName, String featureName) {
		String result = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, typeName) + "__" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, featureName);
		if (result.startsWith("X_")) {
			result = "X" + result.substring(2);
		}
		return result;
	}
	
}
