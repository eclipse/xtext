/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.List;

import org.eclipse.xtext.xbase.ui.testing.AbstractXbaseContentAssistTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistCatchTest extends ContentAssistTest {
	@Override
	protected String getPrefix() {
		return "try { var x = 0 } catch(Exception ex)";
	}

	@Override
	protected String[] getKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.getKeywordsAndStatics());
		result.add("ex");
		return result.toArray(new String[result.size()]);
	}

	@AfterClass
	public static void resetCastInstanceOf() {
		AbstractXbaseContentAssistTest.CAST_INSTANCEOF = new String[] { "as", "instanceof" };
	}

	@BeforeClass
	public static void addCatchAndFinallyToCastInstanceOf() {
		AbstractXbaseContentAssistTest.CAST_INSTANCEOF = new String[] { "as", "catch", "finally", "instanceof" };
	}

	@Override
	public void testOnStringLiteral_33() throws Exception {
		newBuilder().append("(''.toString )").assertTextAtCursorPosition(")",
				expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" }));
	}

	@Override
	public void testAfterBinaryOperation_06() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", 1,
				expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" }));
	}

	@Override
	public void testAfterBinaryOperation_07() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))",
				expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" }));
	}

	@Override
	public void testOnVoidMethod_01() throws Exception {
		newBuilder().append("(null as java.util.List).clear ").assertText("catch", "finally");
	}
}
