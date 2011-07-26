/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaUtil {

	public static class MappedComparator<STATE, COMPARABLE extends Comparable<COMPARABLE>> implements Comparator<STATE> {
		private final Map<STATE, COMPARABLE> sortBy;

		private MappedComparator(Map<STATE, COMPARABLE> sortBy) {
			this.sortBy = sortBy;
		}

		public int compare(STATE o1, STATE o2) {
			COMPARABLE c1 = sortBy.get(o1);
			if (c1 == null)
				return 1;
			COMPARABLE c2 = sortBy.get(o2);
			if (c2 == null)
				return -1;
			return c1.compareTo(c2);
		}
	}

	public static class NFAImpl<STATE> implements INfaAdapter<STATE> {

		protected final STATE start;
		protected final STATE stop;
		protected final Map<STATE, List<STATE>> followers;

		public STATE getFinalStates() {
			return stop;
		}

		public NFAImpl(STATE startStates, STATE finalStates, Map<STATE, List<STATE>> followers) {
			this.start = startStates;
			this.stop = finalStates;
			this.followers = followers;
		}

		public List<STATE> getFollowers(STATE node) {
			List<STATE> result = followers.get(node);
			return result == null ? Collections.<STATE> emptyList() : result;
		}

		public STATE getStartStates() {
			return start;
		}
	}

	protected <SRCSTATE, DSTSTATE> DSTSTATE create(INfaAdapter<SRCSTATE> source, SRCSTATE src,
			INfaFactory<DSTSTATE, SRCSTATE> factory, Map<SRCSTATE, DSTSTATE> src2dst) {
		DSTSTATE dst = src2dst.get(src);
		if (dst != null)
			return dst;
		dst = factory.createState(src);
		src2dst.put(src, dst);
		List<DSTSTATE> dstFollower = Lists.newArrayList();
		for (SRCSTATE srcFollower : source.getFollowers(src))
			dstFollower.add(create(source, srcFollower, factory, src2dst));
		factory.setFollowers(dst, dstFollower);
		return dst;
	}

	public <SRCSTATE, DSTSTATE> INfaAdapter<DSTSTATE> create(INfaAdapter<SRCSTATE> source,
			INfaFactory<DSTSTATE, SRCSTATE> factory) {
		Map<SRCSTATE, DSTSTATE> src2dst = Maps.newHashMap();
		DSTSTATE dstStop = factory.createEndState(source.getFinalStates());
		src2dst.put(source.getFinalStates(), dstStop);
		DSTSTATE dstStart = factory.createStartState(source.getStartStates());
		src2dst.put(source.getStartStates(), dstStart);
		List<DSTSTATE> dstFollower = Lists.newArrayList();
		for (SRCSTATE srcFollower : source.getFollowers(source.getStartStates()))
			dstFollower.add(create(source, srcFollower, factory, src2dst));
		factory.setFollowers(dstStart, dstFollower);
		return factory.createNfa(dstStart, dstStop);
	}

	public <STATE> INfaAdapter<STATE> inverse(INfaAdapter<STATE> nfa) {
		Map<STATE, List<STATE>> inverseMap = Maps.newHashMap();
		collectedInverseMap(nfa, nfa.getStartStates(), inverseMap, Sets.<STATE> newHashSet());
		return new NFAImpl<STATE>(nfa.getFinalStates(), nfa.getStartStates(), inverseMap);

	}

	protected <STATE> void collectedInverseMap(INfaAdapter<STATE> nfa, STATE state, Map<STATE, List<STATE>> inverseMap,
			Set<STATE> visited) {
		if (!visited.add(state))
			return;
		for (STATE follower : nfa.getFollowers(state)) {
			List<STATE> inverse = inverseMap.get(follower);
			if (inverse == null)
				inverseMap.put(follower, inverse = Lists.newArrayList());
			inverse.add(state);
			collectedInverseMap(nfa, follower, inverseMap, visited);
		}
	}

	public <STATE> Map<STATE, Integer> distanceToFinalStateMap(INfaAdapter<STATE> nfa) {
		final STATE stop = nfa.getFinalStates();
		return distanceToStateMap(nfa, new Predicate<STATE>() {
			public boolean apply(STATE input) {
				return stop == input;
			}
		});
	}

	public <STATE> Map<STATE, Integer> distanceToStateMap(INfaAdapter<STATE> nfa, Predicate<STATE> matches) {
		return distanceFromStateMap(inverse(nfa), matches);
	}

	public <STATE> Map<STATE, Integer> distanceFromStateMap(INfaAdapter<STATE> nfa, Predicate<STATE> matches) {
		Map<STATE, Integer> distances = Maps.newHashMap();
		collectDistancesForm(nfa, nfa.getStartStates(), Integer.MAX_VALUE, distances, matches);
		return distances;
	}

	protected <STATE> void collectDistancesForm(INfaAdapter<STATE> nfa, STATE from, int distance,
			Map<STATE, Integer> distances, Predicate<STATE> matches) {
		Integer dist = distances.get(from);
		if (dist != null && dist <= distance)
			return;
		if (matches.apply(from))
			distance = 0;
		distances.put(from, distance);
		if (distance < Integer.MAX_VALUE)
			distance++;
		for (STATE follower : nfa.getFollowers(from))
			collectDistancesForm(nfa, follower, distance, distances, matches);
	}

	public interface BacktrackHandler<STATE, RESULT> {
		RESULT handle(STATE state, RESULT previous);

		Iterable<STATE> sortFollowers(RESULT result, Iterable<STATE> followers);

		boolean isSolution(RESULT result);
	}

	protected class BacktrackingItem<RESULT, STATE> {
		protected Iterator<STATE> followers;

		protected RESULT result;

		public BacktrackingItem(RESULT result, Iterable<STATE> followers) {
			super();
			this.result = result;
			this.followers = followers.iterator();
		}
	}

	public <STATE, RESULT> List<RESULT> backtrack(INfaAdapter<STATE> nfa, RESULT initial,
			BacktrackHandler<STATE, RESULT> handler) {
		Stack<BacktrackingItem<RESULT, STATE>> trace = new Stack<NfaUtil.BacktrackingItem<RESULT, STATE>>();
		trace.push(new BacktrackingItem<RESULT, STATE>(initial, Collections.singleton(nfa.getStartStates())));
		STATE stopState = nfa.getFinalStates();
		ROOT: while (!trace.isEmpty()) {
			BacktrackingItem<RESULT, STATE> item = trace.peek();
			while (item.followers.hasNext()) {
				STATE nextState = item.followers.next();
				RESULT nextResult = handler.handle(nextState, item.result);
				if (nextResult != null) {
					Iterable<STATE> followers = nfa.getFollowers(nextState);
					followers = handler.sortFollowers(nextResult, followers);
					trace.push(new BacktrackingItem<RESULT, STATE>(nextResult, followers));
					if (stopState == nextState && handler.isSolution(nextResult)) {
						List<RESULT> result = Lists.newArrayList();
						for (BacktrackingItem<RESULT, STATE> t : trace)
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

	public <STATE extends Comparable<STATE>> INfaAdapter<STATE> sort(INfaAdapter<STATE> nfa) {
		Map<STATE, List<STATE>> followerMap = Maps.newHashMap();
		for (STATE state : new NfaUtil().collect(nfa)) {
			ArrayList<STATE> followers = Lists.newArrayList(nfa.getFollowers(state));
			Collections.sort(followers);
			followerMap.put(state, followers);
		}
		return new NFAImpl<STATE>(nfa.getStartStates(), nfa.getFinalStates(), followerMap);
	}

	public <STATE, COMP extends Comparable<COMP>> INfaAdapter<STATE> sort(INfaAdapter<STATE> nfa,
			Map<STATE, COMP> comparator) {
		return sort(nfa, new MappedComparator<STATE, COMP>(comparator));
	}

	public <STATE> INfaAdapter<STATE> sort(INfaAdapter<STATE> nfa, Comparator<STATE> comparator) {
		Map<STATE, List<STATE>> followerMap = Maps.newHashMap();
		for (STATE state : new NfaUtil().collect(nfa)) {
			ArrayList<STATE> followers = Lists.newArrayList(nfa.getFollowers(state));
			Collections.sort(followers, comparator);
			followerMap.put(state, followers);
		}
		return new NFAImpl<STATE>(nfa.getStartStates(), nfa.getFinalStates(), followerMap);
	}

	public <STATE> Set<STATE> collect(INfaAdapter<STATE> nfa) {
		Set<STATE> result = Sets.newHashSet();
		collect(nfa, nfa.getStartStates(), result);
		return result;
	}

	protected <STATE> void collect(INfaAdapter<STATE> nfa, STATE state, Set<STATE> visited) {
		if (!visited.add(state))
			return;
		for (STATE s : nfa.getFollowers(state))
			collect(nfa, s, visited);
	}

	//	protected <STATE> void collectFinalStates(INfaAdapter<STATE> nfa, STATE owner, STATE last, Set<STATE> result,
	//			Set<STATE> visited, Set<STATE> ends, Predicate<STATE> filter) {
	//		if (!visited.add(owner))
	//			return;
	//		if (filter.apply(owner))
	//			last = owner;
	//		if (last != null && ends.contains(owner))
	//			result.add(last);
	//		for (STATE follower : nfa.getFollowers(owner))
	//			collectFinalStates(nfa, follower, last, result, visited, ends, filter);
	//	}

	protected <STATE> void collectFollowers(INfaAdapter<STATE> nfa, STATE owner, Set<STATE> result, Set<STATE> visited,
			Predicate<STATE> filter) {
		if (!visited.add(owner))
			return;
		if (filter.apply(owner)) {
			result.add(owner);
			return;
		}
		for (STATE follower : nfa.getFollowers(owner))
			collectFollowers(nfa, follower, result, visited, filter);
	}

	public <STATE> INfaAdapter<STATE> filter(final INfaAdapter<STATE> nfa, final Predicate<STATE> filter) {
		return new INfaAdapter<STATE>() {

			public STATE getFinalStates() {
				//				return filterFinalStates(nfa, filter);
				return nfa.getFinalStates();
			}

			public Set<STATE> getFollowers(STATE node) {
				return filterFollowers(nfa, nfa.getFollowers(node), filter);
			}

			public STATE getStartStates() {
				//				return filterFollowers(nfa, nfa.getStartStates(), filter);
				return nfa.getStartStates();
			}

		};
	}

	public <STATE, TOKEN> ITokenNfaAdapter<STATE, TOKEN> filter(final ITokenNfaAdapter<STATE, TOKEN> nfa,
			final Predicate<STATE> filter) {
		return new ITokenNfaAdapter<STATE, TOKEN>() {

			public STATE getFinalStates() {
				//				return filterFinalStates(nfa, filter);
				return nfa.getFinalStates();
			}

			public Iterable<STATE> getFollowers(STATE node) {
				return filterFollowers(nfa, nfa.getFollowers(node), filter);
			}

			public STATE getStartStates() {
				//				return filterFollowers(nfa, nfa.getStartStates(), filter);
				return nfa.getStartStates();
			}

			public TOKEN getToken(STATE owner) {
				return filter.apply(owner) ? nfa.getToken(owner) : null;
			}

		};
	}

	//	public <STATE> Set<STATE> filterFinalStates(INfaAdapter<STATE> nfa, Predicate<STATE> filter) {
	//		Set<STATE> ends = Sets.newHashSet(nfa.getFinalStates());
	//		Set<STATE> result = Sets.newHashSet();
	//		for (STATE start : nfa.getStartStates())
	//			collectFinalStates(nfa, start, null, result, Sets.<STATE> newHashSet(), ends, filter);
	//		return result;
	//	}

	public <STATE> Set<STATE> filterFollowers(INfaAdapter<STATE> nfa, Iterable<STATE> followers, Predicate<STATE> filter) {
		Set<STATE> result = Sets.newHashSet();
		for (STATE follower : followers)
			collectFollowers(nfa, follower, result, Sets.<STATE> newHashSet(), filter);
		return result;
	}

	public <STATE, ITERABLE extends Iterable<? extends STATE>> STATE find(INfaAdapter<STATE> nfa,
			Iterable<STATE> starts, Predicate<STATE> matcher) {
		Set<STATE> visited = Sets.newHashSet();
		for (STATE s : starts) {
			STATE r = find(nfa, s, matcher, visited);
			if (r != null)
				return r;
		}
		return null;
	}

	public <STATE, ITERABLE extends Iterable<? extends STATE>> boolean canReach(INfaAdapter<STATE> nfa, STATE state,
			Predicate<STATE> matcher) {
		return find(nfa, Collections.singleton(state), matcher) != null;
	}

	public <STATE, ITERABLE extends Iterable<? extends STATE>> boolean canReachFinalState(INfaAdapter<STATE> nfa,
			STATE state) {
		return find(nfa, Collections.singleton(state), Predicates.equalTo(nfa.getFinalStates())) != null;
	}

	public <STATE> STATE find(INfaAdapter<STATE> nfa, Predicate<STATE> matcher) {
		Set<STATE> visited = Sets.newHashSet();
		return find(nfa, nfa.getStartStates(), matcher, visited);
	}

	protected <STATE, ITERABLE extends Iterable<? extends STATE>> STATE find(INfaAdapter<STATE> nfa, STATE state,
			Predicate<STATE> matcher, Set<STATE> visited) {
		if (!visited.add(state))
			return null;
		if (matcher.apply(state))
			return state;
		for (STATE s : nfa.getFollowers(state)) {
			STATE r = find(nfa, s, matcher, visited);
			if (r != null)
				return r;
		}
		return null;
	}

}
