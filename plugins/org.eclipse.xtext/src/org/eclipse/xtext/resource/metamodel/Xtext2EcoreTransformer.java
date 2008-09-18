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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class Xtext2EcoreTransformer {

	private Grammar grammar;
	private Map<String, EPackage> generatedEPackages;
	private Grammar superGrammar;
	private EClassInfos eClassInfos;

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
		eClassInfos = new EClassInfos();
		collectEPackages();

		// create types:
		// iterate rules
		// - typeref in actions
		for (AbstractRule rule : grammar.getRules()) {
			// - return types (lexer and parser rules)
			TypeRef ruleReturnTypeRef = rule.getType();
			try {
				if (ruleReturnTypeRef == null) {
					ruleReturnTypeRef = XtextFactory.eINSTANCE.createTypeRef();
					ruleReturnTypeRef.setName(rule.getName());
				}
				EClassInfo generatedEClass = findOrCreateEClass(ruleReturnTypeRef);
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

	private void fillGeneratedPackages() {

	}

	/**
	 * @param alternatives
	 * @throws TransformationException
	 */
	private void deriveTypesAndHierarchy(EClassInfo ruleReturnType, AbstractElement element)
			throws TransformationException {
		if (element instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) element;
			AbstractRule calledRule = GrammarUtil.calledRule(ruleCall);
			TypeRef calledRuleReturnTypeRef = calledRule.getType();
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

	private void deriveTypesAndHierarchy(EClassInfo ruleReturnType, List<AbstractElement> elements)
			throws TransformationException {
		for (AbstractElement element : elements) {
			deriveTypesAndHierarchy(ruleReturnType, element);
		}
	}

	private void addSuperType(TypeRef subTypeRef, EClassInfo superType) throws TransformationException {
		EClassInfo calledRuleReturnType = findOrCreateEClass(subTypeRef);
		calledRuleReturnType.addSupertype(superType);
	}

	class InterpretationContext {
		public InterpretationContext(EClass currentType, boolean isGeneratedType, boolean isRuleCallAllowed) {
			super();
			this.currentType = currentType;
			this.isGeneratedType = isGeneratedType;
			this.isRuleCallAllowed = isRuleCallAllowed;
		}

		public InterpretationContext clone() {
			return new InterpretationContext(currentType, isGeneratedType, isRuleCallAllowed);
		}

		EClass currentType;
		boolean isGeneratedType;
		boolean isRuleCallAllowed = true;
	}

	private InterpretationContext interpretElement(AbstractElement element, EClass returnType) {
		// TODO: implement
		return null;
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
						for (EClassifier eClassifier : referencedEPackage.getEClassifiers()) {
							if (eClassifier instanceof EClass) {
								EClassInfo info = new EClassInfo((EClass) eClassifier, false);
								eClassInfos.addInfo(alias, eClassifier.getName(), info);
							}
						}
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

	private EClassInfo findOrCreateEClass(TypeRef typeRef) throws TransformationException {
		EClassInfo info = eClassInfos.getInfo(typeRef);
		if (info == null) {
			String typeRefAlias = Strings.emptyIfNull(typeRef.getAlias());
			String typeRefName = typeRef.getName();
			EPackage generatedEPackage = generatedEPackages.get(typeRefAlias);
			if (generatedEPackage == null) {
				raiseError("Cannot create type in alias " + typeRefAlias, typeRef);
			}
			EClass generatedEClass = EcoreFactory.eINSTANCE.createEClass();
			generatedEClass.setName(typeRefName);
			generatedEPackage.getEClassifiers().add(generatedEClass);
			info = new EClassInfo(generatedEClass, true);
			eClassInfos.addInfo(typeRef, info);
		}
		return info;
	}

}
