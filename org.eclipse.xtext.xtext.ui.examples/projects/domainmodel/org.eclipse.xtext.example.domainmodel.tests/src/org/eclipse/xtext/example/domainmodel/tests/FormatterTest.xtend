/*******************************************************************************
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(DomainmodelInjectorProvider)
class FormatterTest {

	@Inject extension FormatterTestHelper

	/**
	 * This example tests if the formatted document equals the unformatted document.
	 * This is the most convenient way to test a formatter.
	 */
	@Test def void example1() {
		assertFormatted[
			toBeFormatted = '''
				entity Foo {
					propertyName:String
				
					op name() {
						val x = 1 + 2 + 4
						val foo = {
							println()
							println()
							null
						}
					}
				}
			'''
		]
	}

	/**
	* This example tests whether a messy document is being formatted properly.
	* In contrast to the first example, this approach also allows to test formatting strategies that are input-aware.
	* Example: "Change newLines between tokens to be one at minimum, two at maximum."
	* Here, it depends on the formatters input document whether there will be one or two newLines on the output.
	*/
	@Test def void example2() {
		assertFormatted[
			expectation = '''
				entity Foo {
					op foo():String {
						"xx"
					}
				}
			'''
			toBeFormatted = '''
				entity Foo {  op  foo  (  )  :  String  {  "xx"  }  }
			'''
		]
	}

	/**
	* This example shows how to test property-dependent formatting behavior.
	*/
	@Test def void example3() {
		assertFormatted[
			preferences[
				put(FormatterPreferenceKeys.indentation, " ")
			]
			expectation = '''
				entity Foo {
				 op foo():String {
				  "xx"
				 }
				}
			'''
			toBeFormatted = '''
				entity Foo {
					op foo():String {
						"xx"
					}
				}
			'''
		]
	}
}
