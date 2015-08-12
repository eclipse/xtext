/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xtext.GrammarResource;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * @author Sebastian Zarnekow
 */
public class Xtext2EcoreTransformer {

	private static final Logger log = Logger.getLogger(Xtext2EcoreTransformer.class);

	private final Grammar grammar;
	private Map<String, EPackage> generatedEPackages;
	private EClassifierInfos eClassifierInfos;
	private ErrorAcceptor errorAcceptor = new NullErrorAcceptor();
	private IXtext2EcorePostProcessor postProcessor;

	public Xtext2EcoreTransformer(Grammar grammar) {
		this.grammar = grammar;
	}

	public ErrorAcceptor getErrorAcceptor() {
		return errorAcceptor;
	}

	public void setErrorAcceptor(ErrorAcceptor errorAcceptor) {
		this.errorAcceptor = errorAcceptor;
	}

	public static class NullErrorAcceptor implements ErrorAcceptor {
		@Override
		public void acceptError(TransformationErrorCode errorCode, String arg0, EObject arg1) {
			// do nothing
		}
	}

	public void setPostProcessor(IXtext2EcorePostProcessor postProcessor) {
		this.postProcessor = postProcessor;
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
		Iterables.addAll(result, Iterables.filter(Iterables.transform(
				Iterables.filter(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class),
				new Function<AbstractMetamodelDeclaration, EPackage>() {
					@Override
					public EPackage apply(AbstractMetamodelDeclaration param) {
						EPackage pack = (EPackage) param.eGet(XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE, false);
						if (pack != null && !pack.eIsProxy()) {
							return pack;
						}
						return null;
					}
				}), Predicates.notNull()));
		return getPackagesSortedByName(result);
	}

	/*
	 * pre-conditions - ensure non-duplicate aliases - ensure all aliases have matching metamodel declarations
	 */
	public void transform() {
		eClassifierInfos = new EClassifierInfos(grammar);
		generatedEPackages = Maps.newLinkedHashMap();

		collectEClassInfosOfUsedGrammars();
		collectEPackages();

		if (!deriveTypes())
			return;

		if (!deriveFeatures())
			return;

		normalizeAndValidateGeneratedPackages();

		postProcessGeneratedPackages();
	}

	public void removeGeneratedPackages() {
		final ResourceSet resourceSet = grammar.eResource().getResourceSet();
		final List<Resource> resources = resourceSet.getResources();
		final Collection<EPackage> packages = getGeneratedPackages();
		for(int i = 0; i < resources.size(); i++) {
			Resource r = resources.get(i);
			if (!(r instanceof GrammarResource)) {
				CONTENT: for (EObject content : r.getContents()) {
					if (content instanceof EPackage && packages.contains(content) || generatedEPackages != null && generatedEPackages.containsValue(content)) {
						clearPackage(r, (EPackage) content);
						break CONTENT;
					}
				}
			}
		}
	}
	
	protected void clearPackage(Resource resource, EPackage pack) {
		Map<InternalEObject, URI> uris = Maps.newHashMap();
		for(EClassifier classifier: pack.getEClassifiers()) {
			InternalEObject internalEObject = (InternalEObject) classifier;
			URI appendFragment = resource.getURI().appendFragment(resource.getURIFragment(internalEObject));
			uris.put(internalEObject, appendFragment);
		}
		pack.getEClassifiers().clear();
		for (Map.Entry<InternalEObject, URI> entry : uris.entrySet()) {
			entry.getKey().eSetProxyURI(entry.getValue());
		}
	}

	private static List<EPackage> getPackagesSortedByName(Collection<EPackage> packages) {
		final ArrayList<EPackage> result = new ArrayList<EPackage>(packages);
		Collections.sort(result, new Comparator<EPackage>() {
			@Override
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
				if (generatedEClass != null || !isWildcardFragment(rule)) {
					if (rule instanceof ParserRule) {
						ParserRule parserRule = (ParserRule) rule;
						if (parserRule.getAlternatives() != null) {
							if (!GrammarUtil.isDatatypeRule(parserRule)) {
								deriveTypesAndHierarchy(parserRule, generatedEClass, parserRule.getAlternatives());
							} else {
								checkSupertypeOfOverriddenDatatypeRule(rule);
							}
						}
					} else if (rule instanceof TerminalRule) {
						if (rule.getType() != null) {
							if (!(rule.getType().getClassifier() instanceof EDataType))
								throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable,
										"Return type of a terminal rule must be an EDataType.", rule.getType());
							checkSupertypeOfOverriddenDatatypeRule(rule);
						}
					} else if (rule instanceof EnumRule) {
						if (rule.getType() != null) {
							if (!(rule.getType().getClassifier() instanceof EEnum))
								throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable,
										"Return type of an enum rule must be an EEnum.", rule.getType());
							checkSupertypeOfOverriddenDatatypeRule(rule);
						}
					} else {
						throw new IllegalStateException("Unknown rule type: " + rule.eClass().getName());
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

	private void checkSupertypeOfOverriddenDatatypeRule(AbstractRule rule) throws TransformationException {
		EDataType datatype = (EDataType) rule.getType().getClassifier();
		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			AbstractRule parentRule = GrammarUtil.findRuleForName(usedGrammar, rule.getName());
			if (parentRule != null && parentRule != rule) {
				if (parentRule.getType() == null || parentRule.getType().getClassifier() == null)
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot determine return type of overridden rule.", rule.getType());
				if (!datatype.equals(parentRule.getType().getClassifier())) {
					String ruleName = getRuleNameForErrorMessage(parentRule);
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot inherit from " + ruleName + "rule and return another type.", rule.getType());
				}
				if (parentRule.eClass() != rule.eClass()) {
					if (parentRule instanceof EnumRule || parentRule instanceof ParserRule) {
						if (rule instanceof TerminalRule && ((TerminalRule) rule).isFragment()) {
							throw new TransformationException(TransformationErrorCode.NoSuchRuleAvailable,
									"A terminal fragment cannot override enum rule " + rule.getName() + ".", rule);	
						}
					} else if (parentRule instanceof TerminalRule) {
						String ruleName = getRuleNameForErrorMessage(rule);
						throw new TransformationException(TransformationErrorCode.NoSuchRuleAvailable,
								"A " + ruleName + " rule cannot override a terminal rule.", rule);
					}
				}
				if (rule instanceof TerminalRule && parentRule instanceof TerminalRule) {
					TerminalRule terminal = (TerminalRule) rule;
					if (terminal.isFragment() && !((TerminalRule) parentRule).isFragment()) {
						String message = "Terminal fragment cannot inherit from terminal rule '" + parentRule.getName() + "'";
						throw new TransformationException(TransformationErrorCode.NoSuchRuleAvailable, message, rule);
					}
				}
				return;
			}
		}
	}

	protected String getRuleNameForErrorMessage(AbstractRule rule) {
		String ruleName = "datatype ";
		if (rule instanceof TerminalRule)
			ruleName = "terminal ";
		else if (rule instanceof EnumRule)
			ruleName = "enum ";
		return ruleName;
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
				if (rule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) rule) && !isWildcardFragment(rule)) {
					deriveFeatures((ParserRule) rule);
				} else if (rule instanceof EnumRule) {
					deriveEnums((EnumRule) rule);
				}
			}
			catch (TransformationException e) {
				result = false;
				reportError(e);
			}
		}
		return result;
	}

	private void deriveEnums(EnumRule rule) {
		EEnum returnType = (EEnum) rule.getType().getClassifier();
		if (returnType != null) {
			List<EnumLiteralDeclaration> decls = EcoreUtil2.getAllContentsOfType(rule, EnumLiteralDeclaration.class);
			for(EnumLiteralDeclaration decl : decls) {
				if (decl.getEnumLiteral() == null) {
					List<INode> nodes = NodeModelUtils.findNodesForFeature(decl, XtextPackage.Literals.ENUM_LITERAL_DECLARATION__ENUM_LITERAL);
					if (!nodes.isEmpty()) {
						if (nodes.size() > 1)
							throw new IllegalStateException("Unexpected nodes found: " + nodes);
						INode node = nodes.get(0);
						String text = node.getText();
						EEnumLiteral literal = null;
						if (rule.getType().getMetamodel() instanceof ReferencedMetamodel) {
							literal = returnType.getEEnumLiteral(text);
						} else {
							EEnumLiteral existing = returnType.getEEnumLiteral(text);
							if (existing == null) {
								literal = EcoreFactory.eINSTANCE.createEEnumLiteral();
								int index = returnType.getELiterals().size();
								returnType.getELiterals().add(literal);
								literal.setName(text);
								literal.setValue(index);
								if (decl.getLiteral() != null) {
									literal.setLiteral(decl.getLiteral().getValue());
								} else {
									literal.setLiteral(text);
								}
							} else {
								literal = existing;
							}
							SourceAdapter.adapt(literal, decl);
						}
						if (literal == null) {
							reportError(new TransformationException(TransformationErrorCode.InvalidFeature, "Enum literal '" + text + "' does not exist.", decl));
						} else {
							decl.setEnumLiteral(literal);
						}
					}
				}
				if (decl.getLiteral() == null && decl.getEnumLiteral() != null) {
					Keyword kw = XtextFactory.eINSTANCE.createKeyword();
					kw.setValue(decl.getEnumLiteral().getLiteral());
					decl.setLiteral(kw);
				}
			}
		}
	}

	private Xtext2EcoreInterpretationContext deriveFeatures(final Xtext2EcoreInterpretationContext context,
			AbstractElement element) {
		XtextSwitch<Xtext2EcoreInterpretationContext> visitor = new XtextSwitch<Xtext2EcoreInterpretationContext>() {
			
			/*
			 * Used for Alternatives and UnorderedGroups
			 */
			@Override
			public Xtext2EcoreInterpretationContext caseCompoundElement(CompoundElement object) {
				List<Xtext2EcoreInterpretationContext> contexts = new ArrayList<Xtext2EcoreInterpretationContext>();
				for (AbstractElement group : object.getElements()) {
					contexts.add(deriveFeatures(context, group));
				}
				Xtext2EcoreInterpretationContext result = context;
				if (!contexts.isEmpty()) {
					if (GrammarUtil.isOptionalCardinality(object)) {
						contexts.add(0, result);
					} else {
						result = contexts.get(0);
					}
					result = result.mergeSpawnedContexts(contexts);
				}
				return result;
			}
			
			@Override
			public Xtext2EcoreInterpretationContext caseAssignment(Assignment object) {
				try {
					context.addFeature(object);
				} catch(TransformationException ex) {
					reportError(ex);
				}
				return context;
			}

			@Override
			public Xtext2EcoreInterpretationContext caseGroup(Group object) {
				return visitElements(object, object.getElements());
			}

			private Xtext2EcoreInterpretationContext visitElements(AbstractElement caller, List<AbstractElement> elementsToProcess) {
				Xtext2EcoreInterpretationContext result = deriveFeatures(context.spawnContextForGroup(), elementsToProcess);
				if (GrammarUtil.isMultipleCardinality(caller)) {
					result = deriveFeatures(result.spawnContextForGroup(), elementsToProcess);
				}
				if (GrammarUtil.isOptionalCardinality(caller)) {
					result = result.mergeSpawnedContexts(Arrays.asList(context, result));
				}
				return result;
			}
			
			@Override
			public Xtext2EcoreInterpretationContext caseAlternatives(Alternatives object) {
				List<Xtext2EcoreInterpretationContext> contexts = newArrayList();
				if (GrammarUtil.isOptionalCardinality(object)) {
					contexts.add(context);
				}
				for (AbstractElement alternative : object.getElements()) {
					contexts.add(deriveFeatures(context.spawnContextForGroup(), alternative));
				}
				Xtext2EcoreInterpretationContext result = context.mergeSpawnedContexts(contexts);
				if (GrammarUtil.isMultipleCardinality(object)) {
					for (AbstractElement alternative : object.getElements()) {
						deriveFeatures(result.spawnContextForGroup(), alternative);
					}
				}
				return result;
			}
			
			@Override
			public Xtext2EcoreInterpretationContext caseRuleCall(RuleCall object) {
				AbstractRule calledRule = object.getRule();
				if (isWildcardFragment(calledRule)) {
					return visitElements(object, Collections.singletonList(calledRule.getAlternatives()));
				}
				if (isParserRuleFragment(calledRule)) {
					return context;
				}
				if (!GrammarUtil.isOptionalCardinality(object)) {
					// do not throw an exception for missing rules, these have been
					// announced during the first iteration
					if (calledRule != null && calledRule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) calledRule)) {
						try {
							EClassifierInfo eClassifierInfo = findOrCreateEClassifierInfo(calledRule);
							return context.spawnContextWithCalledRule(eClassifierInfo, object);
						}
						catch (TransformationException e) {
							reportError(e);
						}
					}
				}
				return context;
			}

			@Override
			public Xtext2EcoreInterpretationContext caseAction(Action object) {
				try {
					TypeRef actionTypeRef = object.getType();
					EClassifierInfo actionType = findOrCreateEClassifierInfo(actionTypeRef, null, true);
					EClassifierInfo currentCompatibleType = context.getCurrentCompatibleType();
					Xtext2EcoreInterpretationContext ctx = context.spawnContextWithReferencedType(actionType, object);
					if (object.getFeature() != null) {
						ctx.addFeature(object.getFeature(), currentCompatibleType,
								GrammarUtil.isMultipleAssignment(object), true, object);
					}
					return ctx;
				}
				catch (TransformationException e) {
					reportError(e);
				}
				return context;
			}
			
			@Override
			public Xtext2EcoreInterpretationContext defaultCase(EObject object) {
				return context;
			}
		};
		return visitor.doSwitch(element);
	}

	private Xtext2EcoreInterpretationContext deriveFeatures(Xtext2EcoreInterpretationContext context,
			List<AbstractElement> elements) {
		Xtext2EcoreInterpretationContext result = context;
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
		Xtext2EcoreInterpretationContext context = new Xtext2EcoreInterpretationContext(eClassifierInfos, classInfo);
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
					if (decl instanceof GeneratedMetamodel && Strings.isEmpty(decl.getAlias())) {
						bestMatch = decl;
						break;
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
		if (rule.getType() != null && rule.getType().getClassifier() != null)
			return rule.getType().getClassifier();
		if (rule instanceof TerminalRule || rule instanceof ParserRule && DatatypeRuleUtil.isDatatypeRule((ParserRule) rule)) {
			return GrammarUtil.findEString(grammar);
		}
		return null;
	}

	TypeRef getTypeRef(EClassifier classifier) {
		TypeRef result = XtextFactory.eINSTANCE.createTypeRef();
		result.setClassifier(classifier);
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
			result.setMetamodel(findMetamodel(grammar, split[0], split[1]));
			name = split[1];
		} else {
			result.setMetamodel(findDefaultMetamodel(grammar, qualifiedName));
		}
		if (result.getMetamodel() instanceof ReferencedMetamodel && result.getMetamodel().getEPackage() != null) {
			result.setClassifier(result.getMetamodel().getEPackage().getEClassifier(name));
		}
		return result;
	}

	public AbstractMetamodelDeclaration findDefaultMetamodel(Grammar grammar, String containedClassifier) {
		return findMetamodel(grammar, "", containedClassifier);
	}

	public AbstractMetamodelDeclaration findMetamodel(Grammar grammar, String alias, String containedClassifier) {
		final List<AbstractMetamodelDeclaration> declarations = grammar.getMetamodelDeclarations();
		AbstractMetamodelDeclaration result = null;
		for (AbstractMetamodelDeclaration decl : declarations) {
			if (isSameAlias(decl.getAlias(), alias)) {
				EPackage pack = decl.getEPackage();
				if (pack != null && pack.getEClassifier(containedClassifier) != null) {
					if (result != null)
						return null;
					result = decl;
				}
			}
		}
		return result;
	}

	public boolean isSameAlias(String alias, String alias2) {
		return Strings.isEmpty(alias) ? Strings.isEmpty(alias2) : alias.equals(alias2);
	}

	private void normalizeAndValidateGeneratedPackages() {
		final TypeHierarchyHelper helper = new TypeHierarchyHelper(grammar, this.eClassifierInfos, this.errorAcceptor);
		helper.liftUpFeaturesRecursively();
		helper.removeDuplicateDerivedFeatures();
	}

	private void deriveTypesAndHierarchy(final ParserRule rule, final EClassifierInfo ruleReturnType,
			AbstractElement element) throws TransformationException {
		TransformationException ex = new XtextSwitch<TransformationException>() {
			
			Set<AbstractRule> visiting = Sets.newHashSet();
			
			@Override
			public TransformationException caseAction(Action action) {
				final TypeRef actionTypeRef = action.getType();
				try {
					addSuperType(rule, actionTypeRef, ruleReturnType);
					return null;
				}
				catch (TransformationException ex) {
					return ex;
				}
			}
			
			@Override
			public TransformationException caseCompoundElement(CompoundElement object) {
				for (AbstractElement ele : object.getElements()) {
					TransformationException ex = doSwitch(ele);
					if (ex != null) {
						return ex;
					}
				}
				return null;
			}

			@Override
			public TransformationException caseRuleCall(RuleCall ruleCall) {
				final AbstractRule calledRule = ruleCall.getRule();
				if (calledRule == null) {
					ICompositeNode node = NodeModelUtils.getNode(ruleCall);
					if (node != null)
						return new TransformationException(TransformationErrorCode.NoSuchRuleAvailable,
								"Cannot find rule " + node.getText().trim(), ruleCall);

					return new TransformationException(TransformationErrorCode.NoSuchRuleAvailable,
							"Cannot find called rule.", ruleCall);
				}
				if (calledRule instanceof TerminalRule ||
						calledRule instanceof ParserRule && (GrammarUtil.isDatatypeRule((ParserRule) calledRule))
						|| isWildcardFragment(calledRule))
					return null;
				if (calledRule instanceof EnumRule) {
					return new TransformationException(TransformationErrorCode.NoSuchRuleAvailable,
							"Cannot call enum rule without assignment.", ruleCall);
				}
				try {
					if (isParserRuleFragment(calledRule)) {
						TypeRef subTypeRef = getOrComputeReturnType(rule);
						addSuperType(rule, subTypeRef, findOrCreateEClassifierInfo(calledRule));
						if (visiting.add(calledRule)) {
							try {
								AbstractElement fragment = calledRule.getAlternatives();
								doSwitch(fragment);
							} finally {
								visiting.remove(calledRule);
							}
						}
					} else {
						final TypeRef calledRuleReturnTypeRef = getOrComputeReturnType(calledRule);
						addSuperType(rule, calledRuleReturnTypeRef, ruleReturnType);
					}
				} catch (TransformationException ex) {
					return ex;
				}
				return null;
			}
			
			@Override
			public TransformationException defaultCase(EObject object) {
				// ignore
				return null;
			}

		}.doSwitch(element);
		if (ex != null)
			throw ex;
		for (Grammar usedGrammar: grammar.getUsedGrammars()) {
			if (deriveTypeHierarchyFromOverridden(rule, usedGrammar))
				return;
		}

	}

	private boolean deriveTypeHierarchyFromOverridden(ParserRule rule, Grammar grammar) throws TransformationException {
		AbstractRule parentRule = GrammarUtil.findRuleForName(grammar, rule.getName());
		if (parentRule != null) {
			if (parentRule != rule && parentRule instanceof ParserRule) {
				ParserRule casted = (ParserRule) parentRule;
				if (casted.isFragment() != rule.isFragment()) {
					if (rule.isFragment()) {
						throw new TransformationException(TransformationErrorCode.InvalidFragmentOverride,
								"A fragment rule cannot override a production rule.", rule);
					} else {
						throw new TransformationException(TransformationErrorCode.InvalidFragmentOverride,
								"Only fragment rule can override other fragment rules.", rule);
					}
				}
				if (casted.isWildcard() != rule.isWildcard()) {
					if (rule.isWildcard()) {
						throw new TransformationException(TransformationErrorCode.InvalidFragmentOverride,
								"A wildcard fragment rule cannot override a typed fragment rule.", rule);
					} else {
						throw new TransformationException(TransformationErrorCode.InvalidFragmentOverride,
								"Only wildcard fragment rules can override other wildcard fragments.", rule);
					}
				}
				if (rule.isFragment() && !rule.isWildcard() && parentRule.getType() != null) {
					if (rule.getType().getClassifier() != parentRule.getType().getClassifier()) {
						throw new TransformationException(TransformationErrorCode.InvalidFragmentOverride,
								"Overriding fragment rules cannot redeclare their type.", rule.getType());
					}
				}
				checkParameterLists(rule, casted);
			}
			if (parentRule.getType() != null && parentRule != rule) {			
				if (parentRule.getType().getClassifier() instanceof EDataType)
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot inherit from datatype rule and return another type.", rule.getType());
				EClassifierInfo parentTypeInfo = eClassifierInfos.getInfoOrNull(parentRule.getType());
				if (parentTypeInfo == null)
					throw new TransformationException(TransformationErrorCode.InvalidSupertype,
							"Cannot determine return type of overridden rule.", rule.getType());
				addSuperType(rule, rule.getType(), parentTypeInfo);
				return true;
			}
		}
		return false;
	}

	private void checkParameterLists(ParserRule rule, ParserRule overridden) throws TransformationException {
		int inherited = overridden.getParameters().size();
		if (inherited == rule.getParameters().size()) {
			boolean ok = true;
			for(int i = 0; ok && i < inherited; i++) {
				if (!Strings.equal(rule.getParameters().get(i).getName(), overridden.getParameters().get(i).getName())) {
					ok = false;
				}
			}
			if (ok) {
				return;
			}
		}
		if (inherited == 0) {
			throw new TransformationException(TransformationErrorCode.InvalidRuleOverride,
					"Overridden rule " + rule.getName() + " does not declare any parameters", rule);
		}
		StringBuilder message = new StringBuilder("Parameter list is incompatible with inherited ");
		message.append(rule.getName()).append("[");
		for(int i = 0; i < overridden.getParameters().size(); i++) {
			if (i != 0) {
				message.append(", ");
			}
			message.append(overridden.getParameters().get(i).getName());
		}
		message.append("]");
		throw new TransformationException(TransformationErrorCode.InvalidRuleOverride,
				message.toString(), rule);
	}

	private void addSuperType(ParserRule rule, TypeRef subTypeRef, EClassifierInfo superTypeInfo) throws TransformationException {
		final EClassifier subType = subTypeRef.getClassifier();
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
		final List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
		final Map<String, GeneratedMetamodel> generateUs = Maps.newLinkedHashMap();

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

	private void collectEClassInfosOfUsedGrammars() {
		Set<Grammar> visitedGrammars = Sets.newLinkedHashSet();
		visitedGrammars.add(grammar);
		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			EClassifierInfos parent = createClassifierInfosFor(usedGrammar, visitedGrammars);
			if (parent != null)
				this.getEClassifierInfos().addParent(parent);
		}

	}

	private EClassifierInfos createClassifierInfosFor(Grammar grammar, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return null;
		final EClassifierInfos result = new EClassifierInfos(grammar);
		for(AbstractMetamodelDeclaration declaration: grammar.getMetamodelDeclarations()) {
			final EPackage referencedEPackage = declaration.getEPackage();
			if (referencedEPackage != null) {
				collectClassInfosOf(result, referencedEPackage, declaration, false);
			}
		}
		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			EClassifierInfos parent = createClassifierInfosFor(usedGrammar, visitedGrammars);
			if (parent != null)
				result.addParent(parent);
		}
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
				EClassifierInfo info = EClassifierInfo.createEClassInfo(eClass, generated, getGeneratedEPackageURIs(), GrammarUtil.getGrammar(metaModel));
				target.addInfo(metaModel, eClassifier.getName(), info);
			}
			else if (eClassifier instanceof EDataType) {
				EDataType eDataType = (EDataType) eClassifier;
				EClassifierInfo info = EClassifierInfo.createEDataTypeInfo(eDataType, generated);
				target.addInfo(metaModel, eClassifier.getName(), info);
			}
		}
	}

	private Set<String> getGeneratedEPackageURIs() {
		List<GeneratedMetamodel> list = EcoreUtil2.typeSelect(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
		return Sets.newLinkedHashSet(Iterables.transform(list, new Function<GeneratedMetamodel, String>() {
			@Override
			public String apply(GeneratedMetamodel from) {
				return from.getEPackage()!=null?from.getEPackage().getNsURI() : null;
			}
		}));
	}

	private void reportError(TransformationErrorCode errorCode, String message, EObject erroneousElement) {
		errorAcceptor.acceptError(errorCode, message, erroneousElement);
	}

	private void reportError(TransformationException exception) {
		log.trace(exception.getErrorCode(), exception);
		reportError(exception.getErrorCode(), exception.getMessage(), exception.getErroneousElement());
	}

	private EClassifierInfo findOrCreateEClassifierInfo(AbstractRule rule) throws TransformationException {
		if (isWildcardFragment(rule)) {
			return null;
		}
		final TypeRef typeRef = getOrComputeReturnType(rule);
		if (typeRef == null) {
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Cannot create type for unnamed rule.", rule);
		}
		if (typeRef.getMetamodel() != null && typeRef.getMetamodel().getEPackage() == null)
			throw new TransformationException(TransformationErrorCode.UnknownMetaModelAlias, "Cannot create type without declared package.", typeRef);
		return findOrCreateEClassifierInfo(typeRef, rule.getName(), grammar.getRules().contains(rule));
	}

	private boolean isWildcardFragment(AbstractRule rule) {
		if (rule instanceof ParserRule) {
			ParserRule casted = (ParserRule) rule;
			return casted.isFragment() && casted.isWildcard();
		}
		return false;
	}
	
	private boolean isParserRuleFragment(AbstractRule rule) {
		if (rule instanceof ParserRule) {
			ParserRule casted = (ParserRule) rule;
			return casted.isFragment() && !casted.isWildcard();
		}
		return false;
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
		if (typeRef.getClassifier() != null && typeRef.getMetamodel() == null)
			throw new TransformationException(TransformationErrorCode.UnknownMetaModelAlias,
					"Cannot find metamodel for type '" + typeRef.getClassifier().getName() + "'", typeRef);
		EClassifierInfo info = eClassifierInfos.getInfo(typeRef);
		if (info == null) {
			// we assumend EString for terminal rules and datatype rules, so
			// we have to do a look up in super grammar
			EDataType dataType = GrammarUtil.findEString(GrammarUtil.getGrammar(typeRef));
			if (dataType != null && typeRef.getClassifier() == dataType) {
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
					+ typeRef.getClassifier().getName());
		//					+ GrammarUtil.getQualifiedName(typeRef));

		String classifierName = GrammarUtil.getTypeRefName(typeRef);
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
			if (GrammarUtil.containingParserRule(typeRef) != null)
				classifier = EcoreFactory.eINSTANCE.createEClass();
			else if (GrammarUtil.containingEnumRule(typeRef) != null)
				classifier = EcoreFactory.eINSTANCE.createEEnum();
			else
				throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Cannot create datatype " + classifierName, typeRef);
			classifier.setName(classifierName);
			generatedEPackage.getEClassifiers().add(classifier);
			typeRef.setClassifier(classifier);

			EClassifierInfo result;
			if (classifier instanceof EClass)
				result = EClassifierInfo.createEClassInfo((EClass) classifier, true, getGeneratedEPackageURIs(), GrammarUtil.getGrammar(typeRef));
			else // datatype or enum
				result = EClassifierInfo.createEDataTypeInfo((EDataType) classifier, true);

			if (!eClassifierInfos.addInfo(typeRef, result))
				throw new IllegalStateException("cannot add type for typeRef twice: '" + classifierName + "'");
			SourceAdapter.adapt(classifier, typeRef);
			return result;
		}
		typeRef.setClassifier(classifier);
		SourceAdapter.adapt(classifier, typeRef);
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

	private void postProcessGeneratedPackages() {
		if (postProcessor != null) {
			final Iterable<GeneratedMetamodel> generatedMetamodels = Iterables.filter(grammar
					.getMetamodelDeclarations(), GeneratedMetamodel.class);
			for (GeneratedMetamodel metamodel : generatedMetamodels) {
				postProcessor.process(metamodel);
			}
		}
	}

	public EClassifierInfos getEClassifierInfos() {
		return eClassifierInfos;
	}

}
