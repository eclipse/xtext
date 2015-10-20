/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser

import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarComparator
import org.junit.Test

import static org.junit.Assert.*

/**
 * Contributes unit tests for {@link AntlrGrammarComparator}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class AntlrGrammarComparatorTest {

	AntlrGrammarComparator comparator = new AntlrGrammarComparator

	TestErrorHandler errorHandler = new TestErrorHandler
	
	private def compare(CharSequence grammar, CharSequence grammarReference) {
		comparator.compareGrammars(grammar, grammarReference, errorHandler);
	}
	
	/**
	 * The pattern of "\"" is not expected to occur in ANTLR grammar,
	 *  so I use it for testing the unmatched token check.
	 */
	@Test(expected = AssertionError)
	def void unmatchedTokens01() {
		val testee = '''
			"\""a
		'''
		
		testee.compare(testee)
	}
	
	@Test
	def void stringMatch_00a() {
		val testee = '''
			hans
		'''
		
		val expected = '''
			hans
		'''
		
		testee.compare(expected)
	} 
	
	@Test
	def void stringMatch_00b() {
		val testee =   '''hans'''
		
		val expected = '''hans'''
		
		testee.compare(expected)
	} 
	
	@Test
	def void stringMatch_01a() {
		val testee = '''
			hans hugo
		'''
		
		val expected = '''
			hans hugo
		'''
		
		testee.compare(expected)
	} 
	
	@Test
	def void stringMatch_01b() {
		val testee =   '''hans hugo'''
		
		val expected = '''hans hugo'''
		
		testee.compare(expected)
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_01a() {
		val testee = '''
			hans hugo
		'''
		
		val expected = '''
			hugo hans
		'''
		
		testee.compare(expected)
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_01b() {
		val testee =   '''hans hugo'''
		
		val expected = '''hugo hans'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_02a() {
		val testee = '''
			hans
		'''
		
		val expected = '''
			hans hugo
		'''
		
		testee.compare(expected)
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_02b() {
		val testee =   '''hans'''
		
		val expected = '''hans hugo'''
		
		testee.compare(expected)
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_03a() {
		val testee = '''
			hans hugo
		'''
		
		val expected = '''
			hans
		'''
		
		testee.compare(expected)
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_03b() {
		val testee =   '''hans hugo'''
		
		val expected = '''hans'''
		
		testee.compare(expected)
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_04() {
		val testee   = '''hans hu'''
		
		val expected = '''hans hugo'''
		
		testee.compare(expected)
	} 
	
	@Test(expected = AssertionError)
	def void stringMismatch_05() {
		val testee   = '''hans hugo'''
		
		val expected = '''hans hu'''
		
		testee.compare(expected)
	} 

	@Test
	def void regExMatch01() {
		val expected = '''
			RULE_IN_RICH_STRING?
		'''
		
		val testee = '''
			RULE_IN_RICH_STRING ?
 		'''
		
		testee.compare(expected)
	}

	@Test
	def void regExMatch02() {
		val expected = '''
			RULE_IN_RICH_STRING*
		'''
		
		val testee = '''
			RULE_IN_RICH_STRING *
 		'''
		
		testee.compare(expected)
	}

	@Test
	def void regExMatch03() {
		val expected = '''
			RULE_IN_RICH_STRING+
		'''
		
		val testee = '''
			RULE_IN_RICH_STRING +
 		'''
		
		testee.compare(expected)
	}

	@Test
	def void snippetMatch01() {
		val expected = '''
			grammar InternalStatemachine;
			options {
				superClass=AbstractInternalAntlrParser;
			}
		'''
		
		val testee = '''
			grammar InternalStatemachine ;
			options{
				superClass = AbstractInternalAntlrParser
				;
			}
		'''
		
		testee.compare(expected)
	}

	@Test
	def void snippetMatch02() {
		val expected = '''
			((	'abstract' 
			 | 	'annotation' 
			 | 	'class' 
			 | 	'(' 
			 |  RULE_ID | 	RULE_HEX )
		'''
		
		val testee = '''
			(
				('abstract' | 'annotation' | 'class' | '(' | RULE_ID | RULE_HEX )
 		'''
		
		testee.compare(expected)
	}
	
	@Test
	def void matchAllTokens01() {
		
		val testee = '''
			RULE_RICH_TEXT : '\'\'\'' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);
		'''
		
		testee.compare(testee)
	}
	
	@Test
	def void matchAllTokens02() {
		val testee = '''
			RULE_RICH_TEXT_START : '\'\'\'' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';
			
			RULE_RICH_TEXT_END : '\u00BB' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);
			
			RULE_RICH_TEXT_INBETWEEN : '\u00BB' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';
			
			RULE_COMMENT_RICH_TEXT_INBETWEEN : '\u00AB\u00AB' ~(('\n'|'\r'))* ('\r'? '\n' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB')?;
			
			RULE_COMMENT_RICH_TEXT_END : '\u00AB\u00AB' ~(('\n'|'\r'))* ('\r'? '\n' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF)|EOF);
		'''
		
		testee.compare(testee)
	}
	
	
	@Test(expected = AssertionError)
	def void mismatchOfParantheses01() {
		val testee = '''
			hans ( ( hugo )
		'''
		
		val expected = '''
			hans ( hugo )
		'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void mismatchOfParantheses02() {
		val testee = '''
			hans ( hugo ) )
		'''
		
		val expected = '''
			hans ( hugo )
		'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void mismatchOfParantheses03() {
		val testee = '''
			{ '(' ( ')' }
		'''
		
		val expected = '''
			{ '(' ')' }
		'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void mismatchOfParantheses04() {
		val testee = '''
			{ '(' '( ')' }
		'''
		
		val expected = '''
			{ '(' '(' ')' }
		'''
		
		testee.compare(expected)		
	}



	private static class TestErrorHandler implements AntlrGrammarComparator.IErrorHandler {
		
		override handleMismatch(String match, String matchReference, AntlrGrammarComparator.ErrorContext context) {
			fail('''
				Inputs differs at token «match» (line «context.testedGrammar.lineNumber»), expected token «
					matchReference» (line «context.referenceGrammar.lineNumber» ).
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