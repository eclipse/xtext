/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug303200TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug303200TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug303200ContentAssistTest extends AbstractContentAssistTest {
	
	@Test public void testEmptyModel() throws Exception {
		newBuilder().assertText(
				"function", // FunctionDefinition
				"Ident", // Attribute
				"[", // Attribute
				"{", // Block
				"Name" // PrimaryExpression
				);
	}
	
	@Test public void testAfterFunction_01() throws Exception {
		newBuilder().append("function f() {}").assertText(
				"function", // FunctionDefinition
				"Ident", // Attribute
				"[", // Attribute
				"{", // Block
				"Name", // PrimaryExpression
				"}" // closing brace
				);
	}
	
	@Test public void testAfterFunction_02() throws Exception {
		newBuilder().appendNl("function f() {}").assertText(
				"function", // FunctionDefinition
				"Ident", // Attribute
				"[", // Attribute
				"{", // Block
				"Name" // PrimaryExpression
				);
	}

}

