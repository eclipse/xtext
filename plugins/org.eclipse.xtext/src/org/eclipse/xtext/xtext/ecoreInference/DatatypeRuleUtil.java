/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.HashSet;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class DatatypeRuleUtil extends XtextSwitch<Boolean>{

	static boolean isDatatypeRule(ParserRule rule) {
		DatatypeRuleFinder finder = new DatatypeRuleFinder();
		return finder.doSwitch(rule) && finder.indicatorFound;
	}

	static boolean isValidDatatypeRule(ParserRule rule) {
		return new DatatypeRuleChecker().doSwitch(rule);
	}

	static class DatatypeRuleFinder extends DatatypeRuleUtil {

		private boolean indicatorFound;

		@Override
		public Boolean caseTerminalRule(TerminalRule object) {
			indicatorFound = true;
			return super.caseTerminalRule(object);
		}

		@Override
		public Boolean caseParserRule(ParserRule object) {
			final TypeRef typeRef = object.getType();
			if (typeRef != null) {
				if (typeRef.getClassifier() != null) {
					boolean result = GrammarUtil.isDatatypeRule(object);
					if (result)
						indicatorFound = true;
					return result;
				}
				if (visitedRules.add(object)) {
					if (object.getAlternatives() != null && doSwitch(object.getAlternatives())) {
						typeRef.setClassifier(EcorePackage.Literals.ESTRING);
						return true;
					}
				} else {
					return true;
				}
			}
			return !visitedRules.add(object) || (object.getAlternatives() != null && doSwitch(object.getAlternatives()));
		}

	}

	static class DatatypeRuleChecker extends DatatypeRuleFinder {

		@Override
		public Boolean caseParserRule(ParserRule object) {
			if (visitedRules.isEmpty()) {
				visitedRules.add(object);
				return object.getAlternatives() != null && doSwitch(object.getAlternatives());
			}
			final TypeRef typeRef = object.getType();
			if (typeRef == null || typeRef.getClassifier() == null) {
				throw new IllegalStateException("checks are only allowed for linked grammars. Rule: " + object.getName());
			}
			return !visitedRules.add(object) || GrammarUtil.isDatatypeRule(object);
		}

	}

	protected final HashSet<AbstractRule> visitedRules;

	protected DatatypeRuleUtil() {
		this.visitedRules = new HashSet<AbstractRule>();
	}

	@Override
	public Boolean caseAbstractElement(AbstractElement object) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseAlternatives(Alternatives object) {
		boolean result = true;
		for(int i = 0; i < object.getGroups().size() && result; i++) {
			result &= doSwitch(object.getGroups().get(i));
		}
		return result;
	}

	@Override
	public Boolean caseGroup(Group object) {
		boolean result = true;
		for(int i = 0; i < object.getTokens().size() && result; i++) {
			AbstractElement token = object.getTokens().get(i);
			result &= doSwitch(token);
		}
		return result;
	}

	@Override
	public Boolean caseKeyword(Keyword object) {
		return Boolean.TRUE;
	}

	@Override
	public Boolean caseTerminalRule(TerminalRule object) {
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseAbstractRule(AbstractRule object) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseRuleCall(RuleCall object) {
		return object.getRule() != null && doSwitch(object.getRule());
	}


}
