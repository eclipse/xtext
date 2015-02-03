/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.AbstractList;
import java.util.List;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ImmutableRevNfa<T> extends RevNfa<T> {

	private static class ImmutableMappedList<T> extends AbstractList<T> {
		private final int[] contents;
		private final T[] map;

		private ImmutableMappedList(int[] contents, T[] map) {
			this.contents = contents;
			this.map = map;
		}

		@Override
		public T get(int index) {
			return map[contents[index]];
		}

		@Override
		public int size() {
			return contents.length;
		}

	}

	protected static class ImmutableState<T> extends State<T> {
		private final int[] followers;
		private final int[] preceders;
		private final T token;
		private final int tokenId;

		protected ImmutableState(int tokenId, T token, int[] followers, int[] preceders) {
			super();
			this.tokenId = tokenId;
			this.token = token;
			this.followers = followers;
			this.preceders = preceders;
		}

		@Override
		public int getFollowerCount() {
			return followers.length;
		}

		@Override
		public int[] getFollowers() {
			return followers;
		}

		@Override
		public int getPrecederCount() {
			return preceders.length;
		}

		@Override
		public int[] getPreceeders() {
			return preceders;
		}

		@Override
		public T getToken() {
			return token;
		}

		@Override
		public int getTokenId() {
			return tokenId;
		}

	}

	private final String hashString;
	private final ImmutableState<T>[] states;

	public ImmutableRevNfa(ImmutableState<T>[] states) {
		super();
		this.states = states;
		this.hashString = hashString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof ImmutableRevNfa<?>)
			return hashString.equals(((ImmutableRevNfa<?>) obj).hashString);
		if (obj instanceof MutableRevNfa<?>)
			return obj.equals(this);
		return false;
	}

	@Override
	public List<State<T>> getFollowers(State<T> state) {
		return new ImmutableMappedList<State<T>>(state.getFollowers(), states);
	}

	@Override
	public List<State<T>> getPreceders(State<T> state) {
		return new ImmutableMappedList<State<T>>(state.getPreceeders(), states);
	}

	@Override
	public State<T> getStart() {
		return states[0];
	}

	@Override
	public State<T> getStop() {
		return states[1];
	}

	@Override
	public int hashCode() {
		return hashString.hashCode();
	}

	protected String hashString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < states.length; i++) {
			ImmutableState<T> state = states[i];
			if (state == null)
				continue;
			if (i > 0)
				result.append(';');
			result.append(state.tokenId);
			result.append(':');
			int[] followers = state.followers;
			for (int j = 0; j < followers.length; j++) {
				if (j > 0)
					result.append('-');
				result.append(states[followers[j]].tokenId);
			}
		}
		return result.toString();
	}

	public MutableRevNfa<T> mutableCopy() {
		return new MutableRevNfa<T>(this);
	}

}
