/*******************************************************************************
 * Copyright (c) 2019, 2020 RCP Vision s.r.l. (http://www.rcp-vision.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.eclipse.xtext.xtext.ui.XtextUiInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.EMPTY_KEYWORD
import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.SPACES_IN_KEYWORD

/**
 * @author loradd - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextUiInjectorProvider)
class XtextGrammarQuickfixTest extends AbstractQuickfixTest {
	
	@Test def test_convert_terminal_fragment_to_terminal_rule() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			
			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
			
			Model hidden(ABC):
				a = ID;
			
			terminal fragment ABC:
				'a';
		'''.testQuickfixesOn(
			"org.eclipse.xtext.grammar.InvalidHiddenTokenFragment",
			new Quickfix("Convert terminal fragment to terminal rule", "Convert terminal fragment to terminal rule", '''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				
				generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
				
				Model hidden(ABC):
					a = ID;
				
				terminal ABC:
					'a';
			'''),
			new Quickfix("Remove hidden token definition", "Remove hidden token definition", '''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				
				generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
				
				Model hidden():
					a = ID;
				
				terminal fragment ABC:
					'a';
			''')
		);
	}
	
	@Test def test_convert_terminal_fragment_to_terminal_rule_01() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			
			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
			
			Model:
				a = ABC;
			
			terminal fragment ABC:
				'a';
		'''.testQuickfixesOn(
			"org.eclipse.xtext.grammar.InvalidTerminalFragmentRuleReference",
			new Quickfix("Convert terminal fragment to terminal rule", "Convert terminal fragment to terminal rule", '''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				
				generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
				
				Model:
					a = ABC;
				
				terminal ABC:
					'a';
			''')
		);
	}

	@Test def test_fix_invalid_hidden_token() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			
			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
			
			Model hidden(AnotherModel):
				a = ID;
			
			AnotherModel:
				b = ID;
		'''.testQuickfixesOn(
			"org.eclipse.xtext.grammar.InvalidHiddenToken",
			new Quickfix("Remove hidden token definition", "Remove hidden token definition", '''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				
				generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
				
				Model hidden():
					a = ID;
				
				AnotherModel:
					b = ID;
			''')
		);
	}

	@Test def test_fix_missing_rule() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			
			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
			
			Model:
				greetings+=Greeting*;
		'''.testQuickfixesOn(
			"org.eclipse.xtext.grammar.UnresolvedRule",
			new Quickfix("Create rule 'Greeting'", "Create rule 'Greeting'", '''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				
				generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
				
				Model:
					greetings+=Greeting*;
				
				Greeting:
					
				;
			'''),
			new Quickfix("Create enum rule 'Greeting'", "Create enum rule 'Greeting'", '''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				
				generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
				
				Model:
					greetings+=Greeting*;
				
				enum Greeting:
					
				;
			'''),
			new Quickfix("Create terminal 'Greeting'", "Create terminal 'Greeting'", '''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				
				generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
				
				Model:
					greetings+=Greeting*;
				
				terminal Greeting:
					
				;
			''')
		);
	}

	@Test def test_fix_empty_keyword() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			generate myDsl "http://www.xtext.org/mydsl/MyDsl"
			
			Model: "" a=ID;
		'''
		.testQuickfixesOn(EMPTY_KEYWORD, 
			removeEmptyKeywordQuickfix('''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				generate myDsl "http://www.xtext.org/mydsl/MyDsl"
				
				Model:  a=ID;
			'''), 
			replaceEmptyKeywordWithRuleNameQuickfix('''
				grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
				generate myDsl "http://www.xtext.org/mydsl/MyDsl"
				
				Model: "model" a=ID;
			''')
		);
	}
	
	@Test def fix_keyword_with_spaces() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			generate myDsl "http://www.xtext.org/mydsl/MyDsl"

			Model: ' a b c d ' a=ID;
		'''.applyKeywordWithSpacesQuickfix('''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			generate myDsl "http://www.xtext.org/mydsl/MyDsl"
			
			Model: 'a' 'b' 'c' 'd' a=ID;
		''')
	}

	@Test def fix_empty_keyword_with_spaces() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			generate myDsl "http://www.xtext.org/mydsl/MyDsl"
			
			Model: '    ' a=ID;
		'''.applyKeywordWithSpacesQuickfix('''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			generate myDsl "http://www.xtext.org/mydsl/MyDsl"
			
			Model: 'model' a=ID;
		''')
	}

	private def removeEmptyKeywordQuickfix(String result) {
		new Quickfix("Remove empty keyword", "Remove empty keyword", result)
	}

	private def replaceEmptyKeywordWithRuleNameQuickfix(String result) {
		new Quickfix("Replace empty keyword with rule name", "Replace empty keyword with rule name", result)
	}

	private def applyKeywordWithSpacesQuickfix(CharSequence input, String result) {
		val issueCode = SPACES_IN_KEYWORD
		val label = "Fix keyword with spaces"
		val description = "Fix keyword with spaces"

		input.testQuickfixesOn(issueCode, new Quickfix(label, description, result))
	}
}