/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.eclipse.xtext.util.formallang.GrammarStringFactory;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaToGrammar;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SequencerDiagnosticProvider implements ISemanticSequencerDiagnosticProvider {

	public static class NamedElement2Name implements Function<ENamedElement, String> {

		public String apply(ENamedElement from) {
			return from == null ? "null" : from.getName();
		}
	}

	@Inject
	protected Context2NameFunction context2Name;

	@Inject
	protected IGrammarAccess grammarAccess;

	@Inject
	protected IGrammarConstraintProvider grammarConstraints;

	@Inject
	protected IContextFinder contextFinder;

	public ISerializationDiagnostic createFeatureValueMissing(EObject semanticObject, EStructuralFeature feature) {
		return new SerializationDiagnostic(semanticObject, "foo bar");
	}

	public ISerializationDiagnostic createInvalidContextOrTypeDiagnostic(EObject semanticObject, EObject context) {
		Set<EObject> contexts = Sets.newHashSet(contextFinder.findContextsByContentsAndContainer(semanticObject, null));
		List<EClass> validTypes = getValidTypes(context);
		List<EObject> recommendedCtxs = Lists.newArrayList();
		List<EObject> otherValidCtxs = Lists.newArrayList();
		for (EObject ctx : getValidContexts(semanticObject.eClass())) {
			if (contexts.contains(ctx))
				recommendedCtxs.add(ctx);
			else
				otherValidCtxs.add(ctx);
		}
		String contextName = context2Name.apply(context);
		String semanticType = semanticObject.eClass().getName();
		String recommendCtxNames = Joiner.on(", ").join(Iterables.transform(recommendedCtxs, context2Name));
		String validTypeNames = Joiner.on(", ").join(Iterables.transform(validTypes, new NamedElement2Name()));
		StringBuilder msg = new StringBuilder();
		msg.append("The context '" + contextName + "' is not valid for type '" + semanticType + "'\n");
		msg.append("Recommended contexts for type '" + semanticType + "': " + recommendCtxNames + "\n");
		if (!otherValidCtxs.isEmpty())
			msg.append("Other valid contexts for type '" + semanticType + "': "
					+ Joiner.on(", ").join(Iterables.transform(otherValidCtxs, context2Name)));
		msg.append("The context '" + contextName + "' is valid for types: " + validTypeNames + "\n");
		return new SerializationDiagnostic(semanticObject, msg.toString());
	}

	protected List<EObject> getValidContexts(EClass clazz) {
		List<EObject> result = Lists.newArrayList();
		List<IConstraintContext> constraints = grammarConstraints.getConstraints(grammarAccess.getGrammar());
		for (IConstraintContext ctx : constraints)
			for (IConstraint c : ctx.getConstraints())
				if (c.getType() == clazz)
					result.add(ctx.getContext());
		return result;
	}

	protected List<EClass> getValidTypes(EObject context) {
		List<IConstraintContext> constraints = grammarConstraints.getConstraints(grammarAccess.getGrammar());
		for (IConstraintContext ctx : constraints)
			if (ctx.getContext() == context) {
				List<EClass> result = Lists.newArrayList();
				for (IConstraint c : ctx.getConstraints())
					result.add(c.getType());
				return result;
			}
		return Collections.emptyList();
	}

	public ISerializationDiagnostic createBacktrackingFailedDiagnostic(EObject semanticObject, EObject context,
			Nfa<ISemState> nfa) {
		String grammar = new NfaToGrammar().nfaToGrammar(nfa, new Function<ISemState, AbstractElement>() {
			public AbstractElement apply(ISemState from) {
				return from.getAssignedGrammarElement();
			}
		}, new GrammarStringFactory<AbstractElement>(new GrammarElementTitleSwitch().showAssignments()));
		StringBuilder msg = new StringBuilder();
		msg.append("Could not serialize EObject via backtracking.\n");
		msg.append("Constraint: " + grammar);
		return new SerializationDiagnostic(semanticObject, context, msg.toString());
	}

}
