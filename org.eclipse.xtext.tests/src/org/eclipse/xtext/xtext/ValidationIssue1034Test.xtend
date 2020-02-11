/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.tests.XtextInjectorProvider
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.XtextPackage.Literals.PARSER_RULE
import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.INVALID_FRAGMENT_AS_FIRST_RULE

/**
 * @author Eva Poell - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class ValidationIssue1034Test extends AbstractXtextTests {

	@Inject extension ParseHelper<Grammar>
	@Inject extension ValidationTestHelper

	@Before
	override setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup)
	}

	@Test
	def void check_FirstRuleIsNotFragment() {
		'''grammar com.space.Test with org.eclipse.xtext.common.Terminals
		generate testDSL "http://space.com/test"
		Model:
			"type" type=ID;'''.parse.assertNoIssues
	}

	@Test
	def void check_FirstRuleIsFragment() {
		'''grammar com.space.Test with org.eclipse.xtext.common.Terminals
		generate testDSL "http://space.com/test"
		fragment Model:
			"type" type=ID;'''.error
	}
	
	@Test
	def void check_FirstRuleIsFragmentEmpty() {
		'''grammar com.space.Test with org.eclipse.xtext.common.Terminals
		generate testDSL "http://space.com/test"
		fragment Model:
			"error"
		Greeting:
			'Hello' name=ID '!';'''.error
	}
	
	@Test
	def void check_FirstRuleIsFragmentParams() {
		'''grammar foo with org.eclipse.xtext.common.Terminals
		generate mm "http://bar"
		fragment MyRule<MyParam>:
		    <MyParam> name=ID
		  | <!MyParam> name=STRING
		  | name='name'
		;'''.error
	}

	private def error(CharSequence input) {
		input.parse.assertError(PARSER_RULE, INVALID_FRAGMENT_AS_FIRST_RULE, "must not be a fragment")
	}
}
