package org.eclipse.xtext.serializer.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.formallang.IGrammarAdapter;

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
		ASSIGNED_DATATYPE_RULE_CALL, //
		ASSIGNED_ENUM_RULE_CALL, //
		ASSIGNED_KEYWORD, //
		ASSIGNED_BOOLEAN_KEYWORD, //
		ASSIGNED_PARSER_RULE_CALL, //
		ASSIGNED_TERMINAL_RULE_CALL, //
		GROUP,
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
		 * @return a list of all assignments represented by this constraint.
		 *         {@link IConstraintElement#getAssignmentID()} returns an Assignment's index in this list. The order of
		 *         the list reflects the order of the assignments in the constraint. Assignments are
		 *         {@link IConstraintElement}s with {@link IConstraintElement#getType()} == ASSIGNED_*
		 */
		IConstraintElement[] getAssignments();

		/**
		 * @return the root of the tree of {@link IConstraintElement} that defines this constraint.
		 */
		IConstraintElement getBody();

		/**
		 * @return a list of all elements represented by this constraint. This is a flattened version of the tree
		 *         returned by {@link #getBody()}. {@link IConstraintElement#getElementID()} returns an Assignment's
		 *         index in this list. The order of the list reflects the order of the elements in the constraint.
		 */
		IConstraintElement[] getElements();

		/**
		 * @return a list of {@link IFeatureInfo} for all {@link EStructuralFeature}s from the {@link EClass} returned
		 *         by {@link #getType()} that have an assignment if this constraint. If there is no assignment for an
		 *         {@link EStructuralFeature} in this constraint, the array's item is null.
		 */
		IFeatureInfo[] getFeatures();

		Iterable<IFeatureInfo> getSingleAssignementFeatures();

		Iterable<IFeatureInfo> getMultiAssignementFeatures();

		/**
		 * @return a name that is unique for a grammar and that aims to be human-readable.
		 */
		String getName();

		/**
		 * @return This constraint only applies to EObjects of this type.
		 */
		EClass getType();
	}

	/**
	 * A ConstraintContext is defined by a ParserRule or an AssignedAction. A ConstraintContext holds a list of all
	 * constraints that are valid for this context. All these constraints have an EClass as their common super type.
	 * 
	 * If the context is a parser rule, the constraints of this context describe all the objects that can be
	 * instantiated via this parser rule.
	 * 
	 * If this context is an assigned action, the constraints of this context describe all the objects that can assigned
	 * by this action. These are all the objects that can be the "current" *before* the action is being executed. This
	 * is *not* the EObject that is instantiated by the action.
	 */
	public interface IConstraintContext {

		// TODO: make sure this type is right for actions
		EClass getCommonType();

		List<IConstraint> getConstraints();

		/**
		 * @return an AssignedAction or ParserRule
		 */
		EObject getContext();

		String getName();
	}

	/**
	 * IConstraintElements form a tree that is in fact a view on the grammar's AbstractElements.
	 */
	public interface IConstraintElement {

		static IGrammarAdapter<IConstraintElement, AbstractElement> ADAPTER = new IGrammarAdapter<IConstraintElement, AbstractElement>() {
			public Iterable<IConstraintElement> getAlternativeChildren(IConstraintElement ele) {
				if (ele.getType() == ConstraintElementType.ALTERNATIVE)
					return ele.getChildren();
				return null;
			}

			public Iterable<IConstraintElement> getSequentialChildren(IConstraintElement ele) {
				if (ele.getType() == ConstraintElementType.GROUP)
					return ele.getChildren();
				return null;
			}

			public AbstractElement getToken(IConstraintElement ele) {
				if (ele.getType() != ConstraintElementType.ALTERNATIVE && ele.getType() != ConstraintElementType.GROUP)
					return ele.getGrammarElement();
				return null;
			}

			public Iterable<IConstraintElement> getUnorderedChildren(IConstraintElement ele) {
				return null;
			}

			public boolean isMany(IConstraintElement ele) {
				return ele.isMany();
			}

			public boolean isOptional(IConstraintElement ele) {
				return ele.isOptional();
			}

			public IConstraintElement getParent(IConstraintElement ele) {
				return ele.getContainer();
			}
		};

		// valid for *_ACTION_CALL
		Action getAction();

		int getAssignmentID();

		EObject getCallContext();

		String getCardinality();

		// valid for GROUP and ALTERNATIVE, null otherwise
		List<IConstraintElement> getChildren();

		IConstraintElement getContainer();

		IConstraint getContainingConstraint();

		// valid for *_CROSSREF_*
		CrossReference getCrossReference();

		// valid for *_CROSSREF_*
		EClass getCrossReferenceType();

		int getElementID();

		// valid for ASSIGNED_*
		EStructuralFeature getFeature();

		int getFeatureAssignmentID();

		// valid for ASSIGNED_*
		IFeatureInfo getFeatureInfo();

		// returns a RuleCall, Keyword or Action. But never an Assignment or
		// Cross Reference.
		AbstractElement getGrammarElement();

		// valid for *_KEYWORD
		Keyword getKeyword();

		// valid for *_RULE_CALL
		RuleCall getRuleCall();

		ConstraintElementType getType();

		List<Pair<IConstraintElement, RelationalDependencyType>> getDependingAssignment();

		List<IConstraintElement> getContainedAssignments();

		boolean isCardinalityOneAmongAssignments(List<IConstraintElement> assignments);

		boolean isMany();

		/**
		 * @return true, if this element or one of its containers is isMany().
		 */
		boolean isManyRecursive(IConstraintElement root);

		boolean isOptional();

		boolean isRoot();

		/**
		 * @return true, if this element or one of its containers is optional. Also true, if one of the containers is an
		 *         alternative.
		 */
		boolean isOptionalRecursive(IConstraintElement root);
	}

	public interface IFeatureInfo {

		IConstraintElement[] getAssignments();

		List<EObject> getCalledContexts();

		IConstraint getContainingConstraint();

		EStructuralFeature getFeature();

		/**
		 * @return true for ASSIGNED_*, if there are multiple IConstraintELements for the same EStructuralFeature, which
		 *         refer to different keywords, rulecalls or cross references.
		 */
		boolean isContentValidationNeeded();

		List<Pair<IFeatureInfo, RelationalDependencyType>> getDependingFeatures();

		int getUpperBound();

		int getLowerBound();
	}

	public enum RelationalDependencyType {
		/**
		 * (b >= 1) => (a == 0)
		 */
		EXCLUDE_IF_SET,

		/**
		 * (b == 0) => (a == 0)
		 */
		EXCLUDE_IF_UNSET,

		/**
		 * (b >= 1) => (a >= 0)
		 */
		MANDATORY_IF_SET,

		/**
		 * a == b
		 */
		SAME,

		/**
		 * a >= b
		 */
		SAME_OR_MORE,

		/**
		 * a <= b
		 */
		SAME_OR_LESS
	}

	final int MAX = Integer.MAX_VALUE;

	/**
	 * Returns all constraints form this grammar. If a constraint belongs to multiple ConstraintContexts, it is
	 * important to call this method to ensure there is inly one instance fo this constraint.
	 */
	public List<IConstraintContext> getConstraints(Grammar context);

}
