package org.xpect.parameter;

import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.text.IRegion;

@XpectSetupFactory
public class OffsetProvider {
	private final OffsetRegion region;

	public OffsetProvider(OffsetRegion region) {
		super();
		this.region = region;
	}

	public OffsetProvider() {
		super();
		this.region = null;
	}

	@Creates
	public int getMatchedOffset() {
		if (region == null)
			return 0;
		return region.getMatchedOffset();
	}

	@Creates
	public IRegion getMatchedRegion() {
		if (region == null)
			return null;
		return region.getMatchedRegion();
	}
}
