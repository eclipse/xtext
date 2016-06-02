package org.eclipse.xpect.parameter;

import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;

import com.google.common.base.Preconditions;

@XpectSetupFactory
public class IntegerProvider {

	private final IntegerRegion region;

	public IntegerProvider(IntegerRegion region) {
		Preconditions.checkNotNull(region);
		this.region = region;
	}

	@Creates
	public int getIntegerValue() {
		String text = region.getRegionText();
		if (text != null)
			return Integer.valueOf(text);
		return 0;
	}

}
