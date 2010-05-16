/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import static org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer;
import static org.eclipse.xtext.EcoreUtil2.eAllContentsAsList;
import static org.eclipse.xtext.EcoreUtil2.getAllContentsOfType;
import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;
import static org.eclipse.xtext.EcoreUtil2.typeSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

/**
 * @author Jan Koehnlein
 * @author Sven Efftinge
 * @author Heiko Behrens
 * @author Sebastian Zarnekow
 */
public class GrammarUtil {

	public static String getClasspathRelativePathToXmi(Grammar grammar) {
		return getLanguageId(grammar).replace('.', '/') + ".xmi";
	}

	public static String getLanguageId(Grammar g) {
		return g.getName();
	}

	public static String getName(Grammar g) {
		if (Strings.isEmpty(g.getName()))
			return null;
		String[] splitted = g.getName().split("\\.");
		return splitted[splitted.length - 1];
	}

	public static String getNamespace(Grammar g) {
		if (Strings.isEmpty(g.getName()))
			return null;
		String[] splitted = g.getName().split("\\.");
		return Strings.concat(".", Arrays.asList(splitted), 1);
	}

	public static Grammar getGrammar(EObject grammarElement) {
		EObject root = getRootContainer(grammarElement);
		if (root instanceof Grammar) {
			return (Grammar) root;
		}
		return null;
	}

	public static AbstractRule containingRule(EObject e) {
		return getContainerOfType(e, AbstractRule.class);
	}
	
	public static ParserRule containingParserRule(EObject e) {
		return getContainerOfType(e, ParserRule.class);
	}

	public static EnumRule containingEnumRule(EObject e) {
		return getContainerOfType(e, EnumRule.class);
	}

	public static Assignment containingAssignment(EObject e) {
		return getContainerOfType(e, Assignment.class);
	}

	public static Group containingGroup(EObject e) {
		return getContainerOfType(e, Group.class);
	}
	
	public static CrossReference containingCrossReference(EObject e) {
		return getContainerOfType(e, CrossReference.class);
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

	public static List<Keyword> containedKeywords(EObject e) {
		return getAllContentsOfType(e, Keyword.class);
	}

	public static List<AbstractElement> containedAbstractElements(EObject e) {
		return getAllContentsOfType(e, AbstractElement.class);
	}

	public static List<CrossReference> containedCrossReferences(EObject e) {
		return getAllContentsOfType(e, CrossReference.class);
	}

	public static List<AbstractElement> elementsBeforeThisInContainingGroup(AbstractElement _this) {
		Group g = containingGroup(_this);
		List<AbstractElement> result = new ArrayList<AbstractElement>();
		for (AbstractElement ae : g.getElements()) {
			if (ae == _this || eAllContentsAsList(ae).contains(_this)) {
				return result;
			}
			result.add(ae);
		}
		return result;
	}

	public static boolean isParserRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = ((RuleCall) grammarElement).getRule();
			return calledRule != null && (calledRule instanceof ParserRule);
		}
		return false;
	}

	public static AbstractRule findRuleForName(Grammar grammar, String ruleName) {
		if (ruleName == null)
			return null;
		List<AbstractRule> rules = allRules(grammar);
		for (AbstractRule abstractRule : rules) {
			if (ruleName.equals(abstractRule.getName())) {
				return abstractRule;
			}
		}
		return null;
	}
	
	public static List<Grammar> allUsedGrammars(Grammar grammar) {
		List<Grammar> grammars = new ArrayList<Grammar>();
		collectAllUsedGrammars(grammars, grammar);
		return grammars;
	}

	private static void collectAllUsedGrammars(List<Grammar> grammars, Grammar grammar) {
		grammars.addAll(grammar.getUsedGrammars());
		for (Grammar g : grammar.getUsedGrammars())
			collectAllUsedGrammars(grammars, g);
	}

	public static List<AbstractRule> allRules(Grammar grammar) {
		final List<AbstractRule> result = new ArrayList<AbstractRule>();
		final Set<String> names = new HashSet<String>();
		final Set<Grammar> grammars = new HashSet<Grammar>();
		collectAllRules(grammar, result, grammars, names);
		return result;
	}

	private static void collectAllRules(Grammar grammar, List<AbstractRule> result,
			Set<Grammar> visitedGrammars, Set<String> knownRulenames) {
		if (!visitedGrammars.add(grammar))
			return;

		for (AbstractRule rule : grammar.getRules()) {
			if (knownRulenames.add(rule.getName())) {
				result.add(rule);
			}
		}

		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			collectAllRules(usedGrammar, result, visitedGrammars, knownRulenames);
		}
	}

	public static List<ParserRule> allParserRules(Grammar _this) {
		return typeSelect(allRules(_this), ParserRule.class);
	}

	public static List<EnumRule> allEnumRules(Grammar _this) {
		return typeSelect(allRules(_this), EnumRule.class);
	}

	public static List<TerminalRule> allTerminalRules(Grammar _this) {
		return typeSelect(allRules(_this), TerminalRule.class);
	}

	public static List<AbstractMetamodelDeclaration> allMetamodelDeclarations(Grammar grammar) {
		final List<AbstractMetamodelDeclaration> result = new ArrayList<AbstractMetamodelDeclaration>();
		final Set<Pair<String, String>> pairs = new HashSet<Pair<String, String>>();
		final Set<Grammar> grammars = new HashSet<Grammar>();
		collectAllMetamodelDeclarations(grammar, result, pairs, grammars);
		return result;
	}

	private static void collectAllMetamodelDeclarations(Grammar grammar, List<AbstractMetamodelDeclaration> result,
			Set<Pair<String, String>> knownAliases, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return;

		for (AbstractMetamodelDeclaration decl : grammar.getMetamodelDeclarations()) {
			if (decl.getEPackage() == null)
				result.add(decl);
			else if (knownAliases.add(getURIAliasPair(decl))) {
				result.add(decl);
			}
		}
		for(Grammar usedGrammar: grammar.getUsedGrammars())
			collectAllMetamodelDeclarations(usedGrammar, result, knownAliases, visitedGrammars);
	}

	private static Pair<String, String> getURIAliasPair(AbstractMetamodelDeclaration decl) {
		return Tuples.create(decl.getEPackage().getNsURI(), Strings.emptyIfNull(decl.getAlias()));
	}

	public static String getTypeRefName(TypeRef typeRef) {
		if (typeRef.getClassifier() != null)
			return typeRef.getClassifier().getName();
		final NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(typeRef);
		if (nodeAdapter != null) {
			final CompositeNode node = nodeAdapter.getParserNode();
			final List<LeafNode> leafNodes = node.getLeafNodes();
			for (int i = leafNodes.size() - 1; i >= 0; i--) {
				final LeafNode leaf = leafNodes.get(i);
				if (!leaf.isHidden())
					return leaf.getText();
			}
		}
		return null;
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
		List<EnumRule> enumRules = allEnumRules(g);
		for (EnumRule enumRule : enumRules) {
			List<Keyword> list = typeSelect(eAllContentsAsList(enumRule), Keyword.class);
			for (Keyword keyword : list) {
				kws.add(keyword.getValue());
			}
		}
		return kws;
	}

	public static boolean isBooleanAssignment(Assignment a) {
		return "?=".equals(a.getOperator());
	}

	public static boolean isSingleAssignment(Assignment a) {
		return "=".equals(a.getOperator());
	}

	public static boolean isMultipleAssignment(Assignment a) {
		return "+=".equals(a.getOperator());
	}

	public static boolean isMultipleAssignment(Action a) {
		return "+=".equals(a.getOperator());
	}

	public static boolean isOptionalCardinality(AbstractElement e) {
		return e.getCardinality() != null && (e.getCardinality().equals("?") || e.getCardinality().equals("*"));
	}

	public static boolean isMultipleCardinality(AbstractElement e) {
		return isOneOrMoreCardinality(e) || isAnyCardinality(e);
	}

	public static boolean isOneOrMoreCardinality(AbstractElement e) {
		return e.getCardinality() != null && (e.getCardinality().equals("+"));
	}

	public static boolean isAnyCardinality(AbstractElement e) {
		return e.getCardinality() != null && (e.getCardinality().equals("*"));
	}

	public static boolean isDatatypeRule(ParserRule parserRule) {
		return parserRule.getType() != null && parserRule.getType().getClassifier() instanceof EDataType;
	}

	// TODO replace me by compiled grammar model
	public static EReference getReference(CrossReference ref, EClass referenceOwner) {
		final List<EReference> references = referenceOwner.getEAllReferences();
		final String feature = GrammarUtil.containingAssignment(ref).getFeature();
		for (EReference reference : references) {
			if (!reference.isContainment() && reference.getName().equals(feature))
				return reference;
		}
		return null;
	}

	// TODO replace me by compiled grammar model
	public static EReference getReference(CrossReference crossRef) {
		EClassifier referenceOwner = findCurrentType(crossRef);
		if (referenceOwner instanceof EClass)
			return getReference(crossRef, (EClass) referenceOwner);
		return null;
	}
	
	public static EClassifier findCurrentType(final AbstractElement element) {
		return new CurrentTypeFinder().findCurrentTypeAfter(element);
	}

}
