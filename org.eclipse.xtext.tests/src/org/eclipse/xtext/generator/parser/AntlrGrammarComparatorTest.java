/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.parser;

import org.junit.Test;

/**
 * Contributes unit tests for {@link AntlrGrammarComparator}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
public class AntlrGrammarComparatorTest {
	private AntlrGrammarComparatorTestHelper antlrGrammarComparatorTestHelper = new AntlrGrammarComparatorTestHelper();

	/**
	 * The pattern of "\"" is not expected to occur in ANTLR grammar, so I use
	 * it for testing the unmatched token check.
	 */
	@Test(expected = AssertionError.class)
	public void unmatchedTokens01() {
		String testee = "\"\"\"a\n";
		antlrGrammarComparatorTestHelper.compare(testee, testee);
	}

	@Test
	public void stringMatch_00a() {
		String testee = "hans\n";
		String expected = "hans\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void stringMatch_00b() {
		String testee = "hans";
		String expected = "hans";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void stringMatch_01a() {
		String testee = "hans hugo\n";
		String expected = "hans hugo\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void stringMatch_01b() {
		String testee = "hans hugo";
		String expected = "hans hugo";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_01a() {
		String testee = "hans hugo\n";
		String expected = "hugo hans\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_01b() {
		String testee = "hans hugo";
		String expected = "hugo hans";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_02a() {
		String testee = "hans\n";
		String expected = "hans hugo\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_02b() {
		String testee = "hans";
		String expected = "hans hugo";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_03a() {
		String testee = "hans hugo\n";
		String expected = "hans\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_03b() {
		String testee = "hans hugo";
		String expected = "hans";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_04() {
		String testee = "hans hu";
		String expected = "hans hugo";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void stringMismatch_05() {
		String testee = "hans hugo";
		String expected = "hans hu";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void regExMatch01() {
		String expected = "RULE_IN_RICH_STRING?\n";
		String testee = "RULE_IN_RICH_STRING ?\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void regExMatch02() {
		String expected = "RULE_IN_RICH_STRING*\n";
		String testee = "RULE_IN_RICH_STRING *\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void regExMatch03() {
		String expected = "RULE_IN_RICH_STRING+\n";
		String testee = "RULE_IN_RICH_STRING +\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void snippetMatch01() {
		String expected =
				"grammar InternalStatemachine;\n" +
				"options {\n" +
				"	superClass=AbstractInternalAntlrParser;\n" +
				"}\n";
		String testee =
				"grammar InternalStatemachine ;\n" +
				"options{\n" +
				"	superClass = AbstractInternalAntlrParser\n" +
				"	;\n" +
				"}\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void snippetMatch02() {
		String expected =
				"((	'abstract' \n" +
				" | 	'annotation' \n" +
				" | 	'class' \n" +
				" | 	'(' \n" +
				" |  RULE_ID | 	RULE_HEX )\n";
		String testee =
				"(\n" +
				"	('abstract' | 'annotation' | 'class' | '(' | RULE_ID | RULE_HEX )\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void matchAllTokens01() {
		String testee = "RULE_RICH_TEXT : ''''' RULE_IN_RICH_STRING* ('''''|(''' '''?)? EOF);\n";
		antlrGrammarComparatorTestHelper.compare(testee, testee);
	}

	@Test
	public void matchAllTokens02() {
		String testee =
				"RULE_RICH_TEXT_START : '\\'\\'\\'' RULE_IN_RICH_STRING* ('\\'' '\\''?)? '\\u00AB';\n" +
				"\n" +
				"RULE_RICH_TEXT_END : '\\u00BB' RULE_IN_RICH_STRING* ('\\'\\'\\''|('\\'' '\\''?)? EOF);\n" +
				"\n" +
				"RULE_RICH_TEXT_INBETWEEN : '\\u00BB' RULE_IN_RICH_STRING* ('\\'' '\\''?)? '\\u00AB';\n" +
				"\n" +
				"RULE_COMMENT_RICH_TEXT_INBETWEEN : '\\u00AB\\u00AB' ~(('\\n'|'\\r'))* ('\\r'? '\\n' RULE_IN_RICH_STRING* ('\\'' '\\''?)? '\\u00AB')?;\n" +
				"\n" +
				"RULE_COMMENT_RICH_TEXT_END : '\\u00AB\\u00AB' ~(('\\n'|'\\r'))* ('\\r'? '\\n' RULE_IN_RICH_STRING* ('\\'\\'\\''|('\\'' '\\''?)? EOF)|EOF);n";
		antlrGrammarComparatorTestHelper.compare(testee, testee);
	}

	@Test(expected = AssertionError.class)
	public void mismatchOfParantheses01() {
		String testee = "hans ( ( hugo )\n";
		String expected = "hans ( hugo )\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void mismatchOfParantheses02() {
		String testee = "hans ( hugo ) )\n";
		String expected = "hans ( hugo )\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void mismatchOfParantheses03() {
		String testee = "{ '(' ( ')' }\n";
		String expected = "{ '(' ')' }\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test(expected = AssertionError.class)
	public void mismatchOfParantheses04() {
		String testee = "{ '(' '( ')' }\n";
		String expected = "{ '(' '(' ')' }\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void sLCommentIgnoring01() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"// rule B\n" +
				"B: 'B'\n";
		String expected =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void sLCommentIgnoring01b() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		String expected = "A: 'A'\n" +
				"\n" +
				"// rule B\n" +
				"B: 'B'\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void mismatchWithSLComment01() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		String expected =
				"A: 'A'\n" +
				"\n" +
				"// rule B\n" +
				"B: 'C'\n";
		antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 3, 4);
	}

	@Test(expected = AssertionError.class)
	public void mismatchWithSLComment01b() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		String expected =
				"A: 'A'\n" +
				"\n" +
				"// rule B\n" +
				"B: 'C'\n";
		// expected to fail because of wrong 'lineNoTestee'
		antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 4, 4);
	}

	@Test
	public void mLCommentIgnoring01() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"/*\n" +
				" * rule B\n" +
				" */\n" +
				"B: 'B'\n";
		String expected =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void mLCommentIgnoring01b() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		String expected =
				"A: 'A'\n" +
				"\n" +
				"/*\n" +
				" * rule B\n" +
				" */\n" +
				"B: 'B'\n";
		antlrGrammarComparatorTestHelper.compare(testee, expected);
	}

	@Test
	public void mismatchWithMLComment01() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		String expected =
				"A: 'A'\n" +
				"\n" +
				"/*\n" +
				" * rule B\n" +
				" */\n" +
				"B: 'C'\n";
		antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 3, 6);
	}

	@Test(expected = AssertionError.class)
	public void mismatchWithMLComment01b() {
		String testee =
				"A: 'A'\n" +
				"\n" +
				"B: 'B'\n";
		String expected =
				"A: 'A'\n" +
				"\n" +
				"/*\n" +
				" * rule B\n" +
				" */\n" +
				"B: 'C'\n";
		// expected to fail because of wrong 'lineNoExpected'
		antlrGrammarComparatorTestHelper.compareAndExpectMismatchInLines(testee, expected, 3, 5);
	}
}
