package de.itemis.statefullexer;

import java.util.Collections;

import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaFactory;

import de.itemis.statefullexer.TokenPDA.TokenPDAState;

@SuppressWarnings("restriction")
public class TokenPDA<T, S> implements Pda<TokenPDAState<T>, S> {

	public enum PDAStateType {
		ELEMENT, POP, PUSH, START, STOP
	}

	public static class TokenPDAFactory<T, S> implements PdaFactory<Pda<TokenPDAState<T>, S>, TokenPDAState<T>, S, T> {

		@Override
		public Pda<TokenPDAState<T>, S> create(T start, T stop) {
			return new TokenPDA<T, S>(new TokenPDAState<T>(start, PDAStateType.START), new TokenPDAState<T>(stop, PDAStateType.STOP));
		}

		@Override
		public TokenPDAState<T> createPop(Pda<TokenPDAState<T>, S> pda, T token) {
			return new TokenPDAState<T>(token, PDAStateType.POP);
		}

		@Override
		public TokenPDAState<T> createPush(Pda<TokenPDAState<T>, S> pda, T token) {
			return new TokenPDAState<T>(token, PDAStateType.PUSH);
		}

		@Override
		public TokenPDAState<T> createState(Pda<TokenPDAState<T>, S> nfa, T token) {
			return new TokenPDAState<T>(token, PDAStateType.ELEMENT);
		}

		@Override
		public void setFollowers(Pda<TokenPDAState<T>, S> nfa, TokenPDAState<T> owner, Iterable<TokenPDAState<T>> followers) {
			owner.followers = followers;
		}

	}

	public static class TokenPDAState<S> {
		protected Iterable<TokenPDAState<S>> followers;
		protected S token;
		protected PDAStateType type;

		protected TokenPDAState(S token, PDAStateType type) {
			super();
			this.token = token;
			this.type = type;
		}

		public Iterable<TokenPDAState<S>> getFollowers() {
			return followers == null ? Collections.<TokenPDAState<S>> emptyList() : followers;
		}

		public S getToken() {
			return token;
		}

		public PDAStateType getType() {
			return type;
		}

		@Override
		public String toString() {
			return type + ": " + token;
		}

	}

	protected final TokenPDAState<T> start;

	protected final TokenPDAState<T> stop;

	public TokenPDA(TokenPDAState<T> startStates, TokenPDAState<T> finalStates) {
		this.start = startStates;
		this.stop = finalStates;
	}

	public Iterable<TokenPDAState<T>> getFollowers(TokenPDAState<T> node) {
		return node.getFollowers();
	}

	@Override
	@SuppressWarnings("unchecked")
	public S getPop(TokenPDAState<T> state) {
		if (state.type == PDAStateType.POP)
			return (S) state.token;
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public S getPush(TokenPDAState<T> state) {
		if (state.type == PDAStateType.PUSH)
			return (S) state.token;
		return null;
	}

	public TokenPDAState<T> getStart() {
		return start;
	}

	public TokenPDAState<T> getStop() {
		return stop;
	}
}