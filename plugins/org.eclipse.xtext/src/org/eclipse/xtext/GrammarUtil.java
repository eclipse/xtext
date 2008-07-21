/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext;

import static org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer;
import static org.eclipse.xtext.EcoreUtil2.eAllContentsAsList;
import static org.eclipse.xtext.EcoreUtil2.getAllContentsOfType;
import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;
import static org.eclipse.xtext.EcoreUtil2.typeSelect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.Strings;

/**
 * 
 * @author koehnlein
 * @author svenefftinge
 */
public class GrammarUtil {

	private static URI getClasspathURIForLanguageId(String id) {
		return URI.createURI("classpath:/" + id.replace('.', '/') + (IXtextBuiltin.ID.equals(id)?".xmi":".xtext"));
	}

	public static EPackage loadEPackage(ReferencedMetamodel ref) {
		if (ref==null)
			throw new NullPointerException("ReferencedMetamodel was null");
		if (EPackage.Registry.INSTANCE.containsKey(ref.getUri()))
			return EPackage.Registry.INSTANCE.getEPackage(ref.getUri());
		URI uri = URI.createURI(ref.getUri());
		if (uri.fragment() == null) {
			Resource resource = ref.eResource().getResourceSet().getResource(uri, true);
			return (EPackage) resource.getContents().get(0);
		} else {
			return (EPackage) ref.eResource().getResourceSet().getEObject(uri, true);
		}
	}

	public static ParserRule getDefaultEntryRule(Grammar g) {
		if (g.isAbstract())
			return null;
		return GrammarUtil.allParserRules(g).get(0);
	}

	public static String getLanguageId(Grammar g) {
		return Strings.concat(".", g.getIdElements());
	}

	public static String getName(Grammar g) {
		return g.getIdElements().get(g.getIdElements().size() - 1);
	}

	public static String getNamespace(Grammar g) {
		return Strings.concat(".", g.getIdElements(), 1);
	}

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
		if (_this == null)
			throw new NullPointerException("Grammar was null");
		String id = getSuperGrammarId(_this);
		if (id==null)
			return null;
		if (!(_this.eResource() != null && _this.eResource().getResourceSet() instanceof XtextResourceSet)) 
			throw new IllegalArgumentException("The passed grammar is not contained in a Resourceset");
		ResourceSet resourceSet = _this.eResource().getResourceSet();
		URI uri = getClasspathURIForLanguageId(id);
		//uri = uri.appendFragment(""); 
		Resource resource = resourceSet.getResource(uri, true);
		if (resource==null)
			throw new IllegalArgumentException("Couldn't find grammar for super language "+id);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		return grammar;
	}

	public static String getSuperGrammarId(Grammar _this) {
		if (IXtextBuiltin.ID.equals(getLanguageId(_this))) {
			return null;
		}
		if (_this.getSuperGrammarIdElements().isEmpty())
			return IXtextBuiltin.ID;
		StringBuffer buff = new StringBuffer();
		for (int i = 0, x = _this.getSuperGrammarIdElements().size(); i < x; i++) {
			buff.append(_this.getSuperGrammarIdElements().get(i));
			if ((i + 1) < x)
				buff.append(".");
		}
		return buff.toString();
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
		return grammarModel.isAbstract();
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

	public static Set<String> getAllKeywords(Grammar g) {
		Set<String> kws = new HashSet<String>();
		List<ParserRule> rules = allParserRules(g);
		for (ParserRule parserRule : rules) {
			List<Keyword> list = typeSelect(eAllContentsAsList(parserRule), Keyword.class);
			for (Keyword keyword : list) {
				kws.add(keyword.getValue());
			}
		}
		return kws;
	}

	public static boolean isOptionalCardinality(AbstractElement e) {
		return e.getCardinality() != null && (e.getCardinality().equals("?") || e.getCardinality().equals("*"));
	}

	public static boolean isMultipleCardinality(AbstractElement e) {
		return isOneOrMoreCardinality(e) || isAnyCardinality(e);
	}

	public static String getClasspathRelativePathToXmi(Grammar grammar) {
		return getLanguageId(grammar).replace('.', '/') + ".xmi";
	}

	public static boolean isOneOrMoreCardinality(AbstractElement e) {
		return e.getCardinality() != null && (e.getCardinality().equals("+"));
	}

	public static boolean isAnyCardinality(AbstractElement e) {
		return e.getCardinality() != null && (e.getCardinality().equals("*"));
	}

}
