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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug288760TestLanguageUiInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug288760TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug288760Test extends AbstractContentAssistTest {

	@Ignore
	@Test public void testBug288760_01() throws Exception {
		newBuilder().append(
				"<workflow>\n" + 
				"    <first class=\"java.lang.StringBuffer\" />\n" + 
				"    <second class=\"java.lang.StringBuffer\" />\n" + 
				"    <third class=\"org.eclipse.xtend.typesystem.emf.XmiReader\" />\n" + 
				"</workflow>").assertTextAtCursorPosition("<first", "<workflow");
	}
	
	@Ignore
	@Test public void testBug288760_02() throws Exception {
		newBuilder().append(
				"<workflow>\n" + 
				"    <first class=\"java.lang.StringBuffer\" />\n" + 
				"    <second class=\"java.lang.StringBuffer\" />\n" + 
				"    <third class=\"org.eclipse.xtend.typesystem.emf.XmiReader\" />\n" + 
				"</workflow>").assertTextAtCursorPosition("<second", "<workflow");
	}
	
	@Ignore
	@Test public void testBug288760_03() throws Exception {
		newBuilder().append(
				"<workflow>\n" + 
				"    <first class=\"java.lang.StringBuffer\" />\n" + 
				"    <second class=\"java.lang.StringBuffer\" />\n" + 
				"    <third class=\"org.eclipse.xtend.typesystem.emf.XmiReader\" />\n" + 
				"</workflow>").assertTextAtCursorPosition("<third", "<workflow");
	}

}