/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.ConstraintElementType;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SemanticSequencerUtil {

	@Inject
	protected IGrammarConstraintProvider gcp;

	public Map<IConstraint, List<EObject>> getGrammarConstraints(Grammar grammar, EClass clazz) {
		Map<IConstraint, List<EObject>> result = Maps.newHashMap();
		for (IConstraintContext ctx : gcp.getConstraints(grammar))
			for (IConstraint c : ctx.getConstraints())
				if (c.getType() == clazz) {
					List<EObject> contexts = result.get(c);
					if (contexts == null)
						result.put(c, contexts = Lists.newArrayList());
					contexts.add(ctx.getContext());
				}
		return result;
	}

	public Collection<EObject> getGrammarContexts(Grammar grammar, EClass clazz) {
		Set<EObject> result = Sets.newLinkedHashSet();
		for (IConstraintContext ctx : gcp.getConstraints(grammar))
			for (IConstraint c : ctx.getConstraints())
				if (c.getType() == clazz)
					result.add(ctx.getContext());
		return result;
	}

	public Collection<EObject> getGrammarContexts(Grammar grammar) {
		Set<EObject> result = Sets.newLinkedHashSet();
		for (IConstraintContext ctx : gcp.getConstraints(grammar))
			result.add(ctx.getContext());
		return result;
	}

	public List<IConstraintContext> getGrammarConstraintContexts(Grammar grammar) {
		return gcp.getConstraints(grammar);
	}

	public Collection<IConstraint> getGrammarConstraints(Grammar grammar) {
		Set<IConstraint> result = Sets.newTreeSet();
		for (IConstraintContext ctx : gcp.getConstraints(grammar))
			result.addAll(ctx.getConstraints());
		return result;
	}

	public boolean canGenerate(IConstraint constraint) {
		if (constraint.getAssignments().length != constraint.getFeatures().length)
			return false;
		IConstraintElement body = constraint.getBody();
		if (body == null)
			return false;
		if (body.getFeatureInfo() != null && !body.isOptional() && !body.isMany()
				&& !body.getFeatureInfo().getFeature().isMany())
			return true;
		if (body.getType() == ConstraintElementType.GROUP) {
			for (IConstraintElement child : body.getChildren())
				if (child.getFeatureInfo() == null || child.isOptional() || child.isMany()
						|| child.getFeatureInfo().getFeature().isMany())
					return false;
			return true;
		}
		return false;
	}

	public String toAcceptMethod(ConstraintElementType type) {
		switch (type) {
			case ASSIGNED_ACTION_CALL:
				return "acceptAssignedAction";
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				return "acceptAssignedCrossRefDatatype";
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				return "acceptAssignedCrossRefEnum";
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				return "acceptAssignedCrossRefTerminal";
			case ASSIGNED_DATATYPE_RULE_CALL:
				return "acceptAssignedDatatype";
			case ASSIGNED_ENUM_RULE_CALL:
				return "acceptAssignedEnum";
			case ASSIGNED_KEYWORD:
				return "acceptAssignedKeyword";
			case ASSIGNED_BOOLEAN_KEYWORD:
				return "acceptAssignedKeyword";
			case ASSIGNED_PARSER_RULE_CALL:
				return "acceptAssignedParserRuleCall";
			case ASSIGNED_TERMINAL_RULE_CALL:
				return "acceptAssignedTerminal";
			default:
				return "<error, unknown type +'" + type + "'>";
		}
	}

	public String toNodeType(ConstraintElementType type) {
		switch (type) {
			case ASSIGNED_ACTION_CALL:
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
			case ASSIGNED_DATATYPE_RULE_CALL:
			case ASSIGNED_ENUM_RULE_CALL:
			case ASSIGNED_PARSER_RULE_CALL:
				return ICompositeNode.class.getSimpleName();
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
			case ASSIGNED_KEYWORD:
			case ASSIGNED_BOOLEAN_KEYWORD:
			case ASSIGNED_TERMINAL_RULE_CALL:
				return ILeafNode.class.getSimpleName();
			default:
				return "<error, unknown type +'" + type + "'>";
		}
	}

}
