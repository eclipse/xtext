/*******************************************************************************
 * Copyright (c) 2019 RCP Vision s.r.l. (http://www.rcp-vision.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix

import org.eclipse.xtext.testing.IInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.eclipse.xtext.xtext.ui.Activator
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.EMPTY_KEYWORD
import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.SPACES_IN_KEYWORD

/**
 * @author loradd - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextGrammarQuickfixTest.InjectorProvider)
class XtextGrammarQuickfixTest extends AbstractQuickfixTest {
	
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

	static class InjectorProvider implements IInjectorProvider {
		override getInjector() {
			Activator.getDefault().getInjector(Activator.ORG_ECLIPSE_XTEXT_XTEXT)
		}
	}

}