/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug348199TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug348199Test extends AbstractContentAssistProcessorTest {

	public ISetup getSetup() {
		return new Bug348199TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug348199TestLanguageRuntimeModule(), new Bug348199TestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}
	
	public void testEmptyDocument() throws Exception {
		newBuilder(getSetup()).assertText(
				"define");
	}
	
	public void testAfterCurlyBrace_01() throws Exception {
		newBuilder(1).assertText("july", "timeperiod_name", "otherelement");
	}
	public void testAfterCurlyBrace_02() throws Exception {
		newBuilder(2).assertText("july", "timeperiod_name", "otherelement");
	}
	public void testAfterCurlyBrace_03() throws Exception {
		newBuilder(3).assertText("july", "timeperiod_name", "otherelement");
	}
//	public void testAfterCurlyBrace_04() throws Exception {
//		newBuilder(4).assertText("july", "timeperiod_name", "otherelement", "}");
//	}
	public void testAfterCurlyBrace_05() throws Exception {
		newBuilder(5).assertText("july", "timeperiod_name", "otherelement");
	}
	public void testAfterCurlyBrace_06() throws Exception {
		newBuilder(6).assertText("july", "timeperiod_name", "otherelement");
	}
	public void testAfterCurlyBrace_07() throws Exception {
		newBuilder(7).assertText("july", "timeperiod_name", "otherelement");
	}
	public void testAfterCurlyBrace_08() throws Exception {
		newBuilder(8).assertText("july", "timeperiod_name", "otherelement", "}");
	}
	
	public void testAfterJuly_01() throws Exception {
		newBuilder(1).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
//	public void testAfterJuly_02() throws Exception {
//		newBuilder(2).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
//	}
	public void testAfterJuly_03() throws Exception {
		newBuilder(3).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
//	public void testAfterJuly_04() throws Exception {
//		newBuilder(4).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
//	}
	public void testAfterJuly_05() throws Exception {
		newBuilder(5).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
//	public void testAfterJuly_06() throws Exception {
//		newBuilder(6).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
//	}
	public void testAfterJuly_07() throws Exception {
		newBuilder(7).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement");
	}
	public void testAfterJuly_08() throws Exception {
		newBuilder(8).appendNl("july 15").assertText("july", "timeperiod_name", "otherelement", "}");
	}
	
//	public void testAfterTimePeriod_01() throws Exception {
//		newBuilder(1).appendNl("timeperiod_name name").assertText("august", "otherelement", "}");
//	}
//	public void testAfterTimePeriod_02() throws Exception {
//		newBuilder(2).appendNl("timeperiod_name name").assertText("august", "}");
//	}
//	public void testAfterTimePeriod_03() throws Exception {
//		newBuilder(3).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
//	}
//	public void testAfterTimePeriod_04() throws Exception {
//		newBuilder(4).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
//	}
	public void testAfterTimePeriod_05() throws Exception {
		newBuilder(5).appendNl("timeperiod_name name").assertText("august", "otherelement", "}");
	}
	public void testAfterTimePeriod_06() throws Exception {
		newBuilder(6).appendNl("timeperiod_name name").assertText("august", "}");
	}
	public void testAfterTimePeriod_07() throws Exception {
		newBuilder(7).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
	}
	public void testAfterTimePeriod_08() throws Exception {
		newBuilder(8).appendNl("timeperiod_name name").assertText("august", "timeperiod_name", "otherelement", "}");
	}
	
//	public void testAfterOtherElement_01() throws Exception {
//		newBuilder(1).appendNl("otherelement alias").assertText("september", "timeperiod_name");
//	}
//	public void testAfterOtherElement_02() throws Exception {
//		newBuilder(2).appendNl("otherelement alias").assertText("september", "}");
//	}
//	public void testAfterOtherElement_03() throws Exception {
//		newBuilder(3).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
//	}
//	public void testAfterOtherElement_04() throws Exception {
//		newBuilder(4).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
//	}
	public void testAfterOtherElement_05() throws Exception {
		newBuilder(5).appendNl("otherelement alias").assertText("september", "timeperiod_name");
	}
	public void testAfterOtherElement_06() throws Exception {
		newBuilder(6).appendNl("otherelement alias").assertText("september", "}");
	}
	public void testAfterOtherElement_07() throws Exception {
		newBuilder(7).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
	}
	public void testAfterOtherElement_08() throws Exception {
		newBuilder(8).appendNl("otherelement alias").assertText("september", "timeperiod_name", "otherelement", "}");
	}
	
	public ContentAssistProcessorTestBuilder newBuilder(int scenario) throws Exception {
		return newBuilder(getSetup()).appendNl("define timeperiod " + scenario + "{");
	}
	
}
