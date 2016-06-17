/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.parameters

import com.google.inject.Injector
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.tests.AbstractXtextTests
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractParametersParsingTest extends AbstractXtextTests {

	override protected setInjector(Injector injector) {
		super.setInjector(injector)
		injectMembers(this)
	}
	
	override protected shouldTestSerializer(XtextResource resource) {
		// TODO implement serializer support for guard conditions
		false
	}
	
	override ParserRuleParameters getModel(String model) throws Exception {
		return super.getModel(model) as ParserRuleParameters
	}
	
	protected def getModelWithErrors(String model) throws Exception {
		return getModelAndExpect(model, EXPECT_ERRORS) as ParserRuleParameters
	} 
	
	@Test
	def void testScenario1_first() {
		val instance = '#1 first'.model
		assertEquals('first', instance.scenario.first)
	}
	
	@Test
	def void testScenario2_second() {
		val instance = '#2 second'.model
		assertEquals('second', instance.scenario.second)
	}
	
	@Test
	def void testScenario3_keyword() {
		val instance = '#3 keyword'.model
		assertEquals('keyword', instance.scenario.first)
	}
	
	@Test
	def void testScenario3_id() {
		val instance = '#3 id'.model
		assertEquals('id', instance.scenario.first)
	}
	
	@Test
	def void testScenario4_keyword() {
		val instance = '#4 keyword'.modelWithErrors
		assertEquals(null, instance.scenario.first)
		assertEquals(1, instance.eResource.errors.size)
		assertEquals("mismatched input 'keyword' expecting RULE_ID", instance.eResource.errors.head.message)
	}
	
	@Test
	def void testScenario4_id() {
		val instance = '#4 id'.model
		assertEquals('id', instance.scenario.first)
	}
	
	@Test
	def void testScenario5_keyword() {
		val instance = '#5 keyword'.model
		assertEquals('keyword', instance.scenario.first)
	}
	
	@Test
	def void testScenario5_id() {
		val instance = '#5 id'.model
		assertEquals('id', instance.scenario.first)
	}
	
	@Test
	def void testScenario6_keyword() {
		val instance = '#6 keyword'.modelWithErrors
		assertEquals(null, instance.scenario)
		assertEquals("no viable alternative at input '#6'", instance.eResource.errors.head.message)
	}
	
	@Test
	def void testScenario6_id() {
		val instance = '#6 id'.model
		assertEquals('id', instance.scenario.first)
	}

	@Test
	def void testScenario7_keyword() {
		val instance = '#7 keyword'.model
		assertEquals('keyword', instance.scenario.first)
	}
	
	@Test
	def void testScenario7_id() {
		val instance = '#7 id'.model
		assertEquals('id', instance.scenario.first)
	}
	
	@Test
	def void testScenario8_keyword() {
		val instance = '#8 keyword'.model
		assertEquals('keyword', instance.scenario.second)
	}
	
	@Test
	def void testScenario8_id() {
		val instance = '#8 id'.model
		assertEquals('id', instance.scenario.first)
	}
	
	@Test
	def void testScenario9_keyword_keyword() {
		val instance = '#9 keyword keyword'.model
		assertEquals('keyword', instance.scenario.second)
	}
	
	@Test
	def void testScenario9_id_keyword() {
		val instance = '#9 id keyword'.model
		assertEquals('id', instance.scenario.second)
	}
	
	@Test
	def void testScenario9_id() {
		val instance = '#9 id'.model
		assertEquals('id', instance.scenario.first)
	}
	
	@Test
	def void testScenario9_keyword() {
		val instance = '#9 keyword'.model
		assertEquals('keyword', instance.scenario.first)
	}
	
	@Test
	def void testScenario10_keyword_keyword() {
		val instance = '#10 keyword keyword'.model
		assertEquals('keyword', instance.scenario.second)
	}
	
	@Test
	def void testScenario10_id_keyword() {
		val instance = '#10 id keyword'.model
		assertEquals('id', instance.scenario.second)
	}
	
	@Test
	def void testScenario10_id() {
		val instance = '#10 id'.model
		assertEquals('id', instance.scenario.first)
	}
	
	@Test
	def void testScenario10_keyword() {
		val instance = '#10 keyword'.modelWithErrors
		assertEquals('keyword', instance.scenario.second)
		assertEquals("mismatched input '<EOF>' expecting 'keyword'", instance.eResource.errors.head.message)
	}
	
	@Test
	def void testScenario11_keyword_keyword() {
		val instance = '#11 keyword keyword'.model
		assertEquals('keyword', instance.scenario.first)
	}
	
	@Test
	def void testScenario11_id_keyword() {
		val instance = '#11 id keyword'.model
		assertEquals('id', instance.scenario.second)
	}
}