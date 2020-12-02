/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtext.ide.tests.testlanguage.signatureHelp.SignatureHelpServiceImpl;
import org.eclipse.xtext.testing.SignatureHelpConfiguration;
import org.junit.Test;

/**
 * Class for testing the {@link SignatureHelpService signature help service}
 * implementation.
 * 
 * @author akos.kitta - Initial contribution and API
 * @see SignatureHelpServiceImpl
 */
public class SignatureHelpTest extends AbstractTestLangLanguageServerTest {
	private static int LINE_NUMBER = 12;

	@Test
	public void singleArgsExactMatchAfterTriggerChar() {
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel("type A { op foo(a: A) { } } type Main { op main() { foo() } }");
			it.setLine(0);
			it.setColumn("type A { op foo(a: A) { } } type Main { op main() { foo(".length());
			it.setExpectedSignatureHelp("A.foo(a: A): void | a: A");
		});
	}

	@Test
	public void noArgsExactMatch() {
		String testMe = "foo()";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(".length());
			it.setExpectedSignatureHelp(
					"A.foo(): void | A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | <empty>");
		});
	}

	@Test
	public void firstArgExactMatch() {
		String testMe = "foo(1)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1".length());
			it.setExpectedSignatureHelp(
					"A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
		});
	}

	@Test
	public void secondArgExactMatch() {
		String testMe = "foo(1, 2)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1, 2".length());
			it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | b: B");
		});
	}

	@Test
	public void thirdArgExactMatch() {
		String testMe = "foo(1, 2, 3)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1, 2, 3".length());
			it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
		});
	}

	@Test
	public void singleArgWithLeadingWhitespace() {
		String testMe = "foo(     1)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(     1".length());
			it.setExpectedSignatureHelp(
					"A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
		});
	}

	@Test
	public void singleArgWithTrailingWhitespace() {
		String testMe = "foo(1    )";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1    ".length());
			it.setExpectedSignatureHelp(
					"A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
		});
	}

	@Test
	public void multipleArgsWithLeadingWhitespaceBeforeFirstArg_ExpectFirstArg() {
		String testMe = "foo(    1, 2)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(    1".length());
			it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
		});
	}

	@Test
	public void multipleArgsWithLeadingWhitespaceBeforeComma_ExpectFirstArg() {
		String testMe = "foo(    1   , 2)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(    1   ".length());
			it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
		});
	}

	@Test
	public void multipleArgsWithLeadingWhitespaceAtComma_ExpectFirstArg() {
		String testMe = "foo(    1   , 2)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(    1   ,".length());
			it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | b: B");
		});
	}

	@Test
	public void multipleArgsAtComma() {
		String testMe = "foo(1, 2, 3)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1, 2,".length());
			it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
		});
	}

	@Test
	public void multipleArgsAtCommaIncomplete() {
		String testMe = "foo(1, 2,)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1, 2,".length());
			it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
		});
	}

	@Test
	public void multipleArgsWithCommentAtCommaIncomplete() {
		String testMe = "foo(1, /*,*/ 2,)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1, /*,*/ 2,".length());
			it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
		});
	}

	@Test
	public void beforeOperationCall() {
		String testMe = "foo(1, 2)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo".length());
			it.setExpectedSignatureHelp("<empty>");
		});
	}

	@Test
	public void afterOperationCall() {
		String testMe = "foo(1, 2)";
		testSignatureHelp((SignatureHelpConfiguration it) -> {
			it.setModel(getModel(testMe));
			it.setLine(SignatureHelpTest.LINE_NUMBER);
			it.setColumn("foo(1, 2)".length());
			it.setExpectedSignatureHelp("<empty>");
		});
	}

	private String getModel(CharSequence method) {
		return "type A { \n" +
				"    op foo() { } \n" +
				"    op foo(a: A): string { }\n" +
				"}\n" +
				"type B { \n" +
				"    op foo(a: A, b: B): int { }\n" +
				"}\n" +
				"type C { \n" +
				"    op foo(a: A, b: B, c: C): void { }\n" +
				"}\n" +
				"type Test { \n" +
				"    op main() {\n" +
				method+"\n" + // this is not properly formatted, but neither was is xtend
				"    }\n" +
				"}\n";
	}
}
