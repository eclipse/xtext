/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(FormatterTestLanguageInjectorProvider)
class CommentFormatterTest {
	@Inject extension GenericFormatterTester
	//@Inject extension FormatterTestLanguageGrammarAccess

	@Test def void SL_inline() {
		assertFormatted[
			toBeFormatted = '''
				idlist  //x
				a
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionFor.keyword("idlist").append[oneSpace]
			]
			expectation = '''
				idlist //x
				a
			'''
		]
	}
	
	@Test def void SL_multiline() {
		assertFormatted[
			toBeFormatted = '''
				idlist  
				
				//x
				
				
				a
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionFor.keyword("idlist").append[oneSpace]
			]
			expectation = '''
				idlist //x
				a
			'''
		]
	}
	
	@Test def void MLSL_inline() {
		assertFormatted[
			toBeFormatted = '''
				idlist  /*x*/  a
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionFor.keyword("idlist").append[oneSpace]
			]
			expectation = '''
				idlist /*x*/ a
			'''
		]
	}
	
	@Test def void MLSL_paragraph() {
		assertFormatted[
			toBeFormatted = '''
				idlist
				
				
				/*x*/
				
				
				a
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionFor.keyword("idlist").append[oneSpace]
			]
			expectation = '''
				idlist /*x*/
				a
			'''
		]
	}
	
	@Test def void MLML_inline() {
		assertFormatted[
			toBeFormatted = '''
				idlist  /*
				x
				*/  a
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionFor.keyword("idlist").append[oneSpace]
			]
			expectation = '''
				idlist
				/*
				 * x
				 */
				a
			'''
		]
	}
	
	@Test def void MLML_paragraph() {
		assertFormatted[
			toBeFormatted = '''
				idlist
				
				
				/*
				x
				*/
				
				
				a
			'''
			formatter = [ IDList model, extension regions, extension document |
				model.regionFor.keyword("idlist").append[oneSpace]
			]
			expectation = '''
				idlist
				
				
				/*
				 * x
				 */
				a
			'''
		]
	}


}
