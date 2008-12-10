/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import static org.eclipse.xtext.util.CollectionUtils.addAll;
import static org.eclipse.xtext.util.CollectionUtils.filter;
import static org.eclipse.xtext.util.CollectionUtils.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
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
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.Function;
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

	public static void doTransform(Grammar grammar) {
		new Xtext2EcoreTransformer().transform(grammar);
	}

	public static List<EPackage> doGetGeneratedPackages(final Grammar grammar) {
		return new Xtext2EcoreTransformer().getGeneratedPackages(grammar);
	}

	public List<EPackage> getGeneratedPackages(final Grammar grammar) {
		final List<EPackage> result = new ArrayList<EPackage>();
		final ResourceSet resourceSet = grammar.eResource().getResourceSet();
		if (resourceSet == null)
			throw new NullPointerException();
		addAll(result, filter(map(filter(grammar.getMetamodelDeclarations(), Filter.Util
				.<AbstractMetamodelDeclaration> instanceOf(GeneratedMetamodel.class)),
				new Function<AbstractMetamodelDeclaration, EPackage>() {
					public EPackage exec(AbstractMetamodelDeclaration param) {
						IDeclaredMetamodelAccess metamodelAccess = DeclaredMetamodelAccessFactory.getAccessTo(param);
						return metamodelAccess.getPackage();
					}
				}), Filter.Util.<EPackage> notNull()));
		return getPackagesSortedByName(result);
	}

	/*
	 * pre-conditions - ensure non-duplicate aliases - ensure all aliases have matching metamodel declarations
	 */
	public void transform(Grammar grammar) {
		this.grammar = grammar;
		removeGeneratedPackages();
		eClassifierInfos = new EClassifierInfos();
		generatedEPackages = new HashMap<String, EPackage>();
		superGrammar = GrammarUtil.getSuperGrammar(grammar);

		if (superGrammar != null)
			collectEClassInfosOfSuperGrammar();
		collectEPackages();

		deriveTypes();
		deriveFeatures();
		normalizeAndValidateGeneratedPackages();
	}

	private void removeGeneratedPackages() {
		final ResourceSet resourceSet = grammar.eResource().getResourceSet();
		final Iterator<Resource> resourceIter = resourceSet.getResources().iterator();
		final Collection<EPackage> packages = getGeneratedPackages(grammar);
		// TODO check against grammar
		while (resourceIter.hasNext()) {
			Resource r = resourceIter.next();
			CONTENT: for (EObject content : r.getContents()) {
				if (content instanceof EPackage && packages.contains(content)) {
					resourceIter.remove();
					break CONTENT;
				}
			}
		}
	}

	private static List<EPackage> getPackagesSortedByName(Collection<EPackage> packages) {
		ArrayList<EPackage> result = new ArrayList<EPackage>(packages);
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
				findOrCreateEClassifierInfo(rule);
			}
			catch (TransformationException e) {
				reportError(e);
			}
		}
		for (AbstractRule rule : grammar.getRules()) {
			try {
				EClassifierInfo generatedEClass = findOrCreateEClassifierInfo(rule);
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
				return context.spawnContextWithCalledRule(findOrCreateEClassifierInfo(calledRule), ruleCall);
		}
		else if (element instanceof Action) {
			Action action = (Action) element;
			TypeRef actionTypeRef = action.getTypeName();
			EClassifierInfo actionType = findOrCreateEClassifierInfo(actionTypeRef, null);
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
		EClassifierInfo classInfo = findEClassifierInfo(rule);
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
			if (result.getMetamodel() == null) {
				AbstractMetamodelDeclaration bestMatch = null;
				for (AbstractMetamodelDeclaration decl : grammar.getMetamodelDeclarations()) {
					if (decl instanceof GeneratedMetamodel) {
						if (bestMatch == null)
							bestMatch = decl;
						else if (Strings.isEmpty(decl.getAlias())) {
							result.setMetamodel(decl);
							break;
						}
						else {
							bestMatch = null;
							break;
						}
					}
				}
				if (result.getMetamodel() == null)
					result.setMetamodel(bestMatch);
			}
			rule.setType(result);
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
				throw new TransformationException(ErrorCode.NoSuchRuleAvailable, "Cannot find rule " + ruleCall,
						ruleCall);
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
		EClassifierInfo calledRuleReturnType = findOrCreateEClassifierInfo(subTypeRef, null);
		calledRuleReturnType.addSupertype(superType);
	}

	private void collectEPackages() {
		// TODO derive alias configuration from supergrammar
		final List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
		final Map<String, GeneratedMetamodel> generateUs = new HashMap<String, GeneratedMetamodel>();

		for (AbstractMetamodelDeclaration metamodelDeclaration : metamodelDeclarations) {
			try {
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
					String alias = Strings.emptyIfNull(metamodelDeclaration.getAlias());
					if (generateUs.containsKey(alias)) {
						generateUs.put(alias, null);
						throw new TransformationException(ErrorCode.AliasForMetamodelAlreadyExists, "Alias '" + alias
								+ "' registered more than once.", metamodelDeclaration);
					}
					else {
						generateUs.put(alias, (GeneratedMetamodel) metamodelDeclaration);
					}
				}
				else
					throw new IllegalStateException("unknown metamodelDeclaraton " + metamodelDeclaration);

			}
			catch (TransformationException e) {
				reportError(e);
			}
		}
		for (GeneratedMetamodel metamodel : generateUs.values()) {
			try {
				if (metamodel != null)
					addGeneratedEPackage(metamodel);
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
			// TODO: Enums
		}
	}

	private void reportError(ErrorCode errorCode, String message, EObject erroneousElement) {
		errorAcceptor.acceptError(errorCode, message, erroneousElement);
	}

	private void reportError(TransformationException exception) {
		reportError(exception.getErrorCode(), exception.getMessage(), exception.getErroneousElement());
	}

	private EClassifierInfo findOrCreateEClassifierInfo(AbstractRule rule) throws TransformationException {
		TypeRef typeRef = getOrFakeReturnType(rule);
		return findOrCreateEClassifierInfo(typeRef, rule.getName());
	}

	private EClassifierInfo findEClassifierInfo(AbstractRule rule) {
		TypeRef typeRef = getOrFakeReturnType(rule);
		if (typeRef == null)
			throw new NullPointerException();
		if (rule.getType() != typeRef)
			throw new IllegalStateException();
		return eClassifierInfos.getInfo(typeRef);
	}

	private EClassifierInfo findOrCreateEClassifierInfo(TypeRef typeRef, String name) throws TransformationException {
		EClassifierInfo info = eClassifierInfos.getInfo(typeRef);
		if (info == null) {
			info = createEClassifierInfo(typeRef, name);
		}
		return info;
	}

	private EClassifierInfo createEClassifierInfo(TypeRef typeRef, String name) throws TransformationException {
		if (eClassifierInfos.getInfo(typeRef) != null)
			throw new IllegalArgumentException("Cannot create EClass for same type twice "
					+ typeRef.getType().getName());
		//					+ GrammarUtil.getQualifiedName(typeRef));

		String typeRefName = null;
		//		typeRefName = typeRef.getName();
		typeRefName = GrammarUtil.getTypeRefName(typeRef);
		if (typeRefName == null)
			typeRefName = name;
		if (typeRefName == null)
			throw new NullPointerException("typeRefName may not be null");

		AbstractMetamodelDeclaration metaModel = typeRef.getMetamodel();
		if (metaModel == null)
			throw new TransformationException(ErrorCode.UnknownMetaModelAlias, "Cannot create type for " + typeRefName
					+ " because its MetaModel is unknown.", typeRef);
		EPackage generatedEPackage = getGeneratedEPackage(metaModel);
		if (generatedEPackage == null) {
			throw new TransformationException(ErrorCode.CannotCreateTypeInSealedMetamodel,
					"Cannot create type in alias " + typeRef.getMetamodel().getAlias(), typeRef);
		}

		EClassifier generatedEClass = generatedEPackage.getEClassifier(typeRefName);
		if (generatedEClass == null) {
			generatedEClass = EcoreFactory.eINSTANCE.createEClass();
			generatedEClass.setName(typeRefName);
			generatedEPackage.getEClassifiers().add(generatedEClass);
		}
		typeRef.setType(generatedEClass);

		EClassifierInfo result;
		// TODO: Enums?
		if (generatedEClass instanceof EClass)
			result = EClassifierInfo.createEClassInfo((EClass) generatedEClass, true);
		else
			result = EClassifierInfo.createEDataTypeInfo((EDataType) generatedEClass, true);

		if (!eClassifierInfos.addInfo(typeRef, result))
			throw new IllegalStateException();
		return result;
	}

	private void addGeneratedEPackage(GeneratedMetamodel generatedMetamodel) throws TransformationException {
		// we do not allow the same alias twice for generated metamodels
		String alias = Strings.emptyIfNull(generatedMetamodel.getAlias());
		if (generatedEPackages.containsKey(alias))
			throw new TransformationException(ErrorCode.AliasForMetamodelAlreadyExists, "alias '" + alias
					+ "' already exists", generatedMetamodel);

		// instantiate EPackages for generated metamodel
		EPackage generatedEPackage = EcoreFactory.eINSTANCE.createEPackage();
		generatedEPackage.setName(generatedMetamodel.getName());
		generatedEPackage.setNsPrefix(generatedMetamodel.getName());
		generatedEPackage.setNsURI(generatedMetamodel.getNsURI());
		Resource generatedPackageResource = new XMIResourceFactoryImpl().createResource(URI
				.createURI(generatedMetamodel.getNsURI()));
		grammar.eResource().getResourceSet().getResources().add(generatedPackageResource);
		generatedPackageResource.getContents().add(generatedEPackage);
		generatedEPackages.put(alias, generatedEPackage);
	}

	private EPackage getGeneratedEPackage(AbstractMetamodelDeclaration metaModel) {
		return generatedEPackages.get(Strings.emptyIfNull(metaModel.getAlias()));
	}

	public EClassifierInfos getEClassifierInfos() {
		return eClassifierInfos;
	}

}
