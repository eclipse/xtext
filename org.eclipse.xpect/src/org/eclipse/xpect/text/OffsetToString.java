package org.eclipse.xpect.text;

public class OffsetToString {
	private CharSequence document;
	private int offset;
	private int vicinityChars = 16;

	public OffsetToString with(int offset, CharSequence document) {
		this.document = document;
		this.offset = offset;
		return this;
	}

	public OffsetToString withVicinityChars(int vicinityChars) {
		this.vicinityChars = vicinityChars;
		return this;
	}

	@Override
	public String toString() {
		CharSequence prefix = CharSequences.getPrefix(document, offset, vicinityChars);
		CharSequence postfix = CharSequences.getPostfix(document, offset, vicinityChars);
		String result = prefix + "|" + postfix;
		return result.replace("\n", "\\n");
	}
}
