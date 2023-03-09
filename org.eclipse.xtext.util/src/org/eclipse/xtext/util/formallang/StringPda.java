/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringPda extends StringNfa implements Pda<String, String> {

	public static class StringPdaFactory<T> implements PdaFactory<StringPda, String, String, T> {

		protected Function<T, String> formatter;
		protected String nullStart;
		protected String nullState;
		protected String nullStop;

		public StringPdaFactory() {
			this("(start:null)", "(stop:null)");
		}

		public StringPdaFactory(String nullStart, String nullStop) {
			this(nullStart, nullStop, "(null)");
		}

		public StringPdaFactory(String nullStart, String nullStop, String nullState) {
			super();
			this.nullStart = nullStart;
			this.nullStop = nullStop;
			this.nullState = nullState;
		}

		@Override
		public StringPda create(T start, T stop) {
			return new StringPda(tokenToStr(start, nullStart), tokenToStr(stop, nullStop));
		}

		@Override
		public String createPop(StringPda pda, T token) {
			String pop = tokenToStr(token, nullState);
			String s = pop.startsWith("<<") ? pop : "<<" + pop;
			pda.state(s).pop(pop);
			return s;
		}

		@Override
		public String createPush(StringPda pda, T token) {
			String push = tokenToStr(token, nullState);
			String s = push.startsWith(">>") ? push : ">>" + push;
			pda.state(s).push(push);
			return s;
		}

		@Override
		public String createState(StringPda pda, T token) {
			return tokenToStr(token, nullState);
		}

		@Override
		public void setFollowers(StringPda pda, String owner, Iterable<String> followers) {
			pda.state(owner).followedBy(Iterables.toArray(followers, String.class));
		}

		public StringPdaFactory<T> setTokenFormatter(Function<T, String> formatter) {
			this.formatter = formatter;
			return this;
		}

		protected String tokenToStr(T token, String nullValue) {
			if (token == null)
				return nullValue;
			if (formatter != null)
				return formatter.apply(token);
			return token.toString();
		}

	}

	public class StringPDAState extends StringNfaState {

		protected StringPDAState(String name) {
			super(name);
		}

		@Override
		public StringPDAState followedBy(String... states) {
			super.followedBy(states);
			return this;
		}

		public StringPDAState pop(String pop) {
			StringPda.this.pops.put(name, pop);
			return this;
		}

		public StringPDAState push(String push) {
			StringPda.this.pushs.put(name, push);
			return this;
		}

	}

	protected final Map<String, String> pops = Maps.newLinkedHashMap();
	protected final Map<String, String> pushs = Maps.newLinkedHashMap();

	public StringPda(String start, String stop) {
		super(start, stop);
	}

	@Override
	public String getPop(String state) {
		return pops.get(state);
	}

	@Override
	public String getPush(String state) {
		return pushs.get(state);
	}

	@Override
	public StringPDAState start() {
		return new StringPDAState(start);
	}

	@Override
	public StringPDAState state(String state) {
		return new StringPDAState(state);
	}

	@Override
	public StringPDAState stop() {
		return new StringPDAState(stop);
	}

}
