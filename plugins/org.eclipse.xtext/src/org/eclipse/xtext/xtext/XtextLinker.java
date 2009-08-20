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
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducerDecorator;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xtext.ecoreInference.TransformationDiagnosticsProducer;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;
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

	@Inject(optional=true)
	private IXtext2EcorePostProcessor postProcessor;

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	@Override
	protected IDiagnosticProducer createDiagnosticProducer(final IDiagnosticConsumer consumer) {
		return new AbstractDiagnosticProducerDecorator(super.createDiagnosticProducer(consumer)) {
			private boolean filter = false;

			@Override
			public void addDiagnostic(String message) {
				if (!filter)
					super.addDiagnostic(message);
			}

			@Override
			public void setTarget(EObject object, EStructuralFeature feature) {
				super.setTarget(object, feature);
				// we don't want to mark generated types as errors unless generation fails
				filter = isTypeRef(object, feature) ||
					isGeneratedPackage(object, feature) ||
					isEnumLiteral(object, feature);
			}

			private boolean isEnumLiteral(EObject object, EStructuralFeature feature) {
				if (feature == XtextPackage.eINSTANCE.getEnumLiteralDeclaration_EnumLiteral()) {
					EnumRule rule = GrammarUtil.containingEnumRule(object);
					return rule.getType() == null || rule.getType().getClassifier() == null;
				}
				return false;
			}

			private boolean isGeneratedPackage(EObject object, EStructuralFeature feature) {
				return (feature == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage() &&
						(object instanceof GeneratedMetamodel));
			}

			private boolean isTypeRef(EObject object, EStructuralFeature feature) {
				return (feature == XtextPackage.eINSTANCE.getTypeRef_Classifier() &&
						((TypeRef) object).getMetamodel() instanceof GeneratedMetamodel);
			}

		};
	}

	@Override
	protected boolean canSetDefaultValues(EReference ref) {
		return super.canSetDefaultValues(ref) || ref == XtextPackage.Literals.CROSS_REFERENCE__TERMINAL;
	}

	@Override
	protected void setDefaultValueImpl(EObject obj, EReference ref, IDiagnosticProducer producer) {
		if (XtextPackage.eINSTANCE.getTypeRef_Metamodel() == ref) {
			final TypeRef typeRef = (TypeRef) obj;
			final String typeRefName = GrammarUtil.getTypeRefName(typeRef);
			final List<EObject> metamodels = XtextMetamodelReferenceHelper.findBestMetamodelForType(
					typeRef, "", typeRefName, scopeProvider.getScope(typeRef, ref));
			if (metamodels.isEmpty() || metamodels.size() > 1)
				producer.addDiagnostic("Cannot find meta model for type '" + typeRefName + "'");
			else
				typeRef.setMetamodel((AbstractMetamodelDeclaration) metamodels.get(0));
		} else if (XtextPackage.eINSTANCE.getCrossReference_Terminal() == ref) {
			AbstractRule rule = GrammarUtil.findRuleForName(GrammarUtil.getGrammar(obj), "ID");
			if (rule == null)
				producer.addDiagnostic("Cannot resolve implicit reference to rule 'ID'");
			else {
				RuleCall call = XtextFactory.eINSTANCE.createRuleCall();
				call.setRule(rule);
				((CrossReference)obj).setTerminal(call);
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

	@Override
	public void linkModel(EObject model, IDiagnosticConsumer consumer) {
		final Xtext2EcoreTransformer transformer = createTransformer((Grammar) model, consumer);
		//TODO duplicate
		transformer.removeGeneratedPackages();
		super.linkModel(model, consumer);
		updateOverriddenRules((Grammar) model);
		try {
			transformer.transform();
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			consumer.consume(new ExceptionDiagnostic(e));
		}
		if (!model.eResource().eAdapters().contains(packageRemover))
			model.eResource().eAdapters().add(packageRemover);
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
						Collection<Resource> referencedResources = Sets.newHashSet(notifyingResource);
						Collection<Resource> resourcesToRemove = new HashSet<Resource>();
						if (oldValue instanceof Grammar) {
							for(AbstractMetamodelDeclaration declaration: ((Grammar)oldValue).getMetamodelDeclarations()) {
								EPackage pack = declaration.getEPackage();
								if (pack != null && pack.eResource() != null) {
									resourcesToRemove.add(pack.eResource());
									if (isPackageReferenced(set, pack, ((Grammar)oldValue).getMetamodelDeclarations())) {
										referencedResources.add(pack.eResource());
									}
								}
							}
						} else if (oldValue instanceof AbstractMetamodelDeclaration) {
							EPackage pack = ((AbstractMetamodelDeclaration) oldValue).getEPackage();
							if (pack != null && pack.eResource() != null) {
								resourcesToRemove.add(pack.eResource());
								if (!isPackageReferenced(set, pack, Collections.singletonList((AbstractMetamodelDeclaration)oldValue))) {
									referencedResources.add(pack.eResource());
								}
							}
						} else if (oldValue instanceof Collection<?>) {
							if (XtextPackage.Literals.GRAMMAR__METAMODEL_DECLARATIONS == msg.getFeature()) {
								Collection<AbstractMetamodelDeclaration> metamodelDeclarations = (Collection<AbstractMetamodelDeclaration>) oldValue;
								for(AbstractMetamodelDeclaration declaration: metamodelDeclarations) {
									EPackage pack =declaration.getEPackage();
									if (pack != null && pack.eResource() != null) {
										resourcesToRemove.add(pack.eResource());
										if (!isPackageReferenced(set, pack, metamodelDeclarations)) {
											referencedResources.add(pack.eResource());
										}
									}
								}
							}
						}
						resourcesToRemove.removeAll(referencedResources);
						if (unloader != null) {
							for(Resource resource: resourcesToRemove) {
								for(EObject content: resource.getContents())
									unloader.unloadRoot(content);
							}
						}
						set.getResources().removeAll(resourcesToRemove);
						break;
					default:
						break;
				}
			}
		}

		public boolean isPackageReferenced(ResourceSet set, EPackage pack, Collection<AbstractMetamodelDeclaration> knownReferences) {
			for(int i = 0; i < set.getResources().size(); i++) { // cannot use foreach since we may get
																 // a CME due to proxy resolution and transparent
																 // loading of resources
				Resource resource = set.getResources().get(i);
				if (resource != null) {
					for(EObject content: resource.getContents()) {
						if (content instanceof Grammar) {
							for (AbstractMetamodelDeclaration decl: ((Grammar) content).getMetamodelDeclarations()) {
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
		for (AbstractRule rule: grammar.getRules())
			rulePerName.put(rule.getName(), rule);
		Set<Grammar> visitedGrammars = new HashSet<Grammar>();
		visitedGrammars.add(grammar);
		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			updateOverriddenRules(usedGrammar, rulePerName, visitedGrammars);
		}
	}

	protected void updateOverriddenRules(Grammar grammar, Map<String, AbstractRule> rulePerName, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return;
		updateOverriddenRules(grammar, rulePerName);
		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			updateOverriddenRules(usedGrammar, rulePerName, visitedGrammars);
		}
	}

	protected void updateOverriddenRules(Grammar grammar, Map<String, AbstractRule> rulePerName) {
		if (grammar.isDefinesHiddenTokens()) {
			updateHiddenTokens(grammar.getHiddenTokens(), rulePerName);
		}
		for (AbstractRule rule: grammar.getRules()) {
			if (rule instanceof ParserRule && ((ParserRule)rule).isDefinesHiddenTokens()) {
				updateHiddenTokens(((ParserRule) rule).getHiddenTokens(), rulePerName);
			}
		}
		final List<RuleCall> allRuleCalls = EcoreUtil2.getAllContentsOfType(grammar, RuleCall.class);
		for (RuleCall call: allRuleCalls) {
			if (call.getRule() != null) {
				AbstractRule rule = rulePerName.get(call.getRule().getName());
				if (rule != null)
					call.setRule(rule);
			}
		}
	}

	private void updateHiddenTokens(List<AbstractRule> hiddenTokens, Map<String, AbstractRule> rulePerName) {
		for(int i = 0; i < hiddenTokens.size(); i++) {
			AbstractRule hidden = hiddenTokens.get(i);
			AbstractRule overridden = rulePerName.get(hidden.getName());
			if (overridden != null)
				hiddenTokens.set(i, overridden);
		}
	}

	/**
	 * We add typeRefs without Nodes on the fly, so we should remove them before
	 * relinking.
	 */
	@Override
	protected void clearReference(EObject obj, EReference ref) {
		super.clearReference(obj, ref);
		if (obj.eIsSet(ref) && ref.getEType().equals(XtextPackage.Literals.TYPE_REF)) {
			NodeAdapter adapter = NodeUtil.getNodeAdapter((EObject) obj.eGet(ref));
			if (adapter == null || adapter.getParserNode() == null)
				obj.eUnset(ref);
		}
		if (obj.eIsSet(ref) && ref == XtextPackage.Literals.CROSS_REFERENCE__TERMINAL) {
			NodeAdapter adapter = NodeUtil.getNodeAdapter((EObject) obj.eGet(ref));
			if (adapter == null || adapter.getParserNode() == null)
				obj.eUnset(ref);
		}
	}

	public void setPackageRemover(PackageRemover packageRemover) {
		this.packageRemover = packageRemover;
	}

	public PackageRemover getPackageRemover() {
		return packageRemover;
	}

}
