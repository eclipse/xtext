/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CurrentTypeFinder {
	
	/**
	 * Find the type of the current variable after an AbstractElement was consumed.
	 * If the AbstractElement will instantiate a new type (e.g. is an Action), 
	 * the instantiated type will be returned. If the element may occur in a 
	 * path that leads to an unassigned current element, <code>null</code> may 
	 * be returned. If the element is optional and changes the type, this method 
	 * will return the changed type as if the element were consumed. 
	 */
	public EClassifier findCurrentTypeAfter(AbstractElement element) {
		final AbstractRule rule = GrammarUtil.containingRule(element);
		Implementation implementation = new Implementation();
		implementation.computeResult(rule, element);
		return implementation.getResult();
	}
	
	public static class Implementation extends XtextSwitch<Boolean> {

		private EClassifier currentType;
		
		private AbstractRule context;

		private AbstractElement stopElement;
		
		private Set<AbstractRule> visiting = Sets.newHashSet();
		
		public EClassifier getResult() {
			return currentType;
		}

		public void computeResult(AbstractRule rule, AbstractElement element) {
			context = rule;
			stopElement = element;
			doSwitch(rule);
		}
		
		@Override
		public Boolean caseAbstractElement(AbstractElement object) {
			return object == stopElement;
		}
		
		@Override
		public Boolean caseAction(Action object) {
			if (object.getType() != null)
				currentType = object.getType().getClassifier();
			return object == stopElement;
		}
		
		@Override
		public Boolean caseParserRule(ParserRule object) {
			if (visiting.add(object)) {
				try {
					if (object.getAlternatives() != null)
						return doSwitch(object.getAlternatives());
				} finally {
					visiting.remove(object);
				}
			}
			return true;
		}
		
		@Override
		public Boolean caseAssignment(Assignment object) {
			EClassifier wasType = currentType;
			if (currentType == null) {
				if (context.getType() != null)
					currentType = context.getType().getClassifier();
			}
			if (object.getTerminal() != null)
				if (doSwitch(object.getTerminal()))
					return true;
			if (object == stopElement)
				return true;
			if (GrammarUtil.isOptionalCardinality(object))
				currentType = getCompatibleType(currentType, wasType, object);
			return false;
		}
		
		@Override
		public Boolean caseCompoundElement(CompoundElement object) {
			EClassifier wasType = currentType;
			for(AbstractElement element: object.getElements()) {
				if (doSwitch(element))
					return true;
			}
			if (object == stopElement)
				return true;
			if (GrammarUtil.isOptionalCardinality(object))
				currentType = getCompatibleType(currentType, wasType, object);
			return false;
		}
		
		@Override
		public Boolean caseCrossReference(CrossReference object) {
			if (object == stopElement)
				return true;
			return doSwitch(object.getTerminal());
		}
		
		@Override
		public Boolean caseRuleCall(RuleCall object) {
			EClassifier wasType = currentType;
			AbstractRule calledRule = object.getRule();
			if (currentType == null) {
				if (calledRule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) calledRule)) {
					ParserRule parserRule = (ParserRule) calledRule;
					if (parserRule.isFragment()) {
						if (context.getType() != null)
							currentType = context.getType().getClassifier();
						if (!parserRule.isWildcard()) {
							doSwitch(parserRule);
						}
					} else {
						TypeRef returnType = calledRule.getType();
						if (returnType != null) {
							currentType = returnType.getClassifier();
						}
					}
				}
			} else if (isFragmentButNotWildcard(calledRule)) {
				doSwitch(calledRule);
			}
			if (object == stopElement)
				return true;
			if (GrammarUtil.isOptionalCardinality(object))
				currentType = getCompatibleType(currentType, wasType, object);
			return false;
		}
		
		private boolean isFragmentButNotWildcard(AbstractRule calledRule) {
			if (calledRule instanceof ParserRule) {
				ParserRule casted = (ParserRule) calledRule;
				return casted.isFragment() && !casted.isWildcard();
			}
			return false;
		}

		protected EClassifier getCompatibleType(EClassifier a, EClassifier b, EObject context) {
			if (a == null)
				return b;
			if (b == null)
				return a;
			return EcoreUtil2.getCompatibleType(a, b, context);
		}
		
		@Override
		public Boolean caseAlternatives(Alternatives object) {
			EClassifier wasType = currentType;
			List<EClassifier> alternativeTypes = null;
			for(AbstractElement element: object.getElements()) {
				currentType = wasType;
				if (doSwitch(element))
					return true;
				if (currentType != wasType) {
					if (alternativeTypes != null)
						alternativeTypes.add(currentType);
					else
						alternativeTypes = Lists.newArrayList(currentType);
				}
			}
			if (alternativeTypes != null) {
				if (alternativeTypes.size() != object.getElements().size()) {
					alternativeTypes.add(wasType);
				}
				currentType = null;
				for(EClassifier classifier: alternativeTypes) {
					currentType = getCompatibleType(currentType, classifier, object);
				}
			}
			if (object == stopElement)
				return true;
			if (GrammarUtil.isOptionalCardinality(object))
				currentType = getCompatibleType(currentType, wasType, object);
			return false;
		}
		
	}
	
}
