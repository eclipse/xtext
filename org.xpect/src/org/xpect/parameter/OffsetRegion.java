package org.xpect.parameter;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.XpectInvocation;
import org.xpect.text.IRegion;

public class OffsetRegion extends DerivedRegion {

	private final int matchedOffset;
	private final DerivedRegion matchedRegion;

	public OffsetRegion(IStatementRelatedRegion origin, int offset, int length) {
		super(origin, offset, length);
		String val = getRegionText();
		int add = val.indexOf('|');
		if (add >= 0)
			val = val.substring(0, add) + val.substring(add + 1);
		else
			add = 0;
		XpectInvocation statement = getStatement();
		INode node = NodeModelUtils.getNode(statement);
		int nodeOffset = node.getOffset() + node.getLength();
		for (IStatementRelatedRegion region : statement.getRelatedRegions()) {
			int regionEnd = region.getOffset() + region.getLength();
			if (regionEnd > nodeOffset)
				nodeOffset = regionEnd;
		}
		String text = statement.getFile().getDocument();
		int result = text.indexOf(val, nodeOffset);
		if (result >= 0) {
			this.matchedOffset = result + add;
			if (add > 0)
				this.matchedRegion = createMatchedRegion(result, length - 1);
			else
				this.matchedRegion = createMatchedRegion(result, length);
		} else
			throw new RuntimeException("OFFSET '" + val + "' not found.");
	}

	private DerivedRegion createMatchedRegion(int offset, int length) {
		return new DerivedRegion(this, offset, length);
	}

	public int getMatchedOffset() {
		return matchedOffset;
	}

	public IRegion getMatchedRegion() {
		return matchedRegion;
	}

}
