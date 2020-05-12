/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.formatting.INodeModelFormatter
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.tests.XtextInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.resource.XtextResource

import static extension org.junit.Assert.assertEquals
import static extension org.eclipse.xtext.util.Strings.toUnixLineSeparator

/**
 * Test cases for the {@link XtextFormatter} class.
 * 
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class XtextFormatterTest {

	@Inject extension ParseHelper<Grammar>
	@Inject extension INodeModelFormatter

	@Test def formatting_with_windows_line_endings01() {
		'''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				  '->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=>('>' '>') | '>')
				| '<' (=>('<' '<') | '<' | '=>')
				| '<>'
				| '?:';'''
			.assertFormattedAs('''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				'->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=> ('>' '>') | '>')
				| '<' (=> ('<' '<') | '<' | '=>')
				| '<>'
				| '?:';'''
		)
	}

	@Test def formatting_with_windows_line_endings02() {
		'''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				  '->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=>('>' '>') | '>')
				| '<' (=>('<' '<') | '<' | '=>')
				| '<>'
				| '?:';
		'''.assertFormattedAs('''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				'->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=> ('>' '>') | '>')
				| '<' (=> ('<' '<') | '<' | '=>')
				| '<>'
				| '?:';'''
		)
	}

	@Test def formatting_with_unix_line_endings01() {
		'''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				  '->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=>('>' '>') | '>')
				| '<' (=>('<' '<') | '<' | '=>')
				| '<>'
				| '?:';'''
		.toUnixLineSeparator.assertFormattedAs('''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				'->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=> ('>' '>') | '>')
				| '<' (=> ('<' '<') | '<' | '=>')
				| '<>'
				| '?:';'''
		)
	}

	@Test def formatting_with_unix_line_endings02() {
		'''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				  '->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=>('>' '>') | '>')
				| '<' (=>('<' '<') | '<' | '=>')
				| '<>'
				| '?:';
		'''.toUnixLineSeparator.assertFormattedAs('''
			grammar org.xtext.example.mydsl.MyDsl

			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"

			OpOther:
				'->'
				| '..<'
				| '>' '..'
				| '..'
				| '=>'
				| '>' (=> ('>' '>') | '>')
				| '<' (=> ('<' '<') | '<' | '=>')
				| '<>'
				| '?:';'''
		)
	}

	private def assertFormattedAs(CharSequence input, CharSequence expected) {
		expected.toString.assertEquals(input.formattedText)
	}

	private def formattedText(CharSequence unformattedText) {
		val rootNode = (unformattedText.parse.eResource as XtextResource).parseResult.rootNode
		rootNode.format(0, unformattedText.length).formattedText
	}

}