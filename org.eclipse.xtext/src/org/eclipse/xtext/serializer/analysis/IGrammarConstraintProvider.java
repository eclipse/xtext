/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.Production;

import com.google.inject.ImplementedBy;

/**
 * Based on an Xtext grammar, the IGrammarConstraintProvider provides constraints that the semantic model must comply
 * with. The structure of the constraints is as follows:
 * 
 * <pre>
 * XtextGrammar 
 * \- 0..n IConstraintContext (one for each ParserRule and AssignedAction) 
 *    \- 1..n IConstraint (one for each EClass) 
 *       \- tree IConstraintElement (one for each relevant Group, Alternative, RuleCall and assigned Keyword)
 * </pre>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(GrammarConstraintProvider.class)
public interface IGrammarConstraintProvider {

	/**
	 * The ConstraintElementType distinguishes different kinds of {@link IConstraintElement}
	 * 
	 * @see IConstraintElement#getType()
	 */
	public enum ConstraintElementType {
		ALTERNATIVE, //
		ASSIGNED_ACTION_CALL, //
		ASSIGNED_CROSSREF_DATATYPE_RULE_CALL, //
		ASSIGNED_CROSSREF_ENUM_RULE_CALL, //
		ASSIGNED_CROSSREF_TERMINAL_RULE_CALL, //
		ASSIGNED_CROSSREF_KEYWORD, //
		ASSIGNED_DATATYPE_RULE_CALL, //
		ASSIGNED_ENUM_RULE_CALL, //
		ASSIGNED_KEYWORD, //
		ASSIGNED_PARSER_RULE_CALL, //
		ASSIGNED_TERMINAL_RULE_CALL, //
		GROUP, // 
		UNORDERED_GROUP;

		public static ConstraintElementType getConstraintElementType(AbstractElement ele) {
			if (ele instanceof Action) {
				if (((Action) ele).getFeature() != null)
					return ConstraintElementType.ASSIGNED_ACTION_CALL;
			} else if (ele instanceof Alternatives) {
				return ConstraintElementType.ALTERNATIVE;
			} else if (ele instanceof Group) {
				return ConstraintElementType.GROUP;
			} else if (ele instanceof UnorderedGroup) {
				return ConstraintElementType.UNORDERED_GROUP;
			} else if (GrammarUtil.containingCrossReference(ele) != null) {
				if (ele instanceof RuleCall) {
					RuleCall rc = (RuleCall) ele;
					if (rc.getRule() instanceof ParserRule)
						return ConstraintElementType.ASSIGNED_CROSSREF_DATATYPE_RULE_CALL;
					if (rc.getRule() instanceof TerminalRule)
						return ConstraintElementType.ASSIGNED_CROSSREF_TERMINAL_RULE_CALL;
					if (rc.getRule() instanceof EnumRule)
						return ConstraintElementType.ASSIGNED_CROSSREF_ENUM_RULE_CALL;
				} else if (ele instanceof Keyword)
					return ConstraintElementType.ASSIGNED_CROSSREF_KEYWORD;
			} else if (GrammarUtil.containingAssignment(ele) != null) {
				if (ele instanceof RuleCall) {
					RuleCall rc = (RuleCall) ele;
					if (rc.getRule() instanceof ParserRule) {
						if (rc.getRule().getType().getClassifier() instanceof EClass)
							return ConstraintElementType.ASSIGNED_PARSER_RULE_CALL;
						return ConstraintElementType.ASSIGNED_DATATYPE_RULE_CALL;
					}
					if (rc.getRule() instanceof TerminalRule)
						return ConstraintElementType.ASSIGNED_TERMINAL_RULE_CALL;
					if (rc.getRule() instanceof EnumRule)
						return ConstraintElementType.ASSIGNED_ENUM_RULE_CALL;

				} else if (ele instanceof Keyword) {
					return ConstraintElementType.ASSIGNED_KEYWORD;
				}
			}
			throw new RuntimeException("Unknown Grammar Element: " + EmfFormatter.objPath(ele));
		}
	}

	/**
	 * One constraint defines all conditions one semantic object must comply with. A constraint is specific for one
	 * EClass and belongs to one or more contexts.
	 * 
	 * The conditions defined by a constraint are represented by a tree of {@link IConstraintElement}. This tree's root
	 * can be accessed by {@link #getBody()}.
	 */
	public interface IConstraint extends Comparable<IConstraint> {

		/**
		 * @return the root of the tree of {@link IConstraintElement} that defines this constraint.
		 */
		IConstraintElement getBody();

		/**
		 * @return a list of {@link IFeatureInfo} for all {@link EStructuralFeature}s from the {@link EClass} returned
		 *         by {@link #getType()} that have an assignment if this constraint. If there is no assignment for an
		 *         {@link EStructuralFeature} in this constraint, the array's item is null.
		 */
		IFeatureInfo[] getFeatures();

		/**
		 * @return a name that is unique for a grammar and that aims to be human-readable.
		 */
		String getName();

		String getSimpleName();

		/**
		 * @return This constraint only applies to EObjects of this type.
		 */
		EClass getType();

		List<ISerializationContext> getContexts();

		Nfa<ISemState> getNfa();
	}

	public class ConstraintElementProduction implements Production<IConstraintElement, AbstractElement> {

		protected IConstraint root;

		public ConstraintElementProduction(IConstraint root) {
			super();
			this.root = root;
		}

		@Override
		public Iterable<IConstraintElement> getAlternativeChildren(IConstraintElement ele) {
			if (ele.getType() == ConstraintElementType.ALTERNATIVE)
				return ele.getChildren();
			return null;
		}

		@Override
		public Iterable<IConstraintElement> getSequentialChildren(IConstraintElement ele) {
			if (ele.getType() == ConstraintElementType.GROUP)
				return ele.getChildren();
			return null;
		}

		@Override
		public AbstractElement getToken(IConstraintElement ele) {
			if (ele.getType() != ConstraintElementType.ALTERNATIVE && ele.getType() != ConstraintElementType.GROUP)
				return ele.getGrammarElement();
			return null;
		}

		@Override
		public Iterable<IConstraintElement> getUnorderedChildren(IConstraintElement ele) {
			return null;
		}

		@Override
		public boolean isMany(IConstraintElement ele) {
			return ele.isMany();
		}

		@Override
		public boolean isOptional(IConstraintElement ele) {
			return ele.isOptional();
		}

		@Override
		public IConstraintElement getParent(IConstraintElement ele) {
			return ele.getContainer();
		}

		@Override
		public IConstraintElement getRoot() {
			return root.getBody();
		}
	}

	/**
	 * IConstraintElements form a tree that is in fact a view on the grammar's AbstractElements.
	 */
	public interface IConstraintElement {

		// valid for GROUP and ALTERNATIVE, null otherwise
		Collection<IConstraintElement> getChildren();

		IConstraintElement getContainer();

		IConstraint getContainingConstraint();

		// valid for ASSIGNED_*
		//		IFeatureInfo getFeatureInfo();

		// returns a RuleCall, Keyword or Action. But never an Assignment or
		// Cross Reference.
		AbstractElement getGrammarElement();

		ConstraintElementType getType();

		boolean isMany();

		boolean isOptional();

	}

	public interface IFeatureInfo {

		List<IConstraintElement> getAssignments();

		IConstraint getContainingConstraint();

		EStructuralFeature getFeature();

		int getUpperBound();

		int getLowerBound();
	}

	final int MAX = Integer.MAX_VALUE;

	/**
	 * Returns all constraints form this grammar. If a constraint belongs to multiple ConstraintContexts, it is
	 * important to call this method to ensure there is inly one instance fo this constraint.
	 */
	public SerializationContextMap<IConstraint> getConstraints(Grammar context);

}
