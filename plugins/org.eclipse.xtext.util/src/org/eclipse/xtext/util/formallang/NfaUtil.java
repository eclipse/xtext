/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaUtil {

	public static class NFAImpl<STATE> implements INfaAdapter<STATE, List<STATE>> {

		protected List<STATE> startStates;
		protected List<STATE> finalStates;
		protected Map<STATE, List<STATE>> followers;

		public List<STATE> getFinalStates() {
			return finalStates;
		}

		public NFAImpl(Iterable<STATE> startStates, Iterable<STATE> finalStates, Map<STATE, List<STATE>> followers) {
			super();
			this.startStates = startStates instanceof List<?> ? (List<STATE>) startStates : Lists
					.newArrayList(startStates);
			this.finalStates = finalStates instanceof List<?> ? (List<STATE>) finalStates : Lists
					.newArrayList(finalStates);
			this.followers = followers;
		}

		public List<STATE> getFollowers(STATE node) {
			List<STATE> result = followers.get(node);
			return result == null ? Collections.<STATE> emptyList() : result;
		}

		public List<STATE> getStartStates() {
			return startStates;
		}
	}

	protected <SRCSTATE, DSTSTATE, ITERABLE extends Iterable<? extends DSTSTATE>> DSTSTATE create(
			INfaAdapter<SRCSTATE, ? extends Iterable<SRCSTATE>> source, SRCSTATE src,
			INfaFactory<DSTSTATE, ITERABLE, SRCSTATE> factory, Map<SRCSTATE, DSTSTATE> src2dst) {
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

	public <SRCSTATE, DSTSTATE, ITERABLE extends Iterable<? extends DSTSTATE>> INfaAdapter<DSTSTATE, ITERABLE> create(
			INfaAdapter<SRCSTATE, ? extends Iterable<SRCSTATE>> source,
			INfaFactory<DSTSTATE, ITERABLE, SRCSTATE> factory) {
		List<DSTSTATE> starts = Lists.newArrayList();
		List<DSTSTATE> stops = Lists.newArrayList();
		Map<SRCSTATE, DSTSTATE> src2dst = Maps.newHashMap();
		for (SRCSTATE srcStop : source.getFinalStates()) {
			DSTSTATE dstStop = factory.createEndState(srcStop);
			src2dst.put(srcStop, dstStop);
			stops.add(dstStop);
		}
		for (SRCSTATE srcStart : source.getStartStates()) {
			DSTSTATE dstStart = factory.createStartState(srcStart);
			src2dst.put(srcStart, dstStart);
			starts.add(dstStart);
		}
		for (SRCSTATE srcStart : source.getStartStates()) {
			List<DSTSTATE> dstFollower = Lists.newArrayList();
			for (SRCSTATE srcFollower : source.getFollowers(srcStart))
				dstFollower.add(create(source, srcFollower, factory, src2dst));
			factory.setFollowers(src2dst.get(srcStart), dstFollower);
		}
		return factory.createNfa(starts, stops);
	}

	public <STATE> INfaAdapter<STATE, List<STATE>> inverse(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa) {
		Map<STATE, List<STATE>> inverseMap = Maps.newHashMap();
		for (STATE start : nfa.getStartStates())
			collectedInverseMap(nfa, start, inverseMap, Sets.<STATE> newHashSet());
		return new NFAImpl<STATE>(nfa.getFinalStates(), nfa.getStartStates(), inverseMap);

	}

	protected <STATE> void collectedInverseMap(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa, STATE state,
			Map<STATE, List<STATE>> inverseMap, Set<STATE> visited) {
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

	public <STATE> Map<STATE, Integer> distanceToFinalStateMap(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa) {
		final Set<STATE> stops = Sets.newHashSet(nfa.getFinalStates());
		return distanceToStateMap(nfa, new Predicate<STATE>() {
			public boolean apply(STATE input) {
				return stops.contains(input);
			}
		});
	}

	public <STATE> Map<STATE, Integer> distanceToStateMap(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa,
			Predicate<STATE> matches) {
		return distanceFromStateMap(inverse(nfa), matches);
	}

	public <STATE> Map<STATE, Integer> distanceFromStateMap(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa,
			Predicate<STATE> matches) {
		Map<STATE, Integer> distances = Maps.newHashMap();
		for (STATE start : nfa.getStartStates())
			collectDistancesForm(nfa, start, Integer.MAX_VALUE, distances, matches);
		return distances;
	}

	protected <STATE> void collectDistancesForm(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa, STATE from,
			int distance, Map<STATE, Integer> distances, Predicate<STATE> matches) {
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

	public <STATE, RESULT> List<RESULT> backtrack(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa, RESULT initial,
			BacktrackHandler<STATE, RESULT> handler) {
		Stack<BacktrackingItem<RESULT, STATE>> trace = new Stack<NfaUtil.BacktrackingItem<RESULT, STATE>>();
		trace.push(new BacktrackingItem<RESULT, STATE>(initial, nfa.getStartStates()));
		Set<STATE> finalStates = Sets.newHashSet(nfa.getFinalStates());
		ROOT: while (!trace.isEmpty()) {
			BacktrackingItem<RESULT, STATE> item = trace.peek();
			while (item.followers.hasNext()) {
				STATE nextState = item.followers.next();
				RESULT nextResult = handler.handle(nextState, item.result);
				if (nextResult != null) {
					Iterable<STATE> followers = nfa.getFollowers(nextState);
					followers = handler.sortFollowers(nextResult, followers);
					trace.push(new BacktrackingItem<RESULT, STATE>(nextResult, followers));
					if (finalStates.contains(nextState) && handler.isSolution(nextResult)) {
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

	public <STATE extends Comparable<STATE>> void sortInplcae(INfaAdapter<STATE, ? extends List<STATE>> nfa) {
		for (STATE state : collect(nfa))
			Collections.sort(nfa.getFollowers(state));
	}

	public <STATE> void sortInplcae(INfaAdapter<STATE, ? extends List<STATE>> nfa, Comparator<STATE> comparator) {
		for (STATE state : collect(nfa))
			Collections.sort(nfa.getFollowers(state), comparator);
	}

	public <STATE, COMP extends Comparable<COMP>> void sortInplace(INfaAdapter<STATE, ? extends List<STATE>> nfa,
			final Map<STATE, COMP> sortBy) {
		Comparator<STATE> comparator = new Comparator<STATE>() {
			public int compare(STATE o1, STATE o2) {
				COMP c1 = sortBy.get(o1);
				if (c1 == null)
					return 1;
				COMP c2 = sortBy.get(o2);
				if (c2 == null)
					return -1;
				return c1.compareTo(c2);
			}
		};
		for (STATE state : collect(nfa))
			Collections.sort(nfa.getFollowers(state), comparator);
	}

	public <STATE> Set<STATE> collect(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa) {
		Set<STATE> result = Sets.newHashSet();
		for (STATE s : nfa.getStartStates())
			collect(nfa, s, result);
		return result;
	}

	protected <STATE> void collect(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa, STATE state, Set<STATE> visited) {
		if (!visited.add(state))
			return;
		for (STATE s : nfa.getFollowers(state))
			collect(nfa, s, visited);
	}

	protected <STATE> void collectFinalStates(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa, STATE owner,
			STATE last, Set<STATE> result, Set<STATE> visited, Set<STATE> ends, Predicate<STATE> filter) {
		if (!visited.add(owner))
			return;
		if (filter.apply(owner))
			last = owner;
		if (last != null && ends.contains(owner))
			result.add(last);
		for (STATE follower : nfa.getFollowers(owner))
			collectFinalStates(nfa, follower, last, result, visited, ends, filter);
	}

	protected <STATE, ITERABLE extends Iterable<? extends STATE>> void collectFollowers(
			INfaAdapter<STATE, ITERABLE> nfa, STATE owner, Set<STATE> result, Set<STATE> visited,
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

	public <STATE> INfaAdapter<STATE, Set<STATE>> filter(final INfaAdapter<STATE, ? extends Iterable<STATE>> nfa,
			final Predicate<STATE> filter) {
		return new INfaAdapter<STATE, Set<STATE>>() {

			public Set<STATE> getFinalStates() {
				return filterFinalStates(nfa, filter);
			}

			public Set<STATE> getFollowers(STATE node) {
				return filterFollowers(nfa, nfa.getFollowers(node), filter);
			}

			public Set<STATE> getStartStates() {
				return filterFollowers(nfa, nfa.getStartStates(), filter);
			}

		};
	}

	public <STATE, TOKEN> ITokenNfaAdapter<STATE, TOKEN> filter(final ITokenNfaAdapter<STATE, TOKEN> nfa,
			final Predicate<STATE> filter) {
		return new ITokenNfaAdapter<STATE, TOKEN>() {

			public Iterable<STATE> getFinalStates() {
				return filterFinalStates(nfa, filter);
			}

			public Iterable<STATE> getFollowers(STATE node) {
				return filterFollowers(nfa, nfa.getFollowers(node), filter);
			}

			public Iterable<STATE> getStartStates() {
				return filterFollowers(nfa, nfa.getStartStates(), filter);
			}

			public TOKEN getToken(STATE owner) {
				return filter.apply(owner) ? nfa.getToken(owner) : null;
			}

		};
	}

	public <STATE> Set<STATE> filterFinalStates(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa,
			Predicate<STATE> filter) {
		Set<STATE> ends = Sets.newHashSet(nfa.getFinalStates());
		Set<STATE> result = Sets.newHashSet();
		for (STATE start : nfa.getStartStates())
			collectFinalStates(nfa, start, null, result, Sets.<STATE> newHashSet(), ends, filter);
		return result;
	}

	public <STATE, ITERABLE extends Iterable<? extends STATE>> Set<STATE> filterFollowers(
			INfaAdapter<STATE, ITERABLE> nfa, Iterable<STATE> followers, Predicate<STATE> filter) {
		Set<STATE> result = Sets.newHashSet();
		for (STATE follower : followers)
			collectFollowers(nfa, follower, result, Sets.<STATE> newHashSet(), filter);
		return result;
	}

	public <STATE, ITERABLE extends Iterable<? extends STATE>> STATE find(INfaAdapter<STATE, ITERABLE> nfa,
			Iterable<STATE> starts, Predicate<STATE> matcher) {
		Set<STATE> visited = Sets.newHashSet();
		for (STATE s : starts) {
			STATE r = find(nfa, s, matcher, visited);
			if (r != null)
				return r;
		}
		return null;
	}

	public <STATE, ITERABLE extends Iterable<? extends STATE>> boolean canReach(INfaAdapter<STATE, ITERABLE> nfa,
			STATE state, Predicate<STATE> matcher) {
		return find(nfa, Collections.singleton(state), matcher) != null;
	}

	public <STATE, ITERABLE extends Iterable<? extends STATE>> boolean canReachFinalState(
			INfaAdapter<STATE, ITERABLE> nfa, STATE state) {
		final Set<STATE> stops = Sets.newHashSet(nfa.getFinalStates());
		return find(nfa, Collections.singleton(state), new Predicate<STATE>() {
			public boolean apply(STATE input) {
				return stops.contains(input);
			}
		}) != null;
	}

	public <STATE> STATE find(INfaAdapter<STATE, ? extends Iterable<STATE>> nfa, Predicate<STATE> matcher) {
		return find(nfa, nfa.getStartStates(), matcher);
	}

	protected <STATE, ITERABLE extends Iterable<? extends STATE>> STATE find(INfaAdapter<STATE, ITERABLE> nfa,
			STATE state, Predicate<STATE> matcher, Set<STATE> visited) {
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
