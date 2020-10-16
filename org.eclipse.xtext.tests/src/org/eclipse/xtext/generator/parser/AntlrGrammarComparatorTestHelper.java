/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.parser;

import org.eclipse.xtext.generator.parser.AntlrGrammarComparator.ErrorContext;
import org.eclipse.xtext.generator.parser.AntlrGrammarComparator.IErrorHandler;

/**
 * @author Christian Schneider - Initial contribution and API
 */
public class AntlrGrammarComparatorTestHelper {
	public static class ComparisonError extends AssertionError {
		private static final long serialVersionUID = 4348093404265434183L;

		private final int lineNoTestee;

		private final int lineNoExpected;

		public ComparisonError(String msg) {
			super(msg);
			this.lineNoTestee = -1;
			this.lineNoExpected = -1;
		}

		public ComparisonError(int lineNoTestee, int lineNoExpected, String msg) {
			super(msg);
			this.lineNoTestee = lineNoTestee;
			this.lineNoExpected = lineNoExpected;
		}
	}

	private static class TestErrorHandler implements IErrorHandler {
		@Override
		public void handleMismatch(String match, String matchReference, ErrorContext context) {
			fail(context.getTestedGrammar().getLineNumber(), context.getReferenceGrammar().getLineNumber(),
					"Inputs differs at token " + match + " (line " + context.getTestedGrammar().getLineNumber()
							+ "), expected token " + matchReference + " (line "
							+ context.getReferenceGrammar().getLineNumber() + ").");
		}

		@Override
		public void handleInvalidGeneratedGrammarFile(ErrorContext context) {
			fail("Noticed an unmatched character sequence in 'testee' in/before line "
					+ context.getTestedGrammar().getLineNumber() + ".");
		}

		@Override
		public void handleInvalidReferenceGrammarFile(ErrorContext context) {
			fail("Noticed an unmatched character sequence in 'expected' in/before line "
					+ context.getReferenceGrammar().getLineNumber() + ".");
		}
	}

	private final AntlrGrammarComparator comparator = new AntlrGrammarComparator();

	private final TestErrorHandler errorHandler = new TestErrorHandler();

	public ErrorContext compare(CharSequence grammar, CharSequence grammarReference) {
		return comparator.compareGrammars(grammar, grammarReference, errorHandler);
	}

	/**
	 * This method delegates to 'compare(..., ...)' and expects a
	 * {@link ComparisonError} reporting a mismatch in the given line numbers.
	 * If so the error is dropped. If the error reports different line numbers
	 * the error is re-thrown indicating a failure in the test. If no error
	 * occurs in 'compare(..., ...)' this test is supposed to fail.
	 */
	public void compareAndExpectMismatchInLines(String testee, String expected, int lineNoTestee, int lineNoExpected) {
		try {
			this.compare(testee, expected);
		} catch (ComparisonError e) {
			if (lineNoTestee == e.lineNoTestee && lineNoExpected == e.lineNoExpected) {
				return;
			} else {
				throw e;
			}
		}
		fail("Expected mismatch in lines " + lineNoTestee + "/" + lineNoExpected + ".");
	}

	private static void fail(String msg) {
		throw new ComparisonError(msg);
	}

	private static void fail(int lineNoTestee, int lineNoExpected, String msg) {
		throw new ComparisonError(lineNoTestee, lineNoExpected, msg);
	}
}
