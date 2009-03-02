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
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.impl.Linker;
import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducerDecorator;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.metamodel.TransformationDiagnosticsProducer;
import org.eclipse.xtext.resource.metamodel.Xtext2EcoreTransformer;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinker extends Linker {

	private static Logger log = Logger.getLogger(XtextLinker.class);

	@Inject
	private IScopeProvider scopeProvider;

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
				filter = (feature == XtextPackage.eINSTANCE.getTypeRef_Type() &&
					((TypeRef) object).getMetamodel() instanceof GeneratedMetamodel) ||
					(feature == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage() &&
					(object instanceof GeneratedMetamodel));
			}

		};
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
		} else if (XtextPackage.eINSTANCE.getCrossReference_Rule() == ref) {
			try {
				((CrossReference)obj).setRule(GrammarUtil.findRuleForName(GrammarUtil.getGrammar(obj), "ID"));
			} catch(IllegalArgumentException ex) {
				producer.addDiagnostic("Cannot resolve implicit reference to rule 'ID'");
			}
		} else {
			super.setDefaultValueImpl(obj, ref, producer);
		}
	}

	@Override
	protected void beforeEnsureIsLinked(EObject obj, EReference ref, IDiagnosticProducer producer) {
		if (XtextPackage.eINSTANCE.getTypeRef_Type() == ref) {
			final TypeRef typeRef = (TypeRef) obj;
			if (typeRef.getMetamodel() == null)
				setDefaultValue(obj, XtextPackage.eINSTANCE.getTypeRef_Metamodel(), producer);
		} else
			super.beforeEnsureIsLinked(obj, ref, producer);
	}

	protected Xtext2EcoreTransformer createTransformer(Grammar grammar, IDiagnosticConsumer consumer) {
		final Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
		transformer.setErrorAcceptor(new TransformationDiagnosticsProducer(consumer));
		return transformer;
	}

	@Override
	public void linkModel(EObject model, IDiagnosticConsumer consumer) {
		final Xtext2EcoreTransformer transformer = createTransformer((Grammar) model, consumer);
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

	private final PackageRemover packageRemover = new PackageRemover();

	private static class PackageRemover extends EContentAdapter {

		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if (!msg.isTouch() && msg.getOldValue() != null) {
				ResourceSet set;
				if (!(msg.getNotifier() instanceof Resource)) {
					Object feature = msg.getFeature();
					if (!(feature instanceof EReference))
						return;
					EReference ref = (EReference) feature;
					if (!ref.isContainment())
						return;
					set = ((EObject) msg.getNotifier()).eResource().getResourceSet();
				} else {
					set = ((Resource) msg.getNotifier()).getResourceSet();
				}
				if (set == null)
					return;
				switch (msg.getEventType()) {
					case Notification.REMOVE_MANY:
					case Notification.REMOVE:
					case Notification.SET:
						Object oldValue = msg.getOldValue();
						Collection<Resource> referencedResources = new HashSet<Resource>();
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
						set.getResources().removeAll(resourcesToRemove);
						break;
					default:
						break;
				}
			}
		}

		public boolean isPackageReferenced(ResourceSet set, EPackage pack, Collection<AbstractMetamodelDeclaration> knownReferences) {
			for(Resource resource: set.getResources()) {
				for(EObject content: resource.getContents()) {
					if (content instanceof Grammar) {
						for (AbstractMetamodelDeclaration decl: ((Grammar) content).getMetamodelDeclarations()) {
							if (pack.equals(decl.getEPackage()) && !knownReferences.contains(decl))
								return true;
						}
					}
				}
			}
			return false;
		}
	}

	protected void updateOverriddenRules(Grammar grammar) {
		if (grammar.getUsedGrammars().isEmpty())
			return;
		Map<String, AbstractRule> rulePerName = new HashMap<String, AbstractRule>(grammar.getRules().size());
		for (AbstractRule rule: grammar.getRules())
			rulePerName.put(rule.getName(), rule);
		Set<Grammar> visitedGrammars = new HashSet<Grammar>();
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
		final List<CrossReference> allCrossRefs = EcoreUtil2.getAllContentsOfType(grammar, CrossReference.class);
		for (CrossReference ref: allCrossRefs) {
			if (ref.getRule() != null) {
				AbstractRule rule = rulePerName.get(ref.getRule().getName());
				if (rule != null)
					ref.setRule(rule);
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
		if (obj instanceof GeneratedMetamodel && ref.equals(XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE) && obj.eIsSet(ref)) {
			EPackage pack = ((AbstractMetamodelDeclaration) obj).getEPackage();
			pack.eResource().getResourceSet().getResources().remove(pack.eResource());
		}
		super.clearReference(obj, ref);
		if (obj.eIsSet(ref) && ref.getEType().equals(XtextPackage.Literals.TYPE_REF)) {
			NodeAdapter adapter = NodeUtil.getNodeAdapter((EObject) obj.eGet(ref));
			if (adapter == null || adapter.getParserNode() == null)
				obj.eUnset(ref);
		}
	}

}
