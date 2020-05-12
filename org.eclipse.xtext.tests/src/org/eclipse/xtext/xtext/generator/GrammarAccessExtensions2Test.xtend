/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextRuntimeModule
import org.eclipse.xtext.common.TerminalsStandaloneSetup
import org.eclipse.xtext.testing.IInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.util.Strings.toUnixLineSeparator

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class GrammarAccessExtensions2Test {
	
	@Inject extension ParseHelper<Grammar>
	@Inject extension GrammarAccessExtensions

	@Test def testGrammarFragmentToString() {
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
		'''.firstRuleIsConvertedTo('''
			//OpOther:
			//	'->'
			//	| '..<'
			//	| '>' '..'
			//	| '..'
			//	| '=>'
			//	| '>' (=> ('>' '>') | '>') | '<' (=> ('<' '<') | '<' | '=>') | '<>'
			//	| '?:';
		''')
	}

	private def firstRuleIsConvertedTo(CharSequence text, CharSequence expected) {
		val actual = text.toUnixLineSeparator.parse.rules.head.grammarFragmentToString("//")
		Assert.assertEquals(expected.toString.trim, actual)
	}

	static class XtextInjectorProvider implements IInjectorProvider {

		override getInjector() {

			TerminalsStandaloneSetup.doSetup

			Guice.createInjector(new XtextRuntimeModule(), new Module() {

				override configure(Binder binder) {
					binder.bind(IXtextProjectConfig).toInstance(new StandardProjectConfig)
				}

			})

		}
	}
}