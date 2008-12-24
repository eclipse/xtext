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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
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
	
	private Grammar grammar;
	private Map<String, EPackage> generatedEPackages;
	private Grammar superGrammar;
	private EClassifierInfos eClassifierInfos;
	private ErrorAcceptor errorAcceptor = new NullErrorAcceptor();
	private boolean superGrammarFailed;

	public Xtext2EcoreTransformer(Grammar grammar) {
		this.grammar = grammar;
		try {
			superGrammar = GrammarUtil.getSuperGrammar(grammar);
		} catch(Exception e) {
			superGrammarFailed = true;
		}
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
			throw new NullPointerException();
		addAll(result, filter(map(filter(grammar.getMetamodelDeclarations(), 
				Filter.Util.<AbstractMetamodelDeclaration> instanceOf(GeneratedMetamodel.class)),
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
	public void transform() {
		if (superGrammarFailed) {
			// TODO should not highlight the whole grammar
			errorAcceptor.acceptError(null, "Could not resolve super grammar", grammar);
		}
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
		if (superGrammar != null) {
			final Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(superGrammar);
			transformer.removeGeneratedPackages();
		}
		
		final ResourceSet resourceSet = grammar.eResource().getResourceSet();
		final Iterator<Resource> resourceIter = resourceSet.getResources().iterator();
		final Collection<EPackage> packages = getGeneratedPackages();
		// TODO check against grammar
		while (resourceIter.hasNext()) {
			Resource r = resourceIter.next();
			CONTENT: for (EObject content : r.getContents()) {
				if (content instanceof EPackage && packages.contains(content) || generatedEPackages != null && generatedEPackages.containsValue(content)) {
					resourceIter.remove();
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
		boolean result = true;
		for (AbstractRule rule : grammar.getRules()) {
			try {
				findOrCreateEClassifierInfo(rule);
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
		if (result) {
			for (AbstractRule rule : grammar.getRules()) {
				try {
					EClassifierInfo generatedEClass = findOrCreateEClassifierInfo(rule);
					if (rule instanceof ParserRule) {
						ParserRule parserRule = (ParserRule) rule;
						if (!GrammarUtil.isDatatypeRule(parserRule)) {
							deriveTypesAndHierarchy(parserRule, generatedEClass, parserRule.getAlternatives());
						}
					}
				}
				catch (TransformationException e) {
					reportError(e);
					result = false;
				}
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

	private void collectEClassInfosOfSuperGrammar() {
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(superGrammar);
		transformer.transform();
		this.getEClassifierInfos().setParent(transformer.getEClassifierInfos());
	}

	private Xtext2ECoreInterpretationContext deriveFeatures(final Xtext2ECoreInterpretationContext context,
			AbstractElement element) throws TransformationException {
		XtextSwitch<Xtext2ECoreInterpretationContext> visitor = new XtextSwitch<Xtext2ECoreInterpretationContext>() {
			@Override
			public Xtext2ECoreInterpretationContext caseAlternatives(Alternatives object) {
				try {
					List<Xtext2ECoreInterpretationContext> contexts = new ArrayList<Xtext2ECoreInterpretationContext>();
					for (AbstractElement group : object.getGroups()) {
						contexts.add(deriveFeatures(context, group));
					}
					if (!GrammarUtil.isOptionalCardinality(object))
						return context.mergeSpawnedContexts(contexts);
				} catch(TransformationException ex) {
					reportError(ex);
				}
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
				try {
					return deriveFeatures(context.spawnContextForGroup(), object.getAbstractTokens());
				}
				catch (TransformationException e) {
					reportError(e);
					return context;
				}
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
					EClassifierInfo actionType = findOrCreateEClassifierInfo(actionTypeRef, null);
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
			EList<AbstractElement> elements) throws TransformationException {
		for (AbstractElement element : elements) {
			context = deriveFeatures(context, element);
		}
		return context;
	}

	private void deriveFeatures(ParserRule rule) throws TransformationException {
		EClassifierInfo classInfo = findEClassifierInfo(rule);
		if (classInfo == null)
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "No type available for rule " +
					rule.getName(), rule);
		Xtext2ECoreInterpretationContext context = new Xtext2ECoreInterpretationContext(eClassifierInfos, classInfo);
		if (rule.getAlternatives() != null) // might happen due to syntax errors
			deriveFeatures(context, rule.getAlternatives());
	}

	private TypeRef getOrComputeReturnType(AbstractRule rule) {
		TypeRef result = rule.getType();
		if (result == null) {
			EClassifier classifier = getClassifierFor(rule);
			if (classifier == null)
				result = getTypeRef(rule.getName());
			else
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
		if (rule instanceof LexerRule || DatatypeRuleUtil.isDatatypeRule((ParserRule) rule)) {
			return EcorePackage.Literals.ESTRING;
		}
		return null;
	}
	
	TypeRef getTypeRef(EClassifier classifier) {
		TypeRef result = XtextFactory.eINSTANCE.createTypeRef();
		result.setType(classifier);
		EPackage pack = classifier.getEPackage();
		String packNsURI = pack.getNsURI();
		for(AbstractMetamodelDeclaration decl: GrammarUtil.allMetamodelDeclarations(grammar)) {
			String nsURI = decl instanceof ReferencedMetamodel ? ((ReferencedMetamodel) decl).getUri() : ((GeneratedMetamodel) decl).getNsURI();
			if (packNsURI.equals(nsURI)) {
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
			result.setMetamodel(GrammarUtil.findMetaModel(grammar, split[0], true));
			name = split[1];
		} else {
			result.setMetamodel(GrammarUtil.findDefaultMetaModel(grammar, true));
		}
		if (result.getMetamodel() instanceof ReferencedMetamodel) {
			IDeclaredMetamodelAccess metamodelAccess = DeclaredMetamodelAccessFactory.getAccessTo(result.getMetamodel());
			result.setType(metamodelAccess.getEClassifier(name));
		}
		return result;
	}

	private void normalizeAndValidateGeneratedPackages() {
		TypeHierarchyHelper helper = new TypeHierarchyHelper(grammar, this.eClassifierInfos, this.errorAcceptor);
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

	private void deriveTypesAndHierarchy(ParserRule rule, EClassifierInfo ruleReturnType, AbstractElement element)
			throws TransformationException {
		if (element instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) element;
			AbstractRule calledRule = ruleCall.getRule();
			if (calledRule == null) {
				NodeAdapter adapter = NodeUtil.getNodeAdapter(ruleCall);
				if (adapter != null)
					throw new TransformationException(
							TransformationErrorCode.NoSuchRuleAvailable, "Cannot find rule " + 
							adapter.getParserNode().serialize().trim(), ruleCall);
				else
					throw new TransformationException(
							TransformationErrorCode.NoSuchRuleAvailable, "Cannot find called rule.", ruleCall);
			}
			TypeRef calledRuleReturnTypeRef = getOrComputeReturnType(calledRule);
			addSuperType(rule, calledRuleReturnTypeRef, ruleReturnType);
		}
		else if (element instanceof Action) {
			Action action = (Action) element;
			TypeRef actionTypeRef = action.getTypeName();
			addSuperType(rule, actionTypeRef, ruleReturnType);
		}
		else if (element instanceof Group) {
			Group group = (Group) element;
			for (AbstractElement ele : group.getAbstractTokens()) {
				deriveTypesAndHierarchy(rule, ruleReturnType, ele);
			}
		}
		else if (element instanceof Alternatives) {
			Alternatives alternatives = (Alternatives) element;
			for (AbstractElement ele : alternatives.getGroups()) {
				deriveTypesAndHierarchy(rule, ruleReturnType, ele);
			}
		}
	}

	private void addSuperType(ParserRule rule, TypeRef subTypeRef, EClassifierInfo superType) throws TransformationException {
		EClassifierInfo calledRuleReturnType = findOrCreateEClassifierInfo(subTypeRef, null);
		if (calledRuleReturnType.getEClassifier() instanceof EDataType)
			throw new TransformationException(TransformationErrorCode.InvalidSupertype, 
					"Cannot add supertype '"
					+ superType.getEClassifier().getName() + "' to simple datatype '"
					+ calledRuleReturnType.getEClassifier().getName() + "'.", rule.getType());
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
					IDeclaredMetamodelAccess access = DeclaredMetamodelAccessFactory.getAccessTo(referencedMetamodel);
					EPackage referencedEPackage = access.getPackage();
					if (referencedEPackage == null)
						throw new TransformationException(TransformationErrorCode.CannotLoadMetamodel, "Cannot not load metamodel "
								+ referencedMetamodel.getUri(), referencedMetamodel);

					collectClassInfosOf(referencedEPackage, referencedMetamodel);
				}
				else if (metamodelDeclaration instanceof GeneratedMetamodel) {
					String alias = Strings.emptyIfNull(metamodelDeclaration.getAlias());
					if (generateUs.containsKey(alias)) {
						generateUs.put(alias, null);
						throw new TransformationException(TransformationErrorCode.AliasForMetamodelAlreadyExists, "Alias '" + alias
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

	private void reportError(TransformationErrorCode errorCode, String message, EObject erroneousElement) {
		errorAcceptor.acceptError(errorCode, message, erroneousElement);
	}

	private void reportError(TransformationException exception) {
		log.trace(exception.getErrorCode(), exception);
		reportError(exception.getErrorCode(), exception.getMessage(), exception.getErroneousElement());
	}

	private EClassifierInfo findOrCreateEClassifierInfo(AbstractRule rule) throws TransformationException {
		TypeRef typeRef = getOrComputeReturnType(rule);
		return findOrCreateEClassifierInfo(typeRef, rule.getName());
	}

	private EClassifierInfo findEClassifierInfo(AbstractRule rule) {
		TypeRef typeRef = getOrComputeReturnType(rule);
		if (typeRef == null)
			throw new NullPointerException();
		if (rule.getType() != typeRef)
			throw new IllegalStateException();
		return eClassifierInfos.getInfo(typeRef);
	}

	private EClassifierInfo findOrCreateEClassifierInfo(TypeRef typeRef, String name) throws TransformationException {
		EClassifierInfo info = eClassifierInfos.getInfo(typeRef);
		if (info == null) {
			// we assumend EString for lexer rules and datatype rules, so
			// we have to do a look up in super grammar
			if (typeRef.getType() == EcorePackage.Literals.ESTRING) {
				EClassifierInfos parent = eClassifierInfos.getParent();
				while(parent != null && info == null) {
					info = parent.getInfo(typeRef);
					parent = parent.getParent();
				}
				if (info != null)
					return info;
			}
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
		} else {
			typeRef.setType(classifier);
			return eClassifierInfos.getInfo(classifier);
		}
	}

	private void addGeneratedEPackage(GeneratedMetamodel generatedMetamodel) throws TransformationException {
		// we do not allow the same alias twice for generated metamodels
		String alias = Strings.emptyIfNull(generatedMetamodel.getAlias());
		if (generatedEPackages.containsKey(alias))
			throw new TransformationException(TransformationErrorCode.AliasForMetamodelAlreadyExists, "alias '" + alias
					+ "' already exists", generatedMetamodel);

		if (generatedMetamodel.getNsURI() == null)
			throw new TransformationException(TransformationErrorCode.UnknownMetaModelAlias, "Cannot create EPackage without NsURI.", generatedMetamodel);
		
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
