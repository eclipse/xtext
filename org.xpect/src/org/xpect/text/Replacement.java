package org.xpect.text;

/**
 * 
 * @author Moritz Eysholdt
 */
public class Replacement extends Region implements IReplacement {

	private final String replacement;

	public Replacement(int offset, int length, String replacement) {
		super(offset, length);
		this.replacement = replacement;
	}

	public String getReplacement() {
		return replacement;
	}

}
