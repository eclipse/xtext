/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.contentassist;

import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class Bug348446Test extends AbstractXtendContentAssistBugTest {

	@Test public void testGetPackage() throws Exception {
		newBuilder().append("typeof(String).pack").assertText();
		newBuilder().append("typeof(String).^pack").assertText();
		newBuilder().append("typeof(String).getpack").assertText("getPackage()");
	}
	
	@Test public void testGetClass() throws Exception {
		newBuilder().append("typeof(String).clas").assertText("classLoader", "classes");
		newBuilder().append("typeof(String).^clas").assertText();
		newBuilder().append("typeof(String).getclas").assertText("classLoader", "classes");
	}
	
	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder result = super.newBuilder();
		return result.appendNl("class Foo { def Object foo() {");
	}
	
}
