package org.xpect.parameter;

import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;

@XpectSetupFactory
public class StringProvider {
	private final StringRegion region;

	public StringProvider() {
		super();
		this.region = null;
	}

	public StringProvider(StringRegion region) {
		super();
		this.region = region;
	}

	@Creates
	public String getStringValue() {
		if (region == null)
			return null;
		String text = region.getRegionText();
		return text;
	}
}
