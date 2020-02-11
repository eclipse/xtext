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
public class PdaToDot<STATE, STACKITEM> extends GraphvizDotBuilder {

	protected Function<STACKITEM, String> popFormatter;
	protected Function<STACKITEM, String> pushFormatter;
	protected Function<STATE, String> stateFormatter;

	protected Node create(Digraph result, Pda<STATE, STACKITEM> pda, STATE state) {
		Node n = new Node(state, stateToString(pda, state));
		if (state == pda.getStart() || state == pda.getStop())
			n.setShape("diamond");
		return n;
	}

	protected Edge create(Digraph result, Pda<STATE, STACKITEM> pda, STATE from, STATE to) {
		return new Edge(from, to);
	}

	protected void draw(Digraph result, Pda<STATE, STACKITEM> pda) {
		for (STATE s : new NfaUtil().collect(pda)) {
			result.add(create(result, pda, s));
			for (STATE f : pda.getFollowers(s))
				result.add(create(result, pda, s, f));
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Props drawObject(Object obj) {
		Digraph result = new Digraph();
		if (obj instanceof Pda<?, ?>)
			draw(result, (Pda<STATE, STACKITEM>) obj);
		return result;
	}

	public PdaToDot<STATE, STACKITEM> setPopFormatter(Function<STACKITEM, String> popFormatter) {
		this.popFormatter = popFormatter;
		return this;
	}

	public PdaToDot<STATE, STACKITEM> setPushFormatter(Function<STACKITEM, String> pushFormatter) {
		this.pushFormatter = pushFormatter;
		return this;
	}

	public PdaToDot<STATE, STACKITEM> setStateFormatter(Function<STATE, String> stateFormatter) {
		this.stateFormatter = stateFormatter;
		return this;
	}

	protected String stateToString(Pda<STATE, STACKITEM> pda, STATE state) {
		STACKITEM push = pda.getPush(state);
		STACKITEM pop = pda.getPop(state);
		if (pushFormatter != null && push != null)
			return pushFormatter.apply(push);
		if (popFormatter != null && pop != null)
			return popFormatter.apply(pop);
		String prefix = push != null && pop != null ? "<>" : push != null ? ">>" : pop != null ? "<<" : "";
		if (stateFormatter != null) {
			String fmt = stateFormatter.apply(state);
			return fmt.startsWith(prefix) ? fmt : prefix + fmt;
		}
		if (state == null)
			return prefix + "null";
		String fmt = state.toString();
		return fmt.startsWith(prefix) ? fmt : prefix + fmt;
	}
}
