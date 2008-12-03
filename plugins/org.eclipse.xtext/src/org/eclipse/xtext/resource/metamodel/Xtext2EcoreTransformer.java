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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.resource.metamodel.ErrorAcceptor.ErrorCode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * 
 */
public class Xtext2EcoreTransformer {

	private Grammar grammar;
	private Map<String, EPackage> generatedEPackages;
	private Grammar superGrammar;
	private EClassifierInfos eClassifierInfos;
	private ErrorAcceptor errorAcceptor = new NullErrorAcceptor();

	public ErrorAcceptor getErrorAcceptor() {
		return errorAcceptor;
	}

	public void setErrorAcceptor(ErrorAcceptor errorAcceptor) {
		this.errorAcceptor = errorAcceptor;
	}

	public class NullErrorAcceptor implements ErrorAcceptor {
		public void acceptError(ErrorCode errorCode, String arg0, EObject arg1) {
			// do nothing
		}
	}

	public Xtext2EcoreTransformer() {
	}

	public static List<EPackage> doTransform(Grammar grammar) throws Exception {
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer();
		try {
			return transformer.transform(grammar);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * pre-conditions - ensure non-duplicate aliases - ensure all aliases have
	 * matching metamodel declarations
	 */
	public List<EPackage> transform(Grammar grammar) {
		this.grammar = grammar;
		eClassifierInfos = new EClassifierInfos();
		generatedEPackages = new HashMap<String, EPackage>();
		superGrammar = GrammarUtil.getSuperGrammar(grammar);

		if (superGrammar != null)
			collectEClassInfosOfSuperGrammar();
		collectEPackages();

		deriveTypes();
		deriveFeatures();
		normalizeAndValidateGeneratedPackages();

		return getGeneratedPackagesSortedByName();
	}

	private List<EPackage> getGeneratedPackagesSortedByName() {
		ArrayList<EPackage> result = new ArrayList<EPackage>(generatedEPackages.values());
		Collections.sort(result, new Comparator<EPackage>() {
			public int compare(EPackage o1, EPackage o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return result;
	}

	private void deriveTypes() {
		for (AbstractRule rule : grammar.getRules()) {
			try {
				EClassifierInfo generatedEClass = findOrCreateEClass(rule);
				if (rule instanceof ParserRule) {
					ParserRule parserRule = (ParserRule) rule;
					deriveTypesAndHierarchy(generatedEClass, parserRule.getAlternatives());
				}
			}
			catch (TransformationException e) {
				reportError(e);
			}
		}
	}

	private void deriveFeatures() {
		for (AbstractRule rule : grammar.getRules()) {
			try {
				if (rule instanceof ParserRule) {
					this.deriveFeatures((ParserRule) rule);
				}
			}
			catch (TransformationException e) {
				reportError(e);
			}
		}
	}

	private void collectEClassInfosOfSuperGrammar() {
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer();
		transformer.transform(superGrammar);
		this.getEClassifierInfos().addAll(transformer.getEClassifierInfos());
	}

	private Xtext2ECoreInterpretationContext deriveFeatures(Xtext2ECoreInterpretationContext context,
			AbstractElement element) throws TransformationException {
		if (element instanceof Assignment) {
			Assignment assignment = (Assignment) element;
			context.addFeature(assignment);
		}
		else if (element instanceof Alternatives) {
			Alternatives alternatives = (Alternatives) element;
			List<Xtext2ECoreInterpretationContext> contexts = new ArrayList<Xtext2ECoreInterpretationContext>();
			for (AbstractElement group : alternatives.getGroups()) {
				contexts.add(deriveFeatures(context, group));
			}

			if (!GrammarUtil.isOptionalCardinality(alternatives))
				return context.mergeSpawnedContexts(contexts);
		}
		else if (element instanceof Group) {
			Group group = (Group) element;
			return deriveFeatures(context.spawnContextForGroup(), group.getAbstractTokens());
		}
		else if (element instanceof RuleCall && !GrammarUtil.isOptionalCardinality(element)) {
			RuleCall ruleCall = (RuleCall) element;
			AbstractRule calledRule = ruleCall.getRule();
			// do not throw an exception for missing rules, these have been
			// announced during the first iteration
			if (calledRule != null)
				return context.spawnContextWithCalledRule(findOrCreateEClass(calledRule), ruleCall);
		}
		else if (element instanceof Action) {
			Action action = (Action) element;
			TypeRef actionTypeRef = action.getTypeName();
			EClassifierInfo actionType = findOrCreateEClass(actionTypeRef);
			EClassifierInfo currentCompatibleType = context.getCurrentCompatibleType();
			context = context.spawnContextWithReferencedType(actionType, action);
			context.addFeature(action.getFeature(), currentCompatibleType, GrammarUtil.isMultipleAssignment(action),
					true, action);
			return context;
		}

		return context;
	}

	private Xtext2ECoreInterpretationContext deriveFeatures(Xtext2ECoreInterpretationContext context,
			EList<AbstractElement> elements) throws TransformationException {
		for (AbstractElement element : elements) {
			context = deriveFeatures(context, element);
		}
		return context;
	}

	private void deriveFeatures(ParserRule rule) throws TransformationException {
		EClassifierInfo classInfo = findEClass(rule);
		if (classInfo == null)
			throw new TransformationException(ErrorCode.NoSuchTypeAvailable, "No such type available"
					+ GrammarUtil.getReturnTypeName(rule), rule);
		Xtext2ECoreInterpretationContext context = new Xtext2ECoreInterpretationContext(eClassifierInfos, classInfo);
		deriveFeatures(context, rule.getAlternatives());
	}

	private TypeRef getOrFakeReturnType(AbstractRule rule) {
		TypeRef result = rule.getType();
		if (result == null) {
			String returnTypeName = GrammarUtil.getReturnTypeName(rule);
			result = GrammarUtil.getTypeRef(grammar, returnTypeName);
		}
		return result;
	}

	private void normalizeAndValidateGeneratedPackages() {
		TypeHierarchyHelper helper = new TypeHierarchyHelper(this.eClassifierInfos, this.errorAcceptor);
		helper.liftUpFeaturesRecursively();
		helper.removeDuplicateDerivedFeatures();
		helper.detectEClassesWithCyclesInTypeHierachy();
		
		// duplicated features can occur in rare cases when alternatives produce
		// different types of a feature
		// If the internal structure (Set) of the underlying algorithm
		// produces the features for the subtype first the implementation of EClassInfo
		// wont find a conflict
		helper.detectDuplicatedFeatures();
	}

	private void deriveTypesAndHierarchy(EClassifierInfo ruleReturnType, AbstractElement element)
			throws TransformationException {
		if (element instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) element;
			AbstractRule calledRule = ruleCall.getRule();
			if (calledRule == null) // TODO: use NodeAdapter to create error message 
				throw new TransformationException(ErrorCode.NoSuchRuleAvailable, "Cannot find rule "
						+ ruleCall, ruleCall);
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

	private void collectEPackages() {
		// TODO derive alias configuration from supergrammar
		Set<String> usedAliases = new HashSet<String>();

		EList<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
		for (AbstractMetamodelDeclaration metamodelDeclaration : metamodelDeclarations) {
			try {
				String alias = Strings.emptyIfNull(metamodelDeclaration.getAlias());
				if (usedAliases.contains(alias))
					throw new TransformationException(ErrorCode.AliasForMetamodelAlreadyExists, "alias already exists "
							+ alias, metamodelDeclaration);
				usedAliases.add(alias);

				if (metamodelDeclaration instanceof ReferencedMetamodel) {
					// load imported metamodel
					ReferencedMetamodel referencedMetamodel = (ReferencedMetamodel) metamodelDeclaration;
					EPackage referencedEPackage;
					try {
						referencedEPackage = GrammarUtil.loadEPackage(referencedMetamodel);
					}
					catch (RuntimeException e) {
						referencedEPackage = null;
					}

					if (referencedEPackage == null)
						throw new TransformationException(ErrorCode.CannotLoadMetamodel, "Cannot not load metamodel "
								+ referencedMetamodel.getUri(), referencedMetamodel);

					collectClassInfosOf(referencedEPackage, referencedMetamodel);
				}
				else if (metamodelDeclaration instanceof GeneratedMetamodel) {
					// instantiate EPackages for generated metamodel
					GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel) metamodelDeclaration;
					EPackage generatedEPackage = EcoreFactory.eINSTANCE.createEPackage();
					generatedEPackage.setName(generatedMetamodel.getName());
					generatedEPackage.setNsPrefix(generatedMetamodel.getName());
					generatedEPackage.setNsURI(generatedMetamodel.getNsURI());
					generatedEPackages.put(generatedMetamodel.getAlias(), generatedEPackage);
				}

			}
			catch (TransformationException e) {
				reportError(e);
			}
		}
	}

	private void collectClassInfosOf(EPackage referencedEPackage, AbstractMetamodelDeclaration metaModel) {
		for (EClassifier eClassifier : referencedEPackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				EClassifierInfo info = EClassifierInfo.createEClassInfo(eClass, false);
				eClassifierInfos.addInfo(metaModel, eClassifier.getName(), info);
			}
			else if (eClassifier instanceof EDataType) {
				EDataType eDataType = (EDataType) eClassifier;
				EClassifierInfo info = EClassifierInfo.createEDataTypeInfo(eDataType, false);
				eClassifierInfos.addInfo(metaModel, eClassifier.getName(), info);
			}
		}
	}

	private void reportError(ErrorCode errorCode, String message, EObject erroneousElement) {
		errorAcceptor.acceptError(errorCode, message, erroneousElement);
	}

	private void reportError(TransformationException exception) {
		reportError(exception.getErrorCode(), exception.getMessage(), exception.getErroneousElement());
	}

	private EClassifierInfo findOrCreateEClass(AbstractRule rule) throws TransformationException {
		TypeRef typeRef = getOrFakeReturnType(rule);
		return findOrCreateEClass(typeRef);
	}

	private EClassifierInfo findEClass(AbstractRule rule) {
		TypeRef typeRef = getOrFakeReturnType(rule);
		return eClassifierInfos.getInfo(typeRef);
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
		String typeRefName = typeRef.getName();
		AbstractMetamodelDeclaration metaModel = typeRef.getMetamodel();
		if (metaModel == null)
			throw new TransformationException(ErrorCode.UnknownMetaModelAlias,
					"Cannot create type for " + typeRef.getName() + " because its MetaModel is unknown.", typeRef);
		EPackage generatedEPackage = generatedEPackages.get(metaModel.getAlias());
		if (generatedEPackage == null) {
			throw new TransformationException(ErrorCode.CannotCreateTypeInSealedMetamodel,
					"Cannot create type in alias " + typeRef.getMetamodel().getAlias(), typeRef);
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
