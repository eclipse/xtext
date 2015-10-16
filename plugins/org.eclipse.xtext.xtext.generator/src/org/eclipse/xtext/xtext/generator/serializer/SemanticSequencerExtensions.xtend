/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.ConstraintElementType
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState

class SemanticSequencerExtensions {
	
	@Inject IGrammarConstraintProvider gcp

	def Map<IConstraint, List<EObject>> getGrammarConstraints(Grammar grammar, EClass clazz) {
		val Map<IConstraint, List<EObject>> result = newLinkedHashMap
		for (ctx : gcp.getConstraints(grammar)) {
			for (c : ctx.constraints) {
				if (c.type === clazz) {
					var contexts = result.get(c)
					if (contexts === null) {
						contexts = newArrayList
						result.put(c, contexts)
					}
					contexts.add(ctx.context)
				}
			}
		}
		return result
	}

	def List<IConstraintContext> getGrammarConstraintContexts(Grammar grammar) {
		return gcp.getConstraints(grammar)
	}

	@FinalFieldsConstructor
	@Accessors
	protected static class SuperGrammar extends AdapterImpl {
		
		val Grammar grammar

		override boolean isAdapterForType(Object type) {
			return type === SuperGrammar
		}
		
	}

	def protected ResourceSet cloneResourceSet(ResourceSet rs) {
		val result = new XtextResourceSet
		result.packageRegistry = rs.packageRegistry
		result.resourceFactoryRegistry = rs.resourceFactoryRegistry
		result.URIConverter = rs.URIConverter
		if (rs instanceof XtextResourceSet) {
			result.classpathURIContext = rs.classpathURIContext
			result.classpathUriResolver = rs.classpathUriResolver
		}
		return result
	}

	def Grammar getSuperGrammar(Grammar grammar) {
		if (grammar.usedGrammars.isEmpty)
			return null
		var sg = EcoreUtil.getExistingAdapter(grammar, SuperGrammar) as SuperGrammar
		if (sg !== null)
			return sg.grammar
		val uri = grammar.usedGrammars.head.eResource.URI
		val resource = cloneResourceSet(grammar.eResource.resourceSet).getResource(uri, true)
		val result = resource.contents.head as Grammar
		grammar.eAdapters.add(new SuperGrammar(result))
		return result
	}

	def Collection<IConstraint> getGrammarConstraints(Grammar grammar) {
		if (grammar === null)
			return emptySet
		val Set<IConstraint> result = newLinkedHashSet
		val constraints = gcp.getConstraints(grammar)
		for (ctx : constraints) {
			result.addAll(ctx.constraints)
		}
		return result
	}

	def List<ISemState> getLinearListOfMandatoryAssignments(IConstraint constraint) {
		val nfa = constraint.nfa
		var state = nfa.start
		val List<ISemState> result = newArrayList
		val Set<EStructuralFeature> features = newHashSet
		while (state !== null) {
			if (state === nfa.stop)
				return if (result.empty) null else result
			if (state.followers.size !== 1)
				return null
			if (state !== nfa.start) {
				val feature = state.feature
				if (feature === null || feature.isMany || !features.add(feature))
					return null
				result.add(state)
			}
			state = state.followers.head
		}
		return null
	}

	def String toAcceptMethod(ConstraintElementType type) {
		switch (type) {
			case ASSIGNED_ACTION_CALL:
				'acceptAssignedAction'
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				'acceptAssignedCrossRefDatatype'
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				'acceptAssignedCrossRefEnum'
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				'acceptAssignedCrossRefTerminal'
			case ASSIGNED_CROSSREF_KEYWORD:
				'acceptAssignedCrossRefKeyword'
			case ASSIGNED_DATATYPE_RULE_CALL:
				'acceptAssignedDatatype'
			case ASSIGNED_ENUM_RULE_CALL:
				'acceptAssignedEnum'
			case ASSIGNED_KEYWORD:
				'acceptAssignedKeyword'
			case ASSIGNED_PARSER_RULE_CALL:
				'acceptAssignedParserRuleCall'
			case ASSIGNED_TERMINAL_RULE_CALL:
				'acceptAssignedTerminal'
			default:
				'<error, unknown type \'' + type + '\'>'
		}
	}

	def String toNodeType(ConstraintElementType type) {
		switch (type) {
			case ASSIGNED_ACTION_CALL,
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL,
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL,
			case ASSIGNED_CROSSREF_KEYWORD,
			case ASSIGNED_DATATYPE_RULE_CALL,
			case ASSIGNED_ENUM_RULE_CALL,
			case ASSIGNED_PARSER_RULE_CALL:
				ICompositeNode.simpleName
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL,
			case ASSIGNED_KEYWORD,
			case ASSIGNED_TERMINAL_RULE_CALL:
				ILeafNode.simpleName
			default:
				'<error, unknown type \'' + type + '\'>'
		}
	}
}
