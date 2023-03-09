/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.ConstraintElementType;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.util.formallang.Nfa;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class SemanticSequencerExtensions {
	protected static class SuperGrammar extends AdapterImpl {
		private final Grammar grammar;

		@Override
		public boolean isAdapterForType(Object type) {
			return type == SuperGrammar.class;
		}

		public SuperGrammar(Grammar grammar) {
			this.grammar = grammar;
		}

		public Grammar getGrammar() {
			return grammar;
		}
	}

	@Inject
	private IGrammarConstraintProvider gcp;

	public Map<IConstraint, List<ISerializationContext>> getGrammarConstraints(Grammar grammar, EClass clazz) {
		Map<IConstraint, List<ISerializationContext>> result = new LinkedHashMap<>();
		SerializationContextMap<IConstraint> constraints = gcp.getConstraints(grammar);
		for (SerializationContextMap.Entry<IConstraint> e : constraints.values()) {
			IConstraint constraint = e.getValue();
			if (constraint.getType() == clazz) {
				List<ISerializationContext> contexts = result.get(constraint);
				if (contexts == null) {
					contexts = new ArrayList<>();
					result.put(constraint, contexts);
				}
				contexts.addAll(e.getContexts(clazz));
			}
		}
		return result;
	}

	protected ResourceSet cloneResourceSet(ResourceSet rs) {
		XtextResourceSet result = new XtextResourceSet();
		result.setPackageRegistry(rs.getPackageRegistry());
		result.setResourceFactoryRegistry(rs.getResourceFactoryRegistry());
		result.setURIConverter(rs.getURIConverter());
		if (rs instanceof XtextResourceSet) {
			result.setClasspathURIContext(((XtextResourceSet) rs).getClasspathURIContext());
			result.setClasspathUriResolver(((XtextResourceSet) rs).getClasspathUriResolver());
		}
		return result;
	}

	public Grammar getSuperGrammar(Grammar grammar) {
		if (grammar.getUsedGrammars().isEmpty()) {
			return null;
		}
		SuperGrammar sg = (SuperGrammar) EcoreUtil.getExistingAdapter(grammar, SuperGrammar.class);
		if (sg != null) {
			return sg.grammar;
		}
		URI uri = Iterables.getFirst(grammar.getUsedGrammars(), null).eResource().getURI();
		Resource resource = cloneResourceSet(grammar.eResource().getResourceSet()).getResource(uri, true);
		Grammar result = (Grammar) Iterables.getFirst(resource.getContents(), null);
		grammar.eAdapters().add(new SuperGrammar(result));
		return result;
	}

	public Collection<IConstraint> getGrammarConstraints(Grammar grammar) {
		if (grammar == null) {
			return Collections.emptySet();
		}
		return Lists.transform(gcp.getConstraints(grammar).values(), SerializationContextMap.Entry::getValue);
	}

	public List<ISemState> getLinearListOfMandatoryAssignments(IConstraint constraint) {
		Nfa<ISemState> nfa = constraint.getNfa();
		ISemState state = nfa.getStart();
		List<ISemState> result = new ArrayList<>();
		Set<EStructuralFeature> features = new HashSet<>();
		while (state != null) {
			if (state == nfa.getStop()) {
				if (result.isEmpty()) {
					return null;
				} else {
					return result;
				}
			}
			if (state.getFollowers().size() != 1) {
				return null;
			}
			if (state != nfa.getStart()) {
				EStructuralFeature feature = state.getFeature();
				if (feature == null || feature.isMany() || !features.add(feature)) {
					return null;
				}
				result.add(state);
			}
			state = Iterables.getFirst(state.getFollowers(), null);
		}
		return null;
	}

	public String toAcceptMethod(ConstraintElementType type) {
		if (type != null) {
			switch (type) {
			case ASSIGNED_ACTION_CALL:
				return "acceptAssignedAction";
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				return "acceptAssignedCrossRefDatatype";
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				return "acceptAssignedCrossRefEnum";
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				return "acceptAssignedCrossRefTerminal";
			case ASSIGNED_CROSSREF_KEYWORD:
				return "acceptAssignedCrossRefKeyword";
			case ASSIGNED_DATATYPE_RULE_CALL:
				return "acceptAssignedDatatype";
			case ASSIGNED_ENUM_RULE_CALL:
				return "acceptAssignedEnum";
			case ASSIGNED_KEYWORD:
				return "acceptAssignedKeyword";
			case ASSIGNED_PARSER_RULE_CALL:
				return "acceptAssignedParserRuleCall";
			case ASSIGNED_TERMINAL_RULE_CALL:
				return "acceptAssignedTerminal";
			default:
				return "<error, unknown type '" + type + "'>";
			}
		} else {
			return "<error, unknown type '" + type + "'>";
		}
	}

	public String toNodeType(ConstraintElementType type) {
		if (type != null) {
			switch (type) {
			case ASSIGNED_ACTION_CALL:
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
			case ASSIGNED_CROSSREF_KEYWORD:
			case ASSIGNED_DATATYPE_RULE_CALL:
			case ASSIGNED_ENUM_RULE_CALL:
			case ASSIGNED_PARSER_RULE_CALL:
				return ICompositeNode.class.getSimpleName();
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
			case ASSIGNED_KEYWORD:
			case ASSIGNED_TERMINAL_RULE_CALL:
				return ILeafNode.class.getSimpleName();
			default:
				return "<error, unknown type '" + type + "'>";
			}
		} else {
			return "<error, unknown type '" + type + "'>";
		}
	}
}
