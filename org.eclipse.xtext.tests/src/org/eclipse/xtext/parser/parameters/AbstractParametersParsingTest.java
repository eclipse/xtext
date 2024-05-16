/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.parameters;

import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParametersParsingTest extends AbstractXtextTests {
	@Override
	protected void setInjector(Injector injector) {
		super.setInjector(injector);
		injectMembers(this);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	@Override
	public ParserRuleParameters getModel(String model) throws Exception {
		return (ParserRuleParameters) super.getModel(model);
	}

	protected ParserRuleParameters getModelWithErrors(String model) throws Exception {
		return (ParserRuleParameters) getModelAndExpect(model, AbstractXtextTests.EXPECT_ERRORS);
	}

	@Test
	public void testScenario1_first() throws Exception {
		ParserRuleParameters instance = getModel("#1 first");
		Assert.assertEquals("first", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario2_second() throws Exception {
		ParserRuleParameters instance = getModel("#2 second");
		Assert.assertEquals("second", instance.getScenario().getSecond());
	}

	@Test
	public void testScenario3_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#3 keyword");
		Assert.assertEquals("keyword", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario3_id() throws Exception {
		ParserRuleParameters instance = getModel("#3 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario4_keyword() throws Exception {
		ParserRuleParameters instance = getModelWithErrors("#4 keyword");
		Assert.assertEquals(null, instance.getScenario().getFirst());
		Assert.assertEquals(1, instance.eResource().getErrors().size());
		Assert.assertEquals("mismatched input 'keyword' expecting RULE_ID",
				Iterables.getFirst(instance.eResource().getErrors(), null).getMessage());
	}

	@Test
	public void testScenario4_id() throws Exception {
		ParserRuleParameters instance = getModel("#4 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario5_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#5 keyword");
		Assert.assertEquals("keyword", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario5_id() throws Exception {
		ParserRuleParameters instance = getModel("#5 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario6_keyword() throws Exception {
		ParserRuleParameters instance = getModelWithErrors("#6 keyword");
		Assert.assertEquals(null, instance.getScenario());
		Assert.assertEquals("no viable alternative at input '#6'",
				Iterables.getFirst(instance.eResource().getErrors(), null).getMessage());
	}

	@Test
	public void testScenario6_id() throws Exception {
		ParserRuleParameters instance = getModel("#6 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario7_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#7 keyword");
		Assert.assertEquals("keyword", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario7_id() throws Exception {
		ParserRuleParameters instance = getModel("#7 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario8_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#8 keyword");
		Assert.assertEquals("keyword", instance.getScenario().getSecond());
	}

	@Test
	public void testScenario8_id() throws Exception {
		ParserRuleParameters instance = getModel("#8 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario9_keyword_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#9 keyword keyword");
		Assert.assertEquals("keyword", instance.getScenario().getSecond());
	}

	@Test
	public void testScenario9_id_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#9 id keyword");
		Assert.assertEquals("id", instance.getScenario().getSecond());
	}

	@Test
	public void testScenario9_id() throws Exception {
		ParserRuleParameters instance = getModel("#9 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario9_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#9 keyword");
		Assert.assertEquals("keyword", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario10_keyword_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#10 keyword keyword");
		Assert.assertEquals("keyword", instance.getScenario().getSecond());
	}

	@Test
	public void testScenario10_id_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#10 id keyword");
		Assert.assertEquals("id", instance.getScenario().getSecond());
	}

	@Test
	public void testScenario10_id() throws Exception {
		ParserRuleParameters instance = getModel("#10 id");
		Assert.assertEquals("id", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario10_keyword() throws Exception {
		ParserRuleParameters instance = getModelWithErrors("#10 keyword");
		Assert.assertEquals("keyword", instance.getScenario().getSecond());
		Assert.assertEquals("mismatched input '<EOF>' expecting 'keyword'",
				Iterables.getFirst(instance.eResource().getErrors(), null).getMessage());
	}

	@Test
	public void testScenario11_keyword_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#11 keyword keyword");
		Assert.assertEquals("keyword", instance.getScenario().getFirst());
	}

	@Test
	public void testScenario11_id_keyword() throws Exception {
		ParserRuleParameters instance = getModel("#11 id keyword");
		Assert.assertEquals("id", instance.getScenario().getSecond());
	}
}
