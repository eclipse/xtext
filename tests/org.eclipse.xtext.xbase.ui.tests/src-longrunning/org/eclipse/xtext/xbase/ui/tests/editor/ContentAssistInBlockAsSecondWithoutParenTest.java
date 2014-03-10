/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistInBlockAsSecondWithoutParenTest extends ContentAssistInBlockTest {
	
	@Override
	protected String getPrefix() {
		return "{ doesNotExist";
	}
	
	@Override
	protected String getSuffix() {
		return "\n}";
	}
	
	@Override
	@Test public void testEmptyInput() throws Exception {
		newBuilder().assertText(expect(getKeywordsAndStatics(), VARIABLE_DECL, CAST_INSTANCEOF));
	}
	
	@Override
	@Test public void testOnStringLiteral_30() throws Exception {
		newBuilder().append("('')").assertText(expect(getKeywordsAndStatics(), VARIABLE_DECL, CAST_INSTANCEOF));
	}
	
	@Override
	@Test public void testOnStringLiteral_32() throws Exception {
		newBuilder().append("(''.toString)").assertText(expect(getKeywordsAndStatics(), VARIABLE_DECL, CAST_INSTANCEOF));
	}
	
	@Override
	@Test public void testAfterBinaryOperation_03() throws Exception {
		newBuilder().append("(''+'')").assertText(expect(getKeywordsAndStatics(), VARIABLE_DECL, CAST_INSTANCEOF));
	}
	
	@Override
	@Test public void testAfterBinaryOperation_05() throws Exception {
		newBuilder().append("((''+''))").assertText(expect(getKeywordsAndStatics(), VARIABLE_DECL, CAST_INSTANCEOF));
	}

	@Override
	@Test public void testOnStringLiteral_31() throws Exception {
		newBuilder().append(";('').").assertText(getStringFeatures());
	}
	
	@Test public void testOnStringLiteral_39() throws Exception {
		newBuilder().append("('').").assertText();
	}
	
	@Override
	@Test public void testAfterBinaryOperation_04() throws Exception {
		newBuilder().append(";(''+'').").assertText(getStringFeatures());
	}
	
	@Test public void testAfterBinaryOperation_12() throws Exception {
		newBuilder().append("(''+'').").assertText();
	}
	
}
