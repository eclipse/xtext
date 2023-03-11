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
public class Bug348446Test extends AbstractXtendContentAssistBugTest {

	@Test public void testVar() throws Exception {
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().va").assertText("variable", "^var");
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().^va").assertText("^var");
	}
	
	@Test public void testGetWhile() throws Exception {
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().wh").assertText("whileYouCan", "^while");
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().getWh").assertText("whileYouCan", "^while");
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().^wh").assertText("^while");
	}
	
	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder result = super.newBuilder();
		return result.appendNl("class Foo { def Object foo() {");
	}
	
}
