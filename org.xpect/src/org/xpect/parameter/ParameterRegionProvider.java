package org.xpect.parameter;

import java.util.Collection;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.XpectInvocation;
import org.xpect.expectation.IExpectationRegion;
import org.xpect.text.IRegion;
import org.xpect.text.Text;

@StatementRelatedRegionProvider
public class ParameterRegionProvider implements IStatementRelatedRegionProvider {

	public class RefinableRegion extends StatementRelatedRegion implements IRefinableStatementRelatedRegion {

		public RefinableRegion(XpectInvocation invocation, int offset, int length) {
			super(invocation, offset, length);
		}

		public IStatementRelatedRegion refine(Collection<IStatementRelatedRegion> allRegions) {
			int start = getOffset(), end = getOffset() + getLength();
			for (IRegion claim : allRegions)
				if (claim != this) {
					int claimOffset = claim instanceof IExpectationRegion ? ((IExpectationRegion) claim).getOpeningSeparatorOffset() : claim.getOffset();
					int claimEnd = claim.getOffset() + claim.getLength();
					if (end > claimOffset && end <= claimEnd)
						end = claimOffset;
					if (start >= claimOffset && start < claimEnd)
						start = claimEnd;
				}
			return new ParameterRegion(getStatement(), start, end - start);
		}
	}

	public IStatementRelatedRegion getRegion(XpectInvocation invocation) {
		INode node = NodeModelUtils.getNode(invocation);
		int start = node.getOffset() + node.getLength();
		Text text = new Text(invocation.getFile().getDocument());
		int end = text.currentLineEnd(start);
		if (end < 0)
			end = invocation.getFile().getDocument().length();
		return new RefinableRegion(invocation, start, end - start);
	}

}
