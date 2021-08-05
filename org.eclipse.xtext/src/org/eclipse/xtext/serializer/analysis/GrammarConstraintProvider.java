/*******************************************************************************
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import static org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.ConstraintElementType.*;
import static org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap.Entry;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaToProduction;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.ProductionFactory;
import org.eclipse.xtext.util.formallang.ProductionFormatter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class GrammarConstraintProvider implements IGrammarConstraintProvider {

	protected static class Constraint implements IGrammarConstraintProvider.IConstraint {

		private IConstraintElement body = UNINITIALIZED;

		private final List<ISerializationContext> contexts = Lists.newArrayList();

		private IFeatureInfo[] features = null;

		private final Grammar grammar;

		private String identity;

		private String name;

		private final Nfa<ISemState> nfa;

		private final EClass type;

		public Constraint(Grammar grammar, EClass type, Nfa<ISemState> nfa) {
			super();
			this.grammar = grammar;
			this.type = type;
			this.nfa = nfa;
		}
		
		protected int[] computeLowerBounds() {
			int[] bounds = new int[type.getFeatureCount()];
			for (int i = 0; i < bounds.length; i++) {
				bounds[i] = computeLowerBound(i);
			}
			return bounds;
		}
		
		private static class DijkstraNode {
			/** Used to make sure all nodes are unique in the comparator function below. */
			int id;
			/** The tentative distance according to Dijkstra's algorithm. */
			int distance;
		}
		
		/**
		 * Computing the lower bound for a given feature is equivalent to the shortest path problem in the
		 * corresponding automaton graph. Dijkstra's algorithm solves this in quadratic time to the number
		 * of nodes.
		 */
		private int computeLowerBound(int featureId) {
			ISemState currentNode = nfa.getStart();
			final ISemState stopNode = nfa.getStop();
			final Map<ISemState, DijkstraNode> idAndDistance = Maps.newHashMap();
			idAndDistance.put(currentNode, new DijkstraNode());
			// The unvisited nodes are sorted by their tentative distance.
			// Nodes with equal distance still have to be separated, which is achieved with the id value. 
			NavigableSet<ISemState> unvisited = new TreeSet<>(Comparator.comparing((s) -> {
				return idAndDistance.get(s).distance;
			}).thenComparing((s) -> {
				return idAndDistance.get(s).id;
			}));
			int nextStateId = 1;
			do {
				int currentDistance = idAndDistance.get(currentNode).distance;
				if (currentNode == stopNode) {
					// We have reached the stop node and thus know the shortest path from start to stop.
					return currentDistance;
				}
				for (ISemState follower : currentNode.getFollowers()) {
					DijkstraNode fdn = idAndDistance.get(follower);
					// The cost of proceeding to this follower is 1 iff it has the correct feature id.
					int increment = follower.getFeatureID() == featureId ? 1 : 0;
					if (fdn == null) {
						// We haven't reached this node before. Assign a new id and distance and mark as unvisited.
						fdn = new DijkstraNode();
						fdn.id = nextStateId++;
						fdn.distance = currentDistance + increment;
						idAndDistance.put(follower, fdn);
						unvisited.add(follower);
					} else {
						// This follower node has already been reached.
						fdn.distance = Math.min(fdn.distance, currentDistance + increment);
						if (unvisited.remove(follower)) {
							// The position of the follower in the sorted set must be updated.
							unvisited.add(follower);
						}
					}
				}
				unvisited.remove(currentNode);
				// Choose the unvisited node with the lowest tentative distance.
				currentNode = unvisited.pollFirst();
			} while (currentNode != null);
			// If we get to this point, the stop state is not reachable from the start.
			throw new AssertionError("Stop state is not reachable.");
		}
		
		/**
		 * Computing the upper bounds is equivalent to the longest path problem. While this is NP-hard if
		 * constrained to simple paths, it becomes easily solvable in our case since we include infinite paths.
		 * All features that are assigned inside a cycle have infinity as upper bound. For the remaining features
		 * we can handle each cycle as if it was a single node because it is not relevant where we enter the
		 * cycle and where we exit it (traversing the cycle has zero weight). The resulting simplified graph
		 * is acyclic, and in such graphs the longest path can be computed in linear time with a simple recursive
		 * algorithm.
		 */
		protected int[] computeUpperBounds() {
			// Assign an infinite upper bound to all features that are on a cycle.
			NfaUtil nfaUtil = new NfaUtil();
			Map<ISemState, Set<ISemState>> cycles = nfaUtil.findCycles(nfa);
			int[] bounds = new int[type.getFeatureCount()];
			for (Set<ISemState> cycle : cycles.values()) {
				for (ISemState node : cycle) {
					int featureId = node.getFeatureID();
					if (featureId >= 0) {
						bounds[featureId] = IGrammarConstraintProvider.MAX;
					}
				}
			}
			
			// Handle the remaining features with the linear-time longest path algorithm.
			for (int i = 0; i < bounds.length; i++) {
				if (bounds[i] != IGrammarConstraintProvider.MAX) {
					bounds[i] = computeUpperBound(i, nfa.getStart(), cycles, Maps.newHashMap());
				}
			}
			return bounds;
		}
		
		/**
		 * This longest path algorithm runs in linear time because each cycle is treated as a single node.
		 */
		private int computeUpperBound(int featureId, ISemState node, Map<ISemState, Set<ISemState>> cycles,
				Map<ISemState, Integer> computedDistances) {
			Integer distance = computedDistances.get(node);
			if (distance != null) {
				// We have already visited the given node.
				return distance;
			} else if (cycles.containsKey(node)) {
				// Same procedure as for regular nodes, but consider all outgoing edges of all nodes in the cycle.
				Set<ISemState> cycle = cycles.get(node);
				int maxDistance = 0;
				for (ISemState cycleNode : cycle) {
					for (ISemState follower : cycleNode.getFollowers()) {
						if (!cycle.contains(follower)) {
							int followerDistance = computeUpperBound(featureId, follower, cycles, computedDistances);
							maxDistance = Math.max(maxDistance, followerDistance);
						}
					}
				}
				for (ISemState cycleNode : cycle) {
					computedDistances.put(cycleNode, maxDistance);
				}
				return maxDistance;
			} else {
				// Compute the maximum of all longest paths from any follower to the stop node.
				int increment = node.getFeatureID() == featureId ? 1 : 0;
				int maxDistance = 0;
				for (ISemState follower : node.getFollowers()) {
					int followerDistance = computeUpperBound(featureId, follower, cycles, computedDistances);
					maxDistance = Math.max(maxDistance, followerDistance + increment);
				}
				computedDistances.put(node, maxDistance);
				return maxDistance;
			}
		}
		
		@Override
		public int compareTo(IConstraint o) {
			return getName().compareTo(o.getName());
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			if (this == obj)
				return true;
			return getIdentity().equals(((Constraint) obj).getIdentity());
		}

		@Override
		public IConstraintElement getBody() {
			if (body == UNINITIALIZED) {
				ConstraintElementFactory factory = new ConstraintElementFactory(this);
				NfaToProduction n2p = new NfaToProduction().excludeStartAndStop();
				GrammarElementDeclarationOrder order = GrammarElementDeclarationOrder.get(grammar);
				IConstraintElement element = n2p.nfaToGrammar(nfa, GET_ASSIGNED_GRAMMAR_ELEMENT, order, factory);
				if (element.getType() == GROUP && element.getChildren().isEmpty())
					body = null;
				else
					body = element;
			}
			return body;
		}

		@Override
		public List<ISerializationContext> getContexts() {
			return contexts;
		}

		@Override
		public IFeatureInfo[] getFeatures() {
			if (features == null) {
				if (type == null) {
					features = new IFeatureInfo[0];
				} else {
					int count = type.getFeatureCount();
					features = new IFeatureInfo[count];
					int[] lowerBounds = computeLowerBounds();
					int[] upperBounds = computeUpperBounds();
					for (int i = 0; i < count; i++) {
						EStructuralFeature feature = type.getEStructuralFeature(i);
						features[i] = new FeatureInfo(this, feature, upperBounds[i], lowerBounds[i]);
					}
				}
			}
			return features;

		}

		protected String getIdentity() {
			if (identity == null) {
				String nfaString = new NfaUtil().identityString(nfa, new Function<ISemState, String>() {
					@Override
					public String apply(ISemState input) {
						AbstractElement element = input.getAssignedGrammarElement();
						return element == null ? null : EcoreUtil.getURI(element).toString();
					}
				});
				String typeString = type == null ? "null" : type.getName() + "@" + type.getEPackage().getNsURI();
				identity = typeString + "\n" + nfaString;
			}
			return identity;
		}

		@Override
		public String getName() {
			return name + "_" + (type == null ? "null" : type.getName());
		}

		@Override
		public Nfa<ISemState> getNfa() {
			return nfa;
		}

		@Override
		public String getSimpleName() {
			return name;
		}

		@Override
		public EClass getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return getIdentity().hashCode();
		}

		protected void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			String typeName = getType() == null ? "null" : getType().getName();
			String body = getBody() != null ? getBody().toString() : "{" + typeName + "}";
			return getName() + " returns " + typeName + ": " + body + ";";
		}

	}

	protected static class ConstraintElement implements IGrammarConstraintProvider.IConstraintElement {

		private final Collection<IConstraintElement> children;
		private final IConstraint constraint;

		private final AbstractElement element;

		private final boolean many;

		private final boolean optional;
		private IConstraintElement parent;
		private final ConstraintElementType type;

		public ConstraintElement(IConstraint constraint, ConstraintElementType type, AbstractElement element, boolean many,
				boolean optional) {
			super();
			this.constraint = constraint;
			this.type = type;
			this.element = element;
			this.children = null;
			this.many = many;
			this.optional = optional;
		}

		public ConstraintElement(IConstraint constraint, ConstraintElementType type, Collection<IConstraintElement> children, boolean many,
				boolean optional) {
			super();
			this.constraint = constraint;
			this.type = type;
			this.element = null;
			this.children = children;
			this.many = many;
			this.optional = optional;
			for (IConstraintElement child : children)
				((ConstraintElement) child).parent = this;
		}

		@Override
		public Collection<IConstraintElement> getChildren() {
			return children == null ? Collections.<IConstraintElement> emptyList() : children;
		}

		@Override
		public IConstraintElement getContainer() {
			return parent;
		}

		@Override
		public IConstraint getContainingConstraint() {
			return constraint;
		}

		public String getFeatureName() {
			if (element instanceof Action)
				return ((Action) element).getFeature();
			Assignment assignment = GrammarUtil.containingAssignment(element);
			if (assignment != null)
				return assignment.getFeature();
			return null;
		}

		@Override
		public AbstractElement getGrammarElement() {
			return element;
		}

		@Override
		public ConstraintElementType getType() {
			return type;
		}

		@Override
		public boolean isMany() {
			return many;
		}

		@Override
		public boolean isOptional() {
			return optional;
		}

		@Override
		public String toString() {
			GrammarElementTitleSwitch t2s = new GrammarElementTitleSwitch().hideCardinality().showActionsAsRuleCalls().showAssignments();
			ProductionFormatter<IConstraintElement, AbstractElement> formatter = new ProductionFormatter<IConstraintElement, AbstractElement>();
			formatter.setTokenToString(t2s);
			return formatter.format(new ConstraintElementProduction(getContainingConstraint()), this, true);
		}
	}

	protected static class ConstraintElementFactory implements ProductionFactory<IConstraintElement, AbstractElement> {

		private final IConstraint constraint;

		public ConstraintElementFactory(IConstraint constraint) {
			super();
			this.constraint = constraint;
		}

		@Override
		public IConstraintElement createForAlternativeChildren(boolean m, boolean o, Iterable<IConstraintElement> c) {

			return new ConstraintElement(constraint, ALTERNATIVE, ImmutableSet.copyOf(c), m, o);
		}

		@Override
		public IConstraintElement createForSequentialChildren(boolean m, boolean o, Iterable<IConstraintElement> c) {
			return new ConstraintElement(constraint, GROUP, ImmutableList.copyOf(c), m, o);
		}

		@Override
		public IConstraintElement createForToken(boolean many, boolean optional, AbstractElement token) {
			ConstraintElementType type = token == null ? null : getConstraintElementType(token);
			return new ConstraintElement(constraint, type, token, many, optional);
		}

		@Override
		public IConstraintElement createForUnordertedChildren(boolean m, boolean o, Iterable<IConstraintElement> c) {
			return new ConstraintElement(constraint, UNORDERED_GROUP, ImmutableSet.copyOf(c), m, o);
		}
	}

	protected static class FeatureInfo implements IFeatureInfo {
		private List<IConstraintElement> assignments = null;
		private final Constraint constraint;
		private final EStructuralFeature feature;
		private final int lowerBound;
		private final int upperBound;

		public FeatureInfo(Constraint constraint, EStructuralFeature feature, int upperBound, int lowerBound) {
			super();
			this.constraint = constraint;
			this.feature = feature;
			this.upperBound = upperBound;
			this.lowerBound = lowerBound;
		}

		@Override
		public List<IConstraintElement> getAssignments() {
			if (assignments == null) {
				IConstraintElement body = constraint.getBody();
				if (body == null) {
					assignments = Collections.emptyList();
				} else {
					assignments = Lists.newArrayList();
					LinkedList<IConstraintElement> stack = new LinkedList<IConstraintElement>();
					stack.push(body);
					while (!stack.isEmpty()) {
						IConstraintElement element = stack.pop();
						String name = ((ConstraintElement) element).getFeatureName();
						if (feature.getName().equals(name))
							assignments.add(element);
						stack.addAll(element.getChildren());
					}
				}
			}
			return assignments;
		}

		@Override
		public IConstraint getContainingConstraint() {
			return constraint;
		}

		@Override
		public EStructuralFeature getFeature() {
			return feature;
		}

		@Override
		public int getLowerBound() {
			return lowerBound;
		}

		@Override
		public int getUpperBound() {
			return upperBound;
		}

	}

	private final static IConstraintElement UNINITIALIZED = new ConstraintElement(null, null, (AbstractElement) null, false, false);

	private Map<Grammar, SerializationContextMap<IConstraint>> cache = Maps.newHashMap();

	@Inject
	protected Context2NameFunction context2Name;

	@Inject
	private ISemanticSequencerNfaProvider nfaProvider;

	@Inject
	private IContextTypePDAProvider typeProvider;

	@Inject
	private NfaUtil nfaUtil;

	protected Multimap<Parameter, Boolean> collectAllParameterValues(IConstraint constraint) {
		Set<Parameter> all = Sets.newLinkedHashSet();
		List<ISerializationContext> contexts = constraint.getContexts();
		for (ISerializationContext context : contexts) {
			all.addAll(((SerializationContext) context).getDeclaredParameters());
		}
		Multimap<Parameter, Boolean> values = LinkedHashMultimap.create();
		for (ISerializationContext ctx : contexts) {
			Set<Parameter> params = ctx.getEnabledBooleanParameters();
			for (Parameter param : all)
				values.put(param, params != null && params.contains(param));
		}
		return values;
	}

	protected String findBestConstraintName(Grammar grammar, SerializationContextMap<Pda<ISerState, RuleCall>> typePDAs,
			IConstraint constraint) {
		Set<ParserRule> relevantRules = Sets.newLinkedHashSet();
		Set<Action> relevantActions = Sets.newLinkedHashSet();
		Set<ParserRule> contextRules = Sets.newLinkedHashSet();
		for (ISerializationContext ctx : constraint.getContexts()) {
			ParserRule rule = ctx.getParserRule();
			if (rule != null) {
				contextRules.add(rule);
			}
		}
		// 1. find relevant rules based on assignments 
		for (ISemState s : nfaUtil.collect(constraint.getNfa())) {
			AbstractElement element = s.getAssignedGrammarElement();
			if (element != null)
				relevantRules.add(GrammarUtil.containingParserRule(element));
		}
		// 2. find relevant rules based on unassigned actions
		for (ISerializationContext ctx : constraint.getContexts()) {
			for (ISerState s : nfaUtil.collect(typePDAs.get(ctx))) {
				AbstractElement element = s.getGrammarElement();
				if (element instanceof Action && ((Action) element).getFeature() == null)
					relevantRules.add(GrammarUtil.containingParserRule(element));
			}
		}
		if (relevantRules.isEmpty()) {
			Set<ParserRule> allRules = Sets.newLinkedHashSet(contextRules);
			for (ISerializationContext ctx : constraint.getContexts()) {
				Action action = ctx.getAssignedAction();
				if (action != null)
					allRules.add(GrammarUtil.containingParserRule(action));
			}
			// 3. use all rules, because the constraint returns null.
			relevantRules.addAll(allRules);
		}
		for (ISerializationContext ctx : constraint.getContexts()) {
			Action action = ctx.getAssignedAction();
			if (action != null) {
				ParserRule rule = GrammarUtil.containingParserRule(action);
				if (!contextRules.contains(rule) && relevantRules.contains(rule)) {
					relevantActions.add(action);
				}
			}
		}
		List<String> actions = Lists.newArrayList();
		List<String> rules = Lists.newArrayList();
		Multimap<Parameter, Boolean> parameterValues = collectAllParameterValues(constraint);
		for (Action a : relevantActions)
			actions.add(context2Name.getUniqueActionName(a));
		for (ParserRule rule : relevantRules) {
			StringBuilder segments = new StringBuilder();
			for (Parameter param : rule.getParameters()) {
				Collection<Boolean> values = parameterValues.get(param);
				if (values.size() == 1) {
					segments.append(param.getName() + "$" + values.iterator().next() + "$");
				}
			}
			if (segments.length() == 0) {
				rules.add(rule.getName());
			} else {
				rules.add(rule.getName() + "$" + segments);
			}
		}
		Collections.sort(rules);
		String result = Joiner.on("_").join(rules);
		if (!actions.isEmpty()) {
			Collections.sort(actions);
			result += "_" + Joiner.on('_').join(actions);
		}
		return result;
	}

	@Override
	public SerializationContextMap<IConstraint> getConstraints(Grammar grammar) {
		SerializationContextMap<IConstraint> cached = cache.get(grammar);
		if (cached != null)
			return cached;
		SerializationContextMap.Builder<IConstraint> builder = SerializationContextMap.builder();
		GrammarElementDeclarationOrder.get(grammar);
		SerializationContextMap<Nfa<ISemState>> nfas = nfaProvider.getSemanticSequencerNFAs(grammar);
		for (Entry<Nfa<ISemState>> e : nfas.values()) {
			Nfa<ISemState> nfa = e.getValue();
			for (EClass type : e.getTypes()) {
				Constraint constraint = new Constraint(grammar, type, nfa);
				List<ISerializationContext> contexts = e.getContexts(type);
				constraint.contexts.addAll(contexts);
				builder.put(contexts, constraint);
			}
		}
		SerializationContextMap<IConstraint> result = builder.create();
		SerializationContextMap<Pda<ISerState, RuleCall>> typePDAs = typeProvider.getContextTypePDAs(grammar);
		for (Entry<IConstraint> e : result.values()) {
			Constraint constraint = (Constraint) e.getValue();
			constraint.setName(findBestConstraintName(grammar, typePDAs, constraint));
		}
		cache.put(grammar, result);
		return result;
	}

}
