/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.formallang.NfaUtil.MappedComparator;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PdaUtil {

	public static class HashStack<T> implements Iterable<T> {

		protected LinkedList<T> list = Lists.newLinkedList();
		protected Set<T> set = Sets.newLinkedHashSet();

		public boolean contains(Object value) {
			return set.contains(value);
		}

		public boolean isEmpty() {
			return list.isEmpty();
		}

		public Iterator<T> iterator() {
			return list.iterator();
		}

		public T peek() {
			return list.getLast();
		}

		public T pop() {
			T result = list.getLast();
			list.removeLast();
			set.remove(result);
			return result;
		}

		public boolean push(T value) {
			list.addLast(value);
			return set.add(value);
		}

		@Override
		public String toString() {
			return list.toString();
		}
	}

	protected static class IsPop<S, P> implements Predicate<S> {
		private final Pda<S, P> pda;

		private IsPop(Pda<S, P> pda) {
			this.pda = pda;
		}

		public boolean apply(S input) {
			return pda.getPop(input) != null;
		}
	}

	protected class StackItem<T> {
		protected StackItem<T> parent;
		protected Iterator<T> parentIt;
		protected T value;

		public StackItem(Iterator<T> parentIt, T value) {
			super();
			this.parentIt = parentIt;
			this.value = value;
		}

		public StackItem(StackItem<T> parent, T value) {
			super();
			this.parent = parent;
			this.value = value;
		}

		public T peek() {
			return value;
		}

		public StackItem<T> pop() {
			if (parent != null)
				return parent;
			if (parentIt != null && parentIt.hasNext())
				return parent = new StackItem<T>(parentIt, parentIt.next());
			return null;
		}

		public StackItem<T> push(T value) {
			return new StackItem<T>(this, value);
		}

		public int size() {
			int result = 0;
			StackItem<T> current = this;
			while (current != null) {
				result++;
				current = current.pop();
			}
			return result;
		}

		@Override
		public String toString() {
			List<String> result = Lists.newArrayList();
			StackItem<T> current = this;
			while (current != null) {
				if (current.value != null)
					result.add(current.value.toString());
				current = current.pop();
			}
			return Joiner.on(", ").join(result);
		}
	}

	protected class TraceItem<S, P> {
		protected TraceItem<S, P> parent;
		protected StackItem<P> stackitem;
		protected S state;

		public TraceItem(TraceItem<S, P> parent, S state, StackItem<P> stackitem) {
			super();
			this.parent = parent;
			this.state = state;
			this.stackitem = stackitem;
		}

		public List<S> asList() {
			List<S> result = Lists.newArrayList();
			TraceItem<S, P> current = this;
			while (current != null) {
				result.add(current.state);
				current = current.parent;
			}
			Collections.reverse(result);
			return result;
		}

		public int size() {
			int result = 0;
			TraceItem<S, P> current = this;
			while (current != null) {
				result++;
				current = current.parent;
			}
			return result;
		}

		@Override
		public String toString() {
			return "States: " + asList() + " Stack: " + stackitem;
		}

	}

	protected static class TraversalItem<S, R> {
		protected R data;
		protected Iterator<S> followers;
		protected S state;

		public TraversalItem(S state, Iterable<S> followers, R previous) {
			super();
			this.state = state;
			this.followers = followers.iterator();
			this.data = previous;
		}

		@Override
		@SuppressWarnings("rawtypes")
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			return data.equals(((TraversalItem) obj).data);
		}

		@Override
		public int hashCode() {
			return data.hashCode();
		}

		@Override
		public String toString() {
			return state.toString();
		}
	}

	@Inject
	protected NfaUtil nfaUtil = new NfaUtil();

	public final long UNREACHABLE = Long.MAX_VALUE;

	public <S, P> boolean canReach(Pda<S, P> pda, S state, Iterator<P> stack, Predicate<S> matches, Predicate<S> canPass) {
		return distanceTo(pda, Collections.singleton(state), stack, matches, canPass) != UNREACHABLE;
	}

	public <S, P, E, T, D extends Pda<S, P>> D create(Cfg<E, T> cfg, FollowerFunction<E> ff,
			PdaFactory<D, S, P, ? super E> fact) {
		return create(cfg, ff, Functions.<E> identity(), fact);
	}

	protected <S, P, E, T1, T2, D extends Pda<S, P>> void create(Cfg<E, T1> cfg, D pda, S state, E ele,
			Iterable<E> followerElements, boolean canEnter, FollowerFunction<E> ff, Function<E, T2> tokens,
			PdaFactory<D, S, P, ? super T2> fact, Map<E, S> states, Map<E, S> stops, Multimap<E, E> callers) {
		List<S> followerStates = Lists.newArrayList();
		for (E fol : followerElements) {
			E e;
			if (fol == null) {
				E root = new ProductionUtil().getRoot(cfg, ele);
				if (root == cfg.getRoot())
					followerStates.add(pda.getStop());
				for (E c : callers.get(root)) {
					S s = stops.get(c);
					if (s == null) {
						s = fact.createPop(pda, tokens.apply(c));
						stops.put(c, s);
						create(cfg, pda, s, c, ff.getFollowers(c), false, ff, tokens, fact, states, stops, callers);
					}
					followerStates.add(s);
				}
			} else if (canEnter && (e = cfg.getCall(fol)) != null) {
				S s = states.get(fol);
				if (s == null) {
					s = fact.createPush(pda, tokens.apply(fol));
					states.put(fol, s);
					create(cfg, pda, s, e, ff.getStarts(e), true, ff, tokens, fact, states, stops, callers);
				}
				followerStates.add(s);
			} else {
				S s = states.get(fol);
				if (s == null) {
					s = fact.createState(pda, tokens.apply(fol));
					states.put(fol, s);
					create(cfg, pda, s, fol, ff.getFollowers(fol), true, ff, tokens, fact, states, stops, callers);
				}
				followerStates.add(s);
			}

		}
		fact.setFollowers(pda, state, followerStates);
	}

	public <S, P, E, T1, T2, D extends Pda<S, P>> D create(Cfg<E, T1> cfg, FollowerFunction<E> ff,
			Function<E, T2> element2token, PdaFactory<D, S, P, ? super T2> fact) {
		D pda = fact.create(null, null);
		Map<E, S> states = Maps.newHashMap();
		Map<E, S> stops = Maps.newHashMap();
		Multimap<E, E> callers = new CfgUtil().getCallers(cfg);
		create(cfg, pda, pda.getStart(), cfg.getRoot(), ff.getStarts(cfg.getRoot()), true, ff, element2token, fact,
				states, stops, callers);
		return pda;
	}

	protected <T> StackItem<T> createStack(Iterator<T> stack) {
		if (stack.hasNext())
			return new StackItem<T>(stack, stack.next());
		return new StackItem<T>((StackItem<T>) null, null);
	}

	public <S, P> long distanceTo(Pda<S, P> pda, Iterable<S> starts, Iterator<P> stack, Predicate<S> matches,
			Predicate<S> canPass) {
		TraceItem<S, P> trace = trace(pda, starts, stack, matches, canPass);
		if (trace != null)
			return trace.size();
		return UNREACHABLE;
	}

	public <S, P, R, D extends Pda<S, P>> D filterEdges(Pda<S, P> pda, Traverser<? super Pda<S, P>, S, R> traverser,
			PdaFactory<D, S, P, S> factory) {
		HashStack<TraversalItem<S, R>> trace = new HashStack<TraversalItem<S, R>>();
		R previous = traverser.enter(pda, pda.getStart(), null);
		if (previous == null)
			return factory.create(pda.getStart(), pda.getStop());
		Map<S, Integer> distances = new NfaUtil().distanceToFinalStateMap(pda);
		MappedComparator<S, Integer> distanceComp = new MappedComparator<S, Integer>(distances);
		trace.push(newItem(pda, distanceComp, pda.getStart(), previous));
		Multimap<S, S> edges = LinkedHashMultimap.create();
		HashSet<S> states = Sets.newHashSet();
		HashSet<R> success = Sets.newHashSet();
		states.add(pda.getStart());
		states.add(pda.getStop());
		ROOT: while (!trace.isEmpty()) {
			TraversalItem<S, R> current = trace.peek();
			while (current.followers.hasNext()) {
				S next = current.followers.next();
				R item = traverser.enter(pda, next, current.data);
				if (item != null) {
					if (next == pda.getStop() || success.contains(item)) {
						S s = null;
						for (TraversalItem<S, R> i : trace) {
							if (s != null)
								edges.put(s, i.state);
							states.add(i.state);
							success.add(i.data);
							s = i.state;
						}
						edges.put(s, next);
					} else {
						if (trace.push(newItem(pda, distanceComp, next, item)))
							continue ROOT;
					}
				}
			}
			trace.pop();
		}
		D result = factory.create(pda.getStart(), pda.getStop());
		Map<S, S> old2new = Maps.newHashMap();
		old2new.put(pda.getStart(), result.getStart());
		old2new.put(pda.getStop(), result.getStop());
		for (S old : states) {
			if (old == pda.getStart() || old == pda.getStop())
				continue;
			else if (pda.getPop(old) != null)
				old2new.put(old, factory.createPop(result, old));
			else if (pda.getPush(old) != null)
				old2new.put(old, factory.createPush(result, old));
			else
				old2new.put(old, factory.createState(result, old));
		}
		for (S old : states) {
			List<S> followers = Lists.newArrayList();
			for (S f : edges.get(old))
				followers.add(old2new.get(f));
			factory.setFollowers(result, old2new.get(old), followers);
		}
		return result;
	}

	public <S, P> Nfa<S> filterUnambiguousPaths(Pda<S, P> pda) {
		Map<S, List<S>> followers = Maps.newHashMap();
		Map<S, Integer> distanceMap = nfaUtil.distanceToFinalStateMap(pda);
		filterUnambiguousPaths(pda, pda.getStart(), distanceMap, followers);
		return new NfaUtil.NFAImpl<S>(pda.getStart(), pda.getStop(), followers);
	}

	protected <S, P> void filterUnambiguousPaths(final Pda<S, P> pda, S state, Map<S, Integer> dist,
			Map<S, List<S>> followers) {
		if (followers.containsKey(state))
			return;
		List<S> f = Lists.newArrayList(pda.getFollowers(state));
		if (f.size() <= 1) {
			followers.put(state, f);
			if (f.size() == 1)
				filterUnambiguousPaths(pda, f.get(0), dist, followers);
			return;
		}
		int closestDist = dist.get(f.get(0));
		S closest = f.get(0);
		for (int i = 1; i < f.size(); i++) {
			int d = dist.get(f.get(i));
			if (d < closestDist) {
				closestDist = d;
				closest = f.get(i);
			}
		}
		IsPop<S, P> isPop = new IsPop<S, P>(pda);
		Set<S> closestPops = nfaUtil.findFirst(pda, Collections.singleton(closest), isPop);
		Iterator<S> it = f.iterator();
		while (it.hasNext()) {
			S next = it.next();
			if (next != closest) {
				Set<S> nextPops = nfaUtil.findFirst(pda, Collections.singleton(next), isPop);
				if (!closestPops.equals(nextPops))
					it.remove();
			}
		}
		followers.put(state, f);
		for (S follower : f)
			filterUnambiguousPaths(pda, follower, dist, followers);
	}

	protected <S, R, P> TraversalItem<S, R> newItem(Pda<S, P> pda, MappedComparator<S, Integer> comp, S next, R item) {
		List<S> followers = Lists.newArrayList(pda.getFollowers(next));
		Collections.sort(followers, comp);
		return new TraversalItem<S, R>(next, followers, item);
	}

	public <S, P> List<S> shortestPathTo(Pda<S, P> pda, Iterable<S> starts, Iterator<P> stack, Predicate<S> matches,
			Predicate<S> canPass) {
		TraceItem<S, P> trace = trace(pda, starts, stack, matches, canPass);
		if (trace != null)
			return trace.asList();
		return null;
	}

	public <S, P> List<S> shortestPathTo(Pda<S, P> pda, Iterator<P> stack, Predicate<S> matches) {
		return shortestPathTo(pda, pda.getStart(), stack, matches, Predicates.<S> alwaysTrue());
	}

	public <S, P> List<S> shortestPathTo(Pda<S, P> pda, Iterator<P> stack, Predicate<S> matches, Predicate<S> canPass) {
		return shortestPathTo(pda, pda.getStart(), stack, matches, canPass);
	}

	public <S, P> List<S> shortestPathTo(Pda<S, P> pda, Iterator<P> stack, S match) {
		return shortestPathTo(pda, pda.getStart(), stack, Predicates.equalTo(match), Predicates.<S> alwaysTrue());
	}

	public <S, P> List<S> shortestPathTo(Pda<S, P> pda, S start, Iterator<P> stack, Predicate<S> matches,
			Predicate<S> canPass) {
		TraceItem<S, P> trace = trace(pda, Collections.singleton(start), stack, matches, canPass);
		if (trace != null)
			return trace.asList();
		return null;
	}

	public <S, P> List<S> shortestPathToFinalState(Pda<S, P> pda, Iterator<P> stack) {
		return shortestPathTo(pda, pda.getStart(), stack, Predicates.equalTo(pda.getStop()),
				Predicates.<S> alwaysTrue());
	}

	public <S, P> List<S> shortestStackpruningPathTo(Pda<S, P> pda, Iterable<S> starts, Iterator<P> stack,
			Predicate<S> matches, Predicate<S> canPass) {
		TraceItem<S, P> trace = traceToWithPruningStack(pda, starts, stack, matches, canPass);
		if (trace != null)
			return trace.asList();
		return null;
	}

	public <S, P> List<S> shortestStackpruningPathTo(Pda<S, P> pda, Iterator<P> stack, Predicate<S> matches) {
		return shortestStackpruningPathTo(pda, pda.getStart(), stack, matches, Predicates.<S> alwaysTrue());
	}

	public <S, P> List<S> shortestStackpruningPathTo(Pda<S, P> pda, Iterator<P> stack, S matches) {
		return shortestStackpruningPathTo(pda, pda.getStart(), stack, Predicates.equalTo(matches),
				Predicates.<S> alwaysTrue());
	}

	public <S, P> List<S> shortestStackpruningPathTo(Pda<S, P> pda, S start, Iterator<P> stack, Predicate<S> matches,
			Predicate<S> canPass) {
		TraceItem<S, P> trace = traceToWithPruningStack(pda, Collections.singleton(start), stack, matches, canPass);
		if (trace != null)
			return trace.asList();
		return null;
	}

	protected <S, P> TraceItem<S, P> trace(Pda<S, P> pda, Iterable<S> starts, Iterator<P> stack, Predicate<S> matches,
			Predicate<S> canPass) {
		StackItem<P> stackItem = createStack(stack);
		List<TraceItem<S, P>> current = Lists.newArrayList();
		Set<S> visited = Sets.newHashSet(starts);
		for (S start : starts) {
			//			if (matches.apply(start))
			//				return new TraceItem<S, P>(null, start, stackItem);
			current.add(new TraceItem<S, P>(null, start, stackItem));
		}
		int counter = stackItem.size() * -1;
		while (current.size() > 0 && counter < visited.size()) {
			List<TraceItem<S, P>> newCurrent = Lists.newArrayList();
			for (TraceItem<S, P> trace : current)
				for (S follower : pda.getFollowers(trace.state)) {
					if (matches.apply(follower))
						return new TraceItem<S, P>(trace, follower, trace.stackitem);
					if (canPass.apply(follower)) {
						P push = pda.getPush(follower);
						visited.add(follower);
						if (push != null) {
							StackItem<P> pushed = trace.stackitem.push(push);
							newCurrent.add(new TraceItem<S, P>(trace, follower, pushed));
						} else {
							P pop = pda.getPop(follower);
							if (pop != null) {
								if (trace.stackitem != null && pop == trace.stackitem.peek()) {
									StackItem<P> popped = trace.stackitem.pop();
									newCurrent.add(new TraceItem<S, P>(trace, follower, popped));
								}
							} else
								newCurrent.add(new TraceItem<S, P>(trace, follower, trace.stackitem));
						}
					}
				}
			current = newCurrent;
			counter++;
		}
		return null;
	}

	protected <S, P> TraceItem<S, P> traceToWithPruningStack(Pda<S, P> pda, Iterable<S> starts, Iterator<P> stack,
			Predicate<S> matches, Predicate<S> canPass) {
		StackItem<P> stackItem = createStack(stack);
		List<TraceItem<S, P>> current = Lists.newArrayList();
		Set<S> visited = Sets.newHashSet(starts);
		TraceItem<S, P> result = null;
		for (S start : starts) {
			TraceItem<S, P> item = new TraceItem<S, P>(null, start, stackItem);
			//			if (matches.apply(start))
			//				result = item;
			current.add(item);
		}
		int counter = stackItem.size() * -1;
		while (current.size() > 0 && counter < visited.size()) {
			List<TraceItem<S, P>> newCurrent = Lists.newArrayList();
			for (TraceItem<S, P> trace : current)
				for (S follower : pda.getFollowers(trace.state)) {
					if (matches.apply(follower)) {
						TraceItem<S, P> found = new TraceItem<S, P>(trace, follower, trace.stackitem);
						if (found.stackitem == null)
							return found;
						if (result == null || result.stackitem.size() > found.stackitem.size()) {
							result = found;
							counter = result.stackitem.size() * -1;
						} else if (result.stackitem.size() == found.stackitem.size() && result.size() > found.size()) {
							result = found;
							counter = result.stackitem.size() * -1;
						}
					}
					if (canPass.apply(follower)) {
						P push = pda.getPush(follower);
						visited.add(follower);
						if (push != null) {
							StackItem<P> pushed = trace.stackitem.push(push);
							newCurrent.add(new TraceItem<S, P>(trace, follower, pushed));
						} else {
							P pop = pda.getPop(follower);
							if (pop != null) {
								if (trace.stackitem != null && pop == trace.stackitem.peek()) {
									StackItem<P> popped = trace.stackitem.pop();
									newCurrent.add(new TraceItem<S, P>(trace, follower, popped));
								}
							} else
								newCurrent.add(new TraceItem<S, P>(trace, follower, trace.stackitem));
						}
					}
				}
			current = newCurrent;
			counter++;
		}
		return result;
	}

	//	public  IPdaAdapter<String, String, String> parse(String pda) {
	//		Pattern node = Pattern.compile("([a-z-A-Z0-9]*)\\[([a-z-A-Z0-9,= ]*)\\]");
	//		Pattern transition = Pattern.compile("([a-z-A-Z0-9]*) -> ([a-z-A-Z0-9]*)");
	//		final Set<String> starts = Sets.newHashSet();
	//		final Set<String> finals = Sets.newHashSet();
	//		final Multimap<String, String> followers = HashMultimap.create();
	//		final Map<String, String> pushs = Maps.newHashMap();
	//		final Map<String, String> pops = Maps.newHashMap();
	//		for (String line : pda.split("\\n")) {
	//			line = line.trim();
	//			Matcher nodeMatcher = node.matcher(line);
	//			if (nodeMatcher.find()) {
	//				String name = nodeMatcher.group(1);
	//				String[] args = nodeMatcher.group(2).split(",");
	//				for (String arg : args) {
	//					String[] a = arg.split("=");
	//					String argKey, argValue;
	//					if (a.length > 1) {
	//						argKey = a[0];
	//						argValue = a[1];
	//					} else {
	//						argKey = arg;
	//						argValue = null;
	//					}
	//					if ("start".equals(argKey))
	//						starts.add(name);
	//					else if ("final".equals(argKey))
	//						finals.add(name);
	//					else if ("push".equals(argKey))
	//						pushs.put(name, argValue);
	//					else if ("pop".equals(argKey))
	//						pops.put(name, argValue);
	//					else
	//						throw new RuntimeException("unknown state argument key: '" + argKey + "'");
	//				}
	//			} else {
	//				Matcher transitionMatcher = transition.matcher(line);
	//				if (transitionMatcher.find())
	//					followers.put(transitionMatcher.group(1), transitionMatcher.group(2));
	//				else
	//					throw new RuntimeException("Could not parse line: '" + line + "'");
	//			}
	//
	//		}
	//		return new IPdaAdapter<String, String, String>() {
	//
	//			public String getToken(String owner) {
	//				return null;
	//			}
	//
	//			public Iterable<String> getStartStates() {
	//				return starts;
	//			}
	//
	//			public Iterable<String> getFollowers(String node) {
	//				return followers.get(node);
	//			}
	//
	//			public Iterable<String> getFinalStates() {
	//				return finals;
	//			}
	//
	//			public String getPush(String state) {
	//				return pushs.get(state);
	//			}
	//
	//			public String getPop(String state) {
	//				return pops.get(state);
	//			}
	//		};
	//	}
}
