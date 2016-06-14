/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
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
