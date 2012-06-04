package de.itemis.statefullexer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.formallang.Cfg;
import org.eclipse.xtext.util.formallang.CfgUtil;
import org.eclipse.xtext.util.formallang.FollowerFunction;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaFactory;
import org.eclipse.xtext.util.formallang.ProductionUtil;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

@SuppressWarnings("restriction")
public class NfaUtil2 {

	public enum NFAStateType {
		START, STOP, ELEMENT
	}

	public static class TokenNFAImpl<S> implements Nfa<TokenNfaState<S>> {

		protected final TokenNfaState<S> start;
		protected final TokenNfaState<S> stop;

		public TokenNFAImpl(TokenNfaState<S> startStates, TokenNfaState<S> finalStates) {
			this.start = startStates;
			this.stop = finalStates;
		}

		public Iterable<TokenNfaState<S>> getFollowers(TokenNfaState<S> node) {
			return node.getFollowers();
		}

		public TokenNfaState<S> getStart() {
			return start;
		}

		public TokenNfaState<S> getStop() {
			return stop;
		}
	}

	public static class TokenNfaState<S> {
		protected S token;
		protected Iterable<TokenNfaState<S>> followers;
		protected NFAStateType type;

		public S getToken() {
			return token;
		}

		public Iterable<TokenNfaState<S>> getFollowers() {
			return followers == null ? Collections.<TokenNfaState<S>> emptyList() : followers;
		}

		private TokenNfaState(S token, NFAStateType type) {
			super();
			this.token = token;
			this.type = type;
		}

		public NFAStateType getType() {
			return type;
		}

		@Override
		public String toString() {
			return type + ": " + token;
		}

	}

	public static class TokenNFAFactory<S> implements NfaFactory<Nfa<TokenNfaState<S>>, TokenNfaState<S>, S> {

		@Override
		public Nfa<TokenNfaState<S>> create(S start, S stop) {
			return new TokenNFAImpl<S>(new TokenNfaState<S>(start, NFAStateType.START), new TokenNfaState<S>(stop, NFAStateType.STOP));
		}

		@Override
		public TokenNfaState<S> createState(Nfa<TokenNfaState<S>> nfa, S token) {
			return new TokenNfaState<S>(token, NFAStateType.ELEMENT);
		}

		@Override
		public void setFollowers(Nfa<TokenNfaState<S>> nfa, TokenNfaState<S> owner, Iterable<TokenNfaState<S>> followers) {
			owner.followers = followers;
		}

	}

	protected <S, T> void getAllTransitions(NfaWithTransitions<S, T> nfa, S state, List<T> result, Set<S> visited) {
		if (!visited.add(state))
			return;
		Iterables.addAll(result, nfa.getOutgoingTransitions(state));
		for (S f : nfa.getFollowers(state))
			getAllTransitions(nfa, f, result, visited);
	}

	public <S, T> Iterable<T> getAllTransitions(NfaWithTransitions<S, T> nfa) {
		List<T> result = Lists.newArrayList();
		getAllTransitions(nfa, nfa.getStart(), result, Sets.<S> newHashSet());
		return result;
	}

	public <S, E, T, D extends Nfa<S>> D create(Cfg<E, T> cfg, FollowerFunction<E> ff, NfaFactory<D, S, E> fact) {
		return create(cfg, ff, Functions.<E> identity(), fact);
	}

	public <S, E, T1, T2, D extends Nfa<S>> D create(Cfg<E, T1> cfg, FollowerFunction<E> ff, Function<E, T2> element2token, NfaFactory<D, S, ? super T2> fact) {
		D pda = fact.create(null, null);
		Map<E, S> states = Maps.newHashMap();
		Map<E, S> stops = Maps.newHashMap();
		Multimap<E, E> callers = new CfgUtil().getCallers(cfg);
		Set<S> followerStates = Sets.newLinkedHashSet();
		Iterable<E> starts = ff.getStarts(cfg.getRoot());
		create(cfg, pda, pda.getStart(), cfg.getRoot(), starts, true, ff, element2token, fact, states, stops, callers, followerStates, Sets.<E> newHashSet());
		fact.setFollowers(pda, pda.getStart(), followerStates);
		return pda;
	}

	protected <S, E, T1, T2, D extends Nfa<S>> void create(Cfg<E, T1> cfg, D pda, S state, E ele, Iterable<E> followerElements, boolean canEnter,
			FollowerFunction<E> ff, Function<E, T2> tokens, NfaFactory<D, S, ? super T2> fact, Map<E, S> states, Map<E, S> stops, Multimap<E, E> callers,
			Set<S> followerStates, Set<E> visited) {
		if (!visited.add(ele))
			return;
		for (E fol : followerElements) {
			E e;
			if (fol == null) {
				E root = new ProductionUtil().getRoot(cfg, ele);
				if (root == cfg.getRoot())
					followerStates.add(pda.getStop());
				for (E c : callers.get(root)) {
					// S s = stops.get(c);
					// if (s == null) {
					// s = fact.createPop(pda, tokens.apply(c));
					// stops.put(c, s);
					create(cfg, pda, state, c, ff.getFollowers(c), true, ff, tokens, fact, states, stops, callers, followerStates, visited);
					// }
					// followerStates.add(s);
				}
			} else if (canEnter && (e = cfg.getCall(fol)) != null) {
				// S s = states.get(fol);
				// if (s == null) {
				// s = fact.createPush(pda, tokens.apply(fol));
				// states.put(fol, s);
				create(cfg, pda, state, e, ff.getStarts(e), true, ff, tokens, fact, states, stops, callers, followerStates, visited);
				// }
				// followerStates.add(s);
			} else {
				S s = states.get(fol);
				if (s == null) {
					s = fact.createState(pda, tokens.apply(fol));
					states.put(fol, s);
					Set<S> sfollowerStates = Sets.newLinkedHashSet();
					create(cfg, pda, s, fol, ff.getFollowers(fol), true, ff, tokens, fact, states, stops, callers, sfollowerStates, Sets.<E> newHashSet());
					fact.setFollowers(pda, s, sfollowerStates);
				}
				followerStates.add(s);
			}

		}
	}
}
