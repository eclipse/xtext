package de.itemis.statefullexer;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import de.itemis.statefullexer.TokenNFA.TokenNfaState;

public class TokenGroupNFA<G, T> extends TokenNFA<T> implements NfaWithGroups<G, TokenNfaState<T>> {

	public static class TokenGroupNfaFactory<G, T> implements NfaWithGroupsFactory<NfaWithGroups<G, TokenNfaState<T>>, G, TokenNfaState<T>, T> {

		private Function<T, String> stateFormatter;

		@Override
		public NfaWithGroups<G, TokenNfaState<T>> create(T start, T stop) {
			de.itemis.statefullexer.TokenNFA.TokenNfaState<T> startStates = new TokenNfaState<T>(start, NFAStateType.START, stateFormatter);
			de.itemis.statefullexer.TokenNFA.TokenNfaState<T> finalStates = new TokenNfaState<T>(stop, NFAStateType.STOP, stateFormatter);
			return new TokenGroupNFA<G, T>(startStates, finalStates);
		}

		@Override
		public TokenNfaState<T> createState(NfaWithGroups<G, TokenNfaState<T>> nfa, T token) {
			return new TokenNfaState<T>(token, NFAStateType.ELEMENT, getStateFormatter());
		}

		public Function<T, String> getStateFormatter() {
			return stateFormatter;
		}

		@Override
		public void setFollowers(NfaWithGroups<G, TokenNfaState<T>> nfa, TokenNfaState<T> owner, Iterable<TokenNfaState<T>> followers) {
			owner.followers = followers;
		}

		@Override
		public void setGroup(NfaWithGroups<G, TokenNfaState<T>> nfa, G group, TokenNfaState<T> owner) {
			((TokenGroupNFA<G, T>) nfa).groups.put(owner, group);
		}

		public void setStateFormatter(Function<T, String> stateFormatter) {
			this.stateFormatter = stateFormatter;
		}

	}

	protected Map<TokenNfaState<T>, G> groups = Maps.newHashMap();

	public TokenGroupNFA(TokenNfaState<T> startStates, TokenNfaState<T> finalStates) {
		super(startStates, finalStates);
	}

	@Override
	public Iterable<G> getAllGroups() {
		return Sets.newLinkedHashSet(groups.values());
	}

	@Override
	public G getGroupFromState(TokenNfaState<T> state) {
		return groups.get(state);
	}

	@Override
	public Iterable<TokenNfaState<T>> getStatesInGroup(G group) {
		List<TokenNfaState<T>> result = Lists.newArrayList();
		for (Map.Entry<TokenNfaState<T>, G> e : groups.entrySet())
			if (group.equals(e.getValue()))
				result.add(e.getKey());
		return result;
	}

}
