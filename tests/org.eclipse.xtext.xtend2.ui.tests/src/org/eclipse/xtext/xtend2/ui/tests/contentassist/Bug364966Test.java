/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.contentassist;

import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;

import junit.framework.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug364966Test extends AbstractXtendContentAssistBugTest {

	public void testFieldInitializer_01() throws Exception {
		newBuilder().append("String s = newArrayLis").assertText("newArrayList()");
	}
	
	public void testFieldInitializer_02() throws Exception {
		newBuilder().append("static String s = newArrayLis").assertText("newArrayList()");
	}
	
	public void testFieldInitializer_03() throws Exception {
		newBuilder().append("String doNotPropose static String something static String anotherThing = somethin").assertText("something");
	}
	
	public void testFieldInitializer_04() throws Exception {
		newBuilder().append("String something String anotherThing = somethin").assertText("something");
	}
	
	public void testFieldInitializer_05() throws Exception {
		newBuilder().append("static String something String anotherThing = somethin").assertText("something");
	}
	
	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder result = super.newBuilder();
		return result.appendNl("class Foo { ");
	}
	
	public static Test suite() {
		return createSuite(Bug364966Test.class);
	}
}
