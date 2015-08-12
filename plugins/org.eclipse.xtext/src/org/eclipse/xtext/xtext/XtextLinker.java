/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducerDecorator;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ecoreInference.TransformationDiagnosticsProducer;
import org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformer;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinker extends Linker {

	private static Logger log = Logger.getLogger(XtextLinker.class);

	@Inject
	private IScopeProvider scopeProvider;

	@Inject(optional = true)
	private IXtext2EcorePostProcessor postProcessor;

	@Inject(optional = true)
	private IReferableElementsUnloader unloader;
	
	@Inject
	private OnChangeEvictingCache cache;

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	public IXtext2EcorePostProcessor getPostProcessor() {
		return postProcessor;
	}

	public void setPostProcessor(IXtext2EcorePostProcessor postProcessor) {
		this.postProcessor = postProcessor;
	}

	@Override
	protected IDiagnosticProducer createDiagnosticProducer(final IDiagnosticConsumer consumer) {
		return new AbstractDiagnosticProducerDecorator(super.createDiagnosticProducer(consumer)) {
			private boolean filter = false;

			@Override
			public void addDiagnostic(DiagnosticMessage message) {
				if (!filter)
					super.addDiagnostic(message);
			}

			@Override
			public void setTarget(EObject object, EStructuralFeature feature) {
				super.setTarget(object, feature);
				// we don't want to mark generated types as errors unless generation fails
				filter = isTypeRef(object, feature) || isGeneratedPackage(object, feature)
						|| isEnumLiteral(object, feature);
			}

			private boolean isEnumLiteral(EObject object, EStructuralFeature feature) {
				if (feature == XtextPackage.eINSTANCE.getEnumLiteralDeclaration_EnumLiteral()) {
					EnumRule rule = GrammarUtil.containingEnumRule(object);
					return rule.getType() == null || rule.getType().getClassifier() == null;
				}
				return false;
			}

			private boolean isGeneratedPackage(EObject object, EStructuralFeature feature) {
				return (feature == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage() && (object instanceof GeneratedMetamodel));
			}

			private boolean isTypeRef(EObject object, EStructuralFeature feature) {
				return (feature == XtextPackage.eINSTANCE.getTypeRef_Classifier() && ((TypeRef) object).getMetamodel() instanceof GeneratedMetamodel);
			}

		};
	}

	@Override
	protected boolean canSetDefaultValues(EReference ref) {
		return super.canSetDefaultValues(ref)
				|| ref == XtextPackage.Literals.CROSS_REFERENCE__TERMINAL;
	}

	@Override
	protected void setDefaultValueImpl(EObject obj, EReference ref, IDiagnosticProducer producer) {
		if (XtextPackage.eINSTANCE.getTypeRef_Metamodel() == ref) {
			final TypeRef typeRef = (TypeRef) obj;
			final String typeRefName = GrammarUtil.getTypeRefName(typeRef);
			final List<EObject> metamodels = XtextMetamodelReferenceHelper.findBestMetamodelForType(typeRef, "",
					typeRefName, scopeProvider.getScope(typeRef, ref));
			if (metamodels.isEmpty() || metamodels.size() > 1)
				producer.addDiagnostic(new DiagnosticMessage("Cannot find meta model for type '" + typeRefName + "'", Severity.ERROR, null));
			else
				typeRef.setMetamodel((AbstractMetamodelDeclaration) metamodels.get(0));
		} else if (XtextPackage.eINSTANCE.getCrossReference_Terminal() == ref) {
			AbstractRule rule = GrammarUtil.findRuleForName(GrammarUtil.getGrammar(obj), "ID");
			if (rule == null)
				producer.addDiagnostic(new DiagnosticMessage("Cannot resolve implicit reference to rule 'ID'", Severity.ERROR, null));
			else {
				RuleCall call = XtextFactory.eINSTANCE.createRuleCall();
				call.setRule(rule);
				((CrossReference) obj).setTerminal(call);
			}
		} else if (XtextPackage.eINSTANCE.getNamedArgument_Parameter() == ref) {
			final NamedArgument argument = (NamedArgument) obj;
			if (!argument.isCalledByName()) {
				RuleCall ruleCall = EcoreUtil2.getContainerOfType(argument, RuleCall.class);
				AbstractRule calledRule = ruleCall.getRule();
				if (calledRule instanceof ParserRule && !calledRule.eIsProxy()) {
					ParserRule casted = (ParserRule) calledRule;
					int idx = ruleCall.getArguments().indexOf(argument);
					if (idx < casted.getParameters().size()) {
						argument.setParameter(casted.getParameters().get(idx));
						return;
					}
				}
			}
		} else {
			super.setDefaultValueImpl(obj, ref, producer);
		}
	}

	@Override
	protected void beforeEnsureIsLinked(EObject obj, EReference ref, IDiagnosticProducer producer) {
		if (XtextPackage.eINSTANCE.getTypeRef_Classifier() == ref) {
			final TypeRef typeRef = (TypeRef) obj;
			if (typeRef.getMetamodel() == null)
				setDefaultValue(obj, XtextPackage.eINSTANCE.getTypeRef_Metamodel(), producer);
		} else
			super.beforeEnsureIsLinked(obj, ref, producer);
	}

	protected Xtext2EcoreTransformer createTransformer(Grammar grammar, IDiagnosticConsumer consumer) {
		final Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
		transformer.setErrorAcceptor(new TransformationDiagnosticsProducer(consumer));
		transformer.setPostProcessor(postProcessor);
		return transformer;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void beforeModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		discardGeneratedPackages(model);
		clearAllReferences(model);
		super.beforeModelLinked(model, diagnosticsConsumer);
		cache.getOrCreate(model.eResource()).ignoreNotifications();
	}
	
	@Override
	protected boolean isClearAllReferencesRequired(Resource resource) {
		return false;
	}

	void discardGeneratedPackages(EObject root) {
		if (root instanceof Grammar) {
			// unload generated metamodels as they will be recreated during linking 
			for (AbstractMetamodelDeclaration metamodelDeclaration : ((Grammar) root).getMetamodelDeclarations()) {
				if (metamodelDeclaration instanceof GeneratedMetamodel) {
					EPackage ePackage = (EPackage) metamodelDeclaration.eGet(XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE, false);
					if (ePackage != null && !ePackage.eIsProxy()) {
						Resource resource = ePackage.eResource();
						if (resource != null && resource.getResourceSet() != null) {
							if (unloader != null) {
								for (EObject content : resource.getContents()) {
									unloader.unloadRoot(content);
								}
							}
							resource.getResourceSet().getResources().remove(resource);
						}
					}
				}
			}
		}
	}
	
	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		super.afterModelLinked(model, diagnosticsConsumer);
		cache.getOrCreate(model.eResource()).listenToNotifications();
	}

	@Override
	public void linkModel(EObject model, IDiagnosticConsumer consumer) {
		if (model instanceof Grammar) {
			final Xtext2EcoreTransformer transformer = createTransformer((Grammar) model, consumer);
			//TODO duplicate
			transformer.removeGeneratedPackages();
			super.linkModel(model, consumer);
			updateOverriddenRules((Grammar) model);
			try {
				transformer.transform();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				consumer.consume(new ExceptionDiagnostic(e), Severity.ERROR);
			}
			if (!model.eResource().eAdapters().contains(packageRemover))
				model.eResource().eAdapters().add(packageRemover);
		} else {
			super.linkModel(model, consumer);
		}
	}

	@Inject
	private PackageRemover packageRemover;

	public static class PackageRemover extends EContentAdapter {

		@Inject
		private IReferableElementsUnloader unloader;

		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if (!msg.isTouch() && msg.getOldValue() != null) {
				ResourceSet set;
				Resource notifyingResource;
				if (!(msg.getNotifier() instanceof Resource)) {
					Object feature = msg.getFeature();
					if (!(feature instanceof EReference))
						return;
					EReference ref = (EReference) feature;
					if (!ref.isContainment())
						return;
					notifyingResource = ((EObject) msg.getNotifier()).eResource();
				} else {
					notifyingResource = ((Resource) msg.getNotifier());
				}
				if (notifyingResource == null)
					return;
				set = notifyingResource.getResourceSet();
				if (set == null)
					return;
				switch (msg.getEventType()) {
					case Notification.REMOVE_MANY:
					case Notification.REMOVE:
					case Notification.SET:
						Object oldValue = msg.getOldValue();
						Collection<Resource> resourcesToRemove = Sets.newHashSet();
						Collection<Resource> resourcesToUnload = Sets.newHashSet();
						Collection<Resource> referencedResources = Sets.newHashSet(notifyingResource);
						if (oldValue instanceof Grammar) {
							processMetamodelDeclarations(((Grammar) oldValue).getMetamodelDeclarations(), set, resourcesToRemove,
									resourcesToUnload, referencedResources);
						} else if (oldValue instanceof AbstractMetamodelDeclaration) {
							processMetamodelDeclarations(Collections
									.singletonList((AbstractMetamodelDeclaration) oldValue), set, resourcesToRemove, resourcesToUnload, referencedResources);
						} else if (oldValue instanceof Collection<?>) {
							if (XtextPackage.Literals.GRAMMAR__METAMODEL_DECLARATIONS == msg.getFeature()) {
								Collection<AbstractMetamodelDeclaration> metamodelDeclarations = (Collection<AbstractMetamodelDeclaration>) oldValue;
								processMetamodelDeclarations(metamodelDeclarations, set, resourcesToRemove, resourcesToUnload, referencedResources);
							}
						}
						resourcesToRemove.removeAll(referencedResources);
						if (unloader != null) {
							resourcesToUnload.removeAll(referencedResources);
							for (Resource resource : resourcesToUnload) {
								if(resource.getResourceSet() == set) {
									for (EObject content : resource.getContents())
										unloader.unloadRoot(content);
								}
							}
						}
						set.getResources().removeAll(resourcesToRemove);
						break;
					default:
						break;
				}
			}
		}

		private void processMetamodelDeclarations(Collection<AbstractMetamodelDeclaration> declarations, ResourceSet resourceSet,
				Collection<Resource> resourcesToRemove, Collection<Resource> resourcesToUnload,
				Collection<Resource> referencedResources) {
			for (AbstractMetamodelDeclaration declaration : declarations) {
				EPackage pack = (EPackage) declaration.eGet(XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE, false);
				if (pack != null && !pack.eIsProxy()) {
					Resource packResource = pack.eResource();
					if (packResource != null) {
						resourcesToRemove.add(packResource);
						if (declaration instanceof ReferencedMetamodel) {
								resourcesToUnload.add(packResource);
						}
						if (isPackageReferenced(resourceSet, pack, declarations)) {
							referencedResources.add(packResource);
						}
					}
				}
			}
		}

		public boolean isPackageReferenced(ResourceSet set, EPackage pack,
				Collection<AbstractMetamodelDeclaration> knownReferences) {
			for (int i = 0; i < set.getResources().size(); i++) { 
				// cannot use foreach since we may get
				// a CME due to proxy resolution and transparent
				// loading of resources
				Resource resource = set.getResources().get(i);
				if (resource != null) {
					for (EObject content : resource.getContents()) {
						if (content instanceof Grammar) {
							for (AbstractMetamodelDeclaration decl : ((Grammar) content).getMetamodelDeclarations()) {
								if (pack.equals(decl.getEPackage()) && !knownReferences.contains(decl))
									return true;
							}
						}
					}
				}
			}
			return false;
		}

		public void setUnloader(IReferableElementsUnloader unloader) {
			this.unloader = unloader;
		}

		public IReferableElementsUnloader getUnloader() {
			return unloader;
		}
	}

	protected void updateOverriddenRules(Grammar grammar) {
		if (grammar.getUsedGrammars().isEmpty())
			return;
		Map<String, AbstractRule> rulePerName = new HashMap<String, AbstractRule>(grammar.getRules().size());
		for (AbstractRule rule : grammar.getRules())
			rulePerName.put(rule.getName(), rule);
		Set<Grammar> visitedGrammars = new HashSet<Grammar>();
		visitedGrammars.add(grammar);
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			updateOverriddenRules(usedGrammar, rulePerName, visitedGrammars);
		}
	}

	protected void updateOverriddenRules(Grammar grammar, Map<String, AbstractRule> rulePerName,
			Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return;
		updateOverriddenRules(grammar, rulePerName);
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			updateOverriddenRules(usedGrammar, rulePerName, visitedGrammars);
		}
	}

	protected void updateOverriddenRules(Grammar grammar, Map<String, AbstractRule> rulePerName) {
		if (grammar.isDefinesHiddenTokens()) {
			updateHiddenTokens(grammar.getHiddenTokens(), rulePerName);
		}
		for (AbstractRule rule : grammar.getRules()) {
			if (rule instanceof ParserRule && ((ParserRule) rule).isDefinesHiddenTokens()) {
				updateHiddenTokens(((ParserRule) rule).getHiddenTokens(), rulePerName);
			}
		}
		final List<RuleCall> allRuleCalls = EcoreUtil2.getAllContentsOfType(grammar, RuleCall.class);
		for (RuleCall call : allRuleCalls) {
			if (call.getRule() != null && !call.isExplicitlyCalled()) {
				AbstractRule rule = rulePerName.get(call.getRule().getName());
				if (rule != null)
					call.setRule(rule);
			}
		}
	}

	private void updateHiddenTokens(List<AbstractRule> hiddenTokens, Map<String, AbstractRule> rulePerName) {
		for (int i = 0; i < hiddenTokens.size(); i++) {
			AbstractRule hidden = hiddenTokens.get(i);
			AbstractRule overridden = rulePerName.get(hidden.getName());
			if (overridden != null)
				hiddenTokens.set(i, overridden);
		}
	}

	/**
	 * We add typeRefs without Nodes on the fly, so we should remove them before relinking.
	 */
	@Override
	protected void clearReference(EObject obj, EReference ref) {
		super.clearReference(obj, ref);
		if (obj.eIsSet(ref) && ref.getEType().equals(XtextPackage.Literals.TYPE_REF)) {
			INode node = NodeModelUtils.getNode((EObject) obj.eGet(ref));
			if (node == null)
				obj.eUnset(ref);
		}
		if (obj.eIsSet(ref) && ref == XtextPackage.Literals.CROSS_REFERENCE__TERMINAL) {
			INode node = NodeModelUtils.getNode((EObject) obj.eGet(ref));
			if (node == null)
				obj.eUnset(ref);
		}
		if (ref == XtextPackage.Literals.RULE_CALL__RULE) {
			obj.eUnset(XtextPackage.Literals.RULE_CALL__EXPLICITLY_CALLED);
		}
	}

	public void setPackageRemover(PackageRemover packageRemover) {
		this.packageRemover = packageRemover;
	}

	public PackageRemover getPackageRemover() {
		return packageRemover;
	}

	public void setCache(OnChangeEvictingCache cache) {
		this.cache = cache;
	}

	public OnChangeEvictingCache getCache() {
		return cache;
	}

}
