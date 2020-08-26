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
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions
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

	static class CustomFormatter extends GenericFormatter<IDList> {
		override format(IDList model, ITextRegionExtensions regionAccess, extension IFormattableDocument document) {
			model.regionFor.keyword("idlist").append[oneSpace]
		}
	}

	@Test def void SL_inline() {
		assertFormatted[
			toBeFormatted = '''
				idlist  //x
				a
			'''
			formatter = new CustomFormatter()
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
			formatter = new CustomFormatter()
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
			formatter = new CustomFormatter()
			expectation = '''
				idlist /*x*/ a
			'''
		]
	}

	@Test def void MLSL_double_inline() {
		assertFormatted[
			toBeFormatted = '''
				idlist  /*x*//*y*/  a
			'''
			formatter = new CustomFormatter()
			expectation = '''
				idlist /*x*/ /*y*/ a
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
			formatter = new CustomFormatter()
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
			formatter = new CustomFormatter()
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
			formatter = new CustomFormatter()
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
