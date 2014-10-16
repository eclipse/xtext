package org.xpect.parameter;

import org.eclipse.emf.common.util.EList;
import org.xpect.Member;
import org.xpect.XpectInvocation;
import org.xpect.text.CharSequences;
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
		IStatementRelatedRegion extendedRegion = statement.getExtendedRegion();
		int nodeOffset = extendedRegion.getOffset() + extendedRegion.getLength();
		String text = statement.getFile().getDocument();

		int result = -1;
		do {
			result = text.indexOf(val, nodeOffset);
			nodeOffset = result + 1;
		} while (isInsideStatementRegion(result));

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

	protected boolean isInsideStatementRegion(int offset) {
		if (offset < 0)
			return false;
		XpectInvocation statement = getStatement();
		EList<Member> members = statement.getFile().getMembers();
		for (int i = members.indexOf(statement) + 1; i < members.size(); i++) {
			Member member = members.get(i);
			if (member instanceof XpectInvocation) {
				IStatementRelatedRegion region = ((XpectInvocation) member).getExtendedRegion();
				int o = region.getOffset();
				int e = o + region.getLength();
				if (o <= offset && offset <= e)
					return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		int offset = matchedRegion.getOffset();
		int end = offset + matchedRegion.getLength();
		CharSequence document = getDocument();
		String prefix = CharSequences.getPrefix(document, offset, 24);
		String postfix = CharSequences.getPostfix(document, end, 24);
		String before = document.subSequence(offset, matchedOffset).toString();
		String after = document.subSequence(matchedOffset, end).toString();
		return prefix + ">>>" + before + "|" + after + "<<<" + postfix;

	}

}
