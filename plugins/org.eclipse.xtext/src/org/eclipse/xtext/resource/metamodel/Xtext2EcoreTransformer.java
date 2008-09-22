/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class Xtext2EcoreTransformer {

	private Grammar grammar;
	private Map<String, EPackage> generatedEPackages;
	private Grammar superGrammar;
	private EClassifierInfos eClassifierInfos;

	public Xtext2EcoreTransformer() {
	}

	/*
	 * pre-conditions - ensure non-duplicate aliases - ensure all aliases have
	 * matching metamodel declarations
	 */

	public List<EPackage> transform(Grammar grammar) {
		this.grammar = grammar;
		generatedEPackages = new HashMap<String, EPackage>();
		superGrammar = GrammarUtil.getSuperGrammar(grammar);
		eClassifierInfos = new EClassifierInfos();
		if (superGrammar != null)
			collectEClassInfosOfSuperGrammar();
		collectEPackages();

		// create types:
		// iterate rules
		// - typeref in actions
		for (AbstractRule rule : grammar.getRules()) {
			// - return types (lexer and parser rules)
			try {
				EClassifierInfo generatedEClass = findOrCreateEClass(rule);
				if (rule instanceof ParserRule) {
					ParserRule parserRule = (ParserRule) rule;
					deriveTypesAndHierarchy(generatedEClass, parserRule.getAlternatives());
				}
			}
			catch (TransformationException e) {
				reportError(e.getMessage(), e.getErroneousElement());
			}
		}

		// create features
		// iterate rules
		// - assignments
		// - feature in actions
		// multiplicity!
		for (AbstractRule rule : grammar.getRules()) {
			try {
				if (rule instanceof ParserRule) {
					this.deriveFeatures((ParserRule) rule);
				}
			}
			catch (TransformationException e) {
				reportError(e.getMessage(), e.getErroneousElement());
			}
		}

		// type hierarchy
		// - rule calls (optionality)
		// - actions

		// feature normalization
		// - uplift of common feature to supertype
		// - removal in subtype if already in supertype
		// - don't combine features with different EDatatypes
		fillGeneratedPackages();

		return new ArrayList<EPackage>(generatedEPackages.values());
	}

	private void collectEClassInfosOfSuperGrammar() {
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer();
		transformer.transform(superGrammar);
		this.getEClassifierInfos().addAll(transformer.getEClassifierInfos());
	}

	private InterpretationContext deriveFeatures(InterpretationContext context, AbstractElement element)
			throws TransformationException {
		if (element instanceof Assignment) {
			Assignment assignment = (Assignment) element;
			context.addFeature(assignment);
		}
		else if (element instanceof Group) {
			Group group = (Group) element;
			return deriveFeatures(context, group.getAbstractTokens());
		}
		else if (element instanceof RuleCall && !GrammarUtil.isOptionalCardinality(element)) {
			RuleCall ruleCall = (RuleCall) element;
			AbstractRule calledRule = GrammarUtil.findRuleForName(grammar, ruleCall.getName());
			context = context.clone();
			context.currentType = findOrCreateEClass(calledRule);
		}

		return context;
	}

	private InterpretationContext deriveFeatures(InterpretationContext context, EList<AbstractElement> elements)
			throws TransformationException {
		for (AbstractElement element : elements) {
			context = deriveFeatures(context, element);
		}
		return context;
	}

	private void deriveFeatures(ParserRule rule) throws TransformationException {
		EClassifierInfo classInfo = findOrCreateEClass(rule);
		boolean isGenerated = classInfo.isGenerated();
		InterpretationContext context = new InterpretationContext(classInfo, isGenerated, true);
		deriveFeatures(context, rule.getAlternatives());
	}

	// TODO : Try to get rid of
	private TypeRef getOrFakeReturnType(AbstractRule rule) {
		TypeRef result = rule.getType();
		if (result == null) {
			String returnTypeName = GrammarUtil.getReturnTypeName(rule);
			result = GrammarUtil.getTypeRef(returnTypeName);
		}
		return result;
	}

	private void fillGeneratedPackages() {

	}

	/**
	 * @param alternatives
	 * @throws TransformationException
	 */
	private void deriveTypesAndHierarchy(EClassifierInfo ruleReturnType, AbstractElement element)
			throws TransformationException {
		if (element instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) element;
			AbstractRule calledRule = GrammarUtil.calledRule(ruleCall);
			TypeRef calledRuleReturnTypeRef = getOrFakeReturnType(calledRule);
			addSuperType(calledRuleReturnTypeRef, ruleReturnType);
		}
		else if (element instanceof Action) {
			Action action = (Action) element;
			TypeRef actionTypeRef = action.getTypeName();
			addSuperType(actionTypeRef, ruleReturnType);
		}
		else if (element instanceof Group) {
			Group group = (Group) element;
			deriveTypesAndHierarchy(ruleReturnType, group.getAbstractTokens());
		}
		else if (element instanceof Alternatives) {
			Alternatives alternatives = (Alternatives) element;
			deriveTypesAndHierarchy(ruleReturnType, alternatives.getGroups());
		}
	}

	private void deriveTypesAndHierarchy(EClassifierInfo ruleReturnType, List<AbstractElement> elements)
			throws TransformationException {
		for (AbstractElement element : elements) {
			deriveTypesAndHierarchy(ruleReturnType, element);
		}
	}

	private void addSuperType(TypeRef subTypeRef, EClassifierInfo superType) throws TransformationException {
		EClassifierInfo calledRuleReturnType = findOrCreateEClass(subTypeRef);
		calledRuleReturnType.addSupertype(superType);
	}

	class InterpretationContext {
		public InterpretationContext(EClassifierInfo currentType, boolean isGeneratedType, boolean isRuleCallAllowed) {
			super();
			this.currentType = currentType;
			this.isGeneratedType = isGeneratedType;
			this.isRuleCallAllowed = isRuleCallAllowed;
		}

		public void addFeature(Assignment assignment) throws TransformationException {
			String featureName = assignment.getFeature();
			boolean isMultivalue = GrammarUtil.isMultipleAssignment(assignment);
			EClassifierInfo featureTypeInfo;

			if (GrammarUtil.isBooleanAssignment(assignment)) {
				featureTypeInfo = getEClassifierInfoOrThrowException("ecore::EBoolean", assignment);
				isMultivalue = false;
			}
			else {
				RuleCall featureRuleCall = (RuleCall) assignment.getTerminal();
				AbstractRule featureTypeRule = GrammarUtil.calledRule(featureRuleCall);
				String featureTypeName = GrammarUtil.getReturnTypeName(featureTypeRule);
				featureTypeInfo = getEClassifierInfoOrThrowException(featureTypeName, assignment);

			}

			currentType.addFeature(featureName, featureTypeInfo, isMultivalue);
		}

		private EClassifierInfo getEClassifierInfoOrThrowException(String typeName, AbstractElement parserElement)
				throws TransformationException {
			EClassifierInfo featureTypeInfo = eClassifierInfos.getInfo(typeName);
			if (featureTypeInfo == null) {
				throw new TransformationException("Cannot resolve type " + typeName, parserElement);
			}
			return featureTypeInfo;
		}

		public InterpretationContext clone() {
			return new InterpretationContext(currentType, isGeneratedType, isRuleCallAllowed);
		}

		// TODO : Use set of types to reflect mandatory actions
		EClassifierInfo currentType;
		boolean isGeneratedType;
		boolean isRuleCallAllowed = true;
	}

	private void collectEPackages() {
		EList<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
		for (AbstractMetamodelDeclaration metamodelDeclaration : metamodelDeclarations) {
			if (metamodelDeclaration instanceof ReferencedMetamodel) {
				// load imported metamodel
				ReferencedMetamodel referencedMetamodel = (ReferencedMetamodel) metamodelDeclaration;
				EPackage referencedEPackage = GrammarUtil.loadEPackage(referencedMetamodel);
				if (referencedEPackage == null) {
					reportError("Cannot not load metamodel " + referencedMetamodel.getUri(), referencedMetamodel);
				}
				else {
					String alias = referencedMetamodel.getAlias();
					if (Strings.isEmpty(alias)) {
						reportError("Referenced metamodels must have an alias", referencedMetamodel);
					}
					else {
						collectClassInfosOf(referencedEPackage, alias);
					}
				}
			}
			else if (metamodelDeclaration instanceof GeneratedMetamodel) {
				// instantiate EPackages for generated metamodel
				GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel) metamodelDeclaration;
				EPackage generatedEPackage = EcoreFactory.eINSTANCE.createEPackage();
				generatedEPackage.setName(generatedMetamodel.getName());
				generatedEPackage.setNsPrefix(generatedMetamodel.getName());
				generatedEPackage.setNsURI(generatedMetamodel.getNsURI());
				String alias = Strings.emptyIfNull(generatedMetamodel.getAlias());
				generatedEPackages.put(alias, generatedEPackage);
			}
		}
	}

	private void collectClassInfosOf(EPackage referencedEPackage, String alias) {
		for (EClassifier eClassifier : referencedEPackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				EClassifierInfo info = EClassifierInfo.createEClassInfo(eClass, false);
				eClassifierInfos.addInfo(alias, eClassifier.getName(), info);
			}
			else if (eClassifier instanceof EDataType) {
				EDataType eDataType = (EDataType) eClassifier;
				EClassifierInfo info = EClassifierInfo.createEDataTypeInfo(eDataType, false);
				eClassifierInfos.addInfo(alias, eClassifier.getName(), info);
			}
		}
	}

	/**
	 * @param string
	 * @param generatedMetamodel
	 */
	private void reportError(String message, EObject erroneousElement) {
		// TODO Auto-generated method stub

	}

	private void raiseError(String message, EObject erroneousElement) throws TransformationException {
		throw new TransformationException(message, erroneousElement);
	}

	private EClassifierInfo findOrCreateEClass(AbstractRule rule) throws TransformationException {
		TypeRef typeRef = getOrFakeReturnType(rule);
		return findOrCreateEClass(typeRef);
	}

	private EClassifierInfo findOrCreateEClass(TypeRef typeRef) throws TransformationException {
		EClassifierInfo info = eClassifierInfos.getInfo(typeRef);
		if (info == null) {
			info = createEClass(typeRef);
		}
		return info;
	}

	private EClassifierInfo createEClass(TypeRef typeRef) throws TransformationException {
		if (eClassifierInfos.getInfo(typeRef) != null)
			throw new IllegalArgumentException("Cannot create EClass for same type twice"
					+ GrammarUtil.getQualifiedName(typeRef));

		EClassifierInfo info;
		String typeRefAlias = Strings.emptyIfNull(typeRef.getAlias());
		String typeRefName = typeRef.getName();
		EPackage generatedEPackage = generatedEPackages.get(typeRefAlias);
		if (generatedEPackage == null) {
			raiseError("Cannot create type in alias " + typeRefAlias, typeRef);
		}
		EClass generatedEClass = EcoreFactory.eINSTANCE.createEClass();
		generatedEClass.setName(typeRefName);
		generatedEPackage.getEClassifiers().add(generatedEClass);
		info = EClassifierInfo.createEClassInfo(generatedEClass, true);
		eClassifierInfos.addInfo(typeRef, info);
		return info;
	}

	public EClassifierInfos getEClassifierInfos() {
		return eClassifierInfos;
	}

}
