/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser

/**
 * @author Christian Schneider - Initial contribution and API
 */
class AntlrGrammarComparatorTestHelper {

	private val AntlrGrammarComparator comparator = new AntlrGrammarComparator
	private val TestErrorHandler errorHandler = new TestErrorHandler

	def compare(CharSequence grammar, CharSequence grammarReference) {
		comparator.compareGrammars(grammar, grammarReference, errorHandler);
	}

	/**
	 * This method delegates to 'compare(..., ...)' and expects a {@link ComparisonError} reporting a mismatch
	 * in the given line numbers. If so the error is dropped. If the error reports different line numbers
	 * the error is re-thrown indicating a failure in the test. If no error occurs in 'compare(..., ...)'
	 * this test is supposed to fail. 
	 */
	def compareAndExpectMismatchInLines(String testee, String expected, int lineNoTestee, int lineNoExpected) {
		try {			
			testee.compare(expected)
		} catch (ComparisonError e) {
			if (lineNoTestee == e.lineNoTestee && lineNoExpected == e.lineNoExpected) {
				return
			} else {
				throw e;				
			}
		}
		
		fail('''Expected mismatch in lines «lineNoTestee»/«lineNoExpected».''')
	}

	private def static fail(String msg) {
		throw new ComparisonError(msg);
	}

	private def static fail(int lineNoTestee, int lineNoExpected, String msg) {
		throw new ComparisonError(lineNoTestee, lineNoExpected, msg);
	}

	static class ComparisonError extends AssertionError {
		
		private val int lineNoTestee 
		private val int lineNoExpected
		
		new(String msg) {
			super(msg)
			this.lineNoTestee = -1
			this.lineNoExpected = -1
		}
		
		new(int lineNoTestee, int lineNoExpected, String msg) {
			super(msg)
			this.lineNoTestee = lineNoTestee
			this.lineNoExpected = lineNoExpected
		}
	}

	private static class TestErrorHandler implements AntlrGrammarComparator.IErrorHandler {
		
		override handleMismatch(String match, String matchReference, AntlrGrammarComparator.ErrorContext context) {
			fail(context.testedGrammar.lineNumber, context.referenceGrammar.lineNumber, '''
				Inputs differs at token «match» (line «context.testedGrammar.lineNumber»), expected token «
					matchReference» (line «context.referenceGrammar.lineNumber»).
			''')
		}
		
		override handleInvalidGeneratedGrammarFile(AntlrGrammarComparator.ErrorContext context) {
			fail('''
				Noticed an unmatched character sequence in 'testee' in/before line «context.testedGrammar.lineNumber».
			''')
		}
		
		override handleInvalidReferenceGrammarFile(AntlrGrammarComparator.ErrorContext context) {
			fail('''
				Noticed an unmatched character sequence in 'expected' in/before line «context.referenceGrammar.lineNumber».
			''')
		}
	}
}