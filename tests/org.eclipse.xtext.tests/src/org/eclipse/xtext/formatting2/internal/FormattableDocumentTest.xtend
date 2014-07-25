/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.formatting2.FormatterPreferenceKeys.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(FormatterTestLanguageInjectorProvider)
class FormattableDocumentTest {
	@Inject extension GenericFormatterTester
	@Inject extension FormatterTestLanguageGrammarAccess

	@Test def void simple() {
		assertFormatted[
			toBeFormatted = '''
				idlist  a
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionForKeyword("idlist").append[oneSpace]
			]
			expectation = '''
				idlist a
			'''
		]
	}

	@Test def void autowrap() {
		assertFormatted[
			preferences[
				put(maxLineWidth, 10)
			]
			toBeFormatted = '''
				idlist  aaa  bbb  ccc  ddd  eee  fff
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionsForRuleCallsTo(IDRule).forEach[prepend[autowrap; oneSpace]]
			]
			expectation = '''
				idlist aaa
				bbb ccc
				ddd eee fff
			'''
		]
	}

	@Test def void autoWrapWithSpan() {
		assertFormatted[
			preferences[
				put(maxLineWidth, 10)
			]
			toBeFormatted = '''
				kwlist  kw1  kw2  kw3  kw4
			'''
			formatter = [ KWList model, extension regions, extension document |
				model.regionForKeyword("kwlist").append[autowrap(6); oneSpace]
				model.regionForKeyword("kw1").append[autowrap; oneSpace]
				model.regionForKeyword("kw2").append[autowrap; oneSpace]
				model.regionForKeyword("kw3").append[autowrap; oneSpace]
				model.regionForKeyword("kw4").append[autowrap; newLine]
			]
			expectation = '''
				kwlist
				kw1 kw2
				kw3 kw4
			'''
		]
	}

	@Test def void conditionalFormatting1() {
		assertFormatted[
			preferences[
				put(maxLineWidth, 10)
			]
			toBeFormatted = '''
				kwlist  kw1  kw2
			'''
			formatter = [ KWList model, extension regions, extension document |
				model.formatConditionally(
					[ doc |
						val extension fits = doc.requireFitsInLine
						model.regionForKeyword("kwlist").append[oneSpace]
						model.regionForKeyword("kw1").append[oneSpace]
					],
					[ extension doc |
						model.regionForKeyword("kwlist").append[newLine]
						model.regionForKeyword("kw1").append[newLine]
					])
			]
			expectation = '''
				kwlist
				kw1
				kw2
			'''
		]
	}

	@Test def void conditionalFormatting2() {
		assertFormatted[
			preferences[
				put(maxLineWidth, 30)
			]
			toBeFormatted = '''
				kwlist  kw1  kw2
			'''
			formatter = [ KWList model, extension regions, extension document |
				model.formatConditionally(
					[ doc |
						val extension fits = doc.requireFitsInLine
						model.regionForKeyword("kwlist").append[oneSpace]
						model.regionForKeyword("kw1").append[oneSpace]
					],
					[ extension doc |
						model.regionForKeyword("kwlist").append[newLine]
						model.regionForKeyword("kw1").append[newLine]
					])
			]
			expectation = '''
				kwlist kw1 kw2
			'''
		]
	}
}
