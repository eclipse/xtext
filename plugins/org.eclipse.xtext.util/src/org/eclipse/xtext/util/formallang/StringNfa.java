/******t*************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Arrays;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringNfa implements Nfa<String> {

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

	public Iterable<String> getFollowers(String state) {
		return followers.get(state);
	}

	public String getStart() {
		return start;
	}

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
