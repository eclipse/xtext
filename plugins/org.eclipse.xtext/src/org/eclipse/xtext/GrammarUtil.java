/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext;

import static org.eclipse.emf.ecore.util.EcoreUtil.*;
import static org.eclipse.xtext.EcoreUtil2.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builtin.XtextBuiltinLanguageFacade;

/**
 * 
 * @author koehnlein
 * @author svenefftinge
 */
public class GrammarUtil {
	public static Grammar getGrammar(EObject grammarElement) {
		EObject root = getRootContainer(grammarElement);
		if (root instanceof Grammar) {
			return (Grammar) root;
		}
		return null;
	}

	public static ParserRule containingParserRule(EObject e) {
		return getContainerOfType(e, ParserRule.class);
	}

	public static Assignment containingAssignment(EObject e) {
		return getContainerOfType(e, Assignment.class);
	}

	public static Group containingGroup(EObject e) {
		return getContainerOfType(e, Group.class);
	}

	public static List<Action> containedActions(EObject e) {
		List<Action> allContentsOfType = getAllContentsOfType(e, Action.class);
		return allContentsOfType;
	}

	public static List<RuleCall> containedRuleCalls(EObject e) {
		return getAllContentsOfType(e, RuleCall.class);
	}

	public static List<Assignment> containedAssignments(EObject e) {
		return getAllContentsOfType(e, Assignment.class);
	}

	public static List<AbstractElement> elementsBeforeThisInContainingGroup(AbstractElement _this) {
		Group g = containingGroup(_this);
		List<AbstractElement> result = new ArrayList<AbstractElement>();
		for (AbstractElement ae : g.getAbstractTokens()) {
			if (ae == _this || eAllContentsAsList(ae).contains(_this)) {
				return result;
			} else {
				result.add(ae);
			}
		}
		return result;
	}

	public static boolean isLexerRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = calledRule((RuleCall) grammarElement);
			return calledRule != null && (calledRule instanceof LexerRule);
		}
		return false;
	}

	public static boolean isParserRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = calledRule((RuleCall) grammarElement);
			return calledRule != null && (calledRule instanceof ParserRule);
		}
		return false;
	}

	public static AbstractRule calledRule(RuleCall ruleCall) {
		Grammar g = getGrammar(ruleCall);
		List<AbstractRule> rules = allRules(g);
		for (AbstractRule rule : rules) {
			if (ruleCall.getName().equals(rule.getName())) {
				return rule;
			}
		}
		return null;
	}

	public static Grammar getSuperGrammar(Grammar _this) {
		if (_this.getSuperGrammar() == null) {
			Grammar superGrammar = LanguageFacadeFactory.getFacade(XtextBuiltinLanguageFacade.ID).getGrammar();
			return superGrammar == _this ? null : superGrammar;
		}
		return LanguageFacadeFactory.getFacade(_this.getSuperGrammar()).getGrammar();
	}

	public static String getID(EObject eObject) {
		Resource resource = eObject.eResource();
		String fragment = resource.getURIFragment(eObject);
		return fragment;
	}

	public static AbstractRule findRuleForName(Grammar _this, String ruleName) {
		List<AbstractRule> rules = allRules(_this);
		for (AbstractRule abstractRule : rules) {
			if (abstractRule.getName().equals(ruleName)) {
				return abstractRule;
			}
		}
		return null;
	}

	public static List<AbstractRule> allRules(Grammar _this) {
		List<AbstractRule> result = new ArrayList<AbstractRule>();
		result.addAll(allParserRules(_this));
		result.addAll(allLexerRules(_this));
		return result;
	}

	public static List<ParserRule> allParserRules(Grammar _this) {
		List<ParserRule> result = new ArrayList<ParserRule>();
		Set<String> names = new HashSet<String>();
		for (ParserRule rule : _this.getParserRules()) {
			if (names.add(rule.getName())) {
				result.add(rule);
			}
		}

		Grammar superGrammar = getSuperGrammar(_this);
		if (superGrammar != null) {
			List<ParserRule> superParserRules = allParserRules(superGrammar);
			for (ParserRule r : superParserRules) {
				if (names.add(r.getName())) {
					result.add(r);
				}
			}
		}
		return result;
	}

	public static List<LexerRule> allLexerRules(Grammar _this) {
		List<LexerRule> result = new ArrayList<LexerRule>();
		Set<String> names = new HashSet<String>();
		for (LexerRule rule : _this.getLexerRules()) {
			if (names.add(rule.getName())) {
				result.add(rule);
			}
		}

		Grammar superGrammar = getSuperGrammar(_this);
		if (superGrammar != null) {
			List<LexerRule> superParserRules = allLexerRules(superGrammar);
			for (LexerRule r : superParserRules) {
				if (names.add(r.getName())) {
					result.add(r);
				}
			}
		}
		return result;
	}

	public static List<AbstractMetamodelDeclaration> allMetamodelDeclarations(Grammar _this) {
		List<AbstractMetamodelDeclaration> result = new ArrayList<AbstractMetamodelDeclaration>();
		Set<String> usedAliases = new HashSet<String>();
		EList<AbstractMetamodelDeclaration> list = _this.getMetamodelDeclarations();
		for (AbstractMetamodelDeclaration dec : list) {
			if (usedAliases.add(dec.getAlias()))
				result.add(dec);
		}

		Grammar superGrammar = getSuperGrammar(_this);
		if (superGrammar != null) {
			for (AbstractMetamodelDeclaration dec : allMetamodelDeclarations(superGrammar)) {
				if (usedAliases.add(dec.getAlias()))
					result.add(dec);
			}
		}
		return result;
	}

	public static boolean isAbstract(Grammar grammarModel) {
		return typeSelect(grammarModel.getMetamodelDeclarations(), GeneratedMetamodel.class).isEmpty();
	}

	public static String getReturnTypeName(AbstractRule rule) {
		if (rule.getType() == null) {
			if (rule instanceof LexerRule) {
				return "ecore::EString";
			}
			return rule.getName();
		}
		return getQualifiedName(rule.getType());
	}

	public static String getQualifiedName(TypeRef type) {
		return (type.getAlias() != null ? type.getAlias() + "::" : "") + type.getName();
	}

	public static boolean isAssigned(EObject e) {
		return containingAssignment(e) != null;
	}

}
