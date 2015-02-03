/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.io.Files;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaToProduction {

	public static boolean DEBUG_GRAPHVIZ = false;
	public static boolean DEBUG_VALIDATE = false;

	protected static abstract class AbstractElementAlias<T> {
		protected boolean many = false;
		protected boolean optional = false;

		protected AbstractElementAlias() {
		}

		protected AbstractElementAlias(boolean optional, boolean many) {
			super();
			this.optional = optional;
			this.many = many;
		}

		protected abstract int getElementCount();

		protected abstract float getCosts();

		public boolean isMany() {
			return many;
		}

		public boolean isOne() {
			return !optional && !many;
		}

		public boolean isOptional() {
			return optional;
		}

		public void setMany(boolean many) {
			this.many = many;
		}

		public void setOptional(boolean optional) {
			this.optional = optional;
		}

		@Override
		public String toString() {
			Function<Production<AbstractElementAlias<T>, T>, String> formatter = new ProductionFormatter<AbstractElementAlias<T>, T>();
			return formatter.apply(new AliasGrammarProvider<T>(this));
		}

	}

	protected static class AliasGrammarProvider<TOKEN> implements Production<AbstractElementAlias<TOKEN>, TOKEN> {

		protected AbstractElementAlias<TOKEN> root;

		public AliasGrammarProvider(AbstractElementAlias<TOKEN> root) {
			this.root = root;
		}

		@Override
		public Iterable<AbstractElementAlias<TOKEN>> getAlternativeChildren(AbstractElementAlias<TOKEN> ele) {
			return ele instanceof AlternativeAlias ? ((AlternativeAlias<TOKEN>) ele).getChildren() : null;
		}

		@Override
		public AbstractElementAlias<TOKEN> getParent(AbstractElementAlias<TOKEN> ele) {
			return null;
		}

		@Override
		public AbstractElementAlias<TOKEN> getRoot() {
			return root;
		}

		@Override
		public Iterable<AbstractElementAlias<TOKEN>> getSequentialChildren(AbstractElementAlias<TOKEN> ele) {
			return ele instanceof GroupAlias ? ((GroupAlias<TOKEN>) ele).getChildren() : null;
		}

		@Override
		public TOKEN getToken(AbstractElementAlias<TOKEN> owner) {
			return owner instanceof ElementAlias ? ((ElementAlias<TOKEN>) owner).getElement() : null;
		}

		@Override
		public Iterable<AbstractElementAlias<TOKEN>> getUnorderedChildren(AbstractElementAlias<TOKEN> ele) {
			return null;
		}

		@Override
		public boolean isMany(AbstractElementAlias<TOKEN> ele) {
			return ele.isMany();
		}

		@Override
		public boolean isOptional(AbstractElementAlias<TOKEN> ele) {
			return ele.isOptional();
		}
	}

	protected static class AlternativeAlias<T> extends AbstractElementAlias<T> {
		protected Set<AbstractElementAlias<T>> children = Sets.newLinkedHashSet();

		public AlternativeAlias() {
			super();
		}

		public AlternativeAlias(boolean optional, boolean many, AbstractElementAlias<T>... children) {
			super(optional, many);
			Collections.addAll(this.children, children);
		}

		public void addChild(AbstractElementAlias<T> child) {
			if (child == this)
				throw new RuntimeException();
			children.add(child);
		}

		public Set<AbstractElementAlias<T>> getChildren() {
			return children;
		}

		@Override
		protected int getElementCount() {
			int result = 1;
			for (AbstractElementAlias<T> child : children)
				result += child.getElementCount();
			return result;
		}

		@Override
		public int hashCode() {
			return children.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass())
				return false;
			return children.equals(((AlternativeAlias<?>) obj).children);
		}

		@Override
		protected float getCosts() {
			float result = 1;
			for (AbstractElementAlias<T> child : children)
				result += child.getCosts();
			return result * 1.2f;
		}

	}

	protected static class ElementAlias<T> extends AbstractElementAlias<T> {
		protected T element;

		public ElementAlias(boolean optional, boolean many, T element) {
			super(optional, many);
			this.element = element;
		}

		public ElementAlias(T element) {
			super();
			this.element = element;
		}

		public T getElement() {
			return element;
		}

		@Override
		protected int getElementCount() {
			return 1;
		}

		@Override
		public int hashCode() {
			return element == null ? 0 : element.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass())
				return false;
			return Objects.equal(element, ((ElementAlias<?>) obj).element);
		}

		@Override
		protected float getCosts() {
			return 1.0f;
		}

	}

	protected static class GroupAlias<T> extends AbstractElementAlias<T> {
		protected List<AbstractElementAlias<T>> children = Lists.newArrayList();

		public GroupAlias() {
			super();
		}

		public GroupAlias(boolean optional, boolean many, AbstractElementAlias<T>... children) {
			super(optional, many);
			Collections.addAll(this.children, children);
		}

		public void addChild(AbstractElementAlias<T> child) {
			if (child == this)
				throw new RuntimeException();
			children.add(child);
		}

		public List<AbstractElementAlias<T>> getChildren() {
			return children;
		}

		@Override
		protected int getElementCount() {
			int result = 1;
			for (AbstractElementAlias<T> child : children)
				result += child.getElementCount();
			return result;
		}

		@Override
		public int hashCode() {
			return children.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass())
				return false;
			return children.equals(((GroupAlias<?>) obj).children);
		}

		@Override
		protected float getCosts() {
			float result = 1;
			for (AbstractElementAlias<T> child : children)
				result += child.getCosts();
			return result * 1.2f;
		}
	}

	protected static class StateAlias<TOKEN> {
		protected AbstractElementAlias<TOKEN> element;
		protected Set<StateAlias<TOKEN>> incoming = Sets.newLinkedHashSet();
		protected Set<StateAlias<TOKEN>> outgoing = Sets.newLinkedHashSet();
		protected final StateAliasNfa<TOKEN> nfa;

		protected StateAlias(StateAliasNfa<TOKEN> nfa, AbstractElementAlias<TOKEN> element) {
			super();
			this.nfa = nfa;
			this.element = element;
		}

		protected boolean isStartOrStop() {
			return this == nfa.start || this == nfa.stop;
		}

		public void absorbIncoming(StateAlias<TOKEN> state) {
			for (StateAlias<TOKEN> in : state.incoming) {
				in.outgoing.remove(state);
				in.outgoing.add(this);
				incoming.add(in);
			}
		}

		public void absorbOutgoing(StateAlias<TOKEN> state) {
			for (StateAlias<TOKEN> out : state.outgoing) {
				out.incoming.remove(state);
				out.incoming.add(this);
				outgoing.add(out);
			}
		}

		public void addOutgoing(StateAlias<TOKEN> state) {
			outgoing.add(state);
			state.incoming.add(this);
		}

		protected AbstractElementAlias<TOKEN> getElement() {
			return element;
		}

		protected Set<StateAlias<TOKEN>> getIncoming() {
			return incoming;
		}

		protected Set<StateAlias<TOKEN>> getOutgoing() {
			return outgoing;
		}

		@Override
		public String toString() {
			return "S(" + element + ")";
		}

	}

	protected static class StateAliasNfa<TOKEN> implements Nfa<StateAlias<TOKEN>>, Comparable<StateAliasNfa<TOKEN>> {
		protected final StateAlias<TOKEN> start;
		protected final StateAlias<TOKEN> stop;
		private final int id;

		public StateAliasNfa(int id, AbstractElementAlias<TOKEN> start, AbstractElementAlias<TOKEN> stop) {
			super();
			this.id = id;
			this.start = new StateAlias<TOKEN>(this, start);
			this.stop = new StateAlias<TOKEN>(this, stop);
		}

		@SuppressWarnings("unchecked")
		protected AbstractElementAlias<TOKEN> toSolution() {
			if (start.getOutgoing().size() != 1 || stop.getIncoming().size() != 1)
				return null;
			StateAlias<TOKEN> middle = start.getOutgoing().iterator().next();
			if (middle == stop.getIncoming().iterator().next()) {
				if (middle.getIncoming().size() != 1 || middle.getOutgoing().size() != 1)
					return null;
				return new GroupAlias<TOKEN>(false, false, start.getElement(), middle.getElement(), stop.getElement());
			} else if (middle == stop) {
				return new GroupAlias<TOKEN>(false, false, start.getElement(), stop.getElement());
			}
			return null;
		}

		protected Map<StateAlias<TOKEN>, StateAlias<TOKEN>> createCloneMap(int newID) {
			Map<StateAlias<TOKEN>, StateAlias<TOKEN>> oldToNew = Maps.newHashMap();
			StateAliasNfa<TOKEN> result = new StateAliasNfa<TOKEN>(newID, start.getElement(), stop.getElement());
			oldToNew.put(start, result.getStart());
			oldToNew.put(stop, result.getStop());
			Set<StateAlias<TOKEN>> allStates = getAllStates();
			for (StateAlias<TOKEN> state : allStates)
				if (!state.isStartOrStop())
					oldToNew.put(state, new StateAlias<TOKEN>(result, state.getElement()));
			for (StateAlias<TOKEN> oldState : allStates) {
				StateAlias<TOKEN> newState = oldToNew.get(oldState);
				for (StateAlias<TOKEN> oldOut : oldState.getOutgoing()) {
					StateAlias<TOKEN> newOut = oldToNew.get(oldOut);
					newState.getOutgoing().add(newOut);
					newOut.getIncoming().add(newState);
				}
			}
			return oldToNew;
		}

		protected Pair<AbstractElementAlias<TOKEN>, AbstractElementAlias<TOKEN>> leading(AbstractElementAlias<TOKEN> t) {
			if (t instanceof GroupAlias<?>) {
				List<AbstractElementAlias<TOKEN>> children = ((GroupAlias<TOKEN>) t).getChildren();
				GroupAlias<TOKEN> g1 = new GroupAlias<TOKEN>();
				GroupAlias<TOKEN> g2 = new GroupAlias<TOKEN>();
				boolean loop = true;
				for (AbstractElementAlias<TOKEN> child : children) {
					loop &= child.isMany();
					if (loop)
						g1.getChildren().add(child);
					else
						g2.getChildren().add(child);
				}
				if (!g1.getChildren().isEmpty()) {
					AbstractElementAlias<TOKEN> r1 = g1.getChildren().size() == 1 ? g1.getChildren().get(0) : g1;
					AbstractElementAlias<TOKEN> r2 = g2.getChildren().size() == 1 ? g2.getChildren().get(0) : g2;
					return Tuples.create(r1, r2);
				}
			}
			return Tuples.create(null, t);
		}

		protected Pair<AbstractElementAlias<TOKEN>, AbstractElementAlias<TOKEN>> trailing(AbstractElementAlias<TOKEN> t) {
			if (t instanceof GroupAlias<?>) {
				List<AbstractElementAlias<TOKEN>> children = ((GroupAlias<TOKEN>) t).getChildren();
				GroupAlias<TOKEN> g1 = new GroupAlias<TOKEN>();
				GroupAlias<TOKEN> g2 = new GroupAlias<TOKEN>();
				boolean loop = true;
				for (int i = children.size(); i >= 0; i--) {
					AbstractElementAlias<TOKEN> child = children.get(0);
					loop &= child.isMany();
					if (loop)
						g2.getChildren().add(child);
					else
						g1.getChildren().add(child);
				}
				Collections.reverse(g1.children);
				Collections.reverse(g2.children);
				if (!g2.getChildren().isEmpty()) {
					AbstractElementAlias<TOKEN> r1 = g1.getChildren().size() == 1 ? g1.getChildren().get(0) : g1;
					AbstractElementAlias<TOKEN> r2 = g2.getChildren().size() == 1 ? g2.getChildren().get(0) : g2;
					return Tuples.create(r1, r2);
				}
			}
			return Tuples.create(t, null);
		}

		protected StateAliasNfa<TOKEN> cloneAndSplitOutgoing(StateAlias<TOKEN> toSplit, StateAlias<TOKEN> out, int newID) {
			Map<StateAlias<TOKEN>, StateAlias<TOKEN>> oldToNew = createCloneMap(newID);
			StateAlias<TOKEN> newToSplit = oldToNew.get(toSplit);
			StateAlias<TOKEN> newOut = oldToNew.get(out);
			StateAliasNfa<TOKEN> result = newToSplit.nfa;
			Pair<AbstractElementAlias<TOKEN>, AbstractElementAlias<TOKEN>> leading = leading(toSplit.getElement());
			AbstractElementAlias<TOKEN> loop = leading.getFirst();
			AbstractElementAlias<TOKEN> body = leading.getSecond();
			newToSplit.getOutgoing().remove(newOut);
			newOut.getIncoming().remove(newToSplit);
			if (loop == null) {
				StateAlias<TOKEN> newBody = new StateAlias<TOKEN>(result, body);
				for (StateAlias<TOKEN> oldIn : toSplit.getIncoming()) {
					StateAlias<TOKEN> newIn = oldToNew.get(oldIn);
					newBody.getIncoming().add(newIn);
					newIn.getOutgoing().add(newBody);
				}
				newBody.getOutgoing().add(newOut);
				newOut.getIncoming().add(newBody);
			} else {
				StateAlias<TOKEN> newLoop = new StateAlias<TOKEN>(result, loop);
				StateAlias<TOKEN> newBody1 = new StateAlias<TOKEN>(result, body);
				StateAlias<TOKEN> newBody2 = new StateAlias<TOKEN>(result, body);
				for (StateAlias<TOKEN> oldIn : toSplit.getIncoming()) {
					StateAlias<TOKEN> newIn = oldToNew.get(oldIn);
					newLoop.getIncoming().add(newIn);
					newIn.getOutgoing().add(newLoop);
					newIn.getOutgoing().remove(newToSplit);
				}
				newToSplit.getIncoming().clear();
				for (StateAlias<TOKEN> oldOut : toSplit.getOutgoing()) {
					StateAlias<TOKEN> newO = oldToNew.get(oldOut);
					if (oldOut != out) {
						newBody2.getOutgoing().add(newO);
						newO.getIncoming().add(newBody2);
					}
					newO.getIncoming().remove(newToSplit);
				}
				newToSplit.getOutgoing().clear();
				newLoop.getOutgoing().add(newBody1);
				newBody1.getIncoming().add(newLoop);
				newLoop.getOutgoing().add(newBody2);
				newBody2.getIncoming().add(newLoop);
				newBody1.getOutgoing().add(newOut);
				newOut.getIncoming().add(newBody1);
			}
			result.forceValidOnDebug();
			return result;
		}

		protected StateAliasNfa<TOKEN> cloneAndSplitIncoming(StateAlias<TOKEN> toSplit, StateAlias<TOKEN> in, int newID) {
			Map<StateAlias<TOKEN>, StateAlias<TOKEN>> oldToNew = createCloneMap(newID);
			StateAlias<TOKEN> newToSplit = oldToNew.get(toSplit);
			StateAlias<TOKEN> newIn = oldToNew.get(in);
			StateAliasNfa<TOKEN> result = newToSplit.nfa;
			Pair<AbstractElementAlias<TOKEN>, AbstractElementAlias<TOKEN>> trailing = trailing(toSplit.getElement());
			AbstractElementAlias<TOKEN> body = trailing.getFirst();
			AbstractElementAlias<TOKEN> loop = trailing.getSecond();
			newToSplit.getIncoming().remove(newIn);
			newIn.getOutgoing().remove(newToSplit);
			if (loop == null) {
				StateAlias<TOKEN> newBody = new StateAlias<TOKEN>(result, body);
				for (StateAlias<TOKEN> oldOut : toSplit.getOutgoing()) {
					StateAlias<TOKEN> newOut = oldToNew.get(oldOut);
					newBody.getOutgoing().add(newOut);
					newOut.getIncoming().add(newBody);
				}
				newBody.getIncoming().add(newIn);
				newIn.getOutgoing().add(newBody);
			} else {
				StateAlias<TOKEN> newBody1 = new StateAlias<TOKEN>(result, body);
				StateAlias<TOKEN> newBody2 = new StateAlias<TOKEN>(result, body);
				StateAlias<TOKEN> newLoop = new StateAlias<TOKEN>(result, loop);
				for (StateAlias<TOKEN> oldOut : toSplit.getOutgoing()) {
					StateAlias<TOKEN> newOut = oldToNew.get(oldOut);
					newLoop.getOutgoing().add(newOut);
					newOut.getIncoming().add(newLoop);
					newOut.getIncoming().remove(newToSplit);
				}
				newToSplit.getOutgoing().clear();
				for (StateAlias<TOKEN> oldIn : toSplit.getIncoming()) {
					StateAlias<TOKEN> newI = oldToNew.get(oldIn);
					if (oldIn != in) {
						newBody2.getIncoming().add(newI);
						newI.getOutgoing().add(newBody2);
					}
					newI.getOutgoing().remove(newToSplit);
				}
				newToSplit.getIncoming().clear();
				newLoop.getIncoming().add(newBody1);
				newBody1.getOutgoing().add(newLoop);
				newLoop.getIncoming().add(newBody2);
				newBody2.getOutgoing().add(newLoop);
				newBody1.getIncoming().add(newIn);
				newIn.getOutgoing().add(newBody1);
			}
			result.forceValidOnDebug();
			return result;
		}

		public int getCosts() {
			float result = 0;
			for (StateAlias<TOKEN> state : getAllStates())
				result += state.getElement().getElementCount();
			//				result += state.getElement().getCosts();
			return (int) result;
		}

		public Set<StateAlias<TOKEN>> getAllStates() {
			Set<StateAlias<TOKEN>> result = Sets.newHashSet();
			collectStatesViaOutgoing(start, result);
			return result;
		}

		public Set<StateAlias<TOKEN>> getAllStatesExceptStartAndStop() {
			Set<StateAlias<TOKEN>> result = getAllStates();
			result.remove(start);
			result.remove(stop);
			return result;
		}

		protected void collectStatesViaOutgoing(StateAlias<TOKEN> state, Set<StateAlias<TOKEN>> result) {
			if (!result.add(state))
				return;
			for (StateAlias<TOKEN> out : state.getOutgoing())
				collectStatesViaOutgoing(out, result);
		}

		protected void collectStatesViaIncoming(StateAlias<TOKEN> state, Set<StateAlias<TOKEN>> result) {
			if (!result.add(state))
				return;
			for (StateAlias<TOKEN> in : state.getIncoming())
				collectStatesViaIncoming(in, result);
		}

		public void dumpAsGraphvizDot(String nameHint) {
			Function<NfaToProduction.StateAlias<TOKEN>, String> stateFormatter = new Function<NfaToProduction.StateAlias<TOKEN>, String>() {
				@Override
				public String apply(StateAlias<TOKEN> input) {
					return input.getElement().toString();
				}
			};
			String folder = "./" + getClass().getSimpleName() + "/";
			String numberOfStates = String.valueOf(getAllStates().size());
			File file = new File(folder + nameHint + "_" + numberOfStates + ".dot");
			File parent = file.getParentFile();
			if (!parent.exists() && !parent.mkdirs())
				throw new RuntimeException("Could not create folder " + parent);
			try {
				System.out.println("Writing " + file);
				String dot = new NfaToDot<StateAlias<TOKEN>>().setStateFormatter(stateFormatter).draw(this);
				Files.write(dot, file, Charsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public Iterable<StateAlias<TOKEN>> getFollowers(StateAlias<TOKEN> state) {
			return state.getOutgoing();
		}

		@Override
		public int hashCode() {
			int result = 31;
			for (StateAlias<TOKEN> state : getAllStates())
				result *= state.element.hashCode();
			return result;
		}

		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass())
				return false;
			return equals(getStart(), ((StateAliasNfa<TOKEN>) obj).getStart(), Sets.<StateAlias<TOKEN>> newHashSet());
		}

		protected boolean equals(StateAlias<TOKEN> s1, StateAlias<TOKEN> s2, Set<StateAlias<TOKEN>> visited) {
			if (!Objects.equal(s1.getElement(), s2.getElement()))
				return false;
			if (!visited.add(s1))
				return true;
			LinkedList<StateAlias<TOKEN>> copy = Lists.newLinkedList(s2.getOutgoing());
			for (StateAlias<TOKEN> out1 : s1.getOutgoing()) {
				Iterator<StateAlias<TOKEN>> iterator = copy.iterator();
				while (iterator.hasNext()) {
					StateAlias<TOKEN> next = iterator.next();
					if (Objects.equal(out1.element, next.element)
							&& out1.getOutgoing().size() == next.getOutgoing().size()) {
						iterator.remove();
						if (!equals(out1, next, visited))
							return false;
					} else
						return false;
				}
			}
			return true;
		}

		@Override
		public StateAlias<TOKEN> getStart() {
			return start;
		}

		@Override
		public StateAlias<TOKEN> getStop() {
			return stop;
		}

		public void forceValidOnDebug() {
			if (!DEBUG_VALIDATE || toSolution() != null)
				return;
			List<String> issues = validate();
			if (issues.isEmpty())
				return;
			throw new RuntimeException("Invalid NFA: \n" + Joiner.on("\n").join(issues));
		}

		public List<String> validate() {
			List<String> result = Lists.newArrayList();
			Set<StateAlias<TOKEN>> starts = Sets.newLinkedHashSet();
			Set<StateAlias<TOKEN>> stops = Sets.newLinkedHashSet();
			collectStatesViaOutgoing(start, starts);
			collectStatesViaIncoming(stop, stops);
			for (StateAlias<TOKEN> s : Sets.difference(starts, stops))
				result.add("The state " + s + "can not be reached from stop.");
			for (StateAlias<TOKEN> s : Sets.difference(stops, starts))
				result.add("The state " + s + "can not be reached from start.");
			for (StateAlias<TOKEN> s : Sets.union(starts, stops)) {
				if (s.nfa != this)
					result.add("The state doens't belong to this NFA: " + s);
				if (s.getElement() == null && !s.isStartOrStop())
					result.add("Element is null for " + s);
				for (StateAlias<TOKEN> out : s.getOutgoing())
					if (!out.getIncoming().contains(s))
						result.add("The state " + s + " has an outgoing edge to " + out
								+ " but the reverse edge is missing.");
				for (StateAlias<TOKEN> in : s.getIncoming())
					if (!in.getOutgoing().contains(s))
						result.add("The state " + s + " has an incoming edge to " + in
								+ " but the reverse edge is missing.");
			}
			return result;
		}

		@Override
		public String toString() {
			List<String> errors = validate();
			List<String> result = Lists.newArrayList();
			if (errors.isEmpty())
				result.add("Validation: OK");
			else {
				result.add("Validation: ERRORS:");
				result.addAll(errors);
			}
			result.add("ElementCount:" + getCosts());
			result.add(new NfaGraphFormatter().format(this));
			return Joiner.on("\n").join(result);
		}

		@Override
		public int compareTo(StateAliasNfa<TOKEN> o) {
			int countDiff = getCosts() - o.getCosts();
			if (countDiff != 0)
				return countDiff;
			return id - o.id;
		}
	}

	protected <T> boolean createAlternative(StateAliasNfa<T> states) {
		boolean created = false;
		Multimap<Pair<Set<StateAlias<T>>, Set<StateAlias<T>>>, StateAlias<T>> alternative = LinkedHashMultimap.create();

		for (StateAlias<T> candidate : new NfaUtil().collect(states))
			if (!candidate.getIncoming().isEmpty() && !candidate.getOutgoing().isEmpty())
				alternative.put(Tuples.create(candidate.getIncoming(), candidate.getOutgoing()), candidate);

		for (Pair<Set<StateAlias<T>>, Set<StateAlias<T>>> inout : alternative.keySet()) {
			Collection<StateAlias<T>> candidates = alternative.get(inout);

			if (candidates.size() < 2)
				continue;

			boolean many = inout.getFirst().containsAll(candidates) && inout.getSecond().containsAll(candidates);
			boolean single = !Iterables.any(inout.getFirst(), Predicates.in(candidates))
					&& !Iterables.any(inout.getSecond(), Predicates.in(candidates));
			if (!many && !single)
				continue;

			AlternativeAlias<T> alt = new AlternativeAlias<T>();
			alt.setMany(many);
			StateAlias<T> altState = new StateAlias<T>(states, alt);
			for (StateAlias<T> candidate : candidates) {
				alt.addChild(candidate.getElement());
				for (StateAlias<T> in : candidate.getIncoming())
					in.getOutgoing().remove(candidate);
				for (StateAlias<T> out : candidate.getOutgoing())
					out.getIncoming().remove(candidate);
			}
			for (StateAlias<T> in : inout.getFirst())
				if (!candidates.contains(in)) {
					altState.getIncoming().add(in);
					in.getOutgoing().add(altState);
				}
			for (StateAlias<T> out : inout.getSecond())
				if (!candidates.contains(out)) {
					altState.getOutgoing().add(out);
					out.getIncoming().add(altState);
				}
			created = true;
			states.forceValidOnDebug();
		}
		return created;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T> void createGroup(StateAlias<T> first, StateAlias<T> second) {
		GroupAlias<T> group = new GroupAlias<T>();
		if (first.getElement() instanceof GroupAlias && first.getElement().isOne())
			group.getChildren().addAll(((GroupAlias) first.getElement()).getChildren());
		else
			group.addChild(first.getElement());
		if (second.getElement() instanceof GroupAlias && second.getElement().isOne())
			group.getChildren().addAll(((GroupAlias) second.getElement()).getChildren());
		else
			group.addChild(second.getElement());
		first.element = group;
		first.getOutgoing().clear();
		first.absorbOutgoing(second);
		first.nfa.forceValidOnDebug();
	}

	protected <T> boolean createGroups(StateAlias<T> state, Set<StateAlias<T>> visited) {
		if (!visited.add(state))
			return false;
		boolean created = false;
		if (state.getOutgoing().size() == 1 && state.getOutgoing().iterator().next().getIncoming().size() == 1) {
			StateAlias<T> follower = state.getOutgoing().iterator().next();
			if (state != follower && !state.isStartOrStop() && !follower.isStartOrStop()) {
				createGroup(state, follower);
				created = true;
			}
		}
		for (StateAlias<T> out : state.getOutgoing()) {
			if (createGroups(out, visited))
				created = true;
		}
		return created;
	}

	protected <T> boolean createMany(StateAlias<T> state, Set<StateAlias<T>> visited) {
		if (!visited.add(state))
			return false;
		boolean created = false;
		if (state.getOutgoing().contains(state)) {
			state.getElement().setMany(true);
			state.getOutgoing().remove(state);
			state.getIncoming().remove(state);
			created = true;
		}
		state.nfa.forceValidOnDebug();
		for (StateAlias<T> out : state.getOutgoing()) {
			if (createMany(out, visited))
				created = true;
		}
		return created;
	}

	protected <T> boolean mergeOptionalIntoMany(StateAlias<T> state, Set<StateAlias<T>> visited) {
		if (!visited.add(state))
			return false;
		boolean merged = false;
		if (state.getElement().isMany()) {
			for (StateAlias<T> out : ImmutableList.copyOf(state.getOutgoing())) {
				if (state.getIncoming().contains(out) && isOptionalIgnoring(out, state)) {
					mergeOptionalIntoMany(state, out);
					merged = true;
				}
			}
			for (StateAlias<T> in : ImmutableList.copyOf(state.getIncoming())) {
				if (state.getOutgoing().contains(in) && isOptionalIgnoring(in, state)) {
					mergeOptionalIntoMany(in, state);
					merged = true;
				}
			}
		}
		for (StateAlias<T> out : ImmutableList.copyOf(state.getOutgoing())) {
			if (mergeOptionalIntoMany(out, visited))
				merged = true;
		}
		return merged;
	}

	protected <T> boolean isOptionalIgnoring(StateAlias<T> cand, StateAlias<T> ignored) {
		if (cand.getIncoming().isEmpty() || cand.getOutgoing().isEmpty())
			return false;
		for (StateAlias<T> in : cand.getIncoming())
			if (!in.equals(ignored) && !in.getOutgoing().containsAll(cand.getOutgoing()))
				return false;
		//		for (StateAlias<T> out : cand.getOutgoing())
		//			if (!out.equals(ignored) && !ignored.getOutgoing().contains(out))
		//				return false;
		return true;
	}

	protected <T> void mergeOptionalIntoMany(StateAlias<T> first, StateAlias<T> second) {
		StateAlias<T> many = first.element.isMany() ? first : second;
		StateAlias<T> optional = many == first ? second : first;
		if (optional.getOutgoing().contains(optional)) {
			optional.element.setMany(true);
		}
		many.element.setMany(false);
		optional.element.setOptional(true);
		for (StateAlias<T> out : ImmutableList.copyOf(optional.getOutgoing())) {
			out.getIncoming().remove(optional);
			optional.getOutgoing().remove(out);
		}
		for (StateAlias<T> in : ImmutableList.copyOf(optional.getIncoming())) {
			in.getOutgoing().remove(optional);
			optional.getIncoming().remove(in);
		}
		GroupAlias<T> group = new GroupAlias<T>();
		group.setMany(true);
		if (first.element instanceof GroupAlias<?> && !first.element.many && !first.element.optional) {
			group.children.addAll(((GroupAlias<T>) first.element).children);
		} else {
			group.addChild(first.getElement());
		}
		if (second.element instanceof GroupAlias<?> && !second.element.many && !second.element.optional) {
			group.children.addAll(((GroupAlias<T>) second.element).children);
		} else {
			group.addChild(second.element);
		}
		many.element = group;
		first.nfa.forceValidOnDebug();
	}

	protected <T> boolean mergeAlternativeMultiples(StateAlias<T> state, Set<StateAlias<T>> visited) {
		if (!visited.add(state))
			return false;
		boolean merged = false;

		if (state.getElement().isMany()) {
			for (StateAlias<T> out : ImmutableList.copyOf(state.getOutgoing())) {
				if (areAlternativeMultiples(state, out)) {
					mergeAlternativeMultiples(state, out);
					merged = true;
				}
			}
		}

		for (StateAlias<T> out : ImmutableList.copyOf(state.getOutgoing())) {
			if (mergeAlternativeMultiples(out, visited))
				merged = true;
		}
		return merged;
	}

	protected <T> boolean areAlternativeMultiples(StateAlias<T> first, StateAlias<T> second) {
		if (!first.getElement().isMany() || !second.getElement().isMany())
			return false;
		if (!first.getOutgoing().contains(second) || !first.getIncoming().contains(second))
			return false;

		for (StateAlias<T> in : first.getIncoming()) {
			if (!in.equals(second) && !second.getIncoming().contains(in))
				return false;
		}
		for (StateAlias<T> out : first.getOutgoing()) {
			if (!out.equals(second) && !second.getOutgoing().contains(out))
				return false;
		}
		return true;
	}

	protected class Counter {
		private int value = 0;

		public int getAndInc() {
			return value++;
		}
	}

	protected <T> void mergeAlternativeMultiples(StateAlias<T> first, StateAlias<T> second) {
		first.element.many = false;
		second.element.many = false;
		AlternativeAlias<T> alternative = new AlternativeAlias<T>();
		alternative.many = true;
		if (first.element instanceof AlternativeAlias<?>) {
			alternative.getChildren().addAll(((AlternativeAlias<T>) first.element).children);
		} else {
			alternative.addChild(first.getElement());
		}
		if (second.element instanceof AlternativeAlias<?>) {
			alternative.getChildren().addAll(((AlternativeAlias<T>) second.element).children);
		} else {
			alternative.addChild(second.element);
		}
		if (first.element.optional || second.element.optional) {
			alternative.optional = true;
		}
		first.element = alternative;
		for (StateAlias<T> out : second.getOutgoing()) {
			out.getIncoming().remove(second);
		}
		for (StateAlias<T> in : second.getIncoming()) {
			in.getOutgoing().remove(second);
		}
		first.nfa.forceValidOnDebug();
	}

	protected <STATE, TOKEN> StateAliasNfa<TOKEN> createNfa(Nfa<STATE> nfa, Function<STATE, TOKEN> state2token) {
		HashMap<STATE, StateAlias<TOKEN>> cache = Maps.<STATE, StateAlias<TOKEN>> newLinkedHashMap();
		ElementAlias<TOKEN> start = new ElementAlias<TOKEN>(state2token.apply(nfa.getStart()));
		boolean same = nfa.getStart() == nfa.getStop();
		ElementAlias<TOKEN> stop = same ? start : new ElementAlias<TOKEN>(state2token.apply(nfa.getStop()));
		StateAliasNfa<TOKEN> states = new StateAliasNfa<TOKEN>(0, start, stop);
		cache.put(nfa.getStart(), states.getStart());
		if (!same)
			cache.put(nfa.getStop(), states.getStop());
		StateAlias<TOKEN> newStart = states.getStart();
		for (STATE s : nfa.getFollowers(nfa.getStart())) {
			StateAlias<TOKEN> alias = toAlias(states, nfa, state2token, s, cache);
			newStart.getOutgoing().add(alias);
			alias.getIncoming().add(newStart);
		}
		if (same) {
			StateAlias<TOKEN> newStop = states.getStop();
			for (StateAlias<TOKEN> in : newStart.getIncoming()) {
				newStop.getIncoming().add(in);
				in.getOutgoing().add(newStop);
				in.getOutgoing().remove(newStart);
			}
			newStart.getIncoming().clear();
		}
		states.forceValidOnDebug();
		return states;
	}

	protected <T> boolean createOptional(StateAliasNfa<T> states) {
		List<StateAlias<T>> opt = Lists.newArrayList();
		L: for (StateAlias<T> cand : new NfaUtil().collect(states)) {
			if (cand.getIncoming().isEmpty() || cand.getOutgoing().isEmpty())
				continue L;
			for (StateAlias<T> in : cand.getIncoming())
				if (!in.getOutgoing().containsAll(cand.getOutgoing()))
					continue L;
			opt.add(cand);
		}
		for (StateAlias<T> o : opt) {
			o.getElement().setOptional(true);
			for (StateAlias<T> in : Lists.newArrayList(o.getIncoming()))
				if (in != o)
					for (StateAlias<T> out : Lists.newArrayList(o.getOutgoing()))
						if (out != o) {
							out.getIncoming().remove(in);
							in.getOutgoing().remove(out);
						}
			states.forceValidOnDebug();
		}
		return !opt.isEmpty();
	}

	protected <T> List<StateAliasNfa<T>> cloneAndSplitListsWithSeparator(StateAliasNfa<T> nfa, Counter counter) {
		List<Pair<StateAlias<T>, StateAlias<T>>> loops = findLoops(nfa);
		List<StateAliasNfa<T>> result = Lists.newArrayList();
		for (Pair<StateAlias<T>, StateAlias<T>> loop : loops) {
			result.addAll(cloneAndSplit(nfa, loop.getFirst(), counter));
			result.addAll(cloneAndSplit(nfa, loop.getSecond(), counter));
		}
		return result;
	}

	protected <T> List<Pair<StateAlias<T>, StateAlias<T>>> findLoops(StateAliasNfa<T> nfa) {
		List<Pair<StateAlias<T>, StateAlias<T>>> result = Lists.newArrayList();
		Set<StateAlias<T>> visited = Sets.newHashSet();
		for (StateAlias<T> state : nfa.getAllStates())
			for (StateAlias<T> out : state.getOutgoing())
				if (out.getOutgoing().contains(state)) {
					if (!visited.contains(state) && !visited.contains(out)) {
						result.add(Tuples.create(state, out));
						visited.add(state);
						visited.add(out);
					}
				}
		return result;
	}

	protected <T> Pair<Integer, StateAlias<T>> findSplitState(StateAlias<T> state, Integer depth,
			Set<StateAlias<T>> visited) {
		if (!visited.add(state))
			return null;
		Pair<Integer, StateAlias<T>> result;
		if (state.getOutgoing().size() > 0 && state.getIncoming().size() > 0
				&& state.getOutgoing().size() + state.getIncoming().size() > 2)
			result = Tuples.create(depth, state);
		else
			result = null;
		for (StateAlias<T> out : state.getOutgoing()) {
			Pair<Integer, StateAlias<T>> cand = findSplitState(out, depth + 1, visited);
			if (cand != null && (result == null || isPreferredSplitState(cand, result)))
				result = cand;
		}
		return result;
	}

	protected <T> boolean isPreferredSplitState(Pair<Integer, StateAlias<T>> state1, Pair<Integer, StateAlias<T>> state2) {
		int count1 = state1.getSecond().getElement().getElementCount();
		int count2 = state2.getSecond().getElement().getElementCount();
		if (count1 != count2)
			return count1 < count2;
		int size1 = state1.getSecond().getOutgoing().size() + state1.getSecond().getIncoming().size();
		int size2 = state2.getSecond().getOutgoing().size() + state2.getSecond().getIncoming().size();
		if (size1 != size2)
			return size1 < size2;
		return state1.getFirst() > state2.getFirst();
	}

	protected <T> List<StateAliasNfa<T>> cloneAndSplit(StateAliasNfa<T> nfa, Counter counter) {
		List<StateAliasNfa<T>> result = Lists.newArrayList();
		for (StateAlias<T> state : nfa.getAllStates())
			result.addAll(cloneAndSplit(nfa, state, counter));
		return result;
	}

	protected <T> List<StateAliasNfa<T>> cloneAndSplit(StateAliasNfa<T> nfa, StateAlias<T> state, Counter counter) {
		if (state.isStartOrStop())
			return Collections.emptyList();
		List<StateAliasNfa<T>> result = Lists.newArrayList();
		if (state.getOutgoing().size() == 2)
			result.add(nfa.cloneAndSplitOutgoing(state, state.getOutgoing().iterator().next(), counter.getAndInc()));
		else if (state.getOutgoing().size() >= 2)
			for (StateAlias<T> out : state.getOutgoing())
				result.add(nfa.cloneAndSplitOutgoing(state, out, counter.getAndInc()));
		if (state.getIncoming().size() == 2)
			result.add(nfa.cloneAndSplitIncoming(state, state.getIncoming().iterator().next(), counter.getAndInc()));
		else if (state.getIncoming().size() >= 2)
			for (StateAlias<T> in : state.getIncoming())
				result.add(nfa.cloneAndSplitIncoming(state, in, counter.getAndInc()));
		return result;
	}

	public <ELEMENT, STATE, TOKEN> ELEMENT nfaToGrammar(Nfa<STATE> nfa, Function<STATE, TOKEN> state2token,
			ProductionFactory<ELEMENT, TOKEN> grammarFactory) {
		StateAliasNfa<TOKEN> first = createNfa(nfa, state2token);
		if (DEBUG_GRAPHVIZ)
			first.dumpAsGraphvizDot("initial");
		mergeStatesIntoElements(first);
		Set<StateAliasNfa<TOKEN>> all = Sets.newHashSet(Collections.singleton(first));
		TreeSet<StateAliasNfa<TOKEN>> remaining = new TreeSet<StateAliasNfa<TOKEN>>(Collections.singleton(first));
		TreeSet<StateAliasNfa<TOKEN>> secondTry = new TreeSet<StateAliasNfa<TOKEN>>();
		Counter counter = new Counter();
		int i = 0;
		while (true) {
			StateAliasNfa<TOKEN> next = remaining.pollFirst();
			if (next == null)
				next = secondTry.pollFirst();
			AbstractElementAlias<TOKEN> solution = next.toSolution();
			if (solution != null) {
				if (DEBUG_GRAPHVIZ)
					next.dumpAsGraphvizDot("final");
				AliasGrammarProvider<TOKEN> production = new AliasGrammarProvider<TOKEN>(solution);
				return new ProductionUtil().clone(production, grammarFactory);
			} else {
				if (DEBUG_GRAPHVIZ)
					next.dumpAsGraphvizDot(String.format("split_%04d", i));
				List<StateAliasNfa<TOKEN>> clones = cloneAndSplitListsWithSeparator(next, counter);
				if (clones.isEmpty()) {
					Pair<Integer, StateAlias<TOKEN>> splitState = findSplitState(next.getStart(), 0,
							Sets.<StateAlias<TOKEN>> newHashSet());
					if (splitState != null) {
						clones = cloneAndSplit(next, splitState.getSecond(), counter);
						for (StateAliasNfa<TOKEN> c : clones) {
							mergeStatesIntoElements(c);
							secondTry.add(c);
						}
					}
				} else {
					int j = 0;
					for (StateAliasNfa<TOKEN> c : clones) {
						if (DEBUG_GRAPHVIZ)
							c.dumpAsGraphvizDot(String.format("split_%04d_%02d", i, j));
						mergeStatesIntoElements(c);
						c.forceValidOnDebug();
						if (all.add(c)) {
							if (DEBUG_GRAPHVIZ)
								c.dumpAsGraphvizDot(String.format("split_%04d_%02d_min", i, j));
							remaining.add(c);
						}
						j++;
					}
				}
			}
			i++;
		}
	}

	protected <TOKEN> void mergeStatesIntoElements(StateAliasNfa<TOKEN> states) {
		boolean changed = true;
		while (states.toSolution() == null && changed) {
			changed = createAlternative(states);
			changed |= createOptional(states);
			changed |= createMany(states.getStart(), Sets.<StateAlias<TOKEN>> newHashSet());
			changed |= createGroups(states.getStart(), Sets.<StateAlias<TOKEN>> newHashSet());
			changed |= mergeOptionalIntoMany(states.getStart(), Sets.<StateAlias<TOKEN>> newHashSet());
			changed |= mergeAlternativeMultiples(states.getStart(), Sets.<StateAlias<TOKEN>> newHashSet());
		}
	}

	public <ELEMENT, STATE> ELEMENT nfaToGrammar(Nfa<STATE> nfa, ProductionFactory<ELEMENT, STATE> grammarFactory) {
		return nfaToGrammar(nfa, Functions.<STATE> identity(), grammarFactory);
	}

	protected <STATE, TOKEN> StateAlias<TOKEN> toAlias(StateAliasNfa<TOKEN> states, Nfa<STATE> nfa,
			Function<STATE, TOKEN> state2token, STATE state, Map<STATE, StateAlias<TOKEN>> cache) {
		StateAlias<TOKEN> result = cache.get(state);
		if (result != null)
			return result;
		result = new StateAlias<TOKEN>(states, new ElementAlias<TOKEN>(state2token.apply(state)));
		cache.put(state, result);
		for (STATE follower : nfa.getFollowers(state)) {
			StateAlias<TOKEN> followerState = toAlias(states, nfa, state2token, follower, cache);
			result.getOutgoing().add(followerState);
			followerState.getIncoming().add(result);
		}
		return result;
	}
}
