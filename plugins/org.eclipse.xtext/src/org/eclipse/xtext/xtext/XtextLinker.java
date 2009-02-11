/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducerDecorator;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.ClasspathUriUtil;
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
		} else if (XtextPackage.eINSTANCE.getGrammar_SuperGrammar() == ref) {
			final Grammar grammar = (Grammar) obj;
			if (!IXtextBuiltin.ID.equals(grammar.getName())) {
				final ResourceSet resourceSet = grammar.eResource().getResourceSet();
				final Resource resource = resourceSet.getResource(URI.createURI(
						ClasspathUriUtil.CLASSPATH_SCHEME + ":/" + IXtextBuiltin.ID.replace('.', '/') + ".xtext"), true);
				grammar.setSuperGrammar((Grammar) resource.getContents().get(0));
			}
		} else {
			super.setDefaultValueImpl(obj, ref, producer);
		}
	}
	
	@Override
	protected boolean isNullValidResult(EObject obj, EReference eRef, AbstractNode node) {
		if (XtextPackage.eINSTANCE.getGrammar_SuperGrammar() == eRef) {
			final StringBuilder builder = new StringBuilder(node.getLength());
			for (LeafNode leaf: node.getLeafNodes()) {
				if (!leaf.isHidden())
					builder.append(leaf.getText());
			}
			return "NULL".equals(builder.toString());
		}
		return super.isNullValidResult(obj, eRef, node);
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
	}
	
	protected void updateOverriddenRules(Grammar grammar) {
		if (grammar.getSuperGrammar() == null)
			return;
		Map<String, AbstractRule> rulePerName = new HashMap<String, AbstractRule>(grammar.getRules().size());
		for (AbstractRule rule: grammar.getRules())
			rulePerName.put(rule.getName(), rule);
		Grammar superGrammar = grammar.getSuperGrammar();
		while(superGrammar != null) {
			updateOverriddenRules(superGrammar, rulePerName);
			superGrammar = superGrammar.getSuperGrammar();
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
