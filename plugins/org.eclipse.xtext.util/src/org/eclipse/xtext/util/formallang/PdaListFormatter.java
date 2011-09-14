/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.inject.internal.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PdaListFormatter<STATE, STACKITEM> implements Function<Pda<STATE, STACKITEM>, String> {

	protected static class ObjToStrFunction<OBJ> implements Function<OBJ, String> {
		public String apply(OBJ from) {
			return from == null ? "null" : from.toString();
		}
	}

	protected Function<STACKITEM, String> stackitemFormatter = new ObjToStrFunction<STACKITEM>();

	protected Function<STATE, String> stateFormatter = new ObjToStrFunction<STATE>();

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
		result.add(0, format(pda, start));
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
		return title(pda, state) + " -> " + Joiner.on(", ").join(followers);
	}

	public Function<STACKITEM, String> getStackitemFormatter() {
		return stackitemFormatter;
	}

	public Function<STATE, String> getStateFormatter() {
		return stateFormatter;
	}

	public PdaListFormatter<STATE, STACKITEM> setStackitemFormatter(Function<STACKITEM, String> stackitemFormatter) {
		this.stackitemFormatter = stackitemFormatter;
		return this;
	}

	public PdaListFormatter<STATE, STACKITEM> setStateFormatter(Function<STATE, String> stateFormatter) {
		this.stateFormatter = stateFormatter;
		return this;
	}

}
