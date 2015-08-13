/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.parameters

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ParametersParsingTest extends AbstractParametersParsingTest {
	override void setUp() throws Exception {
		super.setUp();
		with(new ParametersTestLanguageStandaloneSetup);
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TwoParametersParsingTest extends AbstractParametersParsingTest {
	override void setUp() throws Exception {
		super.setUp();
		with(new TwoParametersTestLanguageStandaloneSetup);
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ParametersParsingTestEx extends AbstractParametersParsingTest {
	override void setUp() throws Exception {
		super.setUp();
		with(new ParametersTestLanguageExStandaloneSetup);
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class NoParametersParsingTest extends AbstractParametersParsingTest {
	override void setUp() throws Exception {
		super.setUp();
		with(new NoParametersTestLanguageStandaloneSetup);
	}
	
	@Test
	override testScenario4_keyword() {
		val instance = '#4 keyword'.modelWithErrors
		assertEquals(null, instance.scenario.first)
		assertEquals(1, instance.eResource.errors.size)
		assertEquals("mismatched input 'keyword' expecting RULE_ID", instance.eResource.errors.head.message)
	}
	
	@Test
	override testScenario10_keyword() {
		val instance = '#10 keyword'.modelWithErrors
		assertEquals('keyword', instance.scenario.second)
		assertEquals("mismatched input '<EOF>' expecting 'keyword'", instance.eResource.errors.head.message)
	}
	
}