/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PdaListFormatter<STATE, STACKITEM> implements Function<Pda<STATE, STACKITEM>, String> {

	protected static class ObjToStrFunction<OBJ> implements Function<OBJ, String> {
		@Override
		public String apply(OBJ from) {
			return from == null ? "null" : from.toString();
		}
	}

	protected Function<? super STACKITEM, String> stackitemFormatter = new ObjToStrFunction<STACKITEM>();

	protected Function<? super STATE, String> stateFormatter = new ObjToStrFunction<STATE>();

	protected boolean sortFollowers = false;

	public PdaListFormatter<STATE, STACKITEM> sortFollowers() {
		this.sortFollowers = true;
		return this;
	}

	@Override
	public String apply(Pda<STATE, STACKITEM> pda) {
		return format(pda);
	}

	public String format(Pda<STATE, STACKITEM> pda) {
		STATE start = pda.getStart();
		List<String> result = Lists.newArrayList();
		for (STATE s : new NfaUtil().collect(pda))
			if (s != start) {
				String str = format(pda, s);
				if (str != null)
					result.add(str);
			}
		Collections.sort(result);
		String startstring = format(pda, start);
		if (startstring != null)
			result.add(0, startstring);
		return Joiner.on('\n').join(result);
	}

	protected String title(Pda<STATE, STACKITEM> pda, STATE state) {
		STACKITEM push = pda.getPush(state);
		STACKITEM pop = pda.getPop(state);
		StringBuilder result = new StringBuilder();
		if (push != null) {
			result.append(">>");
			result.append(stackitemFormatter.apply(push));
		}
		if (pop != null) {
			result.append("<<");
			result.append(stackitemFormatter.apply(pop));
		}
		if (result.length() == 0)
			result.append(stateFormatter.apply(state));
		return result.toString();
	}

	public String format(Pda<STATE, STACKITEM> pda, STATE state) {
		Iterable<STATE> followers2 = pda.getFollowers(state);
		if (!followers2.iterator().hasNext())
			return null;
		List<String> followers = Lists.newArrayList();
		for (STATE f : followers2)
			followers.add(title(pda, f));
		if (sortFollowers)
			Collections.sort(followers);
		return title(pda, state) + " -> " + Joiner.on(", ").join(followers);
	}

	public Function<? super STACKITEM, String> getStackitemFormatter() {
		return stackitemFormatter;
	}

	public Function<? super STATE, String> getStateFormatter() {
		return stateFormatter;
	}

	public PdaListFormatter<STATE, STACKITEM> setStackitemFormatter(
			Function<? super STACKITEM, String> stackitemFormatter) {
		this.stackitemFormatter = stackitemFormatter;
		return this;
	}

	public PdaListFormatter<STATE, STACKITEM> setStateFormatter(Function<? super STATE, String> stateFormatter) {
		this.stateFormatter = stateFormatter;
		return this;
	}

}
