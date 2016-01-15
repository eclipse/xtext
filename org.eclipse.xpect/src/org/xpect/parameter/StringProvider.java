package org.xpect.parameter;

import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;

import com.google.common.base.Preconditions;

@XpectSetupFactory
public class StringProvider {
	private final StringRegion region;

	public StringProvider(StringRegion region) {
		Preconditions.checkNotNull(region);
		this.region = region;
	}

	@Creates
	public String getStringValue() {
		String text = region.getRegionText();
		return text;
	}
}
