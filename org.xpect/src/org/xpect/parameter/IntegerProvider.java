package org.xpect.parameter;

import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;

@XpectSetupFactory
public class IntegerProvider {

	private final IntegerRegion region;

	public IntegerProvider() {
		super();
		this.region = null;
	}

	public IntegerProvider(IntegerRegion region) {
		super();
		this.region = region;
	}

	@Creates
	public int getIntegerValue() {
		if (region == null)
			return 0;
		String text = region.getRegionText();
		return Integer.valueOf(text);
	}

}
