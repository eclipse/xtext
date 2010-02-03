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
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug288734TestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug288734TestLanguageUiModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug288734Test extends AbstractContentAssistProcessorTest {

	public ISetup getBug288734TestLanguageSetup() {
		return new Bug288734TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new Bug288734TestLanguageUiModule(), new UIPluginModule(Activator
						.getInstance()));
			}
		};
	}

	public void testBug288734_01() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).assertText("@desc", "constant");
	}

	public void testBug288734_02() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("constant").assertText("constant");
	}

	public void testBug288734_03() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("constant ").assertText("string", "boolean", "integer");
	}

	public void testBug288734_04() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("constant string").assertText("string");
	}

	public void testBug288734_05() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("constant boolean").assertText("boolean");
	}

	public void testBug288734_06() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("constant string ").assertText("Name");
	}

	public void testBug288734_07() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("constant boolean ").assertText("Name");
	}

	public void testBug288734_08() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc").assertText("@desc", "\"Description\"");
	}

	public void testBug288734_09() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc ").assertText("\"Description\"");
	}

	public void testBug288734_10() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc 'Name' ").assertText("@desc", "constant");
	}

	public void testBug288734_11() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc 'Name' @desc").assertText("@desc", "\"Description\"");
	}

	public void testBug288734_12() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc 'Name' @desc ").assertText("\"Description\"");
	}

	public void testBug288734_13() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc 'Name' constant").assertText("constant");
	}

	public void testBug288734_14() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc 'Name' constant ").assertText("string", "integer",
				"boolean");
	}

	public void testBug288734_15() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc 'Name' @desc 'Name' constant").assertText("constant");
	}

	public void testBug288734_16() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@desc 'Name' @desc 'Name' constant ").assertText("string",
				"integer", "boolean");
	}
	
	public void testBug288734_17() throws Exception {
		newBuilder(getBug288734TestLanguageSetup()).append("@des").assertText("@desc");
	}

}
