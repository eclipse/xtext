/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug288734TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug288734Test extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new Bug288734TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug288734TestLanguageRuntimeModule(), new Bug288734TestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}

	@Test public void testBug288734_01() throws Exception {
		newBuilder().assertText("@desc", "constant");
	}

	@Test public void testBug288734_02() throws Exception {
		newBuilder().append("constant").assertText("constant");
	}

	@Test public void testBug288734_03() throws Exception {
		newBuilder().append("constant ").assertText("string", "boolean", "integer");
	}

	@Test public void testBug288734_04() throws Exception {
		newBuilder().append("constant string").assertText("string");
	}

	@Test public void testBug288734_05() throws Exception {
		newBuilder().append("constant boolean").assertText("boolean");
	}

	@Test public void testBug288734_06() throws Exception {
		newBuilder().append("constant string ").assertText("Name");
	}

	@Test public void testBug288734_07() throws Exception {
		newBuilder().append("constant boolean ").assertText("Name");
	}

	@Test public void testBug288734_08() throws Exception {
		newBuilder().append("@desc").assertText("@desc", "\"Description\"");
	}

	@Test public void testBug288734_09() throws Exception {
		newBuilder().append("@desc ").assertText("\"Description\"");
	}

	@Test public void testBug288734_10() throws Exception {
		newBuilder().append("@desc 'Name' ").assertText("@desc", "constant");
	}

	@Test public void testBug288734_11() throws Exception {
		newBuilder().append("@desc 'Name' @desc").assertText("@desc", "\"Description\"");
	}

	@Test public void testBug288734_12() throws Exception {
		newBuilder().append("@desc 'Name' @desc ").assertText("\"Description\"");
	}

	@Test public void testBug288734_13() throws Exception {
		newBuilder().append("@desc 'Name' constant").assertText("constant");
	}

	@Test public void testBug288734_14() throws Exception {
		newBuilder().append("@desc 'Name' constant ").assertText("string", "integer",
				"boolean");
	}

	@Test public void testBug288734_15() throws Exception {
		newBuilder().append("@desc 'Name' @desc 'Name' constant").assertText("constant");
	}

	@Test public void testBug288734_16() throws Exception {
		newBuilder().append("@desc 'Name' @desc 'Name' constant ").assertText("string",
				"integer", "boolean");
	}
	
	@Test public void testBug288734_17() throws Exception {
		newBuilder().append("@des").assertText("@desc");
	}

}
