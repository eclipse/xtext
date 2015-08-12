/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.emf.ecore.util.EcoreUtil.*;
import static org.eclipse.xtext.EcoreUtil2.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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
	
	/**
	 * @since 2.4
	 */
	public static String getClasspathRelativePathToBinGrammar(Grammar grammar) {
		return getLanguageId(grammar).replace('.', '/') + ".xtextbin";
	}

	public static String getLanguageId(Grammar g) {
		return g.getName();
	}

	public static String getName(Grammar g) {
		String fullName = g.getName();
		if (Strings.isEmpty(fullName))
			return null;
		int nameIndex = fullName.lastIndexOf('.');
		return fullName.substring(nameIndex + 1);
	}

	public static String getNamespace(Grammar g) {
		String fullName = g.getName();
		if (Strings.isEmpty(fullName))
			return null;
		int nameIndex = fullName.lastIndexOf('.');
		if (nameIndex < 0)
			return "";
		else
			return fullName.substring(0, nameIndex);
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

	public static UnorderedGroup containingUnorderedGroup(EObject e) {
		return getContainerOfType(e, UnorderedGroup.class);
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
	
	/**
	 * @since 2.0
	 */
	public static boolean containsAssignedAction(ParserRule rule) {
		TreeIterator<EObject> ti = rule.eAllContents();
		while (ti.hasNext()) {
			EObject obj = ti.next();
			if (obj instanceof Action && ((Action) obj).getFeature() != null)
				return true;
		}
		return false;
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
			return calledRule != null && calledRule instanceof ParserRule;
		}
		return false;
	}

	public static boolean isEObjectRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = ((RuleCall) grammarElement).getRule();
			return isEObjectRule(calledRule);
		}
		return false;
	}
	
	/**
	 * @since 2.0
	 */
	public static boolean isEObjectRule(EObject grammarElement) {
		if (grammarElement instanceof ParserRule) {
			ParserRule rule = (ParserRule) grammarElement;
			TypeRef type = rule.getType();
			// wildcard fragments are considered to be EObjectRules, too
			return type == null || type.getClassifier() instanceof EClass;
		}
		return false;
	}
	
	/**
	 * @since 2.0
	 */
	public static boolean isUnassignedParserRuleCall(EObject ele) {
		if (!isParserRuleCall(ele))
			return false;
		return GrammarUtil.containingAssignment(ele) == null;
	}
	
	/**
	 * @since 2.0
	 */
	public static boolean isUnassignedEObjectRuleCall(EObject ele) {
		if (!isEObjectRuleCall(ele))
			return false;
		return GrammarUtil.containingAssignment(ele) == null;
	}
	
	/**
	 * @since 2.9
	 */
	public static boolean isEObjectFragmentRuleCall(EObject ele) {
		if (ele instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) ele).getRule();
			return isEObjectFragmentRule(rule);
		}
		return false;
	}

	/**
	 * @since 2.9
	 */
	public static boolean isEObjectFragmentRule(AbstractRule rule) {
		return rule instanceof ParserRule && ((ParserRule) rule).isFragment();
	}
	
	/**
	 * @since 2.0
	 */
	public static boolean isAssignedEObjectRuleCall(EObject ele) {
		if (!isEObjectRuleCall(ele))
			return false;
		return GrammarUtil.containingAssignment(ele) != null;
	}

	public static boolean isDatatypeRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = ((RuleCall) grammarElement).getRule();
			return calledRule != null && calledRule instanceof ParserRule
					&& calledRule.getType() != null && calledRule.getType().getClassifier() instanceof EDataType;
		}
		return false;
	}
	
	public static boolean isEnumRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = ((RuleCall) grammarElement).getRule();
			return calledRule != null && calledRule instanceof EnumRule;
		}
		return false;
	}
	
	/**
	 * @since 2.0
	 */
	public static boolean isTerminalRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			AbstractRule calledRule = ((RuleCall) grammarElement).getRule();
			return calledRule != null && calledRule instanceof TerminalRule;
		}
		return false;
	}

	/**
	 * @param ruleName
	 *            the name of the rule that should be found. May be a qualified name with a dot as a delimiter.
	 */
	public static AbstractRule findRuleForName(Grammar grammar, String ruleName) {
		if (ruleName == null)
			return null;
		int lastIndex = ruleName.lastIndexOf('.');
		if (lastIndex == -1) {
			return findRuleForNameRecursively(grammar, null, ruleName, Sets.<Grammar>newHashSet());
		} else {
			return findRuleForNameRecursively(grammar, ruleName.substring(0, lastIndex), ruleName.substring(lastIndex + 1), Sets.<Grammar>newHashSet());
		}
	}

	private static AbstractRule findRuleForNameRecursively(Grammar grammar, String langName, String ruleName, Set<Grammar> visited) {
		if (visited.add(grammar)) {
			if (langName == null || langName.equals(grammar.getName())) {
				for (AbstractRule rule : grammar.getRules()) {
					if (ruleName.equals(rule.getName())) {
						return rule;
					}
				}
				if (langName != null) {
					return null;
				}
			}
			for (Grammar usedGrammar : grammar.getUsedGrammars()) {
				AbstractRule rule = findRuleForNameRecursively(usedGrammar, langName, ruleName, visited);
				if (rule != null) {
					return rule;
				}
			}
		}
		return null;
	}

	public static List<Grammar> allUsedGrammars(Grammar grammar) {
		Collection<Grammar> visitedGrammars = new LinkedHashSet<Grammar>();
		for(Grammar used: grammar.getUsedGrammars())
			collectAllUsedGrammars(used, grammar, visitedGrammars);
		return new ArrayList<Grammar>(visitedGrammars);
	}
	
	private static void collectAllUsedGrammars(Grammar grammar, Grammar start, Collection<Grammar> result) {
		if (grammar == start || !result.add(grammar))
			return;
		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			collectAllUsedGrammars(usedGrammar, start, result);
		}
	}

	public static List<AbstractRule> allRules(Grammar grammar) {
		final Set<AbstractRule> result = Sets.newLinkedHashSet();
		final Set<AbstractRule> explicitlyCalled = Sets.newHashSet();
		final Set<String> seenNames = Sets.newHashSet();
		final Set<Grammar> seenGrammars = Sets.newHashSet();
		collectAllRules(grammar, result, explicitlyCalled, seenNames, seenGrammars);
		return Lists.newArrayList(result);
	}

	private static void collectAllRules(
			Grammar grammar,
			Set<AbstractRule> result,
			Set<AbstractRule> explicitlyCalled,
			Set<String> seenNames,
			Set<Grammar> seenGrammars) {
		if (!seenGrammars.add(grammar))
			return;
		for (AbstractRule rule : grammar.getRules()) {
			// we need to iterate the rules twice in case an explicit call to a
			// rule is made from a rule defined later
			// this explicitly called rule needs to be added
			// to the set of all rules even though it may 
			// have been specialized in the sub grammar
			if (!seenNames.contains(rule.getName()) || explicitlyCalled.contains(rule)) {
				AbstractElement body = rule.getAlternatives();
				if (body != null) {
					Iterator<EObject> contents = eAll(body);
					while(contents.hasNext()) {
						EObject content = contents.next();
						if (content instanceof RuleCall) {
							AbstractRule calledRule = ((RuleCall) content).getRule();
							explicitlyCalled.add(calledRule);
						}
					}
				}
			}
		}
		for (AbstractRule rule : grammar.getRules()) {
			if (seenNames.add(rule.getName()) || explicitlyCalled.contains(rule)) {
				result.add(rule);
			}
		}
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			collectAllRules(usedGrammar, result, explicitlyCalled, seenNames, seenGrammars);
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
		for (Grammar usedGrammar : grammar.getUsedGrammars())
			collectAllMetamodelDeclarations(usedGrammar, result, knownAliases, visitedGrammars);
	}

	private static Pair<String, String> getURIAliasPair(AbstractMetamodelDeclaration decl) {
		return Tuples.create(decl.getEPackage().getNsURI(), Strings.emptyIfNull(decl.getAlias()));
	}

	public static String getTypeRefName(TypeRef typeRef) {
		if (typeRef.getClassifier() != null)
			return typeRef.getClassifier().getName();
		final ICompositeNode node = NodeModelUtils.getNode(typeRef);
		if (node != null) {
			final BidiIterator<INode> leafNodes = node.getAsTreeIterable().iterator();
			while (leafNodes.hasPrevious()) {
				INode previous = leafNodes.previous();
				if (previous instanceof ILeafNode && !((ILeafNode) previous).isHidden()) {
					String result = previous.getText();
					if (result != null && result.startsWith("^")) {
						result = result.substring(1);
					}
					return result;
				}
			}
		}
		return null;
	}

	public static boolean isAssigned(EObject e) {
		return containingAssignment(e) != null;
	}
	
	public static boolean isAssignedAction(EObject e) {
		return e instanceof Action && ((Action) e).getFeature() != null;
	}
	
	public static boolean isUnassignedAction(EObject e) {
		return e instanceof Action && ((Action) e).getFeature() == null;
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

	public static boolean isDatatypeRule(AbstractRule abstractRule) {
		return abstractRule instanceof ParserRule && isDatatypeRule((ParserRule) abstractRule);
	}

	// TODO replace me by compiled grammar model
	public static EReference getReference(CrossReference ref, EClass referenceOwner) {
		final String feature = GrammarUtil.containingAssignment(ref).getFeature();
		EStructuralFeature result = referenceOwner.getEStructuralFeature(feature);
		if (result instanceof EReference && !((EReference) result).isContainment())
			return (EReference) result;
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

	public static Collection<EPackage> allEPackagesToValidate(final Grammar _this) {
		Iterable<TypeRef> allTypeRefs = concat(transform(allParserRules(_this), new Function<ParserRule, Iterable<TypeRef>>() {
			@Override
			public Iterable<TypeRef> apply(ParserRule from) {
				return EcoreUtil2.eAllOfType(from, TypeRef.class);
			}
		}));
		return newLinkedHashSet(transform(filter(allTypeRefs, new Predicate<TypeRef>() {
			@Override
			public boolean apply(TypeRef input) {
				return !(input.eContainer() instanceof CrossReference) && input.getClassifier() instanceof EClass;
			}
		}), new Function<TypeRef, EPackage>() {
			@Override
			public EPackage apply(TypeRef from) {
				return from.getClassifier().getEPackage();
			}
		}));
	}
	
	/**
	 * Find the datatype for EString which is referable from the given grammar.
	 * @since 2.1
	 */
	public static EDataType findEString(Grammar grammar) {
		EClassifier result = findEClassifierByName(grammar, EcorePackage.eNS_URI, EcorePackage.Literals.ESTRING.getName());
		if (result instanceof EDataType)
			return (EDataType) result;
		return null;
	}
	
	/**
	 * Find the datatype for EBoolean which is referable from the given grammar.
	 * @since 2.1
	 */
	public static EDataType findEBoolean(Grammar grammar) {
		EClassifier result = findEClassifierByName(grammar, EcorePackage.eNS_URI, EcorePackage.Literals.EBOOLEAN.getName());
		if (result instanceof EDataType)
			return (EDataType) result;
		return null;
	}
	
	/**
	 * Find the class for EObject which is referable from the given grammar.
	 * @since 2.1
	 */
	public static EClass findEObject(Grammar grammar) {
		EClassifier result = findEClassifierByName(grammar, EcorePackage.eNS_URI, EcorePackage.Literals.EOBJECT.getName());
		if (result instanceof EClass)
			return (EClass) result;
		return null;
	}
	
	private static EClassifier findEClassifierByName(Grammar grammar, String nsURI, String name) {
		if (grammar != null) {
			for(AbstractMetamodelDeclaration declaration: allMetamodelDeclarations(grammar)) {
				if (declaration instanceof ReferencedMetamodel) {
					EPackage referencedPackage = declaration.getEPackage();
					if (referencedPackage != null && !referencedPackage.eIsProxy()) {
						if (nsURI.equals(referencedPackage.getNsURI())) {
							EClassifier result = referencedPackage.getEClassifier(name);
							if (result != null)
								return result;
						}
					}
				}
			}
		}
		return null;
	}
}
