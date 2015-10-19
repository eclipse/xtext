/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser

import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarComparator
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorComparisonFragment
import org.junit.Test

import static org.junit.Assert.*

/**
 * Contributes unit test for {@link XtextAntlrGeneratorComparisonFragment}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class XtextAntlrGeneratorComparisonFragmentTest {

	AntlrGrammarComparator comparator = new AntlrGrammarComparator

	TestErrorHandler errorHandler = new TestErrorHandler
	
	private def compare(CharSequence grammar, CharSequence grammarReference) {
		return comparator.compareGrammars(grammar, grammarReference, errorHandler);
	}
	
	@Test
	def void match_test01() {
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
	def void match_test02() {
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
	def void match_test03() {
		val expected = '''
			RULE_IN_RICH_STRING?
		'''
		
		val testee = '''
			RULE_IN_RICH_STRING ?
 		'''
		
		testee.compare(expected)
	}

	@Test
	def void match_test04() {
		val expected = '''
			RULE_IN_RICH_STRING*
		'''
		
		val testee = '''
			RULE_IN_RICH_STRING *
 		'''
		
		testee.compare(expected)
	}

	@Test
	def void match_test05() {
		val expected = '''
			RULE_IN_RICH_STRING+
		'''
		
		val testee = '''
			RULE_IN_RICH_STRING +
 		'''
		
		testee.compare(expected)
	}
	
	@Test
	def void unmatchedTokens_test01() {
		
		val testee = '''
			RULE_RICH_TEXT : '\'\'\'' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);
		'''
		
		testee.compare(testee)
	}
	
	@Test
	def void unmatchedTokens_test02() {
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
	def void mismatch_test01() {
		val testee = '''
			hans hugo
		'''
		
		val expected = '''
			hugo
		'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void mismatch_test02() {
		val testee = '''
			hans ( ( hugo )
		'''
		
		val expected = '''
			hans ( hugo )
		'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void mismatch_test03() {
		val testee = '''
			hans ( hugo ) )
		'''
		
		val expected = '''
			hans ( hugo )
		'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void mismatch_test04() {
		val testee = '''
			{ '(' ( ')' }
		'''
		
		val expected = '''
			{ '(' ')' }
		'''
		
		testee.compare(expected)		
	} 
	
	@Test(expected = AssertionError)
	def void mismatch_test05() {
		val testee = '''
			{ '(' '( ')' }
		'''
		
		val expected = '''
			{ '(' '(' ')' }
		'''
		
		testee.compare(expected)		
	}
	
	private static class TestErrorHandler extends AntlrGrammarComparator.ErrorHandler {
		
		override handleMismatch(String match, String matchReference, int lineNo, int lineNoReference) {
			fail('''
				Inputs differs at token «match» (line «lineNo»), expected token «matchReference» (line «lineNoReference» ).
			''')
		}
		
		override handleUnexpectedCharSequence(String absoluteGrammarFileName, int lineNo) {
			fail('''
				Noticed an unmatched character sequence in/before line «lineNo».
			''')
		}
	}
}