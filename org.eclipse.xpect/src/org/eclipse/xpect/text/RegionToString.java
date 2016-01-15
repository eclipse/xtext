package org.eclipse.xpect.text;

public class RegionToString {
	private IRegion region;
	private int vicinityChars = 16;

	public RegionToString with(IRegion region) {
		this.region = region;
		return this;
	}

	public RegionToString withVicinityChars(int vicinityChars) {
		this.vicinityChars = vicinityChars;
		return this;
	}

	@Override
	public String toString() {
		CharSequence document = region.getDocument();
		int offset = region.getOffset();
		int end = offset + region.getLength();
		CharSequence prefix = CharSequences.getPrefix(document, offset, vicinityChars);
		CharSequence infix = document.subSequence(offset, end);
		CharSequence postfix = CharSequences.getPostfix(document, end, vicinityChars);
		String result = prefix + ">>>" + infix + "<<<" + postfix;
		return result.replace("\n", "\\n");
	}
}
