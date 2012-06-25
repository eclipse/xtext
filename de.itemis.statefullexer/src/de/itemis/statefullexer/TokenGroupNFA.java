package de.itemis.statefullexer;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import de.itemis.statefullexer.TokenNFA.TokenNfaState;

public class TokenGroupNFA<G, T> extends TokenNFA<T> implements NfaWithGroups<G, TokenNfaState<T>> {

	public static class TokenGroupNfaFactory<G, T> implements NfaWithGroupsFactory<NfaWithGroups<G, TokenNfaState<T>>, G, TokenNfaState<T>, T> {

		@Override
		public NfaWithGroups<G, TokenNfaState<T>> create(T start, T stop) {
			return new TokenGroupNFA<G, T>(new TokenNfaState<T>(start, NFAStateType.START), new TokenNfaState<T>(stop, NFAStateType.STOP));
		}

		@Override
		public TokenNfaState<T> createState(NfaWithGroups<G, TokenNfaState<T>> nfa, T token) {
			return new TokenNfaState<T>(token, NFAStateType.ELEMENT);
		}

		@Override
		public void setFollowers(NfaWithGroups<G, TokenNfaState<T>> nfa, TokenNfaState<T> owner, Iterable<TokenNfaState<T>> followers) {
			owner.followers = followers;
		}

		@Override
		public void setGroup(NfaWithGroups<G, TokenNfaState<T>> nfa, G group, TokenNfaState<T> owner) {
			((TokenGroupNFA<G, T>) nfa).groups.put(owner, group);
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
