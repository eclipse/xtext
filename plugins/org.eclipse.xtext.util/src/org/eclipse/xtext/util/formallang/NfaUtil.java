/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaUtil {

	public interface BacktrackHandler<S, RESULT> {
		RESULT handle(S state, RESULT previous);

		boolean isSolution(RESULT result);

		Iterable<S> sortFollowers(RESULT result, Iterable<S> followers);
	}

	protected static class BacktrackingItem<RESULT, S> {
		protected Iterator<S> followers;

		protected RESULT result;

		public BacktrackingItem(RESULT result, Iterable<S> followers) {
			super();
			this.result = result;
			this.followers = followers.iterator();
		}

		@Override
		public String toString() {
			return result == null ? "null" : result.toString();
		}
	}

	protected static class GetToken<E, T> implements Function<E, T> {

		protected Production<E, T> production;

		public GetToken(Production<E, T> production) {
			super();
			this.production = production;
		}

		@Override
		public T apply(E from) {
			return production.getToken(from);
		}

	}

	public static class MappedComparator<S, COMPARABLE extends Comparable<COMPARABLE>> implements Comparator<S> {
		protected final Map<S, COMPARABLE> sortBy;

		public MappedComparator(Map<S, COMPARABLE> sortBy) {
			this.sortBy = sortBy;
		}

		@Override
		public int compare(S o1, S o2) {
			COMPARABLE c1 = sortBy.get(o1);
			if (c1 == null)
				return 1;
			COMPARABLE c2 = sortBy.get(o2);
			if (c2 == null)
				return -1;
			return c1.compareTo(c2);
		}
	}

	public static class NFAFactory<S> implements NfaFactory<Nfa<S>, S, S> {

		@Override
		public Nfa<S> create(S start, S stop) {
			return new NFAImpl<S>(start, stop, Maps.<S, List<S>> newLinkedHashMap());
		}

		@Override
		public S createState(Nfa<S> nfa, S token) {
			return token;
		}

		@Override
		public void setFollowers(Nfa<S> nfa, S owner, Iterable<S> followers) {
			((NFAImpl<S>) nfa).followers.put(owner, Lists.newArrayList(followers));
		}
	}

	public static class NFAImpl<S> implements Nfa<S> {

		protected final Map<S, List<S>> followers;
		protected final S start;
		protected final S stop;

		public NFAImpl(S startStates, S finalStates, Map<S, List<S>> followers) {
			this.start = startStates;
			this.stop = finalStates;
			this.followers = followers;
		}

		@Override
		public List<S> getFollowers(S node) {
			List<S> result = followers.get(node);
			return result == null ? Collections.<S> emptyList() : result;
		}

		@Override
		public S getStart() {
			return start;
		}

		@Override
		public S getStop() {
			return stop;
		}
	}

	public <S, RESULT> List<RESULT> backtrack(Nfa<S> nfa, RESULT initial, BacktrackHandler<S, RESULT> handler) {
		Stack<BacktrackingItem<RESULT, S>> trace = new Stack<NfaUtil.BacktrackingItem<RESULT, S>>();
		trace.push(new BacktrackingItem<RESULT, S>(initial, Collections.singleton(nfa.getStart())));
		S stopState = nfa.getStop();
		ROOT: while (!trace.isEmpty()) {
			BacktrackingItem<RESULT, S> item = trace.peek();
			while (item.followers.hasNext()) {
				S nextState = item.followers.next();
				RESULT nextResult = handler.handle(nextState, item.result);
				if (nextResult != null) {
					Iterable<S> followers = nfa.getFollowers(nextState);
					followers = handler.sortFollowers(nextResult, followers);
					trace.push(new BacktrackingItem<RESULT, S>(nextResult, followers));
					if (stopState == nextState && handler.isSolution(nextResult)) {
						List<RESULT> result = Lists.newArrayList();
						for (BacktrackingItem<RESULT, S> t : trace)
							result.add(t.result);
						return result;
					}
					continue ROOT;
				}
			}
			trace.pop();
		}
		return null;
	}

	public <S, ITERABLE extends Iterable<? extends S>> boolean canReach(Nfa<S> nfa, Predicate<S> matcher) {
		return find(nfa, Collections.singleton(nfa.getStart()), matcher) != null;
	}
	
	public <S, ITERABLE extends Iterable<? extends S>> boolean canReach(Nfa<S> nfa, S state, Predicate<S> matcher) {
		return find(nfa, Collections.singleton(state), matcher) != null;
	}

	public <S, ITERABLE extends Iterable<? extends S>> boolean canReachFinalState(Nfa<S> nfa, S state) {
		return find(nfa, Collections.singleton(state), Predicates.equalTo(nfa.getStop())) != null;
	}

	public <S> Set<S> collect(Nfa<S> nfa) {
		Set<S> result = Sets.newLinkedHashSet();
		collect(nfa, nfa.getStart(), result);
		return result;
	}

	protected <S> void collect(Nfa<S> nfa, S state, Set<S> visited) {
		if (!visited.add(state))
			return;
		for (S s : nfa.getFollowers(state))
			collect(nfa, s, visited);
	}

	protected <S> void collectDistancesForm(Nfa<S> nfa, S from, int distance, Map<S, Integer> distances,
			Predicate<S> matches) {
		Integer dist = distances.get(from);
		if (dist != null && dist <= distance)
			return;
		if (matches.apply(from))
			distance = 0;
		distances.put(from, distance);
		if (distance < Integer.MAX_VALUE)
			distance++;
		for (S follower : nfa.getFollowers(from))
			collectDistancesForm(nfa, follower, distance, distances, matches);
	}

	protected <S> void collectedInverseMap(Nfa<S> nfa, S state, Map<S, List<S>> inverseMap, Set<S> visited) {
		if (!visited.add(state))
			return;
		for (S follower : nfa.getFollowers(state)) {
			List<S> inverse = inverseMap.get(follower);
			if (inverse == null)
				inverseMap.put(follower, inverse = Lists.newArrayList());
			inverse.add(state);
			collectedInverseMap(nfa, follower, inverseMap, visited);
		}
	}

	protected <S> void collectFollowers(Nfa<S> nfa, S owner, Set<S> result, Set<S> visited, Predicate<S> filter) {
		if (!visited.add(owner))
			return;
		if (filter.apply(owner)) {
			result.add(owner);
			return;
		}
		for (S follower : nfa.getFollowers(owner))
			collectFollowers(nfa, follower, result, visited, filter);
	}

	protected <SRCSTATE, DSTSTATE, P extends Nfa<DSTSTATE>> DSTSTATE create(Nfa<SRCSTATE> source, P result,
			SRCSTATE src, NfaFactory<P, DSTSTATE, SRCSTATE> factory, Map<SRCSTATE, DSTSTATE> src2dst) {
		DSTSTATE dst = src2dst.get(src);
		if (dst != null)
			return dst;
		dst = factory.createState(result, src);
		src2dst.put(src, dst);
		List<DSTSTATE> dstFollower = Lists.newArrayList();
		for (SRCSTATE srcFollower : source.getFollowers(src))
			dstFollower.add(create(source, result, srcFollower, factory, src2dst));
		factory.setFollowers(result, dst, dstFollower);
		return dst;
	}

	public <SRCSTATE, DSTSTATE, P extends Nfa<DSTSTATE>> P create(Nfa<SRCSTATE> source,
			NfaFactory<P, DSTSTATE, SRCSTATE> factory) {
		Map<SRCSTATE, DSTSTATE> src2dst = Maps.newLinkedHashMap();
		P result = factory.create(source.getStart(), source.getStop());
		src2dst.put(source.getStop(), result.getStop());
		src2dst.put(source.getStart(), result.getStart());
		List<DSTSTATE> dstFollower = Lists.newArrayList();
		for (SRCSTATE srcFollower : source.getFollowers(source.getStart()))
			dstFollower.add(create(source, result, srcFollower, factory, src2dst));
		factory.setFollowers(result, result.getStart(), dstFollower);
		return result;
	}

	public <E, T> Nfa<E> create(Production<E, T> production, FollowerFunction<E> ff, E start, E stop) {
		return create(production, ff, Functions.<E> identity(), new NFAFactory<E>(), start, stop);
	}

	public <S, E, T, P extends Nfa<S>> P create(Production<E, T> production, FollowerFunction<E> ff,
			NfaFactory<P, S, ? super T> factory) {
		return create(production, ff, new GetToken<E, T>(production), factory, null, null);
	}

	public <S, E, T1, T2, P extends Nfa<S>> P create(Production<E, T1> production, FollowerFunction<E> ff,
			Function<E, T2> tokenFunc, NfaFactory<P, S, ? super T2> factory, T2 start, T2 stop) {
		Map<E, S> states = Maps.newLinkedHashMap();
		P nfa = factory.create(start, stop);
		states.put(null, nfa.getStop());
		create(production, nfa, nfa.getStart(), ff.getStarts(production.getRoot()), ff, tokenFunc, factory, states);
		return nfa;
	}

	protected <S, E, T1, T2, P extends Nfa<S>> void create(Production<E, T1> production, P nfa, S state,
			Iterable<E> followerElements, FollowerFunction<E> followerFunc, Function<E, T2> tokenFunc,
			NfaFactory<P, S, ? super T2> factory, Map<E, S> ele2state) {
		List<S> sfollower = Lists.newArrayList();
		for (E follower : followerElements) {
			S fs = ele2state.get(follower);
			if (fs == null) {
				fs = factory.createState(nfa, tokenFunc.apply(follower));
				ele2state.put(follower, fs);
				create(production, nfa, fs, followerFunc.getFollowers(follower), followerFunc, tokenFunc, factory,
						ele2state);
			}
			sfollower.add(fs);
		}
		factory.setFollowers(nfa, state, sfollower);
	}

	public <S> Map<S, Integer> distanceFromStateMap(Nfa<S> nfa, Predicate<S> matches) {
		Map<S, Integer> distances = Maps.newHashMap();
		collectDistancesForm(nfa, nfa.getStart(), Integer.MAX_VALUE, distances, matches);
		return distances;
	}

	public <S> Map<S, Integer> distanceToFinalStateMap(Nfa<S> nfa) {
		final S stop = nfa.getStop();
		return distanceToStateMap(nfa, new Predicate<S>() {
			@Override
			public boolean apply(S input) {
				return stop == input;
			}
		});
	}

	public <S> Map<S, Integer> distanceToStateMap(Nfa<S> nfa, Predicate<S> matches) {
		return distanceFromStateMap(inverse(nfa), matches);
	}

	public <S> boolean equalsIgnoreOrder(Nfa<S> nfa1, Nfa<S> nfa2) {
		return equalsIgnoreOrder(nfa1, nfa2, new Function<S, Object>() {
			@Override
			public Object apply(S from) {
				return from;
			}
		});
	}

	public <S> boolean equalsIgnoreOrder(Nfa<S> nfa1, Nfa<S> nfa2, Function<S, ? super Object> keyFunc) {
		if (!Objects.equal(keyFunc.apply(nfa1.getStart()), keyFunc.apply(nfa2.getStart())))
			return false;
		return equalsIgnoreOrder(nfa1, nfa2, nfa1.getStart(), nfa2.getStart(), keyFunc, Sets.<S> newHashSet());
	}

	public <S> boolean equalsIgnoreOrder(Nfa<S> nfa1, Nfa<S> nfa2, S s1, S s2, Function<S, ? super Object> keyFunc,
			Set<S> visited) {
		if (!visited.add(s1))
			return true;
		Iterable<S> followers1 = nfa1.getFollowers(s1);
		Iterable<S> followers2 = nfa1.getFollowers(s2);
		if (Iterables.size(followers1) != Iterables.size(followers2))
			return false;
		Multimap<? super Object, S> index = Multimaps.index(followers1, keyFunc);
		for (S f : followers2) {
			Object key2 = keyFunc.apply(f);
			Collection<S> key1s = index.get(key2);
			if (key1s.size() != 1)
				return false;
			if (!equalsIgnoreOrder(nfa1, nfa2, key1s.iterator().next(), f, keyFunc, visited))
				return false;
		}
		return true;
	}

	public <S> Nfa<S> filter(final Nfa<S> nfa, final Predicate<S> filter) {
		return new Nfa<S>() {

			@Override
			public Set<S> getFollowers(final S node) {
				final S start = nfa.getStart();
				final S stop = nfa.getStop();
				return filterFollowers(nfa, nfa.getFollowers(node), new Predicate<S>() {
					@Override
					public boolean apply(S input) {
						return input == start || input == stop || filter.apply(input);
					}
				});
			}

			@Override
			public S getStart() {
				//				return filterFollowers(nfa, nfa.getStartStates(), filter);
				return nfa.getStart();
			}

			@Override
			public S getStop() {
				//				return filterFinalStates(nfa, filter);
				return nfa.getStop();
			}

		};
	}

	public <S> Set<S> filterFollowers(Nfa<S> nfa, Iterable<S> followers, Predicate<S> filter) {
		Set<S> result = Sets.newLinkedHashSet();
		for (S follower : followers)
			collectFollowers(nfa, follower, result, Sets.<S> newHashSet(), filter);
		return result;
	}

	//	protected <S> void collectFinalStates(INfaAdapter<S> nfa, S owner, S last, Set<S> result,
	//			Set<S> visited, Set<S> ends, Predicate<S> filter) {
	//		if (!visited.add(owner))
	//			return;
	//		if (filter.apply(owner))
	//			last = owner;
	//		if (last != null && ends.contains(owner))
	//			result.add(last);
	//		for (S follower : nfa.getFollowers(owner))
	//			collectFinalStates(nfa, follower, last, result, visited, ends, filter);
	//	}

	public <S, ITERABLE extends Iterable<? extends S>> S find(Nfa<S> nfa, Iterable<S> starts, Predicate<S> matcher) {
		Set<S> visited = Sets.newHashSet();
		for (S s : starts) {
			S r = find(nfa, s, matcher, visited);
			if (r != null)
				return r;
		}
		return null;
	}

	public <S> S find(Nfa<S> nfa, Predicate<S> matcher) {
		Set<S> visited = Sets.newHashSet();
		return find(nfa, nfa.getStart(), matcher, visited);
	}

	//	public <S, TOKEN> ITokenNfaAdapter<S, TOKEN> filter(final ITokenNfaAdapter<S, TOKEN> nfa, final Predicate<S> filter) {
	//		return new ITokenNfaAdapter<S, TOKEN>() {
	//
	//			public S getStop() {
	//				//				return filterFinalStates(nfa, filter);
	//				return nfa.getStop();
	//			}
	//
	//			public Iterable<S> getFollowers(S node) {
	//				return filterFollowers(nfa, nfa.getFollowers(node), filter);
	//			}
	//
	//			public S getStart() {
	//				//				return filterFollowers(nfa, nfa.getStartStates(), filter);
	//				return nfa.getStart();
	//			}
	//
	//			public TOKEN getToken(S owner) {
	//				return filter.apply(owner) ? nfa.getToken(owner) : null;
	//			}
	//
	//		};
	//	}

	//	public <S> Set<S> filterFinalStates(INfaAdapter<S> nfa, Predicate<S> filter) {
	//		Set<S> ends = Sets.newHashSet(nfa.getFinalStates());
	//		Set<S> result = Sets.newHashSet();
	//		for (S start : nfa.getStartStates())
	//			collectFinalStates(nfa, start, null, result, Sets.<S> newHashSet(), ends, filter);
	//		return result;
	//	}

	protected <S, ITERABLE extends Iterable<? extends S>> S find(Nfa<S> nfa, S state, Predicate<S> matcher,
			Set<S> visited) {
		if (!visited.add(state))
			return null;
		if (matcher.apply(state))
			return state;
		for (S s : nfa.getFollowers(state)) {
			S r = find(nfa, s, matcher, visited);
			if (r != null)
				return r;
		}
		return null;
	}

	public <S> Set<S> findFirst(Nfa<S> nfa, Iterable<S> starts, Predicate<S> match) {
		Set<S> current = Sets.newLinkedHashSet(starts);
		Set<S> visited = Sets.newLinkedHashSet();
		while (!current.isEmpty()) {
			Set<S> result = Sets.newLinkedHashSet();
			for (S s : current) {
				if (match.apply(s))
					result.add(s);
			}
			if (!result.isEmpty())
				return result;
			visited.addAll(current);
			Set<S> newCurrent = Sets.newLinkedHashSet();
			for (S s : current)
				Iterables.addAll(newCurrent, nfa.getFollowers(s));
			newCurrent.removeAll(visited);
			current = newCurrent;
		}
		return Collections.emptySet();
	}

	public <S> Nfa<S> inverse(Nfa<S> nfa) {
		Map<S, List<S>> inverseMap = Maps.newLinkedHashMap();
		collectedInverseMap(nfa, nfa.getStart(), inverseMap, Sets.<S> newHashSet());
		return new NFAImpl<S>(nfa.getStop(), nfa.getStart(), inverseMap);
	}

	public <S> void removeOrphans(Nfa<S> nfa) {
		Map<S, Integer> distances = distanceToFinalStateMap(nfa);
		for (S s : collect(nfa)) {
			Iterator<S> i = nfa.getFollowers(s).iterator();
			while (i.hasNext())
				if (!distances.containsKey(i.next()))
					i.remove();
		}
	}

	public <S extends Comparable<S>> Nfa<S> sort(Nfa<S> nfa) {
		Map<S, List<S>> followerMap = Maps.newLinkedHashMap();
		for (S state : new NfaUtil().collect(nfa)) {
			ArrayList<S> followers = Lists.newArrayList(nfa.getFollowers(state));
			Collections.sort(followers);
			followerMap.put(state, followers);
		}
		return new NFAImpl<S>(nfa.getStart(), nfa.getStop(), followerMap);
	}

	public <S> Nfa<S> sort(Nfa<S> nfa, Comparator<S> comparator) {
		Map<S, List<S>> followerMap = Maps.newLinkedHashMap();
		for (S state : new NfaUtil().collect(nfa)) {
			ArrayList<S> followers = Lists.newArrayList(nfa.getFollowers(state));
			Collections.sort(followers, comparator);
			followerMap.put(state, followers);
		}
		return new NFAImpl<S>(nfa.getStart(), nfa.getStop(), followerMap);
	}

	public <S, COMP extends Comparable<COMP>> Nfa<S> sort(Nfa<S> nfa, Map<S, COMP> comparator) {
		return sort(nfa, new MappedComparator<S, COMP>(comparator));
	}
	
}
