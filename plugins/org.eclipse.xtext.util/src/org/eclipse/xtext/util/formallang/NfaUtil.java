/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaUtil {

	protected <STATE> void collectFinalStates(INfaAdapter<STATE> nfa, STATE owner, STATE last, Set<STATE> result,
			Set<STATE> visited, Set<STATE> ends, Predicate<STATE> filter) {
		if (!visited.add(owner))
			return;
		if (filter.apply(owner))
			last = owner;
		if (last != null && ends.contains(owner))
			result.add(last);
		for (STATE follower : nfa.getFollowers(owner))
			collectFinalStates(nfa, follower, last, result, visited, ends, filter);
	}

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

			public Iterable<STATE> getFinalStates() {
				return filterFinalStates(nfa, filter);
			}

			public Iterable<STATE> getFollowers(STATE node) {
				return filterFollowers(nfa, nfa.getFollowers(node), filter);
			}

			public Iterable<STATE> getStartStates() {
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

	public <STATE> Iterable<STATE> filterFinalStates(INfaAdapter<STATE> nfa, Predicate<STATE> filter) {
		Set<STATE> ends = Sets.newHashSet(nfa.getFinalStates());
		Set<STATE> result = Sets.newHashSet();
		for (STATE start : nfa.getStartStates())
			collectFinalStates(nfa, start, null, result, Sets.<STATE> newHashSet(), ends, filter);
		return result;
	}

	public <STATE> Iterable<STATE> filterFollowers(INfaAdapter<STATE> nfa, Iterable<STATE> followers,
			Predicate<STATE> filter) {
		Set<STATE> result = Sets.newHashSet();
		for (STATE follower : followers)
			collectFollowers(nfa, follower, result, Sets.<STATE> newHashSet(), filter);
		return result;
	}

}
