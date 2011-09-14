package org.eclipse.xtext.util.formallang;

import java.util.Map;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringPda extends StringNfa implements Pda<String, String> {

	public static class StringPdaFactory implements PdaFactory<String, String, Object> {

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

		public Pda<String, String> createPda(Object start, Object stop) {
			String starts = start != null ? start.toString() : nullStart;
			String stops = stop != null ? stop.toString() : nullStop;
			return new StringPda(starts, stops);
		}

		public String createPop(Pda<String, String> pda, Object token) {
			String pop = token != null ? token.toString() : nullState;
			String s = "<<" + pop;
			((StringPda) pda).state(s).pop(pop);
			return s;
		}

		public String createPush(Pda<String, String> pda, Object token) {
			String push = token != null ? token.toString() : nullState;
			String s = ">>" + push;
			((StringPda) pda).state(s).push(push);
			return s;
		}

		public String createState(Pda<String, String> pda, Object token) {
			return token != null ? token.toString() : nullState;
		}

		public void setFollowers(Pda<String, String> pda, String owner, Iterable<String> followers) {
			((StringPda) pda).state(owner).followedBy(Iterables.toArray(followers, String.class));
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

	protected final Map<String, String> pops = Maps.newHashMap();
	protected final Map<String, String> pushs = Maps.newHashMap();

	public StringPda(String start, String stop) {
		super(start, stop);
	}

	public String getPop(String state) {
		return pops.get(state);
	}

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
