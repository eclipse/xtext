package org.eclipse.xpect.text;

import org.eclipse.xpect.util.IDifferencer.ISimilarityFunction;

import com.google.common.base.Strings;

public class StringEndsSimilarityFunction implements ISimilarityFunction<String> {

	private final float TRESHOLD;

	public StringEndsSimilarityFunction(float treshold) {
		super();
		this.TRESHOLD = treshold;
	}

	public StringEndsSimilarityFunction() {
		this(0.4f);
	}

	public float similarity(String s1, String s2) {
		if (Strings.isNullOrEmpty(s1) || Strings.isNullOrEmpty(s2))
			return ISimilarityFunction.UPPER_SIMILARITY_BOUND;
		if (s1.equals(s2))
			return ISimilarityFunction.EQUAL;
		int minChars = Math.min(s1.length(), s2.length());
		int maxChars = Math.max(s1.length(), s2.length());
		if (minChars / maxChars < TRESHOLD)
			return ISimilarityFunction.UPPER_SIMILARITY_BOUND;
		int charsInCommon = 0;
		for (int i = 0; i < minChars; i++)
			if (s1.charAt(i) == s2.charAt(i))
				charsInCommon++;
			else
				break;
		minChars -= charsInCommon;
		for (int i = 1; i <= minChars; i++)
			if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - i))
				charsInCommon++;
			else
				break;
		if (charsInCommon == 0)
			return ISimilarityFunction.UPPER_SIMILARITY_BOUND;
		float ratio = ISimilarityFunction.UPPER_SIMILARITY_BOUND - ((float) charsInCommon / maxChars);
		return Math.min(ratio * (1 / TRESHOLD), ISimilarityFunction.UPPER_SIMILARITY_BOUND);
	}

}