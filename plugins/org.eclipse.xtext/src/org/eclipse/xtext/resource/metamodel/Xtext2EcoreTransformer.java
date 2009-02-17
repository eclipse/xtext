/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @author Sebastian Zarnekow
 */
public class Xtext2EcoreTransformer {

	private static final Logger log = Logger.getLogger(Xtext2EcoreTransformer.class);

	private final Grammar grammar;
	private Map<String, EPackage> generatedEPackages;
	private Grammar superGrammar;
	private EClassifierInfos eClassifierInfos;
	private ErrorAcceptor errorAcceptor = new NullErrorAcceptor();

	public Xtext2EcoreTransformer(Grammar grammar) {
		this.grammar = grammar;
	}

	public ErrorAcceptor getErrorAcceptor() {
		return errorAcceptor;
	}

	public void setErrorAcceptor(ErrorAcceptor errorAcceptor) {
		this.errorAcceptor = errorAcceptor;
	}

	public class NullErrorAcceptor implements ErrorAcceptor {
		public void acceptError(TransformationErrorCode errorCode, String arg0, EObject arg1) {
			// do nothing
		}
	}

	public static void doTransform(Grammar grammar) {
		new Xtext2EcoreTransformer(grammar).transform();
	}

	public static List<EPackage> doGetGeneratedPackages(final Grammar grammar) {
		return new Xtext2EcoreTransformer(grammar).getGeneratedPackages();
	}

	public List<EPackage> getGeneratedPackages() {
		final List<EPackage> result = new ArrayList<EPackage>();
		final ResourceSet resourceSet = grammar.eResource().getResourceSet();
		if (resourceSet == null)
			throw new NullPointerException("resourceSet may not be null");
		addAll(result, filter(map(filter(grammar.getMetamodelDeclarations(),
				Filter.Util.<AbstractMetamodelDeclaration> instanceOf(GeneratedMetamodel.class)),
				new Function<AbstractMetamodelDeclaration, EPackage>() {
			public EPackage exec(AbstractMetamodelDeclaration param) {
				return param.getEPackage();
			}
		}), Filter.Util.<EPackage> notNull()));
		return getPackagesSortedByName(result);
	}

	/*
	 * pre-conditions - ensure non-duplicate aliases - ensure all aliases have matching metamodel declarations
	 */
	public void transform() {
		superGrammar = grammar.getSuperGrammar();

		eClassifierInfos = new EClassifierInfos();
		generatedEPackages = new HashMap<String, EPackage>();

		if (superGrammar != null)
			collectEClassInfosOfSuperGrammar();
		collectEPackages();

		if (!deriveTypes())
			return;

		if (!deriveFeatures())
			return;

		normalizeAndValidateGeneratedPackages();
	}

	public void removeGeneratedPackages() {
		final ResourceSet resourceSet = grammar.eResource().getResourceSet();
		final Iterator<Resource> resourceIter = resourceSet.getResources().iterator();
		final Collection<EPackage> packages = getGeneratedPackages();
		// TODO check against grammar
		while (resourceIter.hasNext()) {
			Resource r = resourceIter.next();
			CONTENT: for (EObject content : r.getContents()) {
				if (content instanceof EPackage && packages.contains(content) || generatedEPackages != null && generatedEPackages.containsValue(content)) {
					((EPackage)content).getEClassifiers().clear();
					break CONTENT;
				}
			}
		}
	}

	private static List<EPackage> getPackagesSortedByName(Collection<EPackage> packages) {
		final ArrayList<EPackage> result = new ArrayList<EPackage>(packages);
		Collections.sort(result, new Comparator<EPackage>() {
			public int compare(EPackage o1, EPackage o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return result;
	}

	private boolean deriveTypes() {
		return deriveTypesImpl() && checkDatatypeRules() && deriveTypeHierarchy();
	}

	private boolean deriveTypeHierarchy() {
		boolean result = true;
		for (AbstractRule rule : grammar.getRules()) {
			try {
				EClassifierInfo generatedEClass = findOrCreateEClassifierInfo(rule);
				if (rule instanceof ParserRule) {
					ParserRule parserRule = (ParserRule) rule;
					if (parserRule.getAlternatives() != null) {
						if (!GrammarUtil.isDatatypeRule(parserRule)) {
							deriveTypesAndHierarchy(parserRule, generatedEClass, parserRule.getAlternatives());
						} else {
							checkSupertypeOfOverriddenTerminalRule(rule);
						}
					}
				} else {
					if (rule.getType() != null) {
						checkSupertypeOfOverriddenTerminalRule(rule);
					}
				}
			}
			catch (TransformationException e) {
				reportError(e);
				result = false;
			}
		}
		return result;
	}

	private void checkSupertypeOfOverriddenTerminalRule(AbstractRule rule) throws TransformationException {
		EDataType datatype = (EDataType) rule.getType().getType();
		if (superGrammar != null) {
			AbstractRule parentRule = GrammarUtil.findRuleForName(superGrammar, rule.getName());
			if (parentRule != null) {
				if (parentRule.getType() == null || parentRule.getType().getType() == null)
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot determine return type of overridden rule.", rule.getType());
				if (!datatype.equals(parentRule.getType().getType()))
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot inherit from datatype rule and return another type.", rule.getType());

			}
		}
	}

	private boolean deriveTypesImpl() {
		boolean result = true;
		for (AbstractRule rule : grammar.getRules()) {
			try {
				findOrCreateEClassifierInfo(rule);
			}
			catch (TransformationException e) {
				reportError(e);
				result = false;
			}
		}
		return result;
	}

	private boolean checkDatatypeRules() {
		boolean result = true;
		for (AbstractRule rule : grammar.getRules()) {
			try {
				if (rule instanceof ParserRule && GrammarUtil.isDatatypeRule((ParserRule) rule) && !DatatypeRuleUtil.isValidDatatypeRule((ParserRule) rule)) {
					throw new TransformationException(TransformationErrorCode.InvalidDatatypeRule,
							"Datatype rules may only use other datatype rules, lexer rules and keywords.", rule);
				}
			}
			catch (TransformationException e) {
				reportError(e);
				result = false;
			}
		}
		return result;
	}

	private boolean deriveFeatures() {
		boolean result = true;
		for (AbstractRule rule : grammar.getRules()) {
			try {
				if (rule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) rule)) {
					this.deriveFeatures((ParserRule) rule);
				}
			}
			catch (TransformationException e) {
				result = false;
				reportError(e);
			}
		}
		return result;
	}

	private Xtext2ECoreInterpretationContext deriveFeatures(final Xtext2ECoreInterpretationContext context,
			AbstractElement element) {
		XtextSwitch<Xtext2ECoreInterpretationContext> visitor = new XtextSwitch<Xtext2ECoreInterpretationContext>() {
			@Override
			public Xtext2ECoreInterpretationContext caseAlternatives(Alternatives object) {
				List<Xtext2ECoreInterpretationContext> contexts = new ArrayList<Xtext2ECoreInterpretationContext>();
				for (AbstractElement group : object.getGroups()) {
					contexts.add(deriveFeatures(context, group));
				}
				if (!GrammarUtil.isOptionalCardinality(object))
					return context.mergeSpawnedContexts(contexts);
				return context;
			}

			@Override
			public Xtext2ECoreInterpretationContext caseAssignment(Assignment object) {
				try {
					context.addFeature(object);
				} catch(TransformationException ex) {
					reportError(ex);
				}
				return context;
			}

			@Override
			public Xtext2ECoreInterpretationContext caseGroup(Group object) {
				return deriveFeatures(context.spawnContextForGroup(), object.getAbstractTokens());
			}

			@Override
			public Xtext2ECoreInterpretationContext caseRuleCall(RuleCall object) {
				if (!GrammarUtil.isOptionalCardinality(object)) {
					AbstractRule calledRule = object.getRule();
					// do not throw an exception for missing rules, these have been
					// announced during the first iteration
					if (calledRule != null)
						try {
							return context.spawnContextWithCalledRule(findOrCreateEClassifierInfo(calledRule), object);
						}
						catch (TransformationException e) {
							reportError(e);
						}
				}
				return context;
			}

			@Override
			public Xtext2ECoreInterpretationContext caseAction(Action object) {
				try {
					if (object.getFeature() == null)
						throw new TransformationException(TransformationErrorCode.InvalidFeature, "Name of the feature is not assigned.", object);
					TypeRef actionTypeRef = object.getTypeName();
					EClassifierInfo actionType = findOrCreateEClassifierInfo(actionTypeRef, null, true);
					EClassifierInfo currentCompatibleType = context.getCurrentCompatibleType();
					Xtext2ECoreInterpretationContext ctx = context.spawnContextWithReferencedType(actionType, object);
					ctx.addFeature(object.getFeature(), currentCompatibleType,
							GrammarUtil.isMultipleAssignment(object), true, object);
					return ctx;
				}
				catch (TransformationException e) {
					reportError(e);
				}
				return context;
			}

			@Override
			public Xtext2ECoreInterpretationContext defaultCase(EObject object) {
				return context;
			}
		};
		return visitor.doSwitch(element);
	}

	private Xtext2ECoreInterpretationContext deriveFeatures(Xtext2ECoreInterpretationContext context,
			EList<AbstractElement> elements) {
		Xtext2ECoreInterpretationContext result = context;
		for (AbstractElement element : elements) {
			result = deriveFeatures(result, element);
		}
		return result;
	}

	private void deriveFeatures(ParserRule rule) throws TransformationException {
		EClassifierInfo classInfo = findEClassifierInfo(rule);
		if (classInfo == null)
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "No type available for rule " +
					rule.getName(), rule);
		Xtext2ECoreInterpretationContext context = new Xtext2ECoreInterpretationContext(eClassifierInfos, classInfo);
		if (rule.getAlternatives() != null) // might happen due to syntax errors in the document
			deriveFeatures(context, rule.getAlternatives());
	}

	private TypeRef getOrComputeReturnType(AbstractRule rule) {
		TypeRef result = rule.getType();
		if (result == null) {
			EClassifier classifier = getClassifierFor(rule);
			if (classifier == null) {
				if (rule.getName() == null)
					return null;
				result = getTypeRef(rule.getName());
			} else
				result = getTypeRef(classifier);
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

	EClassifier getClassifierFor(AbstractRule rule) {
		if (rule.getType() != null && rule.getType().getType() != null)
			return rule.getType().getType();
		if (rule instanceof LexerRule || DatatypeRuleUtil.isDatatypeRule((ParserRule) rule) || ((ParserRule)rule).isTerminal()) {
			Grammar checkMe = grammar;
			while(checkMe != null) { // assume EString as default if it is visible
				for(AbstractMetamodelDeclaration decl: checkMe.getMetamodelDeclarations()) {
					if (EcorePackage.eINSTANCE.equals(decl.getEPackage()))
						return EcorePackage.Literals.ESTRING;
				}
				checkMe = checkMe.getSuperGrammar();
			}
		}
		return null;
	}

	TypeRef getTypeRef(EClassifier classifier) {
		TypeRef result = XtextFactory.eINSTANCE.createTypeRef();
		result.setType(classifier);
		EPackage pack = classifier.getEPackage();
		for(AbstractMetamodelDeclaration decl: GrammarUtil.allMetamodelDeclarations(grammar)) {
			if (pack.equals(decl.getEPackage())) {
				result.setMetamodel(decl);
				return result;
			}
		}
		return result;
	}

	TypeRef getTypeRef(String qualifiedName) {
		TypeRef result = XtextFactory.eINSTANCE.createTypeRef();
		String[] split = qualifiedName.split("::");
		String name = qualifiedName;
		if (split.length > 1) {
			result.setMetamodel(GrammarUtil.findMetamodel(grammar, split[0], true));
			name = split[1];
		} else {
			result.setMetamodel(GrammarUtil.findDefaultMetamodel(grammar, true));
		}
		if (result.getMetamodel() instanceof ReferencedMetamodel && result.getMetamodel().getEPackage() != null) {
			result.setType(result.getMetamodel().getEPackage().getEClassifier(name));
		}
		return result;
	}

	private void normalizeAndValidateGeneratedPackages() {
		final TypeHierarchyHelper helper = new TypeHierarchyHelper(grammar, this.eClassifierInfos, this.errorAcceptor);
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

	private void deriveTypesAndHierarchy(final ParserRule rule, final EClassifierInfo ruleReturnType,
			AbstractElement element) throws TransformationException {
		TransformationException ex = new XtextSwitch<TransformationException>() {
			@Override
			public TransformationException caseAction(Action action) {
				final TypeRef actionTypeRef = action.getTypeName();
				try {
					addSuperType(rule, actionTypeRef, ruleReturnType);
					return null;
				}
				catch (TransformationException ex) {
					return ex;
				}
			}

			@Override
			public TransformationException caseAlternatives(Alternatives alternatives) {
				for (AbstractElement ele : alternatives.getGroups()) {
					try {
						deriveTypesAndHierarchy(rule, ruleReturnType, ele);
					}
					catch (TransformationException ex) {
						return ex;
					}
				}
				return null;
			}

			@Override
			public TransformationException caseRuleCall(RuleCall ruleCall) {
				final AbstractRule calledRule = ruleCall.getRule();
				if (calledRule == null) {
					final NodeAdapter adapter = NodeUtil.getNodeAdapter(ruleCall);
					if (adapter != null)
						return new TransformationException(TransformationErrorCode.NoSuchRuleAvailable,
								"Cannot find rule " + adapter.getParserNode().serialize().trim(), ruleCall);

					return new TransformationException(TransformationErrorCode.NoSuchRuleAvailable,
							"Cannot find called rule.", ruleCall);
				}
				final TypeRef calledRuleReturnTypeRef = getOrComputeReturnType(calledRule);
				try {
					addSuperType(rule, calledRuleReturnTypeRef, ruleReturnType);
				}
				catch (TransformationException ex) {
					return ex;
				}
				return null;
			}

			@Override
			public TransformationException caseGroup(Group group) {
				for (AbstractElement ele : group.getAbstractTokens()) {
					try {
						deriveTypesAndHierarchy(rule, ruleReturnType, ele);
					}
					catch (TransformationException ex) {
						return ex;
					}
				}
				return null;
			}

		}.doSwitch(element);
		if (superGrammar != null) {
			AbstractRule parentRule = GrammarUtil.findRuleForName(superGrammar, rule.getName());
			if (parentRule != null) {
				if (parentRule.getType().getType() instanceof EDataType)
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot inherit from datatype rule and return another type.", rule.getType());
				EClassifierInfo parentTypeInfo = eClassifierInfos.getInfoOrNull(parentRule.getType());
				if (parentTypeInfo == null)
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot determine return type of overridden rule.", rule.getType());
				addSuperType(rule, rule.getType(), parentTypeInfo);
			}
		}
		if (ex != null)
			throw ex;
	}

	private void addSuperType(ParserRule rule, TypeRef subTypeRef, EClassifierInfo superTypeInfo) throws TransformationException {
		final EClassifier subType = subTypeRef.getType();
		final EClassifierInfo subTypeInfo = subType == null
		        ? findOrCreateEClassifierInfo(subTypeRef, null, true)
				: eClassifierInfos.getInfoOrNull(subType);
		if (subTypeInfo == null)
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Type '"
					+ superTypeInfo.getEClassifier().getName() + "' is not available.", rule.getType());
		if (superTypeInfo.isAssignableFrom(subTypeInfo))
			return;
		if (subTypeInfo.getEClassifier() instanceof EDataType)
			throw new TransformationException(TransformationErrorCode.InvalidSupertype, "Cannot add supertype '"
					+ superTypeInfo.getEClassifier().getName() + "' to simple datatype '"
					+ subTypeInfo.getEClassifier().getName() + "'.", rule.getType());
		if (!subTypeInfo.isGenerated())
			throw new TransformationException(TransformationErrorCode.CannotCreateTypeInSealedMetamodel,
					"Cannot add supertype '" + superTypeInfo.getEClassifier().getName() + "' to sealed type '"
							+ subTypeInfo.getEClassifier().getName() + "'.", rule.getType());
		subTypeInfo.addSupertype(superTypeInfo);
	}

	private void collectEPackages() {
		// TODO derive alias configuration from supergrammar
		final List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
		final Map<String, GeneratedMetamodel> generateUs = new LinkedHashMap<String, GeneratedMetamodel>();

		for (AbstractMetamodelDeclaration metamodelDeclaration : metamodelDeclarations) {
			try {
				if (metamodelDeclaration instanceof ReferencedMetamodel) {
					// load imported metamodel
					ReferencedMetamodel referencedMetamodel = (ReferencedMetamodel) metamodelDeclaration;
					EPackage referencedEPackage = referencedMetamodel.getEPackage();
					if (referencedEPackage != null)
						collectClassInfosOf(referencedEPackage, referencedMetamodel);
				}
				else if (metamodelDeclaration instanceof GeneratedMetamodel) {
					String alias = Strings.emptyIfNull(metamodelDeclaration.getAlias());
					if (generateUs.containsKey(alias)) {
						GeneratedMetamodel prev = generateUs.get(alias);
						if (prev != null) {
							if (prev.getEPackage() != null) {
								prev.getEPackage().eResource().getResourceSet().getResources().remove(prev.getEPackage().eResource());
							}
							prev.setEPackage(null);
						}
						generateUs.put(alias, null);
						EPackage pack = metamodelDeclaration.getEPackage();
						if (pack != null)
							pack.eResource().getResourceSet().getResources().remove(pack.eResource());
						metamodelDeclaration.setEPackage(null);
						throw new TransformationException(TransformationErrorCode.AliasForMetamodelAlreadyExists, "Alias '" + alias
								+ "' registered more than once.", metamodelDeclaration);
					}
					generateUs.put(alias, (GeneratedMetamodel) metamodelDeclaration);
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

	private void collectEClassInfosOfSuperGrammar() {
		this.getEClassifierInfos().setParent(createClassifierInfosFor(grammar.getSuperGrammar()));
	}

	private EClassifierInfos createClassifierInfosFor(Grammar grammar) {
		if (grammar == null)
			return null;
		EClassifierInfos result = new EClassifierInfos();
		for(AbstractMetamodelDeclaration declaration: grammar.getMetamodelDeclarations()) {
			EPackage referencedEPackage = declaration.getEPackage();
			if (referencedEPackage != null) {
				collectClassInfosOf(result, referencedEPackage, declaration, false);
			}
		}
		result.setParent(createClassifierInfosFor(grammar.getSuperGrammar()));
		return result;
	}

	private void collectClassInfosOf(EPackage referencedEPackage, AbstractMetamodelDeclaration metaModel) {
		collectClassInfosOf(eClassifierInfos, referencedEPackage,
				metaModel, metaModel instanceof GeneratedMetamodel);
	}

	private void collectClassInfosOf(EClassifierInfos target, EPackage referencedEPackage,
			AbstractMetamodelDeclaration metaModel, boolean generated) {
		for (EClassifier eClassifier : referencedEPackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				EClassifierInfo info = EClassifierInfo.createEClassInfo(eClass, generated);
				target.addInfo(metaModel, eClassifier.getName(), info);
			}
			else if (eClassifier instanceof EDataType) {
				EDataType eDataType = (EDataType) eClassifier;
				// TODO: Enums
				EClassifierInfo info = EClassifierInfo.createEDataTypeInfo(eDataType, generated);
				target.addInfo(metaModel, eClassifier.getName(), info);
			}
		}
	}

	private void reportError(TransformationErrorCode errorCode, String message, EObject erroneousElement) {
		errorAcceptor.acceptError(errorCode, message, erroneousElement);
	}

	private void reportError(TransformationException exception) {
		log.trace(exception.getErrorCode(), exception);
		reportError(exception.getErrorCode(), exception.getMessage(), exception.getErroneousElement());
	}

	private EClassifierInfo findOrCreateEClassifierInfo(AbstractRule rule) throws TransformationException {
		final TypeRef typeRef = getOrComputeReturnType(rule);
		if (typeRef == null)
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Cannot create type for unnamed rule.", rule);
		if (typeRef.getMetamodel() != null && typeRef.getMetamodel().getEPackage() == null)
			throw new TransformationException(TransformationErrorCode.UnknownMetaModelAlias, "Cannot create type without declared package.", typeRef);
		return findOrCreateEClassifierInfo(typeRef, rule.getName(), grammar.getRules().contains(rule));
	}

	private EClassifierInfo findEClassifierInfo(AbstractRule rule) {
		final TypeRef typeRef = getOrComputeReturnType(rule);
		if (typeRef == null)
			throw new NullPointerException();
		if (rule.getType() != typeRef)
			throw new IllegalStateException();
		return eClassifierInfos.getInfo(typeRef);
	}

	private EClassifierInfo findOrCreateEClassifierInfo(TypeRef typeRef, String name, boolean createIfMissing) throws TransformationException {
		EClassifierInfo info = eClassifierInfos.getInfo(typeRef);
		if (info == null) {
			// we assumend EString for lexer rules and datatype rules, so
			// we have to do a look up in super grammar
			if (typeRef.getType() == EcorePackage.Literals.ESTRING) {
				info = eClassifierInfos.getInfoOrNull(typeRef);
				if (info != null)
					return info;
			}
			if (createIfMissing)
				info = createEClassifierInfo(typeRef, name);
		}
		return info;
	}

	private EClassifierInfo createEClassifierInfo(TypeRef typeRef, String name) throws TransformationException {
		if (eClassifierInfos.getInfo(typeRef) != null)
			throw new IllegalArgumentException("Cannot create EClass for same type twice "
					+ typeRef.getType().getName());
		//					+ GrammarUtil.getQualifiedName(typeRef));

		String classifierName = null;
		classifierName = GrammarUtil.getTypeRefName(typeRef);
		if (classifierName == null)
			classifierName = name;
		if (classifierName == null)
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Cannot reference unnamed type.", typeRef);

		AbstractMetamodelDeclaration metaModel = typeRef.getMetamodel();
		if (metaModel == null)
			throw new TransformationException(TransformationErrorCode.UnknownMetaModelAlias, "Cannot create type for " + classifierName
					+ " because its MetaModel is unknown.", typeRef);
		EPackage generatedEPackage = getGeneratedEPackage(metaModel);
		if (generatedEPackage == null) {
			throw new TransformationException(TransformationErrorCode.CannotCreateTypeInSealedMetamodel,
					"Cannot create type '" + classifierName + "' in alias " + typeRef.getMetamodel().getAlias(), typeRef);
		}

		EClassifier classifier = generatedEPackage.getEClassifier(classifierName);
		if (classifier == null) {
			classifier = EcoreFactory.eINSTANCE.createEClass();
			classifier.setName(classifierName);
			generatedEPackage.getEClassifiers().add(classifier);
			typeRef.setType(classifier);

			EClassifierInfo result;
			// TODO: Enums?
			if (classifier instanceof EClass)
				result = EClassifierInfo.createEClassInfo((EClass) classifier, true);
			else
				result = EClassifierInfo.createEDataTypeInfo((EDataType) classifier, true);

			if (!eClassifierInfos.addInfo(typeRef, result))
				throw new IllegalStateException("cannot add type for typeRef twice: '" + classifierName + "'");
			return result;
		}
		typeRef.setType(classifier);
		return eClassifierInfos.getInfo(classifier);
	}

	private void addGeneratedEPackage(GeneratedMetamodel generatedMetamodel) throws TransformationException {
		// we do not allow the same alias twice for generated metamodels
		String alias = Strings.emptyIfNull(generatedMetamodel.getAlias());
		if (generatedEPackages.containsKey(alias))
			throw new TransformationException(TransformationErrorCode.AliasForMetamodelAlreadyExists, "alias '" + alias
					+ "' already exists", generatedMetamodel);

		if (generatedMetamodel.getEPackage() == null)
			throw new TransformationException(TransformationErrorCode.UnknownMetaModelAlias, "Cannot create EPackage without NsURI.", generatedMetamodel);

		// instantiate EPackages for generated metamodel
		EPackage generatedEPackage = generatedMetamodel.getEPackage();
		generatedEPackages.put(alias, generatedEPackage);
		collectClassInfosOf(generatedEPackage, generatedMetamodel);
	}

	private EPackage getGeneratedEPackage(AbstractMetamodelDeclaration metaModel) {
		if (metaModel instanceof GeneratedMetamodel)
			return metaModel.getEPackage();
		return null;
	}

	public EClassifierInfos getEClassifierInfos() {
		return eClassifierInfos;
	}

}
