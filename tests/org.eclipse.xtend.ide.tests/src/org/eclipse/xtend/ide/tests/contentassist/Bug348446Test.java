/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Ignore
public class Bug348446Test extends AbstractXtendContentAssistBugTest {

	@Test public void testVar() throws Exception {
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().va").assertText("variable");
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().^va").assertText();
	}
	
	@Test public void testGetWhile() throws Exception {
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().wh").assertText("whileYouCan");
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().getWh").assertText("whileYouCan");
		newBuilder().append("new org.eclipse.xtend.ide.tests.data.bug348446.TestClass().^wh").assertText();
	}
	
	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder result = super.newBuilder();
		return result.appendNl("class Foo { def Object foo() {");
	}
	
}
