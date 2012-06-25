package de.itemis.statefullexer;

import java.util.Collections;

import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaFactory;

import de.itemis.statefullexer.TokenNFA.TokenNfaState;

@SuppressWarnings("restriction")
public class TokenNFA<T> implements Nfa<TokenNfaState<T>> {

	public enum NFAStateType {
		ELEMENT, START, STOP
	}

	public static class TokenNFAFactory<T> implements NfaFactory<Nfa<TokenNfaState<T>>, TokenNfaState<T>, T> {

		@Override
		public Nfa<TokenNfaState<T>> create(T start, T stop) {
			return new TokenNFA<T>(new TokenNfaState<T>(start, NFAStateType.START), new TokenNfaState<T>(stop, NFAStateType.STOP));
		}

		@Override
		public TokenNfaState<T> createState(Nfa<TokenNfaState<T>> nfa, T token) {
			return new TokenNfaState<T>(token, NFAStateType.ELEMENT);
		}

		@Override
		public void setFollowers(Nfa<TokenNfaState<T>> nfa, TokenNfaState<T> owner, Iterable<TokenNfaState<T>> followers) {
			owner.followers = followers;
		}

	}

	public static class TokenNfaState<S> {
		protected Iterable<TokenNfaState<S>> followers;
		protected S token;
		protected NFAStateType type;

		protected TokenNfaState(S token, NFAStateType type) {
			super();
			this.token = token;
			this.type = type;
		}

		public Iterable<TokenNfaState<S>> getFollowers() {
			return followers == null ? Collections.<TokenNfaState<S>> emptyList() : followers;
		}

		public S getToken() {
			return token;
		}

		public NFAStateType getType() {
			return type;
		}

		@Override
		public String toString() {
			return type + ": " + token;
		}

	}

	protected final TokenNfaState<T> start;

	protected final TokenNfaState<T> stop;

	public TokenNFA(TokenNfaState<T> startStates, TokenNfaState<T> finalStates) {
		this.start = startStates;
		this.stop = finalStates;
	}

	public Iterable<TokenNfaState<T>> getFollowers(TokenNfaState<T> node) {
		return node.getFollowers();
	}

	public TokenNfaState<T> getStart() {
		return start;
	}

	public TokenNfaState<T> getStop() {
		return stop;
	}
}