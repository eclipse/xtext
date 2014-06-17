package org.xpect.text;

import java.util.List;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class WhitespaceTokenizer implements Function<String, List<String>> {

	public List<String> apply(String input) {
		List<String> result = Lists.newArrayList();
		if (!Strings.isEmpty(input)) {
			int lastOffset = 0;
			boolean lastWs = Character.isWhitespace(input.charAt(0));
			for (int offset = 1; offset < input.length(); offset++) {
				char c = input.charAt(offset);
				boolean ws = Character.isWhitespace(c);
				if (ws != lastWs) {
					String token = input.substring(lastOffset, offset);
					result.add(token);
					lastOffset = offset;
					lastWs = ws;
				}
			}
			String token = input.substring(lastOffset, input.length());
			result.add(token);
		}
		return result;
	}

}
