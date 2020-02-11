/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug288734TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug288734TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug288734Test extends AbstractContentAssistTest {

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
