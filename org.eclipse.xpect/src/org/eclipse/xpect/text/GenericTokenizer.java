package org.eclipse.xpect.text;

import java.util.List;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class GenericTokenizer implements Function<String, List<String>> {

	public enum CharType {
		LETTER {
			@Override
			public boolean canContinue(CharType previous) {
				switch (previous) {
				case LETTER:
					return true;
				default:
					return false;
				}
			}
		},
		NUMBER {
			@Override
			public boolean canContinue(CharType previous) {
				switch (previous) {
				case LETTER:
				case NUMBER:
					return true;
				default:
					return false;
				}
			}
		},
		SPACE {
			@Override
			public boolean canContinue(CharType previous) {
				switch (previous) {
				case SPACE:
					return true;
				default:
					return false;
				}
			}
		},
		SYMBOL {
			@Override
			public boolean canContinue(CharType previous) {
				return false;
			}
		};

		public static CharType get(char c) {
			switch (Character.getType(c)) {
			case Character.TITLECASE_LETTER:
			case Character.UPPERCASE_LETTER:
			case Character.LOWERCASE_LETTER:
			case Character.OTHER_LETTER:
			case Character.MODIFIER_LETTER:
				return LETTER;
			case Character.LETTER_NUMBER:
			case Character.DECIMAL_DIGIT_NUMBER:
			case Character.OTHER_NUMBER:
				return NUMBER;
			case Character.LINE_SEPARATOR:
			case Character.PARAGRAPH_SEPARATOR:
			case Character.SPACE_SEPARATOR:
			case Character.CONTROL:
				return SPACE;
			case Character.COMBINING_SPACING_MARK:
			case Character.CONNECTOR_PUNCTUATION:
			case Character.CURRENCY_SYMBOL:
			case Character.DASH_PUNCTUATION:
			case Character.ENCLOSING_MARK:
			case Character.END_PUNCTUATION:
			case Character.FINAL_QUOTE_PUNCTUATION:
			case Character.FORMAT:
			case Character.INITIAL_QUOTE_PUNCTUATION:
			case Character.MATH_SYMBOL:
			case Character.MODIFIER_SYMBOL:
			case Character.NON_SPACING_MARK:
			case Character.OTHER_PUNCTUATION:
			case Character.OTHER_SYMBOL:
			case Character.PRIVATE_USE:
			case Character.START_PUNCTUATION:
			case Character.SURROGATE:
			case Character.UNASSIGNED:
			default:
				return SYMBOL;
			}
		}

		public abstract boolean canContinue(CharType previous);
	}

	public List<String> apply(String input) {
		List<String> result = Lists.newArrayList();
		if (!Strings.isEmpty(input)) {
			int lastOffset = 0;
			CharType lastType = CharType.get(input.charAt(0));
			for (int offset = 1; offset < input.length(); offset++) {
				char c = input.charAt(offset);
				CharType type = CharType.get(c);
				if (!type.canContinue(lastType)) {
					String token = input.substring(lastOffset, offset);
					result.add(token);
					lastOffset = offset;
					lastType = type;
				}
			}
			String token = input.substring(lastOffset, input.length());
			result.add(token);
		}
		return result;
	}

}
