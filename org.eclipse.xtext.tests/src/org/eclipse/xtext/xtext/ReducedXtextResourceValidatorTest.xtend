/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext

import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.junit.Test

/**
 * @author efftinge - Initial contribution and API
 */
class ReducedXtextResourceValidatorTest extends AbstractXtextTests {
	override void setUp() throws Exception {
		super.setUp()
		with(new XtextStandaloneSetup())
		this.resourceValidator = get(ReducedXtextResourceValidator)
	}
	
	ReducedXtextResourceValidator resourceValidator
	
	@Test def void testNoEcoreLinkingErrors() {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			import 'http://test' as test
			Root returns test::Foo: name=ID;
		'''
		val issues = resourceValidator.validate(grammarAsString.errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)
		assertEquals(issues.toString, 0, issues.size)
	}
	
	@Test def void testSyntaxErrors() {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			import 'http://test' as test
			Root returns test::Foo: name=ID;;
		'''
		val issues = resourceValidator.validate(grammarAsString.errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)
		assertEquals(issues.toString, 1, issues.size)
		assertTrue(issues.toString, issues.head.message.contains("extraneous input ';'"))
	}
	
	@Test def void testRuleLinkingErrors() {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			import 'http://test' as test
			Root returns test::Foo : name=IDS;
		'''
		val issues = resourceValidator.validate(grammarAsString.errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)
		assertEquals(issues.toString, 1, issues.size)
		assertTrue(issues.toString, issues.head.message.contains("IDS"))
	}
	
	@Test def void testGrammarLinkingErrors() {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Trminals
			import 'http://test' as test
			Root returns test::Foo : name='foo';
		'''
		val issues = resourceValidator.validate(grammarAsString.errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)
		assertEquals(issues.toString, 1, issues.size)
		assertTrue(issues.toString, issues.head.message.contains("Trminals"))
	}
	
	def getErrorneousResource(CharSequence seq) {
		return seq.toString.asStream.doGetResource(testModelURI)
	}
}