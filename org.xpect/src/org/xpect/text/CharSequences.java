package org.xpect.text;

public class CharSequences {
	public static <T extends CharSequence> T getMostSimilarCandiate(Iterable<? extends T> candiates, T defautValue, CharSequence similarTo) {
		if (similarTo == null || similarTo.length() == 0)
			return defautValue;
		T result = defautValue;
		int rating = 0;
		for (T candiate : candiates) {
			int r = getSimilarity(candiate, similarTo);
			if (r > rating) {
				rating = r;
				result = candiate;
			}
		}
		return result;
	}

	public static int getSimilarity(CharSequence s1, CharSequence s2) {
		int result = 0;
		int length = Math.min(s1.length(), s2.length());
		for (int i = 0; i < length; i++)
			if (s1.charAt(i) == s2.charAt(i))
				result++;
			else
				break;
		for (int i = 1; i <= length; i++)
			if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - i))
				result++;
			else
				break;
		return result;
	}
}
