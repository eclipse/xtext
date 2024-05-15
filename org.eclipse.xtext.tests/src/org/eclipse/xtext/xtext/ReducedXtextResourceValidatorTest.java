/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author efftinge - Initial contribution and API
 */
public class ReducedXtextResourceValidatorTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
		resourceValidator = get(ReducedXtextResourceValidator.class);
	}

	private ReducedXtextResourceValidator resourceValidator;

	@Test
	public void testNoEcoreLinkingErrors() throws Exception {
		String grammarAsString = "grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://test' as test\n" +
				"Root returns test::Foo: name=ID;";
		List<Issue> issues = resourceValidator.validate(getErroneousResource(grammarAsString),
				CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		Assert.assertEquals(issues.toString(), 0, issues.size());
	}

	@Test
	public void testSyntaxErrors() throws Exception {
		String grammarAsString = "grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://test' as test\n" +
				"Root returns test::Foo: name=ID;;";
		List<Issue> issues = resourceValidator.validate(getErroneousResource(grammarAsString),
				CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		Assert.assertEquals(issues.toString(), 1, issues.size());
		Assert.assertTrue(issues.toString(),
				Iterables.getFirst(issues, null).getMessage().contains("extraneous input ';'"));
	}

	@Test
	public void testRuleLinkingErrors() throws Exception {
		String grammarAsString = "grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://test' as test\n" +
				"Root returns test::Foo : name=IDS;";
		List<Issue> issues = resourceValidator.validate(getErroneousResource(grammarAsString),
				CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		Assert.assertEquals(issues.toString(), 1, issues.size());
		Assert.assertTrue(issues.toString(), Iterables.getFirst(issues, null).getMessage().contains("IDS"));
	}

	@Test
	public void testGrammarLinkingErrors() throws Exception {
		String grammarAsString = "grammar test.Lang with org.eclipse.xtext.common.Trminals\n" +
				"import 'http://test' as test\n" +
				"Root returns test::Foo : name='foo';";
		List<Issue> issues = resourceValidator.validate(getErroneousResource(grammarAsString),
				CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		Assert.assertEquals(issues.toString(), 1, issues.size());
		Assert.assertTrue(issues.toString(), Iterables.getFirst(issues, null).getMessage().contains("Trminals"));
	}

	public XtextResource getErroneousResource(CharSequence seq) throws Exception {
		return doGetResource(getAsStream(seq.toString()), getTestModelURI());
	}
}
