/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import junit.framework.TestCase;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.generator.parser.PackratParserGenUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PackratParserGenUtilTest extends TestCase {

	private AbstractRule rule;

	@Override
	protected void setUp() {
		rule = XtextFactory.eINSTANCE.createParserRule();
	}

	public void testGetConsumerClassName_Test() {
		rule.setName("Test");
		assertEquals("TestConsumer", PackratParserGenUtil.getConsumerClassName(rule));
	}

	public void testGetConsumerClassName_test() {
		rule.setName("test");
		assertEquals("TestConsumer", PackratParserGenUtil.getConsumerClassName(rule));
	}

	public void testGetConsumerClassName__() {
		rule.setName("_");
		assertEquals("_Consumer", PackratParserGenUtil.getConsumerClassName(rule));
	}

	public void testGetConsumerClassName_Null() {
		rule.setName(null);
		assertEquals("Consumer", PackratParserGenUtil.getConsumerClassName(rule));
	}

	public void testGetConsumerClassName_Unnamed() {
		rule.setName("");
		assertEquals("Consumer", PackratParserGenUtil.getConsumerClassName(rule));
	}

	public void testGetConsumerFieldName_ML_COMMENT() {
		rule.setName("ML_COMMENT");
		assertEquals("mlCommentConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_ML__COMMENT() {
		rule.setName("ML__COMMENT");
		assertEquals("ml_commentConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_ml_comment() {
		rule.setName("ml_comment");
		assertEquals("mlCommentConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName__() {
		rule.setName("_");
		assertEquals("_Consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName___() {
		rule.setName("__");
		assertEquals("__Consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName____() {
		rule.setName("___");
		assertEquals("___Consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName___12() {
		rule.setName("__12");
		assertEquals("__12Consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName__12() {
		rule.setName("_12");
		assertEquals("_12Consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_STRING() {
		rule.setName("STRING");
		assertEquals("stringConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_ID() {
		rule.setName("ID");
		assertEquals("idConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_Grammar() {
		rule.setName("Grammar");
		assertEquals("grammarConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_grammar() {
		rule.setName("grammar");
		assertEquals("grammarConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_AbstractRule() {
		rule.setName("AbstractRule");
		assertEquals("abstractRuleConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_AbstractID() {
		rule.setName("AbstractID");
		assertEquals("abstractIdConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_AbstractIDElement() {
		rule.setName("AbstractIDElement");
		assertEquals("abstractIdElementConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_IElement() {
		rule.setName("IElement");
		assertEquals("iElementConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_IDElement() {
		rule.setName("IDElement");
		assertEquals("idElementConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_a1() {
		rule.setName("a1");
		assertEquals("a1Consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234() {
		rule.setName("A1234");
		assertEquals("a1234Consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_Null() {
		rule.setName(null);
		assertEquals("consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_Unnamed() {
		rule.setName("");
		assertEquals("consumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234TEST() {
		rule.setName("A1234TEST");
		assertEquals("a1234TestConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234Test() {
		rule.setName("A1234Test");
		assertEquals("a1234TestConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234test() {
		rule.setName("A1234test");
		assertEquals("a1234TestConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234T() {
		rule.setName("A1234T");
		assertEquals("a1234TConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234IElement() {
		rule.setName("A1234IElement");
		assertEquals("a1234IElementConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234t() {
		rule.setName("A1234t");
		assertEquals("a1234TConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

	public void testGetConsumerFieldName_A1234iElement() {
		rule.setName("A1234iElement");
		assertEquals("a1234IElementConsumer", PackratParserGenUtil.getConsumerFieldName(rule));
	}

}
