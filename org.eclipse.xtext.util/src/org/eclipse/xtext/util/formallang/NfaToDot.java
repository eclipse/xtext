/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import org.eclipse.xtext.util.GraphvizDotBuilder;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaToDot<STATE> extends GraphvizDotBuilder {

	protected Function<STATE, String> stateFormatter;

	protected Node create(Digraph result, Nfa<STATE> nfa, STATE state) {
		Node n = new Node(state, stateToString(nfa, state));
		if (state == nfa.getStart() || state == nfa.getStop())
			n.setShape("box");
		return n;
	}

	protected Edge create(Digraph result, Nfa<STATE> nfa, STATE from, STATE to) {
		return new Edge(from, to);
	}

	protected void draw(Digraph result, Nfa<STATE> nfa) {
		for (STATE s : new NfaUtil().collect(nfa)) {
			result.add(create(result, nfa, s));
			for (STATE f : nfa.getFollowers(s))
				result.add(create(result, nfa, s, f));
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Props drawObject(Object obj) {
		Digraph result = new Digraph();
		if (obj instanceof Nfa<?>)
			draw(result, (Nfa<STATE>) obj);
		return result;
	}

	public NfaToDot<STATE> setStateFormatter(Function<STATE, String> stateFormatter) {
		this.stateFormatter = stateFormatter;
		return this;
	}

	protected String stateToString(Nfa<STATE> nfa, STATE state) {
		if (stateFormatter != null)
			return stateFormatter.apply(state);
		if (state == null)
			return "null";
		return state.toString();
	}
}
