/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Eva Poell - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class ValidationIssue1034Test extends AbstractXtextTests {
	@Inject
	private ParseHelper<Grammar> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void check_FirstRuleIsNotFragment() throws Exception {
		String grammarAsString = "grammar com.space.Test with org.eclipse.xtext.common.Terminals\n" +
				"generate testDSL 'http://space.com/test'\n" +
				"Model:\n" +
				"	'type' type=ID;";
		validationTestHelper.assertNoIssues(parseHelper.parse(grammarAsString));
	}

	@Test
	public void check_FirstRuleIsFragment() throws Exception {
		String grammarAsString = "grammar com.space.Test with org.eclipse.xtext.common.Terminals\n" +
				"generate testDSL 'http://space.com/test'\n" +
				"fragment Model:\n" +
				"	'type' type=ID;";
		error(grammarAsString);
	}

	@Test
	public void check_FirstRuleIsFragmentEmpty() throws Exception {
		String grammarAsString = "grammar com.space.Test with org.eclipse.xtext.common.Terminals\n" +
				"generate testDSL 'http://space.com/test'\n" +
				"fragment Model:\n" +
				"	'error'\n" +
				"Greeting:\n" +
				"	'Hello' name=ID '!';";
		error(grammarAsString);
	}

	@Test
	public void check_FirstRuleIsFragmentParams() throws Exception {
		String grammarAsString = "grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate mm 'http://bar'\n" +
				"fragment MyRule<MyParam>:\n" +
				"	<MyParam> name=ID\n" +
				"	| <!MyParam> name=STRING\n" +
				"	| name='name'\n" +
				";";
		error(grammarAsString);
	}

	private void error(CharSequence input) throws Exception {
		validationTestHelper.assertError(parseHelper.parse(input), XtextPackage.Literals.PARSER_RULE,
				XtextConfigurableIssueCodes.INVALID_FRAGMENT_AS_FIRST_RULE, "must not be a fragment");
	}
}
