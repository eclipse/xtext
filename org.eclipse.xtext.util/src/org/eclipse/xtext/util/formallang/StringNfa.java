/******t*************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Arrays;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringNfa implements Nfa<String> {

	public static class StringNfaFactory implements NfaFactory<StringNfa, String, Object> {

		protected String nullStart;
		protected String nullState;
		protected String nullStop;

		public StringNfaFactory() {
			this("(start:null)", "(stop:null)");
		}

		public StringNfaFactory(String nullStart, String nullStop) {
			this(nullStart, nullStop, "(null)");
		}

		public StringNfaFactory(String nullStart, String nullStop, String nullState) {
			super();
			this.nullStart = nullStart;
			this.nullStop = nullStop;
			this.nullState = nullState;
		}

		@Override
		public StringNfa create(Object start, Object stop) {
			String starts = start != null ? start.toString() : nullStart;
			String stops = stop != null ? stop.toString() : nullStop;
			return new StringNfa(starts, stops);
		}

		@Override
		public String createState(StringNfa nfa, Object token) {
			return token != null ? token.toString() : nullState;
		}

		@Override
		public void setFollowers(StringNfa nfa, String owner, Iterable<String> followers) {
			nfa.state(owner).followedBy(Iterables.toArray(followers, String.class));
		}

	}

	protected class StringNfaState {
		protected String name;

		protected StringNfaState(String name) {
			super();
			this.name = name;
		}

		public StringNfaState followedBy(String... states) {
			StringNfa.this.followers.putAll(name, Arrays.asList(states));
			return this;
		}
	}

	protected final Multimap<String, String> followers = ArrayListMultimap.create();
	protected final String start;
	protected final String stop;

	public StringNfa(String start, String stop) {
		super();
		this.start = start;
		this.stop = stop;
	}

	@Override
	public Iterable<String> getFollowers(String state) {
		return followers.get(state);
	}

	@Override
	public String getStart() {
		return start;
	}

	@Override
	public String getStop() {
		return stop;
	}

	public StringNfaState start() {
		return new StringNfaState(start);
	}

	public StringNfaState state(String state) {
		return new StringNfaState(state);
	}

	public StringNfaState stop() {
		return new StringNfaState(stop);
	}

}
