/**
 * Copyright (c) 2019, 2021 RCP Vision s.r.l. (http://www.rcp-vision.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.XtextConfigurableIssueCodes;
import org.eclipse.xtext.xtext.ui.XtextUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author loradd - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextUiInjectorProvider.class)
public class XtextGrammarQuickfixTest extends AbstractQuickfixTest {

	@Override
	protected void assertIssueResolutionResult(String expectedResult, IssueResolution actualIssueResolution, String originalText) {
		super.assertIssueResolutionResult(Strings.toPlatformLineSeparator(expectedResult), actualIssueResolution, Strings.toPlatformLineSeparator(originalText));
	}
	
	@Override
	public void testQuickfixesOn(CharSequence content, String issueCode, Quickfix... quickfixes) {
		super.testQuickfixesOn(Strings.toPlatformLineSeparator(content), issueCode, quickfixes);
	}

	@Test
	public void test_convert_terminal_fragment_to_terminal_rule() {
		String result1 =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model hidden(ABC):\n" +
				"	a = ID;\n" +
				"\n" +
				"terminal ABC:\n" +
				"	'a';\n";
		Quickfix quickfix1 = new Quickfix("Convert terminal fragment to terminal rule", "Convert terminal fragment to terminal rule", result1);
		String result2 =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model hidden():\n" +
				"	a = ID;\n" +
				"\n" +
				"terminal fragment ABC:\n" +
				"	'a';\n";
		Quickfix quickfix2 = new Quickfix("Remove hidden token definition", "Remove hidden token definition", result2);
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model hidden(ABC):\n" +
				"	a = ID;\n" +
				"\n" +
				"terminal fragment ABC:\n" +
				"	'a';\n";
		testQuickfixesOn(model, "org.eclipse.xtext.grammar.InvalidHiddenTokenFragment", quickfix1, quickfix2);
	}

	@Test
	public void test_convert_terminal_fragment_to_terminal_rule_01() {
		String result =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model:\n" +
				"	a = ABC;\n" +
				"\n" +
				"terminal ABC:\n" +
				"	'a';\n";
		Quickfix quickfix = new Quickfix("Convert terminal fragment to terminal rule", "Convert terminal fragment to terminal rule", result);
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model:\n" +
				"	a = ABC;\n" +
				"\n" +
				"terminal fragment ABC:\n" +
				"	'a';\n";
		testQuickfixesOn(model, "org.eclipse.xtext.grammar.InvalidTerminalFragmentRuleReference", quickfix);
	}

	@Test
	public void test_fix_invalid_hidden_token() {
		String result =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model hidden():\n" +
				"	a = ID;\n" +
				"\n" +
				"AnotherModel:\n" +
				"	b = ID;\n";
		Quickfix quickfix = new Quickfix("Remove hidden token definition", "Remove hidden token definition", result);
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model hidden(AnotherModel):\n" +
				"	a = ID;\n" +
				"\n" +
				"AnotherModel:\n" +
				"	b = ID;\n";
		testQuickfixesOn(model, "org.eclipse.xtext.grammar.InvalidHiddenToken", quickfix);
	}

	@Test
	public void test_fix_missing_rule() {
		String result1 =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model:\n" +
				"	greetings+=Greeting*;\n" +
				"\n" +
				"Greeting:\n" +
				"	\n" +
				";\n";
		Quickfix quickfix1 = new Quickfix("Create rule 'Greeting'", "Create rule 'Greeting'", result1);
		String result2 =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model:\n" +
				"	greetings+=Greeting*;\n" +
				"\n" +
				"enum Greeting:\n" +
				"	\n" +
				";\n";
		Quickfix quickfix2 = new Quickfix("Create enum rule 'Greeting'", "Create enum rule 'Greeting'", result2);
		String result3 =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model:\n" +
				"	greetings+=Greeting*;\n" +
				"\n" +
				"terminal Greeting:\n" +
				"	\n" +
				";\n";
		Quickfix quickfix3 = new Quickfix("Create terminal 'Greeting'", "Create terminal 'Greeting'", result3);
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"Model:\n" +
				"	greetings+=Greeting*;\n";
		testQuickfixesOn(model, "org.eclipse.xtext.grammar.UnresolvedRule", quickfix1, quickfix2, quickfix3);
	}

	@Test
	public void test_fix_empty_keyword() {
		String result1 =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/mydsl/MyDsl'\n" +
				"\n" +
				"Model:  a=ID;\n";
		String result2 =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/mydsl/MyDsl'\n" +
				"\n" +
				"Model: \"model\" a=ID;\n";
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/mydsl/MyDsl'\n" +
				"\n" +
				"Model: \"\" a=ID;\n";
		testQuickfixesOn(
				model,
				XtextConfigurableIssueCodes.EMPTY_KEYWORD, removeEmptyKeywordQuickfix(result1),
				replaceEmptyKeywordWithRuleNameQuickfix(result2));
	}

	@Test
	public void fix_keyword_with_spaces() {
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/mydsl/MyDsl'\n" +
				"\n" +
				"Model: ' a b c d ' a=ID;\n";
		String result =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/mydsl/MyDsl'\n" +
				"\n" +
				"Model: 'a' 'b' 'c' 'd' a=ID;\n";
		applyKeywordWithSpacesQuickfix(model, result);
	}

	@Test
	public void fix_empty_keyword_with_spaces() {
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/mydsl/MyDsl'\n" +
				"\n" +
				"Model: '    ' a=ID;\n";
		String result =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/mydsl/MyDsl'\n" +
				"\n" +
				"Model: 'model' a=ID;\n";
		applyKeywordWithSpacesQuickfix(model, result);
	}

	private Quickfix removeEmptyKeywordQuickfix(final String result) {
		return new Quickfix("Remove empty keyword", "Remove empty keyword", result);
	}

	private Quickfix replaceEmptyKeywordWithRuleNameQuickfix(final String result) {
		return new Quickfix("Replace empty keyword with rule name", "Replace empty keyword with rule name", result);
	}

	private void applyKeywordWithSpacesQuickfix(final CharSequence input, final String result) {
		String issueCode = XtextConfigurableIssueCodes.SPACES_IN_KEYWORD;
		String label = "Fix keyword with spaces";
		String description = "Fix keyword with spaces";
		testQuickfixesOn(input, issueCode, new Quickfix(label, description, result));
	}
}
