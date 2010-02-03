/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.UIPluginModule;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistContextTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.ContentAssistContextTestLanguageUiModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistContextTest extends AbstractContentAssistProcessorTest {

	public ISetup getContentAssistContextTestLanguageSetup() {
		return new ContentAssistContextTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ContentAssistContextTestLanguageUiModule(), new UIPluginModule(
						Activator.getInstance()));
			}
		};
	}

	public void testBug276742_01() throws Exception {
		newBuilder(getContentAssistContextTestLanguageSetup()).assertText("A1", "B1");
	}

	public void testBug276742_02() throws Exception {
		newBuilder(getContentAssistContextTestLanguageSetup()).append("A1").assertText("A1");
	}

	public void testBug276742_03() throws Exception {
		newBuilder(getContentAssistContextTestLanguageSetup()).append("A1 ").assertText("A1", "A2", "Name");
	}

	public void testBug276742_04() throws Exception {
		newBuilder(getContentAssistContextTestLanguageSetup()).append("A").assertText("A1");
	}

	public void testBug276742_05() throws Exception {
		newBuilder(getContentAssistContextTestLanguageSetup()).append("A1 A1").assertText("A1");
	}

	public void testBug276742_06() throws Exception {
		newBuilder(getContentAssistContextTestLanguageSetup()).append("A1 A").assertText(/* "A", */"A1", "A2");
	}

	public void testBug276742_07() throws Exception {
		newBuilder(getContentAssistContextTestLanguageSetup()).append("A1 A A2").assertText("A2");
	}
}
