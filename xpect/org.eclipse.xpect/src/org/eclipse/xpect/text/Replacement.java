package org.eclipse.xpect.text;

/**
 * 
 * @author Moritz Eysholdt
 */
public class Replacement extends Region implements IReplacement {

	private final String replacement;

	public Replacement(CharSequence document, int offset, int length, String replacement) {
		super(document, offset, length);
		this.replacement = replacement;
	}

	public String getReplacement() {
		return replacement;
	}

}
