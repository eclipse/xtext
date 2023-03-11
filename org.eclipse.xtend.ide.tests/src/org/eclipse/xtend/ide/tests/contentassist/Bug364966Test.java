/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug364966Test extends AbstractXtendContentAssistBugTest {

	@Test public void testFieldInitializer_01() throws Exception {
		newBuilder().append("String s = newArrayLis").assertText("newArrayList","newArrayList()");
	}
	
	@Test public void testFieldInitializer_02() throws Exception {
		newBuilder().append("static String s = newArrayLis").assertText("newArrayList","newArrayList()");
	}
	
	@Test public void testFieldInitializer_03() throws Exception {
		newBuilder().append("String doNotPropose static String something static String anotherThing = somethin").assertText("something");
	}
	
	@Test public void testFieldInitializer_04() throws Exception {
		newBuilder().append("String something String anotherThing = somethin").assertText("something");
	}
	
	@Test public void testFieldInitializer_05() throws Exception {
		newBuilder().append("static String something String anotherThing = somethin").assertText("something");
	}
	
	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder result = super.newBuilder();
		return result.appendNl("class Foo { ");
	}
	
}
