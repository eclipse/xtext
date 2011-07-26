package org.eclipse.xtext.util.formallang;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringPda extends StringNfa implements Pda<String, String> {

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
