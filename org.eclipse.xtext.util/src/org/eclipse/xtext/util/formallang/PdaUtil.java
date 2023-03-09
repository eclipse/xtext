/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
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

		@Override
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
			boolean result = set.add(value);
			if (result)
				list.addLast(value);
			return result;
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

		@Override
		public boolean apply(S input) {
			return pda.getPop(input) != null;
		}
	}

	public static class CyclicStackItem<T> {
		protected CyclicStackItem<T> parent;
		protected T item;

		public CyclicStackItem() {
			this.parent = null;
		}

		public CyclicStackItem(CyclicStackItem<T> parent, T item) {
			super();
			this.parent = parent;
			this.item = item;
		}

		public CyclicStackItem<T> push(T item) {
			int count = 0;
			CyclicStackItem<T> current = this;
			while (current != null) {
				if (current.item == item)
					count++;
				current = current.parent;
			}
			if (count >= 2)
				return null;
			return new CyclicStackItem<T>(this, item);
		}

		public CyclicStackItem<T> pop(T item) {
			if (parent == null || this.item != item)
				return null;
			return parent;
		}
	}

	public static class CyclicStackTraverser<S, P> implements Traverser<Pda<S, P>, S, CyclicStackItem<P>> {
		@Override
		public CyclicStackItem<P> enter(Pda<S, P> pda, S state, CyclicStackItem<P> previous) {
			P item;
			if ((item = pda.getPush(state)) != null)
				return previous.push(item);
			if ((item = pda.getPop(state)) != null)
				return previous.pop(item);
			if (previous == null)
				return new CyclicStackItem<P>();
			return previous;
		}

		@Override
		public boolean isSolution(CyclicStackItem<P> result) {
			return result.parent == null;
		}
	}

	protected class StackItem<T> {
		protected StackItem<T> parent;
		protected T value;

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
			TraversalItem other = (TraversalItem) obj;
			return data.equals(other.data) && state.equals(other.state);
		}

		@Override
		public int hashCode() {
			return data.hashCode() + (state.hashCode() * 7);
		}

		@Override
		public String toString() {
			return state.toString();
		}
	}

	@Inject
	protected NfaUtil nfaUtil = new NfaUtil();

	public final long UNREACHABLE = Long.MAX_VALUE;

	public <S, P> boolean canReach(Pda<S, P> pda, S state, Iterator<P> stack, Predicate<S> matches,
			Predicate<S> canPass) {
		return distanceTo(pda, Collections.singleton(state), stack, matches, canPass) != UNREACHABLE;
	}

	protected static class Identity<T> {
		protected Map<T, T> cache = Maps.newHashMap();

		public T get(T t) {
			T r = cache.get(t);
			if (r != null)
				return r;
			cache.put(t, t);
			return t;
		}
	}

	public <S, P, T, D extends Pda<S, P>> D expand(Pda<S, P> pda, Function<S, Pda<S, P>> expand, Function<S, T> tokens,
			PdaFactory<D, S, P, T> fact) {
		D result = fact.create(tokens.apply(pda.getStart()), tokens.apply(pda.getStop()));
		Identity<S> identity = new Identity<S>();
		Map<S, S> idstates = Maps.newIdentityHashMap();
		Multimap<S, S> followers = LinkedHashMultimap.create();
		for (S s_old : nfaUtil.collect(pda)) {
			S s_new = idstates.get(s_old);
			if (s_new == null) {
				Pda<S, P> sub = expand.apply(s_old);
				if (sub != null) {
					S s_start = identity.get(fact.createPush(result, tokens.apply(s_old)));
					S s_stop = identity.get(fact.createPop(result, tokens.apply(s_old)));
					idstates.put(s_old, s_start);
					idstates.put(sub.getStart(), s_start);
					idstates.put(sub.getStop(), s_stop);
					followers.putAll(s_start, sub.getFollowers(sub.getStart()));
					followers.putAll(s_stop, pda.getFollowers(s_old));
					for (S f_old : nfaUtil.collect(sub))
						if (f_old != sub.getStart() && f_old != sub.getStop()) {
							S f_new = idstates.get(f_old);
							if (f_new == null) {
								idstates.put(f_old, f_new = clone(f_old, sub, result, tokens, fact, identity));
								followers.putAll(f_new, pda.getFollowers(f_old));
							}
						}
				} else {
					idstates.put(s_old, s_new = clone(s_old, pda, result, tokens, fact, identity));
					followers.putAll(s_new, pda.getFollowers(s_old));
				}
			}
		}
		for (Map.Entry<S, Collection<S>> entry : followers.asMap().entrySet()) {
			Set<S> f = Sets.newLinkedHashSet();
			for (S s : entry.getValue())
				f.add(idstates.get(s));
			fact.setFollowers(result, entry.getKey(), f);
		}
		return result;
	}

	protected <S, P, T, D extends Pda<S, P>> S clone(S state, Pda<S, P> src, D target, Function<S, T> tokens,
			PdaFactory<D, S, P, T> fact, Identity<S> identity) {
		if (state == src.getStart())
			return target.getStart();
		if (state == src.getStop())
			return target.getStop();
		P push = src.getPush(state);
		if (push != null)
			return identity.get(fact.createPush(target, tokens.apply(state)));
		P pop = src.getPop(state);
		if (pop != null)
			return identity.get(fact.createPop(target, tokens.apply(state)));
		return identity.get(fact.createState(target, tokens.apply(state)));
	}

	public <S, P, E, T, D extends Pda<S, P>> D create(Cfg<E, T> cfg, FollowerFunction<E> ff,
			PdaFactory<D, S, P, ? super E> fact) {
		return create(cfg, ff, Functions.<E> identity(), fact);
	}

	protected <S, P, E, T1, T2, D extends Pda<S, P>> void create(Cfg<E, T1> cfg, D pda, S state, E ele, Iterable<E> followerElements,
			FollowerFunction<E> ff, Function<E, T2> tokens, PdaFactory<D, S, P, ? super T2> fact, Map<E, S> states, Map<E, S> stops,
			Multimap<E, E> callers) {
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
						create(cfg, pda, s, c, ff.getFollowers(c), ff, tokens, fact, states, stops, callers);
					}
					followerStates.add(s);
				}
			} else if ((e = cfg.getCall(fol)) != null) {
				S s = states.get(fol);
				if (s == null) {
					s = fact.createPush(pda, tokens.apply(fol));
					states.put(fol, s);
					create(cfg, pda, s, e, ff.getStarts(e), ff, tokens, fact, states, stops, callers);
				}
				followerStates.add(s);
			} else {
				S s = states.get(fol);
				if (s == null) {
					s = fact.createState(pda, tokens.apply(fol));
					states.put(fol, s);
					create(cfg, pda, s, fol, ff.getFollowers(fol), ff, tokens, fact, states, stops, callers);
				}
				followerStates.add(s);
			}
		}
		fact.setFollowers(pda, state, followerStates);
	}

	public <S, P, E, T1, T2, D extends Pda<S, P>> D create(Cfg<E, T1> cfg, FollowerFunction<E> ff, Function<E, T2> element2token,
			PdaFactory<D, S, P, ? super T2> fact) {
		D pda = fact.create(null, null);
		Map<E, S> states = Maps.newLinkedHashMap();
		Map<E, S> stops = Maps.newLinkedHashMap();
		Multimap<E, E> callers = new CfgUtil().getCallers(cfg);
		create(cfg, pda, pda.getStart(), cfg.getRoot(), ff.getStarts(cfg.getRoot()), ff, element2token, fact, states, stops, callers);
		return pda;
	}

	protected <T> StackItem<T> createStack(Iterator<T> stack) {
		StackItem<T> result = new StackItem<T>((StackItem<T>) null, null);
		ArrayList<T> list = Lists.newArrayList(stack);
		for (int i = list.size()-1; i >= 0; i--)
			result = new StackItem<T>(result, list.get(i));
		return result;
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
		Map<S, Integer> distances = new NfaUtil().distanceToFinalStateMap(pda);
		return filterEdges(pda, traverser, distances, factory);
	}

	public <S, P, R, D extends Pda<S, P>> D filterEdges(Pda<S, P> pda, Traverser<? super Pda<S, P>, S, R> traverser,
			Map<S, Integer> distances, PdaFactory<D, S, P, S> factory) {
		HashStack<TraversalItem<S, R>> trace = new HashStack<TraversalItem<S, R>>();
		R previous = traverser.enter(pda, pda.getStart(), null);
		if (previous == null)
			return factory == null ? null : factory.create(pda.getStart(), pda.getStop());
		MappedComparator<S, Integer> distanceComp = new MappedComparator<S, Integer>(distances);
		trace.push(newItem(pda, distanceComp, distances, pda.getStart(), previous));
		Multimap<S, S> edges = LinkedHashMultimap.create();
		HashSet<S> states = Sets.newLinkedHashSet();
		HashSet<Pair<S, R>> success = Sets.newLinkedHashSet();
		states.add(pda.getStart());
		states.add(pda.getStop());
		ROOT: while (!trace.isEmpty()) {
			TraversalItem<S, R> current = trace.peek();
			while (current.followers.hasNext()) {
				S next = current.followers.next();
				R item = traverser.enter(pda, next, current.data);
				if (item != null) {
					if ((next == pda.getStop() && traverser.isSolution(item))
							|| success.contains(Tuples.create(next, item))) {
						S s = null;
						for (TraversalItem<S, R> i : trace) {
							if (s != null)
								edges.put(s, i.state);
							states.add(i.state);
							success.add(Tuples.create(i.state, i.data));
							s = i.state;
						}
						edges.put(s, next);
					} else {
						if (trace.push(newItem(pda, distanceComp, distances, next, item)))
							continue ROOT;
					}
				}
			}
			trace.pop();
		}
		if (factory == null)
			return null;
		D result = factory.create(pda.getStart(), pda.getStop());
		Map<S, S> old2new = Maps.newLinkedHashMap();
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
		Map<S, List<S>> followers = Maps.newLinkedHashMap();
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

	protected <S, R, P> TraversalItem<S, R> newItem(Pda<S, P> pda, MappedComparator<S, Integer> comp,
			Map<S, Integer> distances, S next, R item) {
		List<S> followers = Lists.newArrayList();
		for (S f : pda.getFollowers(next))
			if (distances.containsKey(f))
				followers.add(f);
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

	public <S, P, R> List<R> collectReachable(Pda<S, P> pda, final Function<S, R> function) {
		final List<R> result = Lists.newArrayList();
		Iterator<P> stack = Collections.<P> emptyList().iterator();
		Predicate<S> matches = Predicates.<S> alwaysFalse();
		Predicate<S> canPass = new Predicate<S>() {
			@Override
			public boolean apply(S input) {
				R r = function.apply(input);
				if (r != null) {
					result.add(r);
					return false;
				} else {
					return true;
				}
			}
		};
		trace(pda, Collections.singleton(pda.getStart()), stack, matches, canPass);
		return result;
	}

	protected <S, P> TraceItem<S, P> trace(Pda<S, P> pda, Iterable<S> starts, Iterator<P> stack, Predicate<S> matches,
			Predicate<S> canPass) {
		StackItem<P> stackItem = createStack(stack);
		List<TraceItem<S, P>> current = Lists.newArrayList();
		Set<S> visited = Sets.newLinkedHashSet(starts);
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
		Set<S> visited = Sets.newLinkedHashSet(starts);
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

	public <S, P, D extends Pda<S, P>> D filterOrphans(Pda<S, P> pda, PdaFactory<D, S, P, S> factory) {
		CyclicStackTraverser<S, P> traverser = new CyclicStackTraverser<S, P>();
		return filterEdges(pda, traverser, factory);
	}

	public <S, P, D extends Pda<S, P>> Map<P, Pair<S, S>> collectPopsAndPushs(Pda<S, P> pda) {
		Map<P, Pair<S, S>> result = Maps.newLinkedHashMap();
		for (S s : nfaUtil.collect(pda)) {
			P push = pda.getPush(s);
			if (push != null) {
				Pair<S, S> o = result.get(push);
				Pair<S, S> n = Tuples.create(s, o == null ? null : o.getSecond());
				result.put(push, n);
			}
			P pop = pda.getPop(s);
			if (pop != null) {
				Pair<S, S> o = result.get(pop);
				Pair<S, S> n = Tuples.create(o == null ? null : o.getFirst(), s);
				result.put(pop, n);
			}
		}
		return result;
	}

	public <S, P, D extends Pda<S, P>> Map<S, S> mapPopAndPush(Pda<S, P> pda) {
		Map<P, Pair<S, S>> popsAndPushs = collectPopsAndPushs(pda);
		Map<S, S> result = Maps.newLinkedHashMap();
		for (Pair<S, S> p : popsAndPushs.values()) {
			S push = p.getFirst();
			S pop = p.getSecond();
			if (push != null && pop != null) {
				result.put(push, pop);
				result.put(pop, push);
			}
		}
		return result;
	}

	public <S, P, D extends Pda<S, P>> D filter(Pda<S, P> pda, Predicate<S> filter,
			PdaFactory<D, S, P, ? super S> fact) {
		D result = fact.create(pda.getStart(), pda.getStop());
		Map<S, S> orig2copy = Maps.newLinkedHashMap();
		S start = pda.getStart();
		S stop = pda.getStop();
		orig2copy.put(start, result.getStart());
		orig2copy.put(stop, result.getStop());
		for (S orig : new NfaUtil().collect(pda)) {
			if (orig != start && orig != stop && filter.apply(orig)) {
				if (pda.getPop(orig) != null) {
					orig2copy.put(orig, fact.createPop(result, orig));
				} else if (pda.getPush(orig) != null) {
					orig2copy.put(orig, fact.createPush(result, orig));
				} else {
					orig2copy.put(orig, fact.createState(result, orig));
				}
			}
		}
		for (Map.Entry<S, S> e : orig2copy.entrySet()) {
			S orig = e.getKey();
			S copy = e.getValue();
			LinkedList<S> todo = Lists.newLinkedList();
			todo.add(orig);
			Set<S> visited = Sets.newHashSet();
			Set<S> followers = Sets.newLinkedHashSet();
			while (!todo.isEmpty()) {
				S o = todo.pop();
				if (visited.add(o)) {
					for (S s : pda.getFollowers(o)) {
						S f = orig2copy.get(s);
						if (f != null) {
							followers.add(f);
						} else {
							todo.add(s);
						}
					}
				}
			}
			fact.setFollowers(result, copy, followers);
		}
		return result;
	}

}
