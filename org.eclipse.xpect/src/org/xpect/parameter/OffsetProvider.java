package org.xpect.parameter;

import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.text.IRegion;

import com.google.common.base.Preconditions;

@XpectSetupFactory
public class OffsetProvider {
	private final OffsetRegion region;

	public OffsetProvider(OffsetRegion region) {
		Preconditions.checkNotNull(region);
		this.region = region;
	}

	@Creates
	public int getMatchedOffset() {
		return region.getMatchedOffset();
	}

	@Creates
	public IRegion getMatchedRegion() {
		return region.getMatchedRegion();
	}
}
