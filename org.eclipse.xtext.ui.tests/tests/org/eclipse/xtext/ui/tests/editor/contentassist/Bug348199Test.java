/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug348199TestLanguageUiInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug348199TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug348199Test extends AbstractContentAssistTest {
	
	@Test public void testEmptyDocument() throws Exception {
		newBuilder().assertText(
				"define");
	}
	
	@Test public void testAfterCurlyBrace_01() throws Exception {
		newBuilder(1).assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterCurlyBrace_02() throws Exception {
		newBuilder(2).assertText("july", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterCurlyBrace_03() throws Exception {
		newBuilder(3).assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterCurlyBrace_04() throws Exception {
		newBuilder(4).assertText("july", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterCurlyBrace_05() throws Exception {
		newBuilder(5).assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterCurlyBrace_06() throws Exception {
		newBuilder(6).assertText("july", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterCurlyBrace_07() throws Exception {
		newBuilder(7).assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterCurlyBrace_08() throws Exception {
		newBuilder(8).assertText("july", "timeperiod_name", "otherelement", "}");
	}
	
	@Test public void testAfterJuly_01() throws Exception {
		newBuilder(1).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterJuly_02() throws Exception {
		newBuilder(2).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterJuly_03() throws Exception {
		newBuilder(3).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterJuly_04() throws Exception {
		newBuilder(4).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterJuly_05() throws Exception {
		newBuilder(5).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterJuly_06() throws Exception {
		newBuilder(6).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterJuly_07() throws Exception {
		newBuilder(7).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
	@Test public void testAfterJuly_08() throws Exception {
		newBuilder(8).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
	}
	
	@Test @Ignore public void testAfterTimePeriod_01() throws Exception {
		newBuilder(1).appendNl("timeperiod_name name").assertText("august", "otherelement", "}");
	}
	@Test @Ignore public void testAfterTimePeriod_02() throws Exception {
		newBuilder(2).appendNl("timeperiod_name name").assertText("august", "}");
	}
	@Test @Ignore public void testAfterTimePeriod_03() throws Exception {
		newBuilder(3).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
	}
	@Test @Ignore public void testAfterTimePeriod_04() throws Exception {
		newBuilder(4).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterTimePeriod_05() throws Exception {
		newBuilder(5).appendNl("timeperiod_name name").assertText("august", "otherelement", "}");
	}
	@Test public void testAfterTimePeriod_06() throws Exception {
		newBuilder(6).appendNl("timeperiod_name name").assertText("august", "}");
	}
	@Test public void testAfterTimePeriod_07() throws Exception {
		newBuilder(7).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterTimePeriod_08() throws Exception {
		newBuilder(8).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
	}
	
	@Test @Ignore public void testAfterOtherElement_01() throws Exception {
		newBuilder(1).appendNl("otherelement alias").assertText("september", "timeperiod_name");
	}
	@Test @Ignore public void testAfterOtherElement_02() throws Exception {
		newBuilder(2).appendNl("otherelement alias").assertText("september", "}");
	}
	@Test @Ignore public void testAfterOtherElement_03() throws Exception {
		newBuilder(3).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
	}
	@Test @Ignore public void testAfterOtherElement_04() throws Exception {
		newBuilder(4).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterOtherElement_05() throws Exception {
		newBuilder(5).appendNl("otherelement alias").assertText("september", "timeperiod_name");
	}
	@Test public void testAfterOtherElement_06() throws Exception {
		newBuilder(6).appendNl("otherelement alias").assertText("september", "}");
	}
	@Test public void testAfterOtherElement_07() throws Exception {
		newBuilder(7).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
	}
	@Test public void testAfterOtherElement_08() throws Exception {
		newBuilder(8).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
	}
	
	public ContentAssistProcessorTestBuilder newBuilder(int scenario) throws Exception {
		return newBuilder().appendNl("define timeperiod " + scenario + "{");
	}

}
